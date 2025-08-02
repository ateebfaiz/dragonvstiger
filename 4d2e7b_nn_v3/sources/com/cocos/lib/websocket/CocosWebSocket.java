package com.cocos.lib.websocket;

import android.os.Build;
import android.util.Log;
import com.cocos.lib.GlobalObject;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.CipherSuite;
import org.cocos2dx.okhttp3.Dispatcher;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Protocol;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.WebSocket;
import org.cocos2dx.okhttp3.WebSocketListener;
import org.cocos2dx.okio.ByteString;

public class CocosWebSocket extends WebSocketListener {
    private static final String _TAG = "cocos-websocket";
    private static Dispatcher dispatcher = null;
    private OkHttpClient _client;
    private final String[] _header;
    private final boolean _perMessageDeflate;
    /* access modifiers changed from: private */
    public final boolean _tcpNoDelay;
    private final long _timeout;
    private WebSocket _webSocket;
    private final c _wsContext;

    class a implements HostnameVerifier {
        a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            Log.d(CocosWebSocket._TAG, "ca hostname: " + str);
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    class b extends a {
        b(SSLSocketFactory sSLSocketFactory) {
            super(sSLSocketFactory);
        }

        /* access modifiers changed from: protected */
        public SSLSocket a(SSLSocket sSLSocket) {
            sSLSocket.setTcpNoDelay(CocosWebSocket.this._tcpNoDelay);
            return sSLSocket;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        long f19403a;

        /* renamed from: b  reason: collision with root package name */
        long f19404b;

        private c() {
        }
    }

    static {
        NativeInit();
    }

    CocosWebSocket(long j10, long j11, String[] strArr, boolean z10, boolean z11, long j12) {
        c cVar = new c();
        this._wsContext = cVar;
        cVar.f19403a = j10;
        cVar.f19404b = j11;
        this._header = strArr;
        this._tcpNoDelay = z10;
        this._perMessageDeflate = z11;
        this._timeout = j12;
    }

    private static native void NativeInit();

    private void _close(int i10, String str) {
        this._webSocket.close(i10, str);
    }

    private void _connect(String str, String str2, String str3) {
        String str4;
        String str5;
        KeyStore keyStore;
        SecureRandom secureRandom;
        InputStream inputStream;
        Log.d(_TAG, "connect ws url: '" + str + "' ,protocols: '" + str2 + "' ,ca_: '" + str3 + "'");
        try {
            Request.Builder url = new Request.Builder().url(str).url(str.trim());
            URI create = URI.create(str);
            if (!str2.isEmpty()) {
                url.addHeader("Sec-WebSocket-Protocol", str2);
            }
            if (this._header != null) {
                int i10 = 0;
                while (true) {
                    String[] strArr = this._header;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    url.header(strArr[i10], strArr[i10 + 1]);
                    i10 += 2;
                }
            }
            String lowerCase = create.getScheme().toLowerCase();
            if (lowerCase.equals("wss") || lowerCase.equals("https")) {
                str4 = "https";
            } else {
                str4 = "http";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append("://");
            sb2.append(create.getHost());
            if (create.getPort() < 0) {
                str5 = "";
            } else {
                str5 = ":" + create.getPort();
            }
            sb2.append(str5);
            url.addHeader("Origin", sb2.toString());
            Request build = url.build();
            if (dispatcher == null) {
                dispatcher = new Dispatcher();
            }
            OkHttpClient.Builder protocols = new OkHttpClient.Builder().dispatcher(dispatcher).protocols(Collections.singletonList(Protocol.HTTP_1_1));
            long j10 = this._timeout;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectTimeout = protocols.readTimeout(j10, timeUnit).writeTimeout(this._timeout, timeUnit).connectTimeout(this._timeout, timeUnit);
            if (this._perMessageDeflate) {
                connectTimeout.addInterceptor(new CocosGzipRequestInterceptor());
            }
            if (!str.toLowerCase().startsWith("wss://") || str3.isEmpty()) {
                keyStore = null;
            } else {
                try {
                    if (str3.startsWith("assets/")) {
                        inputStream = GlobalObject.getContext().getResources().getAssets().open(str3);
                    } else {
                        inputStream = new FileInputStream(str3);
                    }
                    if (str3.toLowerCase().endsWith(".pem")) {
                        keyStore = d.b(inputStream);
                    } else {
                        keyStore = d.a(inputStream);
                    }
                    connectTimeout.hostnameVerifier(new a());
                } catch (Exception e10) {
                    e10.printStackTrace();
                    String message = e10.getMessage();
                    if (message == null) {
                        message = "unknown error";
                    }
                    String str6 = message;
                    synchronized (this._wsContext) {
                        c cVar = this._wsContext;
                        nativeOnError(str6, cVar.f19403a, cVar.f19404b);
                        return;
                    }
                }
            }
            if (str.toLowerCase().startsWith("wss://") || this._tcpNoDelay) {
                try {
                    X509TrustManager c10 = d.c(keyStore);
                    SSLContext instance = SSLContext.getInstance("TLS");
                    if (Build.VERSION.SDK_INT >= 26) {
                        secureRandom = SecureRandom.getInstanceStrong();
                    } else {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    }
                    instance.init((KeyManager[]) null, new TrustManager[]{c10}, secureRandom);
                    connectTimeout.sslSocketFactory(new b(instance.getSocketFactory()), c10);
                } catch (GeneralSecurityException e11) {
                    e11.printStackTrace();
                    String message2 = e11.getMessage();
                    if (message2 == null) {
                        message2 = "unknown error";
                    }
                    String str7 = message2;
                    synchronized (this._wsContext) {
                        c cVar2 = this._wsContext;
                        nativeOnError(str7, cVar2.f19403a, cVar2.f19404b);
                        return;
                    }
                }
            }
            OkHttpClient build2 = connectTimeout.build();
            this._client = build2;
            this._webSocket = build2.newWebSocket(build, this);
        } catch (IllegalArgumentException | NullPointerException unused) {
            synchronized (this._wsContext) {
                c cVar3 = this._wsContext;
                nativeOnError("invalid url", cVar3.f19403a, cVar3.f19404b);
            }
        }
    }

    private long _getBufferedAmountID() {
        return this._webSocket.queueSize();
    }

    private void _removeHandler() {
        synchronized (this._wsContext) {
            c cVar = this._wsContext;
            cVar.f19403a = 0;
            cVar.f19404b = 0;
        }
    }

    private void _send(byte[] bArr) {
        if (this._webSocket == null) {
            Log.e(_TAG, "WebSocket hasn't connected yet");
            return;
        }
        this._webSocket.send(ByteString.of(bArr));
    }

    private SSLSocketFactory defaultSslSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SecureRandom secureRandom;
        SSLContext instance = SSLContext.getInstance("TLS");
        if (Build.VERSION.SDK_INT >= 26) {
            secureRandom = SecureRandom.getInstanceStrong();
        } else {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        }
        instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, secureRandom);
        return instance.getSocketFactory();
    }

