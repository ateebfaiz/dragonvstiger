package com.sensorsdata.analytics.android.sdk.advert;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.pdns.s.e.c;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.model.SASlinkResponse;
import com.sensorsdata.analytics.android.sdk.advert.model.SATLandingPageType;
import com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataCreateSLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xa.a;

public class SASlinkCreator {
    private String mChannelName = "";
    private String mChannelType = "";
    private String mCommonRedirectURI = "";
    private JSONObject mCustomParams = new JSONObject();
    private Map<String, String> mLandingPage = new HashMap();
    private SATLandingPageType mLandingPageType;
    private String mName = "";
    private String mRedirectURLOnOtherDevice = "";
    private String mRouteParam;
    private JSONObject mSystemParams = new JSONObject();
    private String mTemplateID = "";
    private String mToken = "";
    private String mUriSchemeSuffix = "";
    private String mUtmCampaign = "";
    private String mUtmContent = "";
    private String mUtmMedium = "";
    private String mUtmSource = "";
    private String mUtmTerm = "";

    public SASlinkCreator(String str, String str2, String str3, String str4) {
        this.mTemplateID = str;
        this.mChannelName = str2;
        this.mCommonRedirectURI = str3;
        this.mToken = str4;
    }

    private boolean checkInfo(Context context, SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback, String str) {
        if (sensorsDataCreateSLinkCallback == null) {
            trackSlinkCreate(10005, SADisplayUtil.getStringResource(context, a.f13299a), (SensorsDataCreateSLinkCallback) null);
            return false;
        } else if (!NetworkUtils.isNetworkAvailable(context)) {
            trackSlinkCreate(10002, SADisplayUtil.getStringResource(context, a.f13303e), sensorsDataCreateSLinkCallback);
            return false;
        } else if (TextUtils.isEmpty(str) || (!str.startsWith(c.f18246k) && !str.startsWith(c.f18247l))) {
            trackSlinkCreate(10003, SADisplayUtil.getStringResource(context, a.f13302d), sensorsDataCreateSLinkCallback);
            return false;
        } else if (TextUtils.isEmpty(this.mToken)) {
            trackSlinkCreate(10001, SADisplayUtil.getStringResource(context, a.f13307i), sensorsDataCreateSLinkCallback);
            return false;
        } else if (TextUtils.isEmpty(this.mTemplateID)) {
            trackSlinkCreate(10001, SADisplayUtil.getStringResource(context, a.f13306h), sensorsDataCreateSLinkCallback);
            return false;
        } else if (TextUtils.isEmpty(this.mChannelName)) {
            trackSlinkCreate(10001, SADisplayUtil.getStringResource(context, a.f13300b), sensorsDataCreateSLinkCallback);
            return false;
        } else if (!TextUtils.isEmpty(this.mCommonRedirectURI)) {
            return true;
        } else {
            trackSlinkCreate(10001, SADisplayUtil.getStringResource(context, a.f13301c), sensorsDataCreateSLinkCallback);
            return false;
        }
    }

    private String getChannelType() {
        return this.mChannelType;
    }

    private SASlinkCreator setChannelType(String str) {
        this.mChannelType = str;
        return this;
    }

    /* access modifiers changed from: private */
    public void trackSlinkCreate(int i10, String str, SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        trackSlinkCreate(i10, str, "", "", sensorsDataCreateSLinkCallback);
    }

