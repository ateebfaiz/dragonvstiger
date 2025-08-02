package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class n implements h, Serializable {
    private final int arity;

    public n(int i10) {
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String g10 = z.g(this);
        m.e(g10, "renderLambdaToString(...)");
        return g10;
    }
}
