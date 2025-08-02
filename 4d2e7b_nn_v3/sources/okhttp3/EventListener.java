package okhttp3;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class EventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(response, "response");
    }

    public void cacheMiss(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void callEnd(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(Call call, IOException iOException) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(iOException, "ioe");
    }

    public void callStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void canceled(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(inetSocketAddress, "inetSocketAddress");
        m.f(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(inetSocketAddress, "inetSocketAddress");
        m.f(proxy, "proxy");
        m.f(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(inetSocketAddress, "inetSocketAddress");
        m.f(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(str, "domainName");
        m.f(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(httpUrl, ImagesContract.URL);
        m.f(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(httpUrl, ImagesContract.URL);
    }

    public void requestBodyEnd(Call call, long j10) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(Call call, IOException iOException) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(request, "request");
    }

    public void requestHeadersStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(Call call, long j10) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(Call call, IOException iOException) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(response, "response");
    }

    public void responseHeadersStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void satisfactionFailure(Call call, Response response) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
        m.f(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(Call call) {
        m.f(call, NotificationCompat.CATEGORY_CALL);
    }
}
