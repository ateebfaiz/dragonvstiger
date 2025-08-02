package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class LinearGradientView extends DefinitionView {

    /* renamed from: h  reason: collision with root package name */
    private static final float[] f9635h = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9636a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9637b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9638c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9639d;

    /* renamed from: e  reason: collision with root package name */
    private ReadableArray f9640e;

    /* renamed from: f  reason: collision with root package name */
    private a.b f9641f;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f9642g = null;

    public LinearGradientView(ReactContext reactContext) {
        super(reactContext);
    }

    public void p(ReadableArray readableArray) {
        this.f9640e = readableArray;
        invalidate();
    }

    public void q(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = f9635h;
            int c10 = p.c(readableArray, fArr, this.mScale);
            if (c10 == 6) {
                if (this.f9642g == null) {
                    this.f9642g = new Matrix();
                }
                this.f9642g.setValues(fArr);
            } else if (c10 != -1) {
                z2.a.G("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.f9642g = null;
        }
        invalidate();
    }

    public void r(int i10) {
        if (i10 == 0) {
            this.f9641f = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9641f = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9636a = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0113a.LINEAR_GRADIENT, new SVGLength[]{this.f9636a, this.f9637b, this.f9638c, this.f9639d}, this.f9641f);
            aVar.e(this.f9640e);
            Matrix matrix = this.f9642g;
            if (matrix != null) {
                aVar.f(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.f9641f == a.b.USER_SPACE_ON_USE) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }

    public void t(Dynamic dynamic) {
        this.f9638c = SVGLength.b(dynamic);
        invalidate();
    }

    public void u(Dynamic dynamic) {
        this.f9637b = SVGLength.b(dynamic);
        invalidate();
    }

    public void v(Dynamic dynamic) {
        this.f9639d = SVGLength.b(dynamic);
        invalidate();
    }
}
