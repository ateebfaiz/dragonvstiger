package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture = SettableFuture.create();
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SettableFuture f17080a;

        a(SettableFuture settableFuture) {
            this.f17080a = settableFuture;
        }

        public void run() {
            this.f17080a.setFuture(WorkForegroundRunnable.this.mWorker.getForegroundInfoAsync());
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SettableFuture f17082a;

        b(SettableFuture settableFuture) {
            this.f17082a = settableFuture;
        }

        public void run() {
            try {
                ForegroundInfo foregroundInfo = (ForegroundInfo) this.f17082a.get();
                if (foregroundInfo != null) {
                    Logger.get().debug(WorkForegroundRunnable.TAG, String.format("Updating notification for %s", new Object[]{WorkForegroundRunnable.this.mWorkSpec.workerClassName}), new Throwable[0]);
                    WorkForegroundRunnable.this.mWorker.setRunInForeground(true);
                    WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                    workForegroundRunnable.mFuture.setFuture(workForegroundRunnable.mForegroundUpdater.setForegroundAsync(workForegroundRunnable.mContext, workForegroundRunnable.mWorker.getId(), foregroundInfo));
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{WorkForegroundRunnable.this.mWorkSpec.workerClassName}));
            } catch (Throwable th) {
                WorkForegroundRunnable.this.mFuture.setException(th);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context context, @NonNull WorkSpec workSpec, @NonNull ListenableWorker listenableWorker, @NonNull ForegroundUpdater foregroundUpdater, @NonNull TaskExecutor taskExecutor) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> getFuture() {
        return this.mFuture;
    }

    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.mWorkSpec.expedited || BuildCompat.isAtLeastS()) {
            this.mFuture.set(null);
            return;
        }
        SettableFuture create = SettableFuture.create();
        this.mTaskExecutor.getMainThreadExecutor().execute(new a(create));
        create.addListener(new b(create), this.mTaskExecutor.getMainThreadExecutor());
    }
}
