package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class IdGenerator {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    private final WorkDatabase mWorkDatabase;

    public IdGenerator(@NonNull WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public static void migrateLegacyIdGenerator(@NonNull Context context, @NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY) || sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            int i10 = sharedPreferences.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
            int i11 = sharedPreferences.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(i10)});
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(i11)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    private int nextId(String str) {
        int i10;
        this.mWorkDatabase.beginTransaction();
        try {
            Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(str);
            int i11 = 0;
            if (longValue != null) {
                i10 = longValue.intValue();
            } else {
                i10 = 0;
            }
            if (i10 != Integer.MAX_VALUE) {
                i11 = i10 + 1;
            }
            update(str, i11);
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            return i10;
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    private void update(String str, int i10) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(str, (long) i10));
    }

    public int nextAlarmManagerId() {
        int nextId;
        synchronized (IdGenerator.class) {
            nextId = nextId(NEXT_ALARM_MANAGER_ID_KEY);
        }
        return nextId;
    }

    public int nextJobSchedulerIdWithRange(int i10, int i11) {
        synchronized (IdGenerator.class) {
            int nextId = nextId(NEXT_JOB_SCHEDULER_ID_KEY);
            if (nextId >= i10) {
                if (nextId <= i11) {
                    i10 = nextId;
                }
            }
            update(NEXT_JOB_SCHEDULER_ID_KEY, i10 + 1);
        }
        return i10;
    }
}
