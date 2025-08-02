package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import vb.n;

@c(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", l = {2395, 2399}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ n $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence sequence, n nVar, d dVar) {
        super(2, dVar);
        this.$this_runningReduceIndexed = sequence;
        this.$operation = nVar;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, dVar);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.sequences.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.lang.Object r4 = r9.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.p.b(r10)
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x005e
        L_0x0021:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0029:
            java.lang.Object r1 = r9.L$2
            java.lang.Object r4 = r9.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.p.b(r10)
            goto L_0x005e
        L_0x0037:
            kotlin.p.b(r10)
            java.lang.Object r10 = r9.L$0
            r5 = r10
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.sequences.Sequence<java.lang.Object> r10 = r9.$this_runningReduceIndexed
            java.util.Iterator r4 = r10.iterator()
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x008d
            java.lang.Object r1 = r4.next()
            r9.L$0 = r5
            r9.L$1 = r4
            r9.L$2 = r1
            r9.label = r3
            java.lang.Object r10 = r5.c(r1, r9)
            if (r10 != r0) goto L_0x005e
            return r0
        L_0x005e:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x008d
            vb.n r10 = r9.$operation
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x006d
            kotlin.collections.r.u()
        L_0x006d:
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.b(r3)
            java.lang.Object r7 = r4.next()
            java.lang.Object r3 = r10.e(r3, r1, r7)
            r9.L$0 = r5
            r9.L$1 = r4
            r9.L$2 = r3
            r9.I$0 = r6
            r9.label = r2
            java.lang.Object r10 = r5.c(r3, r9)
            if (r10 != r0) goto L_0x008a
            return r0
        L_0x008a:
            r1 = r3
            r3 = r6
            goto L_0x005e
        L_0x008d:
            kotlin.Unit r10 = kotlin.Unit.f12577a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
