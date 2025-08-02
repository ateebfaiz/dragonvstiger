package com.botion.captcha;

import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class s {

    /* renamed from: l  reason: collision with root package name */
    public static final a f18559l = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public String f18560a;

    /* renamed from: b  reason: collision with root package name */
    public String f18561b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18562c;

    /* renamed from: d  reason: collision with root package name */
    public String f18563d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f18564e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f18565f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, ? extends Object> f18566g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18567h;

    /* renamed from: i  reason: collision with root package name */
    public int f18568i;

    /* renamed from: j  reason: collision with root package name */
    public int f18569j;

    /* renamed from: k  reason: collision with root package name */
    public String f18570k;

    public static final class a {
        private a() {
        }

        public static s a(String str, BOCaptchaConfig bOCaptchaConfig) {
            m.f(str, "captchaId");
            s sVar = new s((byte) 0);
            sVar.f18560a = str;
            if (bOCaptchaConfig != null) {
                sVar.f18562c = bOCaptchaConfig.isDebug();
                String html = bOCaptchaConfig.getHtml();
                m.e(html, "it.html");
                sVar.f18561b = html;
                sVar.f18563d = bOCaptchaConfig.getLanguage();
                sVar.f18564e = bOCaptchaConfig.getApiServers();
                sVar.f18565f = bOCaptchaConfig.getStaticServers();
                sVar.f18567h = bOCaptchaConfig.isCanceledOnTouchOutside();
                sVar.f18566g = bOCaptchaConfig.getParams();
                sVar.f18568i = bOCaptchaConfig.getTimeOut();
                sVar.f18569j = bOCaptchaConfig.getBackgroundColor();
                sVar.f18570k = bOCaptchaConfig.getDialogStyle();
            }
            if (j.s(sVar.f18561b)) {
                sVar.f18561b = "file:///android_asset/boc-index.html";
            }
            return sVar;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    private s() {
        this.f18561b = "file:///android_asset/boc-index.html";
        this.f18567h = true;
        this.f18568i = 10000;
    }

    public /* synthetic */ s(byte b10) {
        this();
    }
}
