package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import vb.n;

public abstract class CombineKt {
    public static final Object a(d dVar, c[] cVarArr, Function0 function0, n nVar, kotlin.coroutines.d dVar2) {
        Object a10 = j.a(new CombineKt$combineInternal$2(cVarArr, function0, nVar, dVar, (kotlin.coroutines.d) null), dVar2);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }
}
