package com.cocos.sdk;

import android.util.Log;
import com.mah.sdk.MahProxy;

public final /* synthetic */ class b implements MahProxy.ProxyListener {
    public final void onProxyChanged(String str, int i10, MahProxy.ProxyChangedReason proxyChangedReason) {
        Log.i(MahProxyController.TAG, "host=" + str + ", port=" + i10 + ", reason=" + proxyChangedReason);
    }
}
