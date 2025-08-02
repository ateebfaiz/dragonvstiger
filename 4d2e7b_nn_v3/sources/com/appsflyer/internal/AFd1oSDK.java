package com.appsflyer.internal;

import java.util.TimerTask;

public final class AFd1oSDK extends TimerTask {
    private final Thread AFKeystoreWrapper;

    public AFd1oSDK(Thread thread) {
        this.AFKeystoreWrapper = thread;
    }

    public final void run() {
        this.AFKeystoreWrapper.interrupt();
    }
}
