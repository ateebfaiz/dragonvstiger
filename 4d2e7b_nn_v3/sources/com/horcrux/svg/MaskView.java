package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class MaskView extends GroupView {
    a C;

    /* renamed from: f  reason: collision with root package name */
    SVGLength f9649f;

    /* renamed from: g  reason: collision with root package name */
    SVGLength f9650g;

    /* renamed from: h  reason: collision with root package name */
    SVGLength f9651h;

    /* renamed from: i  reason: collision with root package name */
    SVGLength f9652i;

    /* renamed from: j  reason: collision with root package name */
    private a.b f9653j;

    /* renamed from: w  reason: collision with root package name */
    private a.b f9654w;

    enum a {
        LUMINANCE,
        ALPHA
    }

    public MaskView(ReactContext reactContext) {
        super(reactContext);
    }

    public a A() {
        return this.C;
    }

    public a.b B() {
        return this.f9653j;
    }

    public void C(Dynamic dynamic) {
        this.f9652i = SVGLength.b(dynamic);
        invalidate();
    }

    public void D(int i10) {
        if (i10 == 0) {
            this.f9654w = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9654w = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void E(int i10) {
        if (i10 == 0) {
            this.C = a.LUMINANCE;
        } else if (i10 == 1) {
            this.C = a.ALPHA;
        }
        invalidate();
    }

    public void F(int i10) {
        if (i10 == 0) {
            this.f9653j = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9653j = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void G(Dynamic dynamic) {
        this.f9651h = SVGLength.b(dynamic);
        invalidate();
    }

    public void H(Dynamic dynamic) {
        this.f9649f = SVGLength.b(dynamic);
        invalidate();
    }

    public void I(Dynamic dynamic) {
        this.f9650g = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
