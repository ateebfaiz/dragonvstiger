package com.swmansion.worklets;

import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;

public final /* synthetic */ class c implements QueueThreadExceptionHandler {
    public final void handleException(Exception exc) {
        WorkletsMessageQueueThreadBase.b(exc);
    }
}
