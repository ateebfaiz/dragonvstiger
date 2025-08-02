package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import vb.n;

@c(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", l = {2336, 2341}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ n $operation;
    final /* synthetic */ Sequence<Object> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, Sequence sequence, n nVar, d dVar) {
        super(2, dVar);
        this.$initial = obj;
        this.$this_runningFoldIndexed = sequence;
        this.$operation = nVar;
    }

    public final d k(Object obj, d dVar) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, dVar);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.sequences.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r8.I$0
            java.lang.Object r3 = r8.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r8.L$1
            java.lang.Object r5 = r8.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.p.b(r9)
            r9 = r4
            r4 = r1
            goto L_0x004f
        L_0x0020:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0028:
            java.lang.Object r1 = r8.L$0
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            kotlin.p.b(r9)
            goto L_0x0045
        L_0x0030:
            kotlin.p.b(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            java.lang.Object r9 = r8.$initial
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r1.c(r9, r8)
            if (r9 != r0) goto L_0x0045
            return r0
        L_0x0045:
            java.lang.Object r9 = r8.$initial
            kotlin.sequences.Sequence<java.lang.Object> r3 = r8.$this_runningFoldIndexed
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r1
        L_0x004f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x007e
            java.lang.Object r1 = r3.next()
            vb.n r6 = r8.$operation
            int r7 = r4 + 1
            if (r4 >= 0) goto L_0x0062
            kotlin.collections.r.u()
        L_0x0062:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.b(r4)
            java.lang.Object r4 = r6.e(r4, r9, r1)
            r8.L$0 = r5
            r8.L$1 = r4
            r8.L$2 = r3
            r8.I$0 = r7
            r8.label = r2
            java.lang.Object r9 = r5.c(r4, r8)
            if (r9 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r9 = r4
            r4 = r7
            goto L_0x004f
        L_0x007e:
            kotlin.Unit r9 = kotlin.Unit.f12577a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
