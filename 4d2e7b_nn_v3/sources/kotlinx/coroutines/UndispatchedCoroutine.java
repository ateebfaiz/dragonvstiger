package kotlinx.coroutines;

import cc.g0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.t;
import kotlinx.coroutines.internal.ScopeCoroutine;

public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UndispatchedCoroutine(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.d r4) {
        /*
            r2 = this;
            kotlinx.coroutines.a2 r0 = kotlinx.coroutines.a2.f848a
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.threadStateToRecover = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.e$b r0 = kotlin.coroutines.e.f677p
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.y
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = cc.g0.c(r3, r4)
            cc.g0.a(r3, r4)
            r2.N0(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.d):void");
    }

    /* access modifiers changed from: protected */
    public void I0(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = this.threadStateToRecover.get();
            if (pair != null) {
                g0.a((CoroutineContext) pair.a(), pair.b());
            }
            this.threadStateToRecover.remove();
        }
        Object a10 = w.a(obj, this.uCont);
        d dVar = this.uCont;
        CoroutineContext context = dVar.getContext();
        UndispatchedCoroutine undispatchedCoroutine = null;
        Object c10 = g0.c(context, undispatchedCoroutine);
        if (c10 != g0.f66a) {
            undispatchedCoroutine = x.g(dVar, context, c10);
        }
        try {
            this.uCont.d(a10);
            Unit unit = Unit.f12577a;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.M0()) {
                g0.a(context, c10);
            }
        }
    }

    public final boolean M0() {
        boolean z10;
        if (!this.threadLocalIsSet || this.threadStateToRecover.get() != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.threadStateToRecover.remove();
        return !z10;
    }

    public final void N0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(t.a(coroutineContext, obj));
    }
}
