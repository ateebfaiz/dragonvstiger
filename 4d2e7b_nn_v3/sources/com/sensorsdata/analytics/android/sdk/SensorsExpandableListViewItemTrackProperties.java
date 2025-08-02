package com.sensorsdata.analytics.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public interface SensorsExpandableListViewItemTrackProperties {
    JSONObject getSensorsChildItemTrackProperties(int i10, int i11) throws JSONException;

    JSONObject getSensorsGroupItemTrackProperties(int i10) throws JSONException;
}
