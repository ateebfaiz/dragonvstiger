package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

final class Handshake$peerCertificates$2 extends n implements Function0<List<? extends Certificate>> {
    final /* synthetic */ Function0 $peerCertificatesFn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Handshake$peerCertificates$2(Function0 function0) {
        super(0);
        this.$peerCertificatesFn = function0;
    }

    public final List<Certificate> invoke() {
        try {
            return (List) this.$peerCertificatesFn.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return r.l();
        }
    }
}
