package com.zing.zalo.zalosdk.oauth;

import org.json.JSONObject;

public interface ZaloOpenAPICallback {
    void onResult(JSONObject jSONObject);
}
