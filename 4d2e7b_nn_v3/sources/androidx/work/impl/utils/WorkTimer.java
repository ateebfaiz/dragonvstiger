package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    private final ThreadFactory mBackgroundThreadFactory;
    private final ScheduledExecutorService mExecutorService;
    final Map<String, TimeLimitExceededListener> mListeners = new HashMap();
    final Object mLock = new Object();
    final Map<String, WorkTimerRunnable> mTimerMap = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final String mWorkSpecId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = str;
        }

        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) != null) {
                        TimeLimitExceededListener remove = this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                        if (remove != null) {
                            remove.onTimeLimitExceeded(this.mWorkSpecId);
                        }
                    } else {
                        Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f17093a = 0;

        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f17093a);
            this.f17093a = this.f17093a + 1;
            return newThread;
        }
    }

    public WorkTimer() {
        a aVar = new a();
        this.mBackgroundThreadFactory = aVar;
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    @VisibleForTesting
    @NonNull
    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        return this.mListeners;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        return this.mTimerMap;
    }

    public void onDestroy() {
        if (!this.mExecutorService.isShutdown()) {
            this.mExecutorService.shutdownNow();
        }
    }

    public void startTimer(@NonNull String str, long j10, @NonNull TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.mTimerMap.put(str, workTimerRunnable);
            this.mListeners.put(str, timeLimitExceededListener);
            this.mExecutorService.schedule(workTimerRunnable, j10, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull String str) {
        synchronized (this.mLock) {
            try {
                if (this.mTimerMap.remove(str) != null) {
                    Logger.get().debug(TAG, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                    this.mListeners.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
