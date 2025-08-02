package com.sensorsdata.analytics.android.sdk.core.event.imp;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.event.Event;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.event.TrackEvent;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONException;
import org.json.JSONObject;

class ItemEventAssemble extends BaseEventAssemble {
    private static final String TAG = "SA.ItemEventAssemble";

    public ItemEventAssemble(SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    private void appendDefaultProperty(InputData inputData, TrackEvent trackEvent) {
        if (SADataHelper.assertPropertyKey(inputData.getItemType())) {
            trackEvent.setItemType(inputData.getItemType());
        }
        trackEvent.setItemId(inputData.getItemId());
        trackEvent.setType(inputData.getEventType().getEventType());
        trackEvent.setTime(inputData.getTime());
        try {
            trackEvent.setProperties(TimeUtils.formatDate(JSONUtils.cloneJsonObject(inputData.getProperties())));
        } catch (InvalidDataException e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void appendLibProperty(TrackEvent trackEvent) throws JSONException {
        SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("$lib", "Android");
        jSONObject.put("$lib_version", sharedInstance.getSDKVersion());
        jSONObject.put("$lib_method", Constant.PARAM_OAUTH_CODE);
        jSONObject.put("$app_version", AppInfoUtils.getAppVersionName(sharedInstance.getSAContextManager().getContext()));
        JSONObject jSONObject2 = (JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get();
        if (jSONObject2 != null && jSONObject2.has("$app_version")) {
            jSONObject.put("$app_version", jSONObject2.get("$app_version"));
        }
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement stackTraceElement = stackTrace[0];
            String format = String.format("%s##%s##%s##%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())});
            if (!TextUtils.isEmpty(format)) {
                jSONObject.put("$lib_detail", format);
            }
        }
        trackEvent.setLib(jSONObject);
    }

    private boolean isEventIgnore(InputData inputData) {
        try {
            SADataHelper.assertPropertyTypes(inputData.getProperties());
            SADataHelper.assertItemId(inputData.getItemId());
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    public Event assembleData(InputData inputData) {
        try {
            if (isEventIgnore(inputData)) {
                return null;
            }
            TrackEvent trackEvent = new TrackEvent();
            appendDefaultProperty(inputData, trackEvent);
            appendLibProperty(trackEvent);
            handlePropertyProtocols(trackEvent);
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "track item event:\n" + JSONUtils.formatJson(trackEvent.toJSONObject().toString()));
            }
            return trackEvent;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }
}
