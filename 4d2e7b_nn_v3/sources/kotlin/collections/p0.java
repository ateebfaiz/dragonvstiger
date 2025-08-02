package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.m;

class p0 extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f651a;

    public static final class a implements ListIterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final ListIterator f652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p0 f653b;

        a(p0 p0Var, int i10) {
            this.f653b = p0Var;
            this.f652a = p0Var.f651a.listIterator(z.O(p0Var, i10));
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasNext() {
            return this.f652a.hasPrevious();
        }

        public boolean hasPrevious() {
            return this.f652a.hasNext();
        }

        public Object next() {
            return this.f652a.previous();
        }

        public int nextIndex() {
            return z.N(this.f653b, this.f652a.previousIndex());
        }

        public Object previous() {
            return this.f652a.next();
        }

        public int previousIndex() {
            return z.N(this.f653b, this.f652a.nextIndex());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public p0(List list) {
        m.f(list, "delegate");
        this.f651a = list;
    }

    public Object get(int i10) {
        return this.f651a.get(z.M(this, i10));
    }

    public int getSize() {
        return this.f651a.size();
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public ListIterator listIterator(int i10) {
        return new a(this, i10);
    }
}
