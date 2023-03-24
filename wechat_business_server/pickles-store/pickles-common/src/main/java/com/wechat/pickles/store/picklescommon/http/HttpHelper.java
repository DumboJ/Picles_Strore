package com.wechat.pickles.store.picklescommon.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


/**
 * Http请求封装
 * */
public class HttpHelper {

    private static final int OUT_TIME = 50 * 1000;
    /**
     * 发送Post请求  解析响应
     *
     * @param url
     * @param param
     * */
    public static String getPostResult(String url, Map param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;

        try {
            httpPost = new HttpPost(url);

            //set RequestConfig (multi timeout)
            RequestConfig requestConfig = RequestConfig.custom().
                                            setSocketTimeout(OUT_TIME).
                                            setConnectTimeout(OUT_TIME).
                                            setConnectionRequestTimeout(OUT_TIME).build();
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
    /**
     * 发送Get请求  解析响应
     * */
    public static String getResult(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        HttpGet httpGet = null;

        //build request config
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                                            .setSocketTimeout(OUT_TIME)
                                            .setConnectTimeout(OUT_TIME)
                                            .setConnectionRequestTimeout(OUT_TIME).build();
            httpGet.setConfig(requestConfig);

            httpResponse = httpClient.execute(httpGet);

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode <= 300) {
                //success
                HttpEntity entity = httpResponse.getEntity();
                InputStream content = entity.getContent();

                //read content
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = content.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                EntityUtils.consume(entity);
                return new String(out.toByteArray(),"UTF-8");

            } else {
                //failure
                throw new ClientProtocolException("Unexpected response statue: " + statusCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                httpResponse.close();
                httpClient.close();
            } catch (IOException e) {
                //nothing ignore
            }

        }
    }
}
