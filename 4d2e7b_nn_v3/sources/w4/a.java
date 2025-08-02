package w4;

import android.graphics.Bitmap;
import h5.i;
import kotlin.jvm.internal.m;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final i f24604a;

    /* renamed from: b  reason: collision with root package name */
    private final z4.a f24605b;

    public a(i iVar, z4.a aVar) {
        m.f(iVar, "bitmapPool");
        m.f(aVar, "closeableReferenceFactory");
        this.f24604a = iVar;
        this.f24605b = aVar;
    }

    public c3.a d(int i10, int i11, Bitmap.Config config) {
        m.f(config, "bitmapConfig");
        Bitmap bitmap = (Bitmap) this.f24604a.get(o5.a.f(i10, i11, config));
        if (bitmap.getAllocationByteCount() >= i10 * i11 * o5.a.e(config)) {
            bitmap.reconfigure(i10, i11, config);
            c3.a c10 = this.f24605b.c(bitmap, this.f24604a);
            m.e(c10, "closeableReferenceFactor…reate(bitmap, bitmapPool)");
            return c10;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
