package com.zing.zalo.zalosdk.oauth;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.zing.zalo.devicetrackingsdk.DeviceTracking;
import com.zing.zalo.zalosdk.core.exception.InitializedException;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.type.LangType;
import com.zing.zalo.zalosdk.payment.direct.Utils;
import org.json.JSONObject;

public class ZaloSDK {
    public static ZaloSDK Instance = new ZaloSDK();
    private boolean bIsInitialized = false;
    private Authenticator mAuthenticator;
    private LocalizedString mLocalizedString = new LocalizedString();
    private OauthStorage mStorage;
    private ZaloAPIService zaloAPIService;

    ZaloSDK() {
    }

    /* access modifiers changed from: protected */
    public void authenticateZaloPlugin(Activity activity, String str, OAuthCompleteListener oAuthCompleteListener) {
        checkInitialize();
        this.mAuthenticator.authenticate(activity, LoginVia.APP_OR_WEB, str, true, oAuthCompleteListener);
    }

    public void authenticateZaloWithAuthenType(Activity activity, LoginVia loginVia, String str, JSONObject jSONObject, OAuthCompleteListener oAuthCompleteListener) {
        checkInitialize();
        this.mAuthenticator.authenticate(activity, loginVia, str, false, jSONObject, oAuthCompleteListener);
    }

    public void checkInitialize() {
        if (!this.bIsInitialized) {
            throw new InitializedException("Missing call declare com.zing.zalo.zalosdk.oauth.ZaloSDKApplication in Application or call wrap init");
        }
    }

    public void clearGuestSession() {
        checkInitialize();
        if (this.mStorage.getLatestLoginChannel().equals(LoginChannel.GUEST.toString())) {
            this.mStorage.clearGuestSession();
        }
    }

    public void getAccessTokenByOAuthCode(Context context, String str, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        checkInitialize();
        this.zaloAPIService.getAccessTokenByOAuthCode(context, str, str2, zaloOpenAPICallback);
    }

    public void getAccessTokenByRefreshToken(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback) {
        checkInitialize();
        this.zaloAPIService.getAccessTokenByRefreshToken(context, str, zaloOpenAPICallback);
    }

    public long getAppID() {
        try {
            return Long.parseLong(ZaloSDKApplication.appID);
        } catch (Exception unused) {
            return 0;
        }
    }

    public Authenticator getAuthenticator() {
        return this.mAuthenticator;
    }

    public DeviceTracking getBaseAppInfo() {
        return DeviceTracking.getInstance();
    }

    public String getDeviceId() {
        return DeviceTracking.getInstance().getDeviceId();
    }

    public void getFriendListInvitable(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        checkInitialize();
        this.zaloAPIService.getFriendListInvitable(context, str, i10, i11, zaloOpenAPICallback, strArr);
    }

    public void getFriendListUsedApp(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        checkInitialize();
        this.zaloAPIService.getFriendListUsedApp(context, str, i10, i11, zaloOpenAPICallback, strArr);
    }

    public String getGrantType(boolean z10) {
        boolean latestLoginChannelIsGuest = latestLoginChannelIsGuest();
        if (z10) {
            if (latestLoginChannelIsGuest) {
                return "guest_oauth_code";
            }
            return "authorization_code";
        } else if (latestLoginChannelIsGuest) {
            return "guest_refresh_token";
        } else {
            return "refresh_token";
        }
    }

    public String getGuestDeviceId() {
        checkInitialize();
        return this.mStorage.getGuestDeviceId();
    }

    public String getGuestSession() {
        checkInitialize();
        if (this.mStorage.getLatestLoginChannel().equals(LoginChannel.GUEST.toString())) {
            return this.mStorage.getOAuthCode();
        }
        return "";
    }

    public String getLatestLoginChannel() {
        return this.mStorage.getLatestLoginChannel();
    }

    public LocalizedString getLocalizedString() {
        return this.mLocalizedString;
    }

