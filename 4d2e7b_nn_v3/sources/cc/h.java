package cc;

import kotlin.coroutines.CoroutineContext;

public final class h extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient CoroutineContext f73a;

    public h(CoroutineContext coroutineContext) {
        this.f73a = coroutineContext;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f73a.toString();
    }
}
