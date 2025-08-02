package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.service.notification.StatusBarNotification;
import java.util.Map;
import java.util.TreeMap;

abstract class y0 {

    /* renamed from: a  reason: collision with root package name */
    static final String f11110a = Integer.toString(49);

    static void a(Context context, int i10) {
        try {
            c(context, i10);
        } catch (Throwable unused) {
            b(context, i10);
        }
    }

    static void b(Context context, int i10) {
        v3 n10 = v3.n(context);
        Cursor cursor = null;
        try {
            cursor = n10.b("notification", new String[]{"android_notification_id"}, v3.z().toString(), (String[]) null, (String) null, (String) null, "_id", e() + i10);
            int count = (cursor.getCount() - d()) + i10;
            if (count >= 1) {
                do {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    o3.q1(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                    count--;
                } while (count > 0);
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (!cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    static void c(Context context, int i10) {
        StatusBarNotification[] d10 = y3.d(context);
        int length = (d10.length - d()) + i10;
        if (length >= 1) {
            TreeMap treeMap = new TreeMap();
            for (StatusBarNotification statusBarNotification : d10) {
                if (!f(statusBarNotification)) {
                    treeMap.put(Long.valueOf(statusBarNotification.getNotification().when), Integer.valueOf(statusBarNotification.getId()));
                }
            }
            for (Map.Entry value : treeMap.entrySet()) {
                o3.q1(((Integer) value.getValue()).intValue());
                length--;
                if (length <= 0) {
                    return;
                }
            }
        }
    }

    private static int d() {
        return 49;
    }

    private static String e() {
        return f11110a;
    }

    static boolean f(StatusBarNotification statusBarNotification) {
        if ((statusBarNotification.getNotification().flags & 512) != 0) {
            return true;
        }
        return false;
    }
}
