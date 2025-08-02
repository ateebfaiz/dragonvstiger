package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import java.util.Iterator;

public class SignUpH5UserIdentityAPI extends H5UserIdentityAPI {
    private final EventType eventType;
    private final UserIdentityAPI mUserIdentityApi;

    public SignUpH5UserIdentityAPI(UserIdentityAPI userIdentityAPI, EventType eventType2) {
        this.mUserIdentityApi = userIdentityAPI;
        this.eventType = eventType2;
    }

    private boolean traversalSearch(String str) {
        Iterator<String> keys = this.mIdentityJson.keys();
        String str2 = "";
        int i10 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                String optString = this.mIdentityJson.optString(next);
                if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                    i10++;
                    str2 = next;
                }
            }
        }
        if (i10 == 1) {
            return this.mUserIdentityApi.loginWithKeyBack(str2, str);
        }
        return false;
    }

    public boolean updateIdentities() {
        try {
            if (TextUtils.isEmpty(this.mEventObject.optString("identities"))) {
                if (!this.mUserIdentityApi.loginWithKeyBack(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, this.mEventObject.optString("distinct_id"))) {
                    return false;
                }
            } else if (this.mIdentityJson.has(this.mUserIdentityApi.getIdentitiesInstance().getLoginIDKey())) {
                String optString = this.mIdentityJson.optString(this.mUserIdentityApi.getIdentitiesInstance().getLoginIDKey());
                UserIdentityAPI userIdentityAPI = this.mUserIdentityApi;
                if (!userIdentityAPI.loginWithKeyBack(userIdentityAPI.getIdentitiesInstance().getLoginIDKey(), optString)) {
                    return false;
                }
            } else {
                String optString2 = this.mEventObject.optString("login_id");
                if (!TextUtils.isEmpty(optString2)) {
                    String[] split = optString2.split("\\+");
                    if (split.length == 2) {
                        String str = split[0];
                        String str2 = split[1];
                        String optString3 = this.mIdentityJson.optString(str);
                        if (this.mIdentityJson.has(str) && !TextUtils.isEmpty(optString3) && optString3.equals(str2) && !this.mUserIdentityApi.loginWithKeyBack(str, str2)) {
                            return false;
                        }
                    } else if (!traversalSearch(optString2)) {
                        return false;
                    }
                }
            }
            String loginId = this.mUserIdentityApi.getIdentitiesInstance().getLoginId();
            if (TextUtils.isEmpty(loginId)) {
                this.mEventObject.put("login_id", loginId);
            }
            mergeIdentities(this.mUserIdentityApi.getIdentities(this.eventType));
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }
}
