package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1193a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f1194b;

    public t(Object obj, Function1 function1) {
        this.f1193a = obj;
        this.f1194b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return m.b(this.f1193a, tVar.f1193a) && m.b(this.f1194b, tVar.f1194b);
    }

    public int hashCode() {
        Object obj = this.f1193a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f1194b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f1193a + ", onCancellation=" + this.f1194b + ')';
    }
}
