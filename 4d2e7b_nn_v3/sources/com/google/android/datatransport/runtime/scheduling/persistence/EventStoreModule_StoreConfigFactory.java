package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class EventStoreModule_StoreConfigFactory implements Factory<c> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_StoreConfigFactory f6541a = new EventStoreModule_StoreConfigFactory();
    }

    public static EventStoreModule_StoreConfigFactory create() {
        return a.f6541a;
    }

    public static c storeConfig() {
        return (c) Preconditions.checkNotNull(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public c get() {
        return storeConfig();
    }
}
