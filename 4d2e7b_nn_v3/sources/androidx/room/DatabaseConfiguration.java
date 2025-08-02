package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    @Nullable
    public final List<RoomDatabase.Callback> callbacks;
    @NonNull
    public final Context context;
    @Nullable
    public final String copyFromAssetPath;
    @Nullable
    public final File copyFromFile;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    @Nullable
    public final String name;
    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;
    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    @NonNull
    public final Executor transactionExecutor;

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z10, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, boolean z11, @Nullable Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z10, journalMode2, executor, executor, false, z11, false, set, (String) null, (File) null);
    }

    public boolean isMigrationRequired(int i10, int i11) {
        if ((i10 > i11 && this.allowDestructiveMigrationOnDowngrade) || !this.requireMigration) {
            return false;
        }
        Set<Integer> set = this.mMigrationNotRequiredFrom;
        if (set == null || !set.contains(Integer.valueOf(i10))) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i10) {
        return isMigrationRequired(i10, i10 + 1);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z10, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z11, boolean z12, boolean z13, @Nullable Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z10, journalMode2, executor, executor2, z11, z12, z13, set, (String) null, (File) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z10, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z11, boolean z12, boolean z13, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context2;
        this.name = str;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z10;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = z11;
        this.requireMigration = z12;
        this.allowDestructiveMigrationOnDowngrade = z13;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
    }
}
