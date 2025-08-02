package com.sensorsdata.analytics.android.sdk.core.business.instantevent;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import java.util.List;
import org.json.JSONObject;

public class InstantEventUtils {
    private static boolean instanceEventType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(EventType.TRACK.getEventType()) || str.equals(EventType.TRACK_SIGNUP.getEventType()) || str.equals(EventType.TRACK_ID_BIND.getEventType()) || str.equals(EventType.TRACK_ID_UNBIND.getEventType())) {
            return true;
        }
        return false;
    }

    public static boolean isInstantEvent(InputData inputData) {
        if (inputData == null) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(inputData.getExtras())) {
                List instantEvents = AbstractSensorsDataAPI.getConfigOptions().getInstantEvents();
                if (inputData.getEventType() != null && inputData.getEventType().isTrack() && !TextUtils.isEmpty(inputData.getEventName()) && instantEvents != null && instantEvents.contains(inputData.getEventName())) {
                    return true;
                }
            } else {
                JSONObject jSONObject = new JSONObject(inputData.getExtras());
                return instanceEventType(jSONObject.optString("type", "")) && jSONObject.optBoolean(DbParams.KEY_IS_INSTANT_EVENT, false);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static int isInstantEvent(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean("_hybrid_h5", false)) {
                boolean optBoolean = jSONObject.optBoolean(DbParams.KEY_IS_INSTANT_EVENT, false);
                String optString = jSONObject.optString("type", "");
                jSONObject.remove(DbParams.KEY_IS_INSTANT_EVENT);
                if (!instanceEventType(optString) || !optBoolean) {
                    return 0;
                }
            } else {
                String optString2 = jSONObject.optString("type", "");
                String optString3 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
                List instantEvents = AbstractSensorsDataAPI.getConfigOptions().getInstantEvents();
                if (!instanceEventType(optString2) || TextUtils.isEmpty(optString3) || instantEvents == null || !instantEvents.contains(optString3)) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 0;
        }
    }
}
