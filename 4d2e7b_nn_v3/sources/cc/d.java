package cc;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f61a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f62b;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<d> cls = d.class;
        Class<Object> cls2 = Object.class;
        f61a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f62b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public d(d dVar) {
        this._prev = dVar;
    }

    private final d c() {
        d g10 = g();
        while (g10 != null && g10.h()) {
            g10 = (d) f62b.get(g10);
        }
        return g10;
    }

    private final d d() {
        d e10;
        d e11 = e();
        m.c(e11);
        while (e11.h() && (e10 = e11.e()) != null) {
            e11 = e10;
        }
        return e11;
    }

    /* access modifiers changed from: private */
    public final Object f() {
        return f61a.get(this);
    }

    public final void b() {
        f62b.lazySet(this, (Object) null);
    }

    public final d e() {
        Object a10 = f();
        if (a10 == c.f59a) {
            return null;
        }
        return (d) a10;
    }

    public final d g() {
        return (d) f62b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        return a.a(f61a, this, (Object) null, c.f59a);
    }

    public final void k() {
        Object obj;
        d dVar;
        if (!i()) {
            while (true) {
                d c10 = c();
                d d10 = d();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f62b;
                do {
                    obj = atomicReferenceFieldUpdater.get(d10);
                    if (((d) obj) == null) {
                        dVar = null;
                    } else {
                        dVar = c10;
                    }
                } while (!a.a(atomicReferenceFieldUpdater, d10, obj, dVar));
                if (c10 != null) {
                    f61a.set(c10, d10);
                }
                if ((!d10.h() || d10.i()) && (c10 == null || !c10.h())) {
                    return;
                }
            }
        }
    }

    public final boolean l(d dVar) {
        return a.a(f61a, this, (Object) null, dVar);
    }
}
