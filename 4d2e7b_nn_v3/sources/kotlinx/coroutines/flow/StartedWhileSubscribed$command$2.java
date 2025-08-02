package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", l = {}, m = "invokeSuspend")
final class StartedWhileSubscribed$command$2 extends SuspendLambda implements Function2<p1, d, Object> {
    /* synthetic */ Object L$0;
    int label;

    StartedWhileSubscribed$command$2(d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(dVar);
        startedWhileSubscribed$command$2.L$0 = obj;
        return startedWhileSubscribed$command$2;
    }

    public final Object n(Object obj) {
        boolean z10;
        b.c();
        if (this.label == 0) {
            p.b(obj);
            if (((p1) this.L$0) != p1.START) {
                z10 = true;
            } else {
                z10 = false;
            }
            return a.a(z10);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(p1 p1Var, d dVar) {
        return ((StartedWhileSubscribed$command$2) k(p1Var, dVar)).n(Unit.f12577a);
    }
}
