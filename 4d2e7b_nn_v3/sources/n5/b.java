package n5;

import android.graphics.Bitmap;
import c3.a;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22833a = new b();

    private b() {
    }

    public static final boolean a(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null) {
            return false;
        }
        Object p10 = aVar2.p();
        m.e(p10, "bitmapReference.get()");
        Bitmap bitmap = (Bitmap) p10;
        if (aVar.a()) {
            bitmap.setHasAlpha(true);
        }
        aVar.b(bitmap);
        return true;
    }
}
