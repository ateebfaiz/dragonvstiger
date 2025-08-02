package com.onesignal;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.j;
import com.blankj.utilcode.util.h;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.onesignal.o3;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class x0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11100a = Pattern.compile("^([A-Fa-f0-9]{8})$");

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r7, android.app.NotificationManager r8, org.json.JSONObject r9) {
        /*
            java.lang.String r0 = "chnl"
            java.lang.Object r0 = r9.opt(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0012
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            goto L_0x0015
        L_0x0012:
            r1 = r0
            org.json.JSONObject r1 = (org.json.JSONObject) r1
        L_0x0015:
            java.lang.String r0 = "id"
            java.lang.String r2 = "fcm_fallback_notification_channel"
            java.lang.String r0 = r1.optString(r0, r2)
            java.lang.String r3 = "miscellaneous"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r2 = r0
        L_0x0027:
            java.lang.String r0 = "langs"
            boolean r3 = r1.has(r0)
            if (r3 == 0) goto L_0x0046
            org.json.JSONObject r0 = r1.getJSONObject(r0)
            oa.a r3 = oa.a.a()
            java.lang.String r3 = r3.b()
            boolean r4 = r0.has(r3)
            if (r4 == 0) goto L_0x0046
            org.json.JSONObject r0 = r0.optJSONObject(r3)
            goto L_0x0047
        L_0x0046:
            r0 = r1
        L_0x0047:
            java.lang.String r3 = "nm"
            java.lang.String r4 = "Miscellaneous"
            java.lang.String r3 = r0.optString(r3, r4)
            java.lang.String r4 = "pri"
            r5 = 6
            int r4 = r9.optInt(r4, r5)
            int r4 = f(r4)
            android.app.NotificationChannel r3 = com.blankj.utilcode.util.h.a(r2, r3, r4)
            java.lang.String r4 = "dscr"
            r5 = 0
            java.lang.String r4 = r0.optString(r4, r5)
            r3.setDescription(r4)
            java.lang.String r4 = "grp_id"
            boolean r6 = r1.has(r4)
            if (r6 == 0) goto L_0x0084
            java.lang.String r1 = r1.optString(r4)
            java.lang.String r4 = "grp_nm"
            java.lang.String r0 = r0.optString(r4)
            android.app.NotificationChannelGroup r0 = com.onesignal.o0.a(r1, r0)
            r8.createNotificationChannelGroup(r0)
            r3.setGroup(r1)
        L_0x0084:
            java.lang.String r0 = "ledc"
            boolean r1 = r9.has(r0)
            if (r1 == 0) goto L_0x00bc
            java.lang.String r0 = r9.optString(r0)
            java.util.regex.Pattern r1 = f11100a
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x00a5
            com.onesignal.o3$v r0 = com.onesignal.o3.v.WARN
            java.lang.String r1 = "OneSignal LED Color Settings: ARGB Hex value incorrect format (E.g: FF9900FF)"
            com.onesignal.o3.a(r0, r1)
            java.lang.String r0 = "FFFFFFFF"
        L_0x00a5:
            java.math.BigInteger r1 = new java.math.BigInteger     // Catch:{ all -> 0x00b4 }
            r4 = 16
            r1.<init>(r0, r4)     // Catch:{ all -> 0x00b4 }
            int r0 = r1.intValue()     // Catch:{ all -> 0x00b4 }
            r3.setLightColor(r0)     // Catch:{ all -> 0x00b4 }
            goto L_0x00bc
        L_0x00b4:
            r0 = move-exception
            com.onesignal.o3$v r1 = com.onesignal.o3.v.ERROR
            java.lang.String r4 = "Couldn't convert ARGB Hex value to BigInteger:"
            com.onesignal.o3.b(r1, r4, r0)
        L_0x00bc:
            java.lang.String r0 = "led"
            r1 = 1
            int r0 = r9.optInt(r0, r1)
            r4 = 0
            if (r0 != r1) goto L_0x00c8
            r0 = r1
            goto L_0x00c9
        L_0x00c8:
            r0 = r4
        L_0x00c9:
            r3.enableLights(r0)
            java.lang.String r0 = "vib_pt"
            boolean r0 = r9.has(r0)
            if (r0 == 0) goto L_0x00dd
            long[] r0 = com.onesignal.OSUtils.Q(r9)
            if (r0 == 0) goto L_0x00dd
            r3.setVibrationPattern(r0)
        L_0x00dd:
            java.lang.String r0 = "vib"
            int r0 = r9.optInt(r0, r1)
            if (r0 != r1) goto L_0x00e7
            r0 = r1
            goto L_0x00e8
        L_0x00e7:
            r0 = r4
        L_0x00e8:
            r3.enableVibration(r0)
            java.lang.String r0 = "sound"
            boolean r6 = r9.has(r0)
            if (r6 == 0) goto L_0x0114
            java.lang.String r0 = r9.optString(r0, r5)
            android.net.Uri r7 = com.onesignal.OSUtils.n(r7, r0)
            if (r7 == 0) goto L_0x0101
            r3.setSound(r7, r5)
            goto L_0x0114
        L_0x0101:
            java.lang.String r7 = "null"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0111
            java.lang.String r7 = "nil"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0114
        L_0x0111:
            r3.setSound(r5, r5)
        L_0x0114:
            java.lang.String r7 = "vis"
            int r7 = r9.optInt(r7, r4)
            r3.setLockscreenVisibility(r7)
            java.lang.String r7 = "bdg"
            int r7 = r9.optInt(r7, r1)
            if (r7 != r1) goto L_0x0127
            r7 = r1
            goto L_0x0128
        L_0x0127:
            r7 = r4
        L_0x0128:
            r3.setShowBadge(r7)
            java.lang.String r7 = "bdnd"
            int r7 = r9.optInt(r7, r4)
            if (r7 != r1) goto L_0x0134
            goto L_0x0135
        L_0x0134:
            r1 = r4
        L_0x0135:
            r3.setBypassDnd(r1)
            com.onesignal.o3$v r7 = com.onesignal.o3.v.VERBOSE
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Creating notification channel with channel:\n"
            r9.append(r0)
            java.lang.String r0 = r3.toString()
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.onesignal.o3.d1(r7, r9)
            r8.createNotificationChannel(r3)     // Catch:{ IllegalArgumentException -> 0x0156 }
            goto L_0x015a
        L_0x0156:
            r7 = move-exception
            r7.printStackTrace()
        L_0x015a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x0.a(android.content.Context, android.app.NotificationManager, org.json.JSONObject):java.lang.String");
    }

    private static String b(NotificationManager notificationManager) {
        NotificationChannel a10 = h.a(CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL, "Miscellaneous", 3);
        a10.enableLights(true);
        a10.enableVibration(true);
        notificationManager.createNotificationChannel(a10);
        return CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL;
    }

    static String c(i2 i2Var) {
        if (Build.VERSION.SDK_INT < 26) {
            return CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL;
        }
        Context d10 = i2Var.d();
        JSONObject e10 = i2Var.e();
        NotificationManager i10 = y3.i(d10);
        if (i2Var.n()) {
            return d(i10);
        }
        if (e10.has("oth_chnl")) {
            String optString = e10.optString("oth_chnl");
            if (i10.getNotificationChannel(optString) != null) {
                return optString;
            }
        }
        if (!e10.has("chnl")) {
            return b(i10);
        }
        try {
            return a(d10, i10, e10);
        } catch (JSONException e11) {
            o3.b(o3.v.ERROR, "Could not create notification channel due to JSON payload error!", e11);
            return CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL;
        }
    }

    private static String d(NotificationManager notificationManager) {
        notificationManager.createNotificationChannel(h.a("restored_OS_notifications", "Restored", 2));
        return "restored_OS_notifications";
    }

    private static List e(NotificationManager notificationManager) {
        try {
            return notificationManager.getNotificationChannels();
        } catch (NullPointerException e10) {
            o3.v vVar = o3.v.ERROR;
            o3.d1(vVar, "Error when trying to delete notification channel: " + e10.getMessage());
            return null;
        } catch (RuntimeException e11) {
            if (i.a(e11.getCause())) {
                return null;
            }
            throw e11;
        }
    }

    private static int f(int i10) {
        if (i10 > 9) {
            return 5;
        }
        if (i10 > 7) {
            return 4;
        }
        if (i10 > 5) {
            return 3;
        }
        if (i10 > 3) {
            return 2;
        }
        return i10 > 1 ? 1 : 0;
    }

    static void g(Context context, JSONArray jSONArray) {
        List<Object> e10;
        if (Build.VERSION.SDK_INT >= 26 && jSONArray != null && jSONArray.length() != 0) {
            NotificationManager i10 = y3.i(context);
            HashSet hashSet = new HashSet();
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                try {
                    hashSet.add(a(context, i10, jSONArray.getJSONObject(i11)));
                } catch (JSONException e11) {
                    o3.b(o3.v.ERROR, "Could not create notification channel due to JSON payload error!", e11);
                }
            }
            if (!hashSet.isEmpty() && (e10 = e(i10)) != null) {
                for (Object a10 : e10) {
                    String a11 = j.a(a10).getId();
                    if (a11.startsWith("OS_") && !hashSet.contains(a11)) {
                        i10.deleteNotificationChannel(a11);
                    }
                }
            }
        }
    }
}
