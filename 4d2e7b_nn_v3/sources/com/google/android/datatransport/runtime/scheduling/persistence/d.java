package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class d implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6572b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f6573c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f6574d;

    public /* synthetic */ d(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f6571a = sQLiteEventStore;
        this.f6572b = str;
        this.f6573c = map;
        this.f6574d = builder;
    }

    public final Object apply(Object obj) {
        return this.f6571a.lambda$loadClientMetrics$20(this.f6572b, this.f6573c, this.f6574d, (SQLiteDatabase) obj);
    }
}
