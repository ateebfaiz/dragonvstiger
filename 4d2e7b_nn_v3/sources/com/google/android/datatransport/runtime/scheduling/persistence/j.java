package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class j implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f6585b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f6586c;

    public /* synthetic */ j(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f6584a = sQLiteEventStore;
        this.f6585b = map;
        this.f6586c = builder;
    }

    public final Object apply(Object obj) {
        return this.f6584a.lambda$loadClientMetrics$19(this.f6585b, this.f6586c, (Cursor) obj);
    }
}
