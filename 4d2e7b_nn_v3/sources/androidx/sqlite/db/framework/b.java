package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class b implements SupportSQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16503a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16504b;

    /* renamed from: c  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Callback f16505c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16506d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f16507e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a f16508f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16509g;

    static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final a[] f16510a;

        /* renamed from: b  reason: collision with root package name */
        final SupportSQLiteOpenHelper.Callback f16511b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16512c;

        /* renamed from: androidx.sqlite.db.framework.b$a$a  reason: collision with other inner class name */
        class C0215a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SupportSQLiteOpenHelper.Callback f16513a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a[] f16514b;

            C0215a(SupportSQLiteOpenHelper.Callback callback, a[] aVarArr) {
                this.f16513a = callback;
                this.f16514b = aVarArr;
            }

            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f16513a.onCorruption(a.h(this.f16514b, sQLiteDatabase));
            }
        }

        a(Context context, String str, a[] aVarArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, callback.version, new C0215a(callback, aVarArr));
            this.f16511b = callback;
            this.f16510a = aVarArr;
        }

        static a h(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        /* access modifiers changed from: package-private */
        public synchronized SupportSQLiteDatabase a() {
            this.f16512c = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (this.f16512c) {
                close();
                return a();
            }
            return b(readableDatabase);
        }

        /* access modifiers changed from: package-private */
        public a b(SQLiteDatabase sQLiteDatabase) {
            return h(this.f16510a, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f16510a[0] = null;
        }

        /* access modifiers changed from: package-private */
        public synchronized SupportSQLiteDatabase j() {
            this.f16512c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f16512c) {
                close();
                return j();
            }
            return b(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f16511b.onConfigure(b(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f16511b.onCreate(b(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f16512c = true;
            this.f16511b.onDowngrade(b(sQLiteDatabase), i10, i11);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f16512c) {
                this.f16511b.onOpen(b(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f16512c = true;
            this.f16511b.onUpgrade(b(sQLiteDatabase), i10, i11);
        }
    }

    b(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z10) {
        this.f16503a = context;
        this.f16504b = str;
        this.f16505c = callback;
        this.f16506d = z10;
    }

    private a a() {
        a aVar;
        synchronized (this.f16507e) {
            try {
                if (this.f16508f == null) {
                    a[] aVarArr = new a[1];
                    if (this.f16504b == null || !this.f16506d) {
                        this.f16508f = new a(this.f16503a, this.f16504b, aVarArr, this.f16505c);
                    } else {
                        this.f16508f = new a(this.f16503a, new File(this.f16503a.getNoBackupFilesDir(), this.f16504b).getAbsolutePath(), aVarArr, this.f16505c);
                    }
                    this.f16508f.setWriteAheadLoggingEnabled(this.f16509g);
                }
                aVar = this.f16508f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void close() {
        a().close();
    }

    public String getDatabaseName() {
        return this.f16504b;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return a().a();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return a().j();
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f16507e) {
            try {
                a aVar = this.f16508f;
                if (aVar != null) {
                    aVar.setWriteAheadLoggingEnabled(z10);
                }
                this.f16509g = z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
