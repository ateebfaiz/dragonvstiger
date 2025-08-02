package com.sensorsdata.analytics.android.sdk.core.event;

import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import org.json.JSONObject;

public class InputData {
    protected String mEventName;
    protected EventType mEventType;
    protected String mExtras;
    private String mItemId;
    private String mItemType;
    protected JSONObject mProperties;
    protected long mTime;

    public String getEventName() {
        return this.mEventName;
    }

    public EventType getEventType() {
        EventType eventType = this.mEventType;
        if (eventType == null) {
            return EventType.TRACK;
        }
        return eventType;
    }

    public String getExtras() {
        return this.mExtras;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getItemType() {
        return this.mItemType;
    }

    public JSONObject getProperties() {
        return this.mProperties;
    }

    public long getTime() {
        return this.mTime;
    }

    public InputData setEventName(String str) {
        this.mEventName = str;
        return this;
    }

    public InputData setEventType(EventType eventType) {
        this.mEventType = eventType;
        return this;
    }

    public InputData setExtras(String str) {
        this.mExtras = str;
        return this;
    }

    public InputData setItemId(String str) {
        this.mItemId = str;
        return this;
    }

    public InputData setItemType(String str) {
        this.mItemType = str;
        return this;
    }

    public InputData setProperties(JSONObject jSONObject) {
        this.mProperties = jSONObject;
        return this;
    }

    public void setTime(long j10) {
        this.mTime = j10;
    }
}
