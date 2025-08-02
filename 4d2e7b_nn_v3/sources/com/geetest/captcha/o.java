package com.geetest.captcha;

import com.geetest.captcha.x;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class o extends u {
    public int a() {
        return 1;
    }

    public void a(p pVar) {
        m.f(pVar, "request");
        if (!pVar.a()) {
            h0.f5812d.c("Step: PreLoadHandler.handler");
            pVar.a(x.a.FLOWING);
            pVar.a(pVar.f5851g, pVar.f5852h, new a(pVar, this));
        }
    }

    public static final class a implements z {

        /* renamed from: a  reason: collision with root package name */
        public final p f5843a;

        /* renamed from: b  reason: collision with root package name */
        public final u f5844b;

        public a(p pVar, u uVar) {
            m.f(pVar, "request");
            m.f(uVar, "handler");
            this.f5843a = pVar;
            this.f5844b = uVar;
        }

        public void a() {
            u uVar;
            if (!this.f5843a.a()) {
                h0.f5812d.b("PreLoadHandler", "HandlerObserver.onCallReady");
                this.f5843a.a(x.a.SUCCESS);
                p pVar = this.f5843a;
                x xVar = pVar.f5846b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.f5844b.f5862a) != null) {
                    uVar.b(pVar);
                }
            }
        }

        public void b() {
            if (!this.f5843a.a()) {
                h0.f5812d.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onClose");
            }
        }

        public void a(String str) {
            u uVar;
            m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (!this.f5843a.a()) {
                h0 h0Var = h0.f5812d;
                h0Var.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onWebError: " + str);
                this.f5843a.a(x.a.FAIL);
                h0Var.c(str);
                p pVar = this.f5843a;
                x xVar = pVar.f5846b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.f5844b.f5862a) != null) {
                    uVar.b(pVar);
                }
            }
        }

        public void a(String str, String str2, JSONObject jSONObject) {
            u uVar;
            m.f(str, "errorCode");
            m.f(str2, "errorMsg");
            m.f(jSONObject, "errorDesc");
            if (!this.f5843a.a()) {
                this.f5843a.a(x.a.FAIL);
                String type = this.f5843a.f5845a.getType();
                m.f(str, Constant.PARAM_OAUTH_CODE);
                String a10 = w.f5877d.a(m.n(type, str), str2, jSONObject).a();
                h0 h0Var = h0.f5812d;
                h0Var.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onError: " + a10);
                p pVar = this.f5843a;
                x xVar = pVar.f5846b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.f5844b.f5862a) != null) {
                    uVar.b(pVar);
                }
            }
        }

        public void a(boolean z10, String str) {
            m.f(str, DbParams.KEY_CHANNEL_RESULT);
            if (!this.f5843a.a()) {
                h0 h0Var = h0.f5812d;
                h0Var.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onResult: " + str);
                this.f5843a.a(x.a.FAIL);
            }
        }
    }
}
