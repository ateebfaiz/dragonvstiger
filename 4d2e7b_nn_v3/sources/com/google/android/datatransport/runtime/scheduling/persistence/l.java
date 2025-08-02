package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class l implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6589a;

    public /* synthetic */ l(SQLiteEventStore sQLiteEventStore) {
        this.f6589a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f6589a.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
    }
}
