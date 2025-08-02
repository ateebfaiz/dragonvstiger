package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.scroll.e;
import com.facebook.react.views.scroll.f;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import va.g;

public class RNCWebView extends WebView implements LifecycleEventListener {
    protected boolean C = false;
    protected boolean N0 = false;
    protected c O0 = new c();
    protected List P0;
    WebChromeClient Q0;

    /* renamed from: a  reason: collision with root package name */
    protected String f11241a;

    /* renamed from: b  reason: collision with root package name */
    protected String f11242b;

    /* renamed from: c  reason: collision with root package name */
    protected d f11243c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f11244d = true;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f11245e = true;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f11246f = false;

    /* renamed from: g  reason: collision with root package name */
    protected String f11247g;

    /* renamed from: h  reason: collision with root package name */
    protected RNCWebViewMessagingModule f11248h = ((RNCWebViewMessagingModule) ((e1) getContext()).b().getJSModule(RNCWebViewMessagingModule.class));

    /* renamed from: i  reason: collision with root package name */
    protected d f11249i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f11250j = false;

    /* renamed from: w  reason: collision with root package name */
    private u7.b f11251w;

    class a extends ActionMode.Callback2 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActionMode.Callback f11252a;

        /* renamed from: com.reactnativecommunity.webview.RNCWebView$a$a  reason: collision with other inner class name */
        class C0129a implements ValueCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MenuItem f11254a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ WritableMap f11255b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ActionMode f11256c;

            C0129a(MenuItem menuItem, WritableMap writableMap, ActionMode actionMode) {
                this.f11254a = menuItem;
                this.f11255b = writableMap;
                this.f11256c = actionMode;
            }

