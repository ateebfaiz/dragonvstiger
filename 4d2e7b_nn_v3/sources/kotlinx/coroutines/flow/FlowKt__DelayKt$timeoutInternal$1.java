package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.b0;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", l = {424}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements n {
    final /* synthetic */ c $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$timeoutInternal$1(long j10, c cVar, d dVar) {
        super(3, dVar);
        this.$timeout = j10;
        this.$this_timeoutInternal = cVar;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007f  */
    public final java.lang.Object n(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r9.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            long r4 = r9.J$0
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.flow.d r6 = (kotlinx.coroutines.flow.d) r6
            kotlin.p.b(r10)
            goto L_0x0077
        L_0x001a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0022:
            kotlin.p.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.b0 r10 = (kotlinx.coroutines.b0) r10
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            long r4 = r9.$timeout
            kotlin.time.a$a r6 = kotlin.time.a.f833a
            long r6 = r6.a()
            int r4 = kotlin.time.a.c(r4, r6)
            if (r4 <= 0) goto L_0x0082
            kotlinx.coroutines.flow.c r4 = r9.$this_timeoutInternal
            r5 = 0
            r6 = 2
            kotlinx.coroutines.flow.c r4 = kotlinx.coroutines.flow.t.b(r4, r5, r3, r6, r3)
            kotlinx.coroutines.channels.ReceiveChannel r10 = kotlinx.coroutines.flow.e.y(r4, r10)
            long r4 = r9.$timeout
            r6 = r1
            r1 = r10
        L_0x004b:
            kotlinx.coroutines.selects.SelectImplementation r10 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r7 = r9.getContext()
            r10.<init>(r7)
            kotlinx.coroutines.selects.g r7 = r1.f()
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1
            r8.<init>(r6, r3)
            r10.d(r7, r8)
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2 r7 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2
            r7.<init>(r4, r3)
            kotlinx.coroutines.selects.b.b(r10, r4, r7)
            r9.L$0 = r6
            r9.L$1 = r1
            r9.J$0 = r4
            r9.label = r2
            java.lang.Object r10 = r10.q(r9)
            if (r10 != r0) goto L_0x0077
            return r0
        L_0x0077:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x004b
            kotlin.Unit r10 = kotlin.Unit.f12577a
            return r10
        L_0x0082:
            kotlinx.coroutines.y1 r10 = new kotlinx.coroutines.y1
            java.lang.String r0 = "Timed out immediately"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object e(b0 b0Var, d dVar, d dVar2) {
        FlowKt__DelayKt$timeoutInternal$1 flowKt__DelayKt$timeoutInternal$1 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, dVar2);
        flowKt__DelayKt$timeoutInternal$1.L$0 = b0Var;
        flowKt__DelayKt$timeoutInternal$1.L$1 = dVar;
        return flowKt__DelayKt$timeoutInternal$1.n(Unit.f12577a);
    }
}
