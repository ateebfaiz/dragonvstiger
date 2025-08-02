package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.botion.captcha.ab;
import com.botion.captcha.t;
import com.botion.captcha.u;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class o extends q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18553a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public final int a() {
        return 5;
    }

    public final void a(n nVar) {
        m.f(nVar, "request");
        if (!nVar.a()) {
            af.b("Step: WebViewHandler.handler");
            b bVar = new b(nVar, this);
            nVar.a(u.FLOWING);
            af.a("Request", "currentStatus preLoadStatus: " + nVar.f18538a.name() + ", status: " + nVar.f18539b.name());
            u.a aVar = nVar.f18538a;
            if (aVar == u.a.FLOWING) {
                nVar.b(nVar.f18545h, nVar.f18546i, bVar);
            } else if (aVar == u.a.SUCCESS) {
                nVar.b();
                nVar.b(nVar.f18545h, nVar.f18546i, bVar);
            } else if (aVar == u.a.FAIL) {
                nVar.a(nVar.f18545h, nVar.f18546i, bVar);
                if (nVar.f18539b != u.FAIL) {
                    nVar.b(nVar.f18545h, nVar.f18546i, bVar);
                }
            } else if (aVar == u.a.NONE) {
                nVar.a(nVar.f18545h, nVar.f18546i, bVar);
                if (nVar.f18539b != u.FAIL) {
                    nVar.b(nVar.f18545h, nVar.f18546i, bVar);
                }
            }
        }
    }

    static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        final n f18554a;

        /* renamed from: b  reason: collision with root package name */
        private final q f18555b;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f18556a;

            a(b bVar) {
                this.f18556a = bVar;
            }

            public final void run() {
                this.f18556a.f18554a.b();
            }
        }

        public b(n nVar, q qVar) {
            m.f(nVar, "request");
            m.f(qVar, "handler");
            this.f18554a = nVar;
            this.f18555b = qVar;
        }

        public final void a() {
            if (!this.f18554a.a()) {
                af.a("WebViewHandler", "WebViewHandler.HandlerObserver.onCallReady");
                this.f18554a.a(u.SUCCESS);
                if (m.b(Looper.myLooper(), Looper.getMainLooper())) {
                    this.f18554a.b();
                    return;
                }
                Context context = this.f18554a.f18545h;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new a(this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public final void b() {
            if (!this.f18554a.a()) {
                af.a("WebViewHandler", "WebViewHandler.HandlerObserver.onClose");
                this.f18554a.a(u.FAIL);
                ab abVar = ab.f18458a;
                String type = u.CANCEL.getType();
                String a10 = ab.a(type, ab.a.USER_ERROR.getType() + "60");
                t.a aVar = t.f18571a;
                String d10 = ac.d();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "User cancelled 'Captcha'");
                Unit unit = Unit.f12577a;
                String a11 = t.a.a(a10, d10, jSONObject).a();
                af.b("WebViewHandler: ".concat(String.valueOf(a11)));
                this.f18554a.c();
                this.f18554a.a(a11);
            }
        }

        public final void a(String str) {
            m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (!this.f18554a.a()) {
                af afVar = af.f18475a;
                af.b("WebViewHandler", "WebViewHandler.HandlerObserver.onWebError: ".concat(String.valueOf(str)));
                this.f18554a.a(u.FAIL);
                q.a(this.f18554a, str);
            }
        }

        public final void a(String str, String str2, JSONObject jSONObject) {
            m.f(str, "errorCode");
            m.f(str2, "errorMsg");
            m.f(jSONObject, "errorDesc");
            if (!this.f18554a.a()) {
                this.f18554a.a(u.FAIL);
                ab abVar = ab.f18458a;
                String a10 = ab.a(this.f18554a.f18539b.getType(), str);
                t.a aVar = t.f18571a;
                String a11 = t.a.a(a10, str2, jSONObject).a();
                af afVar = af.f18475a;
                af.b("WebViewHandler", "WebViewHandler.HandlerObserver.onError: ".concat(String.valueOf(a11)));
                q.a(this.f18554a, a11);
            }
        }

        public final void a(boolean z10, String str) {
            m.f(str, DbParams.KEY_CHANNEL_RESULT);
            if (!this.f18554a.a()) {
                af afVar = af.f18475a;
                af.b("WebViewHandler", "HandlerObserver.onResult: ".concat(String.valueOf(str)));
                if (z10) {
                    this.f18554a.a(u.END);
                    q.a(this.f18554a, true, str);
                    return;
                }
                this.f18554a.a(u.FLOWING);
                q.a(this.f18554a, false, str);
            }
        }
    }
}
