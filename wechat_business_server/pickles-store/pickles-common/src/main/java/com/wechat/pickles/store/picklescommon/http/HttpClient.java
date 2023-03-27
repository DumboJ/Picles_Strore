package com.wechat.pickles.store.picklescommon.http;


import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 基于OKHttp3 请求封装
 */
public class HttpClient {
    private static OkHttpClient client;
    static{
        Builder b = new Builder();
        b.readTimeout(120, TimeUnit.SECONDS);
        b.writeTimeout(120, TimeUnit.SECONDS);
        client = b.build();
    }
    public static String getString(String url) {
        final HttpResult httpResult;
        httpResult = get(url);
        return new String(httpResult.content.get());
    }

    private static HttpResult get(String url) {
        return get(url, null, null);
    }

    private static HttpResult get(String url, List<String> headers, Map<String, String> paramValues) {
        url = genUrl(url, paramValues);
        return null;
    }

    private static String genUrl(String url, Map<String, String> paramValues) {
        return null;
    }

    /**
     * 响应体信息封装
     * */
    public static class HttpResult {
        final public int code;
        final public Optional<byte[]> content;
        final public Map<String, List<String>> headers;

        public HttpResult(int code, byte[] content, Map<String, List<String>> headers) {
            this.code = code;
            if (content == null) {
                this.content = Optional.empty();
            } else {
                this.content = Optional.of(content);
            }
            this.headers = headers;
        }
        /**
         * 结构拼接自定义相应体信息 e.g : "HttpResult{code=200,content='above'}"
         * */
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("HttpResult{")
                                    .append("code=")
                                    .append(code)
                                    .append(",content='");
            sb.append(content.map(bs -> {
                try {
                    return StringUtils.toString(bs, "UTF_8");
                } catch (UnsupportedEncodingException e) {
                    return "";
                }
            }));
            sb.append("'}");
            return sb.toString();
        }
    }
}
