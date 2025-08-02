package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f9116a;

    public /* synthetic */ f(DefaultHeartBeatController defaultHeartBeatController) {
        this.f9116a = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f9116a.lambda$registerHeartBeat$0();
    }
}
