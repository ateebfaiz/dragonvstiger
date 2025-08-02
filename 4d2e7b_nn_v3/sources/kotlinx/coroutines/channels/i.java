package kotlinx.coroutines.channels;

import cc.c0;
import cc.v;
import cc.z;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.b2;

public final class i extends z {

    /* renamed from: e  reason: collision with root package name */
    private final BufferedChannel f908e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReferenceArray f909f = new AtomicReferenceArray(d.f882b * 2);

    public i(long j10, i iVar, BufferedChannel bufferedChannel, int i10) {
        super(j10, iVar, i10);
        this.f908e = bufferedChannel;
    }

    private final void z(int i10, Object obj) {
        this.f909f.lazySet(i10 * 2, obj);
    }

    public final void A(int i10, Object obj) {
        this.f909f.set((i10 * 2) + 1, obj);
    }

    public final void B(int i10, Object obj) {
        z(i10, obj);
    }

    public int n() {
        return d.f882b;
    }

    public void o(int i10, Throwable th, CoroutineContext coroutineContext) {
        boolean z10;
        c0 c0Var;
        Function1 function1;
        Function1 function12;
        int i11 = d.f882b;
        if (i10 >= i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 -= i11;
        }
        Object v10 = v(i10);
        while (true) {
            Object w10 = w(i10);
            if ((w10 instanceof b2) || (w10 instanceof r)) {
                if (z10) {
                    c0Var = d.f890j;
                } else {
                    c0Var = d.f891k;
                }
                if (r(i10, w10, c0Var)) {
                    s(i10);
                    x(i10, !z10);
                    if (z10 && (function1 = u().f862b) != null) {
                        v.b(function1, v10, coroutineContext);
                        return;
                    }
                    return;
                }
            } else if (w10 == d.f890j || w10 == d.f891k) {
                s(i10);
            } else if (!(w10 == d.f887g || w10 == d.f886f)) {
                if (w10 != d.f889i && w10 != d.f884d && w10 != d.z()) {
                    throw new IllegalStateException(("unexpected state: " + w10).toString());
                }
                return;
            }
        }
        s(i10);
        if (z10 && (function12 = u().f862b) != null) {
            v.b(function12, v10, coroutineContext);
        }
    }

    public final boolean r(int i10, Object obj, Object obj2) {
        return h.a(this.f909f, (i10 * 2) + 1, obj, obj2);
    }

    public final void s(int i10) {
        z(i10, (Object) null);
    }

    public final Object t(int i10, Object obj) {
        return this.f909f.getAndSet((i10 * 2) + 1, obj);
    }

    public final BufferedChannel u() {
        BufferedChannel bufferedChannel = this.f908e;
        m.c(bufferedChannel);
        return bufferedChannel;
    }

    public final Object v(int i10) {
        return this.f909f.get(i10 * 2);
    }

    public final Object w(int i10) {
        return this.f909f.get((i10 * 2) + 1);
    }

    public final void x(int i10, boolean z10) {
        if (z10) {
            u().S0((this.f113c * ((long) d.f882b)) + ((long) i10));
        }
        p();
    }

    public final Object y(int i10) {
        Object v10 = v(i10);
        s(i10);
        return v10;
    }
}
