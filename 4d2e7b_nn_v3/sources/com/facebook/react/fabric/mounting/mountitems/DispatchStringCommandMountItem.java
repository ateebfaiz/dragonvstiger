package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.jvm.internal.m;

public final class DispatchStringCommandMountItem extends DispatchCommandMountItem {
    private final ReadableArray commandArgs;
    private final String commandId;
    private final int reactTag;
    private final int surfaceId;

    public DispatchStringCommandMountItem(int i10, int i11, String str, ReadableArray readableArray) {
        m.f(str, "commandId");
        this.surfaceId = i10;
        this.reactTag = i11;
        this.commandId = str;
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
        String str = this.commandId;
        return "DispatchStringCommandMountItem [" + i10 + "] " + str;
    }
}
