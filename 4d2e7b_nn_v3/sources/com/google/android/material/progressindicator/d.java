package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    BaseProgressIndicatorSpec f8397a;

    /* renamed from: b  reason: collision with root package name */
    protected c f8398b;

    public d(BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f8397a = baseProgressIndicatorSpec;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, float f10);

    /* access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Paint paint, float f10, float f11, int i10);

    /* access modifiers changed from: package-private */
    public abstract void c(Canvas canvas, Paint paint);

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: protected */
    public void f(c cVar) {
        this.f8398b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas, float f10) {
        this.f8397a.validateSpec();
        a(canvas, f10);
    }
}
