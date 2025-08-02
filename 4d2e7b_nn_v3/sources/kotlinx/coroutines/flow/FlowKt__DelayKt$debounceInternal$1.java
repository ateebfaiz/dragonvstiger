package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.b0;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {221, 426}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements n {
    final /* synthetic */ c $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1 function1, c cVar, d dVar) {
        super(3, dVar);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r14.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x003e
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r14.L$2
            kotlin.jvm.internal.y r1 = (kotlin.jvm.internal.y) r1
            java.lang.Object r5 = r14.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.d r6 = (kotlinx.coroutines.flow.d) r6
            kotlin.p.b(r15)
        L_0x001e:
            r7 = r6
            r6 = r5
            r5 = r1
            goto L_0x0060
        L_0x0022:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x002a:
            java.lang.Object r1 = r14.L$3
            kotlin.jvm.internal.x r1 = (kotlin.jvm.internal.x) r1
            java.lang.Object r5 = r14.L$2
            kotlin.jvm.internal.y r5 = (kotlin.jvm.internal.y) r5
            java.lang.Object r6 = r14.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r14.L$0
            kotlinx.coroutines.flow.d r7 = (kotlinx.coroutines.flow.d) r7
            kotlin.p.b(r15)
            goto L_0x00a2
        L_0x003e:
            kotlin.p.b(r15)
            java.lang.Object r15 = r14.L$0
            r5 = r15
            kotlinx.coroutines.b0 r5 = (kotlinx.coroutines.b0) r5
            java.lang.Object r15 = r14.L$1
            kotlinx.coroutines.flow.d r15 = (kotlinx.coroutines.flow.d) r15
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.c r1 = r14.$this_debounceInternal
            r8.<init>(r1, r4)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.channels.ReceiveChannel r1 = kotlinx.coroutines.channels.ProduceKt.d(r5, r6, r7, r8, r9, r10)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            r7 = r15
            r6 = r1
        L_0x0060:
            java.lang.Object r15 = r5.f725a
            cc.c0 r1 = kotlinx.coroutines.flow.internal.n.f1058c
            if (r15 == r1) goto L_0x00e9
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            java.lang.Object r15 = r5.f725a
            if (r15 == 0) goto L_0x00a4
            kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Long> r8 = r14.$timeoutMillisSelector
            cc.c0 r9 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r15 != r9) goto L_0x0076
            r15 = r4
        L_0x0076:
            java.lang.Object r15 = r8.invoke(r15)
            java.lang.Number r15 = (java.lang.Number) r15
            long r10 = r15.longValue()
            r1.f724a = r10
            r12 = 0
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 < 0) goto L_0x00a9
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 != 0) goto L_0x00a4
            java.lang.Object r15 = r5.f725a
            if (r15 != r9) goto L_0x0091
            r15 = r4
        L_0x0091:
            r14.L$0 = r7
            r14.L$1 = r6
            r14.L$2 = r5
            r14.L$3 = r1
            r14.label = r3
            java.lang.Object r15 = r7.i(r15, r14)
            if (r15 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r5.f725a = r4
        L_0x00a4:
            r15 = r1
            r1 = r5
            r5 = r6
            r6 = r7
            goto L_0x00b5
        L_0x00a9:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Debounce timeout should not be negative"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x00b5:
            kotlinx.coroutines.selects.SelectImplementation r7 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r8 = r14.getContext()
            r7.<init>(r8)
            java.lang.Object r8 = r1.f725a
            if (r8 == 0) goto L_0x00cc
            long r8 = r15.f724a
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r15 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r15.<init>(r6, r1, r4)
            kotlinx.coroutines.selects.b.a(r7, r8, r15)
        L_0x00cc:
            kotlinx.coroutines.selects.g r15 = r5.f()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r8.<init>(r1, r6, r4)
            r7.d(r15, r8)
            r14.L$0 = r6
            r14.L$1 = r5
            r14.L$2 = r1
            r14.L$3 = r4
            r14.label = r2
            java.lang.Object r15 = r7.q(r14)
            if (r15 != r0) goto L_0x001e
            return r0
        L_0x00e9:
            kotlin.Unit r15 = kotlin.Unit.f12577a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object e(b0 b0Var, d dVar, d dVar2) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, dVar2);
        flowKt__DelayKt$debounceInternal$1.L$0 = b0Var;
        flowKt__DelayKt$debounceInternal$1.L$1 = dVar;
        return flowKt__DelayKt$debounceInternal$1.n(Unit.f12577a);
    }
}
