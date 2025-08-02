package com.botion.captcha;

import android.content.Context;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.s;
import com.botion.captcha.u;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f18506a;

    /* renamed from: b  reason: collision with root package name */
    public BOCaptchaClient.OnSuccessListener f18507b;

    /* renamed from: c  reason: collision with root package name */
    public BOCaptchaClient.OnFailureListener f18508c;

    /* renamed from: d  reason: collision with root package name */
    public BOCaptchaClient.OnWebViewShowListener f18509d;

    /* renamed from: e  reason: collision with root package name */
    public BOCaptchaConfig f18510e;

    /* renamed from: f  reason: collision with root package name */
    public n f18511f;

    /* renamed from: g  reason: collision with root package name */
    public o f18512g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f18513h;

    /* renamed from: i  reason: collision with root package name */
    private m f18514i;

    public b(Context context) {
        m.f(context, "context");
        this.f18513h = context;
    }

    public final void a(String str) {
        m.f(str, "appId");
        this.f18506a = str;
    }

    public final void a() {
        this.f18514i = new m();
        this.f18512g = new o();
        m mVar = this.f18514i;
        if (mVar == null) {
            m.u("preLoadHandler");
        }
        o oVar = this.f18512g;
        if (oVar == null) {
            m.u("webViewHandler");
        }
        mVar.f18558b = oVar;
        Context context = this.f18513h;
        s.a aVar = s.f18559l;
        String str = this.f18506a;
        if (str == null) {
            m.u("appId");
        }
        n nVar = new n(context, s.a.a(str, this.f18510e));
        this.f18511f = nVar;
        nVar.a(u.a.FLOWING);
        n nVar2 = this.f18511f;
        if (nVar2 == null) {
            m.u("request");
        }
        nVar2.a(u.NONE);
        n nVar3 = this.f18511f;
        if (nVar3 == null) {
            m.u("request");
        }
        BOCaptchaConfig bOCaptchaConfig = this.f18510e;
        nVar3.f18541d = new c(bOCaptchaConfig != null ? bOCaptchaConfig.getDialogShowListener() : null);
        m mVar2 = this.f18514i;
        if (mVar2 == null) {
            m.u("preLoadHandler");
        }
        n nVar4 = this.f18511f;
        if (nVar4 == null) {
            m.u("request");
        }
        mVar2.b(nVar4);
    }
}
