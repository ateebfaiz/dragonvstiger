package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class t implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f6599a;

    public /* synthetic */ t(long j10) {
        this.f6599a = j10;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getTimeWindow$22(this.f6599a, (SQLiteDatabase) obj);
    }
}
