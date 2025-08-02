package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;

public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements h {
    private final int arity;

    public RestrictedSuspendLambda(int i10, d dVar) {
        super(dVar);
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f10 = z.f(this);
        m.e(f10, "renderLambdaToString(...)");
        return f10;
    }
}
