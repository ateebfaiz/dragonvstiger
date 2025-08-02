package org.cocos2dx.okhttp3;

import org.cocos2dx.okio.ByteString;

public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i10, String str) {
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onOpen(WebSocket webSocket, Response response) {
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }
}
