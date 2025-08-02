package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

public final /* synthetic */ class f0 implements SchemaManager.Migration {
    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.n(sQLiteDatabase);
    }
}
