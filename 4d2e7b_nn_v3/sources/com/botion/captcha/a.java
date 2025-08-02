package com.botion.captcha;

import android.content.Context;
import android.util.Pair;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.views.BOCWebView;
import java.io.File;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    static long f18451e;

    /* renamed from: f  reason: collision with root package name */
    public static final C0239a f18452f = new C0239a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final b f18453a;

    /* renamed from: b  reason: collision with root package name */
    BOCaptchaClient.OnSuccessListener f18454b;

    /* renamed from: c  reason: collision with root package name */
    BOCaptchaClient.OnFailureListener f18455c;

    /* renamed from: d  reason: collision with root package name */
    BOCaptchaClient.OnWebViewShowListener f18456d;

    /* renamed from: com.botion.captcha.a$a  reason: collision with other inner class name */
    public static final class C0239a {
        private C0239a() {
        }

        public static Pair<Boolean, String> a(Context context) {
            m.f(context, "context");
            try {
                new BOCWebView(context).destroy();
                return new Pair<>(Boolean.TRUE, (Object) null);
            } catch (Exception e10) {
                e10.printStackTrace();
                af afVar = af.f18475a;
                af.b("The device does not support WebViews, error message: " + e10.getMessage());
                return new Pair<>(Boolean.FALSE, e10.getMessage());
            }
        }

        public /* synthetic */ C0239a(byte b10) {
            this();
        }
    }

    public a(Context context) {
        m.f(context, "context");
        this.f18453a = new b(context);
        try {
            ag agVar = ag.f18488a;
            String str = null;
            File externalFilesDir = context.getApplicationContext().getExternalFilesDir((String) null);
            ag.a(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        ac.a(context);
    }

    private final void b(String str, BOCaptchaConfig bOCaptchaConfig) {
        this.f18453a.a(str);
        b bVar = this.f18453a;
        bVar.f18510e = bOCaptchaConfig;
        bVar.a();
    }

    public final void a(String str, BOCaptchaConfig bOCaptchaConfig) {
        m.f(str, "appId");
        b(str, bOCaptchaConfig);
    }

    public static void a() {
        af.a();
    }

    public static void a(boolean z10) {
        af.a(z10);
    }
}
