package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    private static WorkManagerImpl sDefaultInstance = null;
    private static WorkManagerImpl sDelegatedInstance = null;
    private static final Object sLock = new Object();
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SettableFuture f16966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreferenceUtils f16967b;

        a(SettableFuture settableFuture, PreferenceUtils preferenceUtils) {
            this.f16966a = settableFuture;
            this.f16967b = preferenceUtils;
        }

        public void run() {
            try {
                this.f16966a.set(Long.valueOf(this.f16967b.getLastCancelAllTimeMillis()));
            } catch (Throwable th) {
                this.f16966a.setException(th);
            }
        }
    }

    class b implements Function {
        b() {
        }

        /* renamed from: a */
        public WorkInfo apply(List list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return ((WorkSpec.WorkInfoPojo) list.get(0)).toWorkInfo();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                WorkManagerImpl workManagerImpl2 = sDefaultInstance;
                return workManagerImpl2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void initialize(@NonNull Context context, @NonNull Configuration configuration) {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    if (sDefaultInstance != null) {
                        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                    }
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (sDefaultInstance == null) {
                        sDefaultInstance = new WorkManagerImpl(applicationContext, configuration, new WorkManagerTaskExecutor(configuration.getTaskExecutor()));
                    }
                    sDelegatedInstance = sDefaultInstance;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void internalInit(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list, @NonNull Processor processor) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext.isDeviceProtectedStorage()) {
            this.mWorkTaskExecutor.executeOnBackgroundThread(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(@Nullable WorkManagerImpl workManagerImpl) {
        synchronized (sLock) {
            sDelegatedInstance = workManagerImpl;
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
        }
    }

    @NonNull
    public WorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, str, existingWorkPolicy, list);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @NonNull
    public WorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @NonNull
    public Operation cancelAllWork() {
        CancelWorkRunnable forAll = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forAll);
        return forAll.getOperation();
    }

    @NonNull
    public Operation cancelAllWorkByTag(@NonNull String str) {
        CancelWorkRunnable forTag = CancelWorkRunnable.forTag(str, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forTag);
        return forTag.getOperation();
    }

    @NonNull
    public Operation cancelUniqueWork(@NonNull String str) {
        CancelWorkRunnable forName = CancelWorkRunnable.forName(str, this, true);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forName);
        return forName.getOperation();
    }

    @NonNull
    public Operation cancelWorkById(@NonNull UUID uuid) {
        CancelWorkRunnable forId = CancelWorkRunnable.forId(uuid, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(forId);
        return forId.getOperation();
    }

    @NonNull
    public PendingIntent createCancelPendingIntent(@NonNull UUID uuid) {
        int i10;
        Intent createCancelWorkIntent = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, uuid.toString());
        if (BuildCompat.isAtLeastS()) {
            i10 = 167772160;
        } else {
            i10 = GameControllerManager.DEVICEFLAG_VIBRATION;
        }
        return PendingIntent.getService(this.mContext, 0, createCancelWorkIntent, i10);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> createSchedulers(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor) {
        return Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(context, this), new GreedyScheduler(context, configuration, taskExecutor, this)});
    }

    @NonNull
    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        ExistingWorkPolicy existingWorkPolicy;
        if (existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP) {
            existingWorkPolicy = ExistingWorkPolicy.KEEP;
        } else {
            existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        }
        return new WorkContinuationImpl(this, str, existingWorkPolicy, Collections.singletonList(periodicWorkRequest));
    }

    @NonNull
    public Operation enqueue(@NonNull List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @NonNull
    public Operation enqueueUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        return createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    @NonNull
    public Operation enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).enqueue();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @NonNull
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        SettableFuture create = SettableFuture.create();
        this.mWorkTaskExecutor.executeOnBackgroundThread(new a(create, this.mPreferenceUtils));
        return create;
    }

    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.mProcessor;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager == null) {
            synchronized (sLock) {
                try {
                    if (this.mRemoteWorkManager == null) {
                        tryInitializeMultiProcessSupport();
                        if (this.mRemoteWorkManager == null) {
                            if (!TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName())) {
                                throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.mRemoteWorkManager;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @NonNull
    public ListenableFuture<WorkInfo> getWorkInfoById(@NonNull UUID uuid) {
        StatusRunnable<WorkInfo> forUUID = StatusRunnable.forUUID(this, uuid);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forUUID);
        return forUUID.getFuture();
    }

    @NonNull
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(@NonNull UUID uuid) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(uuid.toString())), new b(), this.mWorkTaskExecutor);
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery workQuery) {
        StatusRunnable<List<WorkInfo>> forWorkQuerySpec = StatusRunnable.forWorkQuerySpec(this, workQuery);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forWorkQuerySpec);
        return forWorkQuerySpec.getFuture();
    }

    /* access modifiers changed from: package-private */
    public LiveData<List<WorkInfo>> getWorkInfosById(@NonNull List<String> list) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(list), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(@NonNull String str) {
        StatusRunnable<List<WorkInfo>> forTag = StatusRunnable.forTag(this, str);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forTag);
        return forTag.getFuture();
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@NonNull String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(@NonNull String str) {
        StatusRunnable<List<WorkInfo>> forUniqueWork = StatusRunnable.forUniqueWork(this, str);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(forUniqueWork);
        return forUniqueWork.getFuture();
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@NonNull String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(@NonNull WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.workQueryToRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(pruneWorkRunnable);
        return pruneWorkRunnable.getOperation();
    }

    public void rescheduleEligibleWork() {
        SystemJobScheduler.cancelAll(getApplicationContext());
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (sLock) {
            try {
                this.mRescheduleReceiverResult = pendingResult;
                if (this.mForceStopRunnableCompleted) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull String str) {
        startWork(str, (WorkerParameters.RuntimeExtras) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopForegroundWork(@NonNull String str) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, str, true));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopWork(@NonNull String str) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, str, false));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull String str, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StartWorkRunnable(this, str, runtimeExtras));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, boolean z10) {
        this(context, configuration, taskExecutor, WorkDatabase.create(context.getApplicationContext(), taskExecutor.getBackgroundExecutor(), z10));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(@NonNull Context context) {
        WorkManagerImpl instance;
        synchronized (sLock) {
            try {
                instance = getInstance();
                if (instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext instanceof Configuration.Provider) {
                        initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                        instance = getInstance(applicationContext);
                    } else {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return instance;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        Context context2 = context;
        Configuration configuration2 = configuration;
        TaskExecutor taskExecutor2 = taskExecutor;
        WorkDatabase workDatabase2 = workDatabase;
        List<Scheduler> createSchedulers = createSchedulers(applicationContext, configuration, taskExecutor);
        internalInit(context2, configuration2, taskExecutor2, workDatabase2, createSchedulers, new Processor(context2, configuration2, taskExecutor2, workDatabase2, createSchedulers));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list, @NonNull Processor processor) {
        internalInit(context, configuration, taskExecutor, workDatabase, list, processor);
    }
}
