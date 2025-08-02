package com.cocos.sdk;

import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.s.e.c;
import com.cocos.lib.CocosDownloader;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.cocos2dx.okhttp3.Dispatcher;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Protocol;
import org.json.JSONArray;

public class AliProxyController {
    private static final String TAG = "AliProxyController";
    private static final AliProxyController instance = new AliProxyController();
    private boolean useDnsSdk = false;

    private AliProxyController() {
    }

    public static AliProxyController getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createProxyConnection$0(HttpsURLConnection httpsURLConnection, String str, SSLSession sSLSession) {
        String requestProperty = httpsURLConnection.getRequestProperty("Host");
        if (requestProperty == null) {
            requestProperty = httpsURLConnection.getURL().getHost();
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046 A[Catch:{ Exception -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection createProxyConnection(java.net.URL r5) {
        /*
            r4 = this;
            boolean r0 = r4.useDnsSdk
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = r5.getHost()     // Catch:{ Exception -> 0x0027 }
            boolean r1 = r4.isValidIPv4(r0)     // Catch:{ Exception -> 0x0027 }
            if (r1 != 0) goto L_0x008c
            com.alibaba.pdns.DNSResolver r1 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0027 }
            r2 = 1
            java.lang.String[] r1 = r1.getIpv4ByHostFromCache(r0, r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "AliProxyController"
            if (r1 == 0) goto L_0x0029
            int r3 = r1.length     // Catch:{ Exception -> 0x0027 }
            if (r3 <= 0) goto L_0x0029
            java.lang.String r3 = "createHttpURLConnection, usecache"
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x0027 }
            r3 = 0
            r1 = r1[r3]     // Catch:{ Exception -> 0x0027 }
            goto L_0x003a
        L_0x0027:
            r5 = move-exception
            goto L_0x0089
        L_0x0029:
            java.lang.String r1 = "createHttpURLConnection, nocache"
            android.util.Log.d(r2, r1)     // Catch:{ Exception -> 0x0027 }
            com.alibaba.pdns.DNSResolver r1 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r5.getHost()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r1 = r1.getIPV4ByHost(r3)     // Catch:{ Exception -> 0x0027 }
        L_0x003a:
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x008c
            boolean r3 = r1.isEmpty()     // Catch:{ Exception -> 0x0027 }
            if (r3 != 0) goto L_0x008c
            java.lang.String r5 = r5.replaceFirst(r0, r1)     // Catch:{ Exception -> 0x0027 }
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0027 }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x0027 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0027 }
            java.lang.String r1 = "Host"
            r5.setRequestProperty(r1, r0)     // Catch:{ Exception -> 0x0027 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0027 }
            r1.<init>()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = "createHttpURLConnection, newlinkhost: "
            r1.append(r3)     // Catch:{ Exception -> 0x0027 }
            r1.append(r0)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0027 }
            android.util.Log.d(r2, r0)     // Catch:{ Exception -> 0x0027 }
            boolean r0 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0027 }
            if (r0 == 0) goto L_0x0088
            r0 = r5
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0027 }
            com.cocos.sdk.TlsSniSocketFactory r1 = new com.cocos.sdk.TlsSniSocketFactory     // Catch:{ Exception -> 0x0027 }
            r2 = r5
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0027 }
            r0.setSSLSocketFactory(r1)     // Catch:{ Exception -> 0x0027 }
            com.cocos.sdk.a r1 = new com.cocos.sdk.a     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0027 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x0027 }
        L_0x0088:
            return r5
        L_0x0089:
            r5.printStackTrace()
        L_0x008c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cocos.sdk.AliProxyController.createProxyConnection(java.net.URL):java.net.HttpURLConnection");
    }

    public boolean initProxy(String str, String str2, String str3, Context context) {
        if (str2.equals(ExifInterface.GPS_MEASUREMENT_3D) || (str2.equals("4") && str.equals("1"))) {
            if (str2.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                DNSResolver.Init(context, "560820", "560820_29496609822085120", "2300dc32bb494e098fc4233d58d8aa35");
            } else {
                DNSResolver.Init(context, "145612", "145612_29495097350623232", "dde5a85445eb4e6a8f8232cb274825ff");
            }
            if (str3.equals("032") || str3.equals("1031") || str3.equals("105") || str3.equals("5002") || str3.equals("5001")) {
                DNSResolver.setEnableLogger(true);
            }
            Log.d(TAG, "mah project, ali proxy init success");
            this.useDnsSdk = true;
            return true;
        }
        Log.d(TAG, "mah project, ali proxy init fail");
        return false;
    }

    public boolean isUseDnsSdk() {
        return this.useDnsSdk;
    }

    public boolean isValidIPv4(String str) {
        if (str.startsWith(c.f18247l)) {
            str = str.replace(c.f18247l, "");
        }
        if (str.startsWith(c.f18246k)) {
            str = str.replace(c.f18246k, "");
        }
        return Pattern.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", str);
    }

    public boolean isValidIPv6(String str) {
        if (str.startsWith(c.f18247l)) {
            str = str.replace(c.f18247l, "");
        }
        if (str.startsWith(c.f18246k)) {
            str = str.replace(c.f18246k, "");
        }
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    public void preLoadDomains(String str) {
        try {
            if (this.useDnsSdk) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        strArr[i10] = jSONArray.getString(i10);
                        Log.e(TAG, "preLoadDomains: " + strArr[i10]);
                    }
                    DNSResolver.getInstance().preLoadDomains(strArr);
                }
            }
        } catch (Exception e10) {
            Log.e(TAG, "preLoadDomains: ", e10);
        }
    }

    public boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher) {
        OkHttpClient okHttpClient;
        if (!this.useDnsSdk) {
            return false;
        }
        if (i10 > 0) {
            okHttpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).connectTimeout((long) i10, TimeUnit.SECONDS).protocols(Collections.singletonList(Protocol.HTTP_1_1)).dns(OkHttpDns.getInstance()).build();
        } else {
            okHttpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1)).dns(OkHttpDns.getInstance()).build();
        }
        cocosDownloader.setHttpClient(okHttpClient);
        return true;
    }
}
