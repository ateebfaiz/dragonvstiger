package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.a mTask;
    long mUpdateThrottle;

    final class a extends ModernAsyncTask implements Runnable {
        boolean C;

        /* renamed from: w  reason: collision with root package name */
        private final CountDownLatch f15903w = new CountDownLatch(1);

        a() {
        }

        /* access modifiers changed from: protected */
        public void g(Object obj) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, obj);
            } finally {
                this.f15903w.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void h(Object obj) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, obj);
            } finally {
                this.f15903w.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public Object b(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e10) {
                if (f()) {
                    return null;
                }
                throw e10;
            }
        }

        public void n() {
            try {
                this.f15903w.await();
            } catch (InterruptedException unused) {
            }
        }

        public void run() {
            this.C = false;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.f15906h);
    }

    public void cancelLoadInBackground() {
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(AsyncTaskLoader<D>.a aVar, D d10) {
        onCanceled(d10);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.a aVar, D d10) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d10);
        } else if (isAbandoned()) {
            onCanceled(d10);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d10);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.C);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.C);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.C) {
                this.mTask.C = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.c(this.mExecutor, (Object[]) null);
                return;
            }
            this.mTask.C = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public abstract D loadInBackground();

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.C) {
                this.mTask.C = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.C) {
            this.mTask.C = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean a10 = this.mTask.a(false);
            if (a10) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return a10;
        }
    }

    public void onCanceled(@Nullable D d10) {
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new a();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j10) {
        this.mUpdateThrottle = j10;
        if (j10 != 0) {
            this.mHandler = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.a aVar = this.mTask;
        if (aVar != null) {
            aVar.n();
        }
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
