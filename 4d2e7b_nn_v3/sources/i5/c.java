package i5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import h5.i;
import kotlin.jvm.internal.m;
import o5.a;

public final class c extends b {

    /* renamed from: h  reason: collision with root package name */
    private final f f22128h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(i iVar, Pools.Pool pool, f fVar) {
        super(iVar, pool, fVar);
        m.f(iVar, "bitmapPool");
        m.f(pool, "decodeBuffers");
        m.f(fVar, "platformDecoderOptions");
        this.f22128h = fVar;
    }

    public int d(int i10, int i11, BitmapFactory.Options options) {
        m.f(options, "options");
        Bitmap.Config a10 = options.outConfig;
        if (a10 == null) {
            a10 = Bitmap.Config.ARGB_8888;
        }
        return a.f(i10, i11, a10);
    }
}
