package com.onesignal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class y3 {
    public static boolean a(Context context, String str) {
        if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        NotificationChannel a10 = i(context).getNotificationChannel(str);
        if (a10 == null || a10.getImportance() != 0) {
            return true;
        }
        return false;
    }

    static void b(Context context, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
            NotificationManagerCompat.from(context).notify(statusBarNotification.getId(), Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification()).setGroup("os_group_undefined").setOnlyAlertOnce(true).build());
        }
    }

    static ArrayList c(Context context) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : d(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean f10 = y0.f(statusBarNotification);
            if (notification.getGroup() == null || notification.getGroup().equals(g())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!f10 && z10) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    static StatusBarNotification[] d(Context context) {
        try {
            return i(context).getActiveNotifications();
        } catch (Throwable unused) {
            return new StatusBarNotification[0];
        }
    }

    static Integer e(Context context) {
        int i10 = 0;
        for (StatusBarNotification statusBarNotification : d(context)) {
            if (!NotificationCompat.isGroupSummary(statusBarNotification.getNotification()) && "os_group_undefined".equals(statusBarNotification.getNotification().getGroup())) {
                i10++;
            }
        }
        return Integer.valueOf(i10);
    }

    static int f() {
        return -718463522;
    }

    static String g() {
        return "os_group_undefined";
    }

    static Integer h(v3 v3Var, String str, boolean z10) {
        String str2;
        String[] strArr;
        if (z10) {
            str2 = "group_id IS NULL";
        } else {
            str2 = "group_id = ?";
        }
        String str3 = str2 + " AND dismissed = 0 AND opened = 0 AND is_summary = 0";
        if (z10) {
            strArr = null;
        } else {
            strArr = new String[]{str};
        }
        Cursor b10 = v3Var.b("notification", (String[]) null, str3, strArr, (String) null, (String) null, "created_time DESC", "1");
        if (!b10.moveToFirst()) {
            b10.close();
            return null;
        }
        Integer valueOf = Integer.valueOf(b10.getInt(b10.getColumnIndex("android_notification_id")));
        b10.close();
        return valueOf;
    }

    static NotificationManager i(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }
}
