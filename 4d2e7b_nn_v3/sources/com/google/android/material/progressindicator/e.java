package com.google.android.material.progressindicator;

import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected IndeterminateDrawable f8399a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f8400b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f8401c;

    protected e(int i10) {
        this.f8400b = new float[(i10 * 2)];
        this.f8401c = new int[i10];
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public float b(int i10, int i11, int i12) {
        return ((float) (i10 - i11)) / ((float) i12);
    }

    public abstract void c();

    public abstract void d(Animatable2Compat.AnimationCallback animationCallback);

    /* access modifiers changed from: protected */
    public void e(IndeterminateDrawable indeterminateDrawable) {
        this.f8399a = indeterminateDrawable;
    }

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
