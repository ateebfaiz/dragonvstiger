package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.d;

public final class a extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient d f1047a;

    public a(d dVar) {
        super("Flow was aborted, no more elements needed");
        this.f1047a = dVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
