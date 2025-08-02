package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", l = {2308, 2312}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFold$1(Object obj, Sequence sequence, Function2 function2, d dVar) {
        super(2, dVar);
        this.$initial = obj;
        this.$this_runningFold = sequence;
        this.$operation = function2;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, dVar);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.sequences.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r6.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r6.L$1
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r7)
        L_0x001b:
            r7 = r3
            goto L_0x004c
        L_0x001d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0025:
            java.lang.Object r1 = r6.L$0
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            kotlin.p.b(r7)
            goto L_0x0042
        L_0x002d:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            java.lang.Object r7 = r6.$initial
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.c(r7, r6)
            if (r7 != r0) goto L_0x0042
            return r0
        L_0x0042:
            java.lang.Object r7 = r6.$initial
            kotlin.sequences.Sequence<java.lang.Object> r3 = r6.$this_runningFold
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
            r1 = r3
        L_0x004c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r1.next()
            kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Object> r5 = r6.$operation
            java.lang.Object r3 = r5.invoke(r7, r3)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.c(r3, r6)
            if (r7 != r0) goto L_0x001b
            return r0
        L_0x006b:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt___SequencesKt$runningFold$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
