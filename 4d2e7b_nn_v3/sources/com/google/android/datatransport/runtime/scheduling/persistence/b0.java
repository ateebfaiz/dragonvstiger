package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b0 implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6567a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6568b;

    public /* synthetic */ b0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f6567a = sQLiteEventStore;
        this.f6568b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f6567a.lambda$loadBatch$8(this.f6568b, (SQLiteDatabase) obj);
    }
}
