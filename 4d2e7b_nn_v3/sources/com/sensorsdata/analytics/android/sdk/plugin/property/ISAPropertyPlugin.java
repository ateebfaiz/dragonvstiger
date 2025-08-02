package com.sensorsdata.analytics.android.sdk.plugin.property;

import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;

public interface ISAPropertyPlugin {
    String getName();

    boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter);

    SAPropertyPluginPriority priority();

    void properties(SAPropertiesFetcher sAPropertiesFetcher);
}
