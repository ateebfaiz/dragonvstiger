package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.m;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.conscrypt.Conscrypt;

public final class ConscryptSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    ConscryptSocketAdapter$Companion$factory$1() {
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        return new ConscryptSocketAdapter();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        if (!ConscryptPlatform.Companion.isSupported() || !Conscrypt.isConscrypt(sSLSocket)) {
            return false;
        }
        return true;
    }
}
