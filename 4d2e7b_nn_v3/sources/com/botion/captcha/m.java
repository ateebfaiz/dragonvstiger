package com.botion.captcha;

import com.botion.captcha.t;
import com.botion.captcha.u;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import org.json.JSONObject;

public final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18534a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public final int a() {
        return 1;
    }

    public final void a(n nVar) {
        kotlin.jvm.internal.m.f(nVar, "request");
        if (!nVar.a()) {
            af.b("Step: PreLoadHandler.handler");
            nVar.a(u.a.FLOWING);
            nVar.a(nVar.f18545h, nVar.f18546i, new b(nVar, this));
        }
    }

    static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        private final n f18535a;

        /* renamed from: b  reason: collision with root package name */
        private final q f18536b;

        public b(n nVar, q qVar) {
            kotlin.jvm.internal.m.f(nVar, "request");
            kotlin.jvm.internal.m.f(qVar, "handler");
            this.f18535a = nVar;
            this.f18536b = qVar;
        }

        public final void a() {
            q qVar;
            if (!this.f18535a.a()) {
                af.b("PreLoadHandler", "HandlerObserver.onCallReady");
                this.f18535a.a(u.a.SUCCESS);
                n nVar = this.f18535a;
                u uVar = nVar.f18539b;
                if (uVar != u.NONE && uVar == u.FLOWING && (qVar = this.f18536b.f18558b) != null) {
                    qVar.b(nVar);
                }
            }
        }

        public final void b() {
            if (!this.f18535a.a()) {
                af.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onClose");
            }
        }

        public final void a(String str) {
            q qVar;
            kotlin.jvm.internal.m.f(str, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (!this.f18535a.a()) {
                af afVar = af.f18475a;
                af.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onWebError: ".concat(String.valueOf(str)));
                this.f18535a.a(u.a.FAIL);
                af.b(str);
                n nVar = this.f18535a;
                u uVar = nVar.f18539b;
                if (uVar != u.NONE && uVar == u.FLOWING && (qVar = this.f18536b.f18558b) != null) {
                    qVar.b(nVar);
                }
            }
        }

        public final void a(String str, String str2, JSONObject jSONObject) {
            q qVar;
            kotlin.jvm.internal.m.f(str, "errorCode");
            kotlin.jvm.internal.m.f(str2, "errorMsg");
            kotlin.jvm.internal.m.f(jSONObject, "errorDesc");
            if (!this.f18535a.a()) {
                this.f18535a.a(u.a.FAIL);
                ab abVar = ab.f18458a;
                String a10 = ab.a(this.f18535a.f18538a.getType(), str);
                t.a aVar = t.f18571a;
                String a11 = t.a.a(a10, str2, jSONObject).a();
                af afVar = af.f18475a;
                af.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onError: ".concat(String.valueOf(a11)));
                n nVar = this.f18535a;
                u uVar = nVar.f18539b;
                if (uVar != u.NONE && uVar == u.FLOWING && (qVar = this.f18536b.f18558b) != null) {
                    qVar.b(nVar);
                }
            }
        }

        public final void a(boolean z10, String str) {
            kotlin.jvm.internal.m.f(str, DbParams.KEY_CHANNEL_RESULT);
            if (!this.f18535a.a()) {
                af afVar = af.f18475a;
                af.b("PreLoadHandler", "PreLoadHandler.HandlerObserver.onResult: ".concat(String.valueOf(str)));
                this.f18535a.a(u.a.FAIL);
            }
        }
    }
}
