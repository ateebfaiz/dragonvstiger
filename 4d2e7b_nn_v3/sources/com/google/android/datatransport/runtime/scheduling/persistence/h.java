package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class h implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6579a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f6580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6581c;

    public /* synthetic */ h(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f6579a = sQLiteEventStore;
        this.f6580b = eventInternal;
        this.f6581c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f6579a.lambda$persist$1(this.f6580b, this.f6581c, (SQLiteDatabase) obj);
    }
}
