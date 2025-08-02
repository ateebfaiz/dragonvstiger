package com.sensorsdata.analytics.android.autotrack.core.plugins;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import java.util.Date;
import org.json.JSONObject;

public class AutoTrackEventPlugin extends SAPropertyPlugin {
    private String mEventName;

    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        this.mEventName = sAPropertyFilter.getEvent();
        if ("$AppStart".equals(sAPropertyFilter.getEvent()) || "$AppEnd".equals(sAPropertyFilter.getEvent())) {
            return true;
        }
        return false;
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            JSONObject properties = sAPropertiesFetcher.getProperties();
            JSONObject eventJson = sAPropertiesFetcher.getEventJson(SAPropertyFilter.LIB);
            long currentTimeMillis = System.currentTimeMillis();
            if ("$AppEnd".equals(this.mEventName)) {
                long optLong = properties.optLong("event_time");
                if (optLong > 2000) {
                    currentTimeMillis = optLong;
                }
                String optString = properties.optString("$lib_version");
                if (!TextUtils.isEmpty(optString)) {
                    eventJson.put("$lib_version", optString);
                } else {
                    properties.remove("$lib_version");
                }
                String optString2 = properties.optString("$app_version");
                if (TextUtils.isEmpty(optString2)) {
                    properties.remove("$app_version");
                } else {
                    eventJson.put("$app_version", optString2);
                }
                properties.remove("event_time");
            } else if ("$AppStart".equals(this.mEventName)) {
                long optLong2 = properties.optLong("event_time");
                if (optLong2 > 0) {
                    currentTimeMillis = optLong2;
                }
                properties.remove("event_time");
            }
            properties.put("$time", new Date(currentTimeMillis));
            sAPropertiesFetcher.setProperties(properties);
            sAPropertiesFetcher.setEventJson(SAPropertyFilter.LIB, eventJson);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
