package com.onesignal;

import org.json.JSONArray;
import org.json.JSONObject;

public class a2 {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f10344a;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f10345b;

    a2(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray = null;
        if (jSONObject.has("adds")) {
            jSONObject2 = jSONObject.getJSONObject("adds");
        } else {
            jSONObject2 = null;
        }
        this.f10344a = jSONObject2;
        this.f10345b = jSONObject.has("removes") ? jSONObject.getJSONArray("removes") : jSONArray;
    }

    public JSONObject a() {
        return this.f10344a;
    }

    public JSONArray b() {
        return this.f10345b;
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.f10344a + ", removes=" + this.f10345b + '}';
    }
}
