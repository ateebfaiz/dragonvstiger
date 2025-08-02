package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

public abstract class b {
    public static final void a(c cVar, long j10, Function1 function1) {
        cVar.b(new a(j10).b(), function1);
    }

    public static final void b(c cVar, long j10, Function1 function1) {
        a(cVar, DelayKt.d(j10), function1);
    }
}
