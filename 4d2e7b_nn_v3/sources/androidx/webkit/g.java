package androidx.webkit;

import androidx.webkit.WebViewCompat;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f16929a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebViewStartUpResult f16930b;

    public /* synthetic */ g(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback, WebViewStartUpResult webViewStartUpResult) {
        this.f16929a = webViewStartUpCallback;
        this.f16930b = webViewStartUpResult;
    }

    public final void run() {
        this.f16929a.onSuccess(this.f16930b);
    }
}
