package com.botion.captcha.views;

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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.botion.captcha.ab;
import com.botion.captcha.ac;
import com.botion.captcha.af;
import com.botion.captcha.t;
import com.botion.captcha.v;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class BOCWebView extends WebView {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18578b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public c f18579a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static final class b extends WebChromeClient {
        public final void onProgressChanged(WebView webView, int i10) {
            m.f(webView, "view");
            super.onProgressChanged(webView, i10);
            af afVar = af.f18475a;
            af.a("BOCWebView", "onProgressChanged: ".concat(String.valueOf(i10)));
        }

        public final void onReceivedTitle(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, "title");
            super.onReceivedTitle(webView, str);
            af afVar = af.f18475a;
            af.a("onReceivedTitle: ".concat(String.valueOf(str)));
        }
    }

    public static final class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        v f18580a;

        /* renamed from: b  reason: collision with root package name */
        private String f18581b;

        public c(String str, v vVar) {
            m.f(str, "loadUrl");
            m.f(vVar, "observable");
            this.f18581b = str;
            this.f18580a = vVar;
        }

        public final void onLoadResource(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            super.onLoadResource(webView, str);
            af afVar = af.f18475a;
            af.b("onLoadResource: ".concat(String.valueOf(str)));
        }

        public final void onPageFinished(WebView webView, String str) {
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            super.onPageFinished(webView, str);
            af afVar = af.f18475a;
            af.b("onPageFinished: ".concat(String.valueOf(str)));
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            af afVar = af.f18475a;
            af.b("onPageStarted: ".concat(String.valueOf(str)));
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            m.f(webView, "view");
            m.f(webResourceRequest, "request");
            m.f(webResourceError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            af afVar = af.f18475a;
            af.b("WebViewClient.onReceivedError: URL: " + webResourceRequest.getUrl() + ", Method: " + webResourceRequest.getMethod() + ", ErrorCode: " + webResourceError.getErrorCode() + ", Description: " + webResourceError.getDescription());
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            m.f(webView, "view");
            m.f(webResourceRequest, "request");
            m.f(webResourceResponse, "errorResponse");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            af afVar = af.f18475a;
            af.b("WebViewClient.onReceivedHttpError: URL: " + webResourceRequest.getUrl() + ", Code: " + webResourceResponse.getStatusCode() + ", Message: " + webResourceResponse.getReasonPhrase());
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            m.f(webView, "view");
            m.f(sslErrorHandler, "handler");
            m.f(sslError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            af afVar = af.f18475a;
            af.b("WebViewClient.onReceivedSslError: URL: " + sslError.getUrl() + ", ErrorCode: " + sslError.getPrimaryError() + ", Description: " + sslError);
            b0 b0Var = b0.f709a;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(sslError.getPrimaryError()))}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            String b10 = ac.b();
            t.a aVar = t.f18571a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ImagesContract.URL, sslError.getUrl());
            jSONObject.put("description", sslError.toString());
            Unit unit = Unit.f12577a;
            this.f18580a.a(ab.a.WEB_VIEW_SSL.getType() + format, b10, jSONObject);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Context context;
            af afVar = af.f18475a;
            StringBuilder sb2 = new StringBuilder("shouldOverrideUrlLoading(high): ");
            Uri uri = null;
            sb2.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
            af.b(sb2.toString());
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (webResourceRequest != null) {
                    uri = webResourceRequest.getUrl();
                }
                intent.setData(Uri.parse(String.valueOf(uri)));
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

        public final void onReceivedError(WebView webView, int i10, String str, String str2) {
            m.f(webView, "view");
            m.f(str, "description");
            m.f(str2, "failingUrl");
            super.onReceivedError(webView, i10, str, str2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BOCWebView(Context context) {
        super(context);
        m.c(context);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        af.b("BOCWebView.onDetachedFromWindow");
        super.onDetachedFromWindow();
        removeJavascriptInterface("JSInterface");
        removeAllViews();
        removeAllViewsInLayout();
        loadUrl("");
    }

    public final void onResume() {
        super.onResume();
        resumeTimers();
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        af afVar = af.f18475a;
        af.a("BOCWebView", "newWidth: " + i10 + ", newHeight: " + i11 + ", oldWidth: " + i12 + ", oldHeight: " + i13);
    }

    public final void setWebViewObservable(v vVar) {
        m.f(vVar, "observable");
        c cVar = this.f18579a;
        if (cVar != null) {
            m.f(vVar, "observable");
            cVar.f18580a = vVar;
        }
    }
}
