package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.flow.d;

public final class r implements d {

    /* renamed from: a  reason: collision with root package name */
    private final p f1062a;

    public r(p pVar) {
        this.f1062a = pVar;
    }

    public Object i(Object obj, kotlin.coroutines.d dVar) {
        Object x10 = this.f1062a.x(obj, dVar);
        if (x10 == b.c()) {
            return x10;
        }
        return Unit.f12577a;
    }
}
