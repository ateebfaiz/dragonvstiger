package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    @Nullable
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private ExecutionListener f16961a;

        /* renamed from: b  reason: collision with root package name */
        private String f16962b;

        /* renamed from: c  reason: collision with root package name */
        private ListenableFuture f16963c;

        a(ExecutionListener executionListener, String str, ListenableFuture listenableFuture) {
            this.f16961a = executionListener;
            this.f16962b = str;
            this.f16963c = listenableFuture;
        }

        public void run() {
            boolean z10;
            try {
                z10 = ((Boolean) this.f16963c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z10 = true;
            }
            this.f16961a.onExecuted(this.f16962b, z10);
        }
    }

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
    }

    private static boolean interrupt(@NonNull String str, @Nullable WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.interrupt();
            Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (!(!this.mForegroundWorkMap.isEmpty())) {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public boolean hasWork() {
        boolean z10;
        synchronized (this.mLock) {
            try {
                if (this.mEnqueuedWorkMap.isEmpty()) {
                    if (this.mForegroundWorkMap.isEmpty()) {
                        z10 = false;
                    }
                }
                z10 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z10;
        synchronized (this.mLock) {
            try {
                if (!this.mEnqueuedWorkMap.containsKey(str)) {
                    if (!this.mForegroundWorkMap.containsKey(str)) {
                        z10 = false;
                    }
                }
                z10 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean isEnqueuedInForeground(@NonNull String str) {
        boolean containsKey;
        synchronized (this.mLock) {
            containsKey = this.mForegroundWorkMap.containsKey(str);
        }
        return containsKey;
    }

    public void onExecuted(@NonNull String str, boolean z10) {
        synchronized (this.mLock) {
            try {
                this.mEnqueuedWorkMap.remove(str);
                Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z10)}), new Throwable[0]);
                for (ExecutionListener onExecuted : this.mOuterListeners) {
                    onExecuted.onExecuted(str, z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
                WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
                if (remove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, remove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, str, foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(@NonNull String str) {
        return startWork(str, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean stopAndCancelWork(@NonNull String str) {
        boolean interrupt;
        boolean z10 = false;
        synchronized (this.mLock) {
            try {
                Logger.get().debug(TAG, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
                this.mCancelledIds.add(str);
                WorkerWrapper remove = this.mForegroundWorkMap.remove(str);
                if (remove != null) {
                    z10 = true;
                }
                if (remove == null) {
                    remove = this.mEnqueuedWorkMap.remove(str);
                }
                interrupt = interrupt(str, remove);
                if (z10) {
                    stopForegroundService();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interrupt;
    }

    public void stopForeground(@NonNull String str) {
        synchronized (this.mLock) {
            this.mForegroundWorkMap.remove(str);
            stopForegroundService();
        }
    }

    public boolean stopForegroundWork(@NonNull String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mForegroundWorkMap.remove(str));
        }
        return interrupt;
    }

    public boolean stopWork(@NonNull String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mEnqueuedWorkMap.remove(str));
        }
        return interrupt;
    }

    public boolean startWork(@NonNull String str, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.mLock) {
            try {
                if (isEnqueued(str)) {
                    Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                    return false;
                }
                WorkerWrapper build = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, str).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
                ListenableFuture<Boolean> future = build.getFuture();
                future.addListener(new a(this, str, future), this.mWorkTaskExecutor.getMainThreadExecutor());
                this.mEnqueuedWorkMap.put(str, build);
                this.mWorkTaskExecutor.getBackgroundExecutor().execute(build);
                Logger.get().debug(TAG, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
