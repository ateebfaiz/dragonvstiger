package mb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final d f1305a;

    public e(d dVar) {
        m.f(dVar, "backing");
        this.f1305a = dVar;
    }

    public int a() {
        return this.f1305a.size();
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f1305a.clear();
    }

    public boolean containsAll(Collection collection) {
        m.f(collection, "elements");
        return this.f1305a.q(collection);
    }

    public boolean d(Map.Entry entry) {
        m.f(entry, "element");
        return this.f1305a.s(entry);
    }

    public boolean e(Map.Entry entry) {
        m.f(entry, "element");
        return this.f1305a.N(entry);
    }

    /* renamed from: f */
    public boolean add(Map.Entry entry) {
        m.f(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.f1305a.isEmpty();
    }

    public Iterator iterator() {
        return this.f1305a.w();
    }

    public boolean removeAll(Collection collection) {
        m.f(collection, "elements");
        this.f1305a.o();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.f(collection, "elements");
        this.f1305a.o();
        return super.retainAll(collection);
    }
}
