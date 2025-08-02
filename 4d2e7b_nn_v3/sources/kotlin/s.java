package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.m;

public final class s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12603a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f12604b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f12605c;

    public s(Object obj, Object obj2, Object obj3) {
        this.f12603a = obj;
        this.f12604b = obj2;
        this.f12605c = obj3;
    }

    public final Object a() {
        return this.f12603a;
    }

    public final Object b() {
        return this.f12604b;
    }

    public final Object c() {
        return this.f12605c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return m.b(this.f12603a, sVar.f12603a) && m.b(this.f12604b, sVar.f12604b) && m.b(this.f12605c, sVar.f12605c);
    }

    public int hashCode() {
        Object obj = this.f12603a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f12604b;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f12605c;
        if (obj3 != null) {
            i10 = obj3.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return '(' + this.f12603a + ", " + this.f12604b + ", " + this.f12605c + ')';
    }
}
