package com.sensorsdata.analytics.android.sdk.advert.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants;
import com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkManager {
    public static final String IS_ANALYTICS_DEEPLINK = "is_analytics_deeplink";
    private static JSONObject mCacheProperties;
    /* access modifiers changed from: private */
    public static SensorsDataDeepLinkCallback mDeepLinkCallback;
    private static DeepLinkProcessor mDeepLinkProcessor;
    /* access modifiers changed from: private */
    public static SensorsDataDeferredDeepLinkCallback mDeferredDeepLinkCallback;
    private static boolean mEnableDeepLinkInstallSource;
    private static boolean mIsDeepLink;

    public enum DeepLinkType {
        CHANNEL,
        SENSORSDATA
    }

    public interface OnDeepLinkParseFinishCallback {
        void onFinish(DeepLinkType deepLinkType, String str, JSONObject jSONObject, boolean z10, long j10);
    }

    private static void cacheProperties() {
        if (mCacheProperties == null) {
            mCacheProperties = new JSONObject();
        }
        mergeDeepLinkProperty(mCacheProperties);
    }

    private static DeepLinkProcessor createDeepLink(Intent intent, String str, String str2) {
        if (intent == null) {
            return null;
        }
        if (isSensorsDataDeepLink(intent, new ServerUrl(str).getHost(), NetworkUtils.getHost(str2))) {
            return new SensorsDataDeepLink(intent, str, str2);
        }
        if (isUtmDeepLink(intent)) {
            return new ChannelDeepLink(intent);
        }
        return null;
    }

    public static void enableDeepLinkInstallSource(boolean z10) {
        mEnableDeepLinkInstallSource = z10;
    }

    public static boolean isDeepLink(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction()) || intent.getData() == null) {
            return false;
        }
        return true;
    }

    private static boolean isParsedDeepLink(Activity activity) {
        try {
            if (SensorsDataUtils.isUniApp()) {
                if (!ChannelUtils.isDeepLinkBlackList(activity)) {
                }
                return false;
            }
            Intent intent = activity.getIntent();
            if (!(intent == null || intent.getData() == null)) {
                return intent.getBooleanExtra(IS_ANALYTICS_DEEPLINK, false);
            }
        } catch (Throwable th) {
            SALog.i(SAAdvertConstants.TAG, th.getMessage());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r5 = r5.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isSensorsDataDeepLink(android.content.Intent r5, java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = isDeepLink(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r5 = r5.getData()
            java.util.List r0 = r5.getPathSegments()
            if (r0 == 0) goto L_0x006e
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x006e
            java.lang.String r5 = r5.getHost()
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "slink"
            boolean r2 = r2.equals(r3)
            r3 = 1
            java.lang.String r4 = "sensorsdata"
            if (r2 == 0) goto L_0x0047
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0046
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 != 0) goto L_0x0046
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.compareMainDomain(r7, r5)
            if (r6 != 0) goto L_0x0045
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0046
        L_0x0045:
            r1 = r3
        L_0x0046:
            return r1
        L_0x0047:
            java.lang.Object r7 = r0.get(r1)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r0 = "sd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x006e
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x006e
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x006e
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x006d
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x006e
        L_0x006d:
            r1 = r3
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.isSensorsDataDeepLink(android.content.Intent, java.lang.String, java.lang.String):boolean");
    }

    private static boolean isUtmDeepLink(Intent intent) {
        if (!isDeepLink(intent)) {
            return false;
        }
        Uri data = intent.getData();
        if (data.isOpaque()) {
            SALog.d("ChannelDeepLink", data + " isOpaque");
            return false;
        }
        Set<String> queryParameterNames = data.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.size() <= 0) {
            return false;
        }
        return ChannelUtils.hasLinkUtmProperties(queryParameterNames);
    }

    public static void mergeCacheProperties(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null && (jSONObject2 = mCacheProperties) != null && jSONObject2.length() != 0) {
            JSONUtils.mergeJSONObject(mCacheProperties, jSONObject);
            mCacheProperties = null;
        }
    }

    public static void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            DeepLinkProcessor deepLinkProcessor = mDeepLinkProcessor;
            if (deepLinkProcessor != null) {
                deepLinkProcessor.mergeDeepLinkProperty(jSONObject);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void parseDeepLink(Activity activity, final boolean z10) {
        try {
            if (!isDeepLink(activity.getIntent())) {
                return;
            }
            if (!isParsedDeepLink(activity)) {
                Intent intent = activity.getIntent();
                DeepLinkProcessor createDeepLink = createDeepLink(intent, SensorsDataAPI.sharedInstance().getServerUrl(), AbstractSensorsDataAPI.getConfigOptions().getCustomADChannelUrl());
                mDeepLinkProcessor = createDeepLink;
                if (createDeepLink != null) {
                    ChannelUtils.clearUtm();
                    mIsDeepLink = true;
                    mDeepLinkProcessor.setDeepLinkParseFinishCallback(new OnDeepLinkParseFinishCallback() {
                        public void onFinish(DeepLinkType deepLinkType, String str, JSONObject jSONObject, boolean z10, long j10) {
                            if (z10) {
                                ChannelUtils.saveDeepLinkInfo();
                            }
                            SAEventBus.getInstance().post(SAEventBusConstants.Tag.DEEPLINK_LAUNCH, ChannelUtils.getLatestUtmProperties());
                            if (deepLinkType == DeepLinkType.SENSORSDATA) {
                                try {
                                    if (DeepLinkManager.mDeferredDeepLinkCallback != null) {
                                        DeepLinkManager.mDeferredDeepLinkCallback.onReceive(new SADeepLinkObject(str, jSONObject, "", z10, j10));
                                    } else if (DeepLinkManager.mDeepLinkCallback != null) {
                                        DeepLinkManager.mDeepLinkCallback.onReceive(str, z10, j10);
                                    }
                                } catch (Exception e10) {
                                    SALog.printStackTrace(e10);
                                }
                            }
                        }
                    });
                    mDeepLinkProcessor.parseDeepLink(intent);
                    cacheProperties();
                    trackDeepLinkLaunchEvent(activity.getApplicationContext(), mDeepLinkProcessor);
                    activity.getIntent().putExtra(IS_ANALYTICS_DEEPLINK, true);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void requestDeferredDeepLink(Context context, JSONObject jSONObject, String str, String str2, JSONObject jSONObject2, String str3, boolean z10) {
        String str4;
        if (!mIsDeepLink) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                String openAdIdentifierByReflection = SAOaidHelper.getOpenAdIdentifierByReflection(context);
                if (jSONObject != null) {
                    if (jSONObject.has("$oaid")) {
                        str2 = jSONObject.optString("$oaid");
                        openAdIdentifierByReflection = "";
                        jSONObject.remove("$oaid");
                    }
                    str4 = ChannelUtils.getDeviceInfo(context, str, str2, openAdIdentifierByReflection);
                    if (jSONObject.has("$gaid")) {
                        str4 = String.format("%s##gaid=%s", new Object[]{str4, jSONObject.optString("$gaid")});
                        jSONObject.remove("$gaid");
                    }
                    if (jSONObject.has("$user_agent")) {
                        jSONObject3.put("ua", jSONObject.optString("$user_agent"));
                        jSONObject.remove("$user_agent");
                    }
                    jSONObject3.put("app_parameter", jSONObject.toString());
                } else {
                    str4 = ChannelUtils.getDeviceInfo(context, str, str2, openAdIdentifierByReflection);
                }
                jSONObject3.put("ids", Base64Coder.encodeString(str4));
                jSONObject3.put("model", jSONObject2.optString("$model"));
                jSONObject3.put("os", jSONObject2.optString("$os"));
                jSONObject3.put("os_version", jSONObject2.optString("$os_version"));
                jSONObject3.put("network", jSONObject2.optString("$network_type"));
                jSONObject3.put(Constant.PARAM_APP_ID, jSONObject2.optString("$app_id"));
                jSONObject3.put("app_version", jSONObject2.optString("$app_version"));
                jSONObject3.put("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject3.put("project", new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()).getProject());
                DeferredDeepLinkHelper.request(jSONObject3, mDeferredDeepLinkCallback, str3, z10);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void resetDeepLinkProcessor() {
        mDeepLinkProcessor = null;
    }

    public static void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        mDeepLinkCallback = sensorsDataDeepLinkCallback;
    }

    public static void setDeferredDeepLinkCallback(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        mDeferredDeepLinkCallback = sensorsDataDeferredDeepLinkCallback;
    }

    private static void trackDeepLinkLaunchEvent(final Context context, DeepLinkProcessor deepLinkProcessor) {
        final boolean z10;
        final JSONObject jSONObject = new JSONObject();
        if (!(deepLinkProcessor instanceof SensorsDataDeepLink) || !mEnableDeepLinkInstallSource) {
            z10 = false;
        } else {
            z10 = true;
        }
        try {
            jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_URL, deepLinkProcessor.getDeepLinkUrl());
            jSONObject.put("$time", new Date(System.currentTimeMillis()));
            jSONObject.put("$sat_has_installed_app", SAAdvertUtils.isInstallationTracked());
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        JSONUtils.mergeJSONObject(ChannelUtils.getLatestUtmProperties(), jSONObject);
        JSONUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                if (z10) {
                    try {
                        JSONObject jSONObject = jSONObject;
                        Context context = context;
                        jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(context, SensorsDataUtils.getIdentifier(context), SAOaidHelper.getOpenAdIdentifier(context), SAOaidHelper.getOpenAdIdentifierByReflection(context)));
                    } catch (JSONException e10) {
                        SALog.printStackTrace(e10);
                    }
                }
                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(SAAdvertConstants.EventName.DEEPLINK_LAUNCH).setProperties(jSONObject));
            }
        });
    }
}
