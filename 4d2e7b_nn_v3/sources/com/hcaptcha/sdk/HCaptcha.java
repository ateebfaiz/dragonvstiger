package com.hcaptcha.sdk;

import android.app.Activity;
import android.util.AndroidRuntimeException;
import androidx.fragment.app.FragmentActivity;
import f9.e;

public final class HCaptcha extends e {

    /* renamed from: i  reason: collision with root package name */
    private final Activity f9463i;

    /* renamed from: j  reason: collision with root package name */
    private w f9464j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public HCaptchaConfig f9465k;

    /* renamed from: l  reason: collision with root package name */
    private final l f9466l;

    private HCaptcha(Activity activity, l lVar) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        } else if (lVar != null) {
            this.f9463i = activity;
            this.f9466l = lVar;
        } else {
            throw new NullPointerException("internalConfig is marked non-null but is null");
        }
    }

    public static HCaptcha t(Activity activity) {
        if (activity != null) {
            return new HCaptcha(activity, l.c().a());
        }
        throw new NullPointerException("activity is marked non-null but is null");
    }

    private HCaptcha v() {
        this.f12077h.removeCallbacksAndMessages((Object) null);
        w wVar = this.f9464j;
        if (wVar == null) {
            k(new i(h.ERROR));
        } else {
            wVar.h(this.f9463i);
        }
        return this;
    }

    public HCaptcha u(HCaptchaConfig hCaptchaConfig) {
        if (hCaptchaConfig != null) {
            r.f9560a = hCaptchaConfig.getDiagnosticLog().booleanValue();
            AnonymousClass1 r02 = new HCaptchaStateListener() {
                public void a(i iVar) {
                    HCaptcha.this.k(iVar);
                }

                public void b() {
                    HCaptcha.this.e();
                }

                public void c(String str) {
                    HCaptcha hCaptcha = HCaptcha.this;
                    hCaptcha.j(hCaptcha.f9465k.getTokenExpiration());
                    HCaptcha hCaptcha2 = HCaptcha.this;
                    hCaptcha2.l(new s(str, hCaptcha2.f12077h));
                }
            };
            try {
                if (Boolean.TRUE.equals(hCaptchaConfig.getHideDialog())) {
                    HCaptchaConfig c10 = hCaptchaConfig.toBuilder().u(HCaptchaSize.INVISIBLE).l(Boolean.FALSE).c();
                    this.f9465k = c10;
                    this.f9464j = new j(this.f9463i, c10, this.f9466l, r02);
                } else {
                    Activity activity = this.f9463i;
                    if (activity instanceof FragmentActivity) {
                        this.f9464j = g.u(activity, hCaptchaConfig, this.f9466l, r02);
                        this.f9465k = hCaptchaConfig;
                    } else {
                        throw new IllegalStateException("Visual hCaptcha challenge verification requires FragmentActivity.");
                    }
                }
            } catch (AndroidRuntimeException unused) {
                r02.a(new i(h.ERROR));
            }
            return this;
        }
        throw new NullPointerException("inputConfig is marked non-null but is null");
    }

    public HCaptcha w(HCaptchaConfig hCaptchaConfig) {
        if (hCaptchaConfig != null) {
            if (this.f9464j == null || !hCaptchaConfig.equals(this.f9465k)) {
                u(hCaptchaConfig);
            }
            return v();
        }
        throw new NullPointerException("inputConfig is marked non-null but is null");
    }
}
