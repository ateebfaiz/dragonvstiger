package com.appsflyer.internal;

import android.hardware.SensorEvent;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFa1jSDK f18348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SensorEvent f18349b;

    public /* synthetic */ b(AFa1jSDK aFa1jSDK, SensorEvent sensorEvent) {
        this.f18348a = aFa1jSDK;
        this.f18349b = sensorEvent;
    }

    public final void run() {
        this.f18348a.values(this.f18349b);
    }
}
