package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FeColorMatrixView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    String f9580c;

    /* renamed from: d  reason: collision with root package name */
    g f9581d;

    /* renamed from: e  reason: collision with root package name */
    ReadableArray f9582e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9583a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.horcrux.svg.g[] r0 = com.horcrux.svg.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9583a = r0
                com.horcrux.svg.g r1 = com.horcrux.svg.g.MATRIX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9583a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.g r1 = com.horcrux.svg.g.SATURATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9583a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.g r1 = com.horcrux.svg.g.HUE_ROTATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9583a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.g r1 = com.horcrux.svg.g.LUMINANCE_TO_ALPHA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.FeColorMatrixView.a.<clinit>():void");
        }
    }

    public FeColorMatrixView(ReactContext reactContext) {
        super(reactContext);
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        int i10;
        Bitmap r10 = FilterPrimitiveView.r(hashMap, bitmap, this.f9580c);
        ColorMatrix colorMatrix = new ColorMatrix();
        int i11 = a.f9583a[this.f9581d.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 == 4) {
                        colorMatrix.set(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2125f, 0.7154f, 0.0721f, 0.0f, 0.0f});
                    }
                } else if (this.f9582e.size() != 1) {
                    return r10;
                } else {
                    double d10 = (((double) ((float) this.f9582e.getDouble(0))) * 3.141592653589793d) / 180.0d;
                    float cos = (float) Math.cos(d10);
                    float sin = (float) Math.sin(d10);
                    float f10 = 0.715f - (cos * 0.715f);
                    float f11 = sin * 0.715f;
                    float f12 = 0.072f - (cos * 0.072f);
                    float f13 = 0.213f - (cos * 0.213f);
                    colorMatrix.set(new float[]{((cos * 0.787f) + 0.213f) - (sin * 0.213f), f10 - f11, f12 + (sin * 0.928f), 0.0f, 0.0f, f13 + (0.143f * sin), (0.285f * cos) + 0.715f + (0.14f * sin), f12 - (0.283f * sin), 0.0f, 0.0f, f13 - (0.787f * sin), f10 + f11, (cos * 0.928f) + 0.072f + (sin * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                }
            } else if (this.f9582e.size() != 1) {
                return r10;
            } else {
                colorMatrix.setSaturation((float) this.f9582e.getDouble(0));
            }
        } else if (this.f9582e.size() < 20) {
            return r10;
        } else {
            float[] fArr = new float[this.f9582e.size()];
            for (int i12 = 0; i12 < this.f9582e.size(); i12++) {
                float f14 = (float) this.f9582e.getDouble(i12);
                if (i12 % 5 == 4) {
                    i10 = 255;
                } else {
                    i10 = 1;
                }
                fArr[i12] = f14 * ((float) i10);
            }
            colorMatrix.set(fArr);
        }
        return FilterUtils.getBitmapWithColorMatrix(colorMatrix, r10);
    }

    public void x(String str) {
        this.f9580c = str;
        invalidate();
    }

    public void y(String str) {
        this.f9581d = g.b(str);
        invalidate();
    }

    public void z(ReadableArray readableArray) {
        this.f9582e = readableArray;
        invalidate();
    }
}
