package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FeBlendView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    String f9576c;

    /* renamed from: d  reason: collision with root package name */
    String f9577d;

    /* renamed from: e  reason: collision with root package name */
    f f9578e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9579a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.horcrux.svg.f[] r0 = com.horcrux.svg.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9579a = r0
                com.horcrux.svg.f r1 = com.horcrux.svg.f.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9579a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.f r1 = com.horcrux.svg.f.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9579a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.f r1 = com.horcrux.svg.f.SCREEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9579a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.f r1 = com.horcrux.svg.f.LIGHTEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9579a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.horcrux.svg.f r1 = com.horcrux.svg.f.DARKEN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9579a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.horcrux.svg.f r1 = com.horcrux.svg.f.MULTIPLY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.FeBlendView.a.<clinit>():void");
        }
    }

    public FeBlendView(ReactContext reactContext) {
        super(reactContext);
        this.f9604b.mX = new SVGLength(0.0d);
        this.f9604b.mY = new SVGLength(0.0d);
        this.f9604b.mW = new SVGLength("100%");
        this.f9604b.mH = new SVGLength("100%");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float[] y(float[] fArr, float[] fArr2) {
        float f10 = fArr[0];
        float f11 = fArr2[0];
        float f12 = fArr[1];
        float f13 = fArr2[1];
        float f14 = fArr[2];
        float f15 = fArr2[2];
        float f16 = fArr[3];
        float f17 = fArr2[3];
        float f18 = (f16 * f10 * (1.0f - f11)) + (f17 * f11 * (1.0f - f10)) + (f16 * f10 * f17 * f11);
        return new float[]{1.0f - ((1.0f - f10) * (1.0f - f11)), (f12 * f10 * (1.0f - f11)) + (f13 * f11 * (1.0f - f10)) + (f12 * f10 * f13 * f11), (f14 * f10 * (1.0f - f11)) + (f15 * f11 * (1.0f - f10)) + (f14 * f10 * f15 * f11), f18};
    }

    public void A(String str) {
        this.f9577d = str;
        invalidate();
    }

    public void B(String str) {
        this.f9578e = f.b(str);
        invalidate();
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        Bitmap r10 = FilterPrimitiveView.r(hashMap, bitmap, this.f9576c);
        Bitmap r11 = FilterPrimitiveView.r(hashMap, bitmap, this.f9577d);
        if (this.f9578e == f.MULTIPLY) {
            return CustomFilter.apply(r10, r11, new d());
        }
        Bitmap createBitmap = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(r10, 0.0f, 0.0f, paint);
        int i10 = a.f9579a[this.f9578e.ordinal()];
        if (i10 == 1 || i10 == 2) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        } else if (i10 == 3) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        } else if (i10 == 4) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        } else if (i10 == 5) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        }
        canvas.drawBitmap(r11, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public void z(String str) {
        this.f9576c = str;
        invalidate();
    }
}
