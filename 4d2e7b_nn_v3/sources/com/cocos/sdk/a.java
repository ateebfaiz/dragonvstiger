package com.cocos.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class a implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpsURLConnection f19407a;

    public /* synthetic */ a(HttpsURLConnection httpsURLConnection) {
        this.f19407a = httpsURLConnection;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return AliProxyController.lambda$createProxyConnection$0(this.f19407a, str, sSLSession);
    }
}
