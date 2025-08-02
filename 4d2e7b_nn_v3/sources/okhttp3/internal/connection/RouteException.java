package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.b;
import kotlin.jvm.internal.m;

public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouteException(IOException iOException) {
        super(iOException);
        m.f(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    public final void addConnectException(IOException iOException) {
        m.f(iOException, "e");
        b.a(this.firstConnectException, iOException);
        this.lastConnectException = iOException;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
