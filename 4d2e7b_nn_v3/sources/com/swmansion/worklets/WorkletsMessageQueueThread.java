package com.swmansion.worklets;

import d6.a;

@a
public class WorkletsMessageQueueThread extends WorkletsMessageQueueThreadBase {
    public boolean isIdle() {
        return this.f11696a.isIdle();
    }

    public boolean runOnQueue(Runnable runnable) {
        return this.f11696a.runOnQueue(runnable);
    }
}
