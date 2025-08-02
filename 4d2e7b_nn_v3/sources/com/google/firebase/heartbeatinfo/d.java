package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f9114a;

    public /* synthetic */ d(DefaultHeartBeatController defaultHeartBeatController) {
        this.f9114a = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f9114a.lambda$getHeartBeatsHeader$1();
    }
}
