package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;

public abstract class BaseContinuationImpl implements d, b, Serializable {
    private final d completion;

    public BaseContinuationImpl(d dVar) {
        this.completion = dVar;
    }

    public b c() {
        d dVar = this.completion;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public final void d(Object obj) {
        d dVar = this;
        while (true) {
            e.b(dVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) dVar;
            d dVar2 = baseContinuationImpl.completion;
            m.c(dVar2);
            try {
                Object n10 = baseContinuationImpl.n(obj);
                if (n10 != b.c()) {
                    obj = o.b(n10);
                    baseContinuationImpl.p();
                    if (dVar2 instanceof BaseContinuationImpl) {
                        dVar = dVar2;
                    } else {
                        dVar2.d(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                o.a aVar = o.f12592b;
                obj = o.b(p.a(th));
            }
        }
    }

    public final d getCompletion() {
        return this.completion;
    }

    public d k(Object obj, d dVar) {
        m.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement m() {
        return d.d(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object n(Object obj);

    /* access modifiers changed from: protected */
    public void p() {
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object m10 = m();
        if (m10 == null) {
            m10 = getClass().getName();
        }
        sb2.append(m10);
        return sb2.toString();
    }
}
