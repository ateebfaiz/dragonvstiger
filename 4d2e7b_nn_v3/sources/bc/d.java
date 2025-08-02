package bc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.l;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p1;

public final class d extends e implements i0 {
    private volatile d _immediate;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Handler f22a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24c;

    /* renamed from: d  reason: collision with root package name */
    private final d f25d;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f26a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f27b;

        public a(CancellableContinuation cancellableContinuation, d dVar) {
            this.f26a = cancellableContinuation;
            this.f27b = dVar;
        }

        public final void run() {
            this.f26a.q(this.f27b, Unit.f12577a);
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f29b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, Runnable runnable) {
            super(1);
            this.f28a = dVar;
            this.f29b = runnable;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.f12577a;
        }

        public final void invoke(Throwable th) {
            this.f28a.f22a.removeCallbacks(this.f29b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(Handler handler, String str, boolean z10) {
        super((DefaultConstructorMarker) null);
        d dVar = null;
        this.f22a = handler;
        this.f23b = str;
        this.f24c = z10;
        this._immediate = z10 ? this : dVar;
        d dVar2 = this._immediate;
        if (dVar2 == null) {
            dVar2 = new d(handler, str, true);
            this._immediate = dVar2;
        }
        this.f25d = dVar2;
    }

    private final void K(CoroutineContext coroutineContext, Runnable runnable) {
        j1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        l0.b().dispatch(coroutineContext, runnable);
    }

    /* access modifiers changed from: private */
    public static final void M(d dVar, Runnable runnable) {
        dVar.f22a.removeCallbacks(runnable);
    }

    /* renamed from: L */
    public d G() {
        return this.f25d;
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f22a.post(runnable)) {
            K(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d) || ((d) obj).f22a != this.f22a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f22a);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        if (!this.f24c || !m.b(Looper.myLooper(), this.f22a.getLooper())) {
            return true;
        }
        return false;
    }

    public void j(long j10, CancellableContinuation cancellableContinuation) {
        a aVar = new a(cancellableContinuation, this);
        if (this.f22a.postDelayed(aVar, l.g(j10, 4611686018427387903L))) {
            cancellableContinuation.j(new b(this, aVar));
        } else {
            K(cancellableContinuation.getContext(), aVar);
        }
    }

    public String toString() {
        String H = H();
        if (H != null) {
            return H;
        }
        String str = this.f23b;
        if (str == null) {
            str = this.f22a.toString();
        }
        if (!this.f24c) {
            return str;
        }
        return str + ".immediate";
    }

    public m0 w(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f22a.postDelayed(runnable, l.g(j10, 4611686018427387903L))) {
            return new c(this, runnable);
        }
        K(coroutineContext, runnable);
        return p1.f1110a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Handler handler, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str) {
        this(handler, str, false);
    }
}
