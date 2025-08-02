package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;

@AnyThread
public abstract class ProxyController {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final ProxyController f16920a = new ProxyControllerImpl();
    }

    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            return a.f16920a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void clearProxyOverride(Executor executor, Runnable runnable);

    public abstract void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable);
}
