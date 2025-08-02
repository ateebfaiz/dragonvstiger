package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;

public final class h extends CancellationException {
    public h() {
        super("Child of the scoped flow was cancelled");
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
