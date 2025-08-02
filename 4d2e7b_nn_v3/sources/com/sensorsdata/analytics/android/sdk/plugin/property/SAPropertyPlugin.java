package com.sensorsdata.analytics.android.sdk.plugin.property;

import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;

public abstract class SAPropertyPlugin implements ISAPropertyPlugin {
    public String getName() {
        return getClass().getName();
    }

    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack();
    }

    public SAPropertyPluginPriority priority() {
        return SAPropertyPluginPriority.DEFAULT;
    }

    public abstract void properties(SAPropertiesFetcher sAPropertiesFetcher);
}
