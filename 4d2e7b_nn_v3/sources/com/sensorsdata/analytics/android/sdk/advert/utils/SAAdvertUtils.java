package com.sensorsdata.analytics.android.sdk.advert.utils;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class SAAdvertUtils {
    private static final String TAG = "SA.SAAdvert";

    public static String getIdentifier(Context context) {
        return SensorsDataUtils.getIdentifier(context);
    }

    public static String getInstallSource(Context context) {
        return String.format("imei=%s##imei_old=%s##imei_slot1=%s##imei_slot2=%s##imei_meid=%s", new Object[]{"", "", "", "", ""});
    }

    public static boolean isFirstTrackInstallation(boolean z10) {
        if (z10) {
            return ((Boolean) PersistentLoader.getInstance().getFirstInstallationWithCallbackPst().get()).booleanValue();
        }
        return ((Boolean) PersistentLoader.getInstance().getFirstInstallationPst().get()).booleanValue();
    }

    public static boolean isInstallationTracked() {
        if (SAStoreManager.getInstance().isExists(DbParams.PersistentName.FIRST_INSTALL) || SAStoreManager.getInstance().isExists(DbParams.PersistentName.FIRST_INSTALL_CALLBACK)) {
            return true;
        }
        return false;
    }

    public static void sendData(Context context, String str, JSONObject jSONObject, String str2) {
        String str3;
        if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            SALog.i(TAG, "NetworkRequest is disabled");
        } else if (NetworkUtils.isNetworkAvailable(context) && jSONObject != null && jSONObject.length() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                String jSONArray2 = jSONArray.toString();
                if (jSONObject.has("ekey")) {
                    str3 = DbParams.GZIP_DATA_ENCRYPT;
                } else {
                    jSONArray2 = SADataHelper.gzipData(jSONArray2);
                    str3 = "1";
                }
                jSONObject.put("_flush_time", System.currentTimeMillis());
                sendHttpRequest(str, String.valueOf(jSONArray2.hashCode()), str3, jSONArray2, str2);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:46|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r4 = r8.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00c4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:78:0x0160=Splitter:B:78:0x0160, B:59:0x013b=Splitter:B:59:0x013b} */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void sendHttpRequest(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        /*
            r0 = 0
            r1 = 1
            java.lang.Class<com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils> r2 = com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.class
            monitor-enter(r2)
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0152, all -> 0x014d }
            r4.<init>(r8)     // Catch:{ IOException -> 0x0152, all -> 0x014d }
            java.net.URLConnection r8 = r4.openConnection()     // Catch:{ IOException -> 0x0152, all -> 0x014d }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x0152, all -> 0x014d }
            if (r8 != 0) goto L_0x0036
            java.lang.String r9 = "SA.SAAdvert"
            java.lang.String r10 = "can not connect %s, it shouldn't happen"
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r11[r0] = r4     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r3, r3, r3, r8)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0027:
            r8 = move-exception
            goto L_0x0164
        L_0x002a:
            r9 = move-exception
            r10 = r3
        L_0x002c:
            r4 = r10
            goto L_0x0160
        L_0x002f:
            r9 = move-exception
            r10 = r3
            r11 = r10
        L_0x0032:
            r4 = r11
        L_0x0033:
            r3 = r8
            goto L_0x0156
        L_0x0036:
            r8.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            android.net.Uri$Builder r4 = new android.net.Uri$Builder     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r4.<init>()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = "crc"
            r4.appendQueryParameter(r5, r9)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x0049:
            java.lang.String r9 = "gzip"
            r4.appendQueryParameter(r9, r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r9 = "data_list"
            r4.appendQueryParameter(r9, r11)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r9 = "sink_name"
            java.lang.String r10 = "mirror"
            r4.appendQueryParameter(r9, r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            android.net.Uri r9 = r4.build()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r9 = r9.getEncodedQuery()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r10 == 0) goto L_0x006d
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r3, r3, r3, r8)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x006d:
            java.lang.String r10 = "UTF-8"
            byte[] r10 = r9.getBytes(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            int r10 = r10.length     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r8.setFixedLengthStreamingMode(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r8.setDoOutput(r1)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r10 = "POST"
            r8.setRequestMethod(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r10 = 30000(0x7530, float:4.2039E-41)
            r8.setConnectTimeout(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r8.setReadTimeout(r10)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.io.OutputStream r10 = r8.getOutputStream()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0149, all -> 0x0146 }
            r11.<init>(r10)     // Catch:{ IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r4 = "UTF-8"
            byte[] r9 = r9.getBytes(r4)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r11.write(r9)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r11.flush()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            int r9 = r8.getResponseCode()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r4 = "SA.SAAdvert"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r5.<init>()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r6 = "responseCode: "
            r5.append(r6)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r5.append(r9)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.io.InputStream r4 = r8.getInputStream()     // Catch:{ FileNotFoundException -> 0x00c4 }
            goto L_0x00c8
        L_0x00bb:
            r9 = move-exception
            r4 = r3
        L_0x00bd:
            r3 = r11
            goto L_0x0160
        L_0x00c0:
            r9 = move-exception
            r4 = r3
            goto L_0x0033
        L_0x00c4:
            java.io.InputStream r4 = r8.getErrorStream()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
        L_0x00c8:
            byte[] r5 = com.sensorsdata.analytics.android.sdk.util.SADataHelper.slurp(r4)     // Catch:{ IOException -> 0x0143, all -> 0x0140 }
            r4.close()     // Catch:{ IOException -> 0x0143, all -> 0x0140 }
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r6 = "UTF-8"
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            boolean r5 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            if (r5 == 0) goto L_0x013b
            java.lang.String r12 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r5 = 200(0xc8, float:2.8E-43)
            if (r9 < r5) goto L_0x00ff
            r5 = 300(0x12c, float:4.2E-43)
            if (r9 >= r5) goto L_0x00ff
            java.lang.String r9 = "SA.SAAdvert"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r0.<init>()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r1 = "sat valid message: \n"
            r0.append(r1)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r0.append(r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r12 = r0.toString()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            goto L_0x013b
        L_0x00ff:
            java.lang.String r5 = "SA.SAAdvert"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r6.<init>()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r7 = "sat invalid message: \n"
            r6.append(r7)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r6.append(r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r12 = r6.toString()     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r12 = "SA.SAAdvert"
            java.util.Locale r5 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r6 = "ret_code: %d"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r7[r0] = r9     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r9 = java.lang.String.format(r5, r6, r7)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r9 = "SA.SAAdvert"
            java.util.Locale r12 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r5 = "ret_content: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            r1[r0] = r4     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            java.lang.String r12 = java.lang.String.format(r12, r5, r1)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r12)     // Catch:{ IOException -> 0x00c0, all -> 0x00bb }
        L_0x013b:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r11, r10, r3, r8)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0140:
            r9 = move-exception
            goto L_0x00bd
        L_0x0143:
            r9 = move-exception
            goto L_0x0033
        L_0x0146:
            r9 = move-exception
            r4 = r3
            goto L_0x0160
        L_0x0149:
            r9 = move-exception
            r11 = r3
            goto L_0x0032
        L_0x014d:
            r9 = move-exception
            r8 = r3
            r10 = r8
            goto L_0x002c
        L_0x0152:
            r9 = move-exception
            r10 = r3
            r11 = r10
            r4 = r11
        L_0x0156:
            com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException r8 = new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException     // Catch:{ all -> 0x015c }
            r8.<init>((java.lang.Throwable) r9)     // Catch:{ all -> 0x015c }
            throw r8     // Catch:{ all -> 0x015c }
        L_0x015c:
            r9 = move-exception
            r8 = r3
            goto L_0x00bd
        L_0x0160:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r3, r10, r4, r8)     // Catch:{ all -> 0x0027 }
            throw r9     // Catch:{ all -> 0x0027 }
        L_0x0164:
            monitor-exit(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.sendHttpRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void setTrackInstallation(boolean z10) {
        if (z10) {
            PersistentLoader.getInstance().getFirstInstallationWithCallbackPst().commit(Boolean.FALSE);
        }
        PersistentLoader.getInstance().getFirstInstallationPst().commit(Boolean.FALSE);
    }
}
