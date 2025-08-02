package com.facebook.react.runtime;

import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;

public final /* synthetic */ class r0 implements QueueThreadExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f3504a;

    public /* synthetic */ r0(ReactHostImpl reactHostImpl) {
        this.f3504a = reactHostImpl;
    }

    public final void handleException(Exception exc) {
        this.f3504a.B0(exc);
    }
}
