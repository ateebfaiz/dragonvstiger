package mb;

import com.google.firebase.messaging.Constants;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.g0;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

public final class d<K, V> implements Map<K, V>, Serializable, wb.e {
    public static final a Y = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final d Z;
    private e C;
    private boolean X;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f1288a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object[] f1289b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f1290c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f1291d;

    /* renamed from: e  reason: collision with root package name */
    private int f1292e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f1293f;

    /* renamed from: g  reason: collision with root package name */
    private int f1294g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1295h;

    /* renamed from: i  reason: collision with root package name */
    private int f1296i;

    /* renamed from: j  reason: collision with root package name */
    private f f1297j;

    /* renamed from: w  reason: collision with root package name */
    private g f1298w;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final int c(int i10) {
            return Integer.highestOneBit(l.c(i10, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }

        public final d e() {
            return d.Z;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends C0021d implements Iterator, wb.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            m.f(dVar, "map");
        }

        /* renamed from: j */
        public c next() {
            a();
            if (c() < e().f1293f) {
                int c10 = c();
                g(c10 + 1);
                i(c10);
                c cVar = new c(e(), d());
                f();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void k(StringBuilder sb2) {
            m.f(sb2, "sb");
            if (c() < e().f1293f) {
                int c10 = c();
                g(c10 + 1);
                i(c10);
                Object obj = e().f1288a[d()];
                if (obj == e()) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append('=');
                Object[] j10 = e().f1289b;
                m.c(j10);
                Object obj2 = j10[d()];
                if (obj2 == e()) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                f();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int l() {
            int i10;
            if (c() < e().f1293f) {
                int c10 = c();
                g(c10 + 1);
                i(c10);
                Object obj = e().f1288a[d()];
                int i11 = 0;
                if (obj != null) {
                    i10 = obj.hashCode();
                } else {
                    i10 = 0;
                }
                Object[] j10 = e().f1289b;
                m.c(j10);
                Object obj2 = j10[d()];
                if (obj2 != null) {
                    i11 = obj2.hashCode();
                }
                int i12 = i10 ^ i11;
                f();
                return i12;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c implements Map.Entry, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final d f1299a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1300b;

        public c(d dVar, int i10) {
            m.f(dVar, "map");
            this.f1299a = dVar;
            this.f1300b = i10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!m.b(entry.getKey(), getKey()) || !m.b(entry.getValue(), getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public Object getKey() {
            return this.f1299a.f1288a[this.f1300b];
        }

        public Object getValue() {
            Object[] j10 = this.f1299a.f1289b;
            m.c(j10);
            return j10[this.f1300b];
        }

        public int hashCode() {
            int i10;
            Object key = getKey();
            int i11 = 0;
            if (key != null) {
                i10 = key.hashCode();
            } else {
                i10 = 0;
            }
            Object value = getValue();
            if (value != null) {
                i11 = value.hashCode();
            }
            return i10 ^ i11;
        }

        public Object setValue(Object obj) {
            this.f1299a.o();
            Object[] a10 = this.f1299a.m();
            int i10 = this.f1300b;
            Object obj2 = a10[i10];
            a10[i10] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* renamed from: mb.d$d  reason: collision with other inner class name */
    public static class C0021d {

        /* renamed from: a  reason: collision with root package name */
        private final d f1301a;

        /* renamed from: b  reason: collision with root package name */
        private int f1302b;

        /* renamed from: c  reason: collision with root package name */
        private int f1303c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f1304d;

        public C0021d(d dVar) {
            m.f(dVar, "map");
            this.f1301a = dVar;
            this.f1304d = dVar.f1295h;
            f();
        }

        public final void a() {
            if (this.f1301a.f1295h != this.f1304d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int c() {
            return this.f1302b;
        }

        public final int d() {
            return this.f1303c;
        }

        public final d e() {
            return this.f1301a;
        }

        public final void f() {
            while (this.f1302b < this.f1301a.f1293f) {
                int[] i10 = this.f1301a.f1290c;
                int i11 = this.f1302b;
                if (i10[i11] < 0) {
                    this.f1302b = i11 + 1;
                } else {
                    return;
                }
            }
        }

        public final void g(int i10) {
            this.f1302b = i10;
        }

        public final boolean hasNext() {
            if (this.f1302b < this.f1301a.f1293f) {
                return true;
            }
            return false;
        }

        public final void i(int i10) {
            this.f1303c = i10;
        }

        public final void remove() {
            a();
            if (this.f1303c != -1) {
                this.f1301a.o();
                this.f1301a.Q(this.f1303c);
                this.f1303c = -1;
                this.f1304d = this.f1301a.f1295h;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    public static final class e extends C0021d implements Iterator, wb.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            m.f(dVar, "map");
        }

        public Object next() {
            a();
            if (c() < e().f1293f) {
                int c10 = c();
                g(c10 + 1);
                i(c10);
                Object obj = e().f1288a[d()];
                f();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f extends C0021d implements Iterator, wb.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            m.f(dVar, "map");
        }

        public Object next() {
            a();
            if (c() < e().f1293f) {
                int c10 = c();
                g(c10 + 1);
                i(c10);
                Object[] j10 = e().f1289b;
                m.c(j10);
                Object obj = j10[d()];
                f();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        d dVar = new d(0);
        dVar.X = true;
        Z = dVar;
    }

    private d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i10, int i11) {
        this.f1288a = objArr;
        this.f1289b = objArr2;
        this.f1290c = iArr;
        this.f1291d = iArr2;
        this.f1292e = i10;
        this.f1293f = i11;
        this.f1294g = Y.d(B());
    }

    private final int B() {
        return this.f1291d.length;
    }

    private final int F(Object obj) {
        int i10;
        if (obj != null) {
            i10 = obj.hashCode();
        } else {
            i10 = 0;
        }
        return (i10 * -1640531527) >>> this.f1294g;
    }

    private final boolean I(Collection collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        v(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (J((Map.Entry) it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean J(Map.Entry entry) {
        int l10 = l(entry.getKey());
        Object[] m10 = m();
        if (l10 >= 0) {
            m10[l10] = entry.getValue();
            return true;
        }
        int i10 = (-l10) - 1;
        if (m.b(entry.getValue(), m10[i10])) {
            return false;
        }
        m10[i10] = entry.getValue();
        return true;
    }

    private final boolean K(int i10) {
        int F = F(this.f1288a[i10]);
        int i11 = this.f1292e;
        while (true) {
            int[] iArr = this.f1291d;
            if (iArr[F] == 0) {
                iArr[F] = i10 + 1;
                this.f1290c[i10] = F;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            int i12 = F - 1;
            if (F == 0) {
                F = B() - 1;
            } else {
                F = i12;
            }
        }
    }

    private final void L() {
        this.f1295h++;
    }

    private final void M(int i10) {
        L();
        if (this.f1293f > size()) {
            p();
        }
        int i11 = 0;
        if (i10 != B()) {
            this.f1291d = new int[i10];
            this.f1294g = Y.d(i10);
        } else {
            j.j(this.f1291d, 0, 0, B());
        }
        while (i11 < this.f1293f) {
            int i12 = i11 + 1;
            if (K(i11)) {
                i11 = i12;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void O(int i10) {
        int f10 = l.f(this.f1292e * 2, B() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            int i13 = i10 - 1;
            if (i10 == 0) {
                i10 = B() - 1;
            } else {
                i10 = i13;
            }
            i11++;
            if (i11 > this.f1292e) {
                this.f1291d[i12] = 0;
                return;
            }
            int[] iArr = this.f1291d;
            int i14 = iArr[i10];
            if (i14 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i14 < 0) {
                iArr[i12] = -1;
            } else {
                int i15 = i14 - 1;
                if (((F(this.f1288a[i15]) - i10) & (B() - 1)) >= i11) {
                    this.f1291d[i12] = i14;
                    this.f1290c[i15] = i12;
                }
                f10--;
            }
            i12 = i10;
            i11 = 0;
            f10--;
        } while (f10 >= 0);
        this.f1291d[i12] = -1;
    }

    /* access modifiers changed from: private */
    public final void Q(int i10) {
        c.f(this.f1288a, i10);
        O(this.f1290c[i10]);
        this.f1290c[i10] = -1;
        this.f1296i = size() - 1;
        L();
    }

    private final boolean S(int i10) {
        int z10 = z();
        int i11 = this.f1293f;
        int i12 = z10 - i11;
        int size = i11 - size();
        if (i12 >= i10 || i12 + size < i10 || size < z() / 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final Object[] m() {
        Object[] objArr = this.f1289b;
        if (objArr != null) {
            return objArr;
        }
        Object[] d10 = c.d(z());
        this.f1289b = d10;
        return d10;
    }

    private final void p() {
        int i10;
        Object[] objArr = this.f1289b;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f1293f;
            if (i11 >= i10) {
                break;
            }
            if (this.f1290c[i11] >= 0) {
                Object[] objArr2 = this.f1288a;
                objArr2[i12] = objArr2[i11];
                if (objArr != null) {
                    objArr[i12] = objArr[i11];
                }
                i12++;
            }
            i11++;
        }
        c.g(this.f1288a, i12, i10);
        if (objArr != null) {
            c.g(objArr, i12, this.f1293f);
        }
        this.f1293f = i12;
    }

    private final boolean t(Map map) {
        if (size() != map.size() || !q(map.entrySet())) {
            return false;
        }
        return true;
    }

    private final void u(int i10) {
        Object[] objArr;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        } else if (i10 > z()) {
            int d10 = kotlin.collections.c.Companion.d(z(), i10);
            this.f1288a = c.e(this.f1288a, d10);
            Object[] objArr2 = this.f1289b;
            if (objArr2 != null) {
                objArr = c.e(objArr2, d10);
            } else {
                objArr = null;
            }
            this.f1289b = objArr;
            int[] copyOf = Arrays.copyOf(this.f1290c, d10);
            m.e(copyOf, "copyOf(...)");
            this.f1290c = copyOf;
            int a10 = Y.c(d10);
            if (a10 > B()) {
                M(a10);
            }
        }
    }

    private final void v(int i10) {
        if (S(i10)) {
            M(B());
        } else {
            u(this.f1293f + i10);
        }
    }

    private final Object writeReplace() {
        if (this.X) {
            return new i(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final int x(Object obj) {
        int F = F(obj);
        int i10 = this.f1292e;
        while (true) {
            int i11 = this.f1291d[F];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (m.b(this.f1288a[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            int i13 = F - 1;
            if (F == 0) {
                F = B() - 1;
            } else {
                F = i13;
            }
        }
    }

    private final int y(Object obj) {
        int i10 = this.f1293f;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f1290c[i10] >= 0) {
                Object[] objArr = this.f1289b;
                m.c(objArr);
                if (m.b(objArr[i10], obj)) {
                    return i10;
                }
            }
        }
    }

    public Set A() {
        e eVar = this.C;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.C = eVar2;
        return eVar2;
    }

    public Set C() {
        f fVar = this.f1297j;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        this.f1297j = fVar2;
        return fVar2;
    }

    public int D() {
        return this.f1296i;
    }

    public Collection E() {
        g gVar = this.f1298w;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f1298w = gVar2;
        return gVar2;
    }

    public final boolean G() {
        return this.X;
    }

    public final e H() {
        return new e(this);
    }

    public final boolean N(Map.Entry entry) {
        m.f(entry, "entry");
        o();
        int x10 = x(entry.getKey());
        if (x10 < 0) {
            return false;
        }
        Object[] objArr = this.f1289b;
        m.c(objArr);
        if (!m.b(objArr[x10], entry.getValue())) {
            return false;
        }
        Q(x10);
        return true;
    }

    public final int P(Object obj) {
        o();
        int x10 = x(obj);
        if (x10 < 0) {
            return -1;
        }
        Q(x10);
        return x10;
    }

    public final boolean R(Object obj) {
        o();
        int y10 = y(obj);
        if (y10 < 0) {
            return false;
        }
        Q(y10);
        return true;
    }

    public final f T() {
        return new f(this);
    }

    public void clear() {
        o();
        g0 e10 = new IntRange(0, this.f1293f - 1).iterator();
        while (e10.hasNext()) {
            int nextInt = e10.nextInt();
            int[] iArr = this.f1290c;
            int i10 = iArr[nextInt];
            if (i10 >= 0) {
                this.f1291d[i10] = 0;
                iArr[nextInt] = -1;
            }
        }
        c.g(this.f1288a, 0, this.f1293f);
        Object[] objArr = this.f1289b;
        if (objArr != null) {
            c.g(objArr, 0, this.f1293f);
        }
        this.f1296i = 0;
        this.f1293f = 0;
        L();
    }

    public boolean containsKey(Object obj) {
        if (x(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (y(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final /* bridge */ Set entrySet() {
        return A();
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof Map) && t((Map) obj))) {
            return true;
        }
        return false;
    }

    public Object get(Object obj) {
        int x10 = x(obj);
        if (x10 < 0) {
            return null;
        }
        Object[] objArr = this.f1289b;
        m.c(objArr);
        return objArr[x10];
    }

    public int hashCode() {
        b w10 = w();
        int i10 = 0;
        while (w10.hasNext()) {
            i10 += w10.l();
        }
        return i10;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final /* bridge */ Set keySet() {
        return C();
    }

    public final int l(Object obj) {
        o();
        while (true) {
            int F = F(obj);
            int f10 = l.f(this.f1292e * 2, B() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.f1291d[F];
                if (i11 <= 0) {
                    if (this.f1293f >= z()) {
                        v(1);
                    } else {
                        int i12 = this.f1293f;
                        int i13 = i12 + 1;
                        this.f1293f = i13;
                        this.f1288a[i12] = obj;
                        this.f1290c[i12] = F;
                        this.f1291d[F] = i13;
                        this.f1296i = size() + 1;
                        L();
                        if (i10 > this.f1292e) {
                            this.f1292e = i10;
                        }
                        return i12;
                    }
                } else if (m.b(this.f1288a[i11 - 1], obj)) {
                    return -i11;
                } else {
                    i10++;
                    if (i10 > f10) {
                        M(B() * 2);
                        break;
                    }
                    int i14 = F - 1;
                    if (F == 0) {
                        F = B() - 1;
                    } else {
                        F = i14;
                    }
                }
            }
        }
    }

    public final Map n() {
        o();
        this.X = true;
        if (size() > 0) {
            return this;
        }
        d dVar = Z;
        m.d(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    public final void o() {
        if (this.X) {
            throw new UnsupportedOperationException();
        }
    }

    public Object put(Object obj, Object obj2) {
        o();
        int l10 = l(obj);
        Object[] m10 = m();
        if (l10 < 0) {
            int i10 = (-l10) - 1;
            Object obj3 = m10[i10];
            m10[i10] = obj2;
            return obj3;
        }
        m10[l10] = obj2;
        return null;
    }

    public void putAll(Map map) {
        m.f(map, Constants.MessagePayloadKeys.FROM);
        o();
        I(map.entrySet());
    }

    public final boolean q(Collection collection) {
        m.f(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!s((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public Object remove(Object obj) {
        int P = P(obj);
        if (P < 0) {
            return null;
        }
        Object[] objArr = this.f1289b;
        m.c(objArr);
        Object obj2 = objArr[P];
        c.f(objArr, P);
        return obj2;
    }

    public final boolean s(Map.Entry entry) {
        m.f(entry, "entry");
        int x10 = x(entry.getKey());
        if (x10 < 0) {
            return false;
        }
        Object[] objArr = this.f1289b;
        m.c(objArr);
        return m.b(objArr[x10], entry.getValue());
    }

    public final /* bridge */ int size() {
        return D();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b w10 = w();
        int i10 = 0;
        while (w10.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            w10.k(sb2);
            i10++;
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }

    public final /* bridge */ Collection values() {
        return E();
    }

    public final b w() {
        return new b(this);
    }

    public final int z() {
        return this.f1288a.length;
    }

    public d() {
        this(8);
    }

    public d(int i10) {
        this(c.d(i10), (Object[]) null, new int[i10], new int[Y.c(i10)], 2, 0);
    }
}
