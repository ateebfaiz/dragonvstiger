package com.cocos.sdk;

import com.cocos.sdk.MahProxyController;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MahProxyController f19408a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MahProxyController.ProxySetupListener f19409b;

    public /* synthetic */ c(MahProxyController mahProxyController, MahProxyController.ProxySetupListener proxySetupListener) {
        this.f19408a = mahProxyController;
        this.f19409b = proxySetupListener;
    }

    public final void run() {
        this.f19408a.lambda$setWebviewProxy$0(this.f19409b);
    }
}
