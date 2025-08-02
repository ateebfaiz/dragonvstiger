package com.shopify.reactnative.flash_list;

import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11351a;

    /* renamed from: b  reason: collision with root package name */
    private int f11352b;

    /* renamed from: c  reason: collision with root package name */
    private int f11353c;

    /* renamed from: d  reason: collision with root package name */
    private int f11354d;

    /* renamed from: e  reason: collision with root package name */
    private int f11355e;

    /* renamed from: f  reason: collision with root package name */
    private int f11356f;

    /* renamed from: g  reason: collision with root package name */
    private int f11357g;

    /* renamed from: h  reason: collision with root package name */
    private int f11358h;

    /* renamed from: i  reason: collision with root package name */
    private int f11359i;

    /* renamed from: j  reason: collision with root package name */
    private int f11360j;

    private final boolean g(c cVar) {
        int i10 = this.f11352b - this.f11353c;
        if (!this.f11351a) {
            if ((cVar.getTop() >= i10 - this.f11355e || cVar.getBottom() >= i10 - this.f11355e) && (cVar.getTop() <= this.f11354d + i10 || cVar.getBottom() <= i10 + this.f11354d)) {
                return true;
            }
        } else if ((cVar.getLeft() >= i10 - this.f11355e || cVar.getRight() >= i10 - this.f11355e) && (cVar.getLeft() <= this.f11354d + i10 || cVar.getRight() <= i10 + this.f11354d)) {
            return true;
        }
        return false;
    }

    public final void a(c[] cVarArr) {
        boolean z10;
        int i10;
        int i11;
        int max;
        m.f(cVarArr, "sortedItems");
        this.f11358h = 0;
        int length = cVarArr.length - 1;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < length) {
            c cVar = cVarArr[i13];
            i13++;
            c cVar2 = cVarArr[i13];
            if (cVar2.getIndex() == cVar.getIndex() + 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (g(cVar) || g(cVar2)) {
                if (!this.f11351a) {
                    i14 = Math.max(i15, cVar.getBottom());
                    i12 = Math.min(i12, cVar.getTop());
                    if (z10) {
                        if (cVar.getLeft() < cVar2.getLeft()) {
                            if (cVar.getRight() != cVar2.getLeft()) {
                                cVar2.setRight(cVar.getRight() + cVar2.getWidth());
                                cVar2.setLeft(cVar.getRight());
                            }
                            if (cVar.getTop() != cVar2.getTop()) {
                                cVar2.setBottom(cVar.getTop() + cVar2.getHeight());
                                cVar2.setTop(cVar.getTop());
                            }
                        } else {
                            cVar2.setBottom(cVar2.getHeight() + i14);
                            cVar2.setTop(i14);
                        }
                    }
                    if (g(cVar2)) {
                        max = Math.max(i14, cVar2.getBottom());
                    }
                    i15 = i14;
                } else {
                    i14 = Math.max(i15, cVar.getRight());
                    i12 = Math.min(i12, cVar.getLeft());
                    if (z10) {
                        if (cVar.getTop() < cVar2.getTop()) {
                            if (cVar.getBottom() != cVar2.getTop()) {
                                cVar2.setBottom(cVar.getBottom() + cVar2.getHeight());
                                cVar2.setTop(cVar.getBottom());
                            }
                            if (cVar.getLeft() != cVar2.getLeft()) {
                                cVar2.setRight(cVar.getLeft() + cVar2.getWidth());
                                cVar2.setLeft(cVar.getLeft());
                            }
                        } else {
                            cVar2.setRight(cVar2.getWidth() + i14);
                            cVar2.setLeft(i14);
                        }
                    }
                    if (g(cVar2)) {
                        max = Math.max(i14, cVar2.getRight());
                    }
                    i15 = i14;
                }
                int i16 = max;
                i15 = i14;
                i14 = i16;
            }
            int i17 = this.f11358h;
            if (this.f11351a) {
                i10 = cVar.getRight();
            } else {
                i10 = cVar.getBottom();
            }
            int max2 = Math.max(i17, i10);
            this.f11358h = max2;
            if (this.f11351a) {
                i11 = cVar2.getRight();
            } else {
                i11 = cVar2.getBottom();
            }
            this.f11358h = Math.max(max2, i11);
        }
        this.f11359i = i14;
        this.f11360j = i12;
    }

    public final int b(int i10, int i11, int i12) {
        int i13 = i10 - this.f11353c;
        int i14 = (this.f11360j - i13) - i11;
        this.f11356f = i14;
        int i15 = (((i13 + this.f11354d) - this.f11355e) - this.f11359i) - i12;
        this.f11357g = i15;
        return Math.max(i14, i15);
    }

    public final int c() {
        return this.f11357g;
    }

    public final int d() {
        return this.f11356f;
    }

    public final boolean e() {
        return this.f11351a;
    }

    public final int f() {
        return this.f11358h;
    }

    public final void h(boolean z10) {
        this.f11351a = z10;
    }

    public final void i(int i10) {
        this.f11358h = i10;
    }

    public final void j(int i10) {
        this.f11353c = i10;
    }

    public final void k(int i10) {
        this.f11355e = i10;
    }

    public final void l(int i10) {
        this.f11352b = i10;
    }

    public final void m(int i10) {
        this.f11354d = i10;
    }
}
