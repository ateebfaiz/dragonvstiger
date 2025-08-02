package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class d implements SupportSQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16468a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16469b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16470c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16471d;

    /* renamed from: e  reason: collision with root package name */
    private final SupportSQLiteOpenHelper f16472e;

    /* renamed from: f  reason: collision with root package name */
    private DatabaseConfiguration f16473f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16474g;

    d(Context context, String str, File file, int i10, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.f16468a = context;
        this.f16469b = str;
        this.f16470c = file;
        this.f16471d = i10;
        this.f16472e = supportSQLiteOpenHelper;
    }

    private void a(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.f16469b != null) {
            readableByteChannel = Channels.newChannel(this.f16468a.getAssets().open(this.f16469b));
        } else if (this.f16470c != null) {
            readableByteChannel = new FileInputStream(this.f16470c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f16468a.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    private void h() {
        boolean z10;
        String databaseName = getDatabaseName();
        File databasePath = this.f16468a.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.f16473f;
        if (databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation) {
            z10 = true;
        } else {
            z10 = false;
        }
        CopyLock copyLock = new CopyLock(databaseName, this.f16468a.getFilesDir(), z10);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                a(databasePath);
                copyLock.unlock();
            } else if (this.f16473f == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    int i10 = this.f16471d;
                    if (readVersion == i10) {
                        copyLock.unlock();
                    } else if (this.f16473f.isMigrationRequired(readVersion, i10)) {
                        copyLock.unlock();
                    } else {
                        if (this.f16468a.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath);
                            } catch (IOException e10) {
                                Log.w("ROOM", "Unable to copy database file.", e10);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e11) {
                    Log.w("ROOM", "Unable to read database version.", e11);
                    copyLock.unlock();
                }
            }
        } catch (IOException e12) {
            throw new RuntimeException("Unable to copy database file.", e12);
        } catch (Throwable th) {
            copyLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(DatabaseConfiguration databaseConfiguration) {
        this.f16473f = databaseConfiguration;
    }

    public synchronized void close() {
        this.f16472e.close();
        this.f16474g = false;
    }

    public String getDatabaseName() {
        return this.f16472e.getDatabaseName();
    }

    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        try {
            if (!this.f16474g) {
                h();
                this.f16474g = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f16472e.getReadableDatabase();
    }

    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        try {
            if (!this.f16474g) {
                h();
                this.f16474g = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f16472e.getWritableDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f16472e.setWriteAheadLoggingEnabled(z10);
    }
}
