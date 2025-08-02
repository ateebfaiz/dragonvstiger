package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class h4 extends AbstractMap {

    /* renamed from: a  reason: collision with root package name */
    private final int f7186a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List f7187b = Collections.emptyList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map f7188c = Collections.emptyMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7189d;

    /* renamed from: e  reason: collision with root package name */
    private volatile g4 f7190e;

    /* renamed from: f  reason: collision with root package name */
    private Map f7191f = Collections.emptyMap();

    /* synthetic */ h4(int i10, zzmj zzmj) {
        this.f7186a = i10;
    }

    private final int k(Comparable comparable) {
        int size = this.f7187b.size();
        int i10 = size - 1;
        int i11 = 0;
        if (i10 >= 0) {
            int compareTo = comparable.compareTo(((e4) this.f7187b.get(i10)).a());
            if (compareTo > 0) {
                return -(size + 1);
            }
            if (compareTo == 0) {
                return i10;
            }
        }
        while (i11 <= i10) {
            int i12 = (i11 + i10) / 2;
            int compareTo2 = comparable.compareTo(((e4) this.f7187b.get(i12)).a());
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
        Object value = ((e4) this.f7187b.remove(i10)).getValue();
        if (!this.f7188c.isEmpty()) {
            Iterator it = m().entrySet().iterator();
            List list = this.f7187b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new e4(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap m() {
        n();
        if (this.f7188c.isEmpty() && !(this.f7188c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7188c = treeMap;
            this.f7191f = treeMap.descendingMap();
        }
        return (SortedMap) this.f7188c;
    }

    /* access modifiers changed from: private */
    public final void n() {
        if (this.f7189d) {
            throw new UnsupportedOperationException();
        }
    }

    public void a() {
        Map map;
        Map map2;
        if (!this.f7189d) {
            if (this.f7188c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f7188c);
            }
            this.f7188c = map;
            if (this.f7191f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f7191f);
            }
            this.f7191f = map2;
            this.f7189d = true;
        }
    }

    public final int b() {
        return this.f7187b.size();
    }

    public final Iterable c() {
        if (this.f7188c.isEmpty()) {
            return d4.a();
        }
        return this.f7188c.entrySet();
    }

    public final void clear() {
        n();
        if (!this.f7187b.isEmpty()) {
            this.f7187b.clear();
        }
        if (!this.f7188c.isEmpty()) {
            this.f7188c.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (k(comparable) >= 0 || this.f7188c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final Object put(Comparable comparable, Object obj) {
        n();
        int k10 = k(comparable);
        if (k10 >= 0) {
            return ((e4) this.f7187b.get(k10)).setValue(obj);
        }
        n();
        if (this.f7187b.isEmpty() && !(this.f7187b instanceof ArrayList)) {
            this.f7187b = new ArrayList(this.f7186a);
        }
        int i10 = -(k10 + 1);
        if (i10 >= this.f7186a) {
            return m().put(comparable, obj);
        }
        int size = this.f7187b.size();
        int i11 = this.f7186a;
        if (size == i11) {
            e4 e4Var = (e4) this.f7187b.remove(i11 - 1);
            m().put(e4Var.a(), e4Var.getValue());
        }
        this.f7187b.add(i10, new e4(this, comparable, obj));
        return null;
    }

    public final Set entrySet() {
        if (this.f7190e == null) {
            this.f7190e = new g4(this, (zzmh) null);
        }
        return this.f7190e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h4)) {
            return super.equals(obj);
        }
        h4 h4Var = (h4) obj;
        int size = size();
        if (size != h4Var.size()) {
            return false;
        }
        int b10 = b();
        if (b10 != h4Var.b()) {
            return entrySet().equals(h4Var.entrySet());
        }
        for (int i10 = 0; i10 < b10; i10++) {
            if (!g(i10).equals(h4Var.g(i10))) {
                return false;
            }
        }
        if (b10 != size) {
            return this.f7188c.equals(h4Var.f7188c);
        }
        return true;
    }

    public final Map.Entry g(int i10) {
        return (Map.Entry) this.f7187b.get(i10);
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int k10 = k(comparable);
        if (k10 >= 0) {
            return ((e4) this.f7187b.get(k10)).getValue();
        }
        return this.f7188c.get(comparable);
    }

    public final int hashCode() {
        int b10 = b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10; i11++) {
            i10 += ((e4) this.f7187b.get(i11)).hashCode();
        }
        if (this.f7188c.size() > 0) {
            return i10 + this.f7188c.hashCode();
        }
        return i10;
    }

    public final boolean j() {
        return this.f7189d;
    }

    public final Object remove(Object obj) {
        n();
        Comparable comparable = (Comparable) obj;
        int k10 = k(comparable);
        if (k10 >= 0) {
            return l(k10);
        }
        if (this.f7188c.isEmpty()) {
            return null;
        }
        return this.f7188c.remove(comparable);
    }

    public final int size() {
        return this.f7187b.size() + this.f7188c.size();
    }
}
