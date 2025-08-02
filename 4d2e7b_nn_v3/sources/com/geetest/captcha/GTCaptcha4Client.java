package com.geetest.captcha;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.pdns.x.c;
import com.geetest.captcha.a;
import com.geetest.captcha.h0;
import com.geetest.captcha.v;
import com.geetest.captcha.views.GTC4WebView;
import com.geetest.captcha.w;
import com.geetest.captcha.x;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class GTCaptcha4Client implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public final a f5743a;

    public interface OnDialogShowListener extends NoProguard {
        void actionAfterDialogShow(Dialog dialog);

        void actionBeforeDialogShow(Dialog dialog);

        void onDialogFocusChanged(Dialog dialog, boolean z10);
    }

    public interface OnFailureListener extends NoProguard {
        void onFailure(String str);
    }

    public interface OnSuccessListener extends NoProguard {
        void onSuccess(boolean z10, String str);
    }

    public interface OnWebViewShowListener extends NoProguard {
        void onWebViewShow();
    }

    public GTCaptcha4Client(Context context) {
        this.f5743a = new a(context);
    }

    public static GTCaptcha4Client getClient(Context context) {
        return new GTCaptcha4Client(context);
    }

    public static String getVersion() {
        return "1.8.3.1";
    }

    public static Pair<Boolean, String> isSupportWebView(Context context) {
        a.b bVar = a.f5767f;
        m.f(context, "context");
        try {
            new GTC4WebView(context).destroy();
            return new Pair<>(Boolean.TRUE, (Object) null);
        } catch (Exception e10) {
            e10.printStackTrace();
            h0 h0Var = h0.f5812d;
            h0Var.c("The device does not support WebViews, error message: " + e10.getMessage());
            return new Pair<>(Boolean.FALSE, e10.getMessage());
        }
    }

    public GTCaptcha4Client addOnFailureListener(OnFailureListener onFailureListener) {
        a aVar = this.f5743a;
        aVar.getClass();
        m.f(onFailureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        aVar.f5770c = onFailureListener;
        return this;
    }

    public GTCaptcha4Client addOnSuccessListener(OnSuccessListener onSuccessListener) {
        a aVar = this.f5743a;
        aVar.getClass();
        m.f(onSuccessListener, "response");
        aVar.f5769b = onSuccessListener;
        return this;
    }

    public GTCaptcha4Client addOnWebViewShowListener(OnWebViewShowListener onWebViewShowListener) {
        a aVar = this.f5743a;
        aVar.getClass();
        m.f(onWebViewShowListener, "webViewShowListener");
        aVar.f5771d = onWebViewShowListener;
        return this;
    }

    public void cancel() {
        a aVar = this.f5743a;
        aVar.getClass();
        if (System.currentTimeMillis() - a.f5766e < ((long) 1000)) {
            h0.f5812d.c("The interval between the two cancel is at least 1 second.");
            return;
        }
        b bVar = aVar.f5768a;
        p pVar = bVar.f5779f;
        if (pVar == null) {
            m.u("request");
        }
        if (!pVar.a()) {
            p pVar2 = bVar.f5779f;
            if (pVar2 == null) {
                m.u("request");
            }
            pVar2.a(x.FAIL);
            String type = x.CANCEL.getType();
            String str = d0.USER_ERROR.getType() + "60";
            m.f(str, Constant.PARAM_OAUTH_CODE);
            String n10 = m.n(type, str);
            w.a aVar2 = w.f5877d;
            String str2 = e0.f5792d;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "User cancelled 'Captcha'");
            Unit unit = Unit.f12577a;
            String a10 = aVar2.a(n10, str2, jSONObject).a();
            h0.f5812d.c("Controller: " + a10);
            p pVar3 = bVar.f5779f;
            if (pVar3 == null) {
                m.u("request");
            }
            pVar3.b();
            p pVar4 = bVar.f5779f;
            if (pVar4 == null) {
                m.u("request");
            }
            pVar4.a(a10);
        }
    }

    public void configurationChanged(Configuration configuration) {
        h hVar;
        a aVar = this.f5743a;
        aVar.getClass();
        m.f(configuration, "newConfig");
        b bVar = aVar.f5768a;
        bVar.getClass();
        m.f(configuration, "newConfig");
        try {
            p pVar = bVar.f5779f;
            if (pVar == null) {
                m.u("request");
            }
            g gVar = pVar.f5847c;
            if (gVar != null && (hVar = gVar.f5802a) != null) {
                hVar.a();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void destroy() {
        this.f5743a.getClass();
        try {
            h0.a aVar = h0.f5810b;
            if (aVar != null) {
                if (aVar != null) {
                    aVar.b();
                }
                h0.f5810b = null;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public GTCaptcha4Client init(String str) {
        this.f5743a.a(str, (GTCaptcha4Config) null);
        return this;
    }

    public void setLogEnable(boolean z10) {
        int i10;
        this.f5743a.getClass();
        h0.f5811c = z10;
        if (z10) {
            i10 = 1;
        } else {
            i10 = c.f18290d;
        }
        h0.f5809a = i10;
    }

    public GTCaptcha4Client verifyWithCaptcha() {
        OnDialogShowListener onDialogShowListener;
        a aVar = this.f5743a;
        aVar.getClass();
        if (System.currentTimeMillis() - a.f5766e < ((long) 1000)) {
            h0.f5812d.c("The interval between the two captcha is at least 1 second.");
        } else {
            a.f5766e = System.currentTimeMillis();
            b bVar = aVar.f5768a;
            OnSuccessListener onSuccessListener = aVar.f5769b;
            bVar.f5775b = onSuccessListener;
            OnFailureListener onFailureListener = aVar.f5770c;
            bVar.f5776c = onFailureListener;
            bVar.f5777d = aVar.f5771d;
            Context context = bVar.f5782i;
            if (onFailureListener == null) {
                throw new IllegalArgumentException("The OnFailureListener object cannot be null.".toString());
            } else if (onSuccessListener == null) {
                String str = e0.f5791c;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The GTC4SessionResponse object cannot be null");
                Unit unit = Unit.f12577a;
                String a10 = w.f5877d.a(x.FLOWING.getType() + d0.PARAM.getType() + "70", str, jSONObject).a();
                h0.f5812d.c(a10);
                OnFailureListener onFailureListener2 = bVar.f5776c;
                if (onFailureListener2 != null) {
                    onFailureListener2.onFailure(a10);
                }
            } else if (context == null) {
                String str2 = e0.f5791c;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("description", "The context parameter should not be null");
                Unit unit2 = Unit.f12577a;
                String a11 = w.f5877d.a(x.FLOWING.getType() + d0.PARAM.getType() + "71", str2, jSONObject2).a();
                h0.f5812d.c(a11);
                OnFailureListener onFailureListener3 = bVar.f5776c;
                if (onFailureListener3 != null) {
                    onFailureListener3.onFailure(a11);
                }
            } else if (!(context instanceof Activity)) {
                String str3 = e0.f5791c;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("description", "The context must be an 'Activity' object");
                Unit unit3 = Unit.f12577a;
                String a12 = w.f5877d.a(x.FLOWING.getType() + d0.PARAM.getType() + "72", str3, jSONObject3).a();
                h0.f5812d.c(a12);
                OnFailureListener onFailureListener4 = bVar.f5776c;
                if (onFailureListener4 != null) {
                    onFailureListener4.onFailure(a12);
                }
            } else {
                String str4 = bVar.f5774a;
                if (str4 == null) {
                    m.u("appId");
                }
                if (TextUtils.isEmpty(str4)) {
                    String str5 = e0.f5791c;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("description", "The 'AppId' parameter should not be null");
                    Unit unit4 = Unit.f12577a;
                    String a13 = w.f5877d.a(x.FLOWING.getType() + d0.PARAM.getType() + "74", str5, jSONObject4).a();
                    h0.f5812d.c(a13);
                    OnFailureListener onFailureListener5 = bVar.f5776c;
                    if (onFailureListener5 != null) {
                        onFailureListener5.onFailure(a13);
                    }
                } else {
                    p pVar = bVar.f5779f;
                    if (pVar == null) {
                        m.u("request");
                    }
                    x.a aVar2 = pVar.f5845a;
                    x.a aVar3 = x.a.NONE;
                    if (aVar2 != aVar3) {
                        p pVar2 = bVar.f5779f;
                        if (pVar2 == null) {
                            m.u("request");
                        }
                        if (pVar2.f5846b == x.NONE) {
                            p pVar3 = bVar.f5779f;
                            if (pVar3 == null) {
                                m.u("request");
                            }
                            pVar3.a(x.FLOWING);
                            p pVar4 = bVar.f5779f;
                            if (pVar4 == null) {
                                m.u("request");
                            }
                            pVar4.f5848d = bVar.f5775b;
                            p pVar5 = bVar.f5779f;
                            if (pVar5 == null) {
                                m.u("request");
                            }
                            pVar5.f5849e = bVar.f5776c;
                            p pVar6 = bVar.f5779f;
                            if (pVar6 == null) {
                                m.u("request");
                            }
                            pVar6.f5850f = bVar.f5777d;
                            s sVar = bVar.f5781h;
                            if (sVar == null) {
                                m.u("webViewHandler");
                            }
                            p pVar7 = bVar.f5779f;
                            if (pVar7 == null) {
                                m.u("request");
                            }
                            sVar.b(pVar7);
                        }
                    }
                    bVar.f5781h = new s();
                    Context context2 = bVar.f5782i;
                    v.a aVar4 = v.f5863l;
                    String str6 = bVar.f5774a;
                    if (str6 == null) {
                        m.u("appId");
                    }
                    p pVar8 = new p(context2, aVar4.a(str6, bVar.f5778e));
                    bVar.f5779f = pVar8;
                    pVar8.a(aVar3);
                    p pVar9 = bVar.f5779f;
                    if (pVar9 == null) {
                        m.u("request");
                    }
                    pVar9.a(x.FLOWING);
                    p pVar10 = bVar.f5779f;
                    if (pVar10 == null) {
                        m.u("request");
                    }
                    GTCaptcha4Config gTCaptcha4Config = bVar.f5778e;
                    if (gTCaptcha4Config != null) {
                        onDialogShowListener = gTCaptcha4Config.getDialogShowListener();
                    } else {
                        onDialogShowListener = null;
                    }
                    pVar10.f5847c = new g(onDialogShowListener);
                    p pVar11 = bVar.f5779f;
                    if (pVar11 == null) {
                        m.u("request");
                    }
                    pVar11.f5848d = bVar.f5775b;
                    p pVar12 = bVar.f5779f;
                    if (pVar12 == null) {
                        m.u("request");
                    }
                    pVar12.f5849e = bVar.f5776c;
                    p pVar13 = bVar.f5779f;
                    if (pVar13 == null) {
                        m.u("request");
                    }
                    pVar13.f5850f = bVar.f5777d;
                    s sVar2 = bVar.f5781h;
                    if (sVar2 == null) {
                        m.u("webViewHandler");
                    }
                    p pVar14 = bVar.f5779f;
                    if (pVar14 == null) {
                        m.u("request");
                    }
                    sVar2.b(pVar14);
                }
            }
        }
        return this;
    }

    public GTCaptcha4Client init(String str, GTCaptcha4Config gTCaptcha4Config) {
        this.f5743a.a(str, gTCaptcha4Config);
        return this;
    }
}
