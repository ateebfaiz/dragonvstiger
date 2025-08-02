package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class MarkerView extends GroupView {
    private float C;
    private float N0;
    private float O0;
    private float P0;
    String Q0;
    int R0;
    Matrix S0 = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private SVGLength f9643f;

    /* renamed from: g  reason: collision with root package name */
    private SVGLength f9644g;

    /* renamed from: h  reason: collision with root package name */
    private SVGLength f9645h;

    /* renamed from: i  reason: collision with root package name */
    private SVGLength f9646i;

    /* renamed from: j  reason: collision with root package name */
    private String f9647j;

    /* renamed from: w  reason: collision with root package name */
    private String f9648w;

    public MarkerView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void A(Canvas canvas, Paint paint, float f10, q qVar, float f11) {
        double d10;
        int saveAndSetupCanvas = saveAndSetupCanvas(canvas, this.mCTM);
        this.S0.reset();
        o oVar = qVar.f9934b;
        this.S0.setTranslate((float) oVar.f9923a, (float) oVar.f9924b);
        if ("auto".equals(this.f9648w)) {
            d10 = -1.0d;
        } else {
            d10 = Double.parseDouble(this.f9648w);
        }
        if (d10 == -1.0d) {
            d10 = qVar.f9935c;
        }
        this.S0.preRotate(((float) d10) + 180.0f);
        if ("strokeWidth".equals(this.f9647j)) {
            Matrix matrix = this.S0;
            float f12 = this.mScale;
            matrix.preScale(f11 / f12, f11 / f12);
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) (relativeOnWidth(this.f9645h) / ((double) this.mScale)), (float) (relativeOnHeight(this.f9646i) / ((double) this.mScale)));
        if (this.Q0 != null) {
            float f13 = this.C;
            float f14 = this.mScale;
            float f15 = this.N0;
            Matrix a10 = m0.a(new RectF(f13 * f14, f15 * f14, (f13 + this.O0) * f14, (f15 + this.P0) * f14), rectF, this.Q0, this.R0);
            float[] fArr = new float[9];
            a10.getValues(fArr);
            this.S0.preScale(fArr[0], fArr[4]);
        }
        this.S0.preTranslate((float) (-relativeOnWidth(this.f9643f)), (float) (-relativeOnHeight(this.f9644g)));
        canvas.concat(this.S0);
        p(canvas, paint, f10);
        restoreCanvas(canvas, saveAndSetupCanvas);
    }

    public void B(Dynamic dynamic) {
        this.f9646i = SVGLength.b(dynamic);
        invalidate();
    }

    public void C(String str) {
        this.f9647j = str;
        invalidate();
    }

    public void D(Dynamic dynamic) {
        this.f9645h = SVGLength.b(dynamic);
        invalidate();
    }

    public void E(String str) {
        this.f9648w = str;
        invalidate();
    }

    public void F(Dynamic dynamic) {
        this.f9643f = SVGLength.b(dynamic);
        invalidate();
    }

    public void G(Dynamic dynamic) {
        this.f9644g = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMarker(this, this.mName);
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).saveDefinition();
                }
            }
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
