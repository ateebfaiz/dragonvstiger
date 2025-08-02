package com.google.android.gms.internal.auth;

import java.util.Map;

final class c2 implements Map.Entry, Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final Comparable f6905a;

    /* renamed from: b  reason: collision with root package name */
    private Object f6906b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f2 f6907c;

    c2(f2 f2Var, Comparable comparable, Object obj) {
        this.f6907c = f2Var;
        this.f6905a = comparable;
        this.f6906b = obj;
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
        return this.f6905a;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f6905a.compareTo(((c2) obj).f6905a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!b(this.f6905a, entry.getKey()) || !b(this.f6906b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.f6905a;
    }

    public final Object getValue() {
        return this.f6906b;
    }

    public final int hashCode() {
        int i10;
        Comparable comparable = this.f6905a;
        int i11 = 0;
        if (comparable == null) {
            i10 = 0;
        } else {
            i10 = comparable.hashCode();
        }
        Object obj = this.f6906b;
        if (obj != null) {
            i11 = obj.hashCode();
        }
        return i10 ^ i11;
    }

    public final Object setValue(Object obj) {
        this.f6907c.n();
        Object obj2 = this.f6906b;
        this.f6906b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6905a);
        String valueOf2 = String.valueOf(this.f6906b);
        return valueOf + "=" + valueOf2;
    }
}
