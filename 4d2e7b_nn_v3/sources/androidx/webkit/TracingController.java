package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.webkit.internal.TracingControllerImpl;
import java.io.OutputStream;
import java.util.concurrent.Executor;

@AnyThread
public abstract class TracingController {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final TracingController f16922a = new TracingControllerImpl();
    }

    public static TracingController getInstance() {
        return a.f16922a;
    }

    public abstract boolean isTracing();

    public abstract void start(TracingConfig tracingConfig);

    public abstract boolean stop(OutputStream outputStream, Executor executor);
}
