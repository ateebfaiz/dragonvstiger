package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", l = {316, 318, 319}, m = "invokeSuspend")
final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$fixedPeriodTicker$3(long j10, long j11, d dVar) {
        super(2, dVar);
        this.$initialDelayMillis = j10;
        this.$delayMillis = j11;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__DelayKt$fixedPeriodTicker$3 flowKt__DelayKt$fixedPeriodTicker$3 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.$initialDelayMillis, this.$delayMillis, dVar);
        flowKt__DelayKt$fixedPeriodTicker$3.L$0 = obj;
        return flowKt__DelayKt$fixedPeriodTicker$3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.channels.n} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[RETURN] */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.n r1 = (kotlinx.coroutines.channels.n) r1
            kotlin.p.b(r8)
            goto L_0x0050
        L_0x0022:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.n r1 = (kotlinx.coroutines.channels.n) r1
            kotlin.p.b(r8)
            goto L_0x003f
        L_0x002a:
            kotlin.p.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.channels.n r1 = (kotlinx.coroutines.channels.n) r1
            long r5 = r7.$initialDelayMillis
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r0) goto L_0x003f
            return r0
        L_0x003f:
            kotlinx.coroutines.channels.p r8 = r1.i()
            kotlin.Unit r4 = kotlin.Unit.f12577a
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r8.x(r4, r7)
            if (r8 != r0) goto L_0x0050
            return r0
        L_0x0050:
            long r4 = r7.$delayMillis
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r4, r7)
            if (r8 != r0) goto L_0x003f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) k(nVar, dVar)).n(Unit.f12577a);
    }
}
