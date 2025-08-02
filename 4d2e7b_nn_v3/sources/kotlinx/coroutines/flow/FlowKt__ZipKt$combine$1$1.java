package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {33, 33}, m = "invokeSuspend")
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements n {
    final /* synthetic */ n $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ZipKt$combine$1$1(n nVar, d dVar) {
        super(3, dVar);
        this.$transform = nVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.p.b(r7)
            goto L_0x004c
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r7)
            goto L_0x0040
        L_0x0022:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            java.lang.Object r7 = r6.L$1
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            vb.n r4 = r6.$transform
            r5 = 0
            r5 = r7[r5]
            r7 = r7[r3]
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r4.e(r5, r7, r6)
            if (r7 != r0) goto L_0x0040
            return r0
        L_0x0040:
            r3 = 0
            r6.L$0 = r3
            r6.label = r2
            java.lang.Object r7 = r1.i(r7, r6)
            if (r7 != r0) goto L_0x004c
            return r0
        L_0x004c:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object e(d dVar, Object[] objArr, d dVar2) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.$transform, dVar2);
        flowKt__ZipKt$combine$1$1.L$0 = dVar;
        flowKt__ZipKt$combine$1$1.L$1 = objArr;
        return flowKt__ZipKt$combine$1$1.n(Unit.f12577a);
    }
}
