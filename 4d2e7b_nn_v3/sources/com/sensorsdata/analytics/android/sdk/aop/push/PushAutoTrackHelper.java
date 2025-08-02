package com.sensorsdata.analytics.android.sdk.aop.push;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.push.core.PushProcess;
import com.sensorsdata.analytics.android.sdk.push.utils.PushUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import org.json.JSONObject;

public class PushAutoTrackHelper {
    private static final String TAG = "SA.PushAutoTrackHelper";
    private static long lastPushClickTime;

    private static String getSFData(String str) {
        try {
            return new JSONObject(str).optString("sf_data");
        } catch (Exception unused) {
            SALog.i(TAG, "get sf_data failed");
            return null;
        }
    }

    private static void hookIntent(Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().hookIntent(intent);
                SALog.i(TAG, "hookIntent");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void hookIntentGetActivity(Context context, int i10, Intent intent, int i11) {
        hookIntent(intent);
    }

    public static void hookIntentGetActivityBundle(Context context, int i10, Intent intent, int i11, Bundle bundle) {
        hookIntent(intent);
    }

    public static void hookIntentGetBroadcast(Context context, int i10, Intent intent, int i11) {
        hookIntent(intent);
    }

    public static void hookIntentGetForegroundService(Context context, int i10, Intent intent, int i11) {
        hookIntent(intent);
    }

    public static void hookIntentGetService(Context context, int i10, Intent intent, int i11) {
        hookIntent(intent);
    }

    private static void hookPendingIntent(Intent intent, PendingIntent pendingIntent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().hookPendingIntent(intent, pendingIntent);
                SALog.i(TAG, "hookPendingIntent");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void hookPendingIntentGetActivity(PendingIntent pendingIntent, Context context, int i10, Intent intent, int i11) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetActivityBundle(PendingIntent pendingIntent, Context context, int i10, Intent intent, int i11, Bundle bundle) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetBroadcast(PendingIntent pendingIntent, Context context, int i10, Intent intent, int i11) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetForegroundService(PendingIntent pendingIntent, Context context, int i10, Intent intent, int i11) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetService(PendingIntent pendingIntent, Context context, int i10, Intent intent, int i11) {
        hookPendingIntent(intent, pendingIntent);
    }

    private static boolean isRepeatEvent() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SALog.i(TAG, "currentTime: " + elapsedRealtime + ",lastPushClickTime: " + lastPushClickTime);
        if (elapsedRealtime - lastPushClickTime <= 2000) {
            return true;
        }
        lastPushClickTime = elapsedRealtime;
        return false;
    }

    private static boolean isTrackPushEnabled() {
        try {
            if (!(SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) && AbstractSensorsDataAPI.getConfigOptions() != null) {
                if (AbstractSensorsDataAPI.getConfigOptions().isEnableTrackPush()) {
                    return true;
                }
            }
            SALog.i(TAG, "SDK or push disabled.");
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static void onBroadcastReceiver(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        onBroadcastServiceIntent(intent);
    }

    private static void onBroadcastServiceIntent(Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().onNotificationClick((Context) null, intent);
                SALog.i(TAG, "onBroadcastServiceIntent");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void onGeTuiNotificationClicked(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "gtNotificationMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                String str = (String) ReflectUtil.callMethod(obj, "getMessageId", new Object[0]);
                String str2 = (String) ReflectUtil.callMethod(obj, "getTitle", new Object[0]);
                String str3 = (String) ReflectUtil.callMethod(obj, "getContent", new Object[0]);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    PushProcess.getInstance().trackGTClickDelayed(str, str2, str3);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void onGeTuiReceiveMessageData(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "gtNotificationMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                byte[] bArr = (byte[]) ReflectUtil.callMethod(obj, "getPayload", new Object[0]);
                String str = (String) ReflectUtil.callMethod(obj, "getMessageId", new Object[0]);
                if (bArr != null && !TextUtils.isEmpty(str)) {
                    PushProcess.getInstance().trackReceiveMessageData(new String(bArr), str);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void onNewIntent(Object obj, Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                if (obj instanceof Activity) {
                    PushProcess.getInstance().onNotificationClick((Activity) obj, intent);
                    SALog.i(TAG, "onNewIntent");
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void onNotify(NotificationManager notificationManager, String str, int i10, Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().onNotify(str, i10, notification);
                SALog.i(TAG, "onNotify");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void onServiceStart(Service service, Intent intent, int i10) {
        onBroadcastServiceIntent(intent);
    }

    public static void onServiceStartCommand(Service service, Intent intent, int i10, int i11) {
        onBroadcastServiceIntent(intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r3 = new org.json.JSONObject(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onUMengActivityMessage(android.content.Intent r6) {
        /*
            java.lang.String r0 = "body"
            java.lang.String r1 = "SA.PushAutoTrackHelper"
            if (r6 != 0) goto L_0x000c
            java.lang.String r6 = "intent is null"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r6)
            return
        L_0x000c:
            boolean r2 = isTrackPushEnabled()
            if (r2 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r2 = r6.getStringExtra(r0)     // Catch:{ Exception -> 0x005f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0063
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x005f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x005f }
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0063
            java.lang.String r2 = "extra"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "title"
            java.lang.String r3 = r0.optString(r3)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "text"
            java.lang.String r0 = r0.optString(r4)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "message_source"
            java.lang.String r6 = r6.getStringExtra(r4)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = getSFData(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r5 = "UMeng"
            trackNotificationOpenedEvent(r4, r3, r0, r5, r6)     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = "onUMengActivityMessage is called, title is %s, content is %s, extras is %s"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x005f }
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x005f }
            r3 = 1
            r4[r3] = r0     // Catch:{ Exception -> 0x005f }
            r0 = 2
            r4[r0] = r2     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = java.lang.String.format(r6, r4)     // Catch:{ Exception -> 0x005f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r6 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onUMengActivityMessage(android.content.Intent):void");
    }

    public static void onUMengNotificationClick(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "UMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                JSONObject jSONObject = (JSONObject) ReflectUtil.callMethod(obj, "getRaw", new Object[0]);
                if (jSONObject == null) {
                    SALog.i(TAG, "onUMengNotificationClick:raw is null");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("body");
                if (optJSONObject != null) {
                    String optString = jSONObject.optString("extra");
                    String optString2 = optJSONObject.optString("title");
                    String optString3 = optJSONObject.optString("text");
                    trackNotificationOpenedEvent(getSFData(optString), optString2, optString3, "UMeng", (String) null);
                    SALog.i(TAG, String.format("onUMengNotificationClick is called, title is %s, content is %s, extras is %s", new Object[]{optString2, optString3, optString}));
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void trackGeTuiNotificationClicked(String str, String str2, String str3, long j10) {
        trackNotificationOpenedEvent(str3, str, str2, "GeTui", (String) null, j10);
    }

    public static void trackJPushAppOpenNotification(String str, String str2, String str3, String str4) {
        if (isTrackPushEnabled()) {
            SALog.i(TAG, String.format("trackJPushAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", new Object[]{str2, str3, str, str4, "JPush"}));
            trackNotificationOpenedEvent(getSFData(str), str2, str3, "JPush", str4);
        }
    }

    public static void trackJPushOpenActivity(Intent intent) {
        String str;
        if (intent != null && isTrackPushEnabled()) {
            JSONObject jSONObject = null;
            if (intent.getData() != null) {
                str = intent.getData().toString();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                str = intent.getExtras().getString("JMessageExtra");
            }
            SALog.i(TAG, "trackJPushOpenActivity is called, Intent data is " + str);
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception unused) {
                    try {
                        SALog.i(TAG, "Failed to construct JSON");
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                        return;
                    }
                }
                if (jSONObject != null) {
                    String optString = jSONObject.optString("n_title");
                    String optString2 = jSONObject.optString("n_content");
                    String optString3 = jSONObject.optString("n_extras");
                    String jPushSDKName = PushUtils.getJPushSDKName((byte) jSONObject.optInt("rom_type"));
                    SALog.i(TAG, String.format("trackJPushOpenActivity is called, title is %s, content is %s, extras is %s, appPushChannel is %s", new Object[]{optString, optString2, optString3, jPushSDKName}));
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if (!TextUtils.isEmpty(jPushSDKName)) {
                            trackNotificationOpenedEvent(getSFData(optString3), optString, optString2, "JPush", jPushSDKName);
                        }
                    }
                }
            }
        }
    }

    public static void trackMeizuAppOpenNotification(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (isTrackPushEnabled()) {
            SALog.i(TAG, String.format("trackMeizuAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", new Object[]{str2, str3, str, "Meizu", str4}));
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                try {
                    SALog.i(TAG, "Failed to construct JSON");
                    jSONObject = null;
                } catch (Exception e10) {
                    try {
                        SALog.printStackTrace(e10);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                        return;
                    }
                }
            }
            if (jSONObject != null && jSONObject.has("JMessageExtra")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("JMessageExtra");
                if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("m_content")) == null)) {
                    str = optJSONObject.optString("n_extras");
                }
                str4 = "JPush";
            }
            trackNotificationOpenedEvent(getSFData(str), str2, str3, str4, "Meizu");
        }
    }

    public static void trackNotificationOpenedEvent(String str, String str2, String str3, String str4, String str5) {
        trackNotificationOpenedEvent(str, str2, str3, str4, str5, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void trackNotificationOpenedEvent(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, long r9) {
        /*
            java.lang.String r0 = "sf_plan_id"
            boolean r1 = isRepeatEvent()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r2 = "SA.PushAutoTrackHelper"
            if (r1 == 0) goto L_0x0029
            java.lang.String r9 = "$AppPushClick Repeat trigger, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s"
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0026 }
            r0 = 0
            r10[r0] = r5     // Catch:{ Exception -> 0x0026 }
            r5 = 1
            r10[r5] = r6     // Catch:{ Exception -> 0x0026 }
            r5 = 2
            r10[r5] = r4     // Catch:{ Exception -> 0x0026 }
            r4 = 3
            r10[r4] = r8     // Catch:{ Exception -> 0x0026 }
            r4 = 4
            r10[r4] = r7     // Catch:{ Exception -> 0x0026 }
            java.lang.String r4 = java.lang.String.format(r9, r10)     // Catch:{ Exception -> 0x0026 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0026 }
            return
        L_0x0026:
            r4 = move-exception
            goto L_0x0122
        L_0x0029:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "$app_push_msg_title"
            r1.put(r3, r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "$app_push_msg_content"
            r1.put(r3, r6)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "$app_push_service_name"
            r1.put(r3, r7)     // Catch:{ Exception -> 0x0026 }
            boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0026 }
            if (r7 != 0) goto L_0x004c
            java.lang.String r7 = "$app_push_channel"
            java.lang.String r8 = r8.toUpperCase()     // Catch:{ Exception -> 0x0026 }
            r1.put(r7, r8)     // Catch:{ Exception -> 0x0026 }
        L_0x004c:
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0072 }
            if (r7 != 0) goto L_0x0075
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006c }
            r7.<init>()     // Catch:{ Exception -> 0x006c }
            java.lang.String r8 = "sfData is "
            r7.append(r8)     // Catch:{ Exception -> 0x006c }
            r7.append(r4)     // Catch:{ Exception -> 0x006c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x006c }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x006c }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x006c }
            r7.<init>(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x0076
        L_0x006c:
            java.lang.String r4 = "Failed to construct JSON"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0075
        L_0x0072:
            r4 = move-exception
            goto L_0x0100
        L_0x0075:
            r7 = 0
        L_0x0076:
            if (r7 == 0) goto L_0x0103
            boolean r4 = r7.has(r0)     // Catch:{ Exception -> 0x0072 }
            if (r4 == 0) goto L_0x0103
            java.lang.String r4 = "$sf_msg_title"
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_msg_content"
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_msg_id"
            java.lang.String r5 = "sf_msg_id"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_plan_id"
            java.lang.Object r5 = r7.opt(r0)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_audience_id"
            java.lang.String r5 = "sf_audience_id"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_link_url"
            java.lang.String r5 = "sf_link_url"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_plan_strategy_id"
            java.lang.String r5 = "sf_plan_strategy_id"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_plan_type"
            java.lang.String r5 = "sf_plan_type"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_strategy_unit_id"
            java.lang.String r5 = "sf_strategy_unit_id"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_enter_plan_time"
            java.lang.String r5 = "sf_enter_plan_time"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_channel_id"
            java.lang.String r5 = "sf_channel_id"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_channel_category"
            java.lang.String r5 = "sf_channel_category"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "$sf_channel_service_name"
            java.lang.String r5 = "sf_channel_service_name"
            java.lang.Object r5 = r7.opt(r5)     // Catch:{ Exception -> 0x0072 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0103
        L_0x0100:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ Exception -> 0x0026 }
        L_0x0103:
            r4 = 0
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0118
            java.lang.String r4 = "$time"
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0114 }
            r5.<init>(r9)     // Catch:{ Exception -> 0x0114 }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0114 }
            goto L_0x0118
        L_0x0114:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ Exception -> 0x0026 }
        L_0x0118:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = "$AppPushClick"
            r4.track(r5, r1)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0125
        L_0x0122:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.trackNotificationOpenedEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    public static void onNotify(NotificationManager notificationManager, int i10, Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                onNotify(notificationManager, (String) null, i10, notification);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }
}
