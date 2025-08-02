package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.d1;
import z2.a;

final class PreAllocateViewMountItem implements MountItem {
    @NonNull
    private final String mComponent;
    @Nullable
    private final EventEmitterWrapper mEventEmitterWrapper;
    private final boolean mIsLayoutable;
    @Nullable
    private final ReadableMap mProps;
    private final int mReactTag;
    @Nullable
    private final d1 mStateWrapper;
    private final int mSurfaceId;

    PreAllocateViewMountItem(int i10, int i11, @NonNull String str, @Nullable ReadableMap readableMap, @Nullable d1 d1Var, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z10) {
        this.mComponent = FabricNameComponentMapping.getFabricComponentName(str);
        this.mSurfaceId = i10;
        this.mProps = readableMap;
        this.mStateWrapper = d1Var;
        this.mEventEmitterWrapper = eventEmitterWrapper;
        this.mReactTag = i11;
        this.mIsLayoutable = z10;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            String str = FabricUIManager.TAG;
            a.j(str, "Skipping View PreAllocation; no SurfaceMountingManager found for [" + this.mSurfaceId + "]");
            return;
        }
        surfaceManager.preallocateView(this.mComponent, this.mReactTag, this.mProps, this.mStateWrapper, this.mEventEmitterWrapper, this.mIsLayoutable);
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @NonNull
    public String toString() {
        return "PreAllocateViewMountItem [" + this.mReactTag + "] - component: " + this.mComponent + " surfaceId: " + this.mSurfaceId + " isLayoutable: " + this.mIsLayoutable;
    }
}
