package com.geetest.captcha.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.captcha.d0;
import com.geetest.captcha.e0;
import com.geetest.captcha.h0;
import com.geetest.captcha.v;
import com.geetest.captcha.w;
import com.geetest.captcha.y;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class GTC4WebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public b f5875a;

    public static final class a extends WebChromeClient {
        public void onProgressChanged(WebView webView, int i10) {
            m.f(webView, "view");
            super.onProgressChanged(webView, i10);
            h0 h0Var = h0.f5812d;
            h0Var.a("GTC4WebView", "onProgressChanged: " + i10);
        }

        public void onReceivedTitle(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, "title");
            super.onReceivedTitle(webView, str);
            h0 h0Var = h0.f5812d;
            h0Var.a("onReceivedTitle: " + str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GTC4WebView(Context context) {
        super(context);
        m.c(context);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a(y yVar, v vVar, String str) {
        m.f(yVar, "observable");
        m.f(vVar, "dataBean");
        m.f(str, "loadUrl");
        WebSettings settings = getSettings();
        m.e(settings, "settings");
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(2);
        settings.setSupportZoom(true);
        settings.setTextZoom(100);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        setOverScrollMode(2);
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebChromeClient(new a());
        b bVar = new b(str, yVar);
        this.f5875a = bVar;
        setWebViewClient(bVar);
        setBackgroundColor(vVar.f5873j);
        if (vVar.f5866c) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        super.onResume();
        resumeTimers();
    }

    public void onDetachedFromWindow() {
        h0.f5812d.c("GTC4WebView.onDetachedFromWindow");
        super.onDetachedFromWindow();
        removeJavascriptInterface("JSInterface");
        removeAllViews();
        removeAllViewsInLayout();
        loadUrl("");
    }

    public void onResume() {
        super.onResume();
        resumeTimers();
    }

    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        h0 h0Var = h0.f5812d;
        h0Var.a("GTC4WebView", "newWidth: " + i10 + ", newHeight: " + i11 + ", oldWidth: " + i12 + ", oldHeight: " + i13);
    }

    public final void setWebViewObservable(y yVar) {
        m.f(yVar, "observable");
        b bVar = this.f5875a;
        if (bVar != null) {
            m.f(yVar, "observable");
            bVar.f5876a = yVar;
        }
    }

    public static final class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public y f5876a;

        public b(String str, y yVar) {
            m.f(str, "loadUrl");
            m.f(yVar, "observable");
            this.f5876a = yVar;
        }

        public void onLoadResource(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            super.onLoadResource(webView, str);
            h0 h0Var = h0.f5812d;
            h0Var.c("onLoadResource: " + str);
        }

        public void onPageFinished(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            super.onPageFinished(webView, str);
            h0 h0Var = h0.f5812d;
            h0Var.c("onPageFinished: " + str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            h0 h0Var = h0.f5812d;
            h0Var.c("onPageStarted: " + str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            m.f(webView, "view");
            m.f(webResourceRequest, "request");
            m.f(webResourceError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            h0 h0Var = h0.f5812d;
            h0Var.c("WebViewClient.onReceivedError: URL: " + webResourceRequest.getUrl() + ", " + "Method: " + webResourceRequest.getMethod() + ", ErrorCode: " + webResourceError.getErrorCode() + ", Description: " + webResourceError.getDescription());
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            m.f(webView, "view");
            m.f(webResourceRequest, "request");
            m.f(webResourceResponse, "errorResponse");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            h0 h0Var = h0.f5812d;
            h0Var.c("WebViewClient.onReceivedHttpError: URL: " + webResourceRequest.getUrl() + ", " + "Code: " + webResourceResponse.getStatusCode() + ", Message: " + webResourceResponse.getReasonPhrase());
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            m.f(webView, "view");
            m.f(sslErrorHandler, "handler");
            m.f(sslError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            h0.f5812d.c("WebViewClient.onReceivedSslError: URL: " + sslError.getUrl() + ", ErrorCode: " + sslError.getPrimaryError() + ", Description: " + sslError);
            b0 b0Var = b0.f709a;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(sslError.getPrimaryError()))}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            String str = e0.f5790b;
            w.a aVar = w.f5877d;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ImagesContract.URL, sslError.getUrl());
            jSONObject.put("description", sslError.toString());
            Unit unit = Unit.f12577a;
            this.f5876a.a(d0.WEB_VIEW_SSL.getType() + format, str, jSONObject);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri uri;
            Context context;
            h0 h0Var = h0.f5812d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("shouldOverrideUrlLoading(high): ");
            Uri uri2 = null;
            if (webResourceRequest != null) {
                uri = webResourceRequest.getUrl();
            } else {
                uri = null;
            }
            sb2.append(uri);
            h0Var.c(sb2.toString());
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (webResourceRequest != null) {
                    uri2 = webResourceRequest.getUrl();
                }
                intent.setData(Uri.parse(String.valueOf(uri2)));
                if (webView == null || (context = webView.getContext()) == null) {
                    return true;
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return true;
            }
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            m.f(webView, "view");
            m.f(str, "description");
            m.f(str2, "failingUrl");
            super.onReceivedError(webView, i10, str, str2);
        }
    }
}
