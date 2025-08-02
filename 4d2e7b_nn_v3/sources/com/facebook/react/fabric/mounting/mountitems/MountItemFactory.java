package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.uimanager.d1;
import kotlin.jvm.internal.m;

public final class MountItemFactory {
    public static final MountItemFactory INSTANCE = new MountItemFactory();

    private MountItemFactory() {
    }

    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i10, int i11, int i12, ReadableArray readableArray) {
        return new DispatchIntCommandMountItem(i10, i11, i12, readableArray);
    }

    public static final MountItem createIntBufferBatchMountItem(int i10, int[] iArr, Object[] objArr, int i11) {
        m.f(iArr, "intBuf");
        m.f(objArr, "objBuf");
        return new IntBufferBatchMountItem(i10, iArr, objArr, i11);
    }

    public static final MountItem createPreAllocateViewMountItem(int i10, int i11, String str, ReadableMap readableMap, d1 d1Var, EventEmitterWrapper eventEmitterWrapper, boolean z10) {
        m.f(str, "component");
        return new PreAllocateViewMountItem(i10, i11, str, readableMap, d1Var, eventEmitterWrapper, z10);
    }

    public static final MountItem createSendAccessibilityEventMountItem(int i10, int i11, int i12) {
        return new SendAccessibilityEventMountItem(i10, i11, i12);
    }

    public static final DispatchCommandMountItem createDispatchCommandMountItem(int i10, int i11, String str, ReadableArray readableArray) {
        m.f(str, "commandId");
        return new DispatchStringCommandMountItem(i10, i11, str, readableArray);
    }
}
