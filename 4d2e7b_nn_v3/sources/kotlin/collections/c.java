package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class c<E> extends a implements List<E>, wb.a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final int maxArraySize = 2147483639;

    public static final class a {
        private a() {
        }

        public final void a(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            } else if (i10 > i11) {
                throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
            }
        }

        public final int d(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - c.maxArraySize <= 0) {
                return i12;
            }
            if (i11 > c.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return c.maxArraySize;
        }

        public final boolean e(Collection collection, Collection collection2) {
            m.f(collection, com.alibaba.pdns.net.d.f18103f);
            m.f(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object b10 : collection) {
                if (!m.b(b10, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection collection) {
            int i10;
            m.f(collection, com.alibaba.pdns.net.d.f18103f);
            int i11 = 1;
            for (Object next : collection) {
                int i12 = i11 * 31;
                if (next != null) {
                    i10 = next.hashCode();
                } else {
                    i10 = 0;
                }
                i11 = i12 + i10;
            }
            return i11;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private class b implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private int f631a;

        public b() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f631a;
        }

        /* access modifiers changed from: protected */
        public final void c(int i10) {
            this.f631a = i10;
        }

        public boolean hasNext() {
            if (this.f631a < c.this.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                c cVar = c.this;
                int i10 = this.f631a;
                this.f631a = i10 + 1;
                return cVar.get(i10);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: kotlin.collections.c$c  reason: collision with other inner class name */
    private class C0007c extends b implements ListIterator, wb.a {
        public C0007c(int i10) {
            super();
            c.Companion.b(i10, c.this.size());
            c(i10);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        public int nextIndex() {
            return a();
        }

        public Object previous() {
            if (hasPrevious()) {
                c cVar = c.this;
                c(a() - 1);
                return cVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class d extends c implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        private final c f634a;

        /* renamed from: b  reason: collision with root package name */
        private final int f635b;

        /* renamed from: c  reason: collision with root package name */
        private int f636c;

        public d(c cVar, int i10, int i11) {
            m.f(cVar, "list");
            this.f634a = cVar;
            this.f635b = i10;
            c.Companion.c(i10, i11, cVar.size());
            this.f636c = i11 - i10;
        }

        public Object get(int i10) {
            c.Companion.a(i10, this.f636c);
            return this.f634a.get(this.f635b + i10);
        }

        public int getSize() {
            return this.f636c;
        }
    }

    protected c() {
    }

    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.e(this, (Collection) obj);
    }

    public abstract Object get(int i10);

    public int hashCode() {
        return Companion.f(this);
    }

    public int indexOf(Object obj) {
        int i10 = 0;
        for (Object b10 : this) {
            if (m.b(b10, obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (m.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new C0007c(0);
    }

    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    public ListIterator<E> listIterator(int i10) {
        return new C0007c(i10);
    }
}
