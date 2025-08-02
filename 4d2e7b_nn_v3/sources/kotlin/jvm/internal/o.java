package kotlin.jvm.internal;

import zb.b;
import zb.g;
import zb.j;

public abstract class o extends q implements g {
    public o() {
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return z.d(this);
    }

    public Object getDelegate() {
        return ((g) getReflected()).getDelegate();
    }

    public Object invoke() {
        return get();
    }

    public o(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    public j.a getGetter() {
        ((g) getReflected()).getGetter();
        return null;
    }

    public g.a getSetter() {
        ((g) getReflected()).getSetter();
        return null;
    }
}
