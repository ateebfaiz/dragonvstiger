package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.g1;

class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements n, a {
    private final a _channel;

    /* access modifiers changed from: protected */
    public void J0(Throwable th, boolean z10) {
        if (!this._channel.r(th) && !z10) {
            a0.a(getContext(), th);
        }
    }

    public void M(Throwable th) {
        CancellationException B0 = JobSupport.B0(this, th, (String) null, 1, (Object) null);
        this._channel.b(B0);
        K(B0);
    }

    /* access modifiers changed from: protected */
    public final a M0() {
        return this._channel;
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public void K0(Unit unit) {
        p.a.a(this._channel, (Throwable) null, 1, (Object) null);
    }

    public boolean a() {
        return super.a();
    }

    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new g1(P(), (Throwable) null, this);
        }
        M(cancellationException);
    }

    public p i() {
        return this;
    }

    public boolean r(Throwable th) {
        boolean r10 = this._channel.r(th);
        start();
        return r10;
    }

    public ReceiveChannel s() {
        return this._channel.s();
    }

    public void u(Function1 function1) {
        this._channel.u(function1);
    }

    public Object w(Object obj) {
        return this._channel.w(obj);
    }

    public Object x(Object obj, d dVar) {
        return this._channel.x(obj, dVar);
    }

    public boolean y() {
        return this._channel.y();
    }
}
