package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class c0 implements SQLiteEventStore.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchemaManager f6570a;

    public /* synthetic */ c0(SchemaManager schemaManager) {
        this.f6570a = schemaManager;
    }

    public final Object a() {
        return this.f6570a.getWritableDatabase();
    }
}
