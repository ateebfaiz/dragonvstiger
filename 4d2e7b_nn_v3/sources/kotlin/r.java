package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class r<T> implements Lazy, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private Function0 f12600a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f12601b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f12602c;

    public r(Function0 function0, Object obj) {
        m.f(function0, "initializer");
        this.f12600a = function0;
        this.f12601b = u.f12606a;
        this.f12602c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new e(getValue());
    }

    public boolean a() {
        if (this.f12601b != u.f12606a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        Object obj;
        Object obj2 = this.f12601b;
        u uVar = u.f12606a;
        if (obj2 != uVar) {
            return obj2;
        }
        synchronized (this.f12602c) {
            obj = this.f12601b;
            if (obj == uVar) {
                Function0 function0 = this.f12600a;
                m.c(function0);
                obj = function0.invoke();
                this.f12601b = obj;
                this.f12600a = null;
            }
        }
        return obj;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Function0 function0, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i10 & 2) != 0 ? null : obj);
    }
}
