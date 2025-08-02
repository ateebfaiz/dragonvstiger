package com.alibaba.pdns.net;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpsHostnameVerifier implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    private String f18070a;

    public HttpsHostnameVerifier(String str) {
        this.f18070a = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f18070a, sSLSession);
    }
}
