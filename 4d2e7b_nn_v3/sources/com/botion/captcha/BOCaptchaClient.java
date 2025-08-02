package com.botion.captcha;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Pair;
import com.botion.captcha.a;
import com.botion.captcha.ab;
import com.botion.captcha.s;
import com.botion.captcha.t;
import com.botion.captcha.u;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class BOCaptchaClient implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private final a f18428a;

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

    private BOCaptchaClient(Context context) {
        this.f18428a = new a(context);
    }

    public static BOCaptchaClient getClient(Context context) {
        return new BOCaptchaClient(context);
    }

    public static String getVersion() {
        return "1.0.3";
    }

    public static Pair<Boolean, String> isSupportWebView(Context context) {
        a.C0239a aVar = a.f18452f;
        return a.C0239a.a(context);
    }

    public final BOCaptchaClient addOnFailureListener(OnFailureListener onFailureListener) {
        a aVar = this.f18428a;
        m.f(onFailureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        aVar.f18455c = onFailureListener;
        return this;
    }

    public final BOCaptchaClient addOnSuccessListener(OnSuccessListener onSuccessListener) {
        a aVar = this.f18428a;
        m.f(onSuccessListener, "response");
        aVar.f18454b = onSuccessListener;
        return this;
    }

    public final BOCaptchaClient addOnWebViewShowListener(OnWebViewShowListener onWebViewShowListener) {
        a aVar = this.f18428a;
        m.f(onWebViewShowListener, "webViewShowListener");
        aVar.f18456d = onWebViewShowListener;
        return this;
    }

    public final void cancel() {
        a aVar = this.f18428a;
        if (System.currentTimeMillis() - a.f18451e < 1000) {
            af.b("The interval between the two cancel is at least 1 second.");
            return;
        }
        b bVar = aVar.f18453a;
        n nVar = bVar.f18511f;
        if (nVar == null) {
            m.u("request");
        }
        if (!nVar.a()) {
            n nVar2 = bVar.f18511f;
            if (nVar2 == null) {
                m.u("request");
            }
            nVar2.a(u.FAIL);
            ab abVar = ab.f18458a;
            String type = u.CANCEL.getType();
            String a10 = ab.a(type, ab.a.USER_ERROR.getType() + "60");
            t.a aVar2 = t.f18571a;
            String d10 = ac.d();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("description", "User cancelled 'Captcha'");
            Unit unit = Unit.f12577a;
            String a11 = t.a.a(a10, d10, jSONObject).a();
            af afVar = af.f18475a;
            af.b("Controller: ".concat(String.valueOf(a11)));
            n nVar3 = bVar.f18511f;
            if (nVar3 == null) {
                m.u("request");
            }
            nVar3.c();
            n nVar4 = bVar.f18511f;
            if (nVar4 == null) {
                m.u("request");
            }
            nVar4.a(a11);
        }
    }

    public final void configurationChanged(Configuration configuration) {
        d dVar;
        a aVar = this.f18428a;
        m.f(configuration, "newConfig");
        b bVar = aVar.f18453a;
        m.f(configuration, "newConfig");
        try {
            n nVar = bVar.f18511f;
            if (nVar == null) {
                m.u("request");
            }
            c cVar = nVar.f18541d;
            if (cVar != null && (dVar = cVar.f18515a) != null) {
                dVar.a();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void destroy() {
        a.a();
    }

    public final BOCaptchaClient init(String str) {
        this.f18428a.a(str, (BOCaptchaConfig) null);
        return this;
    }

    public final void setLogEnable(boolean z10) {
        a.a(z10);
    }

    public final BOCaptchaClient verifyWithCaptcha() {
        OnDialogShowListener onDialogShowListener;
        a aVar = this.f18428a;
        if (System.currentTimeMillis() - a.f18451e < 1000) {
            af.b("The interval between the two captcha is at least 1 second.");
        } else {
            a.f18451e = System.currentTimeMillis();
            b bVar = aVar.f18453a;
            OnSuccessListener onSuccessListener = aVar.f18454b;
            bVar.f18507b = onSuccessListener;
            OnFailureListener onFailureListener = aVar.f18455c;
            bVar.f18508c = onFailureListener;
            bVar.f18509d = aVar.f18456d;
            Context context = bVar.f18513h;
            if (onFailureListener == null) {
                throw new IllegalArgumentException("The OnFailureListener object cannot be null.".toString());
            } else if (onSuccessListener == null) {
                t.a aVar2 = t.f18571a;
                String c10 = ac.c();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The BOCSessionResponse object cannot be null");
                Unit unit = Unit.f12577a;
                String a10 = t.a.a(u.FLOWING.getType() + ab.a.PARAM.getType() + "70", c10, jSONObject).a();
                af.b(a10);
                OnFailureListener onFailureListener2 = bVar.f18508c;
                if (onFailureListener2 != null) {
                    onFailureListener2.onFailure(a10);
                }
            } else if (context == null) {
                t.a aVar3 = t.f18571a;
                String c11 = ac.c();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("description", "The context parameter should not be null");
                Unit unit2 = Unit.f12577a;
                String a11 = t.a.a(u.FLOWING.getType() + ab.a.PARAM.getType() + "71", c11, jSONObject2).a();
                af.b(a11);
                OnFailureListener onFailureListener3 = bVar.f18508c;
                if (onFailureListener3 != null) {
                    onFailureListener3.onFailure(a11);
                }
            } else if (!(context instanceof Activity)) {
                t.a aVar4 = t.f18571a;
                String c12 = ac.c();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("description", "The context must be an 'Activity' object");
                Unit unit3 = Unit.f12577a;
                String a12 = t.a.a(u.FLOWING.getType() + ab.a.PARAM.getType() + "72", c12, jSONObject3).a();
                af.b(a12);
                OnFailureListener onFailureListener4 = bVar.f18508c;
                if (onFailureListener4 != null) {
                    onFailureListener4.onFailure(a12);
                }
            } else {
                String str = bVar.f18506a;
                if (str == null) {
                    m.u("appId");
                }
                if (TextUtils.isEmpty(str)) {
                    t.a aVar5 = t.f18571a;
                    String c13 = ac.c();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("description", "The 'AppId' parameter should not be null");
                    Unit unit4 = Unit.f12577a;
                    String a13 = t.a.a(u.FLOWING.getType() + ab.a.PARAM.getType() + "74", c13, jSONObject4).a();
                    af.b(a13);
                    OnFailureListener onFailureListener5 = bVar.f18508c;
                    if (onFailureListener5 != null) {
                        onFailureListener5.onFailure(a13);
                    }
                } else {
                    n nVar = bVar.f18511f;
                    if (nVar == null) {
                        m.u("request");
                    }
                    u.a aVar6 = nVar.f18538a;
                    u.a aVar7 = u.a.NONE;
                    if (aVar6 != aVar7) {
                        n nVar2 = bVar.f18511f;
                        if (nVar2 == null) {
                            m.u("request");
                        }
                        if (nVar2.f18539b == u.NONE) {
                            n nVar3 = bVar.f18511f;
                            if (nVar3 == null) {
                                m.u("request");
                            }
                            nVar3.a(u.FLOWING);
                            n nVar4 = bVar.f18511f;
                            if (nVar4 == null) {
                                m.u("request");
                            }
                            nVar4.f18542e = bVar.f18507b;
                            n nVar5 = bVar.f18511f;
                            if (nVar5 == null) {
                                m.u("request");
                            }
                            nVar5.f18543f = bVar.f18508c;
                            n nVar6 = bVar.f18511f;
                            if (nVar6 == null) {
                                m.u("request");
                            }
                            nVar6.f18544g = bVar.f18509d;
                            o oVar = bVar.f18512g;
                            if (oVar == null) {
                                m.u("webViewHandler");
                            }
                            n nVar7 = bVar.f18511f;
                            if (nVar7 == null) {
                                m.u("request");
                            }
                            oVar.b(nVar7);
                        }
                    }
                    bVar.f18512g = new o();
                    Context context2 = bVar.f18513h;
                    s.a aVar8 = s.f18559l;
                    String str2 = bVar.f18506a;
                    if (str2 == null) {
                        m.u("appId");
                    }
                    n nVar8 = new n(context2, s.a.a(str2, bVar.f18510e));
                    bVar.f18511f = nVar8;
                    nVar8.a(aVar7);
                    n nVar9 = bVar.f18511f;
                    if (nVar9 == null) {
                        m.u("request");
                    }
                    nVar9.a(u.FLOWING);
                    n nVar10 = bVar.f18511f;
                    if (nVar10 == null) {
                        m.u("request");
                    }
                    BOCaptchaConfig bOCaptchaConfig = bVar.f18510e;
                    if (bOCaptchaConfig != null) {
                        onDialogShowListener = bOCaptchaConfig.getDialogShowListener();
                    } else {
                        onDialogShowListener = null;
                    }
                    nVar10.f18541d = new c(onDialogShowListener);
                    n nVar11 = bVar.f18511f;
                    if (nVar11 == null) {
                        m.u("request");
                    }
                    nVar11.f18542e = bVar.f18507b;
                    n nVar12 = bVar.f18511f;
                    if (nVar12 == null) {
                        m.u("request");
                    }
                    nVar12.f18543f = bVar.f18508c;
                    n nVar13 = bVar.f18511f;
                    if (nVar13 == null) {
                        m.u("request");
                    }
                    nVar13.f18544g = bVar.f18509d;
                    o oVar2 = bVar.f18512g;
                    if (oVar2 == null) {
                        m.u("webViewHandler");
                    }
                    n nVar14 = bVar.f18511f;
                    if (nVar14 == null) {
                        m.u("request");
                    }
                    oVar2.b(nVar14);
                }
            }
        }
        return this;
    }

    public final BOCaptchaClient init(String str, BOCaptchaConfig bOCaptchaConfig) {
        this.f18428a.a(str, bOCaptchaConfig);
        return this;
    }
}
