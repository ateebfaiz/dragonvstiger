package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;
import java.util.Map;

public class GTCaptcha4Config implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5744a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5745b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5746c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f5747d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f5748e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f5749f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5750g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5751h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5752i;

    /* renamed from: j  reason: collision with root package name */
    public final String f5753j;

    /* renamed from: k  reason: collision with root package name */
    public final GTCaptcha4Client.OnDialogShowListener f5754k;

    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5755a = false;

        /* renamed from: b  reason: collision with root package name */
        public String f5756b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f5757c = "file:///android_asset/gt4-index.html";

        /* renamed from: d  reason: collision with root package name */
        public String[] f5758d;

        /* renamed from: e  reason: collision with root package name */
        public String[] f5759e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, Object> f5760f = null;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5761g = true;

        /* renamed from: h  reason: collision with root package name */
        public int f5762h = 10000;

        /* renamed from: i  reason: collision with root package name */
        public int f5763i = 0;

        /* renamed from: j  reason: collision with root package name */
        public String f5764j = null;

        /* renamed from: k  reason: collision with root package name */
        public GTCaptcha4Client.OnDialogShowListener f5765k = null;

        public GTCaptcha4Config build() {
            return new GTCaptcha4Config(this);
        }

        public void setApiServers(String[] strArr) {
            this.f5758d = strArr;
        }

        public Builder setBackgroundColor(int i10) {
            this.f5763i = i10;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean z10) {
            this.f5761g = z10;
            return this;
        }

        public Builder setDebug(boolean z10) {
            this.f5755a = z10;
            return this;
        }

        public void setDialogShowListener(GTCaptcha4Client.OnDialogShowListener onDialogShowListener) {
            this.f5765k = onDialogShowListener;
        }

        public Builder setDialogStyle(String str) {
            this.f5764j = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.f5756b = str;
            return this;
        }

        public Builder setParams(Map<String, Object> map) {
            this.f5760f = map;
            return this;
        }

        public Builder setResourcePath(String str) {
            this.f5757c = str;
            return this;
        }

        public void setStaticServers(String[] strArr) {
            this.f5759e = strArr;
        }

        public Builder setTimeOut(int i10) {
            this.f5762h = i10;
            return this;
        }
    }

    public String[] getApiServers() {
        return this.f5747d;
    }

    public int getBackgroundColor() {
        return this.f5752i;
    }

    public GTCaptcha4Client.OnDialogShowListener getDialogShowListener() {
        return this.f5754k;
    }

    public String getDialogStyle() {
        return this.f5753j;
    }

    public String getHtml() {
        return this.f5746c;
    }

    public String getLanguage() {
        return this.f5745b;
    }

    public Map<String, Object> getParams() {
        return this.f5749f;
    }

    public String[] getStaticServers() {
        return this.f5748e;
    }

    public int getTimeOut() {
        return this.f5751h;
    }

    public boolean isCanceledOnTouchOutside() {
        return this.f5750g;
    }

    public boolean isDebug() {
        return this.f5744a;
    }

    public GTCaptcha4Config(Builder builder) {
        this.f5744a = builder.f5755a;
        this.f5745b = builder.f5756b;
        this.f5746c = builder.f5757c;
        this.f5749f = builder.f5760f;
        this.f5750g = builder.f5761g;
        this.f5751h = builder.f5762h;
        this.f5752i = builder.f5763i;
        this.f5753j = builder.f5764j;
        this.f5754k = builder.f5765k;
        this.f5747d = builder.f5758d;
        this.f5748e = builder.f5759e;
    }
}
