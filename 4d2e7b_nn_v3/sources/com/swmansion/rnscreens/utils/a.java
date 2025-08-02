package com.swmansion.rnscreens.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0131a f11682c = new C0131a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final a f11683d = new a(new b(Integer.MIN_VALUE, false), 0.0f);

    /* renamed from: a  reason: collision with root package name */
    private final b f11684a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11685b;

    /* renamed from: com.swmansion.rnscreens.utils.a$a  reason: collision with other inner class name */
    public static final class C0131a {
        private C0131a() {
        }

        public /* synthetic */ C0131a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(b bVar, float f10) {
        m.f(bVar, "cacheKey");
        this.f11684a = bVar;
        this.f11685b = f10;
    }

    public final float a() {
        return this.f11685b;
    }

    public final boolean b(b bVar) {
        m.f(bVar, "key");
        if (this.f11684a.a() == Integer.MIN_VALUE || !m.b(this.f11684a, bVar)) {
            return false;
        }
        return true;
    }
}
