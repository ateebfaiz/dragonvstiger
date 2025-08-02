package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.p;

abstract class s {
    static int a(float f10) {
        return m.a(f10);
    }

    static void b(Activity activity) {
        d.a(activity);
    }

    static int c() {
        return l.a();
    }

    static Application d() {
        return r.f18417g.f();
    }

    static String e() {
        return j.a();
    }

    static Notification f(i.a aVar, p.a aVar2) {
        return i.a(aVar, aVar2);
    }

    static k g() {
        return k.a("Utils");
    }

    static void h(Application application) {
        r.f18417g.g(application);
    }

    static boolean i(String str) {
        return n.a(str);
    }

    static void j() {
        k(a.f());
    }

    private static void k(Runnable... runnableArr) {
        for (Runnable execute : runnableArr) {
            o.b().execute(execute);
        }
    }

    static void l(Runnable runnable, long j10) {
        o.e(runnable, j10);
    }

    static void m(Application application) {
        r.f18417g.l(application);
    }
}
