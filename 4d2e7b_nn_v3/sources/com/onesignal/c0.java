package com.onesignal;

import org.json.JSONObject;

class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f10451a;

    public c0() {
        this.f10451a = new JSONObject();
    }

    public boolean a(String str) {
        return this.f10451a.has(str);
    }

    public boolean b(String str) {
        return this.f10451a.optBoolean(str);
    }

    public boolean c(String str, boolean z10) {
        return this.f10451a.optBoolean(str, z10);
    }

    public int d(String str, int i10) {
        return this.f10451a.optInt(str, i10);
    }

    public JSONObject e(String str) {
        return this.f10451a.optJSONObject(str);
    }

    public String f(String str) {
        return this.f10451a.optString(str);
    }

    public String g(String str, String str2) {
        return this.f10451a.optString(str, str2);
    }

    public String toString() {
        return "ImmutableJSONObject{jsonObject=" + this.f10451a + '}';
    }

    public c0(JSONObject jSONObject) {
        this.f10451a = jSONObject;
    }
}
