package com.onesignal;

import org.json.JSONException;
import org.json.JSONObject;

public class OSSubscriptionState implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private o2 f10305a = new o2("changed", false);

    /* renamed from: b  reason: collision with root package name */
    private String f10306b;

    /* renamed from: c  reason: collision with root package name */
    private String f10307c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10308d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10309e;

    OSSubscriptionState(boolean z10, boolean z11) {
        if (z10) {
            String str = z3.f11153a;
            this.f10309e = z3.b(str, "ONESIGNAL_SUBSCRIPTION_LAST", true);
            this.f10306b = z3.f(str, "ONESIGNAL_PLAYER_ID_LAST", (String) null);
            this.f10307c = z3.f(str, "ONESIGNAL_PUSH_TOKEN_LAST", (String) null);
            this.f10308d = z3.b(str, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", false);
            return;
        }
        this.f10309e = !e4.j();
        this.f10306b = o3.z0();
        this.f10307c = e4.e();
        this.f10308d = z11;
    }

    private void e(boolean z10) {
        boolean c10 = c();
        this.f10308d = z10;
        if (c10 != c()) {
            this.f10305a.c(this);
        }
    }

    public o2 a() {
        return this.f10305a;
    }

    public boolean b() {
        return this.f10309e;
    }

    public boolean c() {
        if (this.f10306b == null || this.f10307c == null || this.f10309e || !this.f10308d) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void changed(r2 r2Var) {
        e(r2Var.a());
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        String str = z3.f11153a;
        z3.j(str, "ONESIGNAL_SUBSCRIPTION_LAST", this.f10309e);
        z3.m(str, "ONESIGNAL_PLAYER_ID_LAST", this.f10306b);
        z3.m(str, "ONESIGNAL_PUSH_TOKEN_LAST", this.f10307c);
        z3.j(str, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", this.f10308d);
    }

    /* access modifiers changed from: package-private */
    public void f(String str) {
        if (str != null) {
            boolean z10 = !str.equals(this.f10307c);
            this.f10307c = str;
            if (z10) {
                this.f10305a.c(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        boolean z10 = true;
        if (str != null ? str.equals(this.f10306b) : this.f10306b == null) {
            z10 = false;
        }
        this.f10306b = str;
        if (z10) {
            this.f10305a.c(this);
        }
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f10306b;
            if (str != null) {
                jSONObject.put("userId", str);
            } else {
                jSONObject.put("userId", JSONObject.NULL);
            }
            String str2 = this.f10307c;
            if (str2 != null) {
                jSONObject.put("pushToken", str2);
            } else {
                jSONObject.put("pushToken", JSONObject.NULL);
            }
            jSONObject.put("isPushDisabled", b());
            jSONObject.put("isSubscribed", c());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return h().toString();
    }
}
