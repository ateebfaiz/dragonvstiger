package com.sensorsdata.analytics.android.sdk.advert.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class SensorsDataDeepLink extends AbsDeepLink {
    /* access modifiers changed from: private */
    public String adSlinkId;
    /* access modifiers changed from: private */
    public String adSlinkTemplateId;
    /* access modifiers changed from: private */
    public String adSlinkType;
    private final String customADChannelUrl;
    /* access modifiers changed from: private */
    public JSONObject customParams;
    /* access modifiers changed from: private */
    public String errorMsg;
    /* access modifiers changed from: private */
    public String pageParams;
    private final String project;
    private final String serverUrl;
    /* access modifiers changed from: private */
    public boolean success;

    public SensorsDataDeepLink(Intent intent, String str, String str2) {
        super(intent);
        this.serverUrl = str;
        this.customADChannelUrl = str2;
        this.project = new ServerUrl(str).getProject();
    }

    private String getSlinkRequestUrl() {
        if (!TextUtils.isEmpty(this.customADChannelUrl)) {
            return NetworkUtils.getRequestUrl(this.customADChannelUrl, "slink/config/query");
        }
        return "";
    }

    private boolean isSlink(Uri uri, String str) {
        List<String> pathSegments;
        if (TextUtils.isEmpty(str) || (pathSegments = uri.getPathSegments()) == null || pathSegments.isEmpty() || !pathSegments.get(0).equals("slink")) {
            return false;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        if (NetworkUtils.compareMainDomain(str, host) || host.equals(DbParams.DATABASE_NAME)) {
            return true;
        }
        return false;
    }

    public String getRequestUrl() {
        int lastIndexOf;
        if (TextUtils.isEmpty(this.serverUrl) || (lastIndexOf = this.serverUrl.lastIndexOf(DomExceptionUtils.SEPARATOR)) == -1) {
            return "";
        }
        return this.serverUrl.substring(0, lastIndexOf) + "/sdk/deeplink/param";
    }

    public void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_URL, getDeepLinkUrl());
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void parseDeepLink(Intent intent) {
        String str;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String lastPathSegment = data.getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                final long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put("key", lastPathSegment);
                hashMap.put("system_type", "ANDROID");
                hashMap.put("project", this.project);
                HttpMethod httpMethod = HttpMethod.GET;
                if (isSlink(data, NetworkUtils.getHost(this.customADChannelUrl))) {
                    str = getSlinkRequestUrl();
                } else {
                    str = getRequestUrl();
                }
                new RequestHelper.Builder(httpMethod, str).params(hashMap).callback(new HttpCallback.JsonCallback() {
                    public void onAfter() {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        final JSONObject jSONObject = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.pageParams)) {
                                jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_OPTIONS, SensorsDataDeepLink.this.pageParams);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                jSONObject.put(SAAdvertConstants.Properties.MATCH_FAIL_REASON, SensorsDataDeepLink.this.errorMsg);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.adSlinkId)) {
                                jSONObject.put(SAAdvertConstants.Properties.SLINK_ID, SensorsDataDeepLink.this.adSlinkId);
                            }
                            jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_URL, SensorsDataDeepLink.this.getDeepLinkUrl());
                            jSONObject.put("$event_duration", TimeUtils.duration((float) currentTimeMillis));
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.adSlinkTemplateId)) {
                                jSONObject.put(SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, SensorsDataDeepLink.this.adSlinkTemplateId);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.adSlinkType)) {
                                jSONObject.put(SAAdvertConstants.Properties.SLINK_TYPE, SensorsDataDeepLink.this.adSlinkType);
                            }
                            if (SensorsDataDeepLink.this.customParams != null && SensorsDataDeepLink.this.customParams.length() > 0) {
                                jSONObject.put(SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, SensorsDataDeepLink.this.customParams.toString());
                            }
                        } catch (JSONException e10) {
                            SALog.printStackTrace(e10);
                        }
                        JSONUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
                        SensorsDataDeepLink sensorsDataDeepLink = SensorsDataDeepLink.this;
                        DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback = sensorsDataDeepLink.mCallBack;
                        if (onDeepLinkParseFinishCallback != null) {
                            onDeepLinkParseFinishCallback.onFinish(DeepLinkManager.DeepLinkType.SENSORSDATA, sensorsDataDeepLink.pageParams, SensorsDataDeepLink.this.customParams, SensorsDataDeepLink.this.success, currentTimeMillis);
                        }
                        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                            public void run() {
                                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(SAAdvertConstants.EventName.MATCH_RESULT).setProperties(jSONObject));
                            }
                        });
                    }

                    public void onFailure(int i10, String str) {
                        String unused = SensorsDataDeepLink.this.errorMsg = str;
                        boolean unused2 = SensorsDataDeepLink.this.success = false;
                    }

                    public void onResponse(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            boolean unused = SensorsDataDeepLink.this.success = true;
                            ChannelUtils.parseParams(JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
                            String unused2 = SensorsDataDeepLink.this.pageParams = jSONObject.optString("page_params");
                            String unused3 = SensorsDataDeepLink.this.errorMsg = jSONObject.optString("errorMsg");
                            if (TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                String unused4 = SensorsDataDeepLink.this.errorMsg = jSONObject.optString("error_msg");
                            }
                            String unused5 = SensorsDataDeepLink.this.adSlinkId = jSONObject.optString("ad_slink_id");
                            String unused6 = SensorsDataDeepLink.this.adSlinkTemplateId = jSONObject.optString("slink_template_id");
                            String unused7 = SensorsDataDeepLink.this.adSlinkType = jSONObject.optString("slink_type");
                            JSONObject unused8 = SensorsDataDeepLink.this.customParams = jSONObject.optJSONObject("custom_params");
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                boolean unused9 = SensorsDataDeepLink.this.success = false;
                                return;
                            }
                            return;
                        }
                        boolean unused10 = SensorsDataDeepLink.this.success = false;
                    }
                }).execute();
            }
        }
    }
}
