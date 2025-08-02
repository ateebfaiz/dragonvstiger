package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class TextPathView extends TextView {
    private String R0;
    private k0 S0;
    private j0 T0;
    private SVGLength U0;
    private i0 V0 = i0.align;
    private l0 W0 = l0.exact;

    public TextPathView(ReactContext reactContext) {
        super(reactContext);
    }

    public void L(String str) {
        this.V0 = i0.valueOf(str);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public j0 R() {
        return this.T0;
    }

    /* access modifiers changed from: package-private */
    public k0 S() {
        return this.S0;
    }

    /* access modifiers changed from: package-private */
    public SVGLength T() {
        return this.U0;
    }

    /* access modifiers changed from: package-private */
    public Path U(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.R0);
        if (!(definedTemplate instanceof RenderableView)) {
            return null;
        }
        return ((RenderableView) definedTemplate).getPath(canvas, paint);
    }

    public void V(String str) {
        this.R0 = str;
        invalidate();
    }

    public void W(String str) {
        this.T0 = j0.valueOf(str);
        invalidate();
    }

    public void X(String str) {
        this.S0 = k0.valueOf(str);
        invalidate();
    }

    public void Y(String str) {
        this.W0 = l0.valueOf(str);
        invalidate();
    }

    public void Z(Dynamic dynamic) {
        this.U0 = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        p(canvas, paint, f10);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return C(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }

    /* access modifiers changed from: package-private */
    public void v() {
    }
}
