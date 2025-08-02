package com.sensorsdata.analytics.android.sdk.advert.plugin;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class SAAdvertAppViewScreenPlugin extends SAPropertyPlugin {
    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        return "$AppViewScreen".equals(sAPropertyFilter.getEvent());
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        JSONObject jSONObject = new JSONObject();
        DeepLinkManager.mergeDeepLinkProperty(jSONObject);
        if (jSONObject.length() > 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    sAPropertiesFetcher.getProperties().put(next, jSONObject.opt(next));
                } catch (JSONException e10) {
                    SALog.printStackTrace(e10);
                }
            }
            DeepLinkManager.resetDeepLinkProcessor();
        }
    }
}
