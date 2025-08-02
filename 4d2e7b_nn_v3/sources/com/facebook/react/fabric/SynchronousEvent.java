package com.facebook.react.fabric;

import kotlin.jvm.internal.m;

public final class SynchronousEvent {
    private final String eventName;
    private final int surfaceId;
    private final int viewTag;

    public SynchronousEvent(int i10, int i11, String str) {
        m.f(str, "eventName");
        this.surfaceId = i10;
        this.viewTag = i11;
        this.eventName = str;
    }

    public static /* synthetic */ SynchronousEvent copy$default(SynchronousEvent synchronousEvent, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = synchronousEvent.surfaceId;
        }
        if ((i12 & 2) != 0) {
            i11 = synchronousEvent.viewTag;
        }
        if ((i12 & 4) != 0) {
            str = synchronousEvent.eventName;
        }
        return synchronousEvent.copy(i10, i11, str);
    }

    public final int component1() {
        return this.surfaceId;
    }

    public final int component2() {
        return this.viewTag;
    }

    public final String component3() {
        return this.eventName;
    }

    public final SynchronousEvent copy(int i10, int i11, String str) {
        m.f(str, "eventName");
        return new SynchronousEvent(i10, i11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SynchronousEvent)) {
            return false;
        }
        SynchronousEvent synchronousEvent = (SynchronousEvent) obj;
        return this.surfaceId == synchronousEvent.surfaceId && this.viewTag == synchronousEvent.viewTag && m.b(this.eventName, synchronousEvent.eventName);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    public int hashCode() {
        return (((this.surfaceId * 31) + this.viewTag) * 31) + this.eventName.hashCode();
    }

    public String toString() {
        int i10 = this.surfaceId;
        int i11 = this.viewTag;
        String str = this.eventName;
        return "SynchronousEvent(surfaceId=" + i10 + ", viewTag=" + i11 + ", eventName=" + str + ")";
    }
}
