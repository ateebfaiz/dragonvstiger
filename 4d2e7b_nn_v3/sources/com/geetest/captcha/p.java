package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.l0;
import com.geetest.captcha.views.GTC4WebView;
import com.geetest.captcha.x;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public x.a f5845a = x.a.NONE;

    /* renamed from: b  reason: collision with root package name */
    public x f5846b = x.FLOWING;

    /* renamed from: c  reason: collision with root package name */
    public g f5847c;

    /* renamed from: d  reason: collision with root package name */
    public GTCaptcha4Client.OnSuccessListener f5848d;

    /* renamed from: e  reason: collision with root package name */
    public GTCaptcha4Client.OnFailureListener f5849e;

    /* renamed from: f  reason: collision with root package name */
    public GTCaptcha4Client.OnWebViewShowListener f5850f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f5851g;

    /* renamed from: h  reason: collision with root package name */
    public final v f5852h;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f5853a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5854b;

        public a(p pVar, String str) {
            this.f5853a = pVar;
            this.f5854b = str;
        }

        public final void run() {
            GTCaptcha4Client.OnFailureListener onFailureListener = this.f5853a.f5849e;
            if (onFailureListener != null) {
                onFailureListener.onFailure(this.f5854b);
            }
        }
    }

    public p(Context context, v vVar) {
        m.f(context, "context");
        m.f(vVar, "dataBean");
        this.f5851g = context;
        this.f5852h = vVar;
    }

    public final void a(x.a aVar) {
        m.f(aVar, "<set-?>");
        this.f5845a = aVar;
    }

    public final void b(Context context, v vVar, z zVar) {
        m.f(context, "context");
        m.f(vVar, "dataBean");
        m.f(zVar, "webViewObserver");
        g gVar = this.f5847c;
        if (gVar != null) {
            m.f(context, "context");
            m.f(vVar, "dataBean");
            m.f(zVar, "webViewObserver");
            try {
                y yVar = new y();
                yVar.a(zVar);
                GTC4WebView gTC4WebView = gVar.f5803b;
                if (gTC4WebView != null) {
                    gTC4WebView.setWebViewObservable(yVar);
                }
                l0 l0Var = gVar.f5804c;
                if (l0Var != null) {
                    m.f(yVar, "observable");
                    l0Var.f5830b = yVar;
                    l0.b bVar = l0Var.f5832d;
                    if (bVar == null) {
                        m.u("jsInterface");
                    }
                    String str = l0Var.f5829a;
                    GTC4WebView gTC4WebView2 = l0Var.f5831c;
                    bVar.getClass();
                    m.f(str, ImagesContract.URL);
                    m.f(gTC4WebView2, "webView");
                    m.f(yVar, "observable");
                    bVar.f5838c = yVar;
                    bVar.f5837b = gTC4WebView2;
                    bVar.f5836a = str;
                }
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    ((Activity) context).runOnUiThread(new f(gVar, context, vVar, zVar));
                } else {
                    gVar.b(context, vVar, zVar);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void c() {
        GTC4WebView gTC4WebView;
        g gVar = this.f5847c;
        if (!(gVar == null || (gTC4WebView = gVar.f5803b) == null)) {
            gTC4WebView.evaluateJavascript("javascript:jsBridge.callback('showBox')", d.f5786a);
        }
        try {
            h0.f5812d.a("Request.onWebViewShow");
            if (!a()) {
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = this.f5851g;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new C0364r(this));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                GTCaptcha4Client.OnWebViewShowListener onWebViewShowListener = this.f5850f;
                if (onWebViewShowListener != null) {
                    onWebViewShowListener.onWebViewShow();
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void a(x xVar) {
        m.f(xVar, "<set-?>");
        this.f5846b = xVar;
    }

    public final boolean a() {
        return this.f5846b == x.CANCEL;
    }

    public final void a(Context context, v vVar, z zVar) {
        m.f(context, "context");
        m.f(vVar, "dataBean");
        m.f(zVar, "webViewObserver");
        g gVar = this.f5847c;
        if (gVar != null) {
            gVar.a(context, vVar, zVar);
        }
    }

    public final void a(String str) {
        m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        try {
            h0 h0Var = h0.f5812d;
            h0Var.a("Request.onFailure: " + str);
            if (!a()) {
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = this.f5851g;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new a(this, str));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                } else {
                    GTCaptcha4Client.OnFailureListener onFailureListener = this.f5849e;
                    if (onFailureListener != null) {
                        onFailureListener.onFailure(str);
                    }
                }
                this.f5846b = x.CANCEL;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void b() {
        h hVar;
        g gVar = this.f5847c;
        if (gVar != null && (hVar = gVar.f5802a) != null && hVar.isShowing()) {
            GTC4WebView gTC4WebView = gVar.f5803b;
            Context context = gTC4WebView != null ? gTC4WebView.getContext() : null;
            if (context != null) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                        activity.runOnUiThread(new c(hVar));
                    } else {
                        hVar.dismiss();
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }
}
