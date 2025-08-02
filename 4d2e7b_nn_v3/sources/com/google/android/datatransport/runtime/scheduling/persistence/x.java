package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class x implements SQLiteEventStore.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f6602a;

    public /* synthetic */ x(SQLiteDatabase sQLiteDatabase) {
        this.f6602a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f6602a.beginTransaction();
    }
}
