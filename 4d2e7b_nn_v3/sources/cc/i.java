package cc;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.w1;

public abstract class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f74a = new c0("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f75b = new c0("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r8.M0() != false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        if (r8.M0() != false) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(kotlin.coroutines.d r6, java.lang.Object r7, kotlin.jvm.functions.Function1 r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00b2
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r8 = kotlinx.coroutines.w.b(r7, r8)
            kotlinx.coroutines.y r0 = r6.dispatcher
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.isDispatchNeeded(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6._state = r8
            r6.resumeMode = r1
            kotlinx.coroutines.y r7 = r6.dispatcher
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.dispatch(r8, r6)
            goto L_0x00b5
        L_0x0026:
            kotlinx.coroutines.w1 r0 = kotlinx.coroutines.w1.f1199a
            kotlinx.coroutines.q0 r0 = r0.a()
            boolean r2 = r0.M()
            if (r2 == 0) goto L_0x003b
            r6._state = r8
            r6.resumeMode = r1
            r0.I(r6)
            goto L_0x00b5
        L_0x003b:
            r0.K(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.f1$b r4 = kotlinx.coroutines.f1.f964r     // Catch:{ all -> 0x0068 }
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.f1 r3 = (kotlinx.coroutines.f1) r3     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x006a
            boolean r4 = r3.a()     // Catch:{ all -> 0x0068 }
            if (r4 != 0) goto L_0x006a
            java.util.concurrent.CancellationException r7 = r3.n()     // Catch:{ all -> 0x0068 }
            r6.b(r8, r7)     // Catch:{ all -> 0x0068 }
            kotlin.o$a r8 = kotlin.o.f12592b     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = kotlin.p.a(r7)     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = kotlin.o.b(r7)     // Catch:{ all -> 0x0068 }
            r6.d(r7)     // Catch:{ all -> 0x0068 }
            goto L_0x0092
        L_0x0068:
            r7 = move-exception
            goto L_0x00a9
        L_0x006a:
            kotlin.coroutines.d r8 = r6.continuation     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = r6.countOrElement     // Catch:{ all -> 0x0068 }
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = cc.g0.c(r4, r3)     // Catch:{ all -> 0x0068 }
            cc.c0 r5 = cc.g0.f66a     // Catch:{ all -> 0x0068 }
            if (r3 == r5) goto L_0x007f
            kotlinx.coroutines.UndispatchedCoroutine r8 = kotlinx.coroutines.x.g(r8, r4, r3)     // Catch:{ all -> 0x0068 }
            goto L_0x0080
        L_0x007f:
            r8 = r2
        L_0x0080:
            kotlin.coroutines.d r5 = r6.continuation     // Catch:{ all -> 0x009c }
            r5.d(r7)     // Catch:{ all -> 0x009c }
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x009c }
            if (r8 == 0) goto L_0x008f
            boolean r7 = r8.M0()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x0092
        L_0x008f:
            cc.g0.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x0092:
            boolean r7 = r0.O()     // Catch:{ all -> 0x0068 }
            if (r7 != 0) goto L_0x0092
        L_0x0098:
            r0.G(r1)
            goto L_0x00b5
        L_0x009c:
            r7 = move-exception
            if (r8 == 0) goto L_0x00a5
            boolean r8 = r8.M0()     // Catch:{ all -> 0x0068 }
            if (r8 == 0) goto L_0x00a8
        L_0x00a5:
            cc.g0.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x00a8:
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x00a9:
            r6.i(r7, r2)     // Catch:{ all -> 0x00ad }
            goto L_0x0098
        L_0x00ad:
            r6 = move-exception
            r0.G(r1)
            throw r6
        L_0x00b2:
            r6.d(r7)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.i.b(kotlin.coroutines.d, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void c(d dVar, Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        b(dVar, obj, function1);
    }

    public static final boolean d(DispatchedContinuation dispatchedContinuation) {
        Unit unit = Unit.f12577a;
        q0 a10 = w1.f1199a.a();
        if (a10.N()) {
            return false;
        }
        if (a10.M()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            a10.I(dispatchedContinuation);
            return true;
        }
        a10.K(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (a10.O());
        } catch (Throwable th) {
            a10.G(true);
            throw th;
        }
        a10.G(true);
        return false;
    }
}
