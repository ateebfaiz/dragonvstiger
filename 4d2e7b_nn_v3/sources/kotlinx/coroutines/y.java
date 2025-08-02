package kotlinx.coroutines;

import cc.k;
import cc.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.b;
import kotlin.coroutines.d;
import kotlin.coroutines.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.internal.DispatchedContinuation;

public abstract class y extends kotlin.coroutines.a implements e {
    public static final a Key = new a((DefaultConstructorMarker) null);

    public static final class a extends b {

        /* renamed from: kotlinx.coroutines.y$a$a  reason: collision with other inner class name */
        static final class C0019a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final C0019a f1210a = new C0019a();

            C0019a() {
                super(1);
            }

            /* renamed from: a */
            public final y invoke(CoroutineContext.Element element) {
                if (element instanceof y) {
                    return (y) element;
                }
                return null;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
            super(e.f677p, C0019a.f1210a);
        }
    }

    public y() {
        super(e.f677p);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.b bVar) {
        return e.a.a(this, bVar);
    }

    public final <T> d interceptContinuation(d dVar) {
        return new DispatchedContinuation(this, dVar);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    public y limitedParallelism(int i10) {
        l.a(i10);
        return new k(this, i10);
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        return e.a.b(this, bVar);
    }

    public final y plus(y yVar) {
        return yVar;
    }

    public final void releaseInterceptedContinuation(d dVar) {
        m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) dVar).v();
    }

    public String toString() {
        return f0.a(this) + '@' + f0.b(this);
    }
}
