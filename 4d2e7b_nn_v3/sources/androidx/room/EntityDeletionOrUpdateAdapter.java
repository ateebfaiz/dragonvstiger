package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t10);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public final int handle(T t10) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t10);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i10 = 0;
            for (Object bind : iterable) {
                bind(acquire, bind);
                i10 += acquire.executeUpdateDelete();
            }
            return i10;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i10 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                i10 += acquire.executeUpdateDelete();
            }
            return i10;
        } finally {
            release(acquire);
        }
    }
}