    public void createSLink(final Context context, final SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        String requestUrl = NetworkUtils.getRequestUrl(AbstractSensorsDataAPI.getConfigOptions().getCustomADChannelUrl(), "slink/dynamic/links");
        try {
            if (checkInfo(context, sensorsDataCreateSLinkCallback, requestUrl)) {
                String project = new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()).getProject();
                HashMap hashMap = new HashMap();
                hashMap.put("token", this.mToken);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("project_name", project);
                jSONObject.put("slink_template_id", this.mTemplateID);
                jSONObject.put("name", getName());
                jSONObject.put("channel_type", "app_share");
                jSONObject.put("channel_name", this.mChannelName);
                jSONObject.put("custom_param", getCustomParams());
                jSONObject.put("system_param", getSystemParams());
                jSONObject.put("route_param", getRouteParam());
                jSONObject.put("fixed_param", new JSONObject().put("channel_utm_campaign", getUtmCampaign()).put("channel_utm_content", getUtmContent()).put("channel_utm_medium", getUtmMedium()).put("channel_utm_source", getUtmSource()).put("channel_utm_term", getUtmTerm()));
                jSONObject.put("uri_scheme_suffix", getUriSchemeSuffix());
                if (getLandingPageType() != null) {
                    jSONObject.put("landing_page_type", getLandingPageType().getTypeName());
                }
                jSONObject.put("other_landing_page_map", new JSONObject(getLandingPage()));
                jSONObject.put("jump_address", this.mRedirectURLOnOtherDevice);
                new RequestHelper.Builder(HttpMethod.POST, requestUrl).header(hashMap).jsonData(jSONObject.toString()).callback(new HttpCallback.JsonCallback() {
                    public void onFailure(int i10, String str) {
                        if (i10 == 0) {
                            i10 = 10006;
                        }
                        SASlinkCreator.this.trackSlinkCreate(i10, str, sensorsDataCreateSLinkCallback);
                    }

                    public void onResponse(JSONObject jSONObject) {
                        String str;
                        String str2;
                        String str3;
                        int i10;
                        String str4;
                        String stringResource = SADisplayUtil.getStringResource(context, a.f13304f);
                        String str5 = "";
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt(Constant.PARAM_OAUTH_CODE, 10004);
                            if (optInt == 0) {
                                String optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, SADisplayUtil.getStringResource(context, a.f13305g));
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    str5 = optJSONObject.optString("slink_id");
                                    str4 = optJSONObject.optString("short_url");
                                } else {
                                    str4 = str5;
                                }
                                str = str4;
                                str3 = optString;
                                str2 = str5;
                            } else {
                                if (optInt != 10004) {
                                    stringResource = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                                }
                                str3 = stringResource;
                                str2 = str5;
                                str = str2;
                            }
                            i10 = optInt;
                        } else {
                            str3 = stringResource;
                            i10 = 10004;
                            str2 = str5;
                            str = str2;
                        }
                        SASlinkCreator.this.trackSlinkCreate(i10, str3, str2, str, sensorsDataCreateSLinkCallback);
                    }
                }).execute();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public JSONObject getCustomParams() {
        return this.mCustomParams;
    }

    public Map<String, String> getLandingPage() {
        return this.mLandingPage;
    }

    public SATLandingPageType getLandingPageType() {
        return this.mLandingPageType;
    }

    public String getName() {
        return this.mName;
    }

    public String getRedirectURLOnOtherDevice() {
        return this.mRedirectURLOnOtherDevice;
    }

    public String getRouteParam() {
        return this.mRouteParam;
    }

    public JSONObject getSystemParams() {
        return this.mSystemParams;
    }

    public String getUriSchemeSuffix() {
        return this.mUriSchemeSuffix;
    }

    public String getUtmCampaign() {
        return this.mUtmCampaign;
    }

    public String getUtmContent() {
        return this.mUtmContent;
    }

    public String getUtmMedium() {
        return this.mUtmMedium;
    }

    public String getUtmSource() {
        return this.mUtmSource;
    }

    public String getUtmTerm() {
        return this.mUtmTerm;
    }

    public SASlinkCreator setCustomParams(JSONObject jSONObject) {
        this.mCustomParams = jSONObject;
        return this;
    }

    public SASlinkCreator setLandingPage(Map<String, String> map) {
        this.mLandingPage = map;
        return this;
    }

    public SASlinkCreator setLandingPageType(SATLandingPageType sATLandingPageType) {
        this.mLandingPageType = sATLandingPageType;
        return this;
    }

    public SASlinkCreator setName(String str) {
        this.mName = str;
        return this;
    }

    public SASlinkCreator setRedirectURLOnOtherDevice(String str) {
        this.mRedirectURLOnOtherDevice = str;
        return this;
    }

    public SASlinkCreator setRouteParam(String str) {
        this.mRouteParam = str;
        return this;
    }

    public SASlinkCreator setSystemParams(JSONObject jSONObject) {
        this.mSystemParams = jSONObject;
        return this;
    }

    public SASlinkCreator setUriSchemeSuffix(String str) {
        this.mUriSchemeSuffix = str;
        return this;
    }

    public SASlinkCreator setUtmCampaign(String str) {
        this.mUtmCampaign = str;
        return this;
    }

    public SASlinkCreator setUtmContent(String str) {
        this.mUtmContent = str;
        return this;
    }

    public SASlinkCreator setUtmMedium(String str) {
        this.mUtmMedium = str;
        return this;
    }

    public SASlinkCreator setUtmSource(String str) {
        this.mUtmSource = str;
        return this;
    }

    public SASlinkCreator setUtmTerm(String str) {
        this.mUtmTerm = str;
        return this;
    }

    /* access modifiers changed from: private */
    public void trackSlinkCreate(int i10, String str, String str2, String str3, SensorsDataCreateSLinkCallback sensorsDataCreateSLinkCallback) {
        SASlinkResponse sASlinkResponse = new SASlinkResponse();
        sASlinkResponse.slink = str3;
        sASlinkResponse.statusCode = i10;
        sASlinkResponse.message = str;
        sASlinkResponse.slinkID = str2;
        sASlinkResponse.commonRedirectURI = this.mCommonRedirectURI;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject put = jSONObject.put(SAAdvertConstants.Properties.DYNAMIC_SLINK_CHANNEL_TYPE, "app_share").put(SAAdvertConstants.Properties.DYNAMIC_SLINK_SOURCE, "Android").put(SAAdvertConstants.Properties.DYNAMIC_SLINK_CHANNEL_NAME, this.mChannelName).put(SAAdvertConstants.Properties.DYNAMIC_SLINK_DATA, "").put(SAAdvertConstants.Properties.DYNAMIC_SLINK_SHORT_URL, str3).put(SAAdvertConstants.Properties.DYNAMIC_SLINK_STATUS, i10);
            if (str.length() > 200) {
                str = str.substring(0, 200);
            }
            put.put(SAAdvertConstants.Properties.DYNAMIC_SLINK_MSG, str).put(SAAdvertConstants.Properties.SLINK_ID, str2).put(SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.mTemplateID).put(SAAdvertConstants.Properties.SLINK_TYPE, "dynamic");
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        SensorsDataAPI.sharedInstance().track(SAAdvertConstants.EventName.DYNAMIC_SLINK_CREATE, jSONObject);
        if (sensorsDataCreateSLinkCallback != null) {
            sensorsDataCreateSLinkCallback.onReceive(sASlinkResponse);
        }
    }
}
