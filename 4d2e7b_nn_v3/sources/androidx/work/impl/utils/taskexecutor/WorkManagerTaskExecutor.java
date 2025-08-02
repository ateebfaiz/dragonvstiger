package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutor mBackgroundExecutor;
    private final Executor mMainThreadExecutor = new a();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    class a implements Executor {
        a() {
        }

        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.postToMainThread(runnable);
        }
    }

    public WorkManagerTaskExecutor(@NonNull Executor executor) {
        this.mBackgroundExecutor = new SerialExecutor(executor);
    }

    public void executeOnBackgroundThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }

    @NonNull
    public SerialExecutor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public void postToMainThread(Runnable runnable) {
        this.mMainThreadHandler.post(runnable);
    }
}
