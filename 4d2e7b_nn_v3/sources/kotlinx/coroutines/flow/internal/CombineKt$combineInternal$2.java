package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;
import vb.n;

@c(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Function0<Object[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.c[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.d $this_combineInternal;
    final /* synthetic */ n $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(kotlinx.coroutines.flow.c[] cVarArr, Function0 function0, n nVar, kotlinx.coroutines.flow.d dVar, d dVar2) {
        super(2, dVar2);
        this.$flows = cVarArr;
        this.$arrayFactory = function0;
        this.$transform = nVar;
        this.$this_combineInternal = dVar;
    }

    public final d k(Object obj, d dVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, dVar);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ca A[LOOP:1: B:25:0x00ca->B:31:0x00ed, LOOP_START, PHI: r6 r10 
      PHI: (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:22:0x00c5, B:31:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:22:0x00c5, B:31:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r5) goto L_0x0035
            if (r2 == r4) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001c:
            int r2 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.e r8 = (kotlinx.coroutines.channels.e) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.p.b(r24)
            r21 = r2
            r2 = r7
            r7 = r8
            goto L_0x0137
        L_0x0035:
            int r2 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.e r8 = (kotlinx.coroutines.channels.e) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.p.b(r24)
            r10 = r24
            kotlinx.coroutines.channels.g r10 = (kotlinx.coroutines.channels.g) r10
            java.lang.Object r10 = r10.k()
            r22 = r8
            r8 = r2
            r2 = r7
            r7 = r22
            goto L_0x00bf
        L_0x0058:
            kotlin.p.b(r24)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.b0 r2 = (kotlinx.coroutines.b0) r2
            kotlinx.coroutines.flow.c[] r6 = r0.$flows
            int r12 = r6.length
            if (r12 != 0) goto L_0x0067
            kotlin.Unit r1 = kotlin.Unit.f12577a
            return r1
        L_0x0067:
            java.lang.Object[] r13 = new java.lang.Object[r12]
            cc.c0 r7 = kotlinx.coroutines.flow.internal.n.f1057b
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r13
            kotlin.collections.j.m(r6, r7, r8, r9, r10, r11)
            r6 = 6
            r7 = 0
            kotlinx.coroutines.channels.e r20 = kotlinx.coroutines.channels.f.b(r12, r7, r7, r6, r7)
            java.util.concurrent.atomic.AtomicInteger r11 = new java.util.concurrent.atomic.AtomicInteger
            r11.<init>(r12)
            r21 = 0
            r10 = r21
        L_0x0082:
            if (r10 >= r12) goto L_0x00a3
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r9 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.c[] r15 = r0.$flows
            r19 = 0
            r14 = r9
            r16 = r10
            r17 = r11
            r18 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r14 = 3
            r15 = 0
            r7 = 0
            r8 = 0
            r6 = r2
            r10 = r14
            r14 = r11
            r11 = r15
            kotlinx.coroutines.f1 unused = kotlinx.coroutines.f.b(r6, r7, r8, r9, r10, r11)
            int r10 = r16 + 1
            r11 = r14
            goto L_0x0082
        L_0x00a3:
            byte[] r2 = new byte[r12]
            r6 = r12
            r7 = r20
        L_0x00a8:
            int r8 = r21 + 1
            byte r8 = (byte) r8
            r0.L$0 = r13
            r0.L$1 = r7
            r0.L$2 = r2
            r0.I$0 = r6
            r0.I$1 = r8
            r0.label = r5
            java.lang.Object r10 = r7.h(r0)
            if (r10 != r1) goto L_0x00be
            return r1
        L_0x00be:
            r9 = r13
        L_0x00bf:
            java.lang.Object r10 = kotlinx.coroutines.channels.g.f(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00ca
            kotlin.Unit r1 = kotlin.Unit.f12577a
            return r1
        L_0x00ca:
            int r11 = r10.a()
            r12 = r9[r11]
            java.lang.Object r10 = r10.b()
            r9[r11] = r10
            cc.c0 r10 = kotlinx.coroutines.flow.internal.n.f1057b
            if (r12 != r10) goto L_0x00dc
            int r6 = r6 + -1
        L_0x00dc:
            byte r10 = r2[r11]
            if (r10 == r8) goto L_0x00ef
            byte r10 = (byte) r8
            r2[r11] = r10
            java.lang.Object r10 = r7.g()
            java.lang.Object r10 = kotlinx.coroutines.channels.g.f(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00ca
        L_0x00ef:
            if (r6 != 0) goto L_0x0135
            kotlin.jvm.functions.Function0<java.lang.Object[]> r10 = r0.$arrayFactory
            java.lang.Object r10 = r10.invoke()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x0112
            vb.n r10 = r0.$transform
            kotlinx.coroutines.flow.d r11 = r0.$this_combineInternal
            r0.L$0 = r9
            r0.L$1 = r7
            r0.L$2 = r2
            r0.I$0 = r6
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r10 = r10.e(r11, r9, r0)
            if (r10 != r1) goto L_0x0135
            return r1
        L_0x0112:
            r16 = 14
            r17 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r11 = r9
            r12 = r10
            kotlin.collections.j.g(r11, r12, r13, r14, r15, r16, r17)
            vb.n r11 = r0.$transform
            kotlinx.coroutines.flow.d r12 = r0.$this_combineInternal
            r0.L$0 = r9
            r0.L$1 = r7
            r0.L$2 = r2
            r0.I$0 = r6
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r10 = r11.e(r12, r10, r0)
            if (r10 != r1) goto L_0x0135
            return r1
        L_0x0135:
            r21 = r8
        L_0x0137:
            r13 = r9
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((CombineKt$combineInternal$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
