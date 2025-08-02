package com.livechatinc.inappchat;

import a1.p;
import a1.u;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b1.l;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatWindowViewImpl extends FrameLayout implements g {
    private ViewTreeObserver.OnGlobalLayoutListener C;
    /* access modifiers changed from: private */
    public PermissionRequest N0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WebView f10092a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10093b;

    /* renamed from: c  reason: collision with root package name */
    private Button f10094c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f10095d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WebView f10096e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c f10097f;

    /* renamed from: g  reason: collision with root package name */
    private ValueCallback f10098g;

    /* renamed from: h  reason: collision with root package name */
    private ValueCallback f10099h;

    /* renamed from: i  reason: collision with root package name */
    private a f10100i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f10101j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10102w = false;

    class LCWebChromeClient extends WebChromeClient {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f10103a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ConsoleMessage f10104b;

            a(boolean z10, ConsoleMessage consoleMessage) {
                this.f10103a = z10;
                this.f10104b = consoleMessage;
            }

            public void run() {
                ChatWindowViewImpl.this.F(this.f10103a, b.Console, -1, this.f10104b.message());
            }
        }

        LCWebChromeClient() {
        }

        public void onCloseWindow(WebView webView) {
            Log.d("onCloseWindow", "called");
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            boolean z10;
            if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                if (ChatWindowViewImpl.this.f10097f == null || !ChatWindowViewImpl.this.f10097f.onError(b.Console, -1, consoleMessage.message())) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                ChatWindowViewImpl.this.post(new a(z10, consoleMessage));
            }
            Log.i("ChatWindowView", "onConsoleMessage" + consoleMessage.messageLevel().name() + " " + consoleMessage.message());
            return super.onConsoleMessage(consoleMessage);
        }

        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            WebView unused = ChatWindowViewImpl.this.f10096e = new WebView(ChatWindowViewImpl.this.getContext());
            CookieManager.getInstance();
            CookieManager.getInstance().setAcceptThirdPartyCookies(ChatWindowViewImpl.this.f10096e, true);
            ChatWindowViewImpl.this.f10096e.setVerticalScrollBarEnabled(false);
            ChatWindowViewImpl.this.f10096e.setHorizontalScrollBarEnabled(false);
            ChatWindowViewImpl.this.f10096e.setWebViewClient(new k());
            ChatWindowViewImpl.this.f10096e.getSettings().setJavaScriptEnabled(true);
            ChatWindowViewImpl.this.f10096e.getSettings().setSavePassword(false);
            ChatWindowViewImpl.this.f10096e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ChatWindowViewImpl chatWindowViewImpl = ChatWindowViewImpl.this;
            chatWindowViewImpl.addView(chatWindowViewImpl.f10096e);
            ((WebView.WebViewTransport) message.obj).setWebView(ChatWindowViewImpl.this.f10096e);
            message.sendToTarget();
            return true;
        }

        @RequiresApi(api = 21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            PermissionRequest unused = ChatWindowViewImpl.this.N0 = permissionRequest;
            ChatWindowViewImpl.this.f10097f.onRequestAudioPermissions(new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA", "android.permission.MODIFY_AUDIO_SETTINGS"}, 89292);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            ChatWindowViewImpl.this.w(valueCallback);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            ChatWindowViewImpl.this.x(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            ChatWindowViewImpl.this.x(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            ChatWindowViewImpl.this.x(valueCallback);
        }
    }

    class a implements Runnable {
        a(p9.a aVar) {
        }

        public void run() {
            ChatWindowViewImpl.this.f10097f.onNewMessage((p9.a) null, ChatWindowViewImpl.this.isShown());
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ChatWindowViewImpl.this.O();
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action != 0 && action != 1) || view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f10109a;

        d(WebView webView) {
            this.f10109a = webView;
        }

        public void onGlobalLayout() {
            View decorView = ChatWindowViewImpl.this.getActivity().getWindow().getDecorView();
            ChatWindowViewImpl chatWindowViewImpl = ChatWindowViewImpl.this;
            DisplayMetrics displayMetrics = chatWindowViewImpl.getResources().getDisplayMetrics();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i10 = displayMetrics.heightPixels - rect.bottom;
            if (chatWindowViewImpl.getPaddingBottom() != i10) {
                chatWindowViewImpl.setPadding(chatWindowViewImpl.getPaddingLeft(), chatWindowViewImpl.getPaddingTop(), chatWindowViewImpl.getPaddingRight(), i10);
            } else if (i10 != 0) {
                this.f10109a.evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", (ValueCallback) null);
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            ChatWindowViewImpl.this.c();
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            ChatWindowViewImpl.this.f10097f.onChatWindowVisibilityChanged(true);
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            ChatWindowViewImpl.this.f10097f.onChatWindowVisibilityChanged(false);
        }
    }

    class h implements p.b {
        h() {
        }

        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Log.d("ChatWindowView", "Response: " + jSONObject);
            String m10 = ChatWindowViewImpl.this.y(jSONObject);
            Log.d("ChatWindowView", "constructed url: " + m10);
            boolean unused = ChatWindowViewImpl.this.f10101j = true;
            if (!(m10 == null || ChatWindowViewImpl.this.getContext() == null)) {
                ChatWindowViewImpl.this.f10092a.loadUrl(m10);
                ChatWindowViewImpl.this.f10092a.setVisibility(0);
            }
            if (ChatWindowViewImpl.this.f10097f != null) {
                ChatWindowViewImpl.this.f10097f.onWindowInitialized();
            }
        }
    }

    class i implements p.a {
        i() {
        }

        public void a(u uVar) {
            int i10;
            Log.d("ChatWindowView", "Error response: " + uVar);
            boolean z10 = false;
            boolean unused = ChatWindowViewImpl.this.f10101j = false;
            a1.k kVar = uVar.f13654a;
            if (kVar != null) {
                i10 = kVar.f13615a;
            } else {
                i10 = -1;
            }
            if (ChatWindowViewImpl.this.f10097f != null && ChatWindowViewImpl.this.f10097f.onError(b.InitialConfiguration, i10, uVar.getMessage())) {
                z10 = true;
            }
            if (ChatWindowViewImpl.this.getContext() != null) {
                ChatWindowViewImpl.this.F(z10, b.InitialConfiguration, i10, uVar.getMessage());
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        public void run() {
            ChatWindowViewImpl.this.A();
        }
    }

    public ChatWindowViewImpl(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void B(Context context) {
        setFitsSystemWindows(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(i.f10147b, this, true);
        this.f10092a = (WebView) findViewById(h.f10145d);
        this.f10093b = (TextView) findViewById(h.f10144c);
        this.f10095d = (ProgressBar) findViewById(h.f10143b);
        Button button = (Button) findViewById(h.f10142a);
        this.f10094c = button;
        button.setOnClickListener(new b());
        if (Build.VERSION.RELEASE.matches("4\\.4(\\.[12])?")) {
            String userAgentString = this.f10092a.getSettings().getUserAgentString();
            WebSettings settings = this.f10092a.getSettings();
            settings.setUserAgentString(userAgentString + " AndroidNoFilesharing");
        }
        CookieManager.getInstance().setAcceptCookie(true);
        this.f10092a.setFocusable(true);
        WebSettings settings2 = this.f10092a.getSettings();
        settings2.setJavaScriptEnabled(true);
        settings2.setAppCacheEnabled(true);
        settings2.setJavaScriptCanOpenWindowsAutomatically(true);
        settings2.setSupportMultipleWindows(true);
        settings2.setDomStorageEnabled(true);
        settings2.setMediaPlaybackRequiresUserGesture(false);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.f10092a, true);
        this.f10092a.setWebViewClient(new k());
        this.f10092a.setWebChromeClient(new LCWebChromeClient());
        this.f10092a.requestFocus(130);
        this.f10092a.setVisibility(8);
        this.f10092a.setOnTouchListener(new c());
        this.f10092a.addJavascriptInterface(new e(this), "androidMobileWidget");
        u(this.f10092a, getActivity());
    }

    /* access modifiers changed from: private */
    public static boolean C(String str) {
        if (str == null || !Pattern.compile("(secure-?(lc|dal|fra|)\\.(livechat|livechatinc)\\.com)").matcher(str).find()) {
            return false;
        }
        return true;
    }

    private boolean D() {
        if (this.f10099h != null) {
            return true;
        }
        return false;
    }

    private boolean E() {
        return false;
    }

    /* access modifiers changed from: private */
    public void F(boolean z10, b bVar, int i10, String str) {
        this.f10095d.setVisibility(8);
        if (z10) {
            return;
        }
        if (!this.f10102w || bVar != b.WebViewClient || i10 != -2) {
            this.f10092a.setVisibility(8);
            this.f10093b.setVisibility(0);
            this.f10094c.setVisibility(0);
        }
    }

    private void J(Intent intent) {
        if (D()) {
            L(intent);
        } else if (E()) {
            M(intent);
        } else {
            K(intent);
        }
    }

    private void K(Intent intent) {
        Uri uri;
        try {
            uri = Uri.fromFile(new File(k.f(getContext(), intent.getData())));
        } catch (Exception unused) {
            uri = null;
        }
        this.f10098g.onReceiveValue(uri);
        this.f10098g = null;
    }

    private void L(Intent intent) {
        Uri[] uriArr;
        try {
            uriArr = new Uri[]{Uri.parse(intent.getDataString())};
        } catch (Exception unused) {
            uriArr = null;
        }
        this.f10099h.onReceiveValue(uriArr);
        this.f10099h = null;
    }

    private void M(Intent intent) {
        this.f10098g.onReceiveValue(intent.getData());
        this.f10098g = null;
    }

    private void N() {
        this.f10092a.setVisibility(8);
        this.f10095d.setVisibility(0);
        this.f10093b.setVisibility(8);
        this.f10094c.setVisibility(8);
        this.f10101j = false;
        initialize();
    }

    /* access modifiers changed from: private */
    public void O() {
        if (this.f10101j) {
            this.f10102w = false;
            this.f10092a.reload();
            return;
        }
        N();
    }

    private void P() {
        if (this.C != null) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.C);
        }
    }

    private void Q() {
        S();
        R();
    }

    private void R() {
        ValueCallback valueCallback = this.f10099h;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.f10099h = null;
        }
    }

    private void S() {
        ValueCallback valueCallback = this.f10098g;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.f10098g = null;
        }
    }

    private boolean T(Activity activity) {
        if (Build.VERSION.SDK_INT < 30 && (activity.getWindow().getAttributes().flags & 1024) != 0) {
            return true;
        }
        return false;
    }

    private void U() {
        if (this.f10097f != null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            this.f10097f.onStartFilePickerActivity(intent, 21354);
            return;
        }
        Log.e("ChatWindowView", "You must provide a listener to handle file sharing");
        Toast.makeText(getContext(), j.f10148a, 0).show();
    }

    /* access modifiers changed from: private */
    public Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private void u(WebView webView, Activity activity) {
        if (T(getActivity())) {
            View decorView = activity.getWindow().getDecorView();
            this.C = new d(webView);
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.C);
        }
    }

    private void v() {
        if (this.f10100i == null) {
            throw new IllegalStateException("Config must be provided before initialization");
        } else if (this.f10101j) {
            throw new IllegalStateException("Chat Window already initialized");
        }
    }

    /* access modifiers changed from: private */
    public void w(ValueCallback valueCallback) {
        Q();
        this.f10099h = valueCallback;
        U();
    }

    /* access modifiers changed from: private */
    public void x(ValueCallback valueCallback) {
        Q();
        this.f10098g = valueCallback;
        U();
    }

    /* access modifiers changed from: private */
    public String y(JSONObject jSONObject) {
        String str = null;
        try {
            str = jSONObject.getString("chat_url").replace("{%license%}", (CharSequence) this.f10100i.b().get("KEY_LICENCE_NUMBER")).replace("{%group%}", (CharSequence) this.f10100i.b().get("KEY_GROUP_ID")) + "&native_platform=android";
            if (this.f10100i.b().get("KEY_VISITOR_NAME") != null) {
                str = str + "&name=" + URLEncoder.encode((String) this.f10100i.b().get("KEY_VISITOR_NAME"), "UTF-8").replace("+", "%20");
            }
            if (this.f10100i.b().get("KEY_VISITOR_EMAIL") != null) {
                str = str + "&email=" + URLEncoder.encode((String) this.f10100i.b().get("KEY_VISITOR_EMAIL"), "UTF-8");
            }
            String z10 = z(this.f10100i.b(), str);
            if (!TextUtils.isEmpty(z10)) {
                str = str + "&params=" + z10;
            }
            if (str.startsWith("http")) {
                return str;
            }
            return com.alibaba.pdns.s.e.c.f18247l + str;
        } catch (JSONException e10) {
            e = e10;
            e.printStackTrace();
            return str;
        } catch (UnsupportedEncodingException e11) {
            e = e11;
            e.printStackTrace();
            return str;
        }
    }

    private String z(Map map, String str) {
        String str2 = "";
        for (String str3 : map.keySet()) {
            if (str3.startsWith("#LCcustomParam_")) {
                String encode = Uri.encode(str3.replace("#LCcustomParam_", ""));
                String encode2 = Uri.encode((String) map.get(str3));
                if (!TextUtils.isEmpty(str2)) {
                    str2 = str2 + "&";
                }
                str2 = str2 + encode + "=" + encode2;
            }
        }
        return Uri.encode(str2);
    }

    /* access modifiers changed from: protected */
    public void A() {
        this.f10095d.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void G() {
        post(new e());
    }

    /* access modifiers changed from: protected */
    public void H(p9.a aVar) {
        if (this.f10097f != null) {
            post(new a(aVar));
        }
    }

    /* access modifiers changed from: protected */
    public void I() {
        this.f10102w = true;
        post(new j());
    }

    public boolean a(int i10, int i11, Intent intent) {
        if (i10 != 21354) {
            return false;
        }
        if (i11 != -1 || intent == null) {
            Q();
            return true;
        }
        J(intent);
        return true;
    }

    public boolean b() {
        if (!isShown()) {
            return false;
        }
        G();
        return true;
    }

    public void c() {
        setVisibility(8);
        if (this.f10097f != null) {
            post(new g());
        }
    }

    public void d() {
        setVisibility(0);
        if (this.f10097f != null) {
            post(new f());
        }
    }

    public void e(Boolean bool) {
        if (bool.booleanValue()) {
            N();
            return;
        }
        this.f10102w = false;
        this.f10092a.reload();
    }

    public boolean f(a aVar) {
        boolean z10;
        a aVar2 = this.f10100i;
        if (aVar2 == null || !aVar2.equals(aVar)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f10100i = aVar;
        return !z10;
    }

    public boolean g() {
        return this.f10102w;
    }

    public void initialize() {
        v();
        this.f10101j = true;
        l.a(getContext()).a(new b1.i(0, "https://cdn.livechatinc.com/app/mobile/urls.json", (JSONObject) null, new h(), new i()));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        P();
        this.f10092a.destroy();
        super.onDetachedFromWindow();
    }

    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        PermissionRequest permissionRequest;
        if (i10 != 89292 || (permissionRequest = this.N0) == null) {
            return false;
        }
        permissionRequest.grant(new String[]{"android.webkit.resource.AUDIO_CAPTURE", "android.webkit.resource.VIDEO_CAPTURE"});
        this.N0 = null;
        return true;
    }

    public void setEventsListener(c cVar) {
        this.f10097f = cVar;
    }

    class k extends WebViewClient {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f10118a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ WebResourceError f10119b;

            a(boolean z10, WebResourceError webResourceError) {
                this.f10118a = z10;
                this.f10119b = webResourceError;
            }

            public void run() {
                ChatWindowViewImpl.this.F(this.f10118a, b.WebViewClient, this.f10119b.getErrorCode(), String.valueOf(this.f10119b.getDescription()));
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f10121a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f10122b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f10123c;

            b(boolean z10, int i10, String str) {
                this.f10121a = z10;
                this.f10122b = i10;
                this.f10123c = str;
            }

            public void run() {
                ChatWindowViewImpl.this.F(this.f10121a, b.WebViewClient, this.f10122b, this.f10123c);
            }
        }

        k() {
        }

        private boolean a(WebView webView, Uri uri) {
            String uri2 = uri.toString();
            Log.i("ChatWindowView", "handle url: " + uri2);
            if (uri2.matches("https://.+facebook.+(/dialog/oauth\\?|/login\\.php\\?|/dialog/return/arbiter\\?).+")) {
                return false;
            }
            if (ChatWindowViewImpl.this.f10096e != null) {
                ChatWindowViewImpl.this.f10096e.setVisibility(8);
                ChatWindowViewImpl chatWindowViewImpl = ChatWindowViewImpl.this;
                chatWindowViewImpl.removeView(chatWindowViewImpl.f10096e);
                WebView unused = ChatWindowViewImpl.this.f10096e = null;
            }
            if (uri2.equals(webView.getOriginalUrl()) || ChatWindowViewImpl.C(uri.getHost())) {
                return false;
            }
            if (ChatWindowViewImpl.this.f10097f != null && ChatWindowViewImpl.this.f10097f.handleUri(uri)) {
                return true;
            }
            ChatWindowViewImpl.this.getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            if (str.startsWith("https://www.facebook.com/dialog/return/arbiter") && ChatWindowViewImpl.this.f10096e != null) {
                ChatWindowViewImpl.this.f10096e.setVisibility(8);
                ChatWindowViewImpl chatWindowViewImpl = ChatWindowViewImpl.this;
                chatWindowViewImpl.removeView(chatWindowViewImpl.f10096e);
                WebView unused = ChatWindowViewImpl.this.f10096e = null;
            }
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            ChatWindowViewImpl.this.post(new a(ChatWindowViewImpl.this.f10097f != null && ChatWindowViewImpl.this.f10097f.onError(b.WebViewClient, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription())), webResourceError));
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            Log.e("ChatWindow Widget", "onReceivedError: " + webResourceError.getErrorCode() + ": desc: " + webResourceError.getDescription() + " url: " + webResourceRequest.getUrl());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(webView, Uri.parse(str));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webView, webResourceRequest.getUrl());
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            ChatWindowViewImpl.this.post(new b(ChatWindowViewImpl.this.f10097f != null && ChatWindowViewImpl.this.f10097f.onError(b.WebViewClient, i10, str), i10, str));
            super.onReceivedError(webView, i10, str, str2);
            Log.e("ChatWindow Widget", "onReceivedError: " + i10 + ": desc: " + str + " url: " + str2);
        }
    }
}
