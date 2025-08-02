package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_SchemaVersionFactory f6540a = new EventStoreModule_SchemaVersionFactory();
    }

    public static EventStoreModule_SchemaVersionFactory create() {
        return a.f6540a;
    }

    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
