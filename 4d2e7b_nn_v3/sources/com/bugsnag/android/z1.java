package com.bugsnag.android;

import android.os.StrictMode;
import java.lang.Thread;

class z1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f19193a;

    /* renamed from: b  reason: collision with root package name */
    private final x3 f19194b = new x3();

    /* renamed from: c  reason: collision with root package name */
    private final z f19195c;

    /* renamed from: d  reason: collision with root package name */
    private final s2 f19196d;

    z1(z zVar, s2 s2Var) {
        this.f19195c = zVar;
        this.f19196d = s2Var;
        this.f19193a = Thread.getDefaultUncaughtExceptionHandler();
    }

    private void a(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f19193a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        System.err.printf("Exception in thread \"%s\" ", new Object[]{thread.getName()});
        this.f19196d.c("Exception", th);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Thread.setDefaultUncaughtExceptionHandler(this.f19193a);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String str2;
        try {
            if (this.f19195c.m().O(th)) {
                a(thread, th);
                return;
            }
            boolean c10 = this.f19194b.c(th);
            y2 y2Var = new y2();
            if (c10) {
                String b10 = this.f19194b.b(th.getMessage());
                y2 y2Var2 = new y2();
                y2Var2.a("StrictMode", "Violation", b10);
                y2 y2Var3 = y2Var2;
                str = b10;
                y2Var = y2Var3;
            } else {
                str = null;
            }
            if (c10) {
                str2 = "strictMode";
            } else {
                str2 = "unhandledException";
            }
            if (c10) {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                this.f19195c.H(th, y2Var, str2, str);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                this.f19195c.H(th, y2Var, str2, (String) null);
            }
            a(thread, th);
        } catch (Throwable unused) {
        }
    }
}
