package kotlinx.coroutines.debug.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlin.sequences.g;

@c(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", l = {166}, m = "invokeSuspend")
final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ f $bottom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ c this$0;

    DebugCoroutineInfoImpl$creationStackTrace$1(c cVar, f fVar, d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1((c) null, (f) null, dVar);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    public final Object n(Object obj) {
        b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            g gVar = (g) this.L$0;
            throw null;
        } else if (i10 == 1) {
            p.b(obj);
            return Unit.f12577a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
