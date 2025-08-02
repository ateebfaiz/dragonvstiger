package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;

public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcessClient f16946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f16947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcess f16948c;

    public /* synthetic */ b1(WebViewRenderProcessClient webViewRenderProcessClient, WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.f16946a = webViewRenderProcessClient;
        this.f16947b = webView;
        this.f16948c = webViewRenderProcess;
    }

    public final void run() {
        this.f16946a.onRenderProcessResponsive(this.f16947b, this.f16948c);
    }
}
