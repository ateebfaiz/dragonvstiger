package androidx.webkit;

import androidx.webkit.WebViewCompat;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewStartUpConfig f16931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f16932b;

    public /* synthetic */ h(WebViewStartUpConfig webViewStartUpConfig, WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.f16931a = webViewStartUpConfig;
        this.f16932b = webViewStartUpCallback;
    }

    public final void run() {
        WebViewCompat.lambda$startUpWebView$3(this.f16931a, this.f16932b);
    }
}
