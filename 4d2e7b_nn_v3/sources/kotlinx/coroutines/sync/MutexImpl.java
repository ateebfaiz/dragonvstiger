package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import cc.z;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.y;

public class MutexImpl extends c implements a {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1170h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    private volatile Object owner;

    private final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, b2 {
        public final CancellableContinuationImpl<Unit> cont;
        public final Object owner;

        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MutexImpl f1171a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CancellableContinuationWithOwner f1172b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner) {
                super(1);
                this.f1171a = mutexImpl;
                this.f1172b = cancellableContinuationWithOwner;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f1171a.c(this.f1172b.owner);
            }
        }

        static final class b extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MutexImpl f1173a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CancellableContinuationWithOwner f1174b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner) {
                super(1);
                this.f1173a = mutexImpl;
                this.f1174b = cancellableContinuationWithOwner;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                MutexImpl.f1170h.set(this.f1173a, this.f1174b.owner);
                this.f1173a.c(this.f1174b.owner);
            }
        }

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl, Object obj) {
            this.cont = cancellableContinuationImpl;
            this.owner = obj;
        }

        public void D(Object obj) {
            this.cont.D(obj);
        }

        public boolean a() {
            return this.cont.a();
        }

        /* renamed from: b */
        public void t(Unit unit, Function1 function1) {
            MutexImpl.f1170h.set(MutexImpl.this, this.owner);
            this.cont.t(unit, new a(MutexImpl.this, this));
        }

        /* renamed from: c */
        public void q(y yVar, Unit unit) {
            this.cont.q(yVar, unit);
        }

        public void d(Object obj) {
            this.cont.d(obj);
        }

        /* renamed from: e */
        public Object l(Unit unit, Object obj, Function1 function1) {
            Object l10 = this.cont.l(unit, obj, new b(MutexImpl.this, this));
            if (l10 != null) {
                MutexImpl.f1170h.set(MutexImpl.this, this.owner);
            }
            return l10;
        }

        public void f(z zVar, int i10) {
            this.cont.f(zVar, i10);
        }

        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        public void j(Function1 function1) {
            this.cont.j(function1);
        }

        public void o(y yVar, Throwable th) {
            this.cont.o(yVar, th);
        }
    }

    private final int p(Object obj) {
        while (q()) {
            Object obj2 = f1170h.get(this);
            if (obj2 != MutexKt.f1175a) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object r(MutexImpl mutexImpl, Object obj, d dVar) {
        if (mutexImpl.t(obj)) {
            return Unit.f12577a;
        }
        Object s10 = mutexImpl.s(obj, dVar);
        if (s10 == b.c()) {
            return s10;
        }
        return Unit.f12577a;
    }

    private final Object s(Object obj, d dVar) {
        CancellableContinuationImpl b10 = j.b(b.b(dVar));
        try {
            e(new CancellableContinuationWithOwner(b10, obj));
            Object A = b10.A();
            if (A == b.c()) {
                e.c(dVar);
            }
            if (A == b.c()) {
                return A;
            }
            return Unit.f12577a;
        } catch (Throwable th) {
            b10.N();
            throw th;
        }
    }

    private final int u(Object obj) {
        while (!l()) {
            if (obj == null) {
                return 1;
            }
            int p10 = p(obj);
            if (p10 == 1) {
                return 2;
            }
            if (p10 == 2) {
                return 1;
            }
        }
        f1170h.set(this, obj);
        return 0;
    }

    public Object b(Object obj, d dVar) {
        return r(this, obj, dVar);
    }

    public void c(Object obj) {
        while (q()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1170h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != MutexKt.f1175a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (a.a(atomicReferenceFieldUpdater, this, obj2, MutexKt.f1175a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean q() {
        if (k() == 0) {
            return true;
        }
        return false;
    }

    public boolean t(Object obj) {
        int u10 = u(obj);
        if (u10 == 0) {
            return true;
        }
        if (u10 == 1) {
            return false;
        }
        if (u10 != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public String toString() {
        return "Mutex@" + f0.b(this) + "[isLocked=" + q() + ",owner=" + f1170h.get(this) + ']';
    }
}
