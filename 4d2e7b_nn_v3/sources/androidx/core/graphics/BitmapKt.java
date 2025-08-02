package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r3.y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean contains(android.graphics.Bitmap r2, android.graphics.Point r3) {
        /*
            int r0 = r2.getWidth()
            int r1 = r3.x
            if (r1 < 0) goto L_0x0016
            if (r1 >= r0) goto L_0x0016
            int r3 = r3.y
            if (r3 < 0) goto L_0x0016
            int r2 = r2.getHeight()
            if (r3 >= r2) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapKt.contains(android.graphics.Bitmap, android.graphics.Point):boolean");
    }

    public static final Bitmap createBitmap(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static final int get(Bitmap bitmap, int i10, int i11) {
        return bitmap.getPixel(i10, i11);
    }

    public static final Bitmap scale(Bitmap bitmap, int i10, int i11, boolean z10) {
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
    }

    public static final void set(Bitmap bitmap, int i10, int i11, @ColorInt int i12) {
        bitmap.setPixel(i10, i11, i12);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f10 = pointF.x;
        if (f10 >= 0.0f && f10 < ((float) bitmap.getWidth())) {
            float f11 = pointF.y;
            return f11 >= 0.0f && f11 < ((float) bitmap.getHeight());
        }
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
    }
}
