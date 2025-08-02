package androidx.webkit;

import androidx.annotation.UiThread;

@UiThread
public abstract class JavaScriptReplyProxy {
    public abstract void postMessage(String str);

    public abstract void postMessage(byte[] bArr);
}
