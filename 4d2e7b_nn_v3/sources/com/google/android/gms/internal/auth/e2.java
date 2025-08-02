package com.google.android.gms.internal.auth;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class e2 extends AbstractSet {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f2 f6917a;

    /* synthetic */ e2(f2 f2Var, zzgr zzgr) {
        this.f6917a = f2Var;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f6917a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.f6917a.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f6917a.get(entry.getKey());
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
        return new d2(this.f6917a, (zzgp) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f6917a.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.f6917a.size();
    }
}
