package i5;

import android.os.Build;
import androidx.core.util.Pools;
import b3.b;
import h5.e0;
import h5.i;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f22129a = new e();

    private e() {
    }

    public static final d a(e0 e0Var, boolean z10, boolean z11, f fVar) {
        m.f(e0Var, "poolFactory");
        m.f(fVar, "platformDecoderOptions");
        if (Build.VERSION.SDK_INT >= 26) {
            i b10 = e0Var.b();
            m.e(b10, "poolFactory.bitmapPool");
            return new c(b10, b(e0Var, z11), fVar);
        }
        i b11 = e0Var.b();
        m.e(b11, "poolFactory.bitmapPool");
        return new a(b11, b(e0Var, z11), fVar);
    }

    public static final Pools.Pool b(e0 e0Var, boolean z10) {
        m.f(e0Var, "poolFactory");
        if (z10) {
            b bVar = b.f17158a;
            m.e(bVar, "INSTANCE");
            return bVar;
        }
        int e10 = e0Var.e();
        Pools.SynchronizedPool synchronizedPool = new Pools.SynchronizedPool(e10);
        for (int i10 = 0; i10 < e10; i10++) {
            synchronizedPool.release(ByteBuffer.allocate(b.c()));
        }
        return synchronizedPool;
    }
}
