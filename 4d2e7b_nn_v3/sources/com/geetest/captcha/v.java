package com.geetest.captcha;

import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class v {

    /* renamed from: l  reason: collision with root package name */
    public static final a f5863l = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f5864a;

    /* renamed from: b  reason: collision with root package name */
    public String f5865b = "file:///android_asset/gt4-index.html";

    /* renamed from: c  reason: collision with root package name */
    public boolean f5866c;

    /* renamed from: d  reason: collision with root package name */
    public String f5867d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f5868e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f5869f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, ? extends Object> f5870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5871h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f5872i = 10000;

    /* renamed from: j  reason: collision with root package name */
    public int f5873j;

    /* renamed from: k  reason: collision with root package name */
    public String f5874k;

    public static final class a {
        public final v a(String str, GTCaptcha4Config gTCaptcha4Config) {
            m.f(str, "captchaId");
            v vVar = new v();
            vVar.f5864a = str;
            if (gTCaptcha4Config != null) {
                vVar.f5866c = gTCaptcha4Config.isDebug();
                String html = gTCaptcha4Config.getHtml();
                m.e(html, "it.html");
                vVar.f5865b = html;
                vVar.f5867d = gTCaptcha4Config.getLanguage();
                vVar.f5868e = gTCaptcha4Config.getApiServers();
                vVar.f5869f = gTCaptcha4Config.getStaticServers();
                vVar.f5871h = gTCaptcha4Config.isCanceledOnTouchOutside();
                vVar.f5870g = gTCaptcha4Config.getParams();
                vVar.f5872i = gTCaptcha4Config.getTimeOut();
                vVar.f5873j = gTCaptcha4Config.getBackgroundColor();
                vVar.f5874k = gTCaptcha4Config.getDialogStyle();
            }
            if (j.s(vVar.f5865b)) {
                vVar.f5865b = "file:///android_asset/gt4-index.html";
            }
            return vVar;
        }
    }
}
