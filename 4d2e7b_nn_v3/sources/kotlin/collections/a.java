package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public abstract class a implements Collection, wb.a {

    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    static final class C0006a extends n implements Function1<Object, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f625a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0006a(a aVar) {
            super(1);
            this.f625a = aVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(Object obj) {
            if (obj == this.f625a) {
                return "(this Collection)";
            }
            return String.valueOf(obj);
        }
    }

    protected a() {
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object b10 : this) {
            if (m.b(b10, obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
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

    public abstract int getSize();

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public String toString() {
        return r.f0(this, ", ", "[", "]", 0, (CharSequence) null, new C0006a(this), 24, (Object) null);
    }

    public <T> T[] toArray(T[] tArr) {
        m.f(tArr, "array");
        return f.b(this, tArr);
    }
}
