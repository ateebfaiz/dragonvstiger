package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class AnalyticsMessages {
    private static final int DELETE_ALL = 4;
    private static final int FLUSH_INSTANT_EVENT = 7;
    private static final int FLUSH_QUEUE = 3;
    private static final int FLUSH_SCHEDULE = 5;
    private static final Map<Context, AnalyticsMessages> S_INSTANCES = new HashMap();
    private static final String TAG = "SA.AnalyticsMessages";
    private final Context mContext;
    /* access modifiers changed from: private */
    public final DbAdapter mDbAdapter = DbAdapter.getInstance();
    private final InternalConfigOptions mInternalConfigs;
    private final SensorsDataAPI mSensorsDataAPI;
    private final Worker mWorker = new Worker();

    private class Worker {
        private final Handler mHandler;
        private final Object mHandlerLock = new Object();

        private class AnalyticsMessageHandler extends Handler {
            AnalyticsMessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                try {
                    int i10 = message.what;
                    if (i10 == 3) {
                        AnalyticsMessages.this.sendData(true);
                        AnalyticsMessages.this.sendData(false);
                    } else if (i10 == 4) {
                        try {
                            AnalyticsMessages.this.mDbAdapter.deleteAllEvents();
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    } else if (i10 == 5) {
                        AnalyticsMessages.this.flushScheduled();
                        AnalyticsMessages.this.sendData(false);
                    } else if (i10 == 7) {
                        AnalyticsMessages.this.sendData(true);
                    } else {
                        SALog.i(AnalyticsMessages.TAG, "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e11) {
                    SALog.i(AnalyticsMessages.TAG, "Worker threw an unhandled exception", (Throwable) e11);
                }
            }
        }

        Worker() {
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.mHandler = new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        /* access modifiers changed from: package-private */
        public void runMessage(Message message) {
            synchronized (this.mHandlerLock) {
                try {
                    Handler handler = this.mHandler;
                    if (handler == null) {
                        SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                    } else {
                        handler.sendMessage(message);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void runMessageOnce(Message message, long j10) {
            synchronized (this.mHandlerLock) {
                try {
                    Handler handler = this.mHandler;
                    if (handler == null) {
                        SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                    } else if (!handler.hasMessages(message.what)) {
                        this.mHandler.sendMessageDelayed(message, j10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private AnalyticsMessages(Context context, SensorsDataAPI sensorsDataAPI, InternalConfigOptions internalConfigOptions) {
        this.mContext = context;
        this.mSensorsDataAPI = sensorsDataAPI;
        this.mInternalConfigs = internalConfigOptions;
    }

    public static AnalyticsMessages getInstance(Context context, SensorsDataAPI sensorsDataAPI, InternalConfigOptions internalConfigOptions) {
        AnalyticsMessages analyticsMessages;
        Map<Context, AnalyticsMessages> map = S_INSTANCES;
        synchronized (map) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (!map.containsKey(applicationContext)) {
                    analyticsMessages = new AnalyticsMessages(applicationContext, sensorsDataAPI, internalConfigOptions);
                    map.put(applicationContext, analyticsMessages);
                } else {
                    analyticsMessages = map.get(applicationContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return analyticsMessages;
    }

    private boolean isDeleteEventsByCode(int i10) {
        return (i10 == 404 || i10 == 403 || (i10 >= 500 && i10 < 600)) ? false : true;
    }

    private boolean sendCheck() {
        try {
            if (!this.mSensorsDataAPI.isNetworkRequestEnable()) {
                SALog.i(TAG, "NetworkRequest is disabled");
                return false;
            } else if (TextUtils.isEmpty(this.mSensorsDataAPI.getServerUrl())) {
                SALog.i(TAG, "Server url is null or empty.");
                return false;
            } else if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                return false;
            } else {
                String networkType = NetworkUtils.networkType(this.mContext);
                if (!NetworkUtils.isShouldFlush(networkType, this.mSensorsDataAPI.getSAContextManager().getInternalConfigs().saConfigOptions.mNetworkTypePolicy)) {
                    SALog.i(TAG, String.format("Invalid NetworkType = %s", new Object[]{networkType}));
                    return false;
                }
                if (this.mInternalConfigs.saConfigOptions.isMultiProcessFlush()) {
                    if (DbAdapter.getInstance().isSubProcessFlushing()) {
                        return false;
                    }
                    DbAdapter.getInstance().commitSubProcessFlushState(true);
                } else if (!this.mInternalConfigs.isMainProcess) {
                    return false;
                }
                return true;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void sendData(boolean z10) {
        String[] strArr;
        boolean z11;
        String str;
        String str2;
        String str3;
        if (sendCheck()) {
            int i10 = 100;
            while (i10 > 0) {
                synchronized (this.mDbAdapter) {
                    try {
                        if (this.mSensorsDataAPI.isDebugMode()) {
                            strArr = this.mDbAdapter.generateDataString(DbParams.TABLE_EVENTS, 1, z10);
                        } else {
                            strArr = this.mDbAdapter.generateDataString(DbParams.TABLE_EVENTS, 50, z10);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (strArr == null) {
                    DbAdapter.getInstance().commitSubProcessFlushState(false);
                    return;
                }
                String str4 = strArr[0];
                String str5 = strArr[1];
                String str6 = strArr[2];
                try {
                    if ("1".equals(str6)) {
                        str3 = SADataHelper.gzipData(str5);
                    } else {
                        str3 = str5;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        sendHttpRequest(this.mSensorsDataAPI.getServerUrl(), str3, str6, str5, false, z10);
                    }
                    boolean isDebugMode = this.mSensorsDataAPI.isDebugMode();
                    if (!TextUtils.isEmpty((CharSequence) null) && (isDebugMode || SALog.isLogEnabled())) {
                        SALog.i(TAG, (String) null);
                        if (isDebugMode && this.mInternalConfigs.isShowDebugView) {
                            SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), (String) null);
                        }
                    }
                    try {
                        i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                    str2 = TAG;
                    str = String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)});
                } catch (ConnectErrorException e11) {
                    String str7 = "Connection error: " + e11.getMessage();
                    boolean isDebugMode2 = this.mSensorsDataAPI.isDebugMode();
                    if (!TextUtils.isEmpty(str7) && (isDebugMode2 || SALog.isLogEnabled())) {
                        SALog.i(TAG, str7);
                        if (isDebugMode2 && this.mInternalConfigs.isShowDebugView) {
                            SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), str7);
                        }
                    }
                    if (isDebugMode2) {
                        try {
                            i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                        } catch (Exception e12) {
                            SALog.printStackTrace(e12);
                        }
                        str2 = TAG;
                        str = String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)});
                    }
                    i10 = 0;
                } catch (InvalidDataException e13) {
                    String str8 = "Invalid data: " + e13.getMessage();
                    boolean isDebugMode3 = this.mSensorsDataAPI.isDebugMode();
                    if (!TextUtils.isEmpty(str8) && (isDebugMode3 || SALog.isLogEnabled())) {
                        SALog.i(TAG, str8);
                        if (isDebugMode3 && this.mInternalConfigs.isShowDebugView) {
                            SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), str8);
                        }
                    }
                    try {
                        i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                    } catch (Exception e14) {
                        SALog.printStackTrace(e14);
                    }
                    str2 = TAG;
                    str = String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)});
                } catch (ResponseErrorException e15) {
                    z11 = isDeleteEventsByCode(e15.getHttpCode());
                    String str9 = "ResponseErrorException: " + e15.getMessage();
                    boolean isDebugMode4 = this.mSensorsDataAPI.isDebugMode();
                    if (!TextUtils.isEmpty(str9) && (isDebugMode4 || SALog.isLogEnabled())) {
                        SALog.i(TAG, str9);
                        if (isDebugMode4 && this.mInternalConfigs.isShowDebugView) {
                            SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), str9);
                        }
                    }
                    if (z11 || isDebugMode4) {
                        try {
                            i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                        } catch (Exception e16) {
                            SALog.printStackTrace(e16);
                        }
                        str2 = TAG;
                        str = String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)});
                    }
                    i10 = 0;
                } catch (Exception e17) {
                    String str10 = "Exception: " + e17.getMessage();
                    boolean isDebugMode5 = this.mSensorsDataAPI.isDebugMode();
                    if (!TextUtils.isEmpty(str10) && (isDebugMode5 || SALog.isLogEnabled())) {
                        SALog.i(TAG, str10);
                        if (isDebugMode5 && this.mInternalConfigs.isShowDebugView) {
                            SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), str10);
                        }
                    }
                    if (isDebugMode5) {
                        try {
                            i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                        } catch (Exception e18) {
                            SALog.printStackTrace(e18);
                        }
                        str2 = TAG;
                        str = String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)});
                    }
                    i10 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    boolean isDebugMode6 = this.mSensorsDataAPI.isDebugMode();
                    SALog.i(TAG, (String) null);
                    SensorsDataDialogUtils.showHttpErrorDialog(AppStateTools.getInstance().getForegroundActivity(), (String) null);
                    i10 = this.mDbAdapter.cleanupEvents(new JSONArray(str4), z10);
                    SALog.i(TAG, String.format(TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i10)}));
                    throw th;
                }
                SALog.i(str2, str);
            }
            if (this.mInternalConfigs.saConfigOptions.isMultiProcessFlush()) {
                DbAdapter.getInstance().commitSubProcessFlushState(false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r10v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:64|65) */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r0 = r10.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0128 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendHttpRequest(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            r1 = 0
            r2 = 1
            java.lang.String r3 = "UTF-8"
            r9 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x01c8, all -> 0x01c3 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x01c8, all -> 0x01c3 }
            java.net.URLConnection r5 = r4.openConnection()     // Catch:{ IOException -> 0x01c8, all -> 0x01c3 }
            r10 = r5
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x01c8, all -> 0x01c3 }
            java.lang.String r5 = "SA.AnalyticsMessages"
            if (r10 != 0) goto L_0x0036
            java.lang.String r0 = "can not connect %s, it shouldn't happen"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r2[r1] = r4     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r9, r9, r9, r10)
            return
        L_0x002a:
            r0 = move-exception
            r6 = r9
            r13 = r6
            goto L_0x01d6
        L_0x002f:
            r0 = move-exception
            r6 = r9
            r13 = r6
            r14 = r13
        L_0x0033:
            r9 = r10
            goto L_0x01cc
        L_0x0036:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r4 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r4 == 0) goto L_0x004a
            javax.net.ssl.SSLSocketFactory r4 = r4.mSSLSocketFactory     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r4 == 0) goto L_0x004a
            boolean r6 = r10 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r6 == 0) goto L_0x004a
            r6 = r10
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r6.setSSLSocketFactory(r4)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x004a:
            r10.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r8.mSensorsDataAPI     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r4 = r4.getDebugMode()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r7 = "true"
            if (r4 != r6) goto L_0x005e
            java.lang.String r4 = "Dry-Run"
            r10.addRequestProperty(r4, r7)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x005e:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r8.mSensorsDataAPI     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r4 = r4.getCookie(r1)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r6 != 0) goto L_0x006f
            java.lang.String r6 = "Cookie"
            r10.setRequestProperty(r6, r4)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x006f:
            android.net.Uri$Builder r4 = new android.net.Uri$Builder     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r4.<init>()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r6 != 0) goto L_0x0087
            java.lang.String r6 = "crc"
            int r11 = r18.hashCode()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r4.appendQueryParameter(r6, r11)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x0087:
            java.lang.String r6 = "gzip"
            r11 = r19
            r4.appendQueryParameter(r6, r11)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r6 = "data_list"
            r12 = r18
            r4.appendQueryParameter(r6, r12)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r22 == 0) goto L_0x009c
            java.lang.String r6 = "instant_event"
            r4.appendQueryParameter(r6, r7)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
        L_0x009c:
            android.net.Uri r4 = r4.build()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r4 = r4.getEncodedQuery()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            if (r6 == 0) goto L_0x00ae
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r9, r9, r9, r10)
            return
        L_0x00ae:
            byte[] r6 = r4.getBytes(r3)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            int r6 = r6.length     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r10.setFixedLengthStreamingMode(r6)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r10.setDoOutput(r2)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.lang.String r6 = "POST"
            r10.setRequestMethod(r6)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r6 = 30000(0x7530, float:4.2039E-41)
            r10.setConnectTimeout(r6)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            r10.setReadTimeout(r6)     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.io.OutputStream r13 = r10.getOutputStream()     // Catch:{ IOException -> 0x002f, all -> 0x002a }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x01be, all -> 0x01bb }
            r14.<init>(r13)     // Catch:{ IOException -> 0x01be, all -> 0x01bb }
            byte[] r4 = r4.getBytes(r3)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r14.write(r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r14.flush()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            int r4 = r10.getResponseCode()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r6.<init>()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r7 = "responseCode: "
            r6.append(r7)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r6.append(r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            if (r21 != 0) goto L_0x0122
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            if (r6 == 0) goto L_0x0122
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r10, r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            if (r6 != 0) goto L_0x0122
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r14, r13, r9, r10)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r6 = 1
            r1 = r16
            r2 = r0
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r22
            r1.sendHttpRequest(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r14, r13, r9, r10)
            return
        L_0x0119:
            r0 = move-exception
            r6 = r9
        L_0x011b:
            r9 = r14
            goto L_0x01d6
        L_0x011e:
            r0 = move-exception
            r6 = r9
            goto L_0x0033
        L_0x0122:
            java.io.InputStream r0 = r10.getInputStream()     // Catch:{ FileNotFoundException -> 0x0128 }
        L_0x0126:
            r6 = r0
            goto L_0x012d
        L_0x0128:
            java.io.InputStream r0 = r10.getErrorStream()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            goto L_0x0126
        L_0x012d:
            byte[] r0 = com.sensorsdata.analytics.android.sdk.util.SADataHelper.slurp(r6)     // Catch:{ IOException -> 0x01b8, all -> 0x01b5 }
            r6.close()     // Catch:{ IOException -> 0x01b8, all -> 0x01b5 }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r6.<init>(r0, r3)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r3 = 300(0x12c, float:4.2E-43)
            r7 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x0196
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r20)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            if (r4 < r7) goto L_0x0160
            if (r4 >= r3) goto L_0x0160
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r11.<init>()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r12 = "valid message: \n"
            r11.append(r12)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r11.append(r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            goto L_0x0196
        L_0x0160:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r11.<init>()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r12 = "invalid message: \n"
            r11.append(r12)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r11.append(r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.util.Locale r0 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r11 = "ret_code: %d"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.Object[] r15 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r15[r1] = r12     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r0 = java.lang.String.format(r0, r11, r15)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.util.Locale r0 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r11 = "ret_content: %s"
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r12[r1] = r6     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r0 = java.lang.String.format(r0, r11, r12)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
        L_0x0196:
            if (r4 < r7) goto L_0x019e
            if (r4 >= r3) goto L_0x019e
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r14, r13, r9, r10)
            return
        L_0x019e:
            com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r3 = "flush failure with response '%s', the response code is '%d'"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r7[r1] = r6     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r7[r2] = r5     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            java.lang.String r1 = java.lang.String.format(r3, r7)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            r0.<init>((java.lang.String) r1, (int) r4)     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
            throw r0     // Catch:{ IOException -> 0x011e, all -> 0x0119 }
        L_0x01b5:
            r0 = move-exception
            goto L_0x011b
        L_0x01b8:
            r0 = move-exception
            goto L_0x0033
        L_0x01bb:
            r0 = move-exception
            r6 = r9
            goto L_0x01d6
        L_0x01be:
            r0 = move-exception
            r6 = r9
            r14 = r6
            goto L_0x0033
        L_0x01c3:
            r0 = move-exception
            r6 = r9
            r10 = r6
            r13 = r10
            goto L_0x01d6
        L_0x01c8:
            r0 = move-exception
            r6 = r9
            r13 = r6
            r14 = r13
        L_0x01cc:
            com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException r1 = new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException     // Catch:{ all -> 0x01d2 }
            r1.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x01d2 }
            throw r1     // Catch:{ all -> 0x01d2 }
        L_0x01d2:
            r0 = move-exception
            r10 = r9
            goto L_0x011b
        L_0x01d6:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(r9, r13, r6, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.sendHttpRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void deleteAll() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 4;
            this.mWorker.runMessage(obtain);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void flush() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mWorker.runMessage(obtain);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void flushEventMessage(boolean z10) {
        try {
            synchronized (this.mDbAdapter) {
                Message obtain = Message.obtain();
                obtain.what = 3;
                if (z10) {
                    this.mWorker.runMessage(obtain);
                } else {
                    this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
                }
            }
        } catch (Exception e10) {
            SALog.i(TAG, "enqueueEventMessage error:" + e10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void flushInstanceEvent() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 7;
            this.mWorker.runMessage(obtain);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public void flushScheduled() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static AnalyticsMessages getInstance(Context context) {
        return S_INSTANCES.get(context);
    }
}
