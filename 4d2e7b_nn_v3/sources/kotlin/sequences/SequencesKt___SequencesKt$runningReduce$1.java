package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", l = {2366, 2369}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Function2<Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduce$1(Sequence sequence, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_runningReduce = sequence;
        this.$operation = function2;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, dVar);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.sequences.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0017:
            java.lang.Object r1 = r6.L$2
            java.lang.Object r3 = r6.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r7)
            goto L_0x004d
        L_0x0025:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            r4 = r7
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.sequences.Sequence<java.lang.Object> r7 = r6.$this_runningReduce
            java.util.Iterator r7 = r7.iterator()
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r7.next()
            r6.L$0 = r4
            r6.L$1 = r7
            r6.L$2 = r1
            r6.label = r3
            java.lang.Object r3 = r4.c(r1, r6)
            if (r3 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r3 = r7
        L_0x004d:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x006c
            kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Object> r7 = r6.$operation
            java.lang.Object r5 = r3.next()
            java.lang.Object r1 = r7.invoke(r1, r5)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.c(r1, r6)
            if (r7 != r0) goto L_0x004d
            return r0
        L_0x006c:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt___SequencesKt$runningReduce$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
