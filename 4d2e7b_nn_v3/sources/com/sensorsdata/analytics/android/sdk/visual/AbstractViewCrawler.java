package com.sensorsdata.analytics.android.sdk.visual;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditState;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader;
import com.sensorsdata.analytics.android.sdk.visual.utils.FlutterUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

public abstract class AbstractViewCrawler implements VTrack {
    private static final int MESSAGE_SEND_STATE_FOR_EDITING = 1;
    private static final String TAG = "SA.AbstractViewCrawler";
    public static final String TYPE_HEAT_MAP = "heat_map";
    public static final String TYPE_VISUAL = "visual";
    /* access modifiers changed from: private */
    public String mAppVersion;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final EditState mEditState;
    /* access modifiers changed from: private */
    public String mFeatureCode;
    private final LifecycleCallbacks mLifecycleCallbacks;
    /* access modifiers changed from: private */
    public final Handler mMainThreadHandler;
    /* access modifiers changed from: private */
    public final ViewCrawlerHandler mMessageThreadHandler;
    /* access modifiers changed from: private */
    public String mPostUrl;
    private boolean mServiceRunning = false;
    /* access modifiers changed from: private */
    public String mType;

    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            AbstractViewCrawler.this.mEditState.remove(activity);
        }

        public void onActivityResumed(Activity activity) {
            AbstractViewCrawler.this.mEditState.add(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private LifecycleCallbacks() {
        }
    }

    private class ViewCrawlerHandler extends Handler {
        private String mAppId;
        private StringBuilder mLastImageHash;
        private final EditProtocol mProtocol;
        private final String mSDKVersion;
        private ViewSnapshot mSnapshot;
        private boolean mUseGzip;

        private void onSnapFinished(SnapInfo snapInfo) {
            if (snapInfo != null && !NodesProcess.getInstance().getWebNodesManager().hasThirdView()) {
                NodesProcess.getInstance().getWebNodesManager().clear();
            }
            if (snapInfo != null && !NodesProcess.getInstance().getFlutterNodesManager().hasThirdView()) {
                NodesProcess.getInstance().getFlutterNodesManager().clear();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.InputStream} */
        /* JADX WARNING: type inference failed for: r6v12 */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
            r6 = r4;
            r4 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r4 = r6.getErrorStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x013f, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0140, code lost:
            r6 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0187, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0188, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0191, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0192, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x019b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x019c, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x01a6  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x01ba  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01c3 A[SYNTHETIC, Splitter:B:106:0x01c3] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x01cd A[SYNTHETIC, Splitter:B:111:0x01cd] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01d7 A[SYNTHETIC, Splitter:B:116:0x01d7] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x01e1 A[SYNTHETIC, Splitter:B:121:0x01e1] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
          PHI: (r4v4 java.io.BufferedOutputStream) = (r4v0 java.io.BufferedOutputStream), (r4v0 java.io.BufferedOutputStream), (r4v10 java.io.BufferedOutputStream) binds: [B:30:0x0094, B:39:0x00b6, B:48:0x011b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:30:0x0094] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0183 A[SYNTHETIC, Splitter:B:84:0x0183] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x018d A[SYNTHETIC, Splitter:B:89:0x018d] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0197 A[SYNTHETIC, Splitter:B:94:0x0197] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01a1 A[SYNTHETIC, Splitter:B:99:0x01a1] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void postSnapshot(java.io.ByteArrayOutputStream r12) {
            /*
                r11 = this;
                java.lang.String r0 = "UTF-8"
                java.lang.String r1 = "SA.AbstractViewCrawler"
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mFeatureCode
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x01ea
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mPostUrl
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x001e
                goto L_0x01ea
            L_0x001e:
                r2 = 1000(0x3e8, double:4.94E-321)
                r4 = 0
                r5 = 1
                java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r7 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.lang.String r7 = r7.mPostUrl     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r7 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                if (r7 == 0) goto L_0x007c
                boolean r8 = r7.isDisableSDK()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                if (r8 == 0) goto L_0x0068
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r1 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r1 = r1.mMessageThreadHandler     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                android.os.Message r1 = r1.obtainMessage(r5)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                r0.sendMessageDelayed(r1, r2)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                if (r12 == 0) goto L_0x005c
                r12.close()     // Catch:{ Exception -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x005c:
                return
            L_0x005d:
                r0 = move-exception
                r6 = r4
                r7 = r6
                goto L_0x01c1
            L_0x0062:
                r0 = move-exception
                r6 = r4
                r7 = r6
            L_0x0065:
                r1 = r5
                goto L_0x017e
            L_0x0068:
                javax.net.ssl.SSLSocketFactory r8 = r7.getSSLSocketFactory()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                if (r8 == 0) goto L_0x007c
                boolean r8 = r6 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                if (r8 == 0) goto L_0x007c
                r8 = r6
                javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                javax.net.ssl.SSLSocketFactory r7 = r7.getSSLSocketFactory()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                r8.setSSLSocketFactory(r7)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            L_0x007c:
                r6.setDoOutput(r5)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.lang.String r7 = "POST"
                r6.setRequestMethod(r7)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.lang.String r7 = "Content-type"
                java.lang.String r8 = "text/plain"
                r6.setRequestProperty(r7, r8)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
                java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
                r8.<init>(r7)     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
                java.lang.String r9 = r12.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                byte[] r9 = r9.getBytes(r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r8.write(r9)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r8.flush()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                int r9 = r6.getResponseCode()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.io.InputStream r4 = r6.getInputStream()     // Catch:{ FileNotFoundException -> 0x00b6 }
                goto L_0x00ba
            L_0x00ab:
                r0 = move-exception
                r6 = r4
                r4 = r8
                goto L_0x01c1
            L_0x00b0:
                r0 = move-exception
                r6 = r4
                r1 = r5
            L_0x00b3:
                r4 = r8
                goto L_0x017e
            L_0x00b6:
                java.io.InputStream r4 = r6.getErrorStream()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
            L_0x00ba:
                byte[] r6 = r11.slurp(r4)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r10.<init>(r6, r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.<init>()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r6 = "request url ="
                r0.append(r6)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r6 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r6 = r6.mPostUrl     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.append(r6)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.<init>()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r6 = "responseCode="
                r0.append(r6)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.append(r9)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.<init>()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r6 = "response="
                r0.append(r6)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.append(r10)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r0.<init>(r10)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                r1 = 200(0xc8, float:2.8E-43)
                if (r9 != r1) goto L_0x0151
                java.lang.String r1 = "delay"
                int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x00b0, all -> 0x00ab }
                if (r1 >= 0) goto L_0x0118
                r1 = 0
                goto L_0x0119
            L_0x0118:
                r1 = r5
            L_0x0119:
                java.lang.String r6 = "visualized_sdk_config"
                java.lang.String r6 = r0.optString(r6)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                java.lang.String r9 = "visualized_config_disabled"
                boolean r9 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                if (r10 == 0) goto L_0x012d
                if (r9 == 0) goto L_0x0143
            L_0x012d:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r9 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                boolean r9 = r9.isVisualizedPropertiesEnabled()     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                if (r9 == 0) goto L_0x0143
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r9 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                r9.save2Cache(r6)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                goto L_0x0143
            L_0x013f:
                r0 = move-exception
                r6 = r4
                goto L_0x00b3
            L_0x0143:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r6 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                java.lang.String r9 = "visualized_debug_mode_enabled"
                boolean r0 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                r6.setDebugModeEnabled(r0)     // Catch:{ Exception -> 0x013f, all -> 0x00ab }
                goto L_0x0152
            L_0x0151:
                r1 = r5
            L_0x0152:
                r8.close()     // Catch:{ Exception -> 0x0156 }
                goto L_0x015a
            L_0x0156:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x015a:
                if (r4 == 0) goto L_0x0164
                r4.close()     // Catch:{ Exception -> 0x0160 }
                goto L_0x0164
            L_0x0160:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0164:
                if (r7 == 0) goto L_0x016e
                r7.close()     // Catch:{ Exception -> 0x016a }
                goto L_0x016e
            L_0x016a:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x016e:
                r12.close()     // Catch:{ Exception -> 0x0172 }
                goto L_0x01a4
            L_0x0172:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
                goto L_0x01a4
            L_0x0177:
                r0 = move-exception
                r6 = r4
                goto L_0x01c1
            L_0x017a:
                r0 = move-exception
                r6 = r4
                goto L_0x0065
            L_0x017e:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x01c0 }
                if (r4 == 0) goto L_0x018b
                r4.close()     // Catch:{ Exception -> 0x0187 }
                goto L_0x018b
            L_0x0187:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x018b:
                if (r6 == 0) goto L_0x0195
                r6.close()     // Catch:{ Exception -> 0x0191 }
                goto L_0x0195
            L_0x0191:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0195:
                if (r7 == 0) goto L_0x019f
                r7.close()     // Catch:{ Exception -> 0x019b }
                goto L_0x019f
            L_0x019b:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x019f:
                if (r12 == 0) goto L_0x01a4
                r12.close()     // Catch:{ Exception -> 0x0172 }
            L_0x01a4:
                if (r1 == 0) goto L_0x01ba
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r12 = r12.mMessageThreadHandler
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler
                android.os.Message r0 = r0.obtainMessage(r5)
                r12.sendMessageDelayed(r0, r2)
                goto L_0x01bf
            L_0x01ba:
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                r12.stopUpdates(r5)
            L_0x01bf:
                return
            L_0x01c0:
                r0 = move-exception
            L_0x01c1:
                if (r4 == 0) goto L_0x01cb
                r4.close()     // Catch:{ Exception -> 0x01c7 }
                goto L_0x01cb
            L_0x01c7:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01cb:
                if (r6 == 0) goto L_0x01d5
                r6.close()     // Catch:{ Exception -> 0x01d1 }
                goto L_0x01d5
            L_0x01d1:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01d5:
                if (r7 == 0) goto L_0x01df
                r7.close()     // Catch:{ Exception -> 0x01db }
                goto L_0x01df
            L_0x01db:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01df:
                if (r12 == 0) goto L_0x01e9
                r12.close()     // Catch:{ Exception -> 0x01e5 }
                goto L_0x01e9
            L_0x01e5:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x01e9:
                throw r0
            L_0x01ea:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.postSnapshot(java.io.ByteArrayOutputStream):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0112, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0113, code lost:
            r13 = "Can't close writer.";
            r10 = "Can't close payload_out.";
            r9 = "Can't close gos.";
            r6 = null;
            r7 = null;
            r16 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x04c3, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x04c4, code lost:
            r13 = r17;
            r9 = r18;
            r10 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x04cd, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x04ce, code lost:
            r13 = r17;
            r9 = r18;
            r10 = r19;
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
            r16.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x04f6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x04f7, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't close os.", (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0501, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0502, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r9, (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x050c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x050d, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r10, (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
            r16.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x053c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x053d, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't close os.", (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x0547, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x0548, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r9, (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0552, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0553, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r10, (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x017e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x017f, code lost:
            r13 = "Can't close writer.";
            r10 = "Can't close payload_out.";
            r9 = "Can't close gos.";
            r3 = null;
            r6 = null;
            r7 = null;
            r16 = null;
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01f6, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0203, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0204, code lost:
            r2 = r0;
            r13 = r17;
            r9 = r18;
            r10 = r19;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0112 A[Catch:{ Exception -> 0x011d, all -> 0x0112 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x00fb] */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x04c3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:92:0x0303] */
        /* JADX WARNING: Removed duplicated region for block: B:186:0x04f2 A[SYNTHETIC, Splitter:B:186:0x04f2] */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x04fd A[SYNTHETIC, Splitter:B:191:0x04fd] */
        /* JADX WARNING: Removed duplicated region for block: B:196:0x0508 A[SYNTHETIC, Splitter:B:196:0x0508] */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x0538 A[SYNTHETIC, Splitter:B:208:0x0538] */
        /* JADX WARNING: Removed duplicated region for block: B:213:0x0543 A[SYNTHETIC, Splitter:B:213:0x0543] */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x054e A[SYNTHETIC, Splitter:B:218:0x054e] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x01f6 A[Catch:{ IOException -> 0x0203, all -> 0x01f6 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:45:0x01b2] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendSnapshot() {
            /*
                r22 = this;
                r1 = r22
                java.lang.String r2 = "Can't close writer."
                java.lang.String r3 = "Can't close payload_out."
                java.lang.String r4 = "Can't close gos."
                java.lang.String r5 = "Can't close os."
                java.lang.String r6 = ","
                java.lang.String r7 = "\","
                java.lang.String r8 = "SA.AbstractViewCrawler"
                long r9 = java.lang.System.currentTimeMillis()
                com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol r11 = r1.mProtocol     // Catch:{ BadInstructionsException -> 0x002a }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ BadInstructionsException -> 0x002a }
                android.os.Handler r12 = r12.mMainThreadHandler     // Catch:{ BadInstructionsException -> 0x002a }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r11 = r11.readSnapshotConfig(r12)     // Catch:{ BadInstructionsException -> 0x002a }
                r1.mSnapshot = r11     // Catch:{ BadInstructionsException -> 0x002a }
                if (r11 != 0) goto L_0x002e
                java.lang.String r2 = "Snapshot should be initialize at first calling."
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ BadInstructionsException -> 0x002a }
                return
            L_0x002a:
                r0 = move-exception
                r2 = r0
                goto L_0x0561
            L_0x002e:
                java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream
                r11.<init>()
                java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream
                r12.<init>(r11)
                java.lang.String r14 = "{"
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = "\"type\": \"snapshot_response\","
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.<init>()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = "\"feature_code\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r15 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = r15.mFeatureCode     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r7)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.<init>()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = "\"app_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r15 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = r15.mAppVersion     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r7)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.<init>()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = "\"lib_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = r1.mSDKVersion     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r7)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = "\"os\": \"Android\","
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = "\"lib\": \"Android\","
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.<init>()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = "\"app_id\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = r1.mAppId     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r7)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.<init>()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r15 = "\"app_enablevisualizedproperties\": "
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r15 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                boolean r15 = r15.isVisualizedPropertiesEnabled()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r15)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r14.append(r6)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                r12.write(r14)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                r14.<init>()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r13 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                boolean r13 = r15.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r13)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                if (r13 != 0) goto L_0x0120
                java.lang.String r13 = "$AppClick"
                r14.put(r13)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                goto L_0x0120
            L_0x0112:
                r0 = move-exception
                r13 = r2
                r10 = r3
                r9 = r4
                r6 = 0
                r7 = 0
                r16 = 0
            L_0x011a:
                r2 = r0
                goto L_0x0536
            L_0x011d:
                r0 = move-exception
                r13 = r0
                goto L_0x0151
            L_0x0120:
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r13 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                boolean r13 = r13.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r15)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                if (r13 != 0) goto L_0x0131
                java.lang.String r13 = "$AppViewScreen"
                r14.put(r13)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
            L_0x0131:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                r13.<init>()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                java.lang.String r15 = "\"app_autotrack\": "
                r13.append(r15)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                r13.append(r14)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                r13.append(r6)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                byte[] r13 = r13.getBytes()     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                r12.write(r13)     // Catch:{ Exception -> 0x011d, all -> 0x0112 }
                goto L_0x0154
            L_0x0151:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r13)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
            L_0x0154:
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r13 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r13 = r13.getVisualConfigVersion()     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                if (r14 != 0) goto L_0x018a
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                r14.<init>()     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                java.lang.String r15 = "\"config_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                r14.append(r13)     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                r14.append(r7)     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                java.lang.String r7 = r14.toString()     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                byte[] r7 = r7.getBytes()     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                r12.write(r7)     // Catch:{ IOException -> 0x017e, all -> 0x0112 }
                goto L_0x018a
            L_0x017e:
                r0 = move-exception
                r13 = r2
                r10 = r3
                r9 = r4
                r3 = 0
                r6 = 0
                r7 = 0
                r16 = 0
                r2 = r0
                goto L_0x04eb
            L_0x018a:
                boolean r7 = r1.mUseGzip     // Catch:{ IOException -> 0x04e6, all -> 0x04e1 }
                java.lang.String r13 = ",\"snapshot_time_millis\": "
                java.lang.String r14 = "}"
                java.lang.String r15 = "\""
                if (r7 == 0) goto L_0x02fb
                java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x02e8, all -> 0x02d6 }
                r7.<init>()     // Catch:{ IOException -> 0x02e8, all -> 0x02d6 }
                r17 = r2
                java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x02d2, all -> 0x02ce }
                r2.<init>(r7)     // Catch:{ IOException -> 0x02d2, all -> 0x02ce }
                java.lang.String r18 = "{\"activities\":"
                r19 = r3
                byte[] r3 = r18.getBytes()     // Catch:{ IOException -> 0x02ca, all -> 0x02c5 }
                r2.write(r3)     // Catch:{ IOException -> 0x02ca, all -> 0x02c5 }
                r2.flush()     // Catch:{ IOException -> 0x02ca, all -> 0x02c5 }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r3 = r1.mSnapshot     // Catch:{ IOException -> 0x02ca, all -> 0x02c5 }
                r18 = r4
                java.lang.StringBuilder r4 = r1.mLastImageHash     // Catch:{ IOException -> 0x02ba, all -> 0x01f6 }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r3 = r3.snapshots(r7, r4)     // Catch:{ IOException -> 0x02ba, all -> 0x01f6 }
                long r20 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                long r20 = r20 - r9
                byte[] r4 = r13.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r4 = java.lang.Long.toString(r20)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r4 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r4 = r4.getDebugInfo()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                if (r9 != 0) goto L_0x0210
                byte[] r9 = r6.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r9)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r9 = "\"event_debug\": "
                byte[] r9 = r9.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r9)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                goto L_0x0210
            L_0x01f6:
                r0 = move-exception
            L_0x01f7:
                r2 = r0
                r13 = r17
                r9 = r18
                r10 = r19
                r6 = 0
            L_0x01ff:
                r16 = 0
                goto L_0x0536
            L_0x0203:
                r0 = move-exception
                r2 = r0
                r13 = r17
                r9 = r18
                r10 = r19
            L_0x020b:
                r6 = 0
            L_0x020c:
                r16 = 0
                goto L_0x04eb
            L_0x0210:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r4 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r4 = r4.getVisualLogInfo()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                if (r9 != 0) goto L_0x0235
                byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r6)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r6 = "\"log_info\":"
                byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r6)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
            L_0x0235:
                byte[] r4 = r14.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.write(r4)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r2.flush()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r7.close()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.lang.String r2 = r7.toString()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                int r6 = r2.length     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                r4.<init>(r6)     // Catch:{ IOException -> 0x0203, all -> 0x01f6 }
                java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x02ad, all -> 0x02a0 }
                r6.<init>(r4)     // Catch:{ IOException -> 0x02ad, all -> 0x02a0 }
                r6.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r6.close()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r4.toByteArray()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r4.close()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r9.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r10 = "\"gzip_payload\": \""
                r9.append(r10)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r10 = new java.lang.String     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                char[] r2 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r10.<init>(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r9.append(r10)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r9.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r9.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                goto L_0x033f
            L_0x0288:
                r0 = move-exception
                r2 = r0
                r16 = r4
                r13 = r17
                r9 = r18
                r10 = r19
                goto L_0x0536
            L_0x0294:
                r0 = move-exception
                r2 = r0
                r16 = r4
                r13 = r17
                r9 = r18
                r10 = r19
                goto L_0x04eb
            L_0x02a0:
                r0 = move-exception
                r2 = r0
                r16 = r4
                r13 = r17
                r9 = r18
                r10 = r19
                r6 = 0
                goto L_0x0536
            L_0x02ad:
                r0 = move-exception
                r2 = r0
                r16 = r4
                r13 = r17
                r9 = r18
                r10 = r19
                r6 = 0
                goto L_0x04eb
            L_0x02ba:
                r0 = move-exception
            L_0x02bb:
                r2 = r0
                r13 = r17
                r9 = r18
                r10 = r19
                r3 = 0
                goto L_0x020b
            L_0x02c5:
                r0 = move-exception
            L_0x02c6:
                r18 = r4
                goto L_0x01f7
            L_0x02ca:
                r0 = move-exception
            L_0x02cb:
                r18 = r4
                goto L_0x02bb
            L_0x02ce:
                r0 = move-exception
                r19 = r3
                goto L_0x02c6
            L_0x02d2:
                r0 = move-exception
                r19 = r3
                goto L_0x02cb
            L_0x02d6:
                r0 = move-exception
                r17 = r2
                r19 = r3
                r18 = r4
                r2 = r0
                r13 = r17
                r9 = r18
                r10 = r19
            L_0x02e4:
                r6 = 0
                r7 = 0
                goto L_0x01ff
            L_0x02e8:
                r0 = move-exception
                r17 = r2
                r19 = r3
                r18 = r4
                r2 = r0
                r13 = r17
                r9 = r18
                r10 = r19
            L_0x02f6:
                r3 = 0
            L_0x02f7:
                r6 = 0
                r7 = 0
                goto L_0x020c
            L_0x02fb:
                r17 = r2
                r19 = r3
                r18 = r4
                java.lang.String r2 = "\"payload\": {"
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                r12.write(r2)     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                java.lang.String r2 = "\"activities\":"
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                r12.write(r2)     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                r12.flush()     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r2 = r1.mSnapshot     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                java.lang.StringBuilder r3 = r1.mLastImageHash     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r3 = r2.snapshots(r11, r3)     // Catch:{ IOException -> 0x04d7, all -> 0x04c3 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                long r6 = r6 - r9
                byte[] r2 = r13.getBytes()     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                r12.write(r2)     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                java.lang.String r2 = java.lang.Long.toString(r6)     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                r12.write(r2)     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                byte[] r2 = r14.getBytes()     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                r12.write(r2)     // Catch:{ IOException -> 0x04cd, all -> 0x04c3 }
                r4 = 0
                r6 = 0
                r7 = 0
            L_0x033f:
                java.lang.String r2 = r3.screenName     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 != 0) goto L_0x0367
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = ",\"screen_name\": \""
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = r3.screenName     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r13 = r3.screenName     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                goto L_0x0368
            L_0x0367:
                r13 = 0
            L_0x0368:
                boolean r2 = r3.hasFragment     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 == 0) goto L_0x037b
                com.sensorsdata.analytics.android.sdk.util.AppStateTools r2 = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.getFragmentScreenName()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                if (r9 != 0) goto L_0x037b
                r13 = r2
            L_0x037b:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r2.<init>()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                java.lang.String r9 = "page_name： "
                r2.append(r9)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r2.append(r13)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 != 0) goto L_0x03b0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = ",\"page_name\": \""
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r13)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x03b0:
                java.lang.String r2 = r3.activityTitle     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 != 0) goto L_0x03d5
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = ",\"title\": \""
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = r3.activityTitle     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x03d5:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r2.<init>()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                java.lang.String r9 = ",\"is_webview\": "
                r2.append(r9)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r9 = r3.isWebView     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r2.append(r9)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r12.write(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                java.lang.String r2 = r3.webLibVersion     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 != 0) goto L_0x0414
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = ",\"web_lib_version\": \""
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = r3.webLibVersion     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x0414:
                boolean r2 = r3.isWebView     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 == 0) goto L_0x042f
                java.lang.String r2 = r3.webViewUrl     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                if (r2 != 0) goto L_0x042f
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.mType     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r9 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                android.content.Context r9 = r9.mContext     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.buildH5AlertInfo(r12, r2, r3, r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x042f:
                java.lang.String r2 = r3.flutterLibVersion     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 != 0) goto L_0x0454
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.<init>()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = ",\"flutter_lib_version\": \""
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r9 = r3.flutterLibVersion     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r2.append(r15)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                r12.write(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x0454:
                boolean r2 = r3.isFlutter     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r2 == 0) goto L_0x046f
                java.lang.String r2 = r3.activityName     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                if (r2 != 0) goto L_0x046f
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                java.lang.String r2 = r2.mType     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r9 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                android.content.Context r9 = r9.mContext     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.buildFlutterAlertInfo(r12, r2, r3, r9)     // Catch:{ IOException -> 0x0294, all -> 0x0288 }
            L_0x046f:
                byte[] r2 = r14.getBytes()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r12.write(r2)     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                r12.flush()     // Catch:{ IOException -> 0x04b8, all -> 0x04ac }
                if (r4 == 0) goto L_0x0484
                r4.close()     // Catch:{ Exception -> 0x047f }
                goto L_0x0484
            L_0x047f:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r5, (java.lang.Throwable) r2)
            L_0x0484:
                if (r6 == 0) goto L_0x0491
                r6.close()     // Catch:{ Exception -> 0x048a }
                goto L_0x0491
            L_0x048a:
                r0 = move-exception
                r2 = r0
                r9 = r18
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r9, (java.lang.Throwable) r2)
            L_0x0491:
                if (r7 == 0) goto L_0x049e
                r7.close()     // Catch:{ Exception -> 0x0497 }
                goto L_0x049e
            L_0x0497:
                r0 = move-exception
                r2 = r0
                r10 = r19
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r10, (java.lang.Throwable) r2)
            L_0x049e:
                r12.close()     // Catch:{ IOException -> 0x04a3 }
                goto L_0x0518
            L_0x04a3:
                r0 = move-exception
                r2 = r0
                r13 = r17
            L_0x04a7:
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r13, (java.lang.Throwable) r2)
                goto L_0x0518
            L_0x04ac:
                r0 = move-exception
                r13 = r17
                r9 = r18
                r10 = r19
                r2 = r0
                r16 = r4
                goto L_0x0536
            L_0x04b8:
                r0 = move-exception
                r13 = r17
                r9 = r18
                r10 = r19
                r2 = r0
                r16 = r4
                goto L_0x04eb
            L_0x04c3:
                r0 = move-exception
                r13 = r17
                r9 = r18
                r10 = r19
            L_0x04ca:
                r2 = r0
                goto L_0x02e4
            L_0x04cd:
                r0 = move-exception
                r13 = r17
                r9 = r18
                r10 = r19
                r2 = r0
                goto L_0x02f7
            L_0x04d7:
                r0 = move-exception
                r13 = r17
                r9 = r18
                r10 = r19
            L_0x04de:
                r2 = r0
                goto L_0x02f6
            L_0x04e1:
                r0 = move-exception
                r13 = r2
                r10 = r3
                r9 = r4
                goto L_0x04ca
            L_0x04e6:
                r0 = move-exception
                r13 = r2
                r10 = r3
                r9 = r4
                goto L_0x04de
            L_0x04eb:
                java.lang.String r4 = "Can't write snapshot request to server"
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0533 }
                if (r16 == 0) goto L_0x04fb
                r16.close()     // Catch:{ Exception -> 0x04f6 }
                goto L_0x04fb
            L_0x04f6:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r5, (java.lang.Throwable) r2)
            L_0x04fb:
                if (r6 == 0) goto L_0x0506
                r6.close()     // Catch:{ Exception -> 0x0501 }
                goto L_0x0506
            L_0x0501:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r9, (java.lang.Throwable) r2)
            L_0x0506:
                if (r7 == 0) goto L_0x0511
                r7.close()     // Catch:{ Exception -> 0x050c }
                goto L_0x0511
            L_0x050c:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r10, (java.lang.Throwable) r2)
            L_0x0511:
                r12.close()     // Catch:{ IOException -> 0x0515 }
                goto L_0x0518
            L_0x0515:
                r0 = move-exception
                r2 = r0
                goto L_0x04a7
            L_0x0518:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "sendSnapshot = "
                r2.append(r4)
                r2.append(r11)
                java.lang.String r2 = r2.toString()
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r2)
                r1.onSnapFinished(r3)
                r1.postSnapshot(r11)
                return
            L_0x0533:
                r0 = move-exception
                goto L_0x011a
            L_0x0536:
                if (r16 == 0) goto L_0x0541
                r16.close()     // Catch:{ Exception -> 0x053c }
                goto L_0x0541
            L_0x053c:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r5, (java.lang.Throwable) r3)
            L_0x0541:
                if (r6 == 0) goto L_0x054c
                r6.close()     // Catch:{ Exception -> 0x0547 }
                goto L_0x054c
            L_0x0547:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r9, (java.lang.Throwable) r3)
            L_0x054c:
                if (r7 == 0) goto L_0x0557
                r7.close()     // Catch:{ Exception -> 0x0552 }
                goto L_0x0557
            L_0x0552:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r10, (java.lang.Throwable) r3)
            L_0x0557:
                r12.close()     // Catch:{ IOException -> 0x055b }
                goto L_0x0560
            L_0x055b:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r13, (java.lang.Throwable) r3)
            L_0x0560:
                throw r2
            L_0x0561:
                java.lang.String r3 = "VisualizedAutoTrack server sent malformed message with snapshot request"
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r3, (java.lang.Throwable) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.sendSnapshot():void");
        }

        private byte[] slurp(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                sendSnapshot();
            }
        }

        public void start() {
        }

        private ViewCrawlerHandler(Context context, Looper looper, String str) {
            super(looper);
            this.mSnapshot = null;
            this.mProtocol = new EditProtocol(new ResourceReader.Ids(str, context));
            this.mLastImageHash = new StringBuilder();
            this.mUseGzip = true;
            this.mAppId = AppInfoUtils.getProcessName(context);
            this.mSDKVersion = SensorsDataAPI.sharedInstance().getSDKVersion();
        }
    }

    AbstractViewCrawler(Activity activity, String str, String str2, String str3, String str4) {
        this.mContext = activity.getApplicationContext();
        this.mFeatureCode = str2;
        EditState editState = new EditState();
        this.mEditState = editState;
        this.mType = str4;
        editState.add(activity);
        this.mLifecycleCallbacks = new LifecycleCallbacks();
        try {
            this.mPostUrl = URLDecoder.decode(str3, "UTF-8");
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        ((Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        try {
            this.mAppVersion = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            this.mAppVersion = "";
        }
        HandlerThread handlerThread = new HandlerThread(VisualizedAutoTrackViewCrawler.class.getCanonicalName(), 10);
        handlerThread.start();
        this.mMessageThreadHandler = new ViewCrawlerHandler(this.mContext, handlerThread.getLooper(), str);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public boolean isServiceRunning() {
        return this.mServiceRunning;
    }

    public void startUpdates() {
        try {
            if (!TextUtils.isEmpty(this.mFeatureCode) && !TextUtils.isEmpty(this.mPostUrl)) {
                ((Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
                this.mMessageThreadHandler.start();
                ViewCrawlerHandler viewCrawlerHandler = this.mMessageThreadHandler;
                viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(1));
                if (!this.mServiceRunning) {
                    FlutterUtils.visualizedConnectionStatusChanged();
                }
                this.mServiceRunning = true;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void stopUpdates(boolean z10) {
        if (z10) {
            try {
                this.mFeatureCode = null;
                this.mPostUrl = null;
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return;
            }
        }
        this.mMessageThreadHandler.removeMessages(1);
        ((Application) this.mContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        if (this.mServiceRunning) {
            FlutterUtils.visualizedConnectionStatusChanged();
            this.mServiceRunning = false;
        }
    }
}
