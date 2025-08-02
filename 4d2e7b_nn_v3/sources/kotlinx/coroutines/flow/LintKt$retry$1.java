package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", l = {}, m = "invokeSuspend")
public final class LintKt$retry$1 extends SuspendLambda implements Function2<Throwable, d, Object> {
    int label;

    public LintKt$retry$1(d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        return new LintKt$retry$1(dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            return a.a(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(Throwable th, d dVar) {
        return ((LintKt$retry$1) k(th, dVar)).n(Unit.f12577a);
    }
}
