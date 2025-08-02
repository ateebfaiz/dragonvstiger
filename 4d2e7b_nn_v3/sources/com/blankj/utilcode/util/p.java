package com.blankj.utilcode.util;

import android.app.Application;
import android.util.Log;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private static Application f18416a;

    public interface a {
        void accept(Object obj);
    }

    public static Application a() {
        Application application = f18416a;
        if (application != null) {
            return application;
        }
        b(s.d());
        if (f18416a != null) {
            Log.i("Utils", s.e() + " reflect app success.");
            return f18416a;
        }
        throw new NullPointerException("reflect failed.");
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f18416a;
        if (application2 == null) {
            f18416a = application;
            s.h(application);
            s.j();
        } else if (!application2.equals(application)) {
            s.m(f18416a);
            f18416a = application;
            s.h(application);
        }
    }
}
