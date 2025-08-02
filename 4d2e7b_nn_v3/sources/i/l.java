package i;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class l implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HostnameVerifier f22011a;

    public /* synthetic */ l(HostnameVerifier hostnameVerifier) {
        this.f22011a = hostnameVerifier;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return n.e(this.f22011a, str, sSLSession);
    }
}
