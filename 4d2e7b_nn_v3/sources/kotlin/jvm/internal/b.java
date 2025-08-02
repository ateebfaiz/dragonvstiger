package kotlin.jvm.internal;

import java.util.Iterator;

public abstract class b {
    public static final Iterator a(Object[] objArr) {
        m.f(objArr, "array");
        return new a(objArr);
    }
}
