package com.onesignal;

import com.google.firebase.messaging.Constants;
import org.json.JSONObject;

public class s2 {

    /* renamed from: a  reason: collision with root package name */
    private r2 f11035a;

    /* renamed from: b  reason: collision with root package name */
    private r2 f11036b;

    public s2(r2 r2Var, r2 r2Var2) {
        this.f11035a = r2Var;
        this.f11036b = r2Var2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.MessagePayloadKeys.FROM, this.f11035a.f());
            jSONObject.put("to", this.f11036b.f());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
