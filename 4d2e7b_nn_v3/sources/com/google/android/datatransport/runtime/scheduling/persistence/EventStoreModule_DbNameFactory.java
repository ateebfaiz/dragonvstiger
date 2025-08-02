package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class EventStoreModule_DbNameFactory implements Factory<String> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_DbNameFactory f6539a = new EventStoreModule_DbNameFactory();
    }

    public static EventStoreModule_DbNameFactory create() {
        return a.f6539a;
    }

    public static String dbName() {
        return (String) Preconditions.checkNotNull(EventStoreModule.dbName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String get() {
        return dbName();
    }
}
