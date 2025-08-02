package com.sensorsdata.analytics.android.sdk.useridentity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;

public class LoginIDAndKey {
    public static final String LOGIN_ID_KEY_DEFAULT = "$identity_login_id";
    private static final String TAG = "SA.LoginIDAndKey";

    public static boolean isInValidLogin(String str, String str2, String str3, String str4, String str5) {
        if (isInValidLoginIDKey(str) || isInValidLoginID(str2, str5)) {
            return true;
        }
        if (!str.equals(str3) || !str2.equals(str4)) {
            return false;
        }
        SALog.i(TAG, "login key and value already exist!");
        return true;
    }

    private static boolean isInValidLoginID(String str, String str2) {
        try {
            SADataHelper.assertDistinctId(str);
            if (!str.equals(str2)) {
                return false;
            }
            SALog.i(TAG, "login value cannot be an anonymous id!");
            return true;
        } catch (Exception e10) {
            SALog.i(TAG, (Throwable) e10);
            return true;
        }
    }

    private static boolean isInValidLoginIDKey(String str) {
        if (!SADataHelper.assertPropertyKey(str)) {
            return true;
        }
        if (!Identities.ANONYMOUS_ID.equals(str) && !Identities.ANDROID_UUID.equals(str) && !Identities.ANDROID_ID.equals(str)) {
            return false;
        }
        SALog.i(TAG, "login key cannot be an anonymous id or android_uuid or android_id!");
        return true;
    }

    public static String jointLoginID(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(LOGIN_ID_KEY_DEFAULT)) {
            return str2;
        }
        return str + "+" + str2;
    }

    private void restoreDefaultLoginIDKey() {
        setLoginIDKey(LOGIN_ID_KEY_DEFAULT);
    }

    public String getJointLoginID() {
        return jointLoginID(getLoginIDKey(), getLoginId());
    }

    public String getLoginIDKey() {
        return DbAdapter.getInstance().getLoginIdKey();
    }

    public String getLoginId() {
        return DbAdapter.getInstance().getLoginId();
    }

    public void init(String str) {
        if (isInValidLoginIDKey(str)) {
            restoreDefaultLoginIDKey();
        }
    }

    public void removeLoginKeyAndID() {
        setLoginIDKey("");
        setLoginId("");
    }

    public void setLoginIDKey(String str) {
        DbAdapter.getInstance().commitLoginIdKey(str);
    }

    public void setLoginId(String str) {
        DbAdapter.getInstance().commitLoginId(str);
    }

    public boolean setLoginKeyAndID(String str, String str2, String str3) {
        if (isInValidLogin(str, str2, getLoginIDKey(), getLoginId(), str3)) {
            return false;
        }
        setLoginIDKey(str);
        setLoginId(str2);
        String loginId = getLoginId();
        String loginIDKey = getLoginIDKey();
        if (str2.equals(loginId) && str.equals(loginIDKey)) {
            return true;
        }
        setLoginId(str2);
        setLoginIDKey(str);
        return true;
    }
}
