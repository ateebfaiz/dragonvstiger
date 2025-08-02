package org.cocos2dx.javascript.sdk.engagelab;

public class StatusObserver {
    private static volatile StatusObserver instance;
    private OnStatusListener onStatusListener;

    public static StatusObserver getInstance() {
        if (instance == null) {
            synchronized (StatusObserver.class) {
                instance = new StatusObserver();
            }
        }
        return instance;
    }

    public void addListener(OnStatusListener onStatusListener2) {
        this.onStatusListener = onStatusListener2;
    }

    public OnStatusListener getListener() {
        return this.onStatusListener;
    }

    public void removeListener() {
        this.onStatusListener = null;
    }
}
