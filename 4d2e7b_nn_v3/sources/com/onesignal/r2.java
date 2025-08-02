package com.onesignal;

import org.json.JSONObject;

public class r2 implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private o2 f11012a = new o2("changed", false);

    /* renamed from: b  reason: collision with root package name */
    private boolean f11013b;

    r2(boolean z10) {
        if (z10) {
            this.f11013b = z3.b(z3.f11153a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", false);
        } else {
            d();
        }
    }

    private void e(boolean z10) {
        boolean z11;
        if (this.f11013b != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f11013b = z10;
        if (z11) {
            this.f11012a.c(this);
        }
    }

    public boolean a() {
        return this.f11013b;
    }

    public o2 b() {
        return this.f11012a;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        z3.j(z3.f11153a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", this.f11013b);
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
    public void d() {
        e(OSUtils.a(o3.f10882b));
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("areNotificationsEnabled", this.f11013b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return f().toString();
    }
}
