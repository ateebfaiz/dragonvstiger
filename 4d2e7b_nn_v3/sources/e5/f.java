package e5;

import android.graphics.Bitmap;
import c3.a;
import c3.h;

public abstract /* synthetic */ class f {
    public static g a(Bitmap bitmap, h hVar, o oVar, int i10) {
        return b(bitmap, hVar, oVar, i10, 0);
    }

    public static g b(Bitmap bitmap, h hVar, o oVar, int i10, int i11) {
        if (b.H()) {
            return new b(bitmap, hVar, oVar, i10, i11);
        }
        return new i(bitmap, hVar, oVar, i10, i11);
    }

    public static g c(a aVar, o oVar, int i10) {
        return d(aVar, oVar, i10, 0);
    }

    public static g d(a aVar, o oVar, int i10, int i11) {
        if (b.H()) {
            return new b(aVar, oVar, i10, i11);
        }
        return new i(aVar, oVar, i10, i11);
    }
}
