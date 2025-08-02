package com.facebook.login;

public enum e {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_ONLY(true, true, false, false, false, true, true),
    KATANA_ONLY(false, true, false, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true, true),
    DEVICE_AUTH(false, false, false, true, false, false, false);
    

    /* renamed from: a  reason: collision with root package name */
    private final boolean f20491a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20492b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20493c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20494d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20495e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f20496f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f20497g;

    private e(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f20491a = z10;
        this.f20492b = z11;
        this.f20493c = z12;
        this.f20494d = z13;
        this.f20495e = z14;
        this.f20496f = z15;
        this.f20497g = z16;
    }

    public final boolean a() {
        return this.f20495e;
    }

    public final boolean b() {
        return this.f20494d;
    }

    public final boolean c() {
        return this.f20496f;
    }

    public final boolean d() {
        return this.f20491a;
    }

    public final boolean e() {
        return this.f20497g;
    }

    public final boolean f() {
        return this.f20492b;
    }

    public final boolean h() {
        return this.f20493c;
    }
}