    private String[] javaNames(List<CipherSuite> list) {
        if (list == null) {
            return new String[0];
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = list.get(i10).javaName();
        }
        return strArr;
    }

    private native void nativeOnBinaryMessage(byte[] bArr, long j10, long j11);

    private native void nativeOnClosed(int i10, String str, long j10, long j11);

    private native void nativeOnError(String str, long j10, long j11);

    private native void nativeOnOpen(String str, String str2, long j10, long j11);

    private native void nativeOnStringMessage(String str, long j10, long j11);

    private void output(String str) {
        Log.w(_TAG, str);
    }

    public void onClosed(WebSocket webSocket, int i10, String str) {
        output("onClosed : " + i10 + " / " + str);
        synchronized (this._wsContext) {
            c cVar = this._wsContext;
            nativeOnClosed(i10, str, cVar.f19403a, cVar.f19404b);
        }
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
        output("Closing : " + i10 + " / " + str);
        if (webSocket != null) {
            webSocket.close(i10, str);
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        String str = "";
        if (th != null) {
            if (th.getMessage() == null) {
                str = th.getClass().getSimpleName();
            } else {
                str = th.getMessage();
            }
        }
        String str2 = str;
        output("onFailure Error : " + str2);
        synchronized (this._wsContext) {
            c cVar = this._wsContext;
            nativeOnError(str2, cVar.f19403a, cVar.f19404b);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
        synchronized (this._wsContext) {
            c cVar = this._wsContext;
            nativeOnStringMessage(str, cVar.f19403a, cVar.f19404b);
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        output("WebSocket onOpen _client: " + this._client);
        synchronized (this._wsContext) {
            String protocol = response.protocol().toString();
            String headers = response.headers().toString();
            c cVar = this._wsContext;
            nativeOnOpen(protocol, headers, cVar.f19403a, cVar.f19404b);
        }
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        synchronized (this._wsContext) {
            byte[] byteArray = byteString.toByteArray();
            c cVar = this._wsContext;
            nativeOnBinaryMessage(byteArray, cVar.f19403a, cVar.f19404b);
        }
    }

    private void _send(String str) {
        WebSocket webSocket = this._webSocket;
        if (webSocket == null) {
            Log.e(_TAG, "WebSocket hasn't connected yet");
        } else {
            webSocket.send(str);
        }
    }
}
