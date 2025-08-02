package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;

public class RealTimePropertyPlugin extends SAPropertyPlugin {
    Context mContext;
    SAContextManager mContextManager;

    public RealTimePropertyPlugin(SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
        this.mContextManager = sAContextManager;
    }

    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        if (!sAPropertyFilter.getType().isTrack() || !"Android".equals(sAPropertyFilter.getEventJson(SAPropertyFilter.LIB).optString("$lib"))) {
            return false;
        }
        return true;
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            String networkType = NetworkUtils.networkType(this.mContext);
            sAPropertiesFetcher.getProperties().put("$wifi", "WIFI".equals(networkType));
            sAPropertiesFetcher.getProperties().put("$network_type", networkType);
            SensorsDataGPSLocation sensorsDataGPSLocation = this.mContextManager.getInternalConfigs().gpsLocation;
            if (sensorsDataGPSLocation != null) {
                sensorsDataGPSLocation.toJSON(sAPropertiesFetcher.getProperties());
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        try {
            String screenOrientation = SensorsDataAPI.sharedInstance().getScreenOrientation();
            if (!TextUtils.isEmpty(screenOrientation)) {
                sAPropertiesFetcher.getProperties().put("$screen_orientation", screenOrientation);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
