package kotlin.sequences;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", l = {145}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ kotlin.random.c $random;
    final /* synthetic */ Sequence<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(Sequence sequence, kotlin.random.c cVar, d dVar) {
        super(2, dVar);
        this.$this_shuffled = sequence;
        this.$random = cVar;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, dVar);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    public final Object n(Object obj) {
        g gVar;
        List list;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            list = m.v(this.$this_shuffled);
            gVar = (g) this.L$0;
        } else if (i10 == 1) {
            list = (List) this.L$1;
            gVar = (g) this.L$0;
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!list.isEmpty()) {
            int d10 = this.$random.d(list.size());
            Object F = r.F(list);
            if (d10 < list.size()) {
                F = list.set(d10, F);
            }
            this.L$0 = gVar;
            this.L$1 = list;
            this.label = 1;
            if (gVar.c(F, this) == c10) {
                return c10;
            }
        }
        return Unit.f12577a;
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt__SequencesKt$shuffled$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
