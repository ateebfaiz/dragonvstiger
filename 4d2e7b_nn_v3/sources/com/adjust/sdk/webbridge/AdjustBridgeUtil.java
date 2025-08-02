package com.adjust.sdk.webbridge;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustEventFailure;
import com.adjust.sdk.AdjustEventSuccess;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.AdjustSessionFailure;
import com.adjust.sdk.AdjustSessionSuccess;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.network.UtilNetworking;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdjustBridgeUtil {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Uri f17532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebView f17533b;

        a(Uri uri, WebView webView) {
            this.f17532a = uri;
            this.f17533b = webView;
        }

        public void run() {
            this.f17533b.loadUrl("javascript:adjust_deeplink('" + this.f17532a.toString() + "');");
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdjustAttribution f17534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17535b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17536c;

        b(AdjustAttribution adjustAttribution, String str, WebView webView) {
            this.f17534a = adjustAttribution;
            this.f17535b = str;
            this.f17536c = webView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3 A[Catch:{ Exception -> 0x0010 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0 A[Catch:{ Exception -> 0x0010 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "trackerName"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.trackerName     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x0013
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
                goto L_0x0013
            L_0x0010:
                r0 = move-exception
                goto L_0x00df
            L_0x0013:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "trackerToken"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.trackerToken     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x0020
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x0020:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "campaign"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.campaign     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x002d
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x002d:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "network"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.network     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x003a
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x003a:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "creative"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.creative     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x0047
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x0047:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "adgroup"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.adgroup     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x0054
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x0054:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "clickLabel"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.clickLabel     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x0061
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x0061:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "adid"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.adid     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x006e
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x006e:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "costType"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.costType     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x007b
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x007b:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "costAmount"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.Double r2 = r2.costAmount     // Catch:{ Exception -> 0x0010 }
                if (r2 == 0) goto L_0x0096
                boolean r2 = r2.isNaN()     // Catch:{ Exception -> 0x0010 }
                if (r2 == 0) goto L_0x008d
                goto L_0x0096
            L_0x008d:
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.Double r2 = r2.costAmount     // Catch:{ Exception -> 0x0010 }
                double r2 = r2.doubleValue()     // Catch:{ Exception -> 0x0010 }
                goto L_0x0098
            L_0x0096:
                r2 = 0
            L_0x0098:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "costCurrency"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.costCurrency     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x00a5
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x00a5:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r1 = "fbInstallReferrer"
                com.adjust.sdk.AdjustAttribution r2 = r4.f17534a     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r2.fbInstallReferrer     // Catch:{ Exception -> 0x0010 }
                if (r2 != 0) goto L_0x00b2
                java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ Exception -> 0x0010 }
            L_0x00b2:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0010 }
                r1.<init>()     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = "javascript:"
                r1.append(r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = r4.f17535b     // Catch:{ Exception -> 0x0010 }
                r1.append(r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r2 = "("
                r1.append(r2)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0010 }
                r1.append(r0)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r0 = ");"
                r1.append(r0)     // Catch:{ Exception -> 0x0010 }
                java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0010 }
                android.webkit.WebView r1 = r4.f17536c     // Catch:{ Exception -> 0x0010 }
                r1.loadUrl(r0)     // Catch:{ Exception -> 0x0010 }
                goto L_0x00e2
            L_0x00df:
                r0.printStackTrace()
            L_0x00e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.webbridge.AdjustBridgeUtil.b.run():void");
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdjustSessionSuccess f17537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17539c;

        c(AdjustSessionSuccess adjustSessionSuccess, String str, WebView webView) {
            this.f17537a = adjustSessionSuccess;
            this.f17538b = str;
            this.f17539c = webView;
        }

        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                Object obj = this.f17537a.message;
                if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONObject.put("message", obj);
                Object obj2 = this.f17537a.adid;
                if (obj2 == null) {
                    obj2 = JSONObject.NULL;
                }
                jSONObject.put("adid", obj2);
                Object obj3 = this.f17537a.timestamp;
                if (obj3 == null) {
                    obj3 = JSONObject.NULL;
                }
                jSONObject.put("timestamp", obj3);
                Object obj4 = this.f17537a.jsonResponse;
                if (obj4 == null) {
                    obj4 = JSONObject.NULL;
                }
                jSONObject.put("jsonResponse", obj4);
                this.f17539c.loadUrl("javascript:" + this.f17538b + "(" + jSONObject.toString() + ");");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdjustSessionFailure f17540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17541b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17542c;

        d(AdjustSessionFailure adjustSessionFailure, String str, WebView webView) {
            this.f17540a = adjustSessionFailure;
            this.f17541b = str;
            this.f17542c = webView;
        }

        public void run() {
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                Object obj = this.f17540a.message;
                if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONObject.put("message", obj);
                Object obj2 = this.f17540a.adid;
                if (obj2 == null) {
                    obj2 = JSONObject.NULL;
                }
                jSONObject.put("adid", obj2);
                Object obj3 = this.f17540a.timestamp;
                if (obj3 == null) {
                    obj3 = JSONObject.NULL;
                }
                jSONObject.put("timestamp", obj3);
                if (this.f17540a.willRetry) {
                    str = String.valueOf(true);
                } else {
                    str = String.valueOf(false);
                }
                jSONObject.put("willRetry", str);
                Object obj4 = this.f17540a.jsonResponse;
                if (obj4 == null) {
                    obj4 = JSONObject.NULL;
                }
                jSONObject.put("jsonResponse", obj4);
                this.f17542c.loadUrl("javascript:" + this.f17541b + "(" + jSONObject.toString() + ");");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdjustEventSuccess f17543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17544b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17545c;

        e(AdjustEventSuccess adjustEventSuccess, String str, WebView webView) {
            this.f17543a = adjustEventSuccess;
            this.f17544b = str;
            this.f17545c = webView;
        }

        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                Object obj = this.f17543a.eventToken;
                if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONObject.put("eventToken", obj);
                Object obj2 = this.f17543a.message;
                if (obj2 == null) {
                    obj2 = JSONObject.NULL;
                }
                jSONObject.put("message", obj2);
                Object obj3 = this.f17543a.adid;
                if (obj3 == null) {
                    obj3 = JSONObject.NULL;
                }
                jSONObject.put("adid", obj3);
                Object obj4 = this.f17543a.timestamp;
                if (obj4 == null) {
                    obj4 = JSONObject.NULL;
                }
                jSONObject.put("timestamp", obj4);
                Object obj5 = this.f17543a.callbackId;
                if (obj5 == null) {
                    obj5 = JSONObject.NULL;
                }
                jSONObject.put("callbackId", obj5);
                Object obj6 = this.f17543a.jsonResponse;
                if (obj6 == null) {
                    obj6 = JSONObject.NULL;
                }
                jSONObject.put("jsonResponse", obj6);
                this.f17545c.loadUrl("javascript:" + this.f17544b + "(" + jSONObject.toString() + ");");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdjustEventFailure f17546a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17547b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17548c;

        f(AdjustEventFailure adjustEventFailure, String str, WebView webView) {
            this.f17546a = adjustEventFailure;
            this.f17547b = str;
            this.f17548c = webView;
        }

        public void run() {
            String str;
            JSONObject jSONObject = new JSONObject();
            try {
                Object obj = this.f17546a.eventToken;
                if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONObject.put("eventToken", obj);
                Object obj2 = this.f17546a.message;
                if (obj2 == null) {
                    obj2 = JSONObject.NULL;
                }
                jSONObject.put("message", obj2);
                Object obj3 = this.f17546a.adid;
                if (obj3 == null) {
                    obj3 = JSONObject.NULL;
                }
                jSONObject.put("adid", obj3);
                Object obj4 = this.f17546a.timestamp;
                if (obj4 == null) {
                    obj4 = JSONObject.NULL;
                }
                jSONObject.put("timestamp", obj4);
                if (this.f17546a.willRetry) {
                    str = String.valueOf(true);
                } else {
                    str = String.valueOf(false);
                }
                jSONObject.put("willRetry", str);
                Object obj5 = this.f17546a.callbackId;
                if (obj5 == null) {
                    obj5 = JSONObject.NULL;
                }
                jSONObject.put("callbackId", obj5);
                Object obj6 = this.f17546a.jsonResponse;
                if (obj6 == null) {
                    obj6 = JSONObject.NULL;
                }
                jSONObject.put("jsonResponse", obj6);
                this.f17548c.loadUrl("javascript:" + this.f17547b + "(" + jSONObject.toString() + ");");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17549a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f17551c;

        g(String str, String str2, WebView webView) {
            this.f17549a = str;
            this.f17550b = str2;
            this.f17551c = webView;
        }

        public void run() {
            this.f17551c.loadUrl("javascript:" + this.f17549a + "('" + this.f17550b + "');");
        }
    }

    class h implements UtilNetworking.IConnectionOptions {

        class a implements X509TrustManager {
            a() {
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                Log.d("TestApp", "checkClientTrusted ");
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                Log.d("TestApp", "checkServerTrusted ");
                try {
                    if (!AdjustBridgeUtil.byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(x509CertificateArr[0].getEncoded())).equalsIgnoreCase("7BCFF44099A35BC093BB48C5A6B9A516CDFDA0D1")) {
                        throw new CertificateException();
                    }
                } catch (NoSuchAlgorithmException e10) {
                    Log.e("TestApp", "testingMode error " + e10.getMessage());
                } catch (CertificateEncodingException e11) {
                    Log.e("TestApp", "testingMode error " + e11.getMessage());
                }
            }

            public X509Certificate[] getAcceptedIssuers() {
                Log.d("TestApp", "getAcceptedIssuers");
                return null;
            }
        }

        class b implements HostnameVerifier {
            b() {
            }

            public boolean verify(String str, SSLSession sSLSession) {
                Log.d("TestApp", "verify hostname ");
                return true;
            }
        }

        h() {
        }

        public void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str) {
            UtilNetworking.createDefaultConnectionOptions().applyConnectionOptions(httpsURLConnection, str);
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, new TrustManager[]{new a()}, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(new b());
            } catch (Exception e10) {
                Log.e("TestApp", "testingMode error " + e10.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte hexString : bArr) {
            String hexString2 = Integer.toHexString(hexString);
            int length = hexString2.length();
            if (length == 1) {
                hexString2 = "0" + hexString2;
            }
            if (length > 2) {
                hexString2 = hexString2.substring(length - 2, length);
            }
            sb2.append(hexString2.toUpperCase());
        }
        return sb2.toString();
    }

    public static void execAttributionCallbackCommand(WebView webView, String str, AdjustAttribution adjustAttribution) {
        if (webView != null && adjustAttribution != null) {
            webView.post(new b(adjustAttribution, str, webView));
        }
    }

    public static void execEventFailureCallbackCommand(WebView webView, String str, AdjustEventFailure adjustEventFailure) {
        if (webView != null && adjustEventFailure != null) {
            webView.post(new f(adjustEventFailure, str, webView));
        }
    }

    public static void execEventSuccessCallbackCommand(WebView webView, String str, AdjustEventSuccess adjustEventSuccess) {
        if (webView != null && adjustEventSuccess != null) {
            webView.post(new e(adjustEventSuccess, str, webView));
        }
    }

    public static void execSessionFailureCallbackCommand(WebView webView, String str, AdjustSessionFailure adjustSessionFailure) {
        if (webView != null && adjustSessionFailure != null) {
            webView.post(new d(adjustSessionFailure, str, webView));
        }
    }

    public static void execSessionSuccessCallbackCommand(WebView webView, String str, AdjustSessionSuccess adjustSessionSuccess) {
        if (webView != null && adjustSessionSuccess != null) {
            webView.post(new c(adjustSessionSuccess, str, webView));
        }
    }

    public static void execSingleValueCallback(WebView webView, String str, String str2) {
        if (webView != null) {
            webView.post(new g(str, str2, webView));
        }
    }

    public static Boolean fieldToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (obj2.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Double fieldToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(obj.toString()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Long fieldToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(obj.toString()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String fieldToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.equals("null")) {
            return null;
        }
        return obj2;
    }

    public static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String[] jsonArrayToArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            strArr[i10] = jSONArray.get(i10).toString();
        }
        return strArr;
    }

    public static void sendDeeplinkToWebView(WebView webView, Uri uri) {
        if (webView != null) {
            webView.post(new a(uri, webView));
        }
    }

    static UtilNetworking.IConnectionOptions testConnectionOptions() {
        return new h();
    }
}
