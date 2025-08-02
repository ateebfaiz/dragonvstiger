package mb;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.d;
import kotlin.jvm.internal.m;
import wb.b;

public final class g extends d implements Collection, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f1307a;

    public g(d dVar) {
        m.f(dVar, "backing");
        this.f1307a = dVar;
    }

    public int a() {
        return this.f1307a.size();
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f1307a.clear();
    }

    public boolean contains(Object obj) {
        return this.f1307a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f1307a.isEmpty();
    }

    public Iterator iterator() {
        return this.f1307a.T();
    }

    public boolean remove(Object obj) {
        return this.f1307a.R(obj);
    }

    public boolean removeAll(Collection collection) {
        m.f(collection, "elements");
        this.f1307a.o();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.f(collection, "elements");
        this.f1307a.o();
        return super.retainAll(collection);
    }
}
