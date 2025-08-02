package com.botion.captcha;

import com.botion.captcha.BOCaptchaClient;
import java.util.Map;

public class BOCaptchaConfig implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18429a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18430b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18431c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f18432d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18433e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f18434f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f18435g;

    /* renamed from: h  reason: collision with root package name */
    private final int f18436h;

    /* renamed from: i  reason: collision with root package name */
    private final int f18437i;

    /* renamed from: j  reason: collision with root package name */
    private final String f18438j;

    /* renamed from: k  reason: collision with root package name */
    private final BOCaptchaClient.OnDialogShowListener f18439k;

    public static class Builder implements NoProguard {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f18440a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f18441b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f18442c = "file:///android_asset/boc-index.html";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Map<String, Object> f18443d = null;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f18444e = true;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String[] f18445f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String[] f18446g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f18447h = 10000;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f18448i = 0;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f18449j = null;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public BOCaptchaClient.OnDialogShowListener f18450k = null;

        public BOCaptchaConfig build() {
            return new BOCaptchaConfig(this);
        }

        public void setApiServers(String[] strArr) {
            this.f18445f = strArr;
        }

        public Builder setBackgroundColor(int i10) {
            this.f18448i = i10;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean z10) {
            this.f18444e = z10;
            return this;
        }

        public Builder setDebug(boolean z10) {
            this.f18440a = z10;
            return this;
        }

        public void setDialogShowListener(BOCaptchaClient.OnDialogShowListener onDialogShowListener) {
            this.f18450k = onDialogShowListener;
        }

        public Builder setDialogStyle(String str) {
            this.f18449j = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.f18441b = str;
            return this;
        }

        public Builder setParams(Map<String, Object> map) {
            this.f18443d = map;
            return this;
        }

        public Builder setResourcePath(String str) {
            this.f18442c = str;
            return this;
        }

        public void setStaticServers(String[] strArr) {
            this.f18446g = strArr;
        }

        public Builder setTimeOut(int i10) {
            this.f18447h = i10;
            return this;
        }
    }

    public String[] getApiServers() {
        return this.f18434f;
    }

    public int getBackgroundColor() {
        return this.f18437i;
    }

    public BOCaptchaClient.OnDialogShowListener getDialogShowListener() {
        return this.f18439k;
    }

    public String getDialogStyle() {
        return this.f18438j;
    }

    public String getHtml() {
        return this.f18431c;
    }

    public String getLanguage() {
        return this.f18430b;
    }

    public Map<String, Object> getParams() {
        return this.f18432d;
    }

    public String[] getStaticServers() {
        return this.f18435g;
    }

    public int getTimeOut() {
        return this.f18436h;
    }

    public boolean isCanceledOnTouchOutside() {
        return this.f18433e;
    }

    public boolean isDebug() {
        return this.f18429a;
    }

    private BOCaptchaConfig(Builder builder) {
        this.f18429a = builder.f18440a;
        this.f18430b = builder.f18441b;
        this.f18431c = builder.f18442c;
        this.f18432d = builder.f18443d;
        this.f18433e = builder.f18444e;
        this.f18436h = builder.f18447h;
        this.f18437i = builder.f18448i;
        this.f18438j = builder.f18449j;
        this.f18439k = builder.f18450k;
        this.f18434f = builder.f18445f;
        this.f18435g = builder.f18446g;
    }
}
