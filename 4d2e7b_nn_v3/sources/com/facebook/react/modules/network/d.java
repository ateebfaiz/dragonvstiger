package com.facebook.react.modules.network;

import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;

public final /* synthetic */ class d implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callback f3320a;

    public /* synthetic */ d(Callback callback) {
        this.f3320a = callback;
    }

    public final void onReceiveValue(Object obj) {
        this.f3320a.invoke((Boolean) obj);
    }
}
