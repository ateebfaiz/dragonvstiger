package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

final class SchemaManager extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private static final String f6544c = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");

    /* renamed from: d  reason: collision with root package name */
    static int f6545d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static final Migration f6546e;

    /* renamed from: f  reason: collision with root package name */
    private static final Migration f6547f;

    /* renamed from: g  reason: collision with root package name */
    private static final Migration f6548g;

    /* renamed from: h  reason: collision with root package name */
    private static final Migration f6549h;

    /* renamed from: i  reason: collision with root package name */
    private static final Migration f6550i;

    /* renamed from: j  reason: collision with root package name */
    private static final List f6551j;

    /* renamed from: a  reason: collision with root package name */
    private final int f6552a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6553b = false;

    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    static {
        f0 f0Var = new f0();
        f6546e = f0Var;
        g0 g0Var = new g0();
        f6547f = g0Var;
        h0 h0Var = new h0();
        f6548g = h0Var;
        i0 i0Var = new i0();
        f6549h = i0Var;
        j0 j0Var = new j0();
        f6550i = j0Var;
        f6551j = Arrays.asList(new Migration[]{f0Var, g0Var, h0Var, i0Var, j0Var});
    }

    SchemaManager(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f6552a = i10;
    }

    private void A(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List list = f6551j;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                ((Migration) f6551j.get(i10)).upgrade(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    private void m(SQLiteDatabase sQLiteDatabase) {
        if (!this.f6553b) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void p(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f6544c);
    }

    private void z(SQLiteDatabase sQLiteDatabase, int i10) {
        m(sQLiteDatabase);
        A(sQLiteDatabase, 0, i10);
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f6553b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        z(sQLiteDatabase, this.f6552a);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        z(sQLiteDatabase, i11);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        m(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        m(sQLiteDatabase);
        A(sQLiteDatabase, i10, i11);
    }
}
