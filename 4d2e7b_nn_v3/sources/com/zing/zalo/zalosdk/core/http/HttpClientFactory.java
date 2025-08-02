package com.zing.zalo.zalosdk.core.http;

import com.zing.zalo.zalosdk.core.http.HttpClientRequest;

public class HttpClientFactory {
    public HttpClientRequest newRequest(HttpClientRequest.Type type, String str) {
        return new HttpClientRequest(type, str);
    }
}
