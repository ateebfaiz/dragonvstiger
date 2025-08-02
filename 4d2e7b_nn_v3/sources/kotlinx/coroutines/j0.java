package kotlinx.coroutines;

import ec.h;
import kotlin.b;
import kotlin.coroutines.d;
import kotlin.jvm.internal.m;

public abstract class j0 extends h {
    public int resumeMode;

    public j0(int i10) {
        this.resumeMode = i10;
    }

    public abstract void b(Object obj, Throwable th);

    public abstract d e();

    public Throwable g(Object obj) {
        s sVar;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.f1129a;
        }
        return null;
    }

    public Object h(Object obj) {
        return obj;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                b.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            m.c(th);
            a0.a(e().getContext(), new e0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object k();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r4.M0() != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b3, code lost:
        if (r4.M0() != false) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            ec.i r0 = r10.taskContext
            kotlin.coroutines.d r1 = r10.e()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.m.d(r1, r2)     // Catch:{ all -> 0x0023 }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x0023 }
            kotlin.coroutines.d r2 = r1.continuation     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = r1.countOrElement     // Catch:{ all -> 0x0023 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = cc.g0.c(r3, r1)     // Catch:{ all -> 0x0023 }
            cc.c0 r4 = cc.g0.f66a     // Catch:{ all -> 0x0023 }
            r5 = 0
            if (r1 == r4) goto L_0x0026
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.x.g(r2, r3, r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r1 = move-exception
            goto L_0x00b9
        L_0x0026:
            r4 = r5
        L_0x0027:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x0046 }
            java.lang.Object r7 = r10.k()     // Catch:{ all -> 0x0046 }
            java.lang.Throwable r8 = r10.g(r7)     // Catch:{ all -> 0x0046 }
            if (r8 != 0) goto L_0x0048
            int r9 = r10.resumeMode     // Catch:{ all -> 0x0046 }
            boolean r9 = kotlinx.coroutines.k0.b(r9)     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x0048
            kotlinx.coroutines.f1$b r9 = kotlinx.coroutines.f1.f964r     // Catch:{ all -> 0x0046 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x0046 }
            kotlinx.coroutines.f1 r6 = (kotlinx.coroutines.f1) r6     // Catch:{ all -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r2 = move-exception
            goto L_0x00ad
        L_0x0048:
            r6 = r5
        L_0x0049:
            if (r6 == 0) goto L_0x0066
            boolean r9 = r6.a()     // Catch:{ all -> 0x0046 }
            if (r9 != 0) goto L_0x0066
            java.util.concurrent.CancellationException r6 = r6.n()     // Catch:{ all -> 0x0046 }
            r10.b(r7, r6)     // Catch:{ all -> 0x0046 }
            kotlin.o$a r7 = kotlin.o.f12592b     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.p.a(r6)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.o.b(r6)     // Catch:{ all -> 0x0046 }
            r2.d(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0066:
            if (r8 == 0) goto L_0x0076
            kotlin.o$a r6 = kotlin.o.f12592b     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.p.a(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.o.b(r6)     // Catch:{ all -> 0x0046 }
            r2.d(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0076:
            kotlin.o$a r6 = kotlin.o.f12592b     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = r10.h(r7)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.o.b(r6)     // Catch:{ all -> 0x0046 }
            r2.d(r6)     // Catch:{ all -> 0x0046 }
        L_0x0083:
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x008d
            boolean r2 = r4.M0()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x0090
        L_0x008d:
            cc.g0.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x0090:
            r0.a()     // Catch:{ all -> 0x009a }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x009a }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x009a }
            goto L_0x00a5
        L_0x009a:
            r0 = move-exception
            kotlin.o$a r1 = kotlin.o.f12592b
            java.lang.Object r0 = kotlin.p.a(r0)
            java.lang.Object r0 = kotlin.o.b(r0)
        L_0x00a5:
            java.lang.Throwable r0 = kotlin.o.d(r0)
            r10.i(r5, r0)
            goto L_0x00d7
        L_0x00ad:
            if (r4 == 0) goto L_0x00b5
            boolean r4 = r4.M0()     // Catch:{ all -> 0x0023 }
            if (r4 == 0) goto L_0x00b8
        L_0x00b5:
            cc.g0.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x00b8:
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x00b9:
            kotlin.o$a r2 = kotlin.o.f12592b     // Catch:{ all -> 0x00c5 }
            r0.a()     // Catch:{ all -> 0x00c5 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x00d0
        L_0x00c5:
            r0 = move-exception
            kotlin.o$a r2 = kotlin.o.f12592b
            java.lang.Object r0 = kotlin.p.a(r0)
            java.lang.Object r0 = kotlin.o.b(r0)
        L_0x00d0:
            java.lang.Throwable r0 = kotlin.o.d(r0)
            r10.i(r1, r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j0.run():void");
    }
}
