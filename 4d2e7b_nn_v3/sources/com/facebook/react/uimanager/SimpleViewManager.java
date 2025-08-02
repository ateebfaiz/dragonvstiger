package com.facebook.react.uimanager;

import android.view.View;
import kotlin.jvm.internal.m;

public abstract class SimpleViewManager<T extends View> extends BaseViewManager<T, v> {
    public Class<v> getShadowNodeClass() {
        return v.class;
    }

    public void updateExtraData(T t10, Object obj) {
        m.f(t10, "root");
    }

    public v createShadowNodeInstance() {
        return new v();
    }
}
