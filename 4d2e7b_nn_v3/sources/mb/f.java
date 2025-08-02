package mb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.m;
import wb.b;

public final class f extends g implements Set, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f1306a;

    public f(d dVar) {
        m.f(dVar, "backing");
        this.f1306a = dVar;
    }

    public int a() {
        return this.f1306a.size();
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f1306a.clear();
    }

    public boolean contains(Object obj) {
        return this.f1306a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f1306a.isEmpty();
    }

    public Iterator iterator() {
        return this.f1306a.H();
    }

    public boolean remove(Object obj) {
        if (this.f1306a.P(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        m.f(collection, "elements");
        this.f1306a.o();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.f(collection, "elements");
        this.f1306a.o();
        return super.retainAll(collection);
    }
}
