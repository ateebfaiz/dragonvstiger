package com.google.android.gms.internal.auth;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class f2 extends AbstractMap {

    /* renamed from: a  reason: collision with root package name */
    private final int f6919a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List f6920b = Collections.emptyList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map f6921c = Collections.emptyMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f6922d;

    /* renamed from: e  reason: collision with root package name */
    private volatile e2 f6923e;

    /* renamed from: f  reason: collision with root package name */
    private Map f6924f = Collections.emptyMap();

    /* synthetic */ f2(int i10, zzgt zzgt) {
        this.f6919a = i10;
    }

    private final int k(Comparable comparable) {
        int size = this.f6920b.size();
        int i10 = size - 1;
        int i11 = 0;
        if (i10 >= 0) {
            int compareTo = comparable.compareTo(((c2) this.f6920b.get(i10)).a());
            if (compareTo > 0) {
                return -(size + 1);
            }
            if (compareTo == 0) {
                return i10;
            }
        }
        while (i11 <= i10) {
            int i12 = (i11 + i10) / 2;
            int compareTo2 = comparable.compareTo(((c2) this.f6920b.get(i12)).a());
            if (compareTo2 < 0) {
                i10 = i12 - 1;
            } else if (compareTo2 <= 0) {
                return i12;
            } else {
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }

    /* access modifiers changed from: private */
    public final Object l(int i10) {
        n();
        Object value = ((c2) this.f6920b.remove(i10)).getValue();
        if (!this.f6921c.isEmpty()) {
            Iterator it = m().entrySet().iterator();
            List list = this.f6920b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new c2(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap m() {
        n();
        if (this.f6921c.isEmpty() && !(this.f6921c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6921c = treeMap;
            this.f6924f = treeMap.descendingMap();
        }
        return (SortedMap) this.f6921c;
    }

    /* access modifiers changed from: private */
    public final void n() {
        if (this.f6922d) {
            throw new UnsupportedOperationException();
        }
    }

    public void a() {
        Map map;
        Map map2;
        if (!this.f6922d) {
            if (this.f6921c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f6921c);
            }
            this.f6921c = map;
            if (this.f6924f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f6924f);
            }
            this.f6924f = map2;
            this.f6922d = true;
        }
    }

    public final int b() {
        return this.f6920b.size();
    }

    public final Iterable c() {
        if (this.f6921c.isEmpty()) {
            return b2.a();
        }
        return this.f6921c.entrySet();
    }

    public final void clear() {
        n();
        if (!this.f6920b.isEmpty()) {
            this.f6920b.clear();
        }
        if (!this.f6921c.isEmpty()) {
            this.f6921c.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (k(comparable) >= 0 || this.f6921c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final Object put(Comparable comparable, Object obj) {
        n();
        int k10 = k(comparable);
        if (k10 >= 0) {
            return ((c2) this.f6920b.get(k10)).setValue(obj);
        }
        n();
        if (this.f6920b.isEmpty() && !(this.f6920b instanceof ArrayList)) {
            this.f6920b = new ArrayList(this.f6919a);
        }
        int i10 = -(k10 + 1);
        if (i10 >= this.f6919a) {
            return m().put(comparable, obj);
        }
        int size = this.f6920b.size();
        int i11 = this.f6919a;
        if (size == i11) {
            c2 c2Var = (c2) this.f6920b.remove(i11 - 1);
            m().put(c2Var.a(), c2Var.getValue());
        }
        this.f6920b.add(i10, new c2(this, comparable, obj));
        return null;
    }

    public final Set entrySet() {
        if (this.f6923e == null) {
            this.f6923e = new e2(this, (zzgr) null);
        }
        return this.f6923e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return super.equals(obj);
        }
        f2 f2Var = (f2) obj;
        int size = size();
        if (size != f2Var.size()) {
            return false;
        }
        int b10 = b();
        if (b10 != f2Var.b()) {
            return entrySet().equals(f2Var.entrySet());
        }
        for (int i10 = 0; i10 < b10; i10++) {
            if (!g(i10).equals(f2Var.g(i10))) {
                return false;
            }
        }
        if (b10 != size) {
            return this.f6921c.equals(f2Var.f6921c);
        }
        return true;
    }

    public final Map.Entry g(int i10) {
        return (Map.Entry) this.f6920b.get(i10);
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int k10 = k(comparable);
        if (k10 >= 0) {
            return ((c2) this.f6920b.get(k10)).getValue();
        }
        return this.f6921c.get(comparable);
    }

    public final int hashCode() {
        int b10 = b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10; i11++) {
            i10 += ((c2) this.f6920b.get(i11)).hashCode();
        }
        if (this.f6921c.size() > 0) {
            return i10 + this.f6921c.hashCode();
        }
        return i10;
    }

    public final boolean j() {
        return this.f6922d;
    }

    public final Object remove(Object obj) {
        n();
        Comparable comparable = (Comparable) obj;
        int k10 = k(comparable);
        if (k10 >= 0) {
            return l(k10);
        }
        if (this.f6921c.isEmpty()) {
            return null;
        }
        return this.f6921c.remove(comparable);
    }

    public final int size() {
        return this.f6920b.size() + this.f6921c.size();
    }
}
