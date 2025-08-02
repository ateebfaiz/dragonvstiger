package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class H5UserIdentityAPI {
    protected JSONObject mEventObject;
    protected JSONObject mIdentityJson;

    public void init(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mIdentityJson = jSONObject;
        this.mEventObject = jSONObject2;
    }

    /* access modifiers changed from: protected */
    public void mergeIdentities(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (!(jSONObject == null || (jSONObject2 = this.mIdentityJson) == null)) {
            JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        }
        if (this.mIdentityJson == null && jSONObject != null) {
            this.mIdentityJson = new JSONObject(jSONObject.toString());
        }
        this.mEventObject.put("identities", this.mIdentityJson);
    }

    public boolean process(JSONObject jSONObject, JSONObject jSONObject2) {
        init(jSONObject, jSONObject2);
        return updateIdentities();
    }

    public boolean updateIdentities() {
        return true;
    }
}
