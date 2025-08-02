package com.onesignal;

import com.onesignal.e4;
import org.json.JSONObject;

class z4 extends a5 {
    z4() {
        super(e4.c.SMS);
    }

    /* access modifiers changed from: protected */
    public String A() {
        return o3.m0();
    }

    /* access modifiers changed from: protected */
    public t4 N(String str, boolean z10) {
        return new y4(str, z10);
    }

    /* access modifiers changed from: package-private */
    public void c0(String str) {
        o3.R1(str);
    }

    /* access modifiers changed from: package-private */
    public void e0() {
        o3.K();
    }

    /* access modifiers changed from: package-private */
    public void f0(JSONObject jSONObject) {
        o3.L(jSONObject);
    }

    /* access modifiers changed from: protected */
    public String g0() {
        return "sms_auth_hash";
    }

    /* access modifiers changed from: protected */
    public String h0() {
        return "sms_number";
    }

    /* access modifiers changed from: protected */
    public int i0() {
        return 14;
    }

    /* access modifiers changed from: package-private */
    public void k0(String str) {
        o3.w1(str);
    }
}
