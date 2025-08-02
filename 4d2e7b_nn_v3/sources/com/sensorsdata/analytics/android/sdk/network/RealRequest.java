package com.sensorsdata.analytics.android.sdk.network;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

class RealRequest {
    private static final String TAG = "SA.HttpRequest";
    private static String sRequestURL;
    private HttpConfig httpConfig = new HttpConfig();

    RealRequest() {
    }

    private RealResponse getExceptionResponse(Exception exc) {
        RealResponse realResponse = new RealResponse();
        realResponse.exception = exc;
        realResponse.errorMsg = exc.getMessage();
        SALog.i(TAG, realResponse.toString());
        return realResponse;
    }

    private HttpURLConnection getHttpURLConnection(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(this.httpConfig.getConnectionTimeout());
        httpURLConnection.setReadTimeout(this.httpConfig.getReadTimeout());
        if (str2.equals("POST")) {
            httpURLConnection.setDoOutput(true);
        }
        SAConfigOptions configOptions = AbstractSensorsDataAPI.getConfigOptions();
        if (!(configOptions == null || configOptions.getSSLSocketFactory() == null || !(httpURLConnection instanceof HttpsURLConnection))) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(configOptions.getSSLSocketFactory());
        }
        return httpURLConnection;
    }

    private RealResponse getRealResponse(HttpURLConnection httpURLConnection) {
        RealResponse realResponse = new RealResponse();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            realResponse.code = responseCode;
            if (HttpUtils.needRedirects(responseCode)) {
                realResponse.location = HttpUtils.getLocation(httpURLConnection, sRequestURL);
            }
            realResponse.contentLength = (long) httpURLConnection.getContentLength();
            if (realResponse.code < 400) {
                realResponse.result = HttpUtils.getRetString(httpURLConnection.getInputStream());
            } else {
                realResponse.errorMsg = HttpUtils.getRetString(httpURLConnection.getErrorStream());
            }
            httpURLConnection.disconnect();
            SALog.i(TAG, realResponse.toString());
            return realResponse;
        } catch (IOException e10) {
            RealResponse exceptionResponse = getExceptionResponse(e10);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return exceptionResponse;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private void setHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RealResponse getData(String str, Map<String, String> map) {
        try {
            SALog.i(TAG, String.format("url:%s,\nmethod:GET", new Object[]{str}));
            sRequestURL = str;
            HttpURLConnection httpURLConnection = getHttpURLConnection(str, "GET");
            if (map != null) {
                setHeader(httpURLConnection, map);
            }
            httpURLConnection.connect();
            return getRealResponse(httpURLConnection);
        } catch (Exception e10) {
            return getExceptionResponse(e10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074 A[SYNTHETIC, Splitter:B:32:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f A[SYNTHETIC, Splitter:B:38:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.network.RealResponse postData(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            sRequestURL = r7     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "SA.HttpRequest"
            java.lang.String r4 = "url:%s\nparams:%s\nmethod:POST"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0031 }
            r5[r1] = r7     // Catch:{ Exception -> 0x0031 }
            r5[r0] = r8     // Catch:{ Exception -> 0x0031 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x0031 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "POST"
            java.net.HttpURLConnection r7 = r6.getHttpURLConnection(r7, r3)     // Catch:{ Exception -> 0x0031 }
            r7.setDoOutput(r0)     // Catch:{ Exception -> 0x0031 }
            r7.setUseCaches(r1)     // Catch:{ Exception -> 0x0031 }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0033
            java.lang.String r0 = "Content-Type"
            r7.setRequestProperty(r0, r9)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0033
        L_0x002f:
            r7 = move-exception
            goto L_0x007d
        L_0x0031:
            r7 = move-exception
            goto L_0x006e
        L_0x0033:
            if (r10 == 0) goto L_0x0038
            r6.setHeader(r7, r10)     // Catch:{ Exception -> 0x0031 }
        L_0x0038:
            r7.connect()     // Catch:{ Exception -> 0x0031 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0031 }
            if (r9 != 0) goto L_0x005f
            java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0031 }
            java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0031 }
            java.io.OutputStream r0 = r7.getOutputStream()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = "UTF-8"
            r10.<init>(r0, r1)     // Catch:{ Exception -> 0x0031 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0031 }
            r9.write(r8)     // Catch:{ Exception -> 0x005c, all -> 0x0059 }
            r9.flush()     // Catch:{ Exception -> 0x005c, all -> 0x0059 }
            r2 = r9
            goto L_0x005f
        L_0x0059:
            r7 = move-exception
            r2 = r9
            goto L_0x007d
        L_0x005c:
            r7 = move-exception
            r2 = r9
            goto L_0x006e
        L_0x005f:
            com.sensorsdata.analytics.android.sdk.network.RealResponse r7 = r6.getRealResponse(r7)     // Catch:{ Exception -> 0x0031 }
            if (r2 == 0) goto L_0x006d
            r2.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x006d:
            return r7
        L_0x006e:
            com.sensorsdata.analytics.android.sdk.network.RealResponse r7 = r6.getExceptionResponse(r7)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x007c:
            return r7
        L_0x007d:
            if (r2 == 0) goto L_0x0087
            r2.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x0087:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.RealRequest.postData(java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.sensorsdata.analytics.android.sdk.network.RealResponse");
    }

    public RealRequest setHttpConfig(HttpConfig httpConfig2) {
        if (httpConfig2 == null) {
            return this;
        }
        this.httpConfig = httpConfig2;
        return this;
    }
}
