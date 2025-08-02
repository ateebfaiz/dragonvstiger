package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.k1;
import com.google.android.gms.common.internal.ImagesContract;
import com.reactnativecommunity.webview.RNCWebView;
import com.zing.zalo.zalosdk.common.Constant;
import va.b;
import va.c;
import va.f;
import va.i;

public class d extends WebViewClient {

    /* renamed from: e  reason: collision with root package name */
    private static String f11297e = "RNCWebViewClient";

    /* renamed from: a  reason: collision with root package name */
    protected boolean f11298a = false;

    /* renamed from: b  reason: collision with root package name */
    protected RNCWebView.c f11299b = null;

    /* renamed from: c  reason: collision with root package name */
    protected String f11300c = null;

    /* renamed from: d  reason: collision with root package name */
    protected a f11301d = null;

    /* access modifiers changed from: protected */
    public WritableMap a(WebView webView, String str) {
        boolean z10;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("target", (double) RNCWebViewWrapper.a(webView));
        createMap.putString(ImagesContract.URL, str);
        if (this.f11298a || webView.getProgress() == 100) {
            z10 = false;
        } else {
            z10 = true;
        }
        createMap.putBoolean("loading", z10);
        createMap.putString("title", webView.getTitle());
        createMap.putBoolean("canGoBack", webView.canGoBack());
        createMap.putBoolean("canGoForward", webView.canGoForward());
        return createMap;
    }

    /* access modifiers changed from: protected */
    public void b(WebView webView, String str) {
        int a10 = RNCWebViewWrapper.a(webView);
        k1.c((ReactContext) webView.getContext(), a10).c(new va.d(a10, a(webView, str)));
    }

    public void c(a aVar) {
        this.f11301d = aVar;
    }

    public void d(String str) {
        this.f11300c = str;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z10) {
        super.doUpdateVisitedHistory(webView, str, z10);
        ((RNCWebView) webView).g(webView, new f(RNCWebViewWrapper.a(webView), a(webView, str)));
    }

