package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", l = {332}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Function1<Object, Iterator<Object>> $iterator;
    final /* synthetic */ Sequence<Object> $source;
    final /* synthetic */ Function2<Integer, Object, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$flatMapIndexed$1(Sequence sequence, Function2 function2, Function1 function1, d dVar) {
        super(2, dVar);
        this.$source = sequence;
        this.$transform = function2;
        this.$iterator = function1;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, dVar);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    public final Object n(Object obj) {
        int i10;
        g gVar;
        Iterator it;
        Object c10 = b.c();
        int i11 = this.label;
        if (i11 == 0) {
            p.b(obj);
            gVar = (g) this.L$0;
            i10 = 0;
            it = this.$source.iterator();
        } else if (i11 == 1) {
            int i12 = this.I$0;
            it = (Iterator) this.L$1;
            gVar = (g) this.L$0;
            p.b(obj);
            i10 = i12;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function2<Integer, Object, Object> function2 = this.$transform;
            int i13 = i10 + 1;
            if (i10 < 0) {
                r.u();
            }
            Object invoke = function2.invoke(a.b(i10), next);
            this.L$0 = gVar;
            this.L$1 = it;
            this.I$0 = i13;
            this.label = 1;
            if (gVar.e((Iterator) this.$iterator.invoke(invoke), this) == c10) {
                return c10;
            }
            i10 = i13;
        }
        return Unit.f12577a;
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
