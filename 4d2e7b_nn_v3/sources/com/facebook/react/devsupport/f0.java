package com.facebook.react.devsupport;

import com.facebook.soloader.SoLoader;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f3079a = new f0();

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f3080b;

    private f0() {
    }

    public static final synchronized void a() {
        synchronized (f0.class) {
            if (!f3080b) {
                SoLoader.t("react_devsupportjni");
                f3080b = true;
            }
        }
    }
}
