package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.r;

public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    private NullProxySelector() {
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return r.e(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
