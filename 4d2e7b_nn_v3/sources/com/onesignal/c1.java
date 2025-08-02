package com.onesignal;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.o3;
import org.json.JSONException;
import org.json.JSONObject;

abstract class c1 {
    static void a(Context context, v3 v3Var, String str) {
        Integer b10 = b(v3Var, str);
        boolean equals = str.equals(y3.g());
        NotificationManager i10 = y3.i(context);
        Integer h10 = y3.h(v3Var, str, equals);
        if (h10 == null) {
            return;
        }
        if (o3.P()) {
            if (equals) {
                b10 = Integer.valueOf(y3.f());
            }
            if (b10 != null) {
                i10.cancel(b10.intValue());
                return;
            }
            return;
        }
        o3.q1(h10.intValue());
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer b(com.onesignal.u3 r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "android_notification_id"
            java.lang.String r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1"
            java.lang.String[] r5 = new java.lang.String[]{r12}
            r9 = 0
            java.lang.String r2 = "notification"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0048 }
            r7 = 0
            r8 = 0
            r6 = 0
            r1 = r11
            android.database.Cursor r11 = r1.h(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x002f
            r11.close()     // Catch:{ all -> 0x002a }
            boolean r12 = r11.isClosed()
            if (r12 != 0) goto L_0x0029
            r11.close()
        L_0x0029:
            return r9
        L_0x002a:
            r0 = move-exception
            r10 = r9
            r9 = r11
            r11 = r10
            goto L_0x004a
        L_0x002f:
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x002a }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x002a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x002a }
            r11.close()     // Catch:{ all -> 0x002a }
            boolean r12 = r11.isClosed()
            if (r12 != 0) goto L_0x006c
            r11.close()
            goto L_0x006c
        L_0x0048:
            r0 = move-exception
            r11 = r9
        L_0x004a:
            com.onesignal.o3$v r1 = com.onesignal.o3.v.ERROR     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r2.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r3 = "Error getting android notification id for summary notification group: "
            r2.append(r3)     // Catch:{ all -> 0x006d }
            r2.append(r12)     // Catch:{ all -> 0x006d }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x006d }
            com.onesignal.o3.b(r1, r12, r0)     // Catch:{ all -> 0x006d }
            if (r9 == 0) goto L_0x006b
            boolean r12 = r9.isClosed()
            if (r12 != 0) goto L_0x006b
            r9.close()
        L_0x006b:
            r9 = r11
        L_0x006c:
            return r9
        L_0x006d:
            r11 = move-exception
            if (r9 == 0) goto L_0x0079
            boolean r12 = r9.isClosed()
            if (r12 != 0) goto L_0x0079
            r9.close()
        L_0x0079:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.c1.b(com.onesignal.u3, java.lang.String):java.lang.Integer");
    }

    private static Cursor c(Context context, u3 u3Var, String str, boolean z10) {
        String str2;
        Cursor h10 = u3Var.h("notification", new String[]{"android_notification_id", "created_time", "full_data"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, "_id DESC");
        int count = h10.getCount();
        if (count == 0 && !str.equals(y3.g())) {
            h10.close();
            Integer b10 = b(u3Var, str);
            if (b10 == null) {
                return h10;
            }
            y3.i(context).cancel(b10.intValue());
            ContentValues contentValues = new ContentValues();
            if (z10) {
                str2 = "dismissed";
            } else {
                str2 = "opened";
            }
            contentValues.put(str2, 1);
            u3Var.a("notification", contentValues, "android_notification_id = " + b10, (String[]) null);
            return h10;
        } else if (count == 1) {
            h10.close();
            if (b(u3Var, str) == null) {
                return h10;
            }
            d(context, str);
            return h10;
        } else {
            try {
                h10.moveToFirst();
                Long valueOf = Long.valueOf(h10.getLong(h10.getColumnIndex("created_time")));
                String string = h10.getString(h10.getColumnIndex("full_data"));
                h10.close();
                if (b(u3Var, str) == null) {
                    return h10;
                }
                i2 i2Var = new i2(context);
                i2Var.y(true);
                i2Var.z(valueOf);
                i2Var.q(new JSONObject(string));
                v.N(i2Var);
                return h10;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    private static void d(Context context, String str) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = v3.n(context).h("notification", OSNotificationRestoreWorkManager.f10295a, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, (String) null, (String) null, (String) null);
            OSNotificationRestoreWorkManager.e(context, cursor, 0);
            if (cursor == null || cursor.isClosed()) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    static void e(Context context, u3 u3Var, int i10) {
        String[] strArr = {FirebaseAnalytics.Param.GROUP_ID};
        Cursor h10 = u3Var.h("notification", strArr, "android_notification_id = " + i10, (String[]) null, (String) null, (String) null, (String) null);
        if (h10.moveToFirst()) {
            String string = h10.getString(h10.getColumnIndex(FirebaseAnalytics.Param.GROUP_ID));
            h10.close();
            if (string != null) {
                f(context, u3Var, string, true);
                return;
            }
            return;
        }
        h10.close();
    }

    static void f(Context context, u3 u3Var, String str, boolean z10) {
        try {
            Cursor c10 = c(context, u3Var, str, z10);
            if (c10 != null && !c10.isClosed()) {
                c10.close();
            }
        } catch (Throwable th) {
            o3.b(o3.v.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }
}
