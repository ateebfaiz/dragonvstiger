package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class k implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f6587a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6588b;

    public /* synthetic */ k(long j10, TransportContext transportContext) {
        this.f6587a = j10;
        this.f6588b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordNextCallTime$7(this.f6587a, this.f6588b, (SQLiteDatabase) obj);
    }
}
