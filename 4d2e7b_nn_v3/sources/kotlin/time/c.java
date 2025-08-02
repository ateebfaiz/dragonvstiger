package kotlin.time;

import ac.b;
import kotlin.jvm.internal.m;

class c {
    public static final long a(long j10, b bVar, b bVar2) {
        m.f(bVar, "sourceUnit");
        m.f(bVar2, "targetUnit");
        return bVar2.b().convert(j10, bVar.b());
    }
}
