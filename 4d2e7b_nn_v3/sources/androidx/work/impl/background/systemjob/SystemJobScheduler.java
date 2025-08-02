package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final a mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void cancelAll(@NonNull Context context) {
        List<JobInfo> pendingJobs;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            for (JobInfo id2 : pendingJobs) {
                cancelJobById(jobScheduler, id2.getId());
            }
        }
    }

    private static void cancelJobById(@NonNull JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i10)}), th);
        }
    }

    @Nullable
    private static List<Integer> getPendingJobIds(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : pendingJobs) {
            if (str.equals(getWorkSpecIdFromJobInfo(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    @Nullable
    private static List<JobInfo> getPendingJobs(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Nullable
    private static String getWorkSpecIdFromJobInfo(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean reconcileJobs(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        int i10;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        List<String> workSpecIds = workManagerImpl.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean z10 = false;
        if (pendingJobs != null) {
            i10 = pendingJobs.size();
        } else {
            i10 = 0;
        }
        HashSet hashSet = new HashSet(i10);
        if (pendingJobs != null && !pendingJobs.isEmpty()) {
            for (JobInfo next : pendingJobs) {
                String workSpecIdFromJobInfo = getWorkSpecIdFromJobInfo(next);
                if (!TextUtils.isEmpty(workSpecIdFromJobInfo)) {
                    hashSet.add(workSpecIdFromJobInfo);
                } else {
                    cancelJobById(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it = workSpecIds.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    Logger.get().debug(TAG, "Reconciling jobs", new Throwable[0]);
                    z10 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z10) {
            WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                for (String markWorkSpecScheduled : workSpecIds) {
                    workSpecDao.markWorkSpecScheduled(markWorkSpecScheduled, -1);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
        return z10;
    }

    public void cancel(@NonNull String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (pendingJobIds != null && !pendingJobIds.isEmpty()) {
            for (Integer intValue : pendingJobIds) {
                cancelJobById(this.mJobScheduler, intValue.intValue());
            }
            this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
        }
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        int i10;
        List<Integer> pendingJobIds;
        int i11;
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        int length = workSpecArr.length;
        int i12 = 0;
        while (i12 < length) {
            WorkSpec workSpec = workSpecArr[i12];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.f17025id);
                if (workSpec2 == null) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.f17025id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.f17025id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.f17025id);
                    if (systemIdInfo != null) {
                        i10 = systemIdInfo.systemId;
                    } else {
                        i10 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                    }
                    if (systemIdInfo == null) {
                        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workSpec.f17025id, i10));
                    }
                    scheduleInternal(workSpec, i10);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.f17025id)) != null) {
                        int indexOf = pendingJobIds.indexOf(Integer.valueOf(i10));
                        if (indexOf >= 0) {
                            pendingJobIds.remove(indexOf);
                        }
                        if (!pendingJobIds.isEmpty()) {
                            i11 = pendingJobIds.get(0).intValue();
                        } else {
                            i11 = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                        }
                        scheduleInternal(workSpec, i11);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                i12++;
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    @VisibleForTesting
    public void scheduleInternal(WorkSpec workSpec, int i10) {
        int i11;
        JobInfo a10 = this.mSystemJobInfoConverter.a(workSpec, i10);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Scheduling work ID %s Job ID %s", new Object[]{workSpec.f17025id, Integer.valueOf(i10)}), new Throwable[0]);
        try {
            if (this.mJobScheduler.schedule(a10) == 0) {
                Logger.get().warning(str, String.format("Unable to schedule work ID %s", new Object[]{workSpec.f17025id}), new Throwable[0]);
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.f17025id}), new Throwable[0]);
                    scheduleInternal(workSpec, i10);
                }
            }
        } catch (IllegalStateException e10) {
            List<JobInfo> pendingJobs = getPendingJobs(this.mContext, this.mJobScheduler);
            if (pendingJobs != null) {
                i11 = pendingJobs.size();
            } else {
                i11 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i11), Integer.valueOf(this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mWorkManager.getConfiguration().getMaxSchedulerLimit())});
            Logger.get().error(TAG, format, new Throwable[0]);
            throw new IllegalStateException(format, e10);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format("Unable to schedule %s", new Object[]{workSpec}), th);
        }
    }

    @VisibleForTesting
    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, a aVar) {
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = aVar;
    }
}
