package com.geetest.captcha;

import android.content.Context;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.v;
import com.geetest.captcha.x;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static long f5766e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f5767f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final b f5768a;

    /* renamed from: b  reason: collision with root package name */
    public GTCaptcha4Client.OnSuccessListener f5769b;

    /* renamed from: c  reason: collision with root package name */
    public GTCaptcha4Client.OnFailureListener f5770c;

    /* renamed from: d  reason: collision with root package name */
    public GTCaptcha4Client.OnWebViewShowListener f5771d;

    /* renamed from: com.geetest.captcha.a$a  reason: collision with other inner class name */
    public static final class C0072a extends n implements Function0<Unit> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0072a(Context context) {
            super(0);
            this.$context = context;
        }

        public final void invoke() {
            String str = null;
            File externalFilesDir = this.$context.getApplicationContext().getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                str = externalFilesDir.getAbsolutePath();
            }
            i0.f5821a = str;
        }
    }

    public static final class b {
    }

    public a(Context context) {
        m.f(context, "context");
        this.f5768a = new b(context);
        try {
            ob.a.b(false, false, (ClassLoader) null, (String) null, 0, new C0072a(context), 31, (Object) null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        e0.f5794f.a(context);
    }

    public final void a(String str, GTCaptcha4Config gTCaptcha4Config) {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener;
        m.f(str, "appId");
        b bVar = this.f5768a;
        bVar.getClass();
        m.f(str, "appId");
        bVar.f5774a = str;
        b bVar2 = this.f5768a;
        bVar2.f5778e = gTCaptcha4Config;
        bVar2.f5780g = new o();
        bVar2.f5781h = new s();
        o oVar = bVar2.f5780g;
        if (oVar == null) {
            m.u("preLoadHandler");
        }
        s sVar = bVar2.f5781h;
        if (sVar == null) {
            m.u("webViewHandler");
        }
        oVar.f5862a = sVar;
        Context context = bVar2.f5782i;
        v.a aVar = v.f5863l;
        String str2 = bVar2.f5774a;
        if (str2 == null) {
            m.u("appId");
        }
        p pVar = new p(context, aVar.a(str2, bVar2.f5778e));
        bVar2.f5779f = pVar;
        pVar.a(x.a.FLOWING);
        p pVar2 = bVar2.f5779f;
        if (pVar2 == null) {
            m.u("request");
        }
        pVar2.a(x.NONE);
        p pVar3 = bVar2.f5779f;
        if (pVar3 == null) {
            m.u("request");
        }
        GTCaptcha4Config gTCaptcha4Config2 = bVar2.f5778e;
        if (gTCaptcha4Config2 != null) {
            onDialogShowListener = gTCaptcha4Config2.getDialogShowListener();
        } else {
            onDialogShowListener = null;
        }
        pVar3.f5847c = new g(onDialogShowListener);
        o oVar2 = bVar2.f5780g;
        if (oVar2 == null) {
            m.u("preLoadHandler");
        }
        p pVar4 = bVar2.f5779f;
        if (pVar4 == null) {
            m.u("request");
        }
        oVar2.b(pVar4);
    }
}
