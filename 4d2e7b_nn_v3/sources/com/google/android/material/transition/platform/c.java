package com.google.android.material.transition.platform;

class c {

    /* renamed from: a  reason: collision with root package name */
    final int f8926a;

    /* renamed from: b  reason: collision with root package name */
    final int f8927b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f8928c;

    private c(int i10, int i11, boolean z10) {
        this.f8926a = i10;
        this.f8927b = i11;
        this.f8928c = z10;
    }

    static c a(int i10, int i11) {
        return new c(i10, i11, true);
    }

    static c b(int i10, int i11) {
        return new c(i10, i11, false);
    }
}
