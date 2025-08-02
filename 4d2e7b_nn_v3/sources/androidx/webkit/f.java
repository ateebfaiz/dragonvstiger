package androidx.webkit;

import androidx.webkit.WebViewCompat;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewCompat.WebViewStartUpCallback f16928a;

    public /* synthetic */ f(WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.f16928a = webViewStartUpCallback;
    }

    public final void run() {
        this.f16928a.onSuccess(new WebViewCompat.b());
    }
}
