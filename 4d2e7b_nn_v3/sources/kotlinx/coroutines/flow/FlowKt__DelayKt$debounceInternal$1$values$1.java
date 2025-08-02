package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.channels.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", l = {210}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ c $this_debounceInternal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$values$1(c cVar, d dVar) {
        super(2, dVar);
        this.$this_debounceInternal = cVar;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, dVar);
        flowKt__DelayKt$debounceInternal$1$values$1.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            final n nVar = (n) this.L$0;
            c cVar = this.$this_debounceInternal;
            AnonymousClass1 r32 = new d() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object i(java.lang.Object r5, kotlin.coroutines.d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.p.b(r6)
                        goto L_0x0043
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.p.b(r6)
                        kotlinx.coroutines.channels.n r6 = r5
                        if (r5 != 0) goto L_0x003a
                        cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
                    L_0x003a:
                        r0.label = r3
                        java.lang.Object r5 = r6.x(r5, r0)
                        if (r5 != r1) goto L_0x0043
                        return r1
                    L_0x0043:
                        kotlin.Unit r5 = kotlin.Unit.f12577a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1.i(java.lang.Object, kotlin.coroutines.d):java.lang.Object");
                }
            };
            this.label = 1;
            if (cVar.a(r32, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(n nVar, d dVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
