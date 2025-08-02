package okhttp3;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketExtensions;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);
    /* access modifiers changed from: private */
    public static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    public static final class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        private ConnectionPool connectionPool;
        private List<ConnectionSpec> connectionSpecs;
        private CookieJar cookieJar;
        private Dispatcher dispatcher;
        private Dns dns;
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends Protocol> protocols;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private RouteDatabase routeDatabase;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator2 = Authenticator.NONE;
            this.authenticator = authenticator2;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator2;
            SocketFactory socketFactory2 = SocketFactory.getDefault();
            m.e(socketFactory2, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory2;
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        }

        /* renamed from: -addInterceptor  reason: not valid java name */
        public final Builder m110addInterceptor(Function1<? super Interceptor.Chain, Response> function1) {
            m.f(function1, "block");
            return addInterceptor(new OkHttpClient$Builder$addInterceptor$2(function1));
        }

        /* renamed from: -addNetworkInterceptor  reason: not valid java name */
        public final Builder m111addNetworkInterceptor(Function1<? super Interceptor.Chain, Response> function1) {
            m.f(function1, "block");
            return addNetworkInterceptor(new OkHttpClient$Builder$addNetworkInterceptor$2(function1));
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            m.f(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(Interceptor interceptor) {
            m.f(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final Builder authenticator(Authenticator authenticator2) {
            m.f(authenticator2, "authenticator");
            this.authenticator = authenticator2;
            return this;
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public final Builder cache(Cache cache2) {
            this.cache = cache2;
            return this;
        }

        public final Builder callTimeout(long j10, TimeUnit timeUnit) {
            m.f(timeUnit, "unit");
            this.callTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public final Builder certificatePinner(CertificatePinner certificatePinner2) {
            m.f(certificatePinner2, "certificatePinner");
            if (!m.b(certificatePinner2, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner2;
            return this;
        }

        public final Builder connectTimeout(long j10, TimeUnit timeUnit) {
            m.f(timeUnit, "unit");
            this.connectTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public final Builder connectionPool(ConnectionPool connectionPool2) {
            m.f(connectionPool2, "connectionPool");
            this.connectionPool = connectionPool2;
            return this;
        }

        public final Builder connectionSpecs(List<ConnectionSpec> list) {
            m.f(list, "connectionSpecs");
            if (!m.b(list, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(list);
            return this;
        }

        public final Builder cookieJar(CookieJar cookieJar2) {
            m.f(cookieJar2, "cookieJar");
            this.cookieJar = cookieJar2;
            return this;
        }

        public final Builder dispatcher(Dispatcher dispatcher2) {
            m.f(dispatcher2, "dispatcher");
            this.dispatcher = dispatcher2;
            return this;
        }

        public final Builder dns(Dns dns2) {
            m.f(dns2, "dns");
            if (!m.b(dns2, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns2;
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            m.f(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        public final Builder eventListenerFactory(EventListener.Factory factory) {
            m.f(factory, "eventListenerFactory");
            this.eventListenerFactory = factory;
            return this;
        }

        public final Builder followRedirects(boolean z10) {
            this.followRedirects = z10;
            return this;
        }

        public final Builder followSslRedirects(boolean z10) {
            this.followSslRedirects = z10;
            return this;
        }

        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final Dns getDns$okhttp() {
            return this.dns;
        }

        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            m.f(hostnameVerifier2, "hostnameVerifier");
            if (!m.b(hostnameVerifier2, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier2;
            return this;
        }

        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public final Builder minWebSocketMessageToCompress(long j10) {
            boolean z10;
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.minWebSocketMessageToCompress = j10;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j10).toString());
        }

        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final Builder pingInterval(long j10, TimeUnit timeUnit) {
            m.f(timeUnit, "unit");
            this.pingInterval = Util.checkDuration("interval", j10, timeUnit);
            return this;
        }

        public final Builder protocols(List<? extends Protocol> list) {
            boolean z10;
            m.f(list, "protocols");
            List y02 = r.y0(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            boolean z11 = false;
            if (y02.contains(protocol) || y02.contains(Protocol.HTTP_1_1)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (!y02.contains(protocol) || y02.size() <= 1) {
                    z11 = true;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + y02).toString());
                } else if (!(!y02.contains(Protocol.HTTP_1_0))) {
                    throw new IllegalArgumentException(("protocols must not contain http/1.0: " + y02).toString());
                } else if (!y02.contains((Object) null)) {
                    y02.remove(Protocol.SPDY_3);
                    if (!m.b(y02, this.protocols)) {
                        this.routeDatabase = null;
                    }
                    List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(y02);
                    m.e(unmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
                    this.protocols = unmodifiableList;
                    return this;
                } else {
                    throw new IllegalArgumentException("protocols must not contain null".toString());
                }
            } else {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + y02).toString());
            }
        }

        public final Builder proxy(Proxy proxy2) {
            if (!m.b(proxy2, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy2;
            return this;
        }

        public final Builder proxyAuthenticator(Authenticator authenticator2) {
            m.f(authenticator2, "proxyAuthenticator");
            if (!m.b(authenticator2, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = authenticator2;
            return this;
        }

        public final Builder proxySelector(ProxySelector proxySelector2) {
            m.f(proxySelector2, "proxySelector");
            if (!m.b(proxySelector2, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector2;
            return this;
        }

        public final Builder readTimeout(long j10, TimeUnit timeUnit) {
            m.f(timeUnit, "unit");
            this.readTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean z10) {
            this.retryOnConnectionFailure = z10;
            return this;
        }

        public final void setAuthenticator$okhttp(Authenticator authenticator2) {
            m.f(authenticator2, "<set-?>");
            this.authenticator = authenticator2;
        }

        public final void setCache$okhttp(Cache cache2) {
            this.cache = cache2;
        }

        public final void setCallTimeout$okhttp(int i10) {
            this.callTimeout = i10;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner2) {
            this.certificateChainCleaner = certificateChainCleaner2;
        }

        public final void setCertificatePinner$okhttp(CertificatePinner certificatePinner2) {
            m.f(certificatePinner2, "<set-?>");
            this.certificatePinner = certificatePinner2;
        }

        public final void setConnectTimeout$okhttp(int i10) {
            this.connectTimeout = i10;
        }

        public final void setConnectionPool$okhttp(ConnectionPool connectionPool2) {
            m.f(connectionPool2, "<set-?>");
            this.connectionPool = connectionPool2;
        }

        public final void setConnectionSpecs$okhttp(List<ConnectionSpec> list) {
            m.f(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(CookieJar cookieJar2) {
            m.f(cookieJar2, "<set-?>");
            this.cookieJar = cookieJar2;
        }

        public final void setDispatcher$okhttp(Dispatcher dispatcher2) {
            m.f(dispatcher2, "<set-?>");
            this.dispatcher = dispatcher2;
        }

        public final void setDns$okhttp(Dns dns2) {
            m.f(dns2, "<set-?>");
            this.dns = dns2;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
            m.f(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z10) {
            this.followRedirects = z10;
        }

        public final void setFollowSslRedirects$okhttp(boolean z10) {
            this.followSslRedirects = z10;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier2) {
            m.f(hostnameVerifier2, "<set-?>");
            this.hostnameVerifier = hostnameVerifier2;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j10) {
            this.minWebSocketMessageToCompress = j10;
        }

        public final void setPingInterval$okhttp(int i10) {
            this.pingInterval = i10;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> list) {
            m.f(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(Proxy proxy2) {
            this.proxy = proxy2;
        }

        public final void setProxyAuthenticator$okhttp(Authenticator authenticator2) {
            m.f(authenticator2, "<set-?>");
            this.proxyAuthenticator = authenticator2;
        }

        public final void setProxySelector$okhttp(ProxySelector proxySelector2) {
            this.proxySelector = proxySelector2;
        }

        public final void setReadTimeout$okhttp(int i10) {
            this.readTimeout = i10;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z10) {
            this.retryOnConnectionFailure = z10;
        }

        public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase2) {
            this.routeDatabase = routeDatabase2;
        }

        public final void setSocketFactory$okhttp(SocketFactory socketFactory2) {
            m.f(socketFactory2, "<set-?>");
            this.socketFactory = socketFactory2;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i10) {
            this.writeTimeout = i10;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        public final Builder socketFactory(SocketFactory socketFactory2) {
            m.f(socketFactory2, "socketFactory");
            if (!(socketFactory2 instanceof SSLSocketFactory)) {
                if (!m.b(socketFactory2, this.socketFactory)) {
                    this.routeDatabase = null;
                }
                this.socketFactory = socketFactory2;
                return this;
            }
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            m.f(sSLSocketFactory, "sslSocketFactory");
            if (!m.b(sSLSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sSLSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                m.c(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", " + "sslSocketFactory is " + sSLSocketFactory.getClass());
        }

        public final Builder writeTimeout(long j10, TimeUnit timeUnit) {
            m.f(timeUnit, "unit");
            this.writeTimeout = Util.checkDuration("timeout", j10, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder callTimeout(Duration duration) {
            m.f(duration, "duration");
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder connectTimeout(Duration duration) {
            m.f(duration, "duration");
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder pingInterval(Duration duration) {
            m.f(duration, "duration");
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder readTimeout(Duration duration) {
            m.f(duration, "duration");
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder writeTimeout(Duration duration) {
            m.f(duration, "duration");
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            m.f(sSLSocketFactory, "sslSocketFactory");
            m.f(x509TrustManager, "trustManager");
            if ((!m.b(sSLSocketFactory, this.sslSocketFactoryOrNull)) || (!m.b(x509TrustManager, this.x509TrustManagerOrNull))) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(x509TrustManager);
            this.x509TrustManagerOrNull = x509TrustManager;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(OkHttpClient okHttpClient) {
            this();
            m.f(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            r.z(this.interceptors, okHttpClient.interceptors());
            r.z(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OkHttpClient(Builder builder) {
        ProxySelector proxySelector2;
        m.f(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector2 = NullProxySelector.INSTANCE;
        } else {
            proxySelector2 = builder.getProxySelector$okhttp();
            proxySelector2 = proxySelector2 == null ? ProxySelector.getDefault() : proxySelector2;
            if (proxySelector2 == null) {
                proxySelector2 = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector2;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        Iterable iterable = connectionSpecs$okhttp;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((ConnectionSpec) it.next()).isTls()) {
                    if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
                        CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
                        m.c(certificateChainCleaner$okhttp);
                        this.certificateChainCleaner = certificateChainCleaner$okhttp;
                        X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
                        m.c(x509TrustManagerOrNull$okhttp);
                        this.x509TrustManager = x509TrustManagerOrNull$okhttp;
                        CertificatePinner certificatePinner$okhttp = builder.getCertificatePinner$okhttp();
                        m.c(certificateChainCleaner$okhttp);
                        this.certificatePinner = certificatePinner$okhttp.withCertificateChainCleaner$okhttp(certificateChainCleaner$okhttp);
                    } else {
                        Platform.Companion companion = Platform.Companion;
                        X509TrustManager platformTrustManager = companion.get().platformTrustManager();
                        this.x509TrustManager = platformTrustManager;
                        Platform platform = companion.get();
                        m.c(platformTrustManager);
                        this.sslSocketFactoryOrNull = platform.newSslSocketFactory(platformTrustManager);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.Companion;
                        m.c(platformTrustManager);
                        CertificateChainCleaner certificateChainCleaner2 = companion2.get(platformTrustManager);
                        this.certificateChainCleaner = certificateChainCleaner2;
                        CertificatePinner certificatePinner$okhttp2 = builder.getCertificatePinner$okhttp();
                        m.c(certificateChainCleaner2);
                        this.certificatePinner = certificatePinner$okhttp2.withCertificateChainCleaner$okhttp(certificateChainCleaner2);
                    }
                }
            }
            verifyClientState();
        }
        this.sslSocketFactoryOrNull = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        verifyClientState();
    }

    private final void verifyClientState() {
        boolean z10;
        boolean z11;
        List<Interceptor> list = this.interceptors;
        if (list != null) {
            boolean z12 = true;
            if (!list.contains((Object) null)) {
                List<Interceptor> list2 = this.networkInterceptors;
                if (list2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
                } else if (!list2.contains((Object) null)) {
                    Iterable<ConnectionSpec> iterable = this.connectionSpecs;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        for (ConnectionSpec isTls : iterable) {
                            if (isTls.isTls()) {
                                if (this.sslSocketFactoryOrNull == null) {
                                    throw new IllegalStateException("sslSocketFactory == null".toString());
                                } else if (this.certificateChainCleaner == null) {
                                    throw new IllegalStateException("certificateChainCleaner == null".toString());
                                } else if (this.x509TrustManager == null) {
                                    throw new IllegalStateException("x509TrustManager == null".toString());
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    if (this.sslSocketFactoryOrNull == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        if (this.certificateChainCleaner == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            if (this.x509TrustManager != null) {
                                z12 = false;
                            }
                            if (!z12) {
                                throw new IllegalStateException("Check failed.".toString());
                            } else if (!m.b(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
                }
            } else {
                throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
    }

    /* renamed from: -deprecated_authenticator  reason: not valid java name */
    public final Authenticator m84deprecated_authenticator() {
        return this.authenticator;
    }

    /* renamed from: -deprecated_cache  reason: not valid java name */
    public final Cache m85deprecated_cache() {
        return this.cache;
    }

    /* renamed from: -deprecated_callTimeoutMillis  reason: not valid java name */
    public final int m86deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m87deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectTimeoutMillis  reason: not valid java name */
    public final int m88deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: -deprecated_connectionPool  reason: not valid java name */
    public final ConnectionPool m89deprecated_connectionPool() {
        return this.connectionPool;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m90deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_cookieJar  reason: not valid java name */
    public final CookieJar m91deprecated_cookieJar() {
        return this.cookieJar;
    }

    /* renamed from: -deprecated_dispatcher  reason: not valid java name */
    public final Dispatcher m92deprecated_dispatcher() {
        return this.dispatcher;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m93deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_eventListenerFactory  reason: not valid java name */
    public final EventListener.Factory m94deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* renamed from: -deprecated_followRedirects  reason: not valid java name */
    public final boolean m95deprecated_followRedirects() {
        return this.followRedirects;
    }

    /* renamed from: -deprecated_followSslRedirects  reason: not valid java name */
    public final boolean m96deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m97deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_interceptors  reason: not valid java name */
    public final List<Interceptor> m98deprecated_interceptors() {
        return this.interceptors;
    }

    /* renamed from: -deprecated_networkInterceptors  reason: not valid java name */
    public final List<Interceptor> m99deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    /* renamed from: -deprecated_pingIntervalMillis  reason: not valid java name */
    public final int m100deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m101deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m102deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m103deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m104deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_readTimeoutMillis  reason: not valid java name */
    public final int m105deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* renamed from: -deprecated_retryOnConnectionFailure  reason: not valid java name */
    public final boolean m106deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m107deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m108deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    /* renamed from: -deprecated_writeTimeoutMillis  reason: not valid java name */
    public final int m109deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Call newCall(Request request) {
        m.f(request, "request");
        return new RealCall(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        m.f(request, "request");
        m.f(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, webSocketListener, new Random(), (long) this.pingIntervalMillis, (WebSocketExtensions) null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
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

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
