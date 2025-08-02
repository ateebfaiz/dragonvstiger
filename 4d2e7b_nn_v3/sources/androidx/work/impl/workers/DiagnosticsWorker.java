package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DiagnosticsWorker extends Worker {
    private static final String TAG = Logger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    private static String workSpecRow(@NonNull WorkSpec workSpec, @Nullable String str, @Nullable Integer num, @NonNull String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{workSpec.f17025id, workSpec.workerClassName, num, workSpec.state.name(), str, str2});
    }

    @NonNull
    private static String workSpecRows(@NonNull WorkNameDao workNameDao, @NonNull WorkTagDao workTagDao, @NonNull SystemIdInfoDao systemIdInfoDao, @NonNull List<WorkSpec> list) {
        Integer num;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{"Job Id"}));
        for (WorkSpec next : list) {
            SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(next.f17025id);
            if (systemIdInfo != null) {
                num = Integer.valueOf(systemIdInfo.systemId);
            } else {
                num = null;
            }
            sb2.append(workSpecRow(next, TextUtils.join(",", workNameDao.getNamesForWorkSpecId(next.f17025id)), num, TextUtils.join(",", workTagDao.getTagsForWorkSpecId(next.f17025id))));
        }
        return sb2.toString();
    }

    @NonNull
    public ListenableWorker.Result doWork() {
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        List<WorkSpec> recentlyCompletedWork = workSpecDao.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> runningWork = workSpecDao.getRunningWork();
        List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (recentlyCompletedWork != null && !recentlyCompletedWork.isEmpty()) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.info(str, "Recently completed work:\n\n", new Throwable[0]);
            Logger.get().info(str, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, recentlyCompletedWork), new Throwable[0]);
        }
        if (runningWork != null && !runningWork.isEmpty()) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            logger2.info(str2, "Running work:\n\n", new Throwable[0]);
            Logger.get().info(str2, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork), new Throwable[0]);
        }
        if (allEligibleWorkSpecsForScheduling != null && !allEligibleWorkSpecsForScheduling.isEmpty()) {
            Logger logger3 = Logger.get();
            String str3 = TAG;
            logger3.info(str3, "Enqueued work:\n\n", new Throwable[0]);
            Logger.get().info(str3, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling), new Throwable[0]);
        }
        return ListenableWorker.Result.success();
    }
}
