package com.onesignal;

import com.onesignal.e4;
import com.onesignal.o3;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a5 extends b5 {
    a5(e4.c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    public abstract String A();

    /* access modifiers changed from: protected */
    public o3.v B() {
        return o3.v.INFO;
    }

    /* access modifiers changed from: protected */
    public void O(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(h0(), jSONObject.get("identifier"));
                if (jSONObject.has(g0())) {
                    jSONObject2.put(g0(), jSONObject.get(g0()));
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            f0(jSONObject2);
        }
    }

    /* access modifiers changed from: protected */
    public void T() {
        if ((A() != null || D() != null) && o3.z0() != null) {
            C(0).c();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void e0();

    /* access modifiers changed from: package-private */
    public abstract void f0(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract String g0();

    /* access modifiers changed from: protected */
    public abstract String h0();

    /* access modifiers changed from: protected */
    public abstract int i0();

    /* access modifiers changed from: package-private */
    public void j0() {
        T();
    }

    /* access modifiers changed from: protected */
    public void n(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", i0());
            jSONObject.putOpt("device_player_id", o3.z0());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void w(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            e0();
        }
    }
}
