package com.onesignal;

import org.json.JSONObject;

public class v2 implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private o2 f11085a = new o2("changed", false);

    /* renamed from: b  reason: collision with root package name */
    private String f11086b;

    /* renamed from: c  reason: collision with root package name */
    private String f11087c;

    v2(boolean z10) {
        if (z10) {
            String str = z3.f11153a;
            this.f11086b = z3.f(str, "PREFS_OS_SMS_ID_LAST", (String) null);
            this.f11087c = z3.f(str, "PREFS_OS_SMS_NUMBER_LAST", (String) null);
            return;
        }
        this.f11086b = o3.m0();
        this.f11087c = e4.f().D();
    }

    public o2 a() {
        return this.f11085a;
    }

    public boolean b() {
        if (this.f11086b == null || this.f11087c == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        String str = z3.f11153a;
        z3.m(str, "PREFS_OS_SMS_ID_LAST", this.f11086b);
        z3.m(str, "PREFS_OS_SMS_NUMBER_LAST", this.f11087c);
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        boolean z10 = true;
        if (str != null ? str.equals(this.f11086b) : this.f11086b == null) {
            z10 = false;
        }
        this.f11086b = str;
        if (z10) {
            this.f11085a.c(this);
        }
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f11086b;
            if (str != null) {
                jSONObject.put("smsUserId", str);
            } else {
                jSONObject.put("smsUserId", JSONObject.NULL);
            }
            String str2 = this.f11087c;
            if (str2 != null) {
                jSONObject.put("smsNumber", str2);
            } else {
                jSONObject.put("smsNumber", JSONObject.NULL);
            }
            jSONObject.put("isSubscribed", b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return e().toString();
    }
}
