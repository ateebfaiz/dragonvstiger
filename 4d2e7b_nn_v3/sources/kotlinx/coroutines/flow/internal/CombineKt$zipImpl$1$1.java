package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.q;
import vb.n;

@c(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {126}, m = "invokeSuspend")
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c $flow;
    final /* synthetic */ kotlinx.coroutines.flow.c $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.d $this_unsafeFlow;
    final /* synthetic */ n $transform;
    private /* synthetic */ Object L$0;
    int label;

    static final class a extends kotlin.jvm.internal.n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f1040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.d f1041b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar, kotlinx.coroutines.flow.d dVar) {
            super(1);
            this.f1040a = qVar;
            this.f1041b = dVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.f12577a;
        }

        public final void invoke(Throwable th) {
            if (this.f1040a.a()) {
                this.f1040a.b(new a(this.f1041b));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.d dVar, kotlinx.coroutines.flow.c cVar, kotlinx.coroutines.flow.c cVar2, n nVar, d dVar2) {
        super(2, dVar2);
        this.$this_unsafeFlow = dVar;
        this.$flow2 = cVar;
        this.$flow = cVar2;
        this.$transform = nVar;
    }

    public final d k(Object obj, d dVar) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, dVar);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 != r9) goto L_0x001e
            java.lang.Object r0 = r8.L$0
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlin.p.b(r20)     // Catch:{ a -> 0x001b }
            goto L_0x008b
        L_0x0018:
            r0 = move-exception
            goto L_0x00a4
        L_0x001b:
            r0 = move-exception
            goto L_0x009b
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            kotlin.p.b(r20)
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.b0 r1 = (kotlinx.coroutines.b0) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.c r2 = r8.$flow2
            r5.<init>(r2, r10)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            r2 = r1
            kotlinx.coroutines.channels.ReceiveChannel r7 = kotlinx.coroutines.channels.ProduceKt.d(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.q r2 = kotlinx.coroutines.k1.b(r10, r9, r10)
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            kotlin.jvm.internal.m.d(r7, r3)
            r3 = r7
            kotlinx.coroutines.channels.p r3 = (kotlinx.coroutines.channels.p) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$a r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$a
            kotlinx.coroutines.flow.d r5 = r8.$this_unsafeFlow
            r4.<init>(r2, r5)
            r3.u(r4)
            kotlin.coroutines.CoroutineContext r13 = r1.getCoroutineContext()     // Catch:{ a -> 0x0098, all -> 0x0095 }
            java.lang.Object r14 = cc.g0.b(r13)     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r2)     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.c r12 = r8.$flow     // Catch:{ a -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.d r3 = r8.$this_unsafeFlow     // Catch:{ a -> 0x0098, all -> 0x0095 }
            vb.n r5 = r8.$transform     // Catch:{ a -> 0x0098, all -> 0x0095 }
            r18 = 0
            r11 = r4
            r15 = r7
            r16 = r3
            r17 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ a -> 0x0098, all -> 0x0095 }
            r8.L$0 = r7     // Catch:{ a -> 0x0098, all -> 0x0095 }
            r8.label = r9     // Catch:{ a -> 0x0098, all -> 0x0095 }
            r3 = 0
            r6 = 4
            r11 = 0
            r5 = r19
            r12 = r7
            r7 = r11
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.e.d(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x0092, all -> 0x008f }
            if (r1 != r0) goto L_0x008a
            return r0
        L_0x008a:
            r1 = r12
        L_0x008b:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            goto L_0x00a1
        L_0x008f:
            r0 = move-exception
        L_0x0090:
            r1 = r12
            goto L_0x00a4
        L_0x0092:
            r0 = move-exception
        L_0x0093:
            r1 = r12
            goto L_0x009b
        L_0x0095:
            r0 = move-exception
            r12 = r7
            goto L_0x0090
        L_0x0098:
            r0 = move-exception
            r12 = r7
            goto L_0x0093
        L_0x009b:
            kotlinx.coroutines.flow.d r2 = r8.$this_unsafeFlow     // Catch:{ all -> 0x0018 }
            kotlinx.coroutines.flow.internal.k.a(r0, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x008b
        L_0x00a1:
            kotlin.Unit r0 = kotlin.Unit.f12577a
            return r0
        L_0x00a4:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((CombineKt$zipImpl$1$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
