package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class s implements SQLiteEventStore.b {
    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadActiveContexts$10((SQLiteDatabase) obj);
    }
}
