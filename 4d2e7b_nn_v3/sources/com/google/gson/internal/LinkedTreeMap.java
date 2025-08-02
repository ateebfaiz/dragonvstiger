package com.google.gson.internal;

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

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e root;
    int size;

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
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || LinkedTreeMap.this.findByEntry((Map.Entry) obj) == null) {
                return false;
            }
            return true;
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            e findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    final class c extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            public Object next() {
                return a().f9379f;
            }
        }

        c() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            if (LinkedTreeMap.this.removeInternalByKey(obj) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    private abstract class d implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        e f9370a;

        /* renamed from: b  reason: collision with root package name */
        e f9371b = null;

        /* renamed from: c  reason: collision with root package name */
        int f9372c;

        d() {
            this.f9370a = LinkedTreeMap.this.header.f9377d;
            this.f9372c = LinkedTreeMap.this.modCount;
        }

        /* access modifiers changed from: package-private */
        public final e a() {
            e eVar = this.f9370a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.modCount == this.f9372c) {
                this.f9370a = eVar.f9377d;
                this.f9371b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            if (this.f9370a != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        public final void remove() {
            e eVar = this.f9371b;
            if (eVar != null) {
                LinkedTreeMap.this.removeInternal(eVar, true);
                this.f9371b = null;
                this.f9372c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER, true);
    }

    private boolean equal(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(e eVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (eVar != null) {
            e eVar2 = eVar.f9375b;
            e eVar3 = eVar.f9376c;
            int i14 = 0;
            if (eVar2 != null) {
                i10 = eVar2.f9382i;
            } else {
                i10 = 0;
            }
            if (eVar3 != null) {
                i11 = eVar3.f9382i;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                e eVar4 = eVar3.f9375b;
                e eVar5 = eVar3.f9376c;
                if (eVar5 != null) {
                    i13 = eVar5.f9382i;
                } else {
                    i13 = 0;
                }
                if (eVar4 != null) {
                    i14 = eVar4.f9382i;
                }
                int i16 = i14 - i13;
                if (i16 == -1 || (i16 == 0 && !z10)) {
                    rotateLeft(eVar);
                } else {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                e eVar6 = eVar2.f9375b;
                e eVar7 = eVar2.f9376c;
                if (eVar7 != null) {
                    i12 = eVar7.f9382i;
                } else {
                    i12 = 0;
                }
                if (eVar6 != null) {
                    i14 = eVar6.f9382i;
                }
                int i17 = i14 - i12;
                if (i17 == 1 || (i17 == 0 && !z10)) {
                    rotateRight(eVar);
                } else {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                eVar.f9382i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f9382i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f9374a;
        }
    }

    private void replaceInParent(e eVar, e eVar2) {
        e eVar3 = eVar.f9374a;
        eVar.f9374a = null;
        if (eVar2 != null) {
            eVar2.f9374a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f9375b == eVar) {
            eVar3.f9375b = eVar2;
        } else {
            eVar3.f9376c = eVar2;
        }
    }

    private void rotateLeft(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f9375b;
        e eVar3 = eVar.f9376c;
        e eVar4 = eVar3.f9375b;
        e eVar5 = eVar3.f9376c;
        eVar.f9376c = eVar4;
        if (eVar4 != null) {
            eVar4.f9374a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.f9375b = eVar;
        eVar.f9374a = eVar3;
        int i12 = 0;
        if (eVar2 != null) {
            i10 = eVar2.f9382i;
        } else {
            i10 = 0;
        }
        if (eVar4 != null) {
            i11 = eVar4.f9382i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f9382i = max;
        if (eVar5 != null) {
            i12 = eVar5.f9382i;
        }
        eVar3.f9382i = Math.max(max, i12) + 1;
    }

    private void rotateRight(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f9375b;
        e eVar3 = eVar.f9376c;
        e eVar4 = eVar2.f9375b;
        e eVar5 = eVar2.f9376c;
        eVar.f9375b = eVar5;
        if (eVar5 != null) {
            eVar5.f9374a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f9376c = eVar;
        eVar.f9374a = eVar2;
        int i12 = 0;
        if (eVar3 != null) {
            i10 = eVar3.f9382i;
        } else {
            i10 = 0;
        }
        if (eVar5 != null) {
            i11 = eVar5.f9382i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f9382i = max;
        if (eVar4 != null) {
            i12 = eVar4.f9382i;
        }
        eVar2.f9382i = Math.max(max, i12) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e eVar = this.header;
        eVar.f9378e = eVar;
        eVar.f9377d = eVar;
    }

    public boolean containsKey(Object obj) {
        if (findByObject(obj) != null) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public e find(K k10, boolean z10) {
        int i10;
        e eVar;
        Comparable comparable;
        e eVar2;
        Comparator<? super K> comparator2 = this.comparator;
        e eVar3 = this.root;
        if (eVar3 != null) {
            if (comparator2 == NATURAL_ORDER) {
                comparable = (Comparable) k10;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar3.f9379f);
                } else {
                    i10 = comparator2.compare(k10, eVar3.f9379f);
                }
                if (i10 == 0) {
                    return eVar3;
                }
                if (i10 < 0) {
                    eVar2 = eVar3.f9375b;
                } else {
                    eVar2 = eVar3.f9376c;
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
        e eVar4 = this.header;
        if (eVar3 != null) {
            eVar = new e(this.allowNullValues, eVar3, k10, eVar4, eVar4.f9378e);
            if (i10 < 0) {
                eVar3.f9375b = eVar;
            } else {
                eVar3.f9376c = eVar;
            }
            rebalance(eVar3, true);
        } else if (comparator2 != NATURAL_ORDER || (k10 instanceof Comparable)) {
            eVar = new e(this.allowNullValues, eVar3, k10, eVar4, eVar4.f9378e);
            this.root = eVar;
        } else {
            throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public e findByEntry(Map.Entry<?, ?> entry) {
        e findByObject = findByObject(entry.getKey());
        if (findByObject == null || !equal(findByObject.f9381h, entry.getValue())) {
            return null;
        }
        return findByObject;
    }

    /* access modifiers changed from: package-private */
    public e findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        e findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f9381h;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        } else if (v10 != null || this.allowNullValues) {
            e find = find(k10, true);
            V v11 = find.f9381h;
            find.f9381h = v10;
            return v11;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public V remove(Object obj) {
        e removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f9381h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void removeInternal(e eVar, boolean z10) {
        e eVar2;
        int i10;
        if (z10) {
            e eVar3 = eVar.f9378e;
            eVar3.f9377d = eVar.f9377d;
            eVar.f9377d.f9378e = eVar3;
        }
        e eVar4 = eVar.f9375b;
        e eVar5 = eVar.f9376c;
        e eVar6 = eVar.f9374a;
        int i11 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                replaceInParent(eVar, eVar4);
                eVar.f9375b = null;
            } else if (eVar5 != null) {
                replaceInParent(eVar, eVar5);
                eVar.f9376c = null;
            } else {
                replaceInParent(eVar, (e) null);
            }
            rebalance(eVar6, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (eVar4.f9382i > eVar5.f9382i) {
            eVar2 = eVar4.b();
        } else {
            eVar2 = eVar5.a();
        }
        removeInternal(eVar2, false);
        e eVar7 = eVar.f9375b;
        if (eVar7 != null) {
            i10 = eVar7.f9382i;
            eVar2.f9375b = eVar7;
            eVar7.f9374a = eVar2;
            eVar.f9375b = null;
        } else {
            i10 = 0;
        }
        e eVar8 = eVar.f9376c;
        if (eVar8 != null) {
            i11 = eVar8.f9382i;
            eVar2.f9376c = eVar8;
            eVar8.f9374a = eVar2;
            eVar.f9376c = null;
        }
        eVar2.f9382i = Math.max(i10, i11) + 1;
        replaceInParent(eVar, eVar2);
    }

    /* access modifiers changed from: package-private */
    public e removeInternalByKey(Object obj) {
        e findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean z10) {
        this(NATURAL_ORDER, z10);
    }

    public LinkedTreeMap(Comparator<? super K> comparator2, boolean z10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.allowNullValues = z10;
        this.header = new e(z10);
    }

    static final class e implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        e f9374a;

        /* renamed from: b  reason: collision with root package name */
        e f9375b;

        /* renamed from: c  reason: collision with root package name */
        e f9376c;

        /* renamed from: d  reason: collision with root package name */
        e f9377d;

        /* renamed from: e  reason: collision with root package name */
        e f9378e;

        /* renamed from: f  reason: collision with root package name */
        final Object f9379f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f9380g;

        /* renamed from: h  reason: collision with root package name */
        Object f9381h;

        /* renamed from: i  reason: collision with root package name */
        int f9382i;

        e(boolean z10) {
            this.f9379f = null;
            this.f9380g = z10;
            this.f9378e = this;
            this.f9377d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f9375b; eVar2 != null; eVar2 = eVar2.f9375b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f9376c; eVar2 != null; eVar2 = eVar2.f9376c) {
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
                java.lang.Object r0 = r3.f9379f
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                java.lang.Object r0 = r3.f9381h
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.e.equals(java.lang.Object):boolean");
        }

        public Object getKey() {
            return this.f9379f;
        }

        public Object getValue() {
            return this.f9381h;
        }

        public int hashCode() {
            int i10;
            Object obj = this.f9379f;
            int i11 = 0;
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            Object obj2 = this.f9381h;
            if (obj2 != null) {
                i11 = obj2.hashCode();
            }
            return i10 ^ i11;
        }

        public Object setValue(Object obj) {
            if (obj != null || this.f9380g) {
                Object obj2 = this.f9381h;
                this.f9381h = obj;
                return obj2;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f9379f + "=" + this.f9381h;
        }

        e(boolean z10, e eVar, Object obj, e eVar2, e eVar3) {
            this.f9374a = eVar;
            this.f9379f = obj;
            this.f9380g = z10;
            this.f9382i = 1;
            this.f9377d = eVar2;
            this.f9378e = eVar3;
            eVar3.f9377d = this;
            eVar2.f9378e = this;
        }
    }
}
