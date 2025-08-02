package h5;

import java.util.HashSet;
import java.util.Set;

public abstract class u implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final Set f21984a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final l f21985b = new l();

    private Object b(Object obj) {
        if (obj != null) {
            synchronized (this) {
                this.f21984a.remove(obj);
            }
        }
        return obj;
    }

    public Object get(int i10) {
        return b(this.f21985b.a(i10));
    }

    public Object pop() {
        return b(this.f21985b.f());
    }

    public void put(Object obj) {
        boolean add;
        synchronized (this) {
            add = this.f21984a.add(obj);
        }
        if (add) {
            this.f21985b.e(a(obj), obj);
        }
    }
}
