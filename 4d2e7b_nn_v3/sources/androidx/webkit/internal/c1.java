package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;

public final /* synthetic */ class c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcessClient f16949a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f16950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcess f16951c;

    public /* synthetic */ c1(WebViewRenderProcessClient webViewRenderProcessClient, WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.f16949a = webViewRenderProcessClient;
        this.f16950b = webView;
        this.f16951c = webViewRenderProcess;
    }

    public final void run() {
        this.f16949a.onRenderProcessUnresponsive(this.f16950b, this.f16951c);
    }
}
