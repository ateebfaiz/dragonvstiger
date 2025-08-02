package com.sensorsdata.analytics.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataGPSLocation {
    private String coordinate;
    private long latitude;
    private long longitude;

    public final class CoordinateType {
        public static final String BD09 = "BD09";
        public static final String GCJ02 = "GCJ02";
        public static final String WGS84 = "WGS84";

        public CoordinateType() {
        }
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public long getLatitude() {
        return this.latitude;
    }

    public long getLongitude() {
        return this.longitude;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }

    public void setLatitude(long j10) {
        this.latitude = j10;
    }

    public void setLongitude(long j10) {
        this.longitude = j10;
    }

    public void toJSON(JSONObject jSONObject) {
        try {
            jSONObject.put("$latitude", this.latitude);
            jSONObject.put("$longitude", this.longitude);
            jSONObject.put("$geo_coordinate_system", this.coordinate);
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }
}
