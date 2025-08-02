package org.cocos2dx.javascript;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.jvm.internal.m;

public final class CaptchaDialog$initView$3 extends WebChromeClient {
    final /* synthetic */ CaptchaDialog this$0;

    CaptchaDialog$initView$3(CaptchaDialog captchaDialog) {
        this.this$0 = captchaDialog;
    }

    public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
        Context context;
        Object obj = null;
        if (webView != null) {
            context = webView.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return true;
        }
        WebView webView2 = new WebView(context);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setDomStorageEnabled(true);
        webView2.setWebViewClient(new CaptchaDialog$initView$3$onCreateWindow$1(this.this$0));
        if (message != null) {
            obj = message.obj;
        }
        m.d(obj, "null cannot be cast to non-null type android.webkit.WebView.WebViewTransport");
        ((WebView.WebViewTransport) obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }
}
