package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import y2.d;
import y2.l;

@d
public class NativeBlurFilter {
    static {
        b.a();
    }

    public static void a(Bitmap bitmap, int i10, int i11) {
        boolean z10;
        l.g(bitmap);
        boolean z11 = false;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i11 > 0) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        nativeIterativeBoxBlur(bitmap, i10, i11);
    }

    @d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i10, int i11);
}
