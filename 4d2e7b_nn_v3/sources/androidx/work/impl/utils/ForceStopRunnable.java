package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import com.google.android.games.paddleboat.GameControllerManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {
    @VisibleForTesting
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    @VisibleForTesting
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private int mRetryCount = 0;
    private final WorkManagerImpl mWorkManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(@NonNull Context context, @Nullable Intent intent) {
            if (intent != null && ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.setAlarm(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    @VisibleForTesting
    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void setAlarm(Context context) {
        int i10;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (BuildCompat.isAtLeastS()) {
            i10 = 167772160;
        } else {
            i10 = GameControllerManager.DEVICEFLAG_VIBRATION;
        }
        PendingIntent pendingIntent = getPendingIntent(context, i10);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    @VisibleForTesting
    public boolean cleanUp() {
        boolean z10;
        boolean reconcileJobs = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager);
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            if (runningWork == null || runningWork.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                for (WorkSpec next : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, next.f17025id);
                    workSpecDao.markWorkSpecScheduled(next.f17025id, -1);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (z10 || reconcileJobs) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    @VisibleForTesting
    public void forceStopRunnable() {
        boolean cleanUp = cleanUp();
        if (shouldRescheduleWorkers()) {
            Logger.get().debug(TAG, "Rescheduling Workers.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
            this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        } else if (isForceStopped()) {
            Logger.get().debug(TAG, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
        } else if (cleanUp) {
            Logger.get().debug(TAG, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        }
    }

    @VisibleForTesting
    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        int i10;
        try {
            if (BuildCompat.isAtLeastS()) {
                i10 = 570425344;
            } else {
                i10 = 536870912;
            }
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i10);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                List a10 = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a10 != null && !a10.isEmpty()) {
                    for (int i11 = 0; i11 < a10.size(); i11++) {
                        if (b.a(a10.get(i11)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntent == null) {
                setAlarm(this.mContext);
                return true;
            }
            return false;
        } catch (SecurityException e10) {
            e = e10;
            Logger.get().warning(TAG, "Ignoring exception", e);
            return true;
        } catch (IllegalArgumentException e11) {
            e = e11;
            Logger.get().warning(TAG, "Ignoring exception", e);
            return true;
        }
    }

    @VisibleForTesting
    public boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty(configuration.getDefaultProcessName())) {
            Logger.get().debug(TAG, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean isDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, configuration);
        Logger.get().debug(TAG, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(isDefaultProcess)}), new Throwable[0]);
        return isDefaultProcess;
    }

    public void run() {
        try {
            if (!multiProcessChecks()) {
                this.mWorkManager.onForceStopRunnableCompleted();
                return;
            }
            while (true) {
                WorkDatabasePathHelper.migrateDatabase(this.mContext);
                Logger.get().debug(TAG, "Performing cleanup operations.", new Throwable[0]);
                forceStopRunnable();
                break;
            }
            this.mWorkManager.onForceStopRunnableCompleted();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
            int i10 = this.mRetryCount + 1;
            this.mRetryCount = i10;
            if (i10 >= 3) {
                Logger logger = Logger.get();
                String str = TAG;
                logger.error(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                InitializationExceptionHandler exceptionHandler = this.mWorkManager.getConfiguration().getExceptionHandler();
                if (exceptionHandler != null) {
                    Logger.get().debug(str, "Routing exception to the specified exception handler", illegalStateException);
                    exceptionHandler.handleException(illegalStateException);
                } else {
                    throw illegalStateException;
                }
            } else {
                long j10 = ((long) i10) * BACKOFF_DURATION_MS;
                Logger.get().debug(TAG, String.format("Retrying after %s", new Object[]{Long.valueOf(j10)}), e10);
                sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
            }
        } catch (Throwable th) {
            this.mWorkManager.onForceStopRunnableCompleted();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    @VisibleForTesting
    public void sleep(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }
}
