package com.facebook.react.modules.debug;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DevSettingsModule f3250a;

    public /* synthetic */ b(DevSettingsModule devSettingsModule) {
        this.f3250a = devSettingsModule;
    }

    public final void run() {
        DevSettingsModule.reload$lambda$0(this.f3250a);
    }
}
