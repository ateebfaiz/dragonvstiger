package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i10, int i11) {
        this.startVersion = i10;
        this.endVersion = i11;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
