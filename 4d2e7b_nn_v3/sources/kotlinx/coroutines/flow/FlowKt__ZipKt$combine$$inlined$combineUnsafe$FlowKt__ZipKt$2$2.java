package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.k;
import vb.n;
import vb.p;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 extends SuspendLambda implements n {
    final /* synthetic */ p $transform$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2(d dVar, p pVar) {
        super(3, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.p.b(obj);
                this.L$0 = null;
                this.label = 2;
                if (((d) this.L$0).i(obj, this) == c10) {
                    return c10;
                }
            } else if (i10 == 2) {
                kotlin.p.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f12577a;
        }
        kotlin.p.b(obj);
        Object[] objArr = (Object[]) this.L$1;
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        Object obj4 = objArr[2];
        Object obj5 = objArr[3];
        this.L$0 = (d) this.L$0;
        this.label = 1;
        k.c(6);
        throw null;
    }

    /* renamed from: u */
    public final Object e(d dVar, Object[] objArr, d dVar2) {
        FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 = new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2(dVar2, (p) null);
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.L$0 = dVar;
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.L$1 = objArr;
        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.n(Unit.f12577a);
    }
}
