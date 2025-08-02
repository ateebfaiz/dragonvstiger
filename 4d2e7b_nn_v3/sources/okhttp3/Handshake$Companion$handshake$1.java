package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

final class Handshake$Companion$handshake$1 extends n implements Function0<List<? extends Certificate>> {
    final /* synthetic */ List $peerCertificatesCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Handshake$Companion$handshake$1(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
