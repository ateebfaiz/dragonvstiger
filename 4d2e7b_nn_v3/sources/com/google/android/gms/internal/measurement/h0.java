package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class h0 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f7183a = Executors.defaultThreadFactory();

    h0(zzef zzef) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f7183a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
