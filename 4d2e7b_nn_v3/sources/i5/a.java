package i5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import h5.i;
import kotlin.jvm.internal.m;

public final class a extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(i iVar, Pools.Pool pool, f fVar) {
        super(iVar, pool, fVar);
        m.f(iVar, "bitmapPool");
        m.f(pool, "decodeBuffers");
        m.f(fVar, "platformDecoderOptions");
    }

    public int d(int i10, int i11, BitmapFactory.Options options) {
        m.f(options, "options");
        Bitmap.Config config = options.inPreferredConfig;
        if (config != null) {
            return o5.a.f(i10, i11, config);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
