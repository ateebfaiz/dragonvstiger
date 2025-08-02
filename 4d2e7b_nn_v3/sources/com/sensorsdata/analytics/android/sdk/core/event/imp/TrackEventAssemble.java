package com.sensorsdata.analytics.android.sdk.core.event.imp;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer;
import com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager;
import com.sensorsdata.analytics.android.sdk.core.event.Event;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.event.TrackEvent;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.plugin.property.impl.InternalCustomPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.zing.zalo.zalosdk.common.Constant;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

class TrackEventAssemble extends BaseEventAssemble {
    private static final String TAG = "SA.TrackEventAssemble";
    private final SAContextManager mContextManager;

    public TrackEventAssemble(SAContextManager sAContextManager) {
        super(sAContextManager);
        this.mContextManager = sAContextManager;
    }

    private void appendDefaultProperty(InputData inputData, TrackEvent trackEvent) {
        try {
            trackEvent.setTime(inputData.getTime());
            trackEvent.setEventName(inputData.getEventName());
            trackEvent.setType(inputData.getEventType().getEventType());
            trackEvent.setTrackId((long) new SecureRandom().nextInt());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void appendEventDuration(TrackEvent trackEvent) {
        try {
            String eventName = trackEvent.getEventName();
            if (!TextUtils.isEmpty(eventName)) {
                EventTimer eventTimer = EventTimerManager.getInstance().getEventTimer(eventName);
                if (eventTimer != null) {
                    float duration = eventTimer.duration();
                    if (duration > 0.0f) {
                        trackEvent.getProperties().put("event_duration", Float.valueOf(duration));
                    }
                }
                if (eventName.endsWith("_SATimer") && eventName.length() > 45) {
                    String substring = eventName.substring(0, eventName.length() - 45);
                    trackEvent.setEventName(substring);
                    SALog.i(TAG, "trigger event name = " + substring);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void appendLibProperty(EventType eventType, TrackEvent trackEvent) throws JSONException {
        SensorsDataAPI.AutoTrackEventType autoTrackEventTypeFromEventName;
        JSONObject jSONObject = new JSONObject();
        JSONObject properties = trackEvent.getProperties();
        String str = null;
        if (properties != null) {
            if (eventType.isTrack()) {
                String optString = trackEvent.getProperties().optString("$lib_method", Constant.PARAM_OAUTH_CODE);
                jSONObject.put("$lib_method", optString);
                properties.put("$lib_method", optString);
            } else {
                jSONObject.put("$lib_method", Constant.PARAM_OAUTH_CODE);
            }
            if (properties.has("$lib_detail")) {
                str = properties.optString("$lib_detail");
                properties.remove("$lib_detail");
            }
        } else {
            jSONObject.put("$lib_method", Constant.PARAM_OAUTH_CODE);
            if (eventType.isTrack()) {
                properties = new JSONObject();
                properties.put("$lib_method", Constant.PARAM_OAUTH_CODE);
            }
        }
        jSONObject.put("$lib", "Android");
        jSONObject.put("$lib_version", this.mContextManager.getSensorsDataAPI().getSDKVersion());
        jSONObject.put("$app_version", AppInfoUtils.getAppVersionName(this.mContextManager.getContext()));
        JSONObject jSONObject2 = (JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get();
        if (jSONObject2 != null && jSONObject2.has("$app_version")) {
            jSONObject.put("$app_version", jSONObject2.get("$app_version"));
        }
        if (this.mContextManager.getSensorsDataAPI().isAutoTrackEnabled() && properties != null && isAutoTrackType(trackEvent.getEventName()) && (autoTrackEventTypeFromEventName = autoTrackEventTypeFromEventName(trackEvent.getEventName())) != null && !this.mContextManager.getSensorsDataAPI().isAutoTrackEventTypeIgnored(autoTrackEventTypeFromEventName) && trackEvent.getProperties().has("$screen_name")) {
            String string = properties.getString("$screen_name");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("\\|");
                if (split.length > 0) {
                    str = String.format("%s##%s##%s##%s", new Object[]{split[0], "", "", ""});
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            if (stackTrace.length > 1) {
                StackTraceElement stackTraceElement = stackTrace[0];
                str = String.format("%s##%s##%s##%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())});
            }
        }
        jSONObject.put("$lib_detail", str);
        trackEvent.setLib(jSONObject);
        trackEvent.setProperties(properties);
    }

    private void appendPluginProperties(EventType eventType, JSONObject jSONObject, TrackEvent trackEvent) throws JSONException {
        SAPropertyFilter sAPropertyFilter = new SAPropertyFilter();
        sAPropertyFilter.setEvent(trackEvent.getEventName());
        sAPropertyFilter.setTime(trackEvent.getTime());
        sAPropertyFilter.setEventJson(SAPropertyFilter.LIB, trackEvent.getLib());
        if (trackEvent.getIdentities() != null) {
            sAPropertyFilter.setEventJson("identities", new JSONObject(trackEvent.getIdentities().toString()));
        }
        sAPropertyFilter.setProperties(trackEvent.getProperties());
        sAPropertyFilter.setType(eventType);
        SAPropertyPlugin propertyPlugin = this.mContextManager.getPluginManager().getPropertyPlugin(InternalCustomPropertyPlugin.class.getName());
        if (propertyPlugin instanceof InternalCustomPropertyPlugin) {
            ((InternalCustomPropertyPlugin) propertyPlugin).saveCustom(jSONObject);
        }
        SAPropertiesFetcher propertiesHandler = this.mContextManager.getPluginManager().propertiesHandler(sAPropertyFilter);
        if (propertiesHandler != null) {
            trackEvent.setProperties(propertiesHandler.getProperties());
            trackEvent.setLib(propertiesHandler.getEventJson(SAPropertyFilter.LIB));
        }
    }

    private void appendUserIDs(InputData inputData, TrackEvent trackEvent) throws JSONException {
        String distinctId = this.mContextManager.getUserIdentityAPI().getDistinctId();
        String loginId = this.mContextManager.getUserIdentityAPI().getLoginId();
        String anonymousId = this.mContextManager.getUserIdentityAPI().getAnonymousId();
        try {
            if ("$PlanPopupDisplay".equals(trackEvent.getEventName())) {
                if (trackEvent.getProperties().has("$sf_internal_anonymous_id")) {
                    anonymousId = trackEvent.getProperties().optString("$sf_internal_anonymous_id");
                    trackEvent.getProperties().remove("$sf_internal_anonymous_id");
                    inputData.getProperties().remove("$sf_internal_anonymous_id");
                }
                if (trackEvent.getProperties().has("$sf_internal_login_id")) {
                    loginId = trackEvent.getProperties().optString("$sf_internal_login_id");
                    trackEvent.getProperties().remove("$sf_internal_login_id");
                    inputData.getProperties().remove("$sf_internal_login_id");
                }
                distinctId = !TextUtils.isEmpty(loginId) ? loginId : anonymousId;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        EventType eventType = inputData.getEventType();
        JSONObject identities = this.mContextManager.getUserIdentityAPI().getIdentities(eventType);
        EventType eventType2 = EventType.TRACK_ID_UNBIND;
        if (!eventType2.getEventType().equals(trackEvent.getType())) {
            if (identities != null) {
                if (!TextUtils.isEmpty(anonymousId)) {
                    identities.put(Identities.ANONYMOUS_ID, anonymousId);
                } else {
                    anonymousId = identities.optString(Identities.ANONYMOUS_ID);
                }
                if (!TextUtils.isEmpty(loginId)) {
                    identities.put(this.mContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), loginId);
                } else {
                    loginId = identities.optString(this.mContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey());
                }
            }
            if (!TextUtils.isEmpty(loginId)) {
                trackEvent.setLoginId(loginId);
            }
            trackEvent.setAnonymousId(anonymousId);
        }
        trackEvent.setDistinctId(distinctId);
        trackEvent.setIdentities(identities);
        if (eventType == EventType.TRACK || eventType == EventType.TRACK_ID_BIND || eventType == eventType2) {
            trackEvent.getProperties().put("$is_first_day", this.mContextManager.isFirstDay(trackEvent.getTime()));
        } else if (eventType == EventType.TRACK_SIGNUP) {
            trackEvent.setOriginalId(trackEvent.getAnonymousId());
        }
    }

    static SensorsDataAPI.AutoTrackEventType autoTrackEventTypeFromEventName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -618659154:
                if (str.equals("$AppViewScreen")) {
                    c10 = 0;
                    break;
                }
                break;
            case -441870274:
                if (str.equals("$AppEnd")) {
                    c10 = 1;
                    break;
                }
                break;
            case 562530347:
                if (str.equals("$AppClick")) {
                    c10 = 2;
                    break;
                }
                break;
            case 577537797:
                if (str.equals("$AppStart")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN;
            case 1:
                return SensorsDataAPI.AutoTrackEventType.APP_END;
            case 2:
                return SensorsDataAPI.AutoTrackEventType.APP_CLICK;
            case 3:
                return SensorsDataAPI.AutoTrackEventType.APP_START;
            default:
                return null;
        }
    }

    static boolean isAutoTrackType(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -618659154:
                    if (str.equals("$AppViewScreen")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -441870274:
                    if (str.equals("$AppEnd")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 562530347:
                    if (str.equals("$AppClick")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 577537797:
                    if (str.equals("$AppStart")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return true;
            }
        }
        return false;
    }

    private boolean isEventIgnore(String str, EventType eventType, SAContextManager sAContextManager) {
        if (!eventType.isTrack()) {
            return false;
        }
        SADataHelper.assertEventName(str);
        if (TextUtils.isEmpty(str) || sAContextManager.getRemoteManager() == null || !sAContextManager.getRemoteManager().ignoreEvent(str)) {
            return false;
        }
        return true;
    }

    public Event assembleData(InputData inputData) {
        try {
            EventType eventType = inputData.getEventType();
            JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(inputData.getProperties());
            if (cloneJsonObject == null) {
                cloneJsonObject = new JSONObject();
            }
            if (isEventIgnore(inputData.getEventName(), eventType, this.mContextManager)) {
                return null;
            }
            TrackEvent trackEvent = new TrackEvent();
            trackEvent.setProperties(cloneJsonObject);
            appendDefaultProperty(inputData, trackEvent);
            appendEventDuration(trackEvent);
            appendLibProperty(eventType, trackEvent);
            appendUserIDs(inputData, trackEvent);
            appendSessionId(eventType, trackEvent);
            appendPluginProperties(eventType, inputData.getProperties(), trackEvent);
            handlePropertyProtocols(trackEvent);
            if (!handleEventCallback(eventType, trackEvent)) {
                return null;
            }
            appendPluginVersion(eventType, trackEvent);
            overrideDeviceId(eventType, trackEvent, this.mContextManager);
            SADataHelper.assertPropertyTypes(trackEvent.getProperties());
            handleEventListener(eventType, trackEvent, this.mContextManager);
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "track event:\n" + JSONUtils.formatJson(trackEvent.toJSONObject().toString()));
            }
            return trackEvent;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }
}
