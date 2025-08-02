package com.sensorsdata.analytics.android.sdk.advert.deeplink;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.pdns.s.e.c;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONObject;
import xa.a;

public class DeferredDeepLinkHelper {
    public static void request(JSONObject jSONObject, SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback, String str, boolean z10) {
        boolean z11;
        final long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str) || (!str.startsWith(c.f18246k) && !str.startsWith(c.f18247l))) {
            z11 = false;
        } else {
            z11 = true;
        }
        final SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
        if (z11 || (!TextUtils.isEmpty(sharedInstance.getServerUrl()) && sharedInstance.getServerUrl().startsWith("http"))) {
            HttpMethod httpMethod = HttpMethod.POST;
            if (!z11) {
                str = sharedInstance.getServerUrl();
            }
            RequestHelper.Builder jsonData = new RequestHelper.Builder(httpMethod, NetworkUtils.getRequestUrl(str, "slink/ddeeplink")).jsonData(jSONObject.toString());
            final boolean z12 = z10;
            final JSONObject jSONObject2 = jSONObject;
            final SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback2 = sensorsDataDeferredDeepLinkCallback;
            jsonData.callback(new HttpCallback.JsonCallback() {
                private String adChannel;
                private String adSlinkId;
                private String adSlinkTemplateId;
                private String adSlinkType;
                private JSONObject customParams;
                private String errorMsg;
                private boolean isSuccess = false;
                private String parameter;

                public void onAfter() {
                    if (z12) {
                        ChannelUtils.saveDeepLinkInfo();
                    }
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    final JSONObject jSONObject = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(this.parameter)) {
                            jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_OPTIONS, this.parameter);
                        }
                        if (!TextUtils.isEmpty(this.errorMsg)) {
                            jSONObject.put(SAAdvertConstants.Properties.MATCH_FAIL_REASON, this.errorMsg);
                        }
                        if (!TextUtils.isEmpty(this.adChannel)) {
                            jSONObject.put(SAAdvertConstants.Properties.CHANNEL_INFO, this.adChannel);
                        }
                        if (!TextUtils.isEmpty(this.adSlinkId)) {
                            jSONObject.put(SAAdvertConstants.Properties.SLINK_ID, this.adSlinkId);
                        }
                        jSONObject.put(SAAdvertConstants.Properties.MATCH_TYPE, "deferred deeplink");
                        jSONObject.put("$event_duration", TimeUtils.duration((float) currentTimeMillis));
                        jSONObject.put(SAAdvertConstants.Properties.DEVICE_INFO, jSONObject2.get("ids"));
                        if (!TextUtils.isEmpty(this.adSlinkTemplateId)) {
                            jSONObject.put(SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.adSlinkTemplateId);
                        }
                        if (!TextUtils.isEmpty(this.adSlinkType)) {
                            jSONObject.put(SAAdvertConstants.Properties.SLINK_TYPE, this.adSlinkType);
                        }
                        JSONObject jSONObject2 = this.customParams;
                        if (jSONObject2 != null) {
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, this.customParams.toString());
                            }
                        }
                        SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback = sensorsDataDeferredDeepLinkCallback2;
                        if (sensorsDataDeferredDeepLinkCallback != null) {
                            try {
                                if (sensorsDataDeferredDeepLinkCallback.onReceive(new SADeepLinkObject(this.parameter, this.customParams, this.adChannel, this.isSuccess, currentTimeMillis)) && this.isSuccess) {
                                    final JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(SAAdvertConstants.Properties.DEEPLINK_OPTIONS, this.parameter);
                                    if (!TextUtils.isEmpty(this.adSlinkId)) {
                                        jSONObject3.put(SAAdvertConstants.Properties.SLINK_ID, this.adSlinkId);
                                    }
                                    JSONObject jSONObject4 = this.customParams;
                                    if (jSONObject4 != null && jSONObject4.length() > 0) {
                                        jSONObject3.put(SAAdvertConstants.Properties.SLINK_CUSTOM_PARAMS, this.customParams.toString());
                                    }
                                    if (!TextUtils.isEmpty(this.adSlinkTemplateId)) {
                                        jSONObject.put(SAAdvertConstants.Properties.SLINK_TEMPLATE_ID, this.adSlinkTemplateId);
                                    }
                                    if (!TextUtils.isEmpty(this.adSlinkType)) {
                                        jSONObject.put(SAAdvertConstants.Properties.SLINK_TYPE, this.adSlinkType);
                                    }
                                    JSONUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject3);
                                    SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                                        public void run() {
                                            SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(SAAdvertConstants.EventName.DEFERRED_DEEPLINK_JUMP).setProperties(jSONObject3));
                                        }
                                    });
                                }
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        } else if (this.isSuccess) {
                            jSONObject.put(SAAdvertConstants.Properties.MATCH_FAIL_REASON, SADisplayUtil.getStringResource(sharedInstance.getSAContextManager().getContext(), a.f13322x));
                        }
                        JSONUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
                        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                            public void run() {
                                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(SAAdvertConstants.EventName.MATCH_RESULT).setProperties(jSONObject));
                            }
                        });
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }

                public void onFailure(int i10, String str) {
                    this.errorMsg = str;
                }

                public void onResponse(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        this.errorMsg = "response is null";
                    } else if (jSONObject.optInt(Constant.PARAM_OAUTH_CODE) == 0) {
                        this.isSuccess = true;
                        ChannelUtils.parseParams(JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
                        this.parameter = jSONObject.optString("parameter");
                        this.adChannel = jSONObject.optString("ad_channel");
                        this.adSlinkId = jSONObject.optString("ad_slink_id");
                        this.adSlinkTemplateId = jSONObject.optString("slink_template_id");
                        this.adSlinkType = jSONObject.optString("slink_type");
                        this.customParams = jSONObject.optJSONObject("custom_params");
                    } else {
                        this.errorMsg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                }
            }).execute();
        }
    }
}
