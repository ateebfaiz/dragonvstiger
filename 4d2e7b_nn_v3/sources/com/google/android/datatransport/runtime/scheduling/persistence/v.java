package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class v implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f6600a;

    public /* synthetic */ v(long j10) {
        this.f6600a = j10;
    }

    public final Object apply(Object obj) {
        return ((Cursor) obj).moveToNext();
    }
}
