package com.zing.zalo.zalosdk.oauth;

import android.content.Context;
import com.zing.zalo.zalosdk.core.helper.Storage;

public class OauthStorage extends Storage {
    private final String PREF_GUEST_DEVICE_ID = "PREF_GUEST_DEVICE_ID";
    private final String PREF_IS_PROTECTED = "PREF_IS_PROTECTED";
    private final String PREF_OAUTH_CODE = "PREFERECE_ZALO_SDK_OAUTH_CODE";
    private final String PREF_OAUTH_CODE_CHANNEL = "PREFERECE_ZALO_SDK_OAUTH_CODE_CHANNEL";
    private final String PREF_SOCIAL_ID = "PREFERECE_SOCIAL_ID";
    private final String PREF_VIEWER = "PREFERECE_VIEWER";
    private final String PREF_ZALO_DISPLAY_NAME = "PREFERECE_ZALO_SDK_ZALO_DISPLAY_NAME";

    public OauthStorage(Context context) {
        super(context);
    }

    public void clearGuestSession() {
        setString("PREFERECE_ZALO_SDK_OAUTH_CODE", "");
    }

    public String getGuestDeviceId() {
        return getString("PREF_GUEST_DEVICE_ID");
    }

    public int getIsProtected() {
        return getInt("PREF_IS_PROTECTED");
    }

    public String getLatestLoginChannel() {
        return getString("PREFERECE_ZALO_SDK_OAUTH_CODE_CHANNEL");
    }

    public String getOAuthCode() {
        return getString("PREFERECE_ZALO_SDK_OAUTH_CODE");
    }

    public String getSocialId() {
        return getString("PREFERECE_SOCIAL_ID");
    }

    public String getViewer() {
        return getString("PREFERECE_VIEWER");
    }

    public String getZaloDisplayName() {
        return getString("PREFERECE_ZALO_SDK_ZALO_DISPLAY_NAME");
    }

    public void setGuestDeviceId(String str) {
        setString("PREF_GUEST_DEVICE_ID", str);
    }

    public void setIsProtected(int i10) {
        setInt("PREF_IS_PROTECTED", i10);
    }

    public void setLoginChannel(String str) {
        setString("PREFERECE_ZALO_SDK_OAUTH_CODE_CHANNEL", str);
    }

    public void setSocialId(String str) {
        setString("PREFERECE_SOCIAL_ID", str);
    }

    public void setViewer(String str) {
        setString("PREFERECE_VIEWER", str);
    }

    public void setZaloDisplayName(String str) {
        setString("PREFERECE_ZALO_SDK_ZALO_DISPLAY_NAME", str);
    }
}
