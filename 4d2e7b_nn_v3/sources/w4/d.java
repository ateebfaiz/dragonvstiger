package w4;

import android.graphics.Bitmap;
import c3.a;

public abstract class d {
    public a a(int i10, int i11) {
        return b(i10, i11, Bitmap.Config.ARGB_8888);
    }

    public a b(int i10, int i11, Bitmap.Config config) {
        return c(i10, i11, config, (Object) null);
    }

    public a c(int i10, int i11, Bitmap.Config config, Object obj) {
        return d(i10, i11, config);
    }

    public abstract a d(int i10, int i11, Bitmap.Config config);
}
