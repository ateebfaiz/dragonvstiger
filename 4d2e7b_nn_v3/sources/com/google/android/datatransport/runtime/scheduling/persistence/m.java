package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class m implements SQLiteEventStore.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f6590a;

    public /* synthetic */ m(Map map) {
        this.f6590a = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$16(this.f6590a, (Cursor) obj);
    }
}
