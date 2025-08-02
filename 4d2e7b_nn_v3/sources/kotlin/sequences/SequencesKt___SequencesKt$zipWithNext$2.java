package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;

@c(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", l = {2873}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Sequence<Object> $this_zipWithNext;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence sequence, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_zipWithNext = sequence;
        this.$transform = function2;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, dVar);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r1 = r6.L$2
            java.lang.Object r3 = r6.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r7)
        L_0x0018:
            r7 = r1
            goto L_0x003f
        L_0x001a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0022:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.g r7 = (kotlin.sequences.g) r7
            kotlin.sequences.Sequence<java.lang.Object> r1 = r6.$this_zipWithNext
            java.util.Iterator r1 = r1.iterator()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x0038
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        L_0x0038:
            java.lang.Object r3 = r1.next()
            r4 = r7
            r7 = r3
            r3 = r1
        L_0x003f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r3.next()
            kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Object> r5 = r6.$transform
            java.lang.Object r7 = r5.invoke(r7, r1)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.c(r7, r6)
            if (r7 != r0) goto L_0x0018
            return r0
        L_0x005e:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) k(gVar, dVar)).n(Unit.f12577a);
    }
}
