package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkerWrapper implements Runnable {
    static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    @NonNull
    SettableFuture<Boolean> mFuture = SettableFuture.create();
    @Nullable
    ListenableFuture<ListenableWorker.Result> mInnerFuture = null;
    private volatile boolean mInterrupted;
    @NonNull
    ListenableWorker.Result mResult = ListenableWorker.Result.failure();
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private String mWorkSpecId;
    private WorkTagDao mWorkTagDao;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Builder {
        @NonNull
        Context mAppContext;
        @NonNull
        Configuration mConfiguration;
        @NonNull
        ForegroundProcessor mForegroundProcessor;
        @NonNull
        WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        List<Scheduler> mSchedulers;
        @NonNull
        WorkDatabase mWorkDatabase;
        @NonNull
        String mWorkSpecId;
        @NonNull
        TaskExecutor mWorkTaskExecutor;
        @Nullable
        ListenableWorker mWorker;

        public Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ForegroundProcessor foregroundProcessor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = taskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = workDatabase;
            this.mWorkSpecId = str;
        }

        @NonNull
        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public Builder withRuntimeExtras(@Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.mRuntimeExtras = runtimeExtras;
            }
            return this;
        }

        @NonNull
        public Builder withSchedulers(@NonNull List<Scheduler> list) {
            this.mSchedulers = list;
            return this;
        }

        @VisibleForTesting
        @NonNull
        public Builder withWorker(@NonNull ListenableWorker listenableWorker) {
            this.mWorker = listenableWorker;
            return this;
        }
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ListenableFuture f16970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SettableFuture f16971b;

        a(ListenableFuture listenableFuture, SettableFuture settableFuture) {
            this.f16970a = listenableFuture;
            this.f16971b = settableFuture;
        }

        public void run() {
            try {
                this.f16970a.get();
                Logger.get().debug(WorkerWrapper.TAG, String.format("Starting work for %s", new Object[]{WorkerWrapper.this.mWorkSpec.workerClassName}), new Throwable[0]);
                WorkerWrapper workerWrapper = WorkerWrapper.this;
                workerWrapper.mInnerFuture = workerWrapper.mWorker.startWork();
                this.f16971b.setFuture(WorkerWrapper.this.mInnerFuture);
            } catch (Throwable th) {
                this.f16971b.setException(th);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SettableFuture f16973a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16974b;

        b(SettableFuture settableFuture, String str) {
            this.f16973a = settableFuture;
            this.f16974b = str;
        }

        public void run() {
            try {
                ListenableWorker.Result result = (ListenableWorker.Result) this.f16973a.get();
                if (result == null) {
                    Logger.get().error(WorkerWrapper.TAG, String.format("%s returned a null result. Treating it as a failure.", new Object[]{WorkerWrapper.this.mWorkSpec.workerClassName}), new Throwable[0]);
                } else {
                    Logger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", new Object[]{WorkerWrapper.this.mWorkSpec.workerClassName, result}), new Throwable[0]);
                    WorkerWrapper.this.mResult = result;
                }
            } catch (CancellationException e10) {
                Logger.get().info(WorkerWrapper.TAG, String.format("%s was cancelled", new Object[]{this.f16974b}), e10);
            } catch (InterruptedException e11) {
                e = e11;
                Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", new Object[]{this.f16974b}), e);
            } catch (ExecutionException e12) {
                e = e12;
                Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", new Object[]{this.f16974b}), e);
            } catch (Throwable th) {
                WorkerWrapper.this.onWorkFinished();
                throw th;
            }
            WorkerWrapper.this.onWorkFinished();
        }
    }

    WorkerWrapper(@NonNull Builder builder) {
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    private String createWorkDescription(List<String> list) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.mWorkSpecId);
        sb2.append(", tags={ ");
        boolean z10 = true;
        for (String next : list) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(next);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    private void handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(TAG, String.format("Worker result SUCCESS for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setSucceededAndResolve();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(TAG, String.format("Worker result RETRY for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, String.format("Worker result FAILURE for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setFailedAndResolve();
            }
        }
    }

    private void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.mWorkSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    private void resolve(boolean z10) {
        ListenableWorker listenableWorker;
        this.mWorkDatabase.beginTransaction();
        try {
            if (!this.mWorkDatabase.workSpecDao().hasUnfinishedWork()) {
                PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
            }
            if (z10) {
                this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            }
            if (!(this.mWorkSpec == null || (listenableWorker = this.mWorker) == null || !listenableWorker.isRunInForeground())) {
                this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            this.mFuture.set(Boolean.valueOf(z10));
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(TAG, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger.get().debug(TAG, String.format("Status for %s is %s; not doing any work", new Object[]{this.mWorkSpecId, state}), new Throwable[0]);
        resolve(false);
    }

    private void runWorker() {
        Data merge;
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec = this.mWorkSpecDao.getWorkSpec(this.mWorkSpecId);
                this.mWorkSpec = workSpec;
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Didn't find WorkSpec for id %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    resolve(false);
                    this.mWorkDatabase.setTransactionSuccessful();
                } else if (workSpec.state != WorkInfo.State.ENQUEUED) {
                    resolveIncorrectStatus();
                    this.mWorkDatabase.setTransactionSuccessful();
                    Logger.get().debug(TAG, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.mWorkSpec.workerClassName}), new Throwable[0]);
                    this.mWorkDatabase.endTransaction();
                } else {
                    if (workSpec.isPeriodic() || this.mWorkSpec.isBackedOff()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WorkSpec workSpec2 = this.mWorkSpec;
                        if (workSpec2.periodStartTime != 0) {
                            if (currentTimeMillis < workSpec2.calculateNextRunTime()) {
                                Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.mWorkSpec.workerClassName}), new Throwable[0]);
                                resolve(true);
                                this.mWorkDatabase.setTransactionSuccessful();
                                this.mWorkDatabase.endTransaction();
                                return;
                            }
                        }
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                    this.mWorkDatabase.endTransaction();
                    if (this.mWorkSpec.isPeriodic()) {
                        merge = this.mWorkSpec.input;
                    } else {
                        InputMerger createInputMergerWithDefaultFallback = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
                        if (createInputMergerWithDefaultFallback == null) {
                            Logger.get().error(TAG, String.format("Could not create Input Merger %s", new Object[]{this.mWorkSpec.inputMergerClassName}), new Throwable[0]);
                            setFailedAndResolve();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.mWorkSpec.input);
                        arrayList.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
                        merge = createInputMergerWithDefaultFallback.merge(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.mWorkSpecId), merge, this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
                    if (this.mWorker == null) {
                        this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.mWorker;
                    if (listenableWorker == null) {
                        Logger.get().error(TAG, String.format("Could not create Worker %s", new Object[]{this.mWorkSpec.workerClassName}), new Throwable[0]);
                        setFailedAndResolve();
                    } else if (listenableWorker.isUsed()) {
                        Logger.get().error(TAG, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.mWorkSpec.workerClassName}), new Throwable[0]);
                        setFailedAndResolve();
                    } else {
                        this.mWorker.setUsed();
                        if (!trySetRunning()) {
                            resolveIncorrectStatus();
                        } else if (!tryCheckForInterruptionAndResolve()) {
                            SettableFuture create = SettableFuture.create();
                            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workerParameters.getForegroundUpdater(), this.mWorkTaskExecutor);
                            this.mWorkTaskExecutor.getMainThreadExecutor().execute(workForegroundRunnable);
                            ListenableFuture<Void> future = workForegroundRunnable.getFuture();
                            future.addListener(new a(future, create), this.mWorkTaskExecutor.getMainThreadExecutor());
                            create.addListener(new b(create, this.mWorkDescription), this.mWorkTaskExecutor.getBackgroundExecutor());
                        }
                    }
                }
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Success) this.mResult).getOutputData());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.getState(next) == WorkInfo.State.BLOCKED && this.mDependencyDao.hasCompletedAllPrerequisites(next)) {
                    Logger.get().info(TAG, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, next);
                    this.mWorkSpecDao.setPeriodStartTime(next, currentTimeMillis);
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            resolve(false);
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            resolve(false);
            throw th;
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(TAG, String.format("Work interrupted for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == null) {
            resolve(false);
        } else {
            resolve(!state.isFinished());
        }
        return true;
    }

    private boolean trySetRunning() {
        boolean z10;
        this.mWorkDatabase.beginTransaction();
        try {
            if (this.mWorkSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.ENQUEUED) {
                this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
                z10 = true;
            } else {
                z10 = false;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            return z10;
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    @NonNull
    public ListenableFuture<Boolean> getFuture() {
        return this.mFuture;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void interrupt() {
        boolean z10;
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.mInnerFuture;
        if (listenableFuture != null) {
            z10 = listenableFuture.isDone();
            this.mInnerFuture.cancel(true);
        } else {
            z10 = false;
        }
        ListenableWorker listenableWorker = this.mWorker;
        if (listenableWorker == null || z10) {
            Logger.get().debug(TAG, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.mWorkSpec}), new Throwable[0]);
            return;
        }
        listenableWorker.stop();
    }

    /* access modifiers changed from: package-private */
    public void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if (state == null) {
                    resolve(false);
                } else if (state == WorkInfo.State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!state.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
                this.mWorkDatabase.endTransaction();
            } catch (Throwable th) {
                this.mWorkDatabase.endTransaction();
                throw th;
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            for (Scheduler cancel : list) {
                cancel.cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    @WorkerThread
    public void run() {
        List<String> tagsForWorkSpecId = this.mWorkTagDao.getTagsForWorkSpecId(this.mWorkSpecId);
        this.mTags = tagsForWorkSpecId;
        this.mWorkDescription = createWorkDescription(tagsForWorkSpecId);
        runWorker();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Failure) this.mResult).getOutputData());
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }
}
