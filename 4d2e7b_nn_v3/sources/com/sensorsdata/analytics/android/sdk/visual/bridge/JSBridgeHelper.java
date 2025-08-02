package com.sensorsdata.analytics.android.sdk.visual.bridge;

import android.text.TextUtils;
import android.view.View;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JSBridgeHelper implements WebViewJavascriptBridge {
    private static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    private static final String CALL_TYPE_GET_VISUAL_PROPERTIES = "getJSVisualProperties";
    /* access modifiers changed from: private */
    public Map<String, OnBridgeCallback> mCallbacks = new HashMap();
    private SAJSListener mSAJSListener;

    /* access modifiers changed from: private */
    public static void invokeWebViewLoad(View view, String str, Object[] objArr, Class[] clsArr) {
        try {
            view.getClass().getMethod(str, clsArr).invoke(view, objArr);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void addSAJSListener() {
        if (this.mSAJSListener == null) {
            this.mSAJSListener = new SAJSListener() {
                public void onReceiveJSMessage(WeakReference<View> weakReference, String str) {
                    OnBridgeCallback onBridgeCallback;
                    JSONObject optJSONObject;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (TextUtils.equals(JSBridgeHelper.CALL_TYPE_GET_VISUAL_PROPERTIES, jSONObject.optString("callType"))) {
                            String optString = jSONObject.optString(Constants.MessagePayloadKeys.MSGID_SERVER);
                            if (!TextUtils.isEmpty(optString) && (onBridgeCallback = (OnBridgeCallback) JSBridgeHelper.this.mCallbacks.remove(optString)) != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                onBridgeCallback.onCallBack(optJSONObject.toString());
                            }
                        }
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            };
            SensorsDataAPI.sharedInstance().addSAJSListener(this.mSAJSListener);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sendToWeb(final android.view.View r6, final java.lang.String r7, java.lang.Object r8, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            com.sensorsdata.analytics.android.sdk.visual.bridge.JSRequest r0 = new com.sensorsdata.analytics.android.sdk.visual.bridge.JSRequest     // Catch:{ Exception -> 0x0030 }
            r0.<init>()     // Catch:{ Exception -> 0x0030 }
            r0.methodName = r7     // Catch:{ Exception -> 0x0030 }
            if (r9 == 0) goto L_0x0032
            java.lang.String r1 = "JAVA_CB_%s"
            long r2 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ Exception -> 0x0030 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0030 }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0030 }
            r4 = 0
            r3[r4] = r2     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0030 }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback> r2 = r5.mCallbacks     // Catch:{ Exception -> 0x0030 }
            r2.put(r1, r9)     // Catch:{ Exception -> 0x0030 }
            r0.messageId = r1     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x002e:
            r6 = move-exception
            goto L_0x0079
        L_0x0030:
            r6 = move-exception
            goto L_0x0074
        L_0x0032:
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0030 }
            if (r9 == 0) goto L_0x0047
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0030 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0030 }
            if (r9 != 0) goto L_0x0064
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0030 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0030 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0065
        L_0x0047:
            boolean r9 = r8 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0030 }
            if (r9 == 0) goto L_0x0064
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0030 }
            r9.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "message_id"
            java.lang.String r0 = r0.messageId     // Catch:{ Exception -> 0x0030 }
            r9.put(r1, r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = "platform"
            java.lang.String r1 = "Android"
            r9.put(r0, r1)     // Catch:{ Exception -> 0x0030 }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ Exception -> 0x0030 }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r8, r9)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            if (r9 != 0) goto L_0x0069
            monitor-exit(r5)
            return
        L_0x0069:
            if (r6 == 0) goto L_0x0077
            com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper$2 r8 = new com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper$2     // Catch:{ Exception -> 0x0030 }
            r8.<init>(r7, r9, r6)     // Catch:{ Exception -> 0x0030 }
            r6.post(r8)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0077
        L_0x0074:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)     // Catch:{ all -> 0x002e }
        L_0x0077:
            monitor-exit(r5)
            return
        L_0x0079:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper.sendToWeb(android.view.View, java.lang.String, java.lang.Object, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback):void");
    }

    public void sendToWeb(View view, String str, Object obj) {
        sendToWeb(view, str, obj, (OnBridgeCallback) null);
    }
}
