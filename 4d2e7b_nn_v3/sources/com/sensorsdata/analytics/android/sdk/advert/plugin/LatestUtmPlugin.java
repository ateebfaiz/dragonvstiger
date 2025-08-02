package com.sensorsdata.analytics.android.sdk.advert.plugin;

import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;

public class LatestUtmPlugin extends SAPropertyPlugin {
    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        if (!sAPropertyFilter.getType().isTrack() || "$AppEnd".equals(sAPropertyFilter.getEvent()) || SAAdvertConstants.EventName.DEEPLINK_LAUNCH.equals(sAPropertyFilter.getEvent())) {
            return false;
        }
        return true;
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        JSONUtils.mergeJSONObject(ChannelUtils.getLatestUtmProperties(), sAPropertiesFetcher.getProperties());
    }
}
