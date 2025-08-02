package kotlin.collections;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ Iterator<Object> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i10, int i11, Iterator it, boolean z10, boolean z11, d dVar) {
        super(2, dVar);
        this.$size = i10;
        this.$step = i11;
        this.$iterator = it;
        this.$reuseBuffer = z10;
        this.$partialWindows = z11;
    }

    public final d k(Object obj, d dVar) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, dVar);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0121 A[SYNTHETIC] */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0057
            if (r1 == r6) goto L_0x0044
            if (r1 == r5) goto L_0x003f
            if (r1 == r4) goto L_0x002e
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            goto L_0x003f
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            java.lang.Object r1 = r10.L$1
            kotlin.collections.q0 r1 = (kotlin.collections.q0) r1
            java.lang.Object r4 = r10.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r11)
            goto L_0x0149
        L_0x002e:
            java.lang.Object r1 = r10.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r10.L$1
            kotlin.collections.q0 r5 = (kotlin.collections.q0) r5
            java.lang.Object r8 = r10.L$0
            kotlin.sequences.g r8 = (kotlin.sequences.g) r8
            kotlin.p.b(r11)
            goto L_0x011b
        L_0x003f:
            kotlin.p.b(r11)
            goto L_0x0165
        L_0x0044:
            int r1 = r10.I$0
            java.lang.Object r2 = r10.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r10.L$1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.Object r4 = r10.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r11)
        L_0x0055:
            r11 = r1
            goto L_0x00a5
        L_0x0057:
            kotlin.p.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlin.sequences.g r11 = (kotlin.sequences.g) r11
            int r1 = r10.$size
            r8 = 1024(0x400, float:1.435E-42)
            int r1 = kotlin.ranges.l.f(r1, r8)
            int r8 = r10.$step
            int r9 = r10.$size
            int r8 = r8 - r9
            if (r8 < 0) goto L_0x00d9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.Iterator<java.lang.Object> r1 = r10.$iterator
            r3 = 0
            r4 = r11
            r11 = r3
            r3 = r2
            r2 = r1
            r1 = r8
        L_0x007a:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x00b7
            java.lang.Object r8 = r2.next()
            if (r11 <= 0) goto L_0x0089
            int r11 = r11 + -1
            goto L_0x007a
        L_0x0089:
            r3.add(r8)
            int r8 = r3.size()
            int r9 = r10.$size
            if (r8 != r9) goto L_0x007a
            r10.L$0 = r4
            r10.L$1 = r3
            r10.L$2 = r2
            r10.I$0 = r1
            r10.label = r6
            java.lang.Object r11 = r4.c(r3, r10)
            if (r11 != r0) goto L_0x0055
            return r0
        L_0x00a5:
            boolean r1 = r10.$reuseBuffer
            if (r1 == 0) goto L_0x00ad
            r3.clear()
            goto L_0x00b5
        L_0x00ad:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r10.$size
            r1.<init>(r3)
            r3 = r1
        L_0x00b5:
            r1 = r11
            goto L_0x007a
        L_0x00b7:
            boolean r11 = r3.isEmpty()
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x0165
            boolean r11 = r10.$partialWindows
            if (r11 != 0) goto L_0x00ca
            int r11 = r3.size()
            int r1 = r10.$size
            if (r11 != r1) goto L_0x0165
        L_0x00ca:
            r10.L$0 = r7
            r10.L$1 = r7
            r10.L$2 = r7
            r10.label = r5
            java.lang.Object r11 = r4.c(r3, r10)
            if (r11 != r0) goto L_0x0165
            return r0
        L_0x00d9:
            kotlin.collections.q0 r5 = new kotlin.collections.q0
            r5.<init>(r1)
            java.util.Iterator<java.lang.Object> r1 = r10.$iterator
            r8 = r11
        L_0x00e1:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0121
            java.lang.Object r11 = r1.next()
            r5.e(r11)
            boolean r11 = r5.i()
            if (r11 == 0) goto L_0x00e1
            int r11 = r5.size()
            int r9 = r10.$size
            if (r11 >= r9) goto L_0x0101
            kotlin.collections.q0 r5 = r5.f(r9)
            goto L_0x00e1
        L_0x0101:
            boolean r11 = r10.$reuseBuffer
            if (r11 == 0) goto L_0x0107
            r11 = r5
            goto L_0x010c
        L_0x0107:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r5)
        L_0x010c:
            r10.L$0 = r8
            r10.L$1 = r5
            r10.L$2 = r1
            r10.label = r4
            java.lang.Object r11 = r8.c(r11, r10)
            if (r11 != r0) goto L_0x011b
            return r0
        L_0x011b:
            int r11 = r10.$step
            r5.j(r11)
            goto L_0x00e1
        L_0x0121:
            boolean r11 = r10.$partialWindows
            if (r11 == 0) goto L_0x0165
            r1 = r5
            r4 = r8
        L_0x0127:
            int r11 = r1.size()
            int r5 = r10.$step
            if (r11 <= r5) goto L_0x014f
            boolean r11 = r10.$reuseBuffer
            if (r11 == 0) goto L_0x0135
            r11 = r1
            goto L_0x013a
        L_0x0135:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r1)
        L_0x013a:
            r10.L$0 = r4
            r10.L$1 = r1
            r10.L$2 = r7
            r10.label = r3
            java.lang.Object r11 = r4.c(r11, r10)
            if (r11 != r0) goto L_0x0149
            return r0
        L_0x0149:
            int r11 = r10.$step
            r1.j(r11)
            goto L_0x0127
        L_0x014f:
            boolean r11 = r1.isEmpty()
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x0165
            r10.L$0 = r7
            r10.L$1 = r7
            r10.L$2 = r7
            r10.label = r2
            java.lang.Object r11 = r4.c(r1, r10)
            if (r11 != r0) goto L_0x0165
            return r0
        L_0x0165:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((SlidingWindowKt$windowedIterator$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
