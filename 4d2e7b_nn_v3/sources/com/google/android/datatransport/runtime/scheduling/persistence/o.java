package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class o implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f6593a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6594b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f6595c;

    public /* synthetic */ o(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f6593a = sQLiteEventStore;
        this.f6594b = str;
        this.f6595c = str2;
    }

    public final Object apply(Object obj) {
        return this.f6593a.lambda$recordFailure$4(this.f6594b, this.f6595c, (SQLiteDatabase) obj);
    }
}