            /* renamed from: a */
            public void onReceiveValue(String str) {
                String str2;
                Map map = (Map) RNCWebView.this.P0.get(this.f11254a.getItemId());
                this.f11255b.putString(Constants.ScionAnalytics.PARAM_LABEL, (String) map.get(Constants.ScionAnalytics.PARAM_LABEL));
                this.f11255b.putString("key", (String) map.get("key"));
                try {
                    str2 = new JSONObject(str).getString("selection");
                } catch (JSONException unused) {
                    str2 = "";
                }
                this.f11255b.putString("selectedText", str2);
                RNCWebView rNCWebView = RNCWebView.this;
                rNCWebView.g(rNCWebView, new va.a(RNCWebViewWrapper.a(RNCWebView.this), this.f11255b));
                this.f11256c.finish();
            }
        }

        a(ActionMode.Callback callback) {
            this.f11252a = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            RNCWebView.this.evaluateJavascript("(function(){return {selection: window.getSelection().toString()} })()", new C0129a(menuItem, Arguments.createMap(), actionMode));
            return true;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            for (int i10 = 0; i10 < RNCWebView.this.P0.size(); i10++) {
                menu.add(0, i10, i10, (CharSequence) ((Map) RNCWebView.this.P0.get(i10)).get(Constants.ScionAnalytics.PARAM_LABEL));
            }
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
            ActionMode.Callback callback = this.f11252a;
            if (callback instanceof ActionMode.Callback2) {
                ((ActionMode.Callback2) callback).onGetContentRect(actionMode, view, rect);
            } else {
                super.onGetContentRect(actionMode, view, rect);
            }
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f11258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11259b;

        b(WebView webView, String str) {
            this.f11258a = webView;
            this.f11259b = str;
        }

        public void run() {
            d dVar = RNCWebView.this.f11249i;
            if (dVar != null) {
                WebView webView = this.f11258a;
                WritableMap a10 = dVar.a(webView, webView.getUrl());
                a10.putString("data", this.f11259b);
                RNCWebView rNCWebView = RNCWebView.this;
                if (rNCWebView.f11248h != null) {
                    rNCWebView.e(a10);
                } else {
                    rNCWebView.g(this.f11258a, new g(RNCWebViewWrapper.a(this.f11258a), a10));
                }
            }
        }
    }

    protected static class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11261a = false;

        protected c() {
        }

        public boolean a() {
            return this.f11261a;
        }

        public void b(boolean z10) {
            this.f11261a = z10;
        }
    }

    protected class d {

        /* renamed from: a  reason: collision with root package name */
        private String f11262a = "RNCWebViewBridge";

        /* renamed from: b  reason: collision with root package name */
        RNCWebView f11263b;

        /* renamed from: c  reason: collision with root package name */
        String f11264c;

        d(RNCWebView rNCWebView) {
            this.f11263b = rNCWebView;
        }

        public void a(String str) {
            this.f11264c = str;
        }

        @JavascriptInterface
        public String injectedObjectJson() {
            return this.f11264c;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (this.f11263b.getMessagingEnabled()) {
                this.f11263b.i(str);
            } else {
                z2.a.G(this.f11262a, "ReactNativeWebView.postMessage method was called but messaging is disabled. Pass an onMessage handler to the WebView.");
            }
        }
    }

    public RNCWebView(e1 e1Var) {
        super(e1Var);
    }

    public void a() {
        String str;
        if (getSettings().getJavaScriptEnabled() && (str = this.f11241a) != null && !TextUtils.isEmpty(str)) {
            h("(function() {\n" + this.f11241a + ";\n})();");
        }
    }

    public void b() {
        String str;
        if (getSettings().getJavaScriptEnabled() && (str = this.f11242b) != null && !TextUtils.isEmpty(str)) {
            h("(function() {\n" + this.f11242b + ";\n})();");
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        setWebViewClient((WebViewClient) null);
        destroy();
    }

    /* access modifiers changed from: protected */
    public d d(RNCWebView rNCWebView) {
        if (this.f11243c == null) {
            d dVar = new d(rNCWebView);
            this.f11243c = dVar;
            addJavascriptInterface(dVar, "ReactNativeWebView");
        }
        return this.f11243c;
    }

    public void destroy() {
        WebChromeClient webChromeClient = this.Q0;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        }
        super.destroy();
    }

    /* access modifiers changed from: protected */
    public void e(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.f11247g);
        this.f11248h.onMessage(writableNativeMap);
    }

    /* access modifiers changed from: protected */
    public boolean f(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.f11247g);
        this.f11248h.onShouldStartLoadWithRequest(writableNativeMap);
        return true;
    }

    /* access modifiers changed from: protected */
    public void g(WebView webView, com.facebook.react.uimanager.events.d dVar) {
        k1.c(getThemedReactContext(), RNCWebViewWrapper.a(webView)).c(dVar);
    }

    public boolean getMessagingEnabled() {
        return this.f11246f;
    }

    @Nullable
    public d getRNCWebViewClient() {
        return this.f11249i;
    }

    public ReactApplicationContext getReactApplicationContext() {
        return getThemedReactContext().b();
    }

    public e1 getThemedReactContext() {
        return (e1) getContext();
    }

    public WebChromeClient getWebChromeClient() {
        return this.Q0;
    }

    /* access modifiers changed from: protected */
    public void h(String str) {
        evaluateJavascript(str, (ValueCallback) null);
    }

    public void i(String str) {
        getThemedReactContext();
        if (this.f11249i != null) {
            post(new b(this, str));
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("data", str);
        if (this.f11248h != null) {
            e(createMap);
        } else {
            g(this, new g(RNCWebViewWrapper.a(this), createMap));
        }
    }

    public void onHostDestroy() {
        c();
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        if (this.C) {
            if (this.f11251w == null) {
                this.f11251w = new u7.b();
            }
            if (this.f11251w.c(i10, i11)) {
                g(this, e.e(RNCWebViewWrapper.a(this), f.SCROLL, (float) i10, (float) i11, this.f11251w.a(), this.f11251w.b(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f11250j) {
            g(this, new com.facebook.react.uimanager.events.c(RNCWebViewWrapper.a(this), i10, i11));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.N0) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBasicAuthCredential(a aVar) {
        this.f11249i.c(aVar);
    }

    public void setHasScrollEvent(boolean z10) {
        this.C = z10;
    }

    public void setIgnoreErrFailedForThisURL(String str) {
        this.f11249i.d(str);
    }

    public void setInjectedJavaScriptObject(String str) {
        if (getSettings().getJavaScriptEnabled()) {
            d(this).a(str);
        }
    }

    public void setMenuCustomItems(List<Map<String, String>> list) {
        this.P0 = list;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void setMessagingEnabled(boolean z10) {
        if (this.f11246f != z10) {
            this.f11246f = z10;
            if (z10) {
                d(this);
            }
        }
    }

    public void setNestedScrollEnabled(boolean z10) {
        this.N0 = z10;
    }

    public void setSendContentSizeChangeEvents(boolean z10) {
        this.f11250j = z10;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.Q0 = webChromeClient;
        super.setWebChromeClient(webChromeClient);
        if (webChromeClient instanceof RNCWebChromeClient) {
            ((RNCWebChromeClient) webChromeClient).setProgressChangedFilter(this.O0);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof d) {
            d dVar = (d) webViewClient;
            this.f11249i = dVar;
            dVar.e(this.O0);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback, int i10) {
        if (this.P0 == null) {
            return super.startActionMode(callback, i10);
        }
        return super.startActionMode(new a(callback), i10);
    }
}
