package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

@Module
public abstract class EventStoreModule {
    @Provides
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Provides
    static String packageName(Context context) {
        return context.getPackageName();
    }

    @Provides
    static int schemaVersion() {
        return SchemaManager.f6545d;
    }

    @Provides
    static c storeConfig() {
        return c.f6569a;
    }

    /* access modifiers changed from: package-private */
    @Binds
    public abstract ClientHealthMetricsStore clientHealthMetricsStore(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);
}
