package com.facebook.imagepipeline.nativecode;

import a8.a;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f20001a;

    public static synchronized void a() {
        synchronized (e.class) {
            if (!f20001a) {
                a.d("static-webp");
                f20001a = true;
            }
        }
    }
}
