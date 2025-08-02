package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class y1 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient f1 f1212a;

    public y1(String str, f1 f1Var) {
        super(str);
        this.f1212a = f1Var;
    }

    public y1(String str) {
        this(str, (f1) null);
    }
}
