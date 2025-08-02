package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.e;
import kotlin.jvm.internal.m;

public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient d intercepted;

    public ContinuationImpl(d dVar, CoroutineContext coroutineContext) {
        super(dVar);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        m.c(coroutineContext);
        return coroutineContext;
    }

    /* access modifiers changed from: protected */
    public void p() {
        d dVar = this.intercepted;
        if (!(dVar == null || dVar == this)) {
            CoroutineContext.Element element = getContext().get(e.f677p);
            m.c(element);
            ((e) element).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = CompletedContinuation.INSTANCE;
    }

    public final d s() {
        d dVar = this.intercepted;
        if (dVar == null) {
            e eVar = (e) getContext().get(e.f677p);
            if (eVar == null || (dVar = eVar.interceptContinuation(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
