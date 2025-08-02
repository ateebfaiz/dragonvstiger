package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

public interface IActivityHandler {
    void addSessionCallbackParameter(String str, String str2);

    void addSessionPartnerParameter(String str, String str2);

    void disableThirdPartySharing();

    void finishedTrackingActivity(ResponseData responseData);

    void gdprForgetMe();

    ActivityState getActivityState();

    String getAdid();

    AdjustConfig getAdjustConfig();

    AdjustAttribution getAttribution();

    Context getContext();

    a getDeviceInfo();

    SessionParameters getSessionParameters();

    void gotOptOutResponse();

    void init(AdjustConfig adjustConfig);

    boolean isEnabled();

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void onPause();

    void onResume();

    void readOpenUrl(Uri uri, long j10);

    void removeSessionCallbackParameter(String str);

    void removeSessionPartnerParameter(String str);

    void resetSessionCallbackParameters();

    void resetSessionPartnerParameters();

    void sendFirstPackages();

    void sendInstallReferrer(ReferrerDetails referrerDetails, String str);

    void sendPreinstallReferrer();

    void sendReftagReferrer();

    void setAskingAttribution(boolean z10);

    void setEnabled(boolean z10);

    void setOfflineMode(boolean z10);

    void setPushToken(String str, boolean z10);

    void teardown();

    void trackAdRevenue(AdjustAdRevenue adjustAdRevenue);

    void trackAdRevenue(String str, JSONObject jSONObject);

    void trackEvent(AdjustEvent adjustEvent);

    void trackMeasurementConsent(boolean z10);

    void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription);

    void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing);

    boolean updateAttributionI(AdjustAttribution adjustAttribution);
}
