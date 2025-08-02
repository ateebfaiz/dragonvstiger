package com.zing.zalo.zalosdk.core.servicemap;

import org.json.JSONObject;

public interface ServiceMapListener {
    void receiveJSONObject(JSONObject jSONObject);
}
