package com.sensorsdata.analytics.android.sdk.core.event.imp;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.SAPluginVersion;
import com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager;
import com.sensorsdata.analytics.android.sdk.core.event.EventProcessor;
import com.sensorsdata.analytics.android.sdk.core.event.TrackEvent;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseEventAssemble implements EventProcessor.IAssembleData {
    private static final String TAG = "SA.BaseEventAssemble";
    protected InternalConfigOptions mInternalConfigs;

    public BaseEventAssemble(SAContextManager sAContextManager) {
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
    }

    private boolean isEnterDb(String str, JSONObject jSONObject) {
        boolean z10 = true;
        if (this.mInternalConfigs.sensorsDataTrackEventCallBack != null) {
            SALog.i(TAG, "SDK have set trackEvent callBack");
            try {
                z10 = this.mInternalConfigs.sensorsDataTrackEventCallBack.onTrackEvent(str, jSONObject);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
            if (z10) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (opt instanceof Date) {
                            jSONObject.put(next, TimeUtils.formatDate((Date) opt, TimeUtils.SDK_LOCALE));
                        } else {
                            jSONObject.put(next, opt);
                        }
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public void appendPluginVersion(EventType eventType, TrackEvent trackEvent) {
        if (eventType.isTrack()) {
            SAPluginVersion.appendPluginVersion(trackEvent.getProperties());
        }
    }

    /* access modifiers changed from: protected */
    public void appendSessionId(EventType eventType, TrackEvent trackEvent) {
        if (eventType.isTrack()) {
            try {
                SessionRelatedManager.getInstance().handleEventOfSession(trackEvent.getEventName(), trackEvent.getProperties(), trackEvent.getTime());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean handleEventCallback(EventType eventType, TrackEvent trackEvent) {
        if (!eventType.isTrack() || isEnterDb(trackEvent.getEventName(), trackEvent.getProperties())) {
            return true;
        }
        SALog.i(TAG, trackEvent.getEventName() + " event can not enter database");
        return false;
    }

    /* access modifiers changed from: protected */
    public void handleEventListener(EventType eventType, TrackEvent trackEvent, SAContextManager sAContextManager) {
        try {
            if (sAContextManager.getEventListenerList() != null && eventType.isTrack()) {
                for (SAEventListener trackEvent2 : sAContextManager.getEventListenerList()) {
                    trackEvent2.trackEvent(trackEvent.toJSONObject());
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        try {
            if (eventType.isTrack()) {
                TrackMonitor.getInstance().callTrack(trackEvent.toJSONObject());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* access modifiers changed from: protected */
    public void handlePropertyProtocols(TrackEvent trackEvent) throws JSONException {
        if (trackEvent.getProperties().has("$project")) {
            if (this instanceof H5TrackAssemble) {
                trackEvent.getExtras().put("project", trackEvent.getProperties().optString("$project"));
            } else {
                trackEvent.setProject(trackEvent.getProperties().optString("$project"));
            }
            trackEvent.getProperties().remove("$project");
        }
        if (trackEvent.getProperties().has("$token")) {
            if (this instanceof H5TrackAssemble) {
                trackEvent.getExtras().put("token", trackEvent.getProperties().optString("$token"));
            } else {
                trackEvent.setToken(trackEvent.getProperties().optString("$token"));
            }
            trackEvent.getProperties().remove("$token");
        }
        if (trackEvent.getProperties().has("$time")) {
            try {
                if (this instanceof H5TrackAssemble) {
                    long j10 = trackEvent.getProperties().getLong("$time");
                    if (TimeUtils.isDateValid(j10)) {
                        trackEvent.getExtras().put("time", j10);
                    }
                } else {
                    Object opt = trackEvent.getProperties().opt("$time");
                    if ((opt instanceof Date) && TimeUtils.isDateValid((Date) opt)) {
                        trackEvent.setTime(((Date) opt).getTime());
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
            trackEvent.getProperties().remove("$time");
        }
    }

    /* access modifiers changed from: protected */
    public void overrideDeviceId(EventType eventType, TrackEvent trackEvent, SAContextManager sAContextManager) {
        try {
            if (eventType.isTrack() && trackEvent != null) {
                SAPropertyPlugin propertyPlugin = sAContextManager.getPluginManager().getPropertyPlugin(SAPresetPropertyPlugin.class.getName());
                if (propertyPlugin instanceof SAPresetPropertyPlugin) {
                    JSONObject presetProperties = ((SAPresetPropertyPlugin) propertyPlugin).getPresetProperties();
                    trackEvent.getProperties().remove("$device_id");
                    trackEvent.getProperties().remove("$anonymization_id");
                    if (this.mInternalConfigs.saConfigOptions.isDisableDeviceId()) {
                        if (presetProperties.has("$anonymization_id")) {
                            trackEvent.getProperties().put("$anonymization_id", presetProperties.optString("$anonymization_id"));
                        }
                    } else if (presetProperties.has("$device_id")) {
                        trackEvent.getProperties().put("$device_id", presetProperties.optString("$device_id"));
                    }
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
