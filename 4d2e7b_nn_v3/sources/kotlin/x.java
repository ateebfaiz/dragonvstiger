package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public final class x implements Lazy, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private Function0 f12608a;

    /* renamed from: b  reason: collision with root package name */
    private Object f12609b = u.f12606a;

    public x(Function0 function0) {
        m.f(function0, "initializer");
        this.f12608a = function0;
    }

    private final Object writeReplace() {
        return new e(getValue());
    }

    public boolean a() {
        if (this.f12609b != u.f12606a) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        if (this.f12609b == u.f12606a) {
            Function0 function0 = this.f12608a;
            m.c(function0);
            this.f12609b = function0.invoke();
            this.f12608a = null;
        }
        return this.f12609b;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
