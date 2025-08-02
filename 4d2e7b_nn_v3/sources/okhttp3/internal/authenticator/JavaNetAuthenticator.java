package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        }
    }

    public JavaNetAuthenticator() {
        this((Dns) null, 1, (DefaultConstructorMarker) null);
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
            return (InetAddress) r.Y(dns.lookup(httpUrl.host()));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            m.e(address2, "(address() as InetSocketAddress).address");
            return address2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    public Request authenticate(Route route, Response response) throws IOException {
        boolean z10;
        Proxy proxy;
        Dns dns;
        PasswordAuthentication passwordAuthentication;
        String str;
        Address address;
        m.f(response, "response");
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        if (response.code() == 407) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge next : challenges) {
            if (j.q("Basic", next.scheme(), true)) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (z10) {
                    SocketAddress address2 = proxy.address();
                    if (address2 != null) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                        String hostName = inetSocketAddress.getHostName();
                        m.e(proxy, "proxy");
                        passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(hostName, connectToInetAddress(proxy, url, dns), inetSocketAddress.getPort(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                } else {
                    String host = url.host();
                    m.e(proxy, "proxy");
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(host, connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    if (z10) {
                        str = "Proxy-Authorization";
                    } else {
                        str = "Authorization";
                    }
                    String userName = passwordAuthentication.getUserName();
                    m.e(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    m.e(password, "auth.password");
                    return request.newBuilder().header(str, Credentials.basic(userName, new String(password), next.charset())).build();
                }
            }
        }
        return null;
    }

    public JavaNetAuthenticator(Dns dns) {
        m.f(dns, "defaultDns");
        this.defaultDns = dns;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
