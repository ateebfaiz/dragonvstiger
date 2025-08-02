package com.flyjingfish.android_aop_core.utils;

import com.flyjingfish.android_aop_core.AndroidAopContentProvider;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5740a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5741b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f5742c;

    private b() {
    }

    private final boolean a() {
        try {
            if ((AndroidAopContentProvider.f5737a.a().getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean b() {
        if (f5741b) {
            return f5742c;
        }
        boolean a10 = a();
        f5742c = a10;
        f5741b = true;
        return a10;
    }
}
