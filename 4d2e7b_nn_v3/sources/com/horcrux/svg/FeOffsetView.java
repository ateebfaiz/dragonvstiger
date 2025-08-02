package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FeOffsetView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    String f9600c;

    /* renamed from: d  reason: collision with root package name */
    SVGLength f9601d;

    /* renamed from: e  reason: collision with root package name */
    SVGLength f9602e;

    public FeOffsetView(ReactContext reactContext) {
        super(reactContext);
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        float f10;
        float f11;
        Bitmap r10 = FilterPrimitiveView.r(hashMap, bitmap, this.f9600c);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        SVGLength sVGLength = this.f9601d;
        if (sVGLength != null) {
            f10 = (float) relativeOnWidth(sVGLength);
        } else {
            f10 = 0.0f;
        }
        SVGLength sVGLength2 = this.f9602e;
        if (sVGLength2 != null) {
            f11 = (float) relativeOnHeight(sVGLength2);
        } else {
            f11 = 0.0f;
        }
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        getSvgView().getCtm().mapRect(rectF);
        float f12 = rectF.left;
        if (f12 >= 0.0f) {
            f12 = rectF.width();
        }
        float f13 = rectF.top;
        if (f13 >= 0.0f) {
            f13 = rectF.height();
        }
        canvas.drawBitmap(r10, f12, f13, (Paint) null);
        return createBitmap;
    }

    public void x(Dynamic dynamic) {
        this.f9601d = SVGLength.b(dynamic);
        invalidate();
    }

    public void y(Dynamic dynamic) {
        this.f9602e = SVGLength.b(dynamic);
        invalidate();
    }

    public void z(String str) {
        this.f9600c = str;
        invalidate();
    }
}
