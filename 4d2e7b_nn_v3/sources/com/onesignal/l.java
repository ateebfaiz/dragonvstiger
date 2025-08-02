package com.onesignal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.onesignal.o3;
import ra.b;
import ra.c;

abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f10747a = -1;

    private static boolean a(Context context) {
        int i10 = f10747a;
        if (i10 == -1) {
            ApplicationInfo a10 = j.f10703a.a(context);
            if (a10 == null) {
                f10747a = 0;
                o3.a(o3.v.ERROR, "Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.");
                return false;
            }
            Bundle bundle = a10.metaData;
            if (bundle != null) {
                f10747a = "DISABLE".equals(bundle.getString("com.onesignal.BadgeCount")) ^ true ? 1 : 0;
            } else {
                f10747a = 1;
            }
            if (f10747a == 1) {
                return true;
            }
            return false;
        } else if (i10 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean b(Context context) {
        if (!a(context) || !OSUtils.a(context)) {
            return false;
        }
        return true;
    }

    static void c(u3 u3Var, Context context) {
        if (b(context)) {
            e(context);
        }
    }

    static void d(int i10, Context context) {
        if (a(context)) {
            try {
                c.a(context, i10);
            } catch (b unused) {
            }
        }
    }

    private static void e(Context context) {
        int i10 = 0;
        for (StatusBarNotification f10 : y3.d(context)) {
            if (!y0.f(f10)) {
                i10++;
            }
        }
        d(i10, context);
    }
}
