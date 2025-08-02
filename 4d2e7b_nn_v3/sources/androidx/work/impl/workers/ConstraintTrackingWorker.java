package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG = Logger.tagWithPrefix("ConstraintTrkngWrkr");
    volatile boolean mAreConstraintsUnmet = false;
    @Nullable
    private ListenableWorker mDelegate;
    SettableFuture<ListenableWorker.Result> mFuture = SettableFuture.create();
    final Object mLock = new Object();
    private WorkerParameters mWorkerParameters;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ConstraintTrackingWorker.this.setupAndRunConstraintTrackingWork();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ListenableFuture f17119a;

        b(ListenableFuture listenableFuture) {
            this.f17119a = listenableFuture;
        }

        public void run() {
            synchronized (ConstraintTrackingWorker.this.mLock) {
                try {
                    if (ConstraintTrackingWorker.this.mAreConstraintsUnmet) {
                        ConstraintTrackingWorker.this.setFutureRetry();
                    } else {
                        ConstraintTrackingWorker.this.mFuture.setFuture(this.f17119a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
    }

    @VisibleForTesting
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableWorker getDelegate() {
        return this.mDelegate;
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkTaskExecutor();
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker == null || !listenableWorker.isRunInForeground()) {
            return false;
        }
        return true;
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.mLock) {
            this.mAreConstraintsUnmet = true;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.mDelegate.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void setFutureFailed() {
        this.mFuture.set(ListenableWorker.Result.failure());
    }

    /* access modifiers changed from: package-private */
    public void setFutureRetry() {
        this.mFuture.set(ListenableWorker.Result.retry());
    }

    /* access modifiers changed from: package-private */
    public void setupAndRunConstraintTrackingWork() {
        String string = getInputData().getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty(string)) {
            Logger.get().error(TAG, "No worker to delegate to.", new Throwable[0]);
            setFutureFailed();
            return;
        }
        ListenableWorker createWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.mWorkerParameters);
        this.mDelegate = createWorkerWithDefaultFallback;
        if (createWorkerWithDefaultFallback == null) {
            Logger.get().debug(TAG, "No worker to delegate to.", new Throwable[0]);
            setFutureFailed();
            return;
        }
        WorkSpec workSpec = getWorkDatabase().workSpecDao().getWorkSpec(getId().toString());
        if (workSpec == null) {
            setFutureFailed();
            return;
        }
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(getApplicationContext(), getTaskExecutor(), this);
        workConstraintsTracker.replace(Collections.singletonList(workSpec));
        if (workConstraintsTracker.areAllConstraintsMet(getId().toString())) {
            Logger.get().debug(TAG, String.format("Constraints met for delegate %s", new Object[]{string}), new Throwable[0]);
            try {
                ListenableFuture<ListenableWorker.Result> startWork = this.mDelegate.startWork();
                startWork.addListener(new b(startWork), getBackgroundExecutor());
            } catch (Throwable th) {
                throw th;
            }
        } else {
            Logger.get().debug(TAG, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{string}), new Throwable[0]);
            setFutureRetry();
        }
    }

    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.mFuture;
    }
}
