package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.ranges.l;
import kotlin.time.a;

public abstract class DelayKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlin.coroutines.d r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L_0x0013
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x002d:
            kotlin.p.b(r4)
            goto L_0x0052
        L_0x0031:
            kotlin.p.b(r4)
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r4 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.d r2 = kotlin.coroutines.intrinsics.b.b(r0)
            r4.<init>(r2, r3)
            r4.E()
            java.lang.Object r4 = r4.A()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.b.c()
            if (r4 != r2) goto L_0x004f
            kotlin.coroutines.jvm.internal.e.c(r0)
        L_0x004f:
            if (r4 != r1) goto L_0x0052
            return r1
        L_0x0052:
            kotlin.f r4 = new kotlin.f
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.d):java.lang.Object");
    }

    public static final Object b(long j10, d dVar) {
        if (j10 <= 0) {
            return Unit.f12577a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.b(dVar), 1);
        cancellableContinuationImpl.E();
        if (j10 < LocationRequestCompat.PASSIVE_INTERVAL) {
            c(cancellableContinuationImpl.getContext()).j(j10, cancellableContinuationImpl);
        }
        Object A = cancellableContinuationImpl.A();
        if (A == b.c()) {
            e.c(dVar);
        }
        if (A == b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    public static final i0 c(CoroutineContext coroutineContext) {
        i0 i0Var;
        CoroutineContext.Element element = coroutineContext.get(kotlin.coroutines.e.f677p);
        if (element instanceof i0) {
            i0Var = (i0) element;
        } else {
            i0Var = null;
        }
        if (i0Var == null) {
            return h0.a();
        }
        return i0Var;
    }

    public static final long d(long j10) {
        if (a.c(j10, a.f833a.a()) > 0) {
            return l.d(a.i(j10), 1);
        }
        return 0;
    }
}
