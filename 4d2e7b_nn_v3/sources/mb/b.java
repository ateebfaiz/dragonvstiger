package mb;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.c;
import kotlin.collections.e;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import wb.d;

public final class b extends e implements List, RandomAccess, Serializable, d {

    /* renamed from: g  reason: collision with root package name */
    private static final a f1276g = new a((DefaultConstructorMarker) null);

    /* renamed from: h  reason: collision with root package name */
    private static final b f1277h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f1278a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f1279b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f1280c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1281d;

    /* renamed from: e  reason: collision with root package name */
    private final b f1282e;

    /* renamed from: f  reason: collision with root package name */
    private final b f1283f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: mb.b$b  reason: collision with other inner class name */
    private static final class C0020b implements ListIterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f1284a;

        /* renamed from: b  reason: collision with root package name */
        private int f1285b;

        /* renamed from: c  reason: collision with root package name */
        private int f1286c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f1287d;

        public C0020b(b bVar, int i10) {
            m.f(bVar, "list");
            this.f1284a = bVar;
            this.f1285b = i10;
            this.f1287d = bVar.modCount;
        }

        private final void a() {
            if (this.f1284a.modCount != this.f1287d) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object obj) {
            a();
            b bVar = this.f1284a;
            int i10 = this.f1285b;
            this.f1285b = i10 + 1;
            bVar.add(i10, obj);
            this.f1286c = -1;
            this.f1287d = this.f1284a.modCount;
        }

        public boolean hasNext() {
            if (this.f1285b < this.f1284a.f1280c) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (this.f1285b > 0) {
                return true;
            }
            return false;
        }

