package cc;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f96a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile Object _cur;

    public p(boolean z10) {
        this._cur = new q(8, z10);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f96a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            int a10 = qVar.a(obj);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 1) {
                a.a(f96a, this, qVar, qVar.i());
            } else if (a10 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f96a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (!qVar.d()) {
                a.a(f96a, this, qVar, qVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((q) f96a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f96a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            Object j10 = qVar.j();
            if (j10 != q.f100h) {
                return j10;
            }
            a.a(f96a, this, qVar, qVar.i());
        }
    }
}
