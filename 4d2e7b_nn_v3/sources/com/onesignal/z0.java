package com.onesignal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.o3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class z0 {
    private static void a(JSONArray jSONArray, String str, v3 v3Var) {
        Cursor h10 = v3Var.h("notification", new String[]{"full_data"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, (String) null);
        if (h10.getCount() > 1) {
            h10.moveToFirst();
            do {
                try {
                    jSONArray.put(new JSONObject(h10.getString(h10.getColumnIndex("full_data"))));
                } catch (JSONException unused) {
                    o3.v vVar = o3.v.ERROR;
                    o3.a(vVar, "Could not parse JSON of sub notification in group: " + str);
                }
            } while (h10.moveToNext());
        }
        h10.close();
    }

    private static void b(Context context, v3 v3Var, String str) {
        if (str != null) {
            c1.a(context, v3Var, str);
        } else if (y3.e(context).intValue() < 1) {
            y3.i(context).cancel(y3.f());
        }
    }

    private static void c(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra("androidNotificationId", 0));
            if (Build.VERSION.SDK_INT < 31) {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        }
    }

    private static boolean d(Intent intent) {
        if (intent.hasExtra("onesignalData") || intent.hasExtra("summary") || intent.hasExtra("androidNotificationId")) {
            return true;
        }
        return false;
    }

    private static void e(Context context, Intent intent, v3 v3Var, boolean z10) {
        String str;
        String stringExtra = intent.getStringExtra("summary");
        String[] strArr = null;
        if (stringExtra != null) {
            boolean equals = stringExtra.equals(y3.g());
            if (equals) {
                str = "group_id IS NULL";
            } else {
                strArr = new String[]{stringExtra};
                str = "group_id = ?";
            }
            if (!z10 && !o3.P()) {
                String valueOf = String.valueOf(y3.h(v3Var, stringExtra, equals));
                str = str + " AND android_notification_id = ?";
                strArr = equals ? new String[]{valueOf} : new String[]{stringExtra, valueOf};
            }
        } else {
            str = "android_notification_id = " + intent.getIntExtra("androidNotificationId", 0);
        }
        b(context, v3Var, stringExtra);
        v3Var.a("notification", f(intent), str, strArr);
        l.c(v3Var, context);
    }

    private static ContentValues f(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", 1);
        } else {
            contentValues.put("opened", 1);
        }
        return contentValues;
    }

    static void g(Context context, Intent intent) {
        if (d(intent)) {
            if (context != null) {
                o3.L0(context.getApplicationContext());
            }
            c(context, intent);
            h(context, intent);
        }
    }

    static void h(Context context, Intent intent) {
        j2 j2Var;
        String stringExtra;
        v3 n10 = v3.n(context);
        String stringExtra2 = intent.getStringExtra("summary");
        boolean booleanExtra = intent.getBooleanExtra("dismissed", false);
        if (!booleanExtra) {
            j2Var = i(context, intent, n10, stringExtra2);
            if (j2Var == null) {
                return;
            }
        } else {
            j2Var = null;
        }
        e(context, intent, n10, booleanExtra);
        if (stringExtra2 == null && (stringExtra = intent.getStringExtra("grp")) != null) {
            c1.f(context, n10, stringExtra, booleanExtra);
        }
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "processIntent from context: " + context + " and intent: " + intent);
        if (intent.getExtras() != null) {
            o3.d1(vVar, "processIntent intent extras: " + intent.getExtras().toString());
        }
        if (booleanExtra) {
            return;
        }
        if (!(context instanceof Activity)) {
            o3.v vVar2 = o3.v.ERROR;
            o3.d1(vVar2, "NotificationOpenedProcessor processIntent from an non Activity context: " + context);
            return;
        }
        o3.E0((Activity) context, j2Var.a(), h2.b(j2Var.b()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.onesignal.j2 i(android.content.Context r7, android.content.Intent r8, com.onesignal.v3 r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "androidNotificationId"
            java.lang.String r1 = "onesignalData"
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r4 = r8.getStringExtra(r1)     // Catch:{ JSONException -> 0x0051 }
            r3.<init>(r4)     // Catch:{ JSONException -> 0x0051 }
            boolean r4 = r7 instanceof android.app.Activity     // Catch:{ JSONException -> 0x0029 }
            if (r4 != 0) goto L_0x002b
            com.onesignal.o3$v r4 = com.onesignal.o3.v.ERROR     // Catch:{ JSONException -> 0x0029 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0029 }
            r5.<init>()     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r6 = "NotificationOpenedProcessor processIntent from an non Activity context: "
            r5.append(r6)     // Catch:{ JSONException -> 0x0029 }
            r5.append(r7)     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r7 = r5.toString()     // Catch:{ JSONException -> 0x0029 }
            com.onesignal.o3.d1(r4, r7)     // Catch:{ JSONException -> 0x0029 }
            goto L_0x0034
        L_0x0029:
            r7 = move-exception
            goto L_0x0053
        L_0x002b:
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ JSONException -> 0x0029 }
            boolean r7 = com.onesignal.u1.b(r7, r3)     // Catch:{ JSONException -> 0x0029 }
            if (r7 == 0) goto L_0x0034
            return r2
        L_0x0034:
            r7 = 0
            int r7 = r8.getIntExtra(r0, r7)     // Catch:{ JSONException -> 0x0029 }
            r3.put(r0, r7)     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x0029 }
            r8.putExtra(r1, r7)     // Catch:{ JSONException -> 0x0029 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r8 = r8.getStringExtra(r1)     // Catch:{ JSONException -> 0x0029 }
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0029 }
            org.json.JSONArray r2 = com.onesignal.l0.g(r7)     // Catch:{ JSONException -> 0x0029 }
            goto L_0x0056
        L_0x0051:
            r7 = move-exception
            r3 = r2
        L_0x0053:
            r7.printStackTrace()
        L_0x0056:
            if (r10 == 0) goto L_0x005b
            a(r2, r10, r9)
        L_0x005b:
            com.onesignal.j2 r7 = new com.onesignal.j2
            r7.<init>(r2, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z0.i(android.content.Context, android.content.Intent, com.onesignal.v3, java.lang.String):com.onesignal.j2");
    }
}
