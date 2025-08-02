package com.onesignal;

import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class w2 {

    /* renamed from: a  reason: collision with root package name */
    private v2 f11097a;

    /* renamed from: b  reason: collision with root package name */
    private v2 f11098b;

    public w2(v2 v2Var, v2 v2Var2) {
        this.f11097a = v2Var;
        this.f11098b = v2Var2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.MessagePayloadKeys.FROM, this.f11097a.e());
            jSONObject.put("to", this.f11098b.e());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
