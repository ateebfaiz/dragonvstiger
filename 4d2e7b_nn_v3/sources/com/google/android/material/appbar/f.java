package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class f {

    /* renamed from: a  reason: collision with root package name */
    private final View f7908a;

    /* renamed from: b  reason: collision with root package name */
    private int f7909b;

    /* renamed from: c  reason: collision with root package name */
    private int f7910c;

    /* renamed from: d  reason: collision with root package name */
    private int f7911d;

    /* renamed from: e  reason: collision with root package name */
    private int f7912e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7913f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7914g = true;

    public f(View view) {
        this.f7908a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f7908a;
        ViewCompat.offsetTopAndBottom(view, this.f7911d - (view.getTop() - this.f7909b));
        View view2 = this.f7908a;
        ViewCompat.offsetLeftAndRight(view2, this.f7912e - (view2.getLeft() - this.f7910c));
    }

    public int b() {
        return this.f7909b;
    }

    public int c() {
        return this.f7912e;
    }

    public int d() {
        return this.f7911d;
    }

    public boolean e() {
        return this.f7914g;
    }

    public boolean f() {
        return this.f7913f;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f7909b = this.f7908a.getTop();
        this.f7910c = this.f7908a.getLeft();
    }

    public void h(boolean z10) {
        this.f7914g = z10;
    }

    public boolean i(int i10) {
        if (!this.f7914g || this.f7912e == i10) {
            return false;
        }
        this.f7912e = i10;
        a();
        return true;
    }

    public boolean j(int i10) {
        if (!this.f7913f || this.f7911d == i10) {
            return false;
        }
        this.f7911d = i10;
        a();
        return true;
    }

    public void k(boolean z10) {
        this.f7913f = z10;
    }
}
