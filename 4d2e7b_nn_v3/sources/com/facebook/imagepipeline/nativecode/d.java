package com.facebook.imagepipeline.nativecode;

import a8.a;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f20000a;

    public static synchronized void a() {
        synchronized (d.class) {
            if (!f20000a) {
                a.d("native-imagetranscoder");
                f20000a = true;
            }
        }
    }
}
