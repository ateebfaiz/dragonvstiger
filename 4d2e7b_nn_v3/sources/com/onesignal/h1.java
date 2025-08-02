package com.onesignal;

import androidx.autofill.HintConstants;
import org.json.JSONObject;

public class h1 implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private o2 f10668a = new o2("changed", false);

    /* renamed from: b  reason: collision with root package name */
    private String f10669b;

    /* renamed from: c  reason: collision with root package name */
    private String f10670c;

    h1(boolean z10) {
        if (z10) {
            String str = z3.f11153a;
            this.f10669b = z3.f(str, "PREFS_ONESIGNAL_EMAIL_ID_LAST", (String) null);
            this.f10670c = z3.f(str, "PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST", (String) null);
            return;
        }
        this.f10669b = o3.Y();
        this.f10670c = e4.b().D();
    }

    public o2 a() {
        return this.f10668a;
    }

    public boolean b() {
        if (this.f10669b == null || this.f10670c == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        String str = z3.f11153a;
        z3.m(str, "PREFS_ONESIGNAL_EMAIL_ID_LAST", this.f10669b);
        z3.m(str, "PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST", this.f10670c);
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
        if (str != null ? str.equals(this.f10669b) : this.f10669b == null) {
            z10 = false;
        }
        this.f10669b = str;
        if (z10) {
            this.f10668a.c(this);
        }
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f10669b;
            if (str != null) {
                jSONObject.put("emailUserId", str);
            } else {
                jSONObject.put("emailUserId", JSONObject.NULL);
            }
            String str2 = this.f10670c;
            if (str2 != null) {
                jSONObject.put(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, str2);
            } else {
                jSONObject.put(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, JSONObject.NULL);
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
