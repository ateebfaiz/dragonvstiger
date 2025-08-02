package com.google.android.gms.internal.measurement;

import java.util.Map;

final class e4 implements Map.Entry, Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final Comparable f7158a;

    /* renamed from: b  reason: collision with root package name */
    private Object f7159b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h4 f7160c;

    e4(h4 h4Var, Comparable comparable, Object obj) {
        this.f7160c = h4Var;
        this.f7158a = comparable;
        this.f7159b = obj;
    }

    private static final boolean b(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 != null) {
            return false;
        }
        return true;
    }

    public final Comparable a() {
        return this.f7158a;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f7158a.compareTo(((e4) obj).f7158a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!b(this.f7158a, entry.getKey()) || !b(this.f7159b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.f7158a;
    }

    public final Object getValue() {
        return this.f7159b;
    }

    public final int hashCode() {
        int i10;
        Comparable comparable = this.f7158a;
        int i11 = 0;
        if (comparable == null) {
            i10 = 0;
        } else {
            i10 = comparable.hashCode();
        }
        Object obj = this.f7159b;
        if (obj != null) {
            i11 = obj.hashCode();
        }
        return i10 ^ i11;
    }

    public final Object setValue(Object obj) {
        this.f7160c.n();
        Object obj2 = this.f7159b;
        this.f7159b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f7158a);
        String valueOf2 = String.valueOf(this.f7159b);
        return valueOf + "=" + valueOf2;
    }
}
