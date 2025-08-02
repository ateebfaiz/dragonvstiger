package com.geetest.captcha;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.geetest.captcha.views.GTC4WebView;
import com.geetest.captcha.w;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONObject;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f5829a;

    /* renamed from: b  reason: collision with root package name */
    public y f5830b;

    /* renamed from: c  reason: collision with root package name */
    public final GTC4WebView f5831c;

    /* renamed from: d  reason: collision with root package name */
    public b f5832d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5833a;

        /* renamed from: b  reason: collision with root package name */
        public y f5834b;

        /* renamed from: c  reason: collision with root package name */
        public GTC4WebView f5835c;

        public final y a() {
            y yVar = this.f5834b;
            if (yVar == null) {
                m.u("observable");
            }
            return yVar;
        }

        public final String b() {
            String str = this.f5833a;
            if (str == null) {
                m.u(ImagesContract.URL);
            }
            return str;
        }

        public final GTC4WebView c() {
            GTC4WebView gTC4WebView = this.f5835c;
            if (gTC4WebView == null) {
                m.u("webView");
            }
            return gTC4WebView;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f5836a;

        /* renamed from: b  reason: collision with root package name */
        public GTC4WebView f5837b;

        /* renamed from: c  reason: collision with root package name */
        public y f5838c;

        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f5839a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f5840b;

            /* renamed from: com.geetest.captcha.l0$b$a$a  reason: collision with other inner class name */
            public static final class C0075a<T> implements ValueCallback<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0075a f5841a = new C0075a();

                public void onReceiveValue(Object obj) {
                    h0 h0Var = h0.f5812d;
                    h0Var.a("WebViewBuilder javascript:jsBridge.callback('postNativeMessage') return: " + ((String) obj));
                }
            }

            public a(b bVar, String str) {
                this.f5839a = bVar;
                this.f5840b = str;
            }

            public final void run() {
                GTC4WebView gTC4WebView = this.f5839a.f5837b;
                gTC4WebView.evaluateJavascript("javascript:jsBridge.callback('postNativeMessage', '" + this.f5840b + "')", C0075a.f5841a);
            }
        }

        public b(String str, GTC4WebView gTC4WebView, y yVar) {
            m.f(str, ImagesContract.URL);
            m.f(gTC4WebView, "webView");
            m.f(yVar, "observable");
            this.f5836a = str;
            this.f5837b = gTC4WebView;
            this.f5838c = yVar;
        }

        @JavascriptInterface
        public final void gt4Notify(String str) {
            String b10;
            h0.f5812d.c("JSInterface.gt4Notify: " + str + ", main: " + m.b(Looper.getMainLooper(), Looper.myLooper()));
            if (str == null || j.s(str)) {
                String str2 = e0.f5789a;
                w.a aVar = w.f5877d;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The Web callback data is empty");
                Unit unit = Unit.f12577a;
                this.f5838c.a(d0.WEB_CALLBACK_ERROR.getType() + "80", str2, jSONObject);
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
                                this.f5838c.a(true, jSONObject3);
                                return;
                            }
                            break;
                        case 102230:
                            if (string.equals("get")) {
                                try {
                                    if ((!m.b(Looper.getMainLooper(), Looper.myLooper())) && (this.f5837b.getContext() instanceof Activity) && (b10 = a0.f5773b.b(this.f5837b.getContext(), this.f5836a)) != null) {
                                        if (!j.s(b10)) {
                                            Context context = this.f5837b.getContext();
                                            if (context != null) {
                                                ((Activity) context).runOnUiThread(new a(this, b10));
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
                                this.f5838c.a(false, jSONObject4);
                                return;
                            }
                            break;
                        case 94756344:
                            if (string.equals("close")) {
                                Iterator<z> it = this.f5838c.f5883a.iterator();
                                while (it.hasNext()) {
                                    it.next().b();
                                }
                                return;
                            }
                            break;
                        case 96784904:
                            if (string.equals(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                                String jSONObject5 = jSONObject2.getJSONObject("data").toString();
                                m.e(jSONObject5, "jsonObject.getJSONObject(\"data\").toString()");
                                y yVar = this.f5838c;
                                yVar.getClass();
                                m.f(jSONObject5, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                                Iterator<z> it2 = yVar.f5883a.iterator();
                                while (it2.hasNext()) {
                                    it2.next().a(jSONObject5);
                                }
                                return;
                            }
                            break;
                        case 108386723:
                            if (string.equals("ready")) {
                                Iterator<z> it3 = this.f5838c.f5883a.iterator();
                                while (it3.hasNext()) {
                                    it3.next().a();
                                }
                                return;
                            }
                            break;
                    }
                }
                String str3 = e0.f5789a;
                w.a aVar2 = w.f5877d;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("description", jSONObject2);
                Unit unit2 = Unit.f12577a;
                this.f5838c.a(d0.WEB_CALLBACK_ERROR.getType() + "82", str3, jSONObject6);
            } catch (Exception e11) {
                e11.printStackTrace();
                String str4 = e0.f5789a;
                w.a aVar3 = w.f5877d;
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("exception", e11.getMessage());
                jSONObject7.put("description", str);
                Unit unit3 = Unit.f12577a;
                this.f5838c.a(d0.WEB_CALLBACK_ERROR.getType() + "81", str4, jSONObject7);
            }
        }
    }

    public l0(a aVar) {
        this.f5829a = aVar.b();
        this.f5830b = aVar.a();
        this.f5831c = aVar.c();
    }

    @SuppressLint({"AddJavascriptInterface", "JavascriptInterface"})
    public final l0 a() {
        b bVar = new b(this.f5829a, this.f5831c, this.f5830b);
        this.f5832d = bVar;
        this.f5831c.addJavascriptInterface(bVar, "JSInterface");
        this.f5831c.buildLayer();
        this.f5831c.loadUrl(this.f5829a);
        this.f5831c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return this;
    }
}
