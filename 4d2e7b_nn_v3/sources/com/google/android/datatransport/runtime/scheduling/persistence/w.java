package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class w implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6601a;

    public /* synthetic */ w(SQLiteEventStore sQLiteEventStore) {
        this.f6601a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f6601a.lambda$cleanUp$11((Cursor) obj);
    }
}
