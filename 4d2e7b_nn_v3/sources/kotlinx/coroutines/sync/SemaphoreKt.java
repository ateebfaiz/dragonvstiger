package kotlinx.coroutines.sync;

import cc.c0;

public abstract class SemaphoreKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f1177a = f0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f1178b = new c0("PERMIT");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f1179c = new c0("TAKEN");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f1180d = new c0("BROKEN");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f1181e = new c0("CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f1182f = f0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    /* access modifiers changed from: private */
    public static final d h(long j10, d dVar) {
        return new d(j10, dVar, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object i(kotlinx.coroutines.sync.b r4, kotlin.jvm.functions.Function0 r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.b r4 = (kotlinx.coroutines.sync.b) r4
            kotlin.p.b(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.p.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.a(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Object r5 = r5.invoke()     // Catch:{ all -> 0x0058 }
            kotlin.jvm.internal.k.b(r3)
            r4.release()
            kotlin.jvm.internal.k.a(r3)
            return r5
        L_0x0058:
            r5 = move-exception
            kotlin.jvm.internal.k.b(r3)
            r4.release()
            kotlin.jvm.internal.k.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.i(kotlinx.coroutines.sync.b, kotlin.jvm.functions.Function0, kotlin.coroutines.d):java.lang.Object");
    }
}
