package com.alibaba.pdns.net;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HttpsNotCheckVerifier implements HostnameVerifier {
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
