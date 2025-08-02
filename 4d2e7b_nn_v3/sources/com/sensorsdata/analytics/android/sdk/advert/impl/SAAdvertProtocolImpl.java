package com.sensorsdata.analytics.android.sdk.advert.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.advert.monitor.SensorsDataAdvertActivityLifeCallback;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.advert.plugin.LatestUtmPlugin;
import com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppStartPlugin;
import com.sensorsdata.analytics.android.sdk.advert.plugin.SAAdvertAppViewScreenPlugin;
import com.sensorsdata.analytics.android.sdk.advert.scan.SAAdvertScanHelper;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class SAAdvertProtocolImpl {
    private SAPropertyPlugin mAdEventId;
    /* access modifiers changed from: private */
    public final SAAdvertisingConfig mAdvertOptions;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public boolean mEnableDeepLinkInstallSource;
    private LatestUtmPlugin mLatestUtmPlugin;
    private SensorsDataAdvertActivityLifeCallback mLifecycleCallback;
    /* access modifiers changed from: private */
    public final SAConfigOptions mOptions;
    private final SAContextManager mSAContextManager;
    private SAAdvertAppStartPlugin mStartPlugin;
    private SAAdvertAppViewScreenPlugin mViewScreenPlugin;

    public SAAdvertProtocolImpl(SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mContext = sAContextManager.getContext();
        SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mOptions = sAConfigOptions;
        this.mAdvertOptions = sAConfigOptions.getAdvertConfig();
        init();
    }

    private void enableDeepLinkInstallSource(boolean z10) {
        this.mEnableDeepLinkInstallSource = z10;
        DeepLinkManager.enableDeepLinkInstallSource(z10);
    }

    private void init() {
        this.mStartPlugin = new SAAdvertAppStartPlugin();
        this.mViewScreenPlugin = new SAAdvertAppViewScreenPlugin();
        this.mLatestUtmPlugin = new LatestUtmPlugin();
        this.mAdEventId = new SAPropertyPlugin() {
            public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
                if (SAAdvertProtocolImpl.this.mAdvertOptions == null || TextUtils.isEmpty(SAAdvertProtocolImpl.this.mAdvertOptions.serverUrl) || SAAdvertProtocolImpl.this.mAdvertOptions.eventNames.isEmpty() || TextUtils.isEmpty(sAPropertyFilter.getEvent()) || !SAAdvertProtocolImpl.this.mAdvertOptions.eventNames.contains(sAPropertyFilter.getEvent())) {
                    return false;
                }
                return true;
            }

            public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
                try {
                    sAPropertiesFetcher.getProperties().put("$sat_event_track_id", UUID.randomUUID().toString());
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        };
        ChannelUtils.setSourceChannelKeys(this.mOptions.channelSourceKeys);
        if (AppInfoUtils.isMainProcess(this.mContext, (Bundle) null)) {
            ChannelUtils.commitRequestDeferredDeeplink(!ChannelUtils.isExistRequestDeferredDeeplink());
        }
    }

    private JSONObject mergeChannelEventProperties(String str, JSONObject jSONObject) {
        if (this.mOptions.isAutoAddChannelCallbackEvent()) {
            return ChannelUtils.checkOrSetChannelCallbackEvent(str, jSONObject, this.mContext);
        }
        return jSONObject;
    }

    private void requestDeferredDeepLink(final JSONObject jSONObject) {
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                try {
                    if (ChannelUtils.isRequestDeferredDeeplink()) {
                        SALog.i(SAAdvertConstants.TAG, "do requestDeferredDeepLink");
                        DeepLinkManager.requestDeferredDeepLink(SAAdvertProtocolImpl.this.mContext, jSONObject, SAAdvertUtils.getIdentifier(SAAdvertProtocolImpl.this.mContext), SAOaidHelper.getOpenAdIdentifier(SAAdvertProtocolImpl.this.mContext), SensorsDataAPI.sharedInstance().getPresetProperties(), SAAdvertProtocolImpl.this.mOptions.getCustomADChannelUrl(), SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo());
                        ChannelUtils.commitRequestDeferredDeeplink(false);
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    private void trackChannelEvent(final String str, JSONObject jSONObject) {
        if (this.mOptions.isAutoAddChannelCallbackEvent()) {
            SensorsDataAPI.sharedInstance().track(str, jSONObject);
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        SADataHelper.addTimeProperty(jSONObject2);
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                try {
                    jSONObject2.put("$is_channel_callback_event", ChannelUtils.isFirstChannelEvent(str));
                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                        ChannelUtils.mergeUtmByMetaData(SAAdvertProtocolImpl.this.mContext, jSONObject2);
                    }
                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                        if (jSONObject2.has("$oaid")) {
                            String optString = jSONObject2.optString("$oaid");
                            jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, SAAdvertUtils.getIdentifier(SAAdvertProtocolImpl.this.mContext), optString, ""));
                            SALog.i(SAAdvertConstants.TAG, "properties has oaid " + optString);
                        } else {
                            jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, SAAdvertUtils.getIdentifier(SAAdvertProtocolImpl.this.mContext), SAOaidHelper.getOpenAdIdentifier(SAAdvertProtocolImpl.this.mContext), SAOaidHelper.getOpenAdIdentifierByReflection(SAAdvertProtocolImpl.this.mContext)));
                        }
                    }
                    if (jSONObject2.has("$oaid")) {
                        jSONObject2.remove("$oaid");
                    }
                } catch (Exception e10) {
                    try {
                        SALog.printStackTrace(e10);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                        return;
                    }
                }
                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(str).setProperties(jSONObject2));
            }
        });
    }

    private void trackDeepLinkLaunch(String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SAAdvertConstants.Properties.DEEPLINK_URL, str);
            jSONObject.put("$time", new Date(System.currentTimeMillis()));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                if (SAAdvertProtocolImpl.this.mEnableDeepLinkInstallSource) {
                    try {
                        String str = str2;
                        String str2 = "";
                        if (TextUtils.isEmpty(str)) {
                            str = SAOaidHelper.getOpenAdIdentifier(SAAdvertProtocolImpl.this.mContext);
                            str2 = SAOaidHelper.getOpenAdIdentifierByReflection(SAAdvertProtocolImpl.this.mContext);
                        }
                        jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, SAAdvertUtils.getIdentifier(SAAdvertProtocolImpl.this.mContext), str, str2));
                    } catch (JSONException e10) {
                        SALog.printStackTrace(e10);
                    }
                }
                SACoreHelper.getInstance().trackEvent(new InputData().setEventName(SAAdvertConstants.EventName.DEEPLINK_LAUNCH).setProperties(jSONObject));
            }
        });
    }

    private void trackInstallation(final String str, JSONObject jSONObject, final boolean z10) {
        try {
            if (AppInfoUtils.isMainProcess(this.mContext, (Bundle) null)) {
                final JSONObject jSONObject2 = new JSONObject();
                JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
                SADataHelper.addTimeProperty(jSONObject2);
                SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                    public void run() {
                        String str;
                        String str2;
                        boolean z10 = false;
                        try {
                            if (SAAdvertUtils.isFirstTrackInstallation(z10)) {
                                try {
                                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                                        ChannelUtils.mergeUtmByMetaData(SAAdvertProtocolImpl.this.mContext, jSONObject2);
                                    }
                                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                                        String identifier = SAAdvertUtils.getIdentifier(SAAdvertProtocolImpl.this.mContext);
                                        if (jSONObject2.has("$oaid")) {
                                            str2 = jSONObject2.optString("$oaid");
                                            str = ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, identifier, str2, "");
                                            SALog.i(SAAdvertConstants.TAG, "properties has oaid " + str2);
                                        } else {
                                            str2 = SAOaidHelper.getOpenAdIdentifier(SAAdvertProtocolImpl.this.mContext);
                                            str = ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, identifier, str2, SAOaidHelper.getOpenAdIdentifierByReflection(SAAdvertProtocolImpl.this.mContext));
                                        }
                                        if (jSONObject2.has("$gaid")) {
                                            str = String.format("%s##gaid=%s", new Object[]{str, jSONObject2.optString("$gaid")});
                                        }
                                        z10 = ChannelUtils.isGetDeviceInfo(identifier, str2);
                                        jSONObject2.put("$ios_install_source", str);
                                    }
                                    if (jSONObject2.has("$oaid")) {
                                        jSONObject2.remove("$oaid");
                                    }
                                    if (jSONObject2.has("$gaid")) {
                                        jSONObject2.remove("$gaid");
                                    }
                                    boolean z11 = z10;
                                    if (z11) {
                                        jSONObject2.put("$ios_install_disable_callback", z11);
                                    }
                                } catch (Exception e10) {
                                    SALog.printStackTrace(e10);
                                }
                                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(str).setProperties(jSONObject2));
                                JSONObject jSONObject = new JSONObject();
                                jSONObject2.remove("$ios_install_disable_callback");
                                JSONUtils.mergeJSONObject(jSONObject2, jSONObject);
                                jSONObject.put("$first_visit_time", new Date());
                                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.PROFILE_SET_ONCE).setProperties(jSONObject));
                                SAAdvertUtils.setTrackInstallation(z10);
                                ChannelUtils.saveCorrectTrackInstallation(z10);
                            }
                            SensorsDataAPI.sharedInstance().flush();
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                        }
                    }
                });
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: protected */
    public void delayExecution() {
        SensorsDataAdvertActivityLifeCallback sensorsDataAdvertActivityLifeCallback;
        try {
            if (this.mOptions.getDeeplinkCallback() != null) {
                DeepLinkManager.setDeferredDeepLinkCallback(this.mOptions.getDeeplinkCallback());
                if ((this.mSAContextManager.getInternalConfigs().context instanceof Activity) && (sensorsDataAdvertActivityLifeCallback = this.mLifecycleCallback) != null) {
                    sensorsDataAdvertActivityLifeCallback.onActivityStarted((Activity) this.mSAContextManager.getInternalConfigs().context);
                }
            }
            if (this.mSAContextManager.getInternalConfigs().context instanceof Activity) {
                SAAdvertMarketHelper.handleAdMarket((Activity) this.mSAContextManager.getInternalConfigs().context, this.mOptions.getAdvertConfig());
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void delayInitTask() {
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                try {
                    if (SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo()) {
                        ChannelUtils.loadUtmByLocal();
                    } else {
                        ChannelUtils.clearLocalUtm();
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1770134035:
                if (str.equals(Modules.Advert.METHOD_SET_DEEPLINK_CALLBACK)) {
                    c10 = 0;
                    break;
                }
                break;
            case -1731065051:
                if (str.equals(Modules.Advert.METHOD_TRACK_INSTALLATION)) {
                    c10 = 1;
                    break;
                }
                break;
            case -430510755:
                if (str.equals(Modules.Advert.METHOD_COMMIT_REQUEST_DEFERRED_DEEPLINK)) {
                    c10 = 2;
                    break;
                }
                break;
            case -427927688:
                if (str.equals(Modules.Advert.METHOD_REMOVE_DEEPLINK_INFO)) {
                    c10 = 3;
                    break;
                }
                break;
            case -159441788:
                if (str.equals(Modules.Advert.METHOD_TRACK_DEEPLINK_LAUNCH)) {
                    c10 = 4;
                    break;
                }
                break;
            case 2762738:
                if (str.equals(Modules.Advert.METHOD_SEND_EVENT_SAT)) {
                    c10 = 5;
                    break;
                }
                break;
            case 126152258:
                if (str.equals(Modules.Advert.METHOD_MERGE_CHANNEL_EVENT_PROPERTIES)) {
                    c10 = 6;
                    break;
                }
                break;
            case 421616706:
                if (str.equals(Modules.Advert.METHOD_TRACK_CHANNEL_EVENT)) {
                    c10 = 7;
                    break;
                }
                break;
            case 736927236:
                if (str.equals(Modules.Advert.METHOD_GET_LATEST_UTM_PROPERTIES)) {
                    c10 = 8;
                    break;
                }
                break;
            case 778248372:
                if (str.equals(Modules.Advert.METHOD_REQUEST_DEFERRED_DEEPLINK)) {
                    c10 = 9;
                    break;
                }
                break;
            case 1053487877:
                if (str.equals(Modules.Advert.METHOD_HANDLER_SCAN_URI)) {
                    c10 = 10;
                    break;
                }
                break;
            case 1462034308:
                if (str.equals(Modules.Advert.METHOD_SET_DEEPLINK_COMPLETION)) {
                    c10 = 11;
                    break;
                }
                break;
            case 2104386157:
                if (str.equals(Modules.Advert.METHOD_ENABLE_DEEPLINK_INSTALL_SOURCE)) {
                    c10 = 12;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                DeepLinkManager.setDeepLinkCallback(objArr[0]);
                break;
            case 1:
                if (objArr.length != 3) {
                    if (objArr.length != 2) {
                        trackInstallation(objArr[0], (JSONObject) null, false);
                        break;
                    } else {
                        trackInstallation(objArr[0], objArr[1], false);
                        break;
                    }
                } else {
                    trackInstallation(objArr[0], objArr[1], objArr[2].booleanValue());
                    break;
                }
            case 2:
                ChannelUtils.commitRequestDeferredDeeplink(objArr[0].booleanValue());
                break;
            case 3:
                ChannelUtils.removeDeepLinkInfo(objArr[0]);
                break;
            case 4:
                if (objArr.length != 2) {
                    trackDeepLinkLaunch(objArr[0], (String) null);
                    break;
                } else {
                    trackDeepLinkLaunch(objArr[0], objArr[1]);
                    break;
                }
            case 5:
                SAAdvertisingConfig sAAdvertisingConfig = this.mAdvertOptions;
                if (sAAdvertisingConfig != null && !TextUtils.isEmpty(sAAdvertisingConfig.serverUrl) && !this.mAdvertOptions.eventNames.isEmpty()) {
                    JSONObject jSONObject = objArr[0];
                    String optString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                    if (!TextUtils.isEmpty(optString) && this.mAdvertOptions.eventNames.contains(optString)) {
                        SAAdvertUtils.sendData(this.mContext, this.mAdvertOptions.serverUrl, (JSONObject) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA_WITH_KEY, jSONObject, this.mAdvertOptions.secreteKey), jSONObject.toString());
                        break;
                    }
                }
            case 6:
                return mergeChannelEventProperties(objArr[0], objArr[1]);
            case 7:
                if (objArr.length != 2) {
                    trackChannelEvent(objArr[0], (JSONObject) null);
                    break;
                } else {
                    trackChannelEvent(objArr[0], objArr[1]);
                    break;
                }
            case 8:
                return ChannelUtils.getLatestUtmProperties();
            case 9:
                requestDeferredDeepLink(objArr[0]);
                break;
            case 10:
                SAAdvertScanHelper.scanHandler(objArr[0], objArr[1]);
                break;
            case 11:
                DeepLinkManager.setDeferredDeepLinkCallback(objArr[0]);
                break;
            case 12:
                enableDeepLinkInstallSource(objArr[0].booleanValue());
                break;
        }
        return null;
    }

    public void registerLifeCallback() {
        if (this.mLifecycleCallback == null) {
            this.mLifecycleCallback = new SensorsDataAdvertActivityLifeCallback(this.mOptions);
        }
        SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mLifecycleCallback);
    }

    public void registerPropertyPlugin() {
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mStartPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mViewScreenPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mLatestUtmPlugin);
        this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.mAdEventId);
    }

    public void unregisterLifecycleCallback() {
        if (this.mLifecycleCallback != null) {
            SensorsDataLifecycleMonitorManager.getInstance().removeActivityLifeCallback(this.mLifecycleCallback);
        }
    }

    public void unregisterPropertyPlugin() {
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mStartPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mViewScreenPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mLatestUtmPlugin);
        this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.mAdEventId);
    }
}
