package h5;

import android.graphics.Bitmap;
import java.util.Set;
import kotlin.jvm.internal.m;
import y2.n;

public final class s implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set f21978a;

    public s() {
        Set b10 = n.b();
        m.e(b10, "newIdentityHashSet()");
        this.f21978a = b10;
    }

    /* renamed from: g */
    public Bitmap get(int i10) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i10) / 2.0d), Bitmap.Config.RGB_565);
        m.e(createBitmap, "createBitmap(\n          …   Bitmap.Config.RGB_565)");
        this.f21978a.add(createBitmap);
        return createBitmap;
    }

    /* renamed from: h */
    public void release(Bitmap bitmap) {
        m.f(bitmap, "value");
        this.f21978a.remove(bitmap);
        bitmap.recycle();
    }
}
