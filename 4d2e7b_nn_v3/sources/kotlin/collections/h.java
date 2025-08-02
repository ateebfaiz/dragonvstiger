package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.m;
import wb.a;

final class h implements Collection, a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f641a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f642b;

    public h(Object[] objArr, boolean z10) {
        m.f(objArr, "values");
        this.f641a = objArr;
        this.f642b = z10;
    }

    public int a() {
        return this.f641a.length;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return j.s(this.f641a, obj);
    }

    public boolean containsAll(Collection collection) {
        m.f(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        if (this.f641a.length == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return b.a(this.f641a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    public Object[] toArray(Object[] objArr) {
        m.f(objArr, "array");
        return f.b(this, objArr);
    }

    public final Object[] toArray() {
        return s.b(this.f641a, this.f642b);
    }
}