        public Object next() {
            a();
            if (this.f1285b < this.f1284a.f1280c) {
                int i10 = this.f1285b;
                this.f1285b = i10 + 1;
                this.f1286c = i10;
                return this.f1284a.f1278a[this.f1284a.f1279b + this.f1286c];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.f1285b;
        }

        public Object previous() {
            a();
            int i10 = this.f1285b;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.f1285b = i11;
                this.f1286c = i11;
                return this.f1284a.f1278a[this.f1284a.f1279b + this.f1286c];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f1285b - 1;
        }

        public void remove() {
            a();
            int i10 = this.f1286c;
            if (i10 != -1) {
                this.f1284a.remove(i10);
                this.f1285b = this.f1286c;
                this.f1286c = -1;
                this.f1287d = this.f1284a.modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(Object obj) {
            a();
            int i10 = this.f1286c;
            if (i10 != -1) {
                this.f1284a.set(i10, obj);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    static {
        b bVar = new b(0);
        bVar.f1281d = true;
        f1277h = bVar;
    }

    private b(Object[] objArr, int i10, int i11, boolean z10, b bVar, b bVar2) {
        this.f1278a = objArr;
        this.f1279b = i10;
        this.f1280c = i11;
        this.f1281d = z10;
        this.f1282e = bVar;
        this.f1283f = bVar2;
        if (bVar != null) {
            this.modCount = bVar.modCount;
        }
    }

    private final void j(int i10, Collection collection, int i11) {
        u();
        b bVar = this.f1282e;
        if (bVar != null) {
            bVar.j(i10, collection, i11);
            this.f1278a = this.f1282e.f1278a;
            this.f1280c += i11;
            return;
        }
        s(i10, i11);
        Iterator it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f1278a[i10 + i12] = it.next();
        }
    }

    private final void k(int i10, Object obj) {
        u();
        b bVar = this.f1282e;
        if (bVar != null) {
            bVar.k(i10, obj);
            this.f1278a = this.f1282e.f1278a;
            this.f1280c++;
            return;
        }
        s(i10, 1);
        this.f1278a[i10] = obj;
    }

    private final void m() {
        b bVar = this.f1283f;
        if (bVar != null && bVar.modCount != this.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void n() {
        if (t()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean o(List list) {
        return c.h(this.f1278a, this.f1279b, this.f1280c, list);
    }

    private final void p(int i10) {
        if (i10 >= 0) {
            Object[] objArr = this.f1278a;
            if (i10 > objArr.length) {
                this.f1278a = c.e(this.f1278a, c.Companion.d(objArr.length, i10));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void q(int i10) {
        p(this.f1280c + i10);
    }

    private final void s(int i10, int i11) {
        q(i11);
        Object[] objArr = this.f1278a;
        j.e(objArr, objArr, i10 + i11, i10, this.f1279b + this.f1280c);
        this.f1280c += i11;
    }

    private final boolean t() {
        b bVar;
        if (this.f1281d || ((bVar = this.f1283f) != null && bVar.f1281d)) {
            return true;
        }
        return false;
    }

    private final void u() {
        this.modCount++;
    }

    private final Object v(int i10) {
        u();
        b bVar = this.f1282e;
        if (bVar != null) {
            this.f1280c--;
            return bVar.v(i10);
        }
        Object[] objArr = this.f1278a;
        Object obj = objArr[i10];
        j.e(objArr, objArr, i10, i10 + 1, this.f1279b + this.f1280c);
        c.f(this.f1278a, (this.f1279b + this.f1280c) - 1);
        this.f1280c--;
        return obj;
    }

    private final void w(int i10, int i11) {
        if (i11 > 0) {
            u();
        }
        b bVar = this.f1282e;
        if (bVar != null) {
            bVar.w(i10, i11);
        } else {
            Object[] objArr = this.f1278a;
            j.e(objArr, objArr, i10, i10 + i11, this.f1280c);
            Object[] objArr2 = this.f1278a;
            int i12 = this.f1280c;
            c.g(objArr2, i12 - i11, i12);
        }
        this.f1280c -= i11;
    }

    private final Object writeReplace() {
        if (t()) {
            return new h(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final int x(int i10, int i11, Collection collection, boolean z10) {
        int i12;
        b bVar = this.f1282e;
        if (bVar != null) {
            i12 = bVar.x(i10, i11, collection, z10);
        } else {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                int i15 = i10 + i13;
                if (collection.contains(this.f1278a[i15]) == z10) {
                    Object[] objArr = this.f1278a;
                    i13++;
                    objArr[i14 + i10] = objArr[i15];
                    i14++;
                } else {
                    i13++;
                }
            }
            int i16 = i11 - i14;
            Object[] objArr2 = this.f1278a;
            j.e(objArr2, objArr2, i10 + i14, i11 + i10, this.f1280c);
            Object[] objArr3 = this.f1278a;
            int i17 = this.f1280c;
            c.g(objArr3, i17 - i16, i17);
            i12 = i16;
        }
        if (i12 > 0) {
            u();
        }
        this.f1280c -= i12;
        return i12;
    }

    public int a() {
        m();
        return this.f1280c;
    }

    public boolean add(Object obj) {
        n();
        m();
        k(this.f1279b + this.f1280c, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        n();
        m();
        int size = collection.size();
        j(this.f1279b + this.f1280c, collection, size);
        return size > 0;
    }

    public Object c(int i10) {
        n();
        m();
        c.Companion.a(i10, this.f1280c);
        return v(this.f1279b + i10);
    }

    public void clear() {
        n();
        m();
        w(this.f1279b, this.f1280c);
    }

    public boolean equals(Object obj) {
        m();
        if (obj == this || ((obj instanceof List) && o((List) obj))) {
            return true;
        }
        return false;
    }

    public Object get(int i10) {
        m();
        c.Companion.a(i10, this.f1280c);
        return this.f1278a[this.f1279b + i10];
    }

    public int hashCode() {
        m();
        return c.i(this.f1278a, this.f1279b, this.f1280c);
    }

    public int indexOf(Object obj) {
        m();
        for (int i10 = 0; i10 < this.f1280c; i10++) {
            if (m.b(this.f1278a[this.f1279b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        m();
        if (this.f1280c == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public final List l() {
        if (this.f1282e == null) {
            n();
            this.f1281d = true;
            if (this.f1280c > 0) {
                return this;
            }
            return f1277h;
        }
        throw new IllegalStateException();
    }

    public int lastIndexOf(Object obj) {
        m();
        for (int i10 = this.f1280c - 1; i10 >= 0; i10--) {
            if (m.b(this.f1278a[this.f1279b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public boolean remove(Object obj) {
        n();
        m();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        m.f(collection, "elements");
        n();
        m();
        if (x(this.f1279b, this.f1280c, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection collection) {
        m.f(collection, "elements");
        n();
        m();
        if (x(this.f1279b, this.f1280c, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public Object set(int i10, Object obj) {
        n();
        m();
        c.Companion.a(i10, this.f1280c);
        Object[] objArr = this.f1278a;
        int i11 = this.f1279b;
        Object obj2 = objArr[i11 + i10];
        objArr[i11 + i10] = obj;
        return obj2;
    }

    public List subList(int i10, int i11) {
        b bVar;
        c.Companion.c(i10, i11, this.f1280c);
        Object[] objArr = this.f1278a;
        int i12 = this.f1279b + i10;
        int i13 = i11 - i10;
        boolean z10 = this.f1281d;
        b bVar2 = this.f1283f;
        if (bVar2 == null) {
            bVar = this;
        } else {
            bVar = bVar2;
        }
        return new b(objArr, i12, i13, z10, this, bVar);
    }

    public Object[] toArray(Object[] objArr) {
        m.f(objArr, FirebaseAnalytics.Param.DESTINATION);
        m();
        int length = objArr.length;
        int i10 = this.f1280c;
        if (length < i10) {
            Object[] objArr2 = this.f1278a;
            int i11 = this.f1279b;
            Object[] copyOfRange = Arrays.copyOfRange(objArr2, i11, i10 + i11, objArr.getClass());
            m.e(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        Object[] objArr3 = this.f1278a;
        int i12 = this.f1279b;
        j.e(objArr3, objArr, 0, i12, i10 + i12);
        return r.f(this.f1280c, objArr);
    }

    public String toString() {
        m();
        return c.j(this.f1278a, this.f1279b, this.f1280c, this);
    }

    public ListIterator listIterator(int i10) {
        m();
        c.Companion.b(i10, this.f1280c);
        return new C0020b(this, i10);
    }

    public void add(int i10, Object obj) {
        n();
        m();
        c.Companion.b(i10, this.f1280c);
        k(this.f1279b + i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        m.f(collection, "elements");
        n();
        m();
        c.Companion.b(i10, this.f1280c);
        int size = collection.size();
        j(this.f1279b + i10, collection, size);
        return size > 0;
    }

    public Object[] toArray() {
        m();
        Object[] objArr = this.f1278a;
        int i10 = this.f1279b;
        return j.i(objArr, i10, this.f1280c + i10);
    }

    public b() {
        this(10);
    }

    public b(int i10) {
        this(c.d(i10), 0, 0, false, (b) null, (b) null);
    }
}
