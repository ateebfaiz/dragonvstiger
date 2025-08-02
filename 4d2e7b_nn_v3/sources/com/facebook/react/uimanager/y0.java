package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.events.e;
import com.swmansion.reanimated.layoutReanimation.ReanimatedNativeHierarchyManager;

public class y0 extends j1 {
    public y0(ReactApplicationContext reactApplicationContext, i2 i2Var, e eVar, int i10) {
        super(reactApplicationContext, i2Var, new r1(reactApplicationContext, new ReanimatedNativeHierarchyManager(i2Var, reactApplicationContext), i10), eVar);
    }

    public void u(int i10, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        super.u(i10, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }
}
