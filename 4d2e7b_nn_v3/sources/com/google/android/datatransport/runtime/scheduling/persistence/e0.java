package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class e0 implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6578a;

    public /* synthetic */ e0(SQLiteEventStore sQLiteEventStore) {
        this.f6578a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f6578a.lambda$recordFailure$3((Cursor) obj);
    }
}
