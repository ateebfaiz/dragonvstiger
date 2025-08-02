package aa;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class h extends AbstractMap implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator f2297i = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Comparator f2298a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2299b;

    /* renamed from: c  reason: collision with root package name */
    e f2300c;

    /* renamed from: d  reason: collision with root package name */
    int f2301d;

    /* renamed from: e  reason: collision with root package name */
    int f2302e;

    /* renamed from: f  reason: collision with root package name */
    final e f2303f;

    /* renamed from: g  reason: collision with root package name */
    private b f2304g;

    /* renamed from: h  reason: collision with root package name */
    private c f2305h;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            /* renamed from: b */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        public void clear() {
            h.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || h.this.c((Map.Entry) obj) == null) {
                return false;
            }
            return true;
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            e c10;
            if (!(obj instanceof Map.Entry) || (c10 = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(c10, true);
            return true;
        }

        public int size() {
            return h.this.f2301d;
        }
    }

    final class c extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            public Object next() {
                return a().f2319f;
            }
        }

        c() {
        }

        public void clear() {
            h.this.clear();
        }

        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            if (h.this.h(obj) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return h.this.f2301d;
        }
    }

    private abstract class d implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        e f2310a;

        /* renamed from: b  reason: collision with root package name */
        e f2311b = null;

        /* renamed from: c  reason: collision with root package name */
        int f2312c;

        d() {
            this.f2310a = h.this.f2303f.f2317d;
            this.f2312c = h.this.f2302e;
        }

        /* access modifiers changed from: package-private */
        public final e a() {
            e eVar = this.f2310a;
            h hVar = h.this;
            if (eVar == hVar.f2303f) {
                throw new NoSuchElementException();
            } else if (hVar.f2302e == this.f2312c) {
                this.f2310a = eVar.f2317d;
                this.f2311b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            if (this.f2310a != h.this.f2303f) {
                return true;
            }
            return false;
        }

        public final void remove() {
            e eVar = this.f2311b;
            if (eVar != null) {
                h.this.f(eVar, true);
                this.f2311b = null;
                this.f2312c = h.this.f2302e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f2297i, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(e eVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (eVar != null) {
            e eVar2 = eVar.f2315b;
            e eVar3 = eVar.f2316c;
            int i14 = 0;
            if (eVar2 != null) {
                i10 = eVar2.f2322i;
            } else {
                i10 = 0;
            }
            if (eVar3 != null) {
                i11 = eVar3.f2322i;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                e eVar4 = eVar3.f2315b;
                e eVar5 = eVar3.f2316c;
                if (eVar5 != null) {
                    i13 = eVar5.f2322i;
                } else {
                    i13 = 0;
                }
                if (eVar4 != null) {
                    i14 = eVar4.f2322i;
                }
                int i16 = i14 - i13;
                if (i16 == -1 || (i16 == 0 && !z10)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                e eVar6 = eVar2.f2315b;
                e eVar7 = eVar2.f2316c;
                if (eVar7 != null) {
                    i12 = eVar7.f2322i;
                } else {
                    i12 = 0;
                }
                if (eVar6 != null) {
                    i14 = eVar6.f2322i;
                }
                int i17 = i14 - i12;
                if (i17 == 1 || (i17 == 0 && !z10)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                eVar.f2322i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f2322i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f2314a;
        }
    }

    private void i(e eVar, e eVar2) {
        e eVar3 = eVar.f2314a;
        eVar.f2314a = null;
        if (eVar2 != null) {
            eVar2.f2314a = eVar3;
        }
        if (eVar3 == null) {
            this.f2300c = eVar2;
        } else if (eVar3.f2315b == eVar) {
            eVar3.f2315b = eVar2;
        } else {
            eVar3.f2316c = eVar2;
        }
    }

    private void j(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f2315b;
        e eVar3 = eVar.f2316c;
        e eVar4 = eVar3.f2315b;
        e eVar5 = eVar3.f2316c;
        eVar.f2316c = eVar4;
        if (eVar4 != null) {
            eVar4.f2314a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f2315b = eVar;
        eVar.f2314a = eVar3;
        int i12 = 0;
        if (eVar2 != null) {
            i10 = eVar2.f2322i;
        } else {
            i10 = 0;
        }
        if (eVar4 != null) {
            i11 = eVar4.f2322i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f2322i = max;
        if (eVar5 != null) {
            i12 = eVar5.f2322i;
        }
        eVar3.f2322i = Math.max(max, i12) + 1;
    }

    private void k(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f2315b;
        e eVar3 = eVar.f2316c;
        e eVar4 = eVar2.f2315b;
        e eVar5 = eVar2.f2316c;
        eVar.f2315b = eVar5;
        if (eVar5 != null) {
            eVar5.f2314a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f2316c = eVar;
        eVar.f2314a = eVar2;
        int i12 = 0;
        if (eVar3 != null) {
            i10 = eVar3.f2322i;
        } else {
            i10 = 0;
        }
        if (eVar5 != null) {
            i11 = eVar5.f2322i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f2322i = max;
        if (eVar4 != null) {
            i12 = eVar4.f2322i;
        }
        eVar2.f2322i = Math.max(max, i12) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* access modifiers changed from: package-private */
    public e b(Object obj, boolean z10) {
        int i10;
        e eVar;
        Comparable comparable;
        e eVar2;
        Comparator comparator = this.f2298a;
        e eVar3 = this.f2300c;
        if (eVar3 != null) {
            if (comparator == f2297i) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar3.f2319f);
                } else {
                    i10 = comparator.compare(obj, eVar3.f2319f);
                }
                if (i10 == 0) {
                    return eVar3;
                }
                if (i10 < 0) {
                    eVar2 = eVar3.f2315b;
                } else {
                    eVar2 = eVar3.f2316c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e eVar4 = this.f2303f;
        if (eVar3 != null) {
            eVar = new e(this.f2299b, eVar3, obj, eVar4, eVar4.f2318e);
            if (i10 < 0) {
                eVar3.f2315b = eVar;
            } else {
                eVar3.f2316c = eVar;
            }
            e(eVar3, true);
        } else if (comparator != f2297i || (obj instanceof Comparable)) {
            eVar = new e(this.f2299b, eVar3, obj, eVar4, eVar4.f2318e);
            this.f2300c = eVar;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
        }
        this.f2301d++;
        this.f2302e++;
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public e c(Map.Entry entry) {
        e d10 = d(entry.getKey());
        if (d10 == null || !a(d10.f2321h, entry.getValue())) {
            return null;
        }
        return d10;
    }

    public void clear() {
        this.f2300c = null;
        this.f2301d = 0;
        this.f2302e++;
        e eVar = this.f2303f;
        eVar.f2318e = eVar;
        eVar.f2317d = eVar;
    }

    public boolean containsKey(Object obj) {
        if (d(obj) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public Set entrySet() {
        b bVar = this.f2304g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f2304g = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public void f(e eVar, boolean z10) {
        e eVar2;
        int i10;
        if (z10) {
            e eVar3 = eVar.f2318e;
            eVar3.f2317d = eVar.f2317d;
            eVar.f2317d.f2318e = eVar3;
        }
        e eVar4 = eVar.f2315b;
        e eVar5 = eVar.f2316c;
        e eVar6 = eVar.f2314a;
        int i11 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f2315b = null;
            } else if (eVar5 != null) {
                i(eVar, eVar5);
                eVar.f2316c = null;
            } else {
                i(eVar, (e) null);
            }
            e(eVar6, false);
            this.f2301d--;
            this.f2302e++;
            return;
        }
        if (eVar4.f2322i > eVar5.f2322i) {
            eVar2 = eVar4.b();
        } else {
            eVar2 = eVar5.a();
        }
        f(eVar2, false);
        e eVar7 = eVar.f2315b;
        if (eVar7 != null) {
            i10 = eVar7.f2322i;
            eVar2.f2315b = eVar7;
            eVar7.f2314a = eVar2;
            eVar.f2315b = null;
        } else {
            i10 = 0;
        }
        e eVar8 = eVar.f2316c;
        if (eVar8 != null) {
            i11 = eVar8.f2322i;
            eVar2.f2316c = eVar8;
            eVar8.f2314a = eVar2;
            eVar.f2316c = null;
        }
        eVar2.f2322i = Math.max(i10, i11) + 1;
        i(eVar, eVar2);
    }

    public Object get(Object obj) {
        e d10 = d(obj);
        if (d10 != null) {
            return d10.f2321h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public e h(Object obj) {
        e d10 = d(obj);
        if (d10 != null) {
            f(d10, true);
        }
        return d10;
    }

    public Set keySet() {
        c cVar = this.f2305h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f2305h = cVar2;
        return cVar2;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        } else if (obj2 != null || this.f2299b) {
            e b10 = b(obj, true);
            Object obj3 = b10.f2321h;
            b10.f2321h = obj2;
            return obj3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public Object remove(Object obj) {
        e h10 = h(obj);
        if (h10 != null) {
            return h10.f2321h;
        }
        return null;
    }

    public int size() {
        return this.f2301d;
    }

    public h(boolean z10) {
        this(f2297i, z10);
    }

    public h(Comparator comparator, boolean z10) {
        this.f2301d = 0;
        this.f2302e = 0;
        this.f2298a = comparator == null ? f2297i : comparator;
        this.f2299b = z10;
        this.f2303f = new e(z10);
    }

    static final class e implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        e f2314a;

        /* renamed from: b  reason: collision with root package name */
        e f2315b;

        /* renamed from: c  reason: collision with root package name */
        e f2316c;

        /* renamed from: d  reason: collision with root package name */
        e f2317d;

        /* renamed from: e  reason: collision with root package name */
        e f2318e;

        /* renamed from: f  reason: collision with root package name */
        final Object f2319f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f2320g;

        /* renamed from: h  reason: collision with root package name */
        Object f2321h;

        /* renamed from: i  reason: collision with root package name */
        int f2322i;

        e(boolean z10) {
            this.f2319f = null;
            this.f2320g = z10;
            this.f2318e = this;
            this.f2317d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f2315b; eVar2 != null; eVar2 = eVar2.f2315b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f2316c; eVar2 != null; eVar2 = eVar2.f2316c) {
                eVar = eVar2;
            }
            return eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r3.f2319f
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                java.lang.Object r0 = r3.f2321h
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: aa.h.e.equals(java.lang.Object):boolean");
        }

        public Object getKey() {
            return this.f2319f;
        }

        public Object getValue() {
            return this.f2321h;
        }

        public int hashCode() {
            int i10;
            Object obj = this.f2319f;
            int i11 = 0;
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            Object obj2 = this.f2321h;
            if (obj2 != null) {
                i11 = obj2.hashCode();
            }
            return i10 ^ i11;
        }

        public Object setValue(Object obj) {
            if (obj != null || this.f2320g) {
                Object obj2 = this.f2321h;
                this.f2321h = obj;
                return obj2;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f2319f + "=" + this.f2321h;
        }

        e(boolean z10, e eVar, Object obj, e eVar2, e eVar3) {
            this.f2314a = eVar;
            this.f2319f = obj;
            this.f2320g = z10;
            this.f2322i = 1;
            this.f2317d = eVar2;
            this.f2318e = eVar3;
            eVar3.f2317d = this;
            eVar2.f2318e = this;
        }
    }
}
