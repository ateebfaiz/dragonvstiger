package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import vb.n;
import vb.o;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 extends SuspendLambda implements n {
    final /* synthetic */ o $transform$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(d dVar, o oVar) {
        super(3, dVar);
        this.$transform$inlined = oVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.p.b(r8)
            goto L_0x0056
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r8)
            goto L_0x004a
        L_0x0022:
            kotlin.p.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            java.lang.Object r8 = r7.L$1
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            vb.o r4 = r7.$transform$inlined
            r5 = 0
            r5 = r8[r5]
            r6 = r8[r3]
            r8 = r8[r2]
            r7.L$0 = r1
            r7.label = r3
            r3 = 6
            kotlin.jvm.internal.k.c(r3)
            java.lang.Object r8 = r4.invoke(r5, r6, r8, r7)
            r3 = 7
            kotlin.jvm.internal.k.c(r3)
            if (r8 != r0) goto L_0x004a
            return r0
        L_0x004a:
            r3 = 0
            r7.L$0 = r3
            r7.label = r2
            java.lang.Object r8 = r1.i(r8, r7)
            if (r8 != r0) goto L_0x0056
            return r0
        L_0x0056:
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object e(d dVar, Object[] objArr, d dVar2) {
        FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 = new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(dVar2, this.$transform$inlined);
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.L$0 = dVar;
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.L$1 = objArr;
        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.n(Unit.f12577a);
    }
}
