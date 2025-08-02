package org.cocos2dx.javascript;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.m;

public final class CaptchaDialog$initView$3$onCreateWindow$1 extends WebViewClient {
    final /* synthetic */ CaptchaDialog this$0;

    CaptchaDialog$initView$3$onCreateWindow$1(CaptchaDialog captchaDialog) {
        this.this$0 = captchaDialog;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        m.f(webView, "view");
        m.f(webResourceRequest, "request");
        try {
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webResourceRequest.getUrl().toString())));
            return true;
        } catch (Exception unused) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
