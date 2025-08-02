package com.swmansion.reanimated.layoutReanimation;

import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.i2;

public abstract class ReanimatedNativeHierarchyManagerBase extends c0 {
    public ReanimatedNativeHierarchyManagerBase(i2 i2Var) {
        super(i2Var);
    }

    public synchronized void updateLayout(int i10, int i11, int i12, int i13, int i14, int i15) {
        super.updateLayout(i10, i11, i12, i13, i14, i15);
        updateLayoutCommon(i10, i11, i12, i13, i14, i15);
    }

    public abstract void updateLayoutCommon(int i10, int i11, int i12, int i13, int i14, int i15);
}
