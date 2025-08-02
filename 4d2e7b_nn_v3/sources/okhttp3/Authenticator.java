package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

public interface Authenticator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator((Dns) null, 1, (DefaultConstructorMarker) null);
    public static final Authenticator NONE = new Companion.AuthenticatorNone();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private static final class AuthenticatorNone implements Authenticator {
            public Request authenticate(Route route, Response response) {
                m.f(response, "response");
                return null;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
