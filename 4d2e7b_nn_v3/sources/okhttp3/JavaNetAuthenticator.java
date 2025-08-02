package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.m;

public final class JavaNetAuthenticator implements Authenticator {
    public Request authenticate(Route route, Response response) throws IOException {
        m.f(response, "response");
        return Authenticator.JAVA_NET_AUTHENTICATOR.authenticate(route, response);
    }
}
