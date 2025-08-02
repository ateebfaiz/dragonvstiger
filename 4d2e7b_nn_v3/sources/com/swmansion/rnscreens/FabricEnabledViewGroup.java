package com.swmansion.rnscreens;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.d1;

public abstract class FabricEnabledViewGroup extends ViewGroup {
    public FabricEnabledViewGroup(ReactContext reactContext) {
        super(reactContext);
    }

    public final void setStateWrapper(d1 d1Var) {
    }
}
