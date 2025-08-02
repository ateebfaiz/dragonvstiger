package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.jvm.internal.m;

public final class DispatchIntCommandMountItem extends DispatchCommandMountItem {
    private final ReadableArray commandArgs;
    private final int commandId;
    private final int reactTag;
    private final int surfaceId;

    public DispatchIntCommandMountItem(int i10, int i11, int i12, ReadableArray readableArray) {
        this.surfaceId = i10;
        this.reactTag = i11;
        this.commandId = i12;
        this.commandArgs = readableArray;
    }

    public void execute(MountingManager mountingManager) {
        m.f(mountingManager, "mountingManager");
        mountingManager.receiveCommand(this.surfaceId, this.reactTag, this.commandId, this.commandArgs);
    }

    public int getSurfaceId() {
        return this.surfaceId;
    }

    public String toString() {
        int i10 = this.reactTag;
        int i11 = this.commandId;
        return "DispatchIntCommandMountItem [" + i10 + "] " + i11;
    }
}
