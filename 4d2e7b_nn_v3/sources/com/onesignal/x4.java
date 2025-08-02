package com.onesignal;

import com.onesignal.b4;
import com.onesignal.b5;
import com.onesignal.e4;
import com.onesignal.o3;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class x4 extends b5 {
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static boolean f11106m;

    class a extends b4.g {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            boolean unused = x4.f11106m = true;
            if (str == null || str.isEmpty()) {
                str = "{}";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tags")) {
                    synchronized (x4.this.f10422a) {
                        x4 x4Var = x4.this;
                        JSONObject y10 = x4Var.y(x4Var.z().l().e("tags"), x4.this.F().l().e("tags"), (JSONObject) null, (Set) null);
                        x4.this.z().t("tags", jSONObject.optJSONObject("tags"));
                        x4.this.z().q();
                        x4.this.F().o(jSONObject, y10);
                        x4.this.F().q();
                    }
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    x4() {
        super(e4.c.PUSH);
    }

    /* access modifiers changed from: protected */
    public String A() {
        return o3.z0();
    }

    /* access modifiers changed from: protected */
    public o3.v B() {
        return o3.v.ERROR;
    }

    /* access modifiers changed from: protected */
    public t4 N(String str, boolean z10) {
        return new w4(str, z10);
    }

    /* access modifiers changed from: protected */
    public void O(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    public void T() {
        C(0).c();
    }

    /* access modifiers changed from: package-private */
    public void c0(String str) {
        o3.S1(str);
    }

    public String f0() {
        return F().i().g("language", (String) null);
    }

    /* access modifiers changed from: package-private */
    public b5.e g0(boolean z10) {
        b5.e eVar;
        if (z10) {
            String z02 = o3.z0();
            String o02 = o3.o0();
            b4.f("players/" + z02 + "?app_id=" + o02, new a(), "CACHE_KEY_GET_TAGS");
        }
        synchronized (this.f10422a) {
            eVar = new b5.e(f11106m, f0.c(F().l(), "tags"));
        }
        return eVar;
    }

    public boolean h0() {
        return F().i().c("userSubscribePref", true);
    }

    /* access modifiers changed from: package-private */
    public void i0(String str) {
        o3.x1(str);
    }

    public void j0(boolean z10) {
        try {
            G().s("androidPermission", Boolean.valueOf(z10));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void k0(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", jSONObject.optString("identifier", (String) null));
            if (jSONObject.has("device_type")) {
                jSONObject2.put("device_type", jSONObject.optInt("device_type"));
            }
            jSONObject2.putOpt("parent_player_id", jSONObject.optString("parent_player_id", (String) null));
            G().h(jSONObject2, (Set) null);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject3.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject3.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            G().g(jSONObject3, (Set) null);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void n(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    public void w(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            o3.H();
        }
        if (jSONObject.has("sms_number")) {
            o3.K();
        }
    }
}
