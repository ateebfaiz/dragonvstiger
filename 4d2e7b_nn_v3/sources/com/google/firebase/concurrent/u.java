package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class u implements Provider {
    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.factory("Firebase Scheduler", 0));
    }
}
