package org.cocos2dx.okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.internal.Util;

public final class Address {
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final Dns dns;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final HttpUrl url;

    public Address(String str, int i10, Dns dns2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator, Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i10).build();
        if (dns2 != null) {
            this.dns = dns2;
            if (socketFactory2 != null) {
                this.socketFactory = socketFactory2;
                if (authenticator != null) {
                    this.proxyAuthenticator = authenticator;
                    if (list != null) {
                        this.protocols = Util.immutableList(list);
                        if (list2 != null) {
                            this.connectionSpecs = Util.immutableList(list2);
                            if (proxySelector2 != null) {
                                this.proxySelector = proxySelector2;
                                this.proxy = proxy2;
                                this.sslSocketFactory = sSLSocketFactory;
                                this.hostnameVerifier = hostnameVerifier2;
                                this.certificatePinner = certificatePinner2;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (!this.url.equals(address.url) || !equalsNonHost(address)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean equalsNonHost(Address address) {
        if (!this.dns.equals(address.dns) || !this.proxyAuthenticator.equals(address.proxyAuthenticator) || !this.protocols.equals(address.protocols) || !this.connectionSpecs.equals(address.connectionSpecs) || !this.proxySelector.equals(address.proxySelector) || !Util.equal(this.proxy, address.proxy) || !Util.equal(this.sslSocketFactory, address.sslSocketFactory) || !Util.equal(this.hostnameVerifier, address.hostnameVerifier) || !Util.equal(this.certificatePinner, address.certificatePinner) || url().port() != address.url().port()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int hashCode = (((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31;
        Proxy proxy2 = this.proxy;
        int i13 = 0;
        if (proxy2 != null) {
            i10 = proxy2.hashCode();
        } else {
            i10 = 0;
        }
        int i14 = (hashCode + i10) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        if (sSLSocketFactory != null) {
            i11 = sSLSocketFactory.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = (i14 + i11) * 31;
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        if (hostnameVerifier2 != null) {
            i12 = hostnameVerifier2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        CertificatePinner certificatePinner2 = this.certificatePinner;
        if (certificatePinner2 != null) {
            i13 = certificatePinner2.hashCode();
        }
        return i16 + i13;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(":");
        sb2.append(this.url.port());
        if (this.proxy != null) {
            sb2.append(", proxy=");
            sb2.append(this.proxy);
        } else {
            sb2.append(", proxySelector=");
            sb2.append(this.proxySelector);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public HttpUrl url() {
        return this.url;
    }
}
