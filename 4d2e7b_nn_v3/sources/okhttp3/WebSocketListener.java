package okhttp3;

import kotlin.jvm.internal.m;
import okio.ByteString;

public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i10, String str) {
        m.f(webSocket, "webSocket");
        m.f(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
        m.f(webSocket, "webSocket");
        m.f(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        m.f(webSocket, "webSocket");
        m.f(th, "t");
    }

    public void onMessage(WebSocket webSocket, String str) {
        m.f(webSocket, "webSocket");
        m.f(str, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        m.f(webSocket, "webSocket");
        m.f(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        m.f(webSocket, "webSocket");
        m.f(byteString, "bytes");
    }
}
