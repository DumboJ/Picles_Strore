package com.wechat.pickles.store.picklescommon.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.Map;


/**
 * Http请求封装
 * */
public class HttpHelper {
    public static String getPostResult(String url, Map param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;

        try {
            httpPost = new HttpPost(url);

            //set RequestConfig (multi timeout)
            RequestConfig requestConfig = RequestConfig.custom().
                    setSocketTimeout(50 * 1000).
                    setConnectTimeout(5 * 1000).
                    setConnectionRequestTimeout(50 * 1000).build();
            httpPost.setConfig(requestConfig);

            httpPost.addHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());

            //build entity
            String jsonParam = JSON.toJSONString(param);
            StringEntity entity = new StringEntity(jsonParam);
            entity.setContentType("text/json");
            entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString()));
            httpPost.setEntity(entity);

            //send request
            response = httpClient.execute(httpPost);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode <= 300) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new ClientProtocolException("Unexpected response status:" + statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                //nothing ignore
            }
        }
    }
}
