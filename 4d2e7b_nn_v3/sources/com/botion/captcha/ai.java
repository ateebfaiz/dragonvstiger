package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.botion.captcha.ab;
import com.botion.captcha.t;
import com.botion.captcha.views.BOCWebView;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONObject;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public final String f18493a;

    /* renamed from: b  reason: collision with root package name */
    public v f18494b;

    /* renamed from: c  reason: collision with root package name */
    public final BOCWebView f18495c;

    /* renamed from: d  reason: collision with root package name */
    public b f18496d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18497a;

        /* renamed from: b  reason: collision with root package name */
        public v f18498b;

        /* renamed from: c  reason: collision with root package name */
        public BOCWebView f18499c;
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f18500a;

        /* renamed from: b  reason: collision with root package name */
        public BOCWebView f18501b;

        /* renamed from: c  reason: collision with root package name */
        public v f18502c;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f18503a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f18504b;

            a(b bVar, String str) {
                this.f18503a = bVar;
                this.f18504b = str;
            }

            public final void run() {
                BOCWebView bOCWebView = this.f18503a.f18501b;
                bOCWebView.evaluateJavascript("javascript:jsBridge.callback('postNativeMessage', '" + this.f18504b + "')", AnonymousClass1.f18505a);
            }
        }

        public b(String str, BOCWebView bOCWebView, v vVar) {
            m.f(str, ImagesContract.URL);
            m.f(bOCWebView, "webView");
            m.f(vVar, "observable");
            this.f18500a = str;
            this.f18501b = bOCWebView;
            this.f18502c = vVar;
        }

        @JavascriptInterface
        public final void bocNotify(String str) {
            af afVar = af.f18475a;
            af.b("JSInterface.bocNotify: " + str + ", main: " + m.b(Looper.getMainLooper(), Looper.myLooper()));
            if (str == null || j.s(str)) {
                String a10 = ac.a();
                t.a aVar = t.f18571a;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The Web callback data is empty");
                Unit unit = Unit.f12577a;
                this.f18502c.a(ab.a.WEB_CALLBACK_ERROR.getType() + "80", a10, jSONObject);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = jSONObject2.getString("type");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -934426595:
                            if (string.equals(DbParams.KEY_CHANNEL_RESULT)) {
                                String jSONObject3 = jSONObject2.getJSONObject("data").toString();
                                m.e(jSONObject3, "jsonObject.getJSONObject(\"data\").toString()");
                                this.f18502c.a(true, jSONObject3);
                                return;
                            }
                            break;
                        case 102230:
                            if (string.equals("get")) {
                                try {
                                    if ((!m.b(Looper.getMainLooper(), Looper.myLooper())) && (this.f18501b.getContext() instanceof Activity)) {
                                        x xVar = x.f18582a;
                                        String a11 = x.a(this.f18501b.getContext(), this.f18500a);
                                        if (a11 == null) {
                                            return;
                                        }
                                        if (!j.s(a11)) {
                                            Context context = this.f18501b.getContext();
                                            if (context != null) {
                                                ((Activity) context).runOnUiThread(new a(this, a11));
                                                return;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                    return;
                                }
                            }
                            break;
                        case 3135262:
                            if (string.equals("fail")) {
                                String jSONObject4 = jSONObject2.getJSONObject("data").toString();
                                m.e(jSONObject4, "jsonObject.getJSONObject(\"data\").toString()");
                                this.f18502c.a(false, jSONObject4);
                                return;
                            }
                            break;
                        case 94756344:
                            if (string.equals("close")) {
                                this.f18502c.b();
                                return;
                            }
                            break;
                        case 96784904:
                            if (string.equals(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                                String jSONObject5 = jSONObject2.getJSONObject("data").toString();
                                m.e(jSONObject5, "jsonObject.getJSONObject(\"data\").toString()");
                                this.f18502c.a(jSONObject5);
                                return;
                            }
                            break;
                        case 108386723:
                            if (string.equals("ready")) {
                                this.f18502c.a();
                                return;
                            }
                            break;
                    }
                }
                String a12 = ac.a();
                t.a aVar2 = t.f18571a;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("description", jSONObject2);
                Unit unit2 = Unit.f12577a;
                this.f18502c.a(ab.a.WEB_CALLBACK_ERROR.getType() + "82", a12, jSONObject6);
            } catch (Exception e11) {
                e11.printStackTrace();
                String a13 = ac.a();
                t.a aVar3 = t.f18571a;
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("exception", e11.getMessage());
                jSONObject7.put("description", str);
                Unit unit3 = Unit.f12577a;
                this.f18502c.a(ab.a.WEB_CALLBACK_ERROR.getType() + "81", a13, jSONObject7);
            }
        }
    }

    private ai(a aVar) {
        String str = aVar.f18497a;
        if (str == null) {
            m.u(ImagesContract.URL);
        }
        this.f18493a = str;
        v vVar = aVar.f18498b;
        if (vVar == null) {
            m.u("observable");
        }
        this.f18494b = vVar;
        BOCWebView bOCWebView = aVar.f18499c;
        if (bOCWebView == null) {
            m.u("webView");
        }
        this.f18495c = bOCWebView;
    }

    public /* synthetic */ ai(a aVar, byte b10) {
        this(aVar);
    }
}