    public OauthStorage getOauthStorage() {
        return this.mStorage;
    }

    public String getPrivateKey() {
        return DeviceTracking.getInstance().getPrivateKey();
    }

    public void getProfile(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        checkInitialize();
        this.zaloAPIService.getProfile(context, str, zaloOpenAPICallback, strArr);
    }

    public String getSDKId() {
        return DeviceTracking.getInstance().getSDKId();
    }

    public String getSocialId() {
        checkInitialize();
        return this.mStorage.getSocialId();
    }

    public String getVersion() {
        return "4.24.1101";
    }

    public String getZaloDisplayname() {
        checkInitialize();
        return this.mStorage.getZaloDisplayName();
    }

    public void getZaloLoginStatus(GetZaloLoginStatus getZaloLoginStatus) {
        checkInitialize();
        this.mAuthenticator.getZaloLoginStatus(getZaloLoginStatus);
    }

    /* access modifiers changed from: protected */
    public synchronized void initialize(Application application) {
        if (!this.bIsInitialized) {
            Context applicationContext = application.getApplicationContext();
            this.mStorage = new OauthStorage(applicationContext);
            this.mAuthenticator = new Authenticator(applicationContext, this.mStorage, this.mLocalizedString);
            this.bIsInitialized = true;
            this.zaloAPIService = new ZaloAPIService(this.mStorage);
        }
    }

    public void inviteFriendUseApp(Context context, String str, String[] strArr, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        checkInitialize();
        this.zaloAPIService.inviteFriendUseApp(context, str, strArr, str2, zaloOpenAPICallback);
    }

    public boolean isAuthenticate(String str, ValidateCallback validateCallback) {
        checkInitialize();
        return this.mAuthenticator.isAuthenticate(str, validateCallback);
    }

    public boolean isGuestSessionValid(String str, ValidateCallback validateCallback) {
        checkInitialize();
        return this.mAuthenticator.isGuestSessionValid(str, validateCallback);
    }

    public boolean latestLoginChannelIsGuest() {
        return LoginChannel.GUEST.toString().equals(this.mStorage.getLatestLoginChannel());
    }

    public final boolean onActivityResult(Activity activity, int i10, int i11, Intent intent) {
        return this.mAuthenticator.onActivityResult(activity, i10, i11, intent);
    }

    public void registerZalo(Activity activity, OAuthCompleteListener oAuthCompleteListener) {
        checkInitialize();
        this.mAuthenticator.registerZalo(activity, oAuthCompleteListener);
    }

    public void setApplicationID(long j10) {
        ZaloSDKApplication.appID = String.valueOf(j10);
    }

    public void setLanguageSDK(Context context, LangType langType) {
        Utils.setLanguage(context, langType);
    }

    public void setLocalizedString(LocalizedString localizedString) {
        this.mLocalizedString = localizedString;
    }

    public void setLogLevel(int i10) {
        Log.setLogLevel(i10);
    }

    public void setOauthCompletedListener(OAuthCompleteListener oAuthCompleteListener) {
        checkInitialize();
        this.mAuthenticator.setOAuthCompleteListener(oAuthCompleteListener);
    }

    public void setUseWeakReferenceCallback(boolean z10) {
        checkInitialize();
        this.mAuthenticator.setUseWeakReferenceCallback(z10);
    }

    public void unauthenticate() {
        checkInitialize();
        this.mAuthenticator.unauthenticate();
    }

    public void getDeviceId(DeviceTracking.GetInfoListener getInfoListener) {
        DeviceTracking.getInstance().getDeviceId(getInfoListener);
    }

    public void authenticateZaloWithAuthenType(Activity activity, LoginVia loginVia, String str, OAuthCompleteListener oAuthCompleteListener) {
        authenticateZaloWithAuthenType(activity, loginVia, str, (JSONObject) null, oAuthCompleteListener);
    }
}
