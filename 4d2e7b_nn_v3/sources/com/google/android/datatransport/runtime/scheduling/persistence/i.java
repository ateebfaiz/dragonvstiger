package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class i implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6583b;

    public /* synthetic */ i(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f6582a = sQLiteEventStore;
        this.f6583b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f6582a.lambda$hasPendingEventsFor$6(this.f6583b, (SQLiteDatabase) obj);
    }
}
