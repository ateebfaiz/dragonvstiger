package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class PatternView extends GroupView {
    private static final float[] T0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float C;
    private float N0;
    private float O0;
    private float P0;
    String Q0;
    int R0;
    private Matrix S0 = null;

    /* renamed from: f  reason: collision with root package name */
    private SVGLength f9659f;

    /* renamed from: g  reason: collision with root package name */
    private SVGLength f9660g;

    /* renamed from: h  reason: collision with root package name */
    private SVGLength f9661h;

    /* renamed from: i  reason: collision with root package name */
    private SVGLength f9662i;

    /* renamed from: j  reason: collision with root package name */
    private a.b f9663j;

    /* renamed from: w  reason: collision with root package name */
    private a.b f9664w;

    public PatternView(ReactContext reactContext) {
        super(reactContext);
    }

    public void A(Dynamic dynamic) {
        this.f9662i = SVGLength.b(dynamic);
        invalidate();
    }

    public void B(int i10) {
        if (i10 == 0) {
            this.f9664w = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9664w = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void C(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = T0;
            int c10 = p.c(readableArray, fArr, this.mScale);
            if (c10 == 6) {
                if (this.S0 == null) {
                    this.S0 = new Matrix();
                }
                this.S0.setValues(fArr);
            } else if (c10 != -1) {
                z2.a.G("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.S0 = null;
        }
        invalidate();
    }

    public void D(int i10) {
        if (i10 == 0) {
            this.f9663j = a.b.OBJECT_BOUNDING_BOX;
        } else if (i10 == 1) {
            this.f9663j = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void E(Dynamic dynamic) {
        this.f9661h = SVGLength.b(dynamic);
        invalidate();
    }

    public void F(Dynamic dynamic) {
        this.f9659f = SVGLength.b(dynamic);
        invalidate();
    }

    public void G(Dynamic dynamic) {
        this.f9660g = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public RectF getViewBox() {
        float f10 = this.C;
        float f11 = this.mScale;
        float f12 = this.N0;
        return new RectF(f10 * f11, f12 * f11, (f10 + this.O0) * f11, (f12 + this.P0) * f11);
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0113a.PATTERN, new SVGLength[]{this.f9659f, this.f9660g, this.f9661h, this.f9662i}, this.f9663j);
            aVar.d(this.f9664w);
            aVar.g(this);
            Matrix matrix = this.S0;
            if (matrix != null) {
                aVar.f(matrix);
            }
            SvgView svgView = getSvgView();
            a.b bVar = this.f9663j;
            a.b bVar2 = a.b.USER_SPACE_ON_USE;
            if (bVar == bVar2 || this.f9664w == bVar2) {
                aVar.h(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }

    public void setAlign(String str) {
        this.Q0 = str;
        invalidate();
    }

    public void setMeetOrSlice(int i10) {
        this.R0 = i10;
        invalidate();
    }

    public void setMinX(float f10) {
        this.C = f10;
        invalidate();
    }

    public void setMinY(float f10) {
        this.N0 = f10;
        invalidate();
    }

    public void setVbHeight(float f10) {
        this.P0 = f10;
        invalidate();
    }

    public void setVbWidth(float f10) {
        this.O0 = f10;
        invalidate();
    }
}
