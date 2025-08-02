package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

@SuppressLint({"ViewConstructor"})
class ForeignObjectView extends GroupView {

    /* renamed from: f  reason: collision with root package name */
    SVGLength f9609f;

    /* renamed from: g  reason: collision with root package name */
    SVGLength f9610g;

    /* renamed from: h  reason: collision with root package name */
    SVGLength f9611h;

    /* renamed from: i  reason: collision with root package name */
    SVGLength f9612i;

    /* renamed from: j  reason: collision with root package name */
    Bitmap f9613j = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);

    /* renamed from: w  reason: collision with root package name */
    Canvas f9614w = new Canvas(this.f9613j);

    public ForeignObjectView(ReactContext reactContext) {
        super(reactContext);
    }

    public void A(Dynamic dynamic) {
        this.f9612i = SVGLength.b(dynamic);
        invalidate();
    }

    public void B(Dynamic dynamic) {
        this.f9611h = SVGLength.b(dynamic);
        invalidate();
    }

    public void C(Dynamic dynamic) {
        this.f9609f = SVGLength.b(dynamic);
        invalidate();
    }

    public void D(Dynamic dynamic) {
        this.f9610g = SVGLength.b(dynamic);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(this.f9614w);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        canvas.translate((float) relativeOnWidth(this.f9609f), (float) relativeOnHeight(this.f9610g));
        canvas.clipRect(0.0f, 0.0f, (float) relativeOnWidth(this.f9611h), (float) relativeOnHeight(this.f9612i));
        super.draw(canvas, paint, f10);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(this.f9614w, view, j10);
    }

    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void p(Canvas canvas, Paint paint, float f10) {
        v();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt;
                    if (!DevicePublicKeyStringDef.NONE.equals(virtualView.mDisplay)) {
                        boolean z10 = virtualView instanceof RenderableView;
                        if (z10) {
                            ((RenderableView) virtualView).mergeProperties(this);
                        }
                        int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas, this.mCTM);
                        virtualView.render(canvas, paint, this.mOpacity * f10);
                        RectF clientRect = virtualView.getClientRect();
                        if (clientRect != null) {
                            rectF.union(clientRect);
                        }
                        virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                        if (z10) {
                            ((RenderableView) virtualView).resetProperties();
                        }
                        if (virtualView.isResponsible()) {
                            svgView.enableTouchEvents();
                        }
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                } else {
                    childAt.draw(canvas);
                }
            }
        }
        setClientRect(rectF);
        u();
    }
}
