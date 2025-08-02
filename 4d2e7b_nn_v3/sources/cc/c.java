package cc;

import kotlin.jvm.functions.Function2;

public abstract class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f59a = new c0("CLOSED");

    public static final d b(d dVar) {
        while (true) {
            Object a10 = dVar.f();
            if (a10 == f59a) {
                return dVar;
            }
            d dVar2 = (d) a10;
            if (dVar2 != null) {
                dVar = dVar2;
            } else if (dVar.j()) {
                return dVar;
            }
        }
    }

    public static final Object c(z zVar, long j10, Function2 function2) {
        while (true) {
            if (zVar.f113c >= j10 && !zVar.h()) {
                return a0.a(zVar);
            }
            Object a10 = zVar.f();
            if (a10 == f59a) {
                return a0.a(f59a);
            }
            z zVar2 = (z) ((d) a10);
            if (zVar2 == null) {
                zVar2 = (z) function2.invoke(Long.valueOf(zVar.f113c + 1), zVar);
                if (zVar.l(zVar2)) {
                    if (zVar.h()) {
                        zVar.k();
                    }
                }
            }
            zVar = zVar2;
        }
    }
}
