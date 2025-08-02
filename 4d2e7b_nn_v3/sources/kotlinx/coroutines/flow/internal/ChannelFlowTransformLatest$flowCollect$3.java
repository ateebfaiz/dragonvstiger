package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, kotlinx.coroutines.flow.d dVar, d dVar2) {
        super(2, dVar2);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = dVar;
    }

    public final d k(Object obj, d dVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, dVar);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            final b0 b0Var = (b0) this.L$0;
            final y yVar = new y();
            final ChannelFlowTransformLatest channelFlowTransformLatest = this.this$0;
            kotlinx.coroutines.flow.c cVar = channelFlowTransformLatest.f1027d;
            final kotlinx.coroutines.flow.d dVar = this.$collector;
            AnonymousClass1 r52 = new kotlinx.coroutines.flow.d() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object i(final java.lang.Object r8, kotlin.coroutines.d r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x003b
                        if (r2 != r3) goto L_0x0033
                        java.lang.Object r8 = r0.L$2
                        kotlinx.coroutines.f1 r8 = (kotlinx.coroutines.f1) r8
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r0 = r0.L$0
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                        kotlin.p.b(r9)
                        goto L_0x005e
                    L_0x0033:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x003b:
                        kotlin.p.b(r9)
                        kotlin.jvm.internal.y r9 = r1
                        java.lang.Object r9 = r9.f725a
                        kotlinx.coroutines.f1 r9 = (kotlinx.coroutines.f1) r9
                        if (r9 == 0) goto L_0x005d
                        kotlinx.coroutines.flow.internal.h r2 = new kotlinx.coroutines.flow.internal.h
                        r2.<init>()
                        r9.b(r2)
                        r0.L$0 = r7
                        r0.L$1 = r8
                        r0.L$2 = r9
                        r0.label = r3
                        java.lang.Object r9 = r9.k(r0)
                        if (r9 != r1) goto L_0x005d
                        return r1
                    L_0x005d:
                        r0 = r7
                    L_0x005e:
                        kotlin.jvm.internal.y r9 = r1
                        kotlinx.coroutines.b0 r1 = r8
                        kotlinx.coroutines.d0 r3 = kotlinx.coroutines.d0.UNDISPATCHED
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest r2 = r3
                        kotlinx.coroutines.flow.d r0 = r6
                        r5 = 0
                        r4.<init>(r2, r0, r8, r5)
                        r5 = 1
                        r6 = 0
                        r2 = 0
                        kotlinx.coroutines.f1 r8 = kotlinx.coroutines.f.b(r1, r2, r3, r4, r5, r6)
                        r9.f725a = r8
                        kotlin.Unit r8 = kotlin.Unit.f12577a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.i(java.lang.Object, kotlin.coroutines.d):java.lang.Object");
                }
            };
            this.label = 1;
            if (cVar.a(r52, this) == c10) {
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
    public final Object invoke(b0 b0Var, d dVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
