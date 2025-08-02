package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.g;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", l = {404}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ d $downStream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$timeoutInternal$1$1$1(d dVar, d dVar2) {
        super(2, dVar2);
        this.$downStream = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return u(((g) obj).k(), (d) obj2);
    }

    public final d k(Object obj, d dVar) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, dVar);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            java.lang.Object r0 = r4.L$0
            kotlin.p.b(r5)
            goto L_0x0036
        L_0x0011:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0019:
            kotlin.p.b(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.g r5 = (kotlinx.coroutines.channels.g) r5
            java.lang.Object r5 = r5.k()
            kotlinx.coroutines.flow.d r1 = r4.$downStream
            boolean r3 = r5 instanceof kotlinx.coroutines.channels.g.c
            if (r3 != 0) goto L_0x0037
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r1.i(r5, r4)
            if (r1 != r0) goto L_0x0035
            return r0
        L_0x0035:
            r0 = r5
        L_0x0036:
            r5 = r0
        L_0x0037:
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.g.a
            if (r0 == 0) goto L_0x0045
            kotlinx.coroutines.channels.g.e(r5)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        L_0x0045:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1.n(java.lang.Object):java.lang.Object");
    }

    public final Object u(Object obj, d dVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) k(g.b(obj), dVar)).n(Unit.f12577a);
    }
}
