package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

final class o extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzea f7651a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(zzea zzea, Context context, String str) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f7651a = zzea;
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e10) {
            throw e10;
        } catch (SQLiteException unused) {
            this.f7651a.zzt.zzay().zzd().zza("Opening the local database failed, dropping and recreating it");
            this.f7651a.zzt.zzf();
            if (!this.f7651a.zzt.zzau().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.f7651a.zzt.zzay().zzd().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e11) {
                this.f7651a.zzt.zzay().zzd().zzb("Failed to open local database. Events will bypass local storage", e11);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzan.zzb(this.f7651a.zzt.zzay(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzan.zza(this.f7651a.zzt.zzay(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", (String[]) null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
