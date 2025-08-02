package com.facebook.react.module.model;

import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ReactModuleInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final a f3188g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f3189a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3190b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3191c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3192d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3193e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3194f;

    public static final class a {
        private a() {
        }

        public final boolean a(Class cls) {
            m.f(cls, "clazz");
            return TurboModule.class.isAssignableFrom(cls);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReactModuleInfo(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        m.f(str, "_name");
        m.f(str2, "_className");
        this.f3189a = str;
        this.f3190b = str2;
        this.f3191c = z10;
        this.f3192d = z11;
        this.f3193e = z12;
        this.f3194f = z13;
    }

    public static final boolean b(Class cls) {
        return f3188g.a(cls);
    }

    public final boolean a() {
        return this.f3191c;
    }

    public final String c() {
        return this.f3190b;
    }

    public final boolean d() {
        return this.f3193e;
    }

    public final boolean e() {
        return this.f3194f;
    }

    public final String f() {
        return this.f3189a;
    }

    public final boolean g() {
        return this.f3192d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReactModuleInfo(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this(str, str2, z10, z11, z13, z14);
        m.f(str, "name");
        m.f(str2, "className");
    }
}
