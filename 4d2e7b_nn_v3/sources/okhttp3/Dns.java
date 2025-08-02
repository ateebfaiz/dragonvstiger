package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public interface Dns {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Dns SYSTEM = new Companion.DnsSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private static final class DnsSystem implements Dns {
            public List<InetAddress> lookup(String str) {
                m.f(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    m.e(allByName, "InetAddress.getAllByName(hostname)");
                    return j.W(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
