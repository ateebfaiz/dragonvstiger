package com.sensorsdata.analytics.android.sdk.useridentity;

import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import org.json.JSONObject;

public interface IUserIdentityAPI {
    public static final String BIND_ID = "$BindID";
    public static final String UNBIND_ID = "$UnbindID";

    void bind(String str, String str2) throws InvalidDataException;

    @Deprecated
    String getAnonymousId();

    String getDistinctId();

    JSONObject getIdentities();

    String getLoginId();

    @Deprecated
    void identify(String str);

    void login(String str);

    void login(String str, JSONObject jSONObject);

    @Deprecated
    void loginWithKey(String str, String str2);

    @Deprecated
    void loginWithKey(String str, String str2, JSONObject jSONObject);

    void logout();

    @Deprecated
    void resetAnonymousId();

    void resetAnonymousIdentity(String str);

    void unbind(String str, String str2) throws InvalidDataException;
}
