package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class n implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6591a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f6592b;

    public /* synthetic */ n(SQLiteEventStore sQLiteEventStore, long j10) {
        this.f6591a = sQLiteEventStore;
        this.f6592b = j10;
    }

    public final Object apply(Object obj) {
        return this.f6591a.lambda$cleanUp$12(this.f6592b, (SQLiteDatabase) obj);
    }
}
