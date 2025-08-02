package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.m;

public final class Pair<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12575a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f12576b;

    public Pair(Object obj, Object obj2) {
        this.f12575a = obj;
        this.f12576b = obj2;
    }

    public final Object a() {
        return this.f12575a;
    }

    public final Object b() {
        return this.f12576b;
    }

    public final Object c() {
        return this.f12575a;
    }

    public final Object d() {
        return this.f12576b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return m.b(this.f12575a, pair.f12575a) && m.b(this.f12576b, pair.f12576b);
    }

    public int hashCode() {
        Object obj = this.f12575a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f12576b;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return '(' + this.f12575a + ", " + this.f12576b + ')';
    }
}
