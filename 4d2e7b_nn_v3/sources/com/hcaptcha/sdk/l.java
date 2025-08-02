package com.hcaptcha.sdk;

import java.io.Serializable;

class l implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private u f9548a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9549a;

        /* renamed from: b  reason: collision with root package name */
        private u f9550b;

        public l a() {
            u uVar = this.f9550b;
            if (!this.f9549a) {
                uVar = l.a();
            }
            return new l(uVar);
        }

        public String toString() {
            return "HCaptchaInternalConfig.HCaptchaInternalConfigBuilder(htmlProvider$value=" + this.f9550b + ")";
        }
    }

    public l(u uVar) {
        this.f9548a = uVar;
    }

    /* access modifiers changed from: private */
    public static u a() {
        return new k();
    }

    public static a c() {
        return new a();
    }

    public boolean d(Object obj) {
        return obj instanceof l;
    }

    public u e() {
        return this.f9548a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!lVar.d(this)) {
            return false;
        }
        u e10 = e();
        u e11 = lVar.e();
        if (e10 != null ? e10.equals(e11) : e11 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        u e10 = e();
        if (e10 == null) {
            i10 = 43;
        } else {
            i10 = e10.hashCode();
        }
        return i10 + 59;
    }

    public String toString() {
        return "HCaptchaInternalConfig(htmlProvider=" + e() + ")";
    }
}
