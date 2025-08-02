package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String str, int i10, Dns dns2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator, Proxy proxy2, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        m.f(str, "uriHost");
        m.f(dns2, "dns");
        m.f(socketFactory2, "socketFactory");
        m.f(authenticator, "proxyAuthenticator");
        m.f(list, "protocols");
        m.f(list2, "connectionSpecs");
        m.f(proxySelector2, "proxySelector");
        this.dns = dns2;
        this.socketFactory = socketFactory2;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier2;
        this.certificatePinner = certificatePinner2;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy2;
        this.proxySelector = proxySelector2;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i10).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m0deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m1deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m2deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m3deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m4deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m5deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m6deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m7deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m8deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m9deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m10deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (!m.b(this.url, address.url) || !equalsNonHost$okhttp(address)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        m.f(address, "that");
        if (!m.b(this.dns, address.dns) || !m.b(this.proxyAuthenticator, address.proxyAuthenticator) || !m.b(this.protocols, address.protocols) || !m.b(this.connectionSpecs, address.connectionSpecs) || !m.b(this.proxySelector, address.proxySelector) || !m.b(this.proxy, address.proxy) || !m.b(this.sslSocketFactory, address.sslSocketFactory) || !m.b(this.hostnameVerifier, address.hostnameVerifier) || !m.b(this.certificatePinner, address.certificatePinner) || this.url.port() != address.url.port()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.host());
        sb3.append(':');
        sb3.append(this.url.port());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append("}");
        return sb3.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }
}
