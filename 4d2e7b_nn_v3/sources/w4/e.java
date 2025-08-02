package w4;

import h5.e0;
import h5.i;
import i5.d;
import kotlin.jvm.internal.m;
import z4.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f24612a = new e();

    private e() {
    }

    public static final d a(e0 e0Var, d dVar, a aVar) {
        m.f(e0Var, "poolFactory");
        m.f(dVar, "platformDecoder");
        m.f(aVar, "closeableReferenceFactory");
        i b10 = e0Var.b();
        m.e(b10, "poolFactory.bitmapPool");
        return new a(b10, aVar);
    }
}
