package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.e1;
import com.google.firebase.analytics.FirebaseAnalytics;
import e6.f;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import kotlin.text.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class RNCWebViewManagerImpl {
    public static final a C = new a((DefaultConstructorMarker) null);
    private final int A;
    private final int B;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11266a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11267b;

    /* renamed from: c  reason: collision with root package name */
    private e f11268c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11269d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11270e;

    /* renamed from: f  reason: collision with root package name */
    private String f11271f;

    /* renamed from: g  reason: collision with root package name */
    private String f11272g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11273h;

    /* renamed from: i  reason: collision with root package name */
    private ReadableMap f11274i;

    /* renamed from: j  reason: collision with root package name */
    private String f11275j;

    /* renamed from: k  reason: collision with root package name */
    private String f11276k;

    /* renamed from: l  reason: collision with root package name */
    private final String f11277l;

    /* renamed from: m  reason: collision with root package name */
    private final String f11278m;

    /* renamed from: n  reason: collision with root package name */
    private final String f11279n;

    /* renamed from: o  reason: collision with root package name */
    private final String f11280o;

    /* renamed from: p  reason: collision with root package name */
    private final String f11281p;

    /* renamed from: q  reason: collision with root package name */
    private final String f11282q;

    /* renamed from: r  reason: collision with root package name */
    private final int f11283r;

    /* renamed from: s  reason: collision with root package name */
    private final int f11284s;

    /* renamed from: t  reason: collision with root package name */
    private final int f11285t;

    /* renamed from: u  reason: collision with root package name */
    private final int f11286u;

    /* renamed from: v  reason: collision with root package name */
    private final int f11287v;

    /* renamed from: w  reason: collision with root package name */
    private final int f11288w;

    /* renamed from: x  reason: collision with root package name */
    private final int f11289x;

    /* renamed from: y  reason: collision with root package name */
    private final int f11290y;

    /* renamed from: z  reason: collision with root package name */
    private final int f11291z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RNCWebViewManagerImpl() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final void f(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl, String str, String str2, String str3, String str4, long j10) {
        m.f(rNCWebView, "$webView");
        m.f(rNCWebViewManagerImpl, "this$0");
        rNCWebView.setIgnoreErrFailedForThisURL(str);
        RNCWebViewModule rNCWebViewModule = (RNCWebViewModule) rNCWebView.getReactApplicationContext().getNativeModule(RNCWebViewModule.class);
        if (rNCWebViewModule != null) {
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                String a10 = l.a(str, str3, str4);
                m.c(a10);
                String d10 = h.a().d(a10, "_");
                String str5 = "Downloading " + d10;
                try {
                    URL url = new URL(str);
                    request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
                } catch (MalformedURLException e10) {
                    Log.w(rNCWebViewManagerImpl.f11267b, "Error getting cookie for DownloadManager", e10);
                }
                request.addRequestHeader("User-Agent", str2);
                request.setTitle(d10);
                request.setDescription(str5);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, d10);
                rNCWebViewModule.setDownloadRequest(request);
                if (rNCWebViewModule.grantFileDownloaderPermissions(rNCWebViewManagerImpl.h(), rNCWebViewManagerImpl.i())) {
                    rNCWebViewModule.downloadFile(rNCWebViewManagerImpl.h());
                }
            } catch (IllegalArgumentException e11) {
                Log.w(rNCWebViewManagerImpl.f11267b, "Unsupported URI, aborting download", e11);
            }
        }
    }

    private final void g0(RNCWebViewWrapper rNCWebViewWrapper) {
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (this.f11275j != null) {
            webView.getSettings().setUserAgentString(this.f11275j);
        } else if (this.f11276k != null) {
            webView.getSettings().setUserAgentString(this.f11276k);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    private final String h() {
        String str = this.f11271f;
        if (str == null) {
            return this.f11281p;
        }
        return str;
    }

    private final String i() {
        String str = this.f11272g;
        if (str == null) {
            return this.f11282q;
        }
        return str;
    }

    private final void i0(RNCWebView rNCWebView) {
        Activity currentActivity = rNCWebView.getThemedReactContext().getCurrentActivity();
        if (!this.f11269d || currentActivity == null) {
            RNCWebChromeClient rNCWebChromeClient = (RNCWebChromeClient) rNCWebView.getWebChromeClient();
            if (rNCWebChromeClient != null) {
                rNCWebChromeClient.onHideCustomView();
            }
            RNCWebViewManagerImpl$setupWebChromeClient$1 rNCWebViewManagerImpl$setupWebChromeClient$1 = new RNCWebViewManagerImpl$setupWebChromeClient$1(rNCWebView);
            rNCWebViewManagerImpl$setupWebChromeClient$1.setAllowsProtectedMedia(this.f11270e);
            rNCWebViewManagerImpl$setupWebChromeClient$1.setHasOnOpenWindowEvent(this.f11273h);
            rNCWebView.setWebChromeClient(rNCWebViewManagerImpl$setupWebChromeClient$1);
            return;
        }
        RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1 rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1 = new RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1(rNCWebView, currentActivity, currentActivity.getRequestedOrientation());
        rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1.setAllowsProtectedMedia(this.f11270e);
        rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1.setHasOnOpenWindowEvent(this.f11273h);
        rNCWebView.setWebChromeClient(rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1);
    }

    private final void j(RNCWebViewWrapper rNCWebViewWrapper, ReadableMap readableMap) {
        byte[] bArr;
        String str;
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                String string = readableMap.getString("html");
                if (readableMap.hasKey("baseUrl")) {
                    str = readableMap.getString("baseUrl");
                } else {
                    str = "";
                }
                m.c(string);
                webView.loadDataWithBaseURL(str, string, this.f11278m, this.f11277l, (String) null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string2 = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url != null && m.b(url, string2)) {
                    return;
                }
                if (!readableMap.hasKey(FirebaseAnalytics.Param.METHOD) || !j.q(readableMap.getString(FirebaseAnalytics.Param.METHOD), this.f11279n, true)) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        if (this.f11266a) {
                            ReadableArray array = readableMap.getArray("headers");
                            m.c(array);
                            Iterator<Object> it = array.toArrayList().iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                m.d(next, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
                                HashMap hashMap2 = (HashMap) next;
                                String str2 = (String) hashMap2.get("name");
                                if (str2 == null) {
                                    str2 = "";
                                }
                                String str3 = (String) hashMap2.get("value");
                                if (str3 == null) {
                                    str3 = "";
                                }
                                Locale locale = Locale.ENGLISH;
                                m.e(locale, "ENGLISH");
                                String lowerCase = str2.toLowerCase(locale);
                                m.e(lowerCase, "toLowerCase(...)");
                                if (m.b("user-agent", lowerCase)) {
                                    webView.getSettings().setUserAgentString(str3);
                                } else {
                                    hashMap.put(str2, str3);
                                }
                            }
                        } else {
                            ReadableMap map = readableMap.getMap("headers");
                            m.c(map);
                            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                            while (keySetIterator.hasNextKey()) {
                                String nextKey = keySetIterator.nextKey();
                                Locale locale2 = Locale.ENGLISH;
                                m.e(locale2, "ENGLISH");
                                String lowerCase2 = nextKey.toLowerCase(locale2);
                                m.e(lowerCase2, "toLowerCase(...)");
                                if (m.b("user-agent", lowerCase2)) {
                                    webView.getSettings().setUserAgentString(map.getString(nextKey));
                                } else {
                                    hashMap.put(nextKey, map.getString(nextKey));
                                }
                            }
                        }
                    }
                    m.c(string2);
                    webView.loadUrl(string2, hashMap);
                    return;
                }
                if (readableMap.hasKey("body")) {
                    String string3 = readableMap.getString("body");
                    try {
                        m.c(string3);
                        Charset forName = Charset.forName("UTF-8");
                        m.e(forName, "forName(...)");
                        bArr = string3.getBytes(forName);
                        m.e(bArr, "getBytes(...)");
                    } catch (UnsupportedEncodingException unused) {
                        m.c(string3);
                        bArr = string3.getBytes(d.f797b);
                        m.e(bArr, "getBytes(...)");
                    }
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                m.c(string2);
                webView.postUrl(string2, bArr);
                return;
            }
        }
        webView.loadUrl(this.f11280o);
    }

    /* access modifiers changed from: private */
    public static final void k(WebView webView) {
    }

    public final void A(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        int i10;
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (Build.VERSION.SDK_INT > 28) {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                if (z10) {
                    i10 = 2;
                } else {
                    i10 = 0;
                }
                WebSettingsCompat.setForceDark(webView.getSettings(), i10);
            }
            if (z10 && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 2);
            }
        }
    }

    public final void B(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setGeolocationEnabled(z10);
    }

    public final void C(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        this.f11273h = z10;
        i0(webView);
    }

    public final void D(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().setHasScrollEvent(z10);
    }

    public final void E(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (z10) {
            CookieManager.getInstance().removeAllCookies((ValueCallback) null);
            webView.getSettings().setCacheMode(2);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    public final void F(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().f11241a = str;
    }

    public final void G(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().f11242b = str;
    }

    public final void H(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().f11245e = z10;
    }

    public final void I(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().f11244d = z10;
    }

    public final void J(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().setInjectedJavaScriptObject(str);
    }

    public final void K(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(z10);
    }

    public final void L(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setJavaScriptEnabled(z10);
    }

    public final void M(String str) {
        this.f11272g = str;
    }

    public final void N(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setMediaPlaybackRequiresUserGesture(z10);
    }

    public final void O(RNCWebViewWrapper rNCWebViewWrapper, ReadableArray readableArray) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (readableArray == null) {
            webView.setMenuCustomItems((List<Map<String, String>>) null);
            return;
        }
        ArrayList<Object> arrayList = readableArray.toArrayList();
        m.d(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");
        webView.setMenuCustomItems(arrayList);
    }

    public final void P(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().setMessagingEnabled(z10);
    }

    public final void Q(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().f11247g = str;
    }

    public final void R(RNCWebViewWrapper rNCWebViewWrapper, int i10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setMinimumFontSize(i10);
    }

    public final void S(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (str == null || m.b("never", str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if (m.b("always", str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if (m.b("compatibility", str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    public final void T(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().N0 = z10;
    }

    public final void U(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        int i10 = 0;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -1414557169) {
                boolean equals = str.equals("always");
            } else if (hashCode != 104712844) {
                if (hashCode == 951530617 && str.equals(FirebaseAnalytics.Param.CONTENT)) {
                    i10 = 1;
                }
            } else if (str.equals("never")) {
                i10 = 2;
            }
        }
        webView.setOverScrollMode(i10);
    }

    public final void V(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setSaveFormData(!z10);
    }

    public final void W(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        webView.getSettings().setLoadWithOverviewMode(z10);
        webView.getSettings().setUseWideViewPort(z10);
    }

    public final void X(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setBuiltInZoomControls(z10);
    }

    public final void Y(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setDisplayZoomControls(z10);
    }

    public final void Z(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setSupportMultipleWindows(z10);
    }

    public final void a0(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().setHorizontalScrollBarEnabled(z10);
    }

    public final void b0(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().setVerticalScrollBarEnabled(z10);
    }

    public final RNCWebView c(e1 e1Var) {
        m.f(e1Var, "context");
        return new RNCWebView(e1Var);
    }

    public final void c0(RNCWebViewWrapper rNCWebViewWrapper, ReadableMap readableMap) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        this.f11274i = readableMap;
    }

    public final RNCWebViewWrapper d(e1 e1Var) {
        m.f(e1Var, "context");
        return e(e1Var, c(e1Var));
    }

    public final void d0(RNCWebViewWrapper rNCWebViewWrapper, int i10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setTextZoom(i10);
    }

    public final RNCWebViewWrapper e(e1 e1Var, RNCWebView rNCWebView) {
        m.f(e1Var, "context");
        m.f(rNCWebView, "webView");
        i0(rNCWebView);
        e1Var.addLifecycleEventListener(rNCWebView);
        this.f11268c.a(rNCWebView);
        WebSettings settings = rNCWebView.getSettings();
        m.e(settings, "getSettings(...)");
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(1);
        rNCWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        rNCWebView.setDownloadListener(new g(rNCWebView, this));
        return new RNCWebViewWrapper(e1Var, rNCWebView);
    }

    public final void e0(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        CookieManager.getInstance().setAcceptThirdPartyCookies(rNCWebViewWrapper.getWebView(), z10);
    }

    public final void f0(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        this.f11275j = str;
        g0(rNCWebViewWrapper);
    }

    public final Map g() {
        return f.a().b("goBack", Integer.valueOf(this.f11283r)).b("goForward", Integer.valueOf(this.f11284s)).b("reload", Integer.valueOf(this.f11285t)).b("stopLoading", Integer.valueOf(this.f11286u)).b("postMessage", Integer.valueOf(this.f11287v)).b("injectJavaScript", Integer.valueOf(this.f11288w)).b("loadUrl", Integer.valueOf(this.f11289x)).b("requestFocus", Integer.valueOf(this.f11290y)).b("clearFormData", Integer.valueOf(this.f11291z)).b("clearCache", Integer.valueOf(this.A)).b("clearHistory", Integer.valueOf(this.B)).a();
    }

    public final void h0(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        WebView.setWebContentsDebuggingEnabled(z10);
    }

    public final void l(RNCWebViewWrapper rNCWebViewWrapper) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        ReadableMap readableMap = this.f11274i;
        if (readableMap != null) {
            j(rNCWebViewWrapper, readableMap);
        }
        this.f11274i = null;
    }

    public final void m(RNCWebViewWrapper rNCWebViewWrapper) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        webView.getThemedReactContext().removeLifecycleEventListener(webView);
        webView.c();
        webView.Q0 = null;
    }

    public final void n(RNCWebViewWrapper rNCWebViewWrapper, String str, ReadableArray readableArray) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        m.f(str, "commandId");
        m.f(readableArray, "args");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        switch (str.hashCode()) {
            case -1241591313:
                if (str.equals("goBack")) {
                    webView.goBack();
                    return;
                }
                return;
            case -948122918:
                if (str.equals("stopLoading")) {
                    webView.stopLoading();
                    return;
                }
                return;
            case -934641255:
                if (str.equals("reload")) {
                    webView.reload();
                    return;
                }
                return;
            case -759238347:
                if (str.equals("clearCache")) {
                    webView.clearCache(readableArray.getBoolean(0));
                    return;
                }
                return;
            case -318289731:
                if (str.equals("goForward")) {
                    webView.goForward();
                    return;
                }
                return;
            case -265032709:
                if (str.equals("clearFormData")) {
                    webView.clearFormData();
                    return;
                }
                return;
            case 336631465:
                if (str.equals("loadUrl")) {
                    webView.O0.b(false);
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                return;
            case 903120263:
                if (str.equals("clearHistory")) {
                    webView.clearHistory();
                    return;
                }
                return;
            case 1280029577:
                if (str.equals("requestFocus")) {
                    webView.requestFocus();
                    return;
                }
                return;
            case 1490029383:
                if (str.equals("postMessage")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", readableArray.getString(0));
                        webView.h("(function () {var event;var data = " + jSONObject + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                        return;
                    } catch (JSONException e10) {
                        throw new RuntimeException(e10);
                    }
                } else {
                    return;
                }
            case 2104576510:
                if (str.equals("injectJavaScript")) {
                    webView.h(readableArray.getString(0));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void o(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setAllowFileAccess(z10);
    }

    public final void p(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setAllowFileAccessFromFileURLs(z10);
    }

    public final void q(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setAllowUniversalAccessFromFileURLs(z10);
    }

    public final void r(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        this.f11269d = z10;
        i0(webView);
    }

    public final void s(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        WebChromeClient webChromeClient;
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        this.f11270e = z10;
        if (Build.VERSION.SDK_INT >= 26 && (webChromeClient = webView.getWebChromeClient()) != null && (webChromeClient instanceof RNCWebChromeClient)) {
            ((RNCWebChromeClient) webChromeClient).setAllowsProtectedMedia(z10);
        }
    }

    public final void t(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        int i10;
        m.f(rNCWebViewWrapper, "viewWrapper");
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        if (m.b(str, "hardware")) {
            i10 = 2;
        } else if (m.b(str, "software")) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        webView.setLayerType(i10, (Paint) null);
    }

    public final void u(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        if (str != null) {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(rNCWebViewWrapper.getWebView().getContext());
            this.f11276k = defaultUserAgent + " " + str;
        } else {
            this.f11276k = null;
        }
        g0(rNCWebViewWrapper);
    }

    public final void v(RNCWebViewWrapper rNCWebViewWrapper, ReadableMap readableMap) {
        a aVar;
        m.f(rNCWebViewWrapper, "viewWrapper");
        if (readableMap == null || !readableMap.hasKey(HintConstants.AUTOFILL_HINT_USERNAME) || !readableMap.hasKey(HintConstants.AUTOFILL_HINT_PASSWORD)) {
            aVar = null;
        } else {
            aVar = new a(readableMap.getString(HintConstants.AUTOFILL_HINT_USERNAME), readableMap.getString(HintConstants.AUTOFILL_HINT_PASSWORD));
        }
        rNCWebViewWrapper.getWebView().setBasicAuthCredential(aVar);
    }

    public final void w(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        int i10;
        m.f(rNCWebViewWrapper, "viewWrapper");
        WebSettings settings = rNCWebViewWrapper.getWebView().getSettings();
        if (z10) {
            i10 = -1;
        } else {
            i10 = 2;
        }
        settings.setCacheMode(i10);
    }

    public final void x(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        WebSettings settings = rNCWebViewWrapper.getWebView().getSettings();
        int i10 = -1;
        if (str != null) {
            switch (str.hashCode()) {
                case -2059164003:
                    if (str.equals("LOAD_NO_CACHE")) {
                        i10 = 2;
                        break;
                    }
                    break;
                case -1215135800:
                    boolean equals = str.equals("LOAD_DEFAULT");
                    break;
                case -873877826:
                    if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                        i10 = 1;
                        break;
                    }
                    break;
                case 1548620642:
                    if (str.equals("LOAD_CACHE_ONLY")) {
                        i10 = 3;
                        break;
                    }
                    break;
            }
        }
        settings.setCacheMode(i10);
    }

    public final void y(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        m.f(rNCWebViewWrapper, "viewWrapper");
        rNCWebViewWrapper.getWebView().getSettings().setDomStorageEnabled(z10);
    }

    public final void z(String str) {
        this.f11271f = str;
    }

    public RNCWebViewManagerImpl(boolean z10) {
        this.f11266a = z10;
        this.f11267b = "RNCWebViewManagerImpl";
        this.f11268c = new f();
        this.f11277l = "UTF-8";
        this.f11278m = "text/html";
        this.f11279n = "POST";
        this.f11280o = "about:blank";
        this.f11281p = "Downloading";
        this.f11282q = "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.";
        this.f11283r = 1;
        this.f11284s = 2;
        this.f11285t = 3;
        this.f11286u = 4;
        this.f11287v = 5;
        this.f11288w = 6;
        this.f11289x = 7;
        this.f11290y = 8;
        this.f11291z = 1000;
        this.A = 1001;
        this.B = 1002;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RNCWebViewManagerImpl(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
