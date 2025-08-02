package kotlin;

import java.io.Serializable;

public final class e implements Lazy, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12578a;

    public e(Object obj) {
        this.f12578a = obj;
    }

    public Object getValue() {
        return this.f12578a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
