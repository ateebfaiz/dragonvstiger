package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.fabric.mounting.MountingManager;

final class SendAccessibilityEventMountItem implements MountItem {
    private final String TAG = "Fabric.SendAccessibilityEvent";
    private final int mEventType;
    private final int mReactTag;
    private final int mSurfaceId;

    SendAccessibilityEventMountItem(int i10, int i11, int i12) {
        this.mSurfaceId = i10;
        this.mReactTag = i11;
        this.mEventType = i12;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        try {
            mountingManager.sendAccessibilityEvent(this.mSurfaceId, this.mReactTag, this.mEventType);
        } catch (RetryableMountingLayerException e10) {
            ReactSoftExceptionLogger.logSoftException("Fabric.SendAccessibilityEvent", e10);
        }
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @NonNull
    public String toString() {
        return "SendAccessibilityEventMountItem [" + this.mReactTag + "] " + this.mEventType;
    }
}
