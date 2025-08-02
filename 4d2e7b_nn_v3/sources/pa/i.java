package pa;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import kotlin.jvm.internal.m;
import na.b;

public final class i {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        m.f(sQLiteDatabase, "db");
        String n10 = m.n("_id,name", ",notification_id");
        String n11 = m.n("_id,name", ",channel_influence_id");
        try {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("CREATE TABLE cached_unique_outcome (_id INTEGER PRIMARY KEY,channel_influence_id TEXT,channel_type TEXT,name TEXT);");
            sQLiteDatabase.execSQL("INSERT INTO cached_unique_outcome(" + n11 + ") SELECT " + n10 + " FROM " + "cached_unique_outcome_notification" + ';');
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UPDATE cached_unique_outcome SET channel_type = '");
            sb2.append(b.NOTIFICATION);
            sb2.append("';");
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL("DROP TABLE " + "cached_unique_outcome_notification" + ';');
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.execSQL("COMMIT;");
            throw th;
        }
        sQLiteDatabase.execSQL("COMMIT;");
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        m.f(sQLiteDatabase, "db");
        try {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE outcome_backup(" + "_id,session,notification_ids,name,timestamp" + ");");
            sQLiteDatabase.execSQL("INSERT INTO outcome_backup SELECT " + "_id,session,notification_ids,name,timestamp" + " FROM outcome;");
            sQLiteDatabase.execSQL("DROP TABLE outcome;");
            sQLiteDatabase.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
            sQLiteDatabase.execSQL("INSERT INTO outcome (" + "_id,session,notification_ids,name,timestamp" + ", weight) SELECT " + "_id,session,notification_ids,name,timestamp" + ", 0 FROM outcome_backup;");
            sQLiteDatabase.execSQL("DROP TABLE outcome_backup;");
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.execSQL("COMMIT;");
            throw th;
        }
        sQLiteDatabase.execSQL("COMMIT;");
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        m.f(sQLiteDatabase, "db");
        String n10 = m.n("_id,name,timestamp,notification_ids,weight", ",session");
        String n11 = m.n("_id,name,timestamp,notification_ids,weight", ",notification_influence_type");
        try {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("ALTER TABLE outcome RENAME TO " + "outcome_aux" + ';');
            sQLiteDatabase.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
            sQLiteDatabase.execSQL("INSERT INTO outcome(" + n11 + ") SELECT " + n10 + " FROM " + "outcome_aux" + ';');
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DROP TABLE ");
            sb2.append("outcome_aux");
            sb2.append(';');
            sQLiteDatabase.execSQL(sb2.toString());
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.execSQL("COMMIT;");
            throw th;
        }
        sQLiteDatabase.execSQL("COMMIT;");
    }
}
