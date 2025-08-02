package com.onesignal;

import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j2 {

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f10706a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f10707b;

    public j2(JSONArray jSONArray, JSONObject jSONObject) {
        this.f10706a = jSONArray;
        this.f10707b = jSONObject;
    }

    public final JSONArray a() {
        return this.f10706a;
    }

    public final JSONObject b() {
        return this.f10707b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return m.b(this.f10706a, j2Var.f10706a) && m.b(this.f10707b, j2Var.f10707b);
    }

    public int hashCode() {
        JSONArray jSONArray = this.f10706a;
        int i10 = 0;
        int hashCode = (jSONArray == null ? 0 : jSONArray.hashCode()) * 31;
        JSONObject jSONObject = this.f10707b;
        if (jSONObject != null) {
            i10 = jSONObject.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "OSNotificationIntentExtras(dataArray=" + this.f10706a + ", jsonData=" + this.f10707b + ')';
    }
}
