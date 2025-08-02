package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import org.json.JSONObject;

public class H5UserIdentityStrategy {
    private final UserIdentityAPI userIdentityAPI;

    public H5UserIdentityStrategy(UserIdentityAPI userIdentityAPI2) {
        this.userIdentityAPI = userIdentityAPI2;
    }

    private void specialIDProcess(JSONObject jSONObject) {
        jSONObject.remove(Identities.ANDROID_ID);
        jSONObject.remove(Identities.ANONYMOUS_ID);
        jSONObject.remove(Identities.ANDROID_UUID);
    }

    public boolean processH5UserIdentity(EventType eventType, JSONObject jSONObject) {
        JSONObject jSONObject2;
        H5UserIdentityAPI h5UserIdentityAPI;
        try {
            String optString = jSONObject.optString("identities");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject(optString);
            } else {
                jSONObject2 = new JSONObject();
            }
            if (EventType.TRACK_SIGNUP == eventType) {
                specialIDProcess(jSONObject2);
                h5UserIdentityAPI = new SignUpH5UserIdentityAPI(this.userIdentityAPI, eventType);
            } else if (EventType.TRACK_ID_BIND == eventType) {
                specialIDProcess(jSONObject2);
                h5UserIdentityAPI = new BindIDH5UserIdentityAPI(this.userIdentityAPI);
            } else if (EventType.TRACK_ID_UNBIND == eventType) {
                h5UserIdentityAPI = new UnbindIDH5UserIdentityAPI(this.userIdentityAPI);
            } else {
                specialIDProcess(jSONObject2);
                h5UserIdentityAPI = new CommonUserIdentityAPI(this.userIdentityAPI);
            }
            return h5UserIdentityAPI.process(jSONObject2, jSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }
}
