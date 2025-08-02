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
class FeCompositeView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    String f9584c;

    /* renamed from: d  reason: collision with root package name */
    String f9585d;

    /* renamed from: e  reason: collision with root package name */
    float f9586e;

    /* renamed from: f  reason: collision with root package name */
    float f9587f;

    /* renamed from: g  reason: collision with root package name */
    float f9588g;

    /* renamed from: h  reason: collision with root package name */
    float f9589h;

    /* renamed from: i  reason: collision with root package name */
    h f9590i;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9591a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.horcrux.svg.h[] r0 = com.horcrux.svg.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9591a = r0
                com.horcrux.svg.h r1 = com.horcrux.svg.h.OVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9591a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.h r1 = com.horcrux.svg.h.IN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9591a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.h r1 = com.horcrux.svg.h.OUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9591a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.h r1 = com.horcrux.svg.h.ATOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9591a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.horcrux.svg.h r1 = com.horcrux.svg.h.XOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9591a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.horcrux.svg.h r1 = com.horcrux.svg.h.ARITHMETIC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.FeCompositeView.a.<clinit>():void");
        }
    }

    public FeCompositeView(ReactContext reactContext) {
        super(reactContext);
    }

    public void A(Float f10) {
        this.f9587f = f10.floatValue();
        invalidate();
    }

    public void B(Float f10) {
        this.f9588g = f10.floatValue();
        invalidate();
    }

    public void C(Float f10) {
        this.f9589h = f10.floatValue();
        invalidate();
    }

    public void D(String str) {
        this.f9590i = h.b(str);
        invalidate();
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        Canvas canvas;
        Bitmap bitmap2;
        HashMap hashMap2 = hashMap;
        Bitmap bitmap3 = bitmap;
        Bitmap r10 = FilterPrimitiveView.r(hashMap2, bitmap3, this.f9584c);
        Bitmap r11 = FilterPrimitiveView.r(hashMap2, bitmap3, this.f9585d);
        Bitmap createBitmap = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas2.drawBitmap(r10, 0.0f, 0.0f, paint);
        switch (a.f9591a[this.f9590i.ordinal()]) {
            case 1:
                bitmap2 = r11;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                break;
            case 2:
                bitmap2 = r11;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                break;
            case 3:
                bitmap2 = r11;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                break;
            case 4:
                bitmap2 = r11;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                break;
            case 5:
                bitmap2 = r11;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                break;
            case 6:
                int width = createBitmap.getWidth() * createBitmap.getHeight();
                int[] iArr = new int[width];
                int[] iArr2 = new int[width];
                createBitmap.getPixels(iArr, 0, createBitmap.getWidth(), 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                int[] iArr3 = iArr;
                r11.getPixels(iArr2, 0, createBitmap.getWidth(), 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                int i10 = 0;
                while (i10 < width) {
                    int i11 = iArr3[i10];
                    int i12 = iArr2[i10];
                    int i13 = width;
                    float f10 = this.f9586e;
                    float f11 = (float) ((i11 >> 16) & 255);
                    float f12 = (float) ((i12 >> 16) & 255);
                    Bitmap bitmap4 = r11;
                    float f13 = this.f9587f;
                    float f14 = (f10 * f11 * f12) + (f11 * f13);
                    float f15 = this.f9588g;
                    float f16 = f14 + (f12 * f15);
                    float f17 = this.f9589h;
                    Canvas canvas3 = canvas2;
                    float f18 = (float) ((i11 >> 8) & 255);
                    float f19 = (float) ((i12 >> 8) & 255);
                    float f20 = (float) (i11 & 255);
                    float f21 = (float) (i12 & 255);
                    float f22 = (float) (i11 >>> 24);
                    float f23 = (float) (i12 >>> 24);
                    int min = Math.min(255, Math.max(0, (int) (f16 + f17)));
                    int min2 = Math.min(255, Math.max(0, (int) ((f10 * f18 * f19) + (f18 * f13) + (f19 * f15) + f17)));
                    iArr3[i10] = (Math.min(255, Math.max(0, (int) (((((f10 * f22) * f23) + (f13 * f22)) + (f15 * f23)) + f17))) << 24) | (min << 16) | (min2 << 8) | Math.min(255, Math.max(0, (int) ((f10 * f20 * f21) + (f20 * f13) + (f21 * f15) + f17)));
                    i10++;
                    width = i13;
                    r11 = bitmap4;
                    canvas2 = canvas3;
                }
                bitmap2 = r11;
                canvas = canvas2;
                createBitmap.setPixels(iArr3, 0, createBitmap.getWidth(), 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                break;
            default:
                bitmap2 = r11;
                canvas = canvas2;
                break;
        }
        if (this.f9590i != h.ARITHMETIC) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        }
        return createBitmap;
    }

    public void x(String str) {
        this.f9584c = str;
        invalidate();
    }

    public void y(String str) {
        this.f9585d = str;
        invalidate();
    }

    public void z(Float f10) {
        this.f9586e = f10.floatValue();
        invalidate();
    }
}
