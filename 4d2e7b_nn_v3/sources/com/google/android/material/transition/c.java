package com.google.android.material.transition;

class c {

    /* renamed from: a  reason: collision with root package name */
    final int f8833a;

    /* renamed from: b  reason: collision with root package name */
    final int f8834b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f8835c;

    private c(int i10, int i11, boolean z10) {
        this.f8833a = i10;
        this.f8834b = i11;
        this.f8835c = z10;
    }

    static c a(int i10, int i11) {
        return new c(i10, i11, true);
    }

    static c b(int i10, int i11) {
        return new c(i10, i11, false);
    }
}
