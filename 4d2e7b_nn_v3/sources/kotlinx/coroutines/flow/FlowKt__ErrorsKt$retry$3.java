package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import vb.o;

@c(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", l = {95}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements o {
    final /* synthetic */ Function2<Throwable, d, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$3(long j10, Function2 function2, d dVar) {
        super(4, dVar);
        this.$retries = j10;
        this.$predicate = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return u((d) obj, (Throwable) obj2, ((Number) obj3).longValue(), (d) obj4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.p.b(r8)
            goto L_0x0031
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.p.b(r8)
            java.lang.Object r8 = r7.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.J$0
            long r5 = r7.$retries
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x003a
            kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.d, java.lang.Object> r1 = r7.$predicate
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L_0x0031
            return r0
        L_0x0031:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.a.a(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.n(java.lang.Object):java.lang.Object");
    }

    public final Object u(d dVar, Throwable th, long j10, d dVar2) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, dVar2);
        flowKt__ErrorsKt$retry$3.L$0 = th;
        flowKt__ErrorsKt$retry$3.J$0 = j10;
        return flowKt__ErrorsKt$retry$3.n(Unit.f12577a);
    }
}
