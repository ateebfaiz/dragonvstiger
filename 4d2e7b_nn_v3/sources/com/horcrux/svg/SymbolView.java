package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class SymbolView extends GroupView {

    /* renamed from: f  reason: collision with root package name */
    private float f9724f;

    /* renamed from: g  reason: collision with root package name */
    private float f9725g;

    /* renamed from: h  reason: collision with root package name */
    private float f9726h;

    /* renamed from: i  reason: collision with root package name */
    private float f9727i;

    /* renamed from: j  reason: collision with root package name */
    private String f9728j;

    /* renamed from: w  reason: collision with root package name */
    private int f9729w;

    public SymbolView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void A(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        if (this.f9728j != null) {
            float f13 = this.f9724f;
            float f14 = this.mScale;
            float f15 = this.f9725g;
            canvas.concat(m0.a(new RectF(f13 * f14, f15 * f14, (f13 + this.f9726h) * f14, (f15 + this.f9727i) * f14), new RectF(0.0f, 0.0f, f11, f12), this.f9728j, this.f9729w));
            super.draw(canvas, paint, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        saveDefinition();
    }

    public void setAlign(String str) {
        this.f9728j = str;
        invalidate();
    }

    public void setMeetOrSlice(int i10) {
        this.f9729w = i10;
        invalidate();
    }

    public void setMinX(float f10) {
        this.f9724f = f10;
        invalidate();
    }

    public void setMinY(float f10) {
        this.f9725g = f10;
        invalidate();
    }

    public void setVbHeight(float f10) {
        this.f9727i = f10;
        invalidate();
    }

    public void setVbWidth(float f10) {
        this.f9726h = f10;
        invalidate();
    }
}
