package kotlinx.coroutines.flow;

import kotlin.jvm.internal.y;

final class DistinctFlowImpl$collect$2 implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DistinctFlowImpl f970a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ y f971b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f972c;

    DistinctFlowImpl$collect$2(DistinctFlowImpl distinctFlowImpl, y yVar, d dVar) {
        this.f970a = distinctFlowImpl;
        this.f971b = yVar;
        this.f972c = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(java.lang.Object r6, kotlin.coroutines.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.p.b(r7)
            goto L_0x0067
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.p.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl r7 = r5.f970a
            kotlin.jvm.functions.Function1 r7 = r7.f968b
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.y r2 = r5.f971b
            java.lang.Object r2 = r2.f725a
            cc.c0 r4 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r2 == r4) goto L_0x0058
            kotlinx.coroutines.flow.DistinctFlowImpl r4 = r5.f970a
            kotlin.jvm.functions.Function2 r4 = r4.f969c
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            kotlin.Unit r6 = kotlin.Unit.f12577a
            return r6
        L_0x0058:
            kotlin.jvm.internal.y r2 = r5.f971b
            r2.f725a = r7
            kotlinx.coroutines.flow.d r7 = r5.f972c
            r0.label = r3
            java.lang.Object r6 = r7.i(r6, r0)
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0067:
            kotlin.Unit r6 = kotlin.Unit.f12577a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.i(java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }
}
