package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import wb.a;

final class e0 implements Map, Serializable, a {

    /* renamed from: a  reason: collision with root package name */
    public static final e0 f639a = new e0();

    private e0() {
    }

    private final Object readResolve() {
        return f639a;
    }

    public boolean a(Void voidR) {
        m.f(voidR, "value");
        return false;
    }

    /* renamed from: c */
    public Void get(Object obj) {
        return null;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return a((Void) obj);
    }

    public Set d() {
        return f0.f640a;
    }

    public Set e() {
        return f0.f640a;
    }

    public final /* bridge */ Set entrySet() {
        return d();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map) || !((Map) obj).isEmpty()) {
            return false;
        }
        return true;
    }

    public int f() {
        return 0;
    }

    public int hashCode() {
        return 0;
    }

    public Collection i() {
        return d0.f638a;
    }

    public boolean isEmpty() {
        return true;
    }

    /* renamed from: j */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ Set keySet() {
        return e();
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return f();
    }

    public String toString() {
        return "{}";
    }

    public final /* bridge */ Collection values() {
        return i();
    }
}
