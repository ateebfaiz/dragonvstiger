package com.sensorsdata.analytics.android.sdk.plugin.property.beans;

import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SAPropertyFilter {
    public static final String IDENTITIES = "identities";
    public static final String LIB = "lib";
    public static final String PROPERTIES = "properties";
    private String event;
    private final Map<String, JSONObject> eventJson = new HashMap();
    long time;
    private EventType type;

    public String getEvent() {
        return this.event;
    }

    public JSONObject getEventJson(String str) {
        return this.eventJson.get(str);
    }

    public JSONObject getProperties() {
        return this.eventJson.get(PROPERTIES);
    }

    public long getTime() {
        return this.time;
    }

    public EventType getType() {
        return this.type;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setEventJson(String str, JSONObject jSONObject) {
        this.eventJson.put(str, jSONObject);
    }

    public void setProperties(JSONObject jSONObject) {
        this.eventJson.put(PROPERTIES, jSONObject);
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public void setType(EventType eventType) {
        this.type = eventType;
    }

    public String toString() {
        return "SAPropertyFilter{event='" + this.event + '\'' + ", type=" + this.type + ", time=" + this.time + ", eventJson=" + this.eventJson + '}';
    }
}
