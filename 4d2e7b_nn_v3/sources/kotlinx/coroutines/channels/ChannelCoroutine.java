package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.selects.g;

public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements e {
    private final e _channel;

    public ChannelCoroutine(CoroutineContext coroutineContext, e eVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this._channel = eVar;
    }

    public void M(Throwable th) {
        CancellationException B0 = JobSupport.B0(this, th, (String) null, 1, (Object) null);
        this._channel.b(B0);
        K(B0);
    }

    public final e M0() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final e N0() {
        return this._channel;
    }

    public final void b(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new g1(P(), (Throwable) null, this);
            }
            M(cancellationException);
        }
    }

    public g e() {
        return this._channel.e();
    }

    public g f() {
        return this._channel.f();
    }

    public Object g() {
        return this._channel.g();
    }

    public Object h(d dVar) {
        Object h10 = this._channel.h(dVar);
        b.c();
        return h10;
    }

    public ChannelIterator iterator() {
        return this._channel.iterator();
    }

    public boolean r(Throwable th) {
        return this._channel.r(th);
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
