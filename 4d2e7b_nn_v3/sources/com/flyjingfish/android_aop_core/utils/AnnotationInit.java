package com.flyjingfish.android_aop_core.utils;

import android.os.Handler;
import android.os.Looper;
import y8.a;
import y8.h;

class AnnotationInit {
    static {
        h.f13354a.a(new a(new Handler(Looper.getMainLooper())));
        a.f13334a.c(b.f5740a.b());
    }

    AnnotationInit() {
    }

    private static /* synthetic */ void lambda$static$0(Handler handler, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
