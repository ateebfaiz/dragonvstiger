package com.alibaba.pdns.net.f;

import android.content.Context;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static b f18118a;

    public static void a(Context context) {
        if (context != null) {
            synchronized (c.class) {
                try {
                    if (f18118a == null) {
                        f18118a = new d().a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
