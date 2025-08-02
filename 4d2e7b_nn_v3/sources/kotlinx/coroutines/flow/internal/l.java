package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlinx.coroutines.flow.c;

public interface l extends c {

    public static final class a {
        public static /* synthetic */ c a(l lVar, CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    coroutineContext = g.f679a;
                }
                if ((i11 & 2) != 0) {
                    i10 = -3;
                }
                if ((i11 & 4) != 0) {
                    cVar = kotlinx.coroutines.channels.c.SUSPEND;
                }
                return lVar.c(coroutineContext, i10, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    c c(CoroutineContext coroutineContext, int i10, kotlinx.coroutines.channels.c cVar);
}
