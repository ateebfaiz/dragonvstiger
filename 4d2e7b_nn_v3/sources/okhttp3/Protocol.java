package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final String protocol;

    public static final class Companion {
        private Companion() {
        }

        public final Protocol get(String str) throws IOException {
            m.f(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!m.b(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!m.b(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!m.b(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!m.b(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!m.b(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!m.b(str, protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    public String toString() {
        return this.protocol;
    }
}
