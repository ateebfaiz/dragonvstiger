package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import org.json.JSONException;

public class ReferrerTitlePlugin extends SAPropertyPlugin {
    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        if (!sAPropertyFilter.getType().isTrack() || !"Android".equals(sAPropertyFilter.getEventJson(SAPropertyFilter.LIB).optString("$lib"))) {
            return false;
        }
        return true;
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        String str = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_GET_REFERRER_SCREEN_TITLE, new Object[0]);
        if (str != null) {
            try {
                if (!sAPropertiesFetcher.getProperties().has("$referrer_title")) {
                    sAPropertiesFetcher.getProperties().put("$referrer_title", str);
                }
            } catch (JSONException e10) {
                SALog.printStackTrace(e10);
            }
        }
    }
}
