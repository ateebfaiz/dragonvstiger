package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.k;
import kotlin.p;
import kotlinx.coroutines.flow.internal.CombineKt;
import vb.n;
import vb.r;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5", f = "Zip.kt", l = {273}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 extends SuspendLambda implements Function2<d, d, Object> {
    final /* synthetic */ c[] $flows;
    final /* synthetic */ r $transform$inlined;
    private /* synthetic */ Object L$0;
    int label;

    @c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1", f = "Zip.kt", l = {333}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ r $transform$inlined;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public final Object n(Object obj) {
            b.c();
            int i10 = this.label;
            if (i10 == 0) {
                p.b(obj);
                d dVar = (d) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.label = 1;
                k.c(6);
                throw null;
            } else if (i10 == 1) {
                p.b(obj);
                return Unit.f12577a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: u */
        public final Object e(d dVar, Object[] objArr, d dVar2) {
            AnonymousClass1 r02 = new AnonymousClass1(dVar2, (r) null);
            r02.L$0 = dVar;
            r02.L$1 = objArr;
            return r02.n(Unit.f12577a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(c[] cVarArr, d dVar, r rVar) {
        super(2, dVar);
        this.$flows = cVarArr;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(this.$flows, dVar, (r) null);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            c[] cVarArr = this.$flows;
            Function0 a10 = h1.b();
            AnonymousClass1 r42 = new AnonymousClass1((d) null, (r) null);
            this.label = 1;
            if (CombineKt.a((d) this.L$0, cVarArr, a10, r42, this) == c10) {
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
    public final Object invoke(d dVar, d dVar2) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
