package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.channels.n;

@c(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", l = {89}, m = "invokeSuspend")
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c $flow2;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.c cVar, d dVar) {
        super(2, dVar);
        this.$flow2 = cVar;
    }

    public final d k(Object obj, d dVar) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, dVar);
        combineKt$zipImpl$1$1$second$1.L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            final n nVar = (n) this.L$0;
            kotlinx.coroutines.flow.c cVar = this.$flow2;
            AnonymousClass1 r32 = new kotlinx.coroutines.flow.d() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object i(java.lang.Object r5, kotlin.coroutines.d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.p.b(r6)
                        goto L_0x0047
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.p.b(r6)
                        kotlinx.coroutines.channels.n r6 = r5
                        kotlinx.coroutines.channels.p r6 = r6.i()
                        if (r5 != 0) goto L_0x003e
                        cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
                    L_0x003e:
                        r0.label = r3
                        java.lang.Object r5 = r6.x(r5, r0)
                        if (r5 != r1) goto L_0x0047
                        return r1
                    L_0x0047:
                        kotlin.Unit r5 = kotlin.Unit.f12577a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1.AnonymousClass1.i(java.lang.Object, kotlin.coroutines.d):java.lang.Object");
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
        return ((CombineKt$zipImpl$1$1$second$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
