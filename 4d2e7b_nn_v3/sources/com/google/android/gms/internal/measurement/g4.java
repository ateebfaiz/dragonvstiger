package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class g4 extends AbstractSet {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h4 f7180a;

    /* synthetic */ g4(h4 h4Var, zzmh zzmh) {
        this.f7180a = h4Var;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f7180a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.f7180a.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f7180a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(value)) {
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        return new f4(this.f7180a, (zzmf) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f7180a.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.f7180a.size();
    }
}
