package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

public final /* synthetic */ class e implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6575a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f6576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6577c;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f6575a = sQLiteEventStore;
        this.f6576b = list;
        this.f6577c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f6575a.lambda$loadEvents$14(this.f6576b, this.f6577c, (Cursor) obj);
    }
}
