package kotlinx.coroutines.internal;

import cc.i;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.w;

public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements b {
    public final d uCont;

    public ScopeCoroutine(CoroutineContext coroutineContext, d dVar) {
        super(coroutineContext, true, true);
        this.uCont = dVar;
    }

    /* access modifiers changed from: protected */
    public void I0(Object obj) {
        d dVar = this.uCont;
        dVar.d(w.a(obj, dVar));
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        i.c(kotlin.coroutines.intrinsics.b.b(this.uCont), w.a(obj, this.uCont), (Function1) null, 2, (Object) null);
    }

    public final b c() {
        d dVar = this.uCont;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean h0() {
        return true;
    }
}
