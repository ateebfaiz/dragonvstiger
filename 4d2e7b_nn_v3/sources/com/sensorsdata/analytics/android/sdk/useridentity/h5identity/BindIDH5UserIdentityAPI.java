package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import org.json.JSONObject;

public class BindIDH5UserIdentityAPI extends H5UserIdentityAPI {
    private final UserIdentityAPI mUserIdentityApi;

    public BindIDH5UserIdentityAPI(UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityApi = userIdentityAPI;
    }

    public boolean updateIdentities() {
        try {
            JSONObject jSONObject = this.mIdentityJson;
            if (jSONObject != null) {
                jSONObject.remove(Identities.COOKIE_ID);
                this.mUserIdentityApi.getIdentitiesInstance().mergeIdentities(jSONObject);
            }
            mergeIdentities(this.mUserIdentityApi.getIdentitiesInstance().getIdentities(Identities.State.DEFAULT));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return super.updateIdentities();
    }
}
