package com.onesignal;

import com.google.firebase.messaging.Constants;
import org.json.JSONObject;

public class a3 {

    /* renamed from: a  reason: collision with root package name */
    private OSSubscriptionState f10346a;

    /* renamed from: b  reason: collision with root package name */
    private OSSubscriptionState f10347b;

    public a3(OSSubscriptionState oSSubscriptionState, OSSubscriptionState oSSubscriptionState2) {
        this.f10346a = oSSubscriptionState;
        this.f10347b = oSSubscriptionState2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.MessagePayloadKeys.FROM, this.f10346a.h());
            jSONObject.put("to", this.f10347b.h());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
