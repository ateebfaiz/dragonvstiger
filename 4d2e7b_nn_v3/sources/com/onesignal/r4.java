package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import androidx.work.WorkRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

class r4 {

    /* renamed from: c  reason: collision with root package name */
    private static Class f11014c;

    /* renamed from: d  reason: collision with root package name */
    private static AtomicLong f11015d;

    /* renamed from: e  reason: collision with root package name */
    private static AtomicLong f11016e;

    /* renamed from: f  reason: collision with root package name */
    private static d2 f11017f;

    /* renamed from: a  reason: collision with root package name */
    private Object f11018a;

    /* renamed from: b  reason: collision with root package name */
    private Context f11019b;

    r4(Context context) {
        this.f11019b = context;
    }

    static boolean a() {
        try {
            f11014c = FirebaseAnalytics.class;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private String b(d2 d2Var) {
        if (!d2Var.j().isEmpty() && !d2Var.i().isEmpty()) {
            return d2Var.j() + " - " + d2Var.i();
        } else if (d2Var.k() != null) {
            return d2Var.k().substring(0, Math.min(10, d2Var.k().length()));
        } else {
            return "";
        }
    }

    private Object c(Context context) {
        if (this.f11018a == null) {
            try {
                this.f11018a = d(f11014c).invoke((Object) null, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.f11018a;
    }

    private static Method d(Class cls) {
        try {
            return cls.getMethod("getInstance", new Class[]{Context.class});
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static Method e(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (f11015d != null && f11017f != null) {
            long b10 = o3.w0().b();
            if (b10 - f11015d.get() <= 120000) {
                AtomicLong atomicLong = f11016e;
                if (atomicLong == null || b10 - atomicLong.get() >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    try {
                        Object c10 = c(this.f11019b);
                        Method e10 = e(f11014c);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "OneSignal");
                        bundle.putString("medium", "notification");
                        bundle.putString("notification_id", f11017f.g());
                        bundle.putString("campaign", b(f11017f));
                        e10.invoke(c10, new Object[]{"os_notification_influence_open", bundle});
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(m2 m2Var) {
        if (f11016e == null) {
            f11016e = new AtomicLong();
        }
        f11016e.set(o3.w0().b());
        try {
            Object c10 = c(this.f11019b);
            Method e10 = e(f11014c);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", m2Var.d().g());
            bundle.putString("campaign", b(m2Var.d()));
            e10.invoke(c10, new Object[]{"os_notification_opened", bundle});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(m2 m2Var) {
        try {
            Object c10 = c(this.f11019b);
            Method e10 = e(f11014c);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", m2Var.d().g());
            bundle.putString("campaign", b(m2Var.d()));
            e10.invoke(c10, new Object[]{"os_notification_received", bundle});
            if (f11015d == null) {
                f11015d = new AtomicLong();
            }
            f11015d.set(o3.w0().b());
            f11017f = m2Var.d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
