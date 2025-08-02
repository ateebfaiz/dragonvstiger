package com.onesignal;

import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private h1 f10678a;

    /* renamed from: b  reason: collision with root package name */
    private h1 f10679b;

    public i1(h1 h1Var, h1 h1Var2) {
        this.f10678a = h1Var;
        this.f10679b = h1Var2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.MessagePayloadKeys.FROM, this.f10678a.e());
            jSONObject.put("to", this.f10679b.e());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
