package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", l = {69, 71}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Function0<Sequence<Object>> $defaultValue;
    final /* synthetic */ Sequence<Object> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(Sequence sequence, Function0 function0, d dVar) {
        super(2, dVar);
        this.$this_ifEmpty = sequence;
        this.$defaultValue = function0;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, dVar);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            g gVar = (g) this.L$0;
            Iterator it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.label = 1;
                if (gVar.e(it, this) == c10) {
                    return c10;
                }
            } else {
                this.label = 2;
                if (gVar.f((Sequence) this.$defaultValue.invoke(), this) == c10) {
                    return c10;
                }
            }
        } else if (i10 == 1 || i10 == 2) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
