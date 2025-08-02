package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import okhttp3.Handshake;

final class RealConnection$connectTls$2 extends n implements Function0<List<? extends X509Certificate>> {
    final /* synthetic */ RealConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.this$0 = realConnection;
    }

    public final List<X509Certificate> invoke() {
        Handshake access$getHandshake$p = this.this$0.handshake;
        m.c(access$getHandshake$p);
        Iterable<Certificate> peerCertificates = access$getHandshake$p.peerCertificates();
        ArrayList arrayList = new ArrayList(r.v(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            if (certificate != null) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        return arrayList;
    }
}
