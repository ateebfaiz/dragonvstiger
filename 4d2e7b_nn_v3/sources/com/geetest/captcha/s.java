package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.w;
import com.geetest.captcha.x;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class s extends u {
    public int a() {
        return 5;
    }

    public void a(p pVar) {
        m.f(pVar, "request");
        if (!pVar.a()) {
            h0 h0Var = h0.f5812d;
            h0Var.c("Step: WebViewHandler.handler");
            a aVar = new a(pVar, this);
            pVar.a(x.FLOWING);
            h0Var.a("Request", "currentStatus preLoadStatus: " + pVar.f5845a.name() + ", status: " + pVar.f5846b.name());
            x.a aVar2 = pVar.f5845a;
            if (aVar2 == x.a.FLOWING) {
                pVar.b(pVar.f5851g, pVar.f5852h, aVar);
            } else if (aVar2 == x.a.SUCCESS) {
                pVar.c();
                pVar.b(pVar.f5851g, pVar.f5852h, aVar);
            } else if (aVar2 == x.a.FAIL) {
                pVar.a(pVar.f5851g, pVar.f5852h, aVar);
                if (pVar.f5846b != x.FAIL) {
                    pVar.b(pVar.f5851g, pVar.f5852h, aVar);
                }
            } else if (aVar2 == x.a.NONE) {
                pVar.a(pVar.f5851g, pVar.f5852h, aVar);
                if (pVar.f5846b != x.FAIL) {
                    pVar.b(pVar.f5851g, pVar.f5852h, aVar);
                }
            }
        }
    }

    public static final class a implements z {

        /* renamed from: a  reason: collision with root package name */
        public final p f5859a;

        /* renamed from: b  reason: collision with root package name */
        public final u f5860b;

        /* renamed from: com.geetest.captcha.s$a$a  reason: collision with other inner class name */
        public static final class C0076a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f5861a;

            public C0076a(a aVar) {
                this.f5861a = aVar;
            }

            public final void run() {
                this.f5861a.f5859a.c();
            }
        }

        public a(p pVar, u uVar) {
            m.f(pVar, "request");
            m.f(uVar, "handler");
            this.f5859a = pVar;
            this.f5860b = uVar;
        }

        public void a() {
            if (!this.f5859a.a()) {
                h0.f5812d.a("WebViewHandler", "WebViewHandler.HandlerObserver.onCallReady");
                this.f5859a.a(x.SUCCESS);
                if (m.b(Looper.myLooper(), Looper.getMainLooper())) {
                    this.f5859a.c();
                    return;
                }
                Context context = this.f5859a.f5851g;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new C0076a(this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public void b() {
            if (!this.f5859a.a()) {
                h0 h0Var = h0.f5812d;
                h0Var.a("WebViewHandler", "WebViewHandler.HandlerObserver.onClose");
                this.f5859a.a(x.FAIL);
                String type = x.CANCEL.getType();
                String str = d0.USER_ERROR.getType() + "60";
                m.f(str, Constant.PARAM_OAUTH_CODE);
                String n10 = m.n(type, str);
                w.a aVar = w.f5877d;
                String str2 = e0.f5792d;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "User cancelled 'Captcha'");
                Unit unit = Unit.f12577a;
                String a10 = aVar.a(n10, str2, jSONObject).a();
                h0Var.c("WebViewHandler: " + a10);
                this.f5859a.b();
                this.f5859a.a(a10);
            }
        }

        public void a(String str) {
            m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (!this.f5859a.a()) {
                h0 h0Var = h0.f5812d;
                h0Var.b("WebViewHandler", "WebViewHandler.HandlerObserver.onWebError: " + str);
                this.f5859a.a(x.FAIL);
                this.f5860b.a(this.f5859a, str);
            }
        }

        public void a(String str, String str2, JSONObject jSONObject) {
            m.f(str, "errorCode");
            m.f(str2, "errorMsg");
            m.f(jSONObject, "errorDesc");
            if (!this.f5859a.a()) {
                this.f5859a.a(x.FAIL);
                String type = this.f5859a.f5846b.getType();
                m.f(str, Constant.PARAM_OAUTH_CODE);
                String a10 = w.f5877d.a(m.n(type, str), str2, jSONObject).a();
                h0 h0Var = h0.f5812d;
                h0Var.b("WebViewHandler", "WebViewHandler.HandlerObserver.onError: " + a10);
                this.f5860b.a(this.f5859a, a10);
            }
        }

        public void a(boolean z10, String str) {
            m.f(str, DbParams.KEY_CHANNEL_RESULT);
            if (!this.f5859a.a()) {
                h0 h0Var = h0.f5812d;
                h0Var.b("WebViewHandler", "HandlerObserver.onResult: " + str);
                if (z10) {
                    this.f5859a.a(x.END);
                    this.f5860b.a(this.f5859a, true, str);
                    return;
                }
                this.f5859a.a(x.FLOWING);
                this.f5860b.a(this.f5859a, false, str);
            }
        }
    }
}
