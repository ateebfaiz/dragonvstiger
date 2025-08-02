package com.facebook.react.views.text;

import android.text.Spannable;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Spannable f4225a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4226b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4227c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4228d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4229e;

    /* renamed from: f  reason: collision with root package name */
    private final float f4230f;

    /* renamed from: g  reason: collision with root package name */
    private final float f4231g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4232h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4233i;

    /* renamed from: j  reason: collision with root package name */
    private final int f4234j;

    public i(Spannable spannable, int i10, boolean z10, int i11, int i12, int i13) {
        this(spannable, i10, z10, -1.0f, -1.0f, -1.0f, -1.0f, i11, i12, i13);
    }

    public static i a(Spannable spannable, int i10, int i11, int i12, int i13) {
        return new i(spannable, i10, false, i11, i12, i13);
    }

    public boolean b() {
        return this.f4227c;
    }

    public int c() {
        return this.f4226b;
    }

    public int d() {
        return this.f4234j;
    }

    public float e() {
        return this.f4231g;
    }

    public float f() {
        return this.f4228d;
    }

    public float g() {
        return this.f4230f;
    }

    public float h() {
        return this.f4229e;
    }

    public Spannable i() {
        return this.f4225a;
    }

    public int j() {
        return this.f4232h;
    }

    public int k() {
        return this.f4233i;
    }

    public i(Spannable spannable, int i10, boolean z10, float f10, float f11, float f12, float f13, int i11, int i12, int i13) {
        this.f4225a = spannable;
        this.f4226b = i10;
        this.f4227c = z10;
        this.f4228d = f10;
        this.f4229e = f11;
        this.f4230f = f12;
        this.f4231g = f13;
        this.f4232h = i11;
        this.f4233i = i12;
        this.f4234j = i13;
    }
}
