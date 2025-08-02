package com.facebook.react.modules.websocket;

import androidx.annotation.Nullable;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.network.c;
import com.facebook.react.modules.network.e;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@s6.a(name = "WebSocketModule")
public final class WebSocketModule extends NativeWebSocketModuleSpec {
    @Nullable
    private static c customClientBuilder;
    /* access modifiers changed from: private */
    public final Map<Integer, b> mContentHandlers = new ConcurrentHashMap();
    private e mCookieHandler;
    /* access modifiers changed from: private */
    public final Map<Integer, WebSocket> mWebSocketConnections = new ConcurrentHashMap();

    public interface b {
        void a(ByteString byteString, WritableMap writableMap);

        void b(String str, WritableMap writableMap);
    }

    public WebSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieHandler = new e(reactApplicationContext);
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
    }

    private String getCookie(String str) {
        try {
            List list = (List) this.mCookieHandler.get(new URI(getDefaultOrigin(str)), new HashMap()).get("Cookie");
            if (list == null) {
                return null;
            }
            if (list.isEmpty()) {
                return null;
            }
            return (String) list.get(0);
        } catch (IOException | URISyntaxException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053 A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093 A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDefaultOrigin(java.lang.String r12) {
        /*
            r0 = 3
            r1 = 0
            r2 = 2
            r3 = 1
            java.lang.String r4 = ""
            java.net.URI r5 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00bf }
            r5.<init>(r12)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r6 = r5.getScheme()     // Catch:{ URISyntaxException -> 0x00bf }
            int r7 = r6.hashCode()     // Catch:{ URISyntaxException -> 0x00bf }
            r8 = 3804(0xedc, float:5.33E-42)
            java.lang.String r9 = "http"
            java.lang.String r10 = "https"
            r11 = -1
            if (r7 == r8) goto L_0x0046
            r8 = 118039(0x1cd17, float:1.65408E-40)
            if (r7 == r8) goto L_0x003c
            r8 = 3213448(0x310888, float:4.503E-39)
            if (r7 == r8) goto L_0x0034
            r8 = 99617003(0x5f008eb, float:2.2572767E-35)
            if (r7 == r8) goto L_0x002c
            goto L_0x0050
        L_0x002c:
            boolean r6 = r6.equals(r10)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r6 == 0) goto L_0x0050
            r6 = r0
            goto L_0x0051
        L_0x0034:
            boolean r6 = r6.equals(r9)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r6 == 0) goto L_0x0050
            r6 = r2
            goto L_0x0051
        L_0x003c:
            java.lang.String r7 = "wss"
            boolean r6 = r6.equals(r7)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r6 == 0) goto L_0x0050
            r6 = r1
            goto L_0x0051
        L_0x0046:
            java.lang.String r7 = "ws"
            boolean r6 = r6.equals(r7)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r6 == 0) goto L_0x0050
            r6 = r3
            goto L_0x0051
        L_0x0050:
            r6 = r11
        L_0x0051:
            if (r6 == 0) goto L_0x007e
            if (r6 == r3) goto L_0x006e
            if (r6 == r2) goto L_0x005a
            if (r6 == r0) goto L_0x005a
            goto L_0x008d
        L_0x005a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r6.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r4)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r4 = r5.getScheme()     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r4)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r4 = r6.toString()     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x008d
        L_0x006e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r6.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r4)     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r9)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r4 = r6.toString()     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x008d
        L_0x007e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r6.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r4)     // Catch:{ URISyntaxException -> 0x00bf }
            r6.append(r10)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r4 = r6.toString()     // Catch:{ URISyntaxException -> 0x00bf }
        L_0x008d:
            int r6 = r5.getPort()     // Catch:{ URISyntaxException -> 0x00bf }
            if (r6 == r11) goto L_0x00ae
            java.lang.String r6 = "%s://%s:%s"
            java.lang.String r7 = r5.getHost()     // Catch:{ URISyntaxException -> 0x00bf }
            int r5 = r5.getPort()     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ URISyntaxException -> 0x00bf }
            r0[r1] = r4     // Catch:{ URISyntaxException -> 0x00bf }
            r0[r3] = r7     // Catch:{ URISyntaxException -> 0x00bf }
            r0[r2] = r5     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r12 = java.lang.String.format(r6, r0)     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x00be
        L_0x00ae:
            java.lang.String r0 = "%s://%s"
            java.lang.String r5 = r5.getHost()     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ URISyntaxException -> 0x00bf }
            r2[r1] = r4     // Catch:{ URISyntaxException -> 0x00bf }
            r2[r3] = r5     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r12 = java.lang.String.format(r0, r2)     // Catch:{ URISyntaxException -> 0x00bf }
        L_0x00be:
            return r12
        L_0x00bf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to set "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = " as default origin header"
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.getDefaultOrigin(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void notifyWebSocketFailed(int i10, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", i10);
        createMap.putString("message", str);
        sendEvent("websocketFailed", createMap);
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(str, writableMap);
        }
    }

    public static void setCustomClientBuilder(c cVar) {
    }

    public void addListener(String str) {
    }

    public void close(double d10, String str, double d11) {
        int i10 = (int) d11;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i10));
        if (webSocket != null) {
            try {
                webSocket.close((int) d10, str);
                this.mWebSocketConnections.remove(Integer.valueOf(i10));
                this.mContentHandlers.remove(Integer.valueOf(i10));
            } catch (Exception e10) {
                z2.a.k("ReactNative", "Could not close WebSocket connection for id " + i10, e10);
            }
        }
    }

    public void connect(String str, @Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap, double d10) {
        boolean z10;
        int i10 = (int) d10;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder readTimeout = builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(0, TimeUnit.MINUTES);
        applyCustomBuilder(readTimeout);
        OkHttpClient build = readTimeout.build();
        Request.Builder url = new Request.Builder().tag(Integer.valueOf(i10)).url(str);
        String cookie = getCookie(str);
        if (cookie != null) {
            url.addHeader("Cookie", cookie);
        }
        if (readableMap == null || !readableMap.hasKey("headers") || !readableMap.getType("headers").equals(ReadableType.Map)) {
            z10 = false;
        } else {
            ReadableMap map = readableMap.getMap("headers");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            z10 = false;
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (ReadableType.String.equals(map.getType(nextKey))) {
                    if (nextKey.equalsIgnoreCase("origin")) {
                        z10 = true;
                    }
                    url.addHeader(nextKey, map.getString(nextKey));
                } else {
                    z2.a.G("ReactNative", "Ignoring: requested " + nextKey + ", value not a string");
                }
            }
        }
        if (!z10) {
            url.addHeader("origin", getDefaultOrigin(str));
        }
        if (readableArray != null && readableArray.size() > 0) {
            StringBuilder sb2 = new StringBuilder("");
            for (int i11 = 0; i11 < readableArray.size(); i11++) {
                String trim = readableArray.getString(i11).trim();
                if (!trim.isEmpty() && !trim.contains(",")) {
                    sb2.append(trim);
                    sb2.append(",");
                }
            }
            if (sb2.length() > 0) {
                sb2.replace(sb2.length() - 1, sb2.length(), "");
                url.addHeader("Sec-WebSocket-Protocol", sb2.toString());
            }
        }
        build.newWebSocket(url.build(), new a(i10));
        build.dispatcher().executorService().shutdown();
    }

    public void invalidate() {
        for (WebSocket close : this.mWebSocketConnections.values()) {
            close.close(1001, (String) null);
        }
        this.mWebSocketConnections.clear();
        this.mContentHandlers.clear();
    }

    public void ping(double d10) {
        int i10 = (int) d10;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i10));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i10);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i10);
            createMap2.putInt(Constant.PARAM_OAUTH_CODE, 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i10));
            this.mContentHandlers.remove(Integer.valueOf(i10));
            return;
        }
        try {
            webSocket.send(ByteString.EMPTY);
        } catch (Exception e10) {
            notifyWebSocketFailed(i10, e10.getMessage());
        }
    }

    public void removeListeners(double d10) {
    }

    public void send(String str, double d10) {
        int i10 = (int) d10;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i10));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i10);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i10);
            createMap2.putInt(Constant.PARAM_OAUTH_CODE, 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i10));
            this.mContentHandlers.remove(Integer.valueOf(i10));
            return;
        }
        try {
            webSocket.send(str);
        } catch (Exception e10) {
            notifyWebSocketFailed(i10, e10.getMessage());
        }
    }

    public void sendBinary(String str, double d10) {
        int i10 = (int) d10;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i10));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i10);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i10);
            createMap2.putInt(Constant.PARAM_OAUTH_CODE, 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i10));
            this.mContentHandlers.remove(Integer.valueOf(i10));
            return;
        }
        try {
            webSocket.send(ByteString.decodeBase64(str));
        } catch (Exception e10) {
            notifyWebSocketFailed(i10, e10.getMessage());
        }
    }

    public void setContentHandler(int i10, b bVar) {
        if (bVar != null) {
            this.mContentHandlers.put(Integer.valueOf(i10), bVar);
        } else {
            this.mContentHandlers.remove(Integer.valueOf(i10));
        }
    }

    class a extends WebSocketListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3359a;

        a(int i10) {
            this.f3359a = i10;
        }

        public void onClosed(WebSocket webSocket, int i10, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.f3359a);
            createMap.putInt(Constant.PARAM_OAUTH_CODE, i10);
            createMap.putString("reason", str);
            WebSocketModule.this.sendEvent("websocketClosed", createMap);
        }

        public void onClosing(WebSocket webSocket, int i10, String str) {
            webSocket.close(i10, str);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            WebSocketModule.this.notifyWebSocketFailed(this.f3359a, th.getMessage());
        }

        public void onMessage(WebSocket webSocket, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.f3359a);
            createMap.putString("type", "text");
            b bVar = (b) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.f3359a));
            if (bVar != null) {
                bVar.b(str, createMap);
            } else {
                createMap.putString("data", str);
            }
            WebSocketModule.this.sendEvent("websocketMessage", createMap);
        }

        public void onOpen(WebSocket webSocket, Response response) {
            WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(this.f3359a), webSocket);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.f3359a);
            createMap.putString("protocol", response.header("Sec-WebSocket-Protocol", ""));
            WebSocketModule.this.sendEvent("websocketOpen", createMap);
        }

        public void onMessage(WebSocket webSocket, ByteString byteString) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.f3359a);
            createMap.putString("type", "binary");
            b bVar = (b) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.f3359a));
            if (bVar != null) {
                bVar.a(byteString, createMap);
            } else {
                createMap.putString("data", byteString.base64());
            }
            WebSocketModule.this.sendEvent("websocketMessage", createMap);
        }
    }

    public void sendBinary(ByteString byteString, int i10) {
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i10));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i10);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i10);
            createMap2.putInt(Constant.PARAM_OAUTH_CODE, 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i10));
            this.mContentHandlers.remove(Integer.valueOf(i10));
            return;
        }
        try {
            webSocket.send(byteString);
        } catch (Exception e10) {
            notifyWebSocketFailed(i10, e10.getMessage());
        }
    }
}
