package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FilterView extends DefinitionView {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f9605a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private i f9606b;

    /* renamed from: c  reason: collision with root package name */
    private i f9607c;

    /* renamed from: d  reason: collision with root package name */
    private final FilterRegion f9608d = new FilterRegion();

    public FilterView(ReactContext reactContext) {
        super(reactContext);
    }

    public Bitmap p(Bitmap bitmap, Bitmap bitmap2, RectF rectF) {
        RectF rectF2;
        this.f9605a.clear();
        this.f9605a.put("SourceGraphic", bitmap);
        this.f9605a.put("SourceAlpha", FilterUtils.applySourceAlphaFilter(bitmap));
        this.f9605a.put("BackgroundImage", bitmap2);
        this.f9605a.put("BackgroundAlpha", FilterUtils.applySourceAlphaFilter(bitmap2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Rect cropRect = this.f9608d.getCropRect(this, this.f9606b, rectF);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof FilterPrimitiveView) {
                FilterPrimitiveView filterPrimitiveView = (FilterPrimitiveView) childAt;
                createBitmap.eraseColor(0);
                FilterRegion filterRegion = filterPrimitiveView.f9604b;
                i iVar = this.f9607c;
                if (iVar == i.USER_SPACE_ON_USE) {
                    rectF2 = new RectF(cropRect);
                } else {
                    rectF2 = rectF;
                }
                Rect cropRect2 = filterRegion.getCropRect(filterPrimitiveView, iVar, rectF2);
                canvas.drawBitmap(filterPrimitiveView.p(this.f9605a, bitmap), cropRect2, cropRect2, (Paint) null);
                bitmap = createBitmap.copy(Bitmap.Config.ARGB_8888, true);
                String q10 = filterPrimitiveView.q();
                if (q10 != null) {
                    this.f9605a.put(q10, bitmap);
                }
            } else {
                Log.e("RNSVG", "Invalid `Filter` child: Filter children can only be `Fe...` components");
            }
        }
        createBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, cropRect, cropRect, (Paint) null);
        return createBitmap;
    }

    public void q(String str) {
        this.f9606b = i.b(str);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9608d.setHeight(dynamic);
        invalidate();
    }

    public void s(String str) {
        this.f9607c = i.b(str);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        SvgView svgView;
        if (this.mName != null && (svgView = getSvgView()) != null) {
            svgView.defineFilter(this, this.mName);
        }
    }

    public void t(Dynamic dynamic) {
        this.f9608d.setWidth(dynamic);
        invalidate();
    }

    public void u(Dynamic dynamic) {
        this.f9608d.setX(dynamic);
        invalidate();
    }

    public void v(Dynamic dynamic) {
        this.f9608d.setY(dynamic);
        invalidate();
    }
}
