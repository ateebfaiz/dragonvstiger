package com.bugsnag.android;

import android.content.Context;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f18951a = new Object();

    /* renamed from: b  reason: collision with root package name */
    static z f18952b;

    public static z a() {
        if (f18952b == null) {
            synchronized (f18951a) {
                try {
                    if (f18952b == null) {
                        throw new IllegalStateException("You must call Bugsnag.start before any other Bugsnag methods");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18952b;
    }

    private static void b() {
        a().f19174q.g("Multiple Bugsnag.start calls detected. Ignoring.");
    }

    public static void c(Throwable th, h3 h3Var) {
        a().F(th, h3Var);
    }

    public static z d(Context context) {
        return e(context, f0.I(context));
    }

    public static z e(Context context, f0 f0Var) {
        synchronized (f18951a) {
            try {
                if (f18952b == null) {
                    f18952b = new z(context, f0Var);
                } else {
                    b();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f18952b;
    }
}
