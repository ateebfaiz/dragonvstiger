package cc;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class b extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f55a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f54a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f54a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.a(atomicReferenceFieldUpdater, this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }

    public final Object a(Object obj) {
        Object obj2 = f55a.get(this);
        if (obj2 == a.f54a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract Object d(Object obj);
}
