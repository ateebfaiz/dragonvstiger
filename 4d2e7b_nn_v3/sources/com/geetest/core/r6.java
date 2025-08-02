package com.geetest.core;

import android.text.TextUtils;
import com.geetest.core.q6;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class r6 implements HostnameVerifier {
    public boolean verify(String str, SSLSession sSLSession) {
        boolean z10;
        boolean z11;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        if (defaultHostnameVerifier != null) {
            z10 = defaultHostnameVerifier.verify(str, sSLSession);
        } else {
            z10 = true;
        }
        q6 q6Var = q6.a.f6148a;
        q6Var.getClass();
        if (TextUtils.isEmpty(str)) {
            z11 = false;
        } else {
            z11 = q6Var.f6147a.contains(str);
        }
        if (!z11 || !z10) {
            return false;
        }
        return true;
    }
}
