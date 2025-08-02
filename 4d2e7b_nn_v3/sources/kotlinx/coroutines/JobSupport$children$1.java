package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {956, 958}, m = "invokeSuspend")
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, d dVar) {
        super(2, dVar);
        this.this$0 = jobSupport;
    }

    public final d k(Object obj, d dVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, dVar);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x0026
            if (r1 != r2) goto L_0x001e
            java.lang.Object r1 = r6.L$2
            cc.o r1 = (cc.o) r1
            java.lang.Object r3 = r6.L$1
            cc.m r3 = (cc.m) r3
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.p.b(r7)
            goto L_0x0081
        L_0x001e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0026:
            kotlin.p.b(r7)
            goto L_0x0086
        L_0x002a:
            kotlin.p.b(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.g r7 = (kotlin.sequences.g) r7
            kotlinx.coroutines.JobSupport r1 = r6.this$0
            java.lang.Object r1 = r1.c0()
            boolean r4 = r1 instanceof kotlinx.coroutines.n
            if (r4 == 0) goto L_0x0048
            kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) r1
            kotlinx.coroutines.o r1 = r1.f1106e
            r6.label = r3
            java.lang.Object r7 = r7.c(r1, r6)
            if (r7 != r0) goto L_0x0086
            return r0
        L_0x0048:
            boolean r3 = r1 instanceof kotlinx.coroutines.z0
            if (r3 == 0) goto L_0x0086
            kotlinx.coroutines.z0 r1 = (kotlinx.coroutines.z0) r1
            kotlinx.coroutines.o1 r1 = r1.c()
            if (r1 == 0) goto L_0x0086
            java.lang.Object r3 = r1.k()
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.m.d(r3, r4)
            cc.o r3 = (cc.o) r3
            r4 = r7
            r5 = r3
            r3 = r1
            r1 = r5
        L_0x0063:
            boolean r7 = kotlin.jvm.internal.m.b(r1, r3)
            if (r7 != 0) goto L_0x0086
            boolean r7 = r1 instanceof kotlinx.coroutines.n
            if (r7 == 0) goto L_0x0081
            r7 = r1
            kotlinx.coroutines.n r7 = (kotlinx.coroutines.n) r7
            kotlinx.coroutines.o r7 = r7.f1106e
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.c(r7, r6)
            if (r7 != r0) goto L_0x0081
            return r0
        L_0x0081:
            cc.o r1 = r1.l()
            goto L_0x0063
        L_0x0086:
            kotlin.Unit r7 = kotlin.Unit.f12577a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((JobSupport$children$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
