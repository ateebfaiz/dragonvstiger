package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", l = {292, 292}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combine$6$2 extends SuspendLambda implements n {
    final /* synthetic */ Function2<Object[], d, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$2(Function2 function2, d dVar) {
        super(3, dVar);
        this.$transform = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.p.b(r6)
            goto L_0x0047
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r6)
            goto L_0x003b
        L_0x0022:
            kotlin.p.b(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            java.lang.Object r6 = r5.L$1
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            kotlin.jvm.functions.Function2<java.lang.Object[], kotlin.coroutines.d, java.lang.Object> r4 = r5.$transform
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.invoke(r6, r5)
            if (r6 != r0) goto L_0x003b
            return r0
        L_0x003b:
            r3 = 0
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = r1.i(r6, r5)
            if (r6 != r0) goto L_0x0047
            return r0
        L_0x0047:
            kotlin.Unit r6 = kotlin.Unit.f12577a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object e(d dVar, Object[] objArr, d dVar2) {
        m.j();
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, dVar2);
        flowKt__ZipKt$combine$6$2.L$0 = dVar;
        flowKt__ZipKt$combine$6$2.L$1 = objArr;
        return flowKt__ZipKt$combine$6$2.n(Unit.f12577a);
    }
}
