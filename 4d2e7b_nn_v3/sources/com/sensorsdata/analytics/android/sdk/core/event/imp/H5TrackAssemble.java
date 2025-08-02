package com.sensorsdata.analytics.android.sdk.core.event.imp;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.event.Event;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.event.TrackEvent;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class H5TrackAssemble extends BaseEventAssemble {
    private static final String TAG = "SA.H5TrackAssemble";

    public H5TrackAssemble(SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    private void appendDefaultProperty(TrackEvent trackEvent) {
        try {
            trackEvent.getExtras().put("_hybrid_h5", true);
            if (!trackEvent.getExtras().has("time")) {
                trackEvent.getExtras().put("time", System.currentTimeMillis());
            }
            trackEvent.getExtras().put("_track_id", new SecureRandom().nextInt());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void appendNativeProperty(EventType eventType, TrackEvent trackEvent, SAContextManager sAContextManager) throws JSONException {
        JSONObject optJSONObject = trackEvent.getExtras().optJSONObject(SAPropertyFilter.LIB);
        if (optJSONObject != null) {
            optJSONObject.put("$app_version", AppInfoUtils.getAppVersionName(sAContextManager.getContext()));
            JSONObject jSONObject = (JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get();
            if (jSONObject != null && jSONObject.has("$app_version")) {
                optJSONObject.put("$app_version", jSONObject.get("$app_version"));
            }
            trackEvent.setLib(optJSONObject);
        }
        if (eventType.isTrack()) {
            trackEvent.getProperties().put("$is_first_day", sAContextManager.isFirstDay(trackEvent.getExtras().optLong("time")));
        }
    }

    private void appendPropertyPlugin(EventType eventType, TrackEvent trackEvent, SensorsDataAPI sensorsDataAPI) {
        SAPropertyFilter sAPropertyFilter = new SAPropertyFilter();
        sAPropertyFilter.setEvent(trackEvent.getEventName());
        sAPropertyFilter.setEventJson(SAPropertyFilter.LIB, trackEvent.getExtras().optJSONObject(SAPropertyFilter.LIB));
        sAPropertyFilter.setProperties(trackEvent.getProperties());
        sAPropertyFilter.setType(eventType);
        SAPropertiesFetcher propertiesHandler = sensorsDataAPI.getSAContextManager().getPluginManager().propertiesHandler(sAPropertyFilter);
        if (propertiesHandler != null) {
            trackEvent.setProperties(propertiesHandler.getProperties());
            trackEvent.setLib(propertiesHandler.getEventJson(SAPropertyFilter.LIB));
        }
    }

    private void checkIDConsistent(EventType eventType, TrackEvent trackEvent, SensorsDataAPI sensorsDataAPI) {
        try {
            JSONObject optJSONObject = trackEvent.getExtras().optJSONObject("identities");
            if (optJSONObject == null) {
                return;
            }
            if (EventType.TRACK_ID_UNBIND.getEventType().equals(eventType.getEventType())) {
                trackEvent.getExtras().remove("anonymous_id");
                return;
            }
            String anonymousId = sensorsDataAPI.getAnonymousId();
            if (!TextUtils.isEmpty(anonymousId)) {
                optJSONObject.put(Identities.ANONYMOUS_ID, anonymousId);
                trackEvent.getExtras().put("anonymous_id", anonymousId);
            } else {
                trackEvent.getExtras().put("anonymous_id", optJSONObject.optString(Identities.ANONYMOUS_ID));
            }
            String loginId = sensorsDataAPI.getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                optJSONObject.put(sensorsDataAPI.getSAContextManager().getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), loginId);
            } else {
                loginId = optJSONObject.optString(sensorsDataAPI.getSAContextManager().getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey());
            }
            if (eventType != EventType.TRACK_SIGNUP && !TextUtils.isEmpty(sensorsDataAPI.getLoginId())) {
                trackEvent.getExtras().put("login_id", loginId);
            }
            trackEvent.getExtras().put("identities", optJSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void overrideH5Ids(EventType eventType, TrackEvent trackEvent, SensorsDataAPI sensorsDataAPI) throws JSONException {
        if (eventType == EventType.TRACK_SIGNUP) {
            trackEvent.getExtras().put("original_id", sensorsDataAPI.getAnonymousId());
        } else if (!TextUtils.isEmpty(sensorsDataAPI.getLoginId())) {
            trackEvent.getExtras().put("distinct_id", sensorsDataAPI.getLoginId());
        } else {
            trackEvent.getExtras().put("distinct_id", sensorsDataAPI.getAnonymousId());
        }
    }

    private void removeH5Property(TrackEvent trackEvent) {
        if (trackEvent.getExtras().has("_nocache")) {
            trackEvent.getExtras().remove("_nocache");
        }
        if (trackEvent.getExtras().has("server_url")) {
            trackEvent.getExtras().remove("server_url");
        }
        if (trackEvent.getExtras().has("_flush_time")) {
            trackEvent.getExtras().remove("_flush_time");
        }
    }

    private boolean updateIdentities(EventType eventType, TrackEvent trackEvent, SensorsDataAPI sensorsDataAPI, SAContextManager sAContextManager) {
        try {
            if (!EventType.TRACK_ID_UNBIND.getEventType().equals(eventType.getEventType()) && !sAContextManager.getUserIdentityAPI().mergeH5Identities(eventType, trackEvent.getExtras())) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public Event assembleData(InputData inputData) {
        try {
            if (TextUtils.isEmpty(inputData.getExtras())) {
                return null;
            }
            TrackEvent trackEvent = new TrackEvent();
            trackEvent.setExtras(new JSONObject(inputData.getExtras()));
            String optString = trackEvent.getExtras().optString(NotificationCompat.CATEGORY_EVENT);
            SADataHelper.assertEventName(optString);
            trackEvent.setEventName(optString);
            JSONObject optJSONObject = trackEvent.getExtras().optJSONObject(SAPropertyFilter.PROPERTIES);
            SADataHelper.assertPropertyTypes(optJSONObject);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            trackEvent.setProperties(optJSONObject);
            EventType valueOf = EventType.valueOf(trackEvent.getExtras().getString("type").toUpperCase(Locale.getDefault()));
            SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
            SAContextManager sAContextManager = sharedInstance.getSAContextManager();
            appendDefaultProperty(trackEvent);
            overrideH5Ids(valueOf, trackEvent, sharedInstance);
            appendNativeProperty(valueOf, trackEvent, sAContextManager);
            appendPropertyPlugin(valueOf, trackEvent, sharedInstance);
            appendSessionId(valueOf, trackEvent);
            handlePropertyProtocols(trackEvent);
            if (!handleEventCallback(valueOf, trackEvent)) {
                return null;
            }
            appendPluginVersion(valueOf, trackEvent);
            removeH5Property(trackEvent);
            overrideDeviceId(valueOf, trackEvent, sAContextManager);
            if (updateIdentities(valueOf, trackEvent, sharedInstance, sAContextManager)) {
                SADataHelper.assertPropertyTypes(trackEvent.getProperties());
                trackEvent.getExtras().put(SAPropertyFilter.PROPERTIES, trackEvent.getProperties());
                trackEvent.getExtras().put(SAPropertyFilter.LIB, trackEvent.getLib());
                checkIDConsistent(valueOf, trackEvent, sharedInstance);
                if (SALog.isLogEnabled()) {
                    SALog.i(TAG, "track event from H5:\n" + JSONUtils.formatJson(trackEvent.getExtras().toString()));
                }
                return trackEvent;
            }
            return null;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
