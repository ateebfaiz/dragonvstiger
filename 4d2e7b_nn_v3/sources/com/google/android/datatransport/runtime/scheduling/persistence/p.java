package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class p implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6596a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f6597b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f6598c;

    public /* synthetic */ p(String str, LogEventDropped.Reason reason, long j10) {
        this.f6596a = str;
        this.f6597b = reason;
        this.f6598c = j10;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f6596a, this.f6597b, this.f6598c, (SQLiteDatabase) obj);
    }
}
