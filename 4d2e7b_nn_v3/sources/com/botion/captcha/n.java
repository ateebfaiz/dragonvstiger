package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.ai;
import com.botion.captcha.c;
import com.botion.captcha.u;
import com.botion.captcha.views.BOCWebView;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class n {

    /* renamed from: j  reason: collision with root package name */
    public static final a f18537j = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public u.a f18538a = u.a.NONE;

    /* renamed from: b  reason: collision with root package name */
    public u f18539b = u.FLOWING;

    /* renamed from: c  reason: collision with root package name */
    public int f18540c;

    /* renamed from: d  reason: collision with root package name */
    public c f18541d;

    /* renamed from: e  reason: collision with root package name */
    public BOCaptchaClient.OnSuccessListener f18542e;

    /* renamed from: f  reason: collision with root package name */
    public BOCaptchaClient.OnFailureListener f18543f;

    /* renamed from: g  reason: collision with root package name */
    public BOCaptchaClient.OnWebViewShowListener f18544g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f18545h;

    /* renamed from: i  reason: collision with root package name */
    final s f18546i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f18547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18548b;

        b(n nVar, String str) {
            this.f18547a = nVar;
            this.f18548b = str;
        }

        public final void run() {
            BOCaptchaClient.OnFailureListener b10 = this.f18547a.f18543f;
            if (b10 != null) {
                b10.onFailure(this.f18548b);
            }
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f18549a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18551c;

        public c(n nVar, boolean z10, String str) {
            this.f18549a = nVar;
            this.f18550b = z10;
            this.f18551c = str;
        }

        public final void run() {
            BOCaptchaClient.OnSuccessListener c10 = this.f18549a.f18542e;
            if (c10 != null) {
                c10.onSuccess(this.f18550b, this.f18551c);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f18552a;

        d(n nVar) {
            this.f18552a = nVar;
        }

        public final void run() {
            BOCaptchaClient.OnWebViewShowListener a10 = this.f18552a.f18544g;
            if (a10 != null) {
                a10.onWebViewShow();
            }
        }
    }

    public n(Context context, s sVar) {
        m.f(context, "context");
        m.f(sVar, "dataBean");
        this.f18545h = context;
        this.f18546i = sVar;
    }

    public final void a(u.a aVar) {
        m.f(aVar, "<set-?>");
        this.f18538a = aVar;
    }

    public final void b(Context context, s sVar, w wVar) {
        m.f(context, "context");
        m.f(sVar, "dataBean");
        m.f(wVar, "webViewObserver");
        c cVar = this.f18541d;
        if (cVar != null) {
            m.f(context, "context");
            m.f(sVar, "dataBean");
            m.f(wVar, "webViewObserver");
            try {
                v vVar = new v();
                vVar.a(wVar);
                BOCWebView bOCWebView = cVar.f18516b;
                if (bOCWebView != null) {
                    bOCWebView.setWebViewObservable(vVar);
                }
                ai aiVar = cVar.f18517c;
                if (aiVar != null) {
                    m.f(vVar, "observable");
                    aiVar.f18494b = vVar;
                    ai.b bVar = aiVar.f18496d;
                    if (bVar == null) {
                        m.u("jsInterface");
                    }
                    String str = aiVar.f18493a;
                    BOCWebView bOCWebView2 = aiVar.f18495c;
                    m.f(str, ImagesContract.URL);
                    m.f(bOCWebView2, "webView");
                    m.f(vVar, "observable");
                    bVar.f18502c = vVar;
                    bVar.f18501b = bOCWebView2;
                    bVar.f18500a = str;
                }
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    ((Activity) context).runOnUiThread(new c.d(cVar, context, sVar, wVar));
                } else {
                    cVar.b(context, sVar, wVar);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void c() {
        c cVar = this.f18541d;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(u uVar) {
        m.f(uVar, "<set-?>");
        this.f18539b = uVar;
    }

    public final boolean a() {
        return this.f18539b == u.CANCEL;
    }

    public final void a(Context context, s sVar, w wVar) {
        m.f(context, "context");
        m.f(sVar, "dataBean");
        m.f(wVar, "webViewObserver");
        c cVar = this.f18541d;
        if (cVar != null) {
            cVar.a(context, sVar, wVar);
        }
    }

    public final void a(String str) {
        m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        try {
            af afVar = af.f18475a;
            af.a("Request.onFailure: ".concat(String.valueOf(str)));
            if (!a()) {
                if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                    Context context = this.f18545h;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new b(this, str));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                } else {
                    BOCaptchaClient.OnFailureListener onFailureListener = this.f18543f;
                    if (onFailureListener != null) {
                        onFailureListener.onFailure(str);
                    }
                }
                this.f18539b = u.CANCEL;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void b() {
        BOCWebView bOCWebView;
        c cVar = this.f18541d;
        if (!(cVar == null || (bOCWebView = cVar.f18516b) == null || bOCWebView == null)) {
            bOCWebView.evaluateJavascript("javascript:jsBridge.callback('showBox')", c.b.f18520a);
        }
        try {
            af.a("Request.onWebViewShow");
            if (a()) {
                return;
            }
            if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                Context context = this.f18545h;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new d(this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            BOCaptchaClient.OnWebViewShowListener onWebViewShowListener = this.f18544g;
            if (onWebViewShowListener != null) {
                onWebViewShowListener.onWebViewShow();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
