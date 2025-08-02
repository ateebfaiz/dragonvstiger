package com.swmansion.reanimated;

import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.UIManagerModule;

public final /* synthetic */ class c implements UIManagerModule.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UIManager f11436a;

    public /* synthetic */ c(UIManager uIManager) {
        this.f11436a = uIManager;
    }

    public final String a(String str) {
        return this.f11436a.resolveCustomDirectEventName(str);
    }
}
