package com.sensorsdata.analytics.android.sdk.core.eventbus;

public abstract class Subscription<T> {
    String eventTag;

    public abstract void notify(T t10);
}
