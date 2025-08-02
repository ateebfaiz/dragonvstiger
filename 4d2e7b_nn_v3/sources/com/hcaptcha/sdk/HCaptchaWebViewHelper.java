package com.hcaptcha.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class HCaptchaWebViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9508a;

    /* renamed from: b  reason: collision with root package name */
    private final HCaptchaConfig f9509b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f9510c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final HCaptchaWebView f9511d;

    /* renamed from: e  reason: collision with root package name */
    private final u f9512e;

    public static class HCaptchaWebChromeClient extends WebChromeClient {
        private HCaptchaWebChromeClient() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            new StringBuilder("[webview] onConsoleMessage ").append(consoleMessage.message());
            return true;
        }

        public void onProgressChanged(WebView webView, int i10) {
        }
    }

    public class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f9513a;

        public b(Handler handler) {
            if (handler != null) {
                this.f9513a = handler;
                return;
            }
            throw new NullPointerException("handler is marked non-null but is null");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Uri uri) {
            HCaptchaWebViewHelper.this.f9511d.removeJavascriptInterface("JSInterface");
            HCaptchaWebViewHelper.this.f9511d.removeJavascriptInterface("JSDI");
            w b10 = HCaptchaWebViewHelper.this.f9510c;
            h hVar = h.INSECURE_HTTP_REQUEST_ERROR;
            b10.f(new i(hVar, "Insecure resource " + uri + " requested"));
        }

        private String c(String str) {
            return str.split("[?#]")[0] + "...";
        }

        public void onLoadResource(WebView webView, String str) {
            new StringBuilder("[webview] onLoadResource ").append(c(str));
        }

        public void onPageFinished(WebView webView, String str) {
            new StringBuilder("[webview] onPageFinished ").append(c(str));
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new StringBuilder("[webview] onPageStarted ").append(c(str));
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            if (!(url == null || url.getScheme() == null || !url.getScheme().equals("http"))) {
                this.f9513a.post(new t(this, url));
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public HCaptchaWebViewHelper(Handler handler, Context context, HCaptchaConfig hCaptchaConfig, l lVar, w wVar, HCaptchaWebView hCaptchaWebView) {
        if (handler == null) {
            throw new NullPointerException("handler is marked non-null but is null");
        } else if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        } else if (hCaptchaConfig == null) {
            throw new NullPointerException("config is marked non-null but is null");
        } else if (lVar == null) {
            throw new NullPointerException("internalConfig is marked non-null but is null");
        } else if (wVar == null) {
            throw new NullPointerException("captchaVerifier is marked non-null but is null");
        } else if (hCaptchaWebView != null) {
            this.f9508a = context;
            this.f9509b = hCaptchaConfig;
            this.f9510c = wVar;
            this.f9511d = hCaptchaWebView;
            this.f9512e = lVar.e();
            g(handler);
        } else {
            throw new NullPointerException("webView is marked non-null but is null");
        }
    }

    private void g(Handler handler) {
        if (handler != null) {
            this.f9511d.setId(x.f9566b);
            q qVar = new q(handler, this.f9509b, this.f9510c);
            d dVar = new d(this.f9508a);
            WebSettings settings = this.f9511d.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setCacheMode(-1);
            settings.setGeolocationEnabled(false);
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            this.f9511d.setWebViewClient(new b(handler));
            if (r.f9560a) {
                this.f9511d.setWebChromeClient(new HCaptchaWebChromeClient());
            }
            this.f9511d.setBackgroundColor(0);
            if (this.f9509b.getDisableHardwareAcceleration().booleanValue()) {
                this.f9511d.setLayerType(1, (Paint) null);
            }
            this.f9511d.addJavascriptInterface(qVar, "JSInterface");
            this.f9511d.addJavascriptInterface(dVar, "JSDI");
            this.f9511d.loadDataWithBaseURL(this.f9509b.getHost(), this.f9512e.r(), "text/html", "UTF-8", (String) null);
            this.f9511d.isHardwareAccelerated();
            return;
        }
        throw new NullPointerException("handler is marked non-null but is null");
    }

    public HCaptchaConfig c() {
        return this.f9509b;
    }

    public HCaptchaWebView d() {
        return this.f9511d;
    }

    public void e() {
        if (!this.f9511d.a()) {
            this.f9511d.loadUrl("javascript:reset();");
        }
    }

    public void f() {
        this.f9511d.loadUrl("javascript:resetAndExecute();");
    }

    public boolean h(i iVar) {
        return this.f9509b.getRetryPredicate().g(this.f9509b, iVar);
    }
}
