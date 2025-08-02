package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.m;

final class o0 extends e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f648a;

    public static final class a implements ListIterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final ListIterator f649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o0 f650b;

        a(o0 o0Var, int i10) {
            this.f650b = o0Var;
            this.f649a = o0Var.f648a.listIterator(z.O(o0Var, i10));
        }

        public void add(Object obj) {
            this.f649a.add(obj);
            this.f649a.previous();
        }

        public boolean hasNext() {
            return this.f649a.hasPrevious();
        }

        public boolean hasPrevious() {
            return this.f649a.hasNext();
        }

        public Object next() {
            return this.f649a.previous();
        }

        public int nextIndex() {
            return z.N(this.f650b, this.f649a.previousIndex());
        }

        public Object previous() {
            return this.f649a.next();
        }

        public int previousIndex() {
            return z.N(this.f650b, this.f649a.nextIndex());
        }

        public void remove() {
            this.f649a.remove();
        }

        public void set(Object obj) {
            this.f649a.set(obj);
        }
    }

    public o0(List list) {
        m.f(list, "delegate");
        this.f648a = list;
    }

    public int a() {
        return this.f648a.size();
    }

    public void add(int i10, Object obj) {
        this.f648a.add(z.O(this, i10), obj);
    }

    public Object c(int i10) {
        return this.f648a.remove(z.M(this, i10));
    }

    public void clear() {
        this.f648a.clear();
    }

    public Object get(int i10) {
        return this.f648a.get(z.M(this, i10));
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public Object set(int i10, Object obj) {
        return this.f648a.set(z.M(this, i10), obj);
    }

    public ListIterator listIterator(int i10) {
        return new a(this, i10);
    }
}
