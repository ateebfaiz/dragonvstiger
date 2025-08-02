package kotlinx.coroutines.channels;

public abstract class TickerChannelsKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: kotlinx.coroutines.channels.p} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(long r6, long r8, kotlinx.coroutines.channels.p r10, kotlin.coroutines.d r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.p r8 = (kotlinx.coroutines.channels.p) r8
            kotlin.p.b(r11)
        L_0x0034:
            r10 = r8
            goto L_0x0063
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.p r8 = (kotlinx.coroutines.channels.p) r8
            kotlin.p.b(r11)
            goto L_0x0073
        L_0x0048:
            long r6 = r0.J$0
            java.lang.Object r8 = r0.L$0
            r10 = r8
            kotlinx.coroutines.channels.p r10 = (kotlinx.coroutines.channels.p) r10
            kotlin.p.b(r11)
            goto L_0x0063
        L_0x0053:
            kotlin.p.b(r11)
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r8 = kotlin.Unit.f12577a
            r0.L$0 = r10
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r10.x(r8, r0)
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r8 = r10
        L_0x0073:
            r0.L$0 = r8
            r0.J$0 = r6
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r9 != r1) goto L_0x0034
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.c(long, long, kotlinx.coroutines.channels.p, kotlin.coroutines.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0104 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(long r18, long r20, kotlinx.coroutines.channels.p r22, kotlin.coroutines.d r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.b.c()
            int r3 = r1.label
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0079
            if (r3 == r7) goto L_0x006b
            if (r3 == r6) goto L_0x005f
            if (r3 == r5) goto L_0x004c
            if (r3 != r4) goto L_0x0044
            long r7 = r1.J$1
            long r9 = r1.J$0
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.channels.p r3 = (kotlinx.coroutines.channels.p) r3
            kotlin.p.b(r0)
            r11 = r4
            r0 = r5
        L_0x003d:
            r16 = r7
            r7 = r9
            r9 = r16
            goto L_0x0105
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            long r7 = r1.J$1
            long r9 = r1.J$0
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.channels.p r3 = (kotlinx.coroutines.channels.p) r3
            kotlin.p.b(r0)
            r0 = r5
        L_0x0058:
            r16 = r7
            r7 = r9
            r9 = r16
            goto L_0x00ec
        L_0x005f:
            long r7 = r1.J$1
            long r9 = r1.J$0
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.channels.p r3 = (kotlinx.coroutines.channels.p) r3
            kotlin.p.b(r0)
            goto L_0x00ba
        L_0x006b:
            long r7 = r1.J$1
            long r9 = r1.J$0
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.channels.p r3 = (kotlinx.coroutines.channels.p) r3
            kotlin.p.b(r0)
            r0 = r3
            r10 = r9
            goto L_0x009e
        L_0x0079:
            kotlin.p.b(r0)
            kotlinx.coroutines.b.a()
            long r8 = java.lang.System.nanoTime()
            long r10 = kotlinx.coroutines.u0.d(r20)
            long r8 = r8 + r10
            r0 = r22
            r1.L$0 = r0
            r10 = r18
            r1.J$0 = r10
            r1.J$1 = r8
            r1.label = r7
            r12 = r20
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r12, r1)
            if (r3 != r2) goto L_0x009d
            return r2
        L_0x009d:
            r7 = r8
        L_0x009e:
            long r9 = kotlinx.coroutines.u0.d(r10)
        L_0x00a2:
            long r7 = r7 + r9
            kotlin.Unit r3 = kotlin.Unit.f12577a
            r1.L$0 = r0
            r1.J$0 = r7
            r1.J$1 = r9
            r1.label = r6
            java.lang.Object r3 = r0.x(r3, r1)
            if (r3 != r2) goto L_0x00b4
            return r2
        L_0x00b4:
            r3 = r0
            r16 = r7
            r7 = r9
            r9 = r16
        L_0x00ba:
            kotlinx.coroutines.b.a()
            long r11 = java.lang.System.nanoTime()
            long r13 = r9 - r11
            r4 = 0
            long r13 = kotlin.ranges.l.d(r13, r4)
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 != 0) goto L_0x00f0
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00f0
            long r4 = r11 - r9
            long r4 = r4 % r7
            long r4 = r7 - r4
            long r9 = r11 + r4
            long r4 = kotlinx.coroutines.u0.c(r4)
            r1.L$0 = r3
            r1.J$0 = r9
            r1.J$1 = r7
            r0 = 3
            r1.label = r0
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.b(r4, r1)
            if (r4 != r2) goto L_0x0058
            return r2
        L_0x00ec:
            r5 = r0
            r0 = r3
            r4 = 4
            goto L_0x00a2
        L_0x00f0:
            r0 = 3
            long r4 = kotlinx.coroutines.u0.c(r13)
            r1.L$0 = r3
            r1.J$0 = r9
            r1.J$1 = r7
            r11 = 4
            r1.label = r11
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.b(r4, r1)
            if (r4 != r2) goto L_0x003d
            return r2
        L_0x0105:
            r5 = r0
            r0 = r3
            r4 = r11
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.d(long, long, kotlinx.coroutines.channels.p, kotlin.coroutines.d):java.lang.Object");
    }
}
