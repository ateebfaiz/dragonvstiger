package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class RadialGradientView extends DefinitionView {

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f9665j = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9666a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9667b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9668c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9669d;

    /* renamed from: e  reason: collision with root package name */
    private SVGLength f9670e;

    /* renamed from: f  reason: collision with root package name */
    private SVGLength f9671f;

    /* renamed from: g  reason: collision with root package name */
    private ReadableArray f9672g;

    /* renamed from: h  reason: collision with root package name */
    private a.b f9673h;

    /* renamed from: i  reason: collision with root package name */
    private Matrix f9674i = null;

    public RadialGradientView(ReactContext reactContext) {
        super(reactContext);
    }

    public void p(Dynamic dynamic) {
        this.f9670e = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(Dynamic dynamic) {
        this.f9671f = SVGLength.b(dynamic);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9666a = SVGLength.b(dynamic);
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9667b = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0113a.RADIAL_GRADIENT, new SVGLength[]{this.f9666a, this.f9667b, this.f9668c, this.f9669d, this.f9670e, this.f9671f}, this.f9673h);
            aVar.e(this.f9672g);
            Matrix matrix = this.f9674i;
            if (matrix != null) {
                aVar.f(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.f9673h == a.b.USER_SPACE_ON_USE) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }

    public void t(ReadableArray readableArray) {
        this.f9672g = readableArray;
        invalidate();
    }

    public void u(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = f9665j;
            int c10 = p.c(readableArray, fArr, this.mScale);
            if (c10 == 6) {
                if (this.f9674i == null) {
                    this.f9674i = new Matrix();
                }
                this.f9674i.setValues(fArr);
            } else if (c10 != -1) {
                z2.a.G("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.f9674i = null;
        }
        invalidate();
    }

    public void v(int i10) {
        if (i10 == 0) {
            this.f9673h = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9673h = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void w(Dynamic dynamic) {
        this.f9668c = SVGLength.b(dynamic);
        invalidate();
    }

    public void x(Dynamic dynamic) {
        this.f9669d = SVGLength.b(dynamic);
        invalidate();
    }
}
