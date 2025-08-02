package okhttp3.internal.platform.android;

import io.jsonwebtoken.JwtParser;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    final /* synthetic */ String $packageName;

    AndroidSocketAdapter$Companion$factory$1(String str) {
        this.$packageName = str;
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        return AndroidSocketAdapter.Companion.build(sSLSocket.getClass());
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        m.e(name, "sslSocket.javaClass.name");
        return j.F(name, this.$packageName + JwtParser.SEPARATOR_CHAR, false, 2, (Object) null);
    }
}
