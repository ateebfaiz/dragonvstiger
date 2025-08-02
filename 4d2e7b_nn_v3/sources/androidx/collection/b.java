package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    C0184b f14473a;

    /* renamed from: b  reason: collision with root package name */
    c f14474b;

    /* renamed from: c  reason: collision with root package name */
    e f14475c;

    final class a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        final int f14476a;

        /* renamed from: b  reason: collision with root package name */
        int f14477b;

        /* renamed from: c  reason: collision with root package name */
        int f14478c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14479d = false;

        a(int i10) {
            this.f14476a = i10;
            this.f14477b = b.this.d();
        }

        public boolean hasNext() {
            if (this.f14478c < this.f14477b) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                Object b10 = b.this.b(this.f14478c, this.f14476a);
                this.f14478c++;
                this.f14479d = true;
                return b10;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f14479d) {
                int i10 = this.f14478c - 1;
                this.f14478c = i10;
                this.f14477b--;
                this.f14479d = false;
                b.this.h(i10);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.collection.b$b  reason: collision with other inner class name */
    final class C0184b implements Set {
        C0184b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            int d10 = b.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                b.this.g(entry.getKey(), entry.getValue());
            }
            if (d10 != b.this.d()) {
                return true;
            }
            return false;
        }

        public void clear() {
            b.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e10 = b.this.e(entry.getKey());
            if (e10 < 0) {
                return false;
            }
            return a.c(b.this.b(e10, 1), entry.getValue());
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return b.k(this, obj);
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = 0;
            for (int d10 = b.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = b.this.b(d10, 0);
                Object b11 = b.this.b(d10, 1);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                i12 += i10 ^ i11;
            }
            return i12;
        }

        public boolean isEmpty() {
            if (b.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return b.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set {
        c() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            b.this.a();
        }

        public boolean contains(Object obj) {
            if (b.this.e(obj) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            return b.j(b.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return b.k(this, obj);
        }

        public int hashCode() {
            int i10;
            int i11 = 0;
            for (int d10 = b.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = b.this.b(d10, 0);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                i11 += i10;
            }
            return i11;
        }

        public boolean isEmpty() {
            if (b.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int e10 = b.this.e(obj);
            if (e10 < 0) {
                return false;
            }
            b.this.h(e10);
            return true;
        }

        public boolean removeAll(Collection collection) {
            return b.o(b.this.c(), collection);
        }

        public boolean retainAll(Collection collection) {
            return b.p(b.this.c(), collection);
        }

        public int size() {
            return b.this.d();
        }

        public Object[] toArray() {
            return b.this.q(0);
        }

        public Object[] toArray(Object[] objArr) {
            return b.this.r(objArr, 0);
        }
    }

    final class d implements Iterator, Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        int f14483a;

        /* renamed from: b  reason: collision with root package name */
        int f14484b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14485c = false;

        d() {
            this.f14483a = b.this.d() - 1;
            this.f14484b = -1;
        }

        /* renamed from: a */
        public Map.Entry next() {
            if (hasNext()) {
                this.f14484b++;
                this.f14485c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f14485c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!a.c(entry.getKey(), b.this.b(this.f14484b, 0)) || !a.c(entry.getValue(), b.this.b(this.f14484b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public Object getKey() {
            if (this.f14485c) {
                return b.this.b(this.f14484b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.f14485c) {
                return b.this.b(this.f14484b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            if (this.f14484b < this.f14483a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            if (this.f14485c) {
                int i11 = 0;
                Object b10 = b.this.b(this.f14484b, 0);
                Object b11 = b.this.b(this.f14484b, 1);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                if (b11 != null) {
                    i11 = b11.hashCode();
                }
                return i10 ^ i11;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f14485c) {
                b.this.h(this.f14484b);
                this.f14484b--;
                this.f14483a--;
                this.f14485c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public Object setValue(Object obj) {
            if (this.f14485c) {
                return b.this.i(this.f14484b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection {
        e() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            b.this.a();
        }

        public boolean contains(Object obj) {
            if (b.this.f(obj) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            if (b.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int f10 = b.this.f(obj);
            if (f10 < 0) {
                return false;
            }
            b.this.h(f10);
            return true;
        }

        public boolean removeAll(Collection collection) {
            int d10 = b.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (collection.contains(b.this.b(i10, 1))) {
                    b.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        public boolean retainAll(Collection collection) {
            int d10 = b.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (!collection.contains(b.this.b(i10, 1))) {
                    b.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        public int size() {
            return b.this.d();
        }

        public Object[] toArray() {
            return b.this.q(1);
        }

        public Object[] toArray(Object[] objArr) {
            return b.this.r(objArr, 1);
        }
    }

    b() {
    }

    public static boolean j(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract Object b(int i10, int i11);

    /* access modifiers changed from: protected */
    public abstract Map c();

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract int e(Object obj);

    /* access modifiers changed from: protected */
    public abstract int f(Object obj);

    /* access modifiers changed from: protected */
    public abstract void g(Object obj, Object obj2);

    /* access modifiers changed from: protected */
    public abstract void h(int i10);

    /* access modifiers changed from: protected */
    public abstract Object i(int i10, Object obj);

    public Set l() {
        if (this.f14473a == null) {
            this.f14473a = new C0184b();
        }
        return this.f14473a;
    }

    public Set m() {
        if (this.f14474b == null) {
            this.f14474b = new c();
        }
        return this.f14474b;
    }

    public Collection n() {
        if (this.f14475c == null) {
            this.f14475c = new e();
        }
        return this.f14475c;
    }

    public Object[] q(int i10) {
        int d10 = d();
        Object[] objArr = new Object[d10];
        for (int i11 = 0; i11 < d10; i11++) {
            objArr[i11] = b(i11, i10);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i10) {
        int d10 = d();
        if (objArr.length < d10) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d10);
        }
        for (int i11 = 0; i11 < d10; i11++) {
            objArr[i11] = b(i11, i10);
        }
        if (objArr.length > d10) {
            objArr[d10] = null;
        }
        return objArr;
    }
}
