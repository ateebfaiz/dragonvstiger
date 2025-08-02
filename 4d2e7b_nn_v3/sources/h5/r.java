package h5;

import android.graphics.Bitmap;
import kotlin.jvm.internal.m;

public final class r implements i {
    /* renamed from: g */
    public Bitmap get(int i10) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i10) / 2.0d), Bitmap.Config.RGB_565);
        m.e(createBitmap, "createBitmap(\n          …   Bitmap.Config.RGB_565)");
        return createBitmap;
    }

    /* renamed from: h */
    public void release(Bitmap bitmap) {
        m.f(bitmap, "value");
        bitmap.recycle();
    }
}
