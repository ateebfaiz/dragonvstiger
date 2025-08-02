package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<String, JobParameters> mJobParameters = new HashMap();
    private WorkManagerImpl mWorkManagerImpl;

    @Nullable
    private static String getWorkSpecIdFromJobParameters(@NonNull JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = instance;
            instance.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    public void onExecuted(@NonNull String str, boolean z10) {
        JobParameters remove;
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        if (r2 < 24) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r3 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (j0.k.a(r9) == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        r3.triggeredContentUris = java.util.Arrays.asList(j0.k.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (j0.l.a(r9) == null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        r3.triggeredContentAuthorities = java.util.Arrays.asList(j0.l.a(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        if (r2 < 28) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r3.network = j0.m.a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a4, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        r8.mWorkManagerImpl.startWork(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(@androidx.annotation.NonNull android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.WorkManagerImpl r0 = r8.mWorkManagerImpl
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = TAG
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.debug(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = getWorkSpecIdFromJobParameters(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            androidx.work.Logger r9 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.error(r0, r1, r3)
            return r2
        L_0x002f:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.mJobParameters
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.mJobParameters     // Catch:{ all -> 0x0051 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x0051 }
            if (r4 == 0) goto L_0x0053
            androidx.work.Logger r9 = androidx.work.Logger.get()     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0051 }
            r1[r2] = r0     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x0051 }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x0051 }
            r9.debug(r4, r0, r1)     // Catch:{ all -> 0x0051 }
            monitor-exit(r3)     // Catch:{ all -> 0x0051 }
            return r2
        L_0x0051:
            r9 = move-exception
            goto L_0x00ab
        L_0x0053:
            androidx.work.Logger r4 = androidx.work.Logger.get()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x0051 }
            r7[r2] = r0     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x0051 }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x0051 }
            r4.debug(r5, r6, r2)     // Catch:{ all -> 0x0051 }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.mJobParameters     // Catch:{ all -> 0x0051 }
            r2.put(r0, r9)     // Catch:{ all -> 0x0051 }
            monitor-exit(r3)     // Catch:{ all -> 0x0051 }
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x00a4
            androidx.work.WorkerParameters$RuntimeExtras r3 = new androidx.work.WorkerParameters$RuntimeExtras
            r3.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L_0x0089
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.triggeredContentUris = r4
        L_0x0089:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x0099
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.triggeredContentAuthorities = r4
        L_0x0099:
            r4 = 28
            if (r2 < r4) goto L_0x00a5
            android.net.Network r9 = r9.getNetwork()
            r3.network = r9
            goto L_0x00a5
        L_0x00a4:
            r3 = 0
        L_0x00a5:
            androidx.work.impl.WorkManagerImpl r9 = r8.mWorkManagerImpl
            r9.startWork(r0, r3)
            return r1
        L_0x00ab:
            monitor-exit(r3)     // Catch:{ all -> 0x0051 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String workSpecIdFromJobParameters = getWorkSpecIdFromJobParameters(jobParameters);
        if (TextUtils.isEmpty(workSpecIdFromJobParameters)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(TAG, String.format("onStopJob for %s", new Object[]{workSpecIdFromJobParameters}), new Throwable[0]);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workSpecIdFromJobParameters);
        }
        this.mWorkManagerImpl.stopWork(workSpecIdFromJobParameters);
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workSpecIdFromJobParameters);
    }
}
