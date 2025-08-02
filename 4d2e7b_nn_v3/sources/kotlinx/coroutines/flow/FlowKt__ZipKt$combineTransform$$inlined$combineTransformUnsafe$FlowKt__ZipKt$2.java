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
import vb.o;

@c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2", f = "Zip.kt", l = {273}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2 extends SuspendLambda implements Function2<d, d, Object> {
    final /* synthetic */ c[] $flows;
    final /* synthetic */ o $transform$inlined;
    private /* synthetic */ Object L$0;
    int label;

    @c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2$1", f = "Zip.kt", l = {333}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public final Object n(Object obj) {
            Object c10 = b.c();
            int i10 = this.label;
            if (i10 == 0) {
                p.b(obj);
                Object[] objArr = (Object[]) this.L$1;
                o oVar = oVar;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                this.label = 1;
                k.c(6);
                Object invoke = oVar.invoke((d) this.L$0, obj2, obj3, this);
                k.c(7);
                if (invoke == c10) {
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
        public final Object e(d dVar, Object[] objArr, d dVar2) {
            AnonymousClass1 r02 = new AnonymousClass1(dVar2, oVar);
            r02.L$0 = dVar;
            r02.L$1 = objArr;
            return r02.n(Unit.f12577a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(c[] cVarArr, d dVar, o oVar) {
        super(2, dVar);
        this.$flows = cVarArr;
        this.$transform$inlined = oVar;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(this.$flows, dVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            c[] cVarArr = this.$flows;
            Function0 a10 = h1.b();
            final o oVar = this.$transform$inlined;
            AnonymousClass1 r42 = new AnonymousClass1((d) null);
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
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
