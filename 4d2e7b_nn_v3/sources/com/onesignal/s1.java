package com.onesignal;

import org.json.JSONObject;

public class s1 {

    /* renamed from: a  reason: collision with root package name */
    private String f11032a;

    /* renamed from: b  reason: collision with root package name */
    private float f11033b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11034c;

    s1(JSONObject jSONObject) {
        float f10;
        boolean z10;
        this.f11032a = jSONObject.getString("name");
        if (jSONObject.has("weight")) {
            f10 = (float) jSONObject.getDouble("weight");
        } else {
            f10 = 0.0f;
        }
        this.f11033b = f10;
        if (!jSONObject.has("unique") || !jSONObject.getBoolean("unique")) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f11034c = z10;
    }

    public String a() {
        return this.f11032a;
    }

    public float b() {
        return this.f11033b;
    }

    public boolean c() {
        return this.f11034c;
    }

    public String toString() {
        return "OSInAppMessageOutcome{name='" + this.f11032a + '\'' + ", weight=" + this.f11033b + ", unique=" + this.f11034c + '}';
    }
}
