package com.horcrux.svg;

import android.graphics.Bitmap;

public class CustomFilter {
    public static Bitmap apply(Bitmap bitmap, Bitmap bitmap2, b bVar) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 0.0f};
        try {
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
        }
        for (int i11 = 0; i11 < height; i11++) {
            for (int i12 = 0; i12 < width; i12++) {
                int i13 = (i11 * width) + i12;
                int i14 = iArr[i13];
                fArr[0] = ((float) ((i14 >> 24) & 255)) / 255.0f;
                fArr[1] = ((float) ((i14 >> 16) & 255)) / 255.0f;
                fArr[2] = ((float) ((i14 >> 8) & 255)) / 255.0f;
                fArr[3] = ((float) (i14 & 255)) / 255.0f;
                int i15 = iArr2[i13];
                float[] fArr3 = fArr2;
                fArr3[0] = ((float) ((i15 >> 24) & 255)) / 255.0f;
                fArr3[1] = ((float) ((i15 >> 16) & 255)) / 255.0f;
                fArr3[2] = ((float) ((i15 >> 8) & 255)) / 255.0f;
                fArr3[3] = ((float) (i15 & 255)) / 255.0f;
                iArr3[i13] = normalizeFromFloats(bVar.a(fArr, fArr3));
            }
            b bVar2 = bVar;
            float[] fArr4 = fArr2;
        }
        return Bitmap.createBitmap(iArr3, width, height, Bitmap.Config.ARGB_8888);
    }

    public static int normalizeFromFloat(float f10) {
        return Math.min(255, Math.max(0, Math.round(f10 * 255.0f)));
    }

    public static int normalizeFromFloats(float[] fArr) {
        if (fArr.length < 4 || normalizeFromFloat(fArr[0]) <= 0) {
            return 0;
        }
        return normalizeFromFloat(fArr[3] / fArr[0]) | (normalizeFromFloat(fArr[0]) << 24) | (normalizeFromFloat(fArr[1] / fArr[0]) << 16) | (normalizeFromFloat(fArr[2] / fArr[0]) << 8);
    }
}