    public void e(RNCWebView.c cVar) {
        this.f11299b = cVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (CookieManager.getInstance().getCookie(str) != null) {
            CookieManager.getInstance().flush();
        }
        if (!this.f11298a) {
            ((RNCWebView) webView).a();
            b(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f11298a = false;
        ((RNCWebView) webView).b();
    }

    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        String str3 = this.f11300c;
        if (str3 == null || !str2.equals(str3) || i10 != -1 || !str.equals("net::ERR_FAILED")) {
            super.onReceivedError(webView, i10, str, str2);
            this.f11298a = true;
            b(webView, str2);
            WritableMap a10 = a(webView, str2);
            a10.putDouble(Constant.PARAM_OAUTH_CODE, (double) i10);
            a10.putString("description", str);
            int a11 = RNCWebViewWrapper.a(webView);
            k1.c((ReactContext) webView.getContext(), a11).c(new c(a11, a10));
            return;
        }
        d((String) null);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        a aVar = this.f11301d;
        if (aVar != null) {
            httpAuthHandler.proceed(aVar.f11294a, aVar.f11295b);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            WritableMap a10 = a(webView, webResourceRequest.getUrl().toString());
            a10.putInt("statusCode", webResourceResponse.getStatusCode());
            a10.putString("description", webResourceResponse.getReasonPhrase());
            int a11 = RNCWebViewWrapper.a(webView);
            k1.c((ReactContext) webView.getContext(), a11).c(new b(a11, a10));
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        String url = webView.getUrl();
        String url2 = sslError.getUrl();
        sslErrorHandler.cancel();
        if (!url.equalsIgnoreCase(url2)) {
            String str2 = f11297e;
            Log.w(str2, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
            return;
        }
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            str = "The certificate is not yet valid";
        } else if (primaryError == 1) {
            str = "The certificate has expired";
        } else if (primaryError == 2) {
            str = "Hostname mismatch";
        } else if (primaryError == 3) {
            str = "The certificate authority is not trusted";
        } else if (primaryError == 4) {
            str = "The date of the certificate is invalid";
        } else if (primaryError != 5) {
            str = "Unknown SSL Error";
        } else {
            str = "A generic error occurred";
        }
        onReceivedError(webView, primaryError, "SSL error: " + str, url2);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (renderProcessGoneDetail.didCrash()) {
            Log.e(f11297e, "The WebView rendering process crashed.");
        } else {
            Log.w(f11297e, "The WebView rendering process was killed by the system.");
        }
        if (webView == null) {
            return true;
        }
        WritableMap a10 = a(webView, webView.getUrl());
        a10.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
        int a11 = RNCWebViewWrapper.a(webView);
        k1.c((ReactContext) webView.getContext(), a11).c(new i(a11, a10));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r1.get() != com.reactnativecommunity.webview.i.d.a.f11324b) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        com.reactnativecommunity.webview.i.f11305g.c(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = r11
            com.reactnativecommunity.webview.RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebView) r0
            com.facebook.react.bridge.ReactApplicationContext r1 = r0.getReactApplicationContext()
            com.facebook.react.bridge.JavaScriptContextHolder r1 = r1.getJavaScriptContextHolder()
            long r1 = r1.get()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 != 0) goto L_0x0017
            goto L_0x0087
        L_0x0017:
            com.reactnativecommunity.webview.RNCWebViewMessagingModule r1 = r0.f11248h
            if (r1 == 0) goto L_0x0087
            com.reactnativecommunity.webview.i$d r1 = com.reactnativecommunity.webview.i.f11305g
            androidx.core.util.Pair r1 = r1.b()
            F r3 = r1.first
            java.lang.Double r3 = (java.lang.Double) r3
            double r4 = r3.doubleValue()
            S r1 = r1.second
            java.util.concurrent.atomic.AtomicReference r1 = (java.util.concurrent.atomic.AtomicReference) r1
            com.facebook.react.bridge.WritableMap r11 = r10.a(r11, r12)
            java.lang.String r12 = "lockIdentifier"
            r11.putDouble(r12, r4)
            r0.f(r11)
            r11 = 0
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0079 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0060 }
        L_0x003f:
            java.lang.Object r12 = r1.get()     // Catch:{ all -> 0x0060 }
            com.reactnativecommunity.webview.i$d$a r0 = com.reactnativecommunity.webview.i.d.a.UNDECIDED     // Catch:{ all -> 0x0060 }
            if (r12 != r0) goto L_0x0066
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0060 }
            long r6 = r6 - r4
            r8 = 250(0xfa, double:1.235E-321)
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x0062
            java.lang.String r12 = f11297e     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading."
            z2.a.G(r12, r0)     // Catch:{ all -> 0x0060 }
            com.reactnativecommunity.webview.i$d r12 = com.reactnativecommunity.webview.i.f11305g     // Catch:{ all -> 0x0060 }
            r12.c(r3)     // Catch:{ all -> 0x0060 }
            monitor-exit(r1)     // Catch:{ all -> 0x0060 }
            return r11
        L_0x0060:
            r12 = move-exception
            goto L_0x0077
        L_0x0062:
            r1.wait(r8)     // Catch:{ all -> 0x0060 }
            goto L_0x003f
        L_0x0066:
            monitor-exit(r1)     // Catch:{ all -> 0x0060 }
            java.lang.Object r12 = r1.get()
            com.reactnativecommunity.webview.i$d$a r0 = com.reactnativecommunity.webview.i.d.a.SHOULD_OVERRIDE
            if (r12 != r0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r2 = r11
        L_0x0071:
            com.reactnativecommunity.webview.i$d r11 = com.reactnativecommunity.webview.i.f11305g
            r11.c(r3)
            return r2
        L_0x0077:
            monitor-exit(r1)     // Catch:{ all -> 0x0060 }
            throw r12     // Catch:{ InterruptedException -> 0x0079 }
        L_0x0079:
            r12 = move-exception
            java.lang.String r0 = f11297e
            java.lang.String r1 = "shouldOverrideUrlLoading was interrupted while waiting for result."
            z2.a.k(r0, r1, r12)
            com.reactnativecommunity.webview.i$d r12 = com.reactnativecommunity.webview.i.f11305g
            r12.c(r3)
            return r11
        L_0x0087:
            java.lang.String r0 = f11297e
            java.lang.String r1 = "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load."
            z2.a.G(r0, r1)
            com.reactnativecommunity.webview.RNCWebView$c r0 = r10.f11299b
            r0.b(r2)
            int r0 = com.reactnativecommunity.webview.RNCWebViewWrapper.a(r11)
            android.content.Context r1 = r11.getContext()
            com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
            com.facebook.react.uimanager.events.e r1 = com.facebook.react.uimanager.k1.c(r1, r0)
            va.j r3 = new va.j
            com.facebook.react.bridge.WritableMap r11 = r10.a(r11, r12)
            r3.<init>(r0, r11)
            r1.c(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.d.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
