package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.g;
import kotlinx.coroutines.flow.internal.l;

abstract /* synthetic */ class t {
    public static final c a(c cVar, int i10, c cVar2) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        } else if (i10 != -1 || cVar2 == c.SUSPEND) {
            if (i10 == -1) {
                cVar2 = c.DROP_OLDEST;
                i10 = 0;
            }
            int i11 = i10;
            c cVar3 = cVar2;
            if (cVar instanceof l) {
                return l.a.a((l) cVar, (CoroutineContext) null, i11, cVar3, 1, (Object) null);
            }
            return new g(cVar, (CoroutineContext) null, i11, cVar3, 2, (DefaultConstructorMarker) null);
        } else {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
    }

    public static /* synthetic */ c b(c cVar, int i10, c cVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            cVar2 = c.SUSPEND;
        }
        return e.b(cVar, i10, cVar2);
    }
}
