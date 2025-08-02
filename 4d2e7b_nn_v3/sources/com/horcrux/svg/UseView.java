package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import z2.a;

@SuppressLint({"ViewConstructor"})
class UseView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private String f9739a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9740b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9741c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9742d;

    /* renamed from: e  reason: collision with root package name */
    private SVGLength f9743e;

    public UseView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f9739a);
        if (definedTemplate == null) {
            a.G("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f9739a + " is not defined.");
            return;
        }
        definedTemplate.clearCache();
        canvas.translate((float) relativeOnWidth(this.f9740b), (float) relativeOnHeight(this.f9741c));
        boolean z10 = definedTemplate instanceof RenderableView;
        if (z10) {
            ((RenderableView) definedTemplate).mergeProperties(this);
        }
        int saveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas, this.mCTM);
        clip(canvas, paint);
        if (definedTemplate instanceof SymbolView) {
            ((SymbolView) definedTemplate).A(canvas, paint, f10, (float) relativeOnWidth(this.f9742d), (float) relativeOnHeight(this.f9743e));
        } else {
            definedTemplate.draw(canvas, paint, f10 * this.mOpacity);
        }
        RectF rectF = new RectF();
        getPath(canvas, paint).computeBounds(rectF, true);
        canvas.getMatrix().mapRect(rectF);
        setClientRect(rectF);
        definedTemplate.restoreCanvas(canvas, saveAndSetupCanvas);
        if (z10) {
            ((RenderableView) definedTemplate).resetProperties();
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f9739a);
        if (definedTemplate == null) {
            a.G("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f9739a + " is not defined.");
            return null;
        }
        Path path = definedTemplate.getPath(canvas, paint);
        Path path2 = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) relativeOnWidth(this.f9740b), (float) relativeOnHeight(this.f9741c));
        path.transform(matrix, path2);
        return path2;
    }

    public int hitTest(float[] fArr) {
        if (!this.mInvertible) {
            return -1;
        }
        float[] fArr2 = new float[2];
        this.mInvMatrix.mapPoints(fArr2, fArr);
        this.mInvTransform.mapPoints(fArr2);
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f9739a);
        if (definedTemplate == null) {
            a.G("ReactNative", "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.f9739a + " is not defined.");
            return -1;
        }
        int hitTest = definedTemplate.hitTest(fArr2);
        if (hitTest == -1) {
            return -1;
        }
        if (definedTemplate.isResponsible() || hitTest != definedTemplate.getId()) {
            return hitTest;
        }
        return getId();
    }

    public void p(Dynamic dynamic) {
        this.f9743e = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(String str) {
        this.f9739a = str;
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9742d = SVGLength.b(dynamic);
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9740b = SVGLength.b(dynamic);
        invalidate();
    }

    public void t(Dynamic dynamic) {
        this.f9741c = SVGLength.b(dynamic);
        invalidate();
    }
}
