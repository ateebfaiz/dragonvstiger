package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    final CommandHandler mCommandHandler;
    @Nullable
    private c mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Handler mMainHandler;
    private final Processor mProcessor;
    private final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    class a implements Runnable {
        a() {
        }

        public void run() {
            SystemAlarmDispatcher systemAlarmDispatcher;
            d dVar;
            synchronized (SystemAlarmDispatcher.this.mIntents) {
                SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                systemAlarmDispatcher2.mCurrentIntent = systemAlarmDispatcher2.mIntents.get(0);
            }
            Intent intent = SystemAlarmDispatcher.this.mCurrentIntent;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = SystemAlarmDispatcher.this.mCurrentIntent.getIntExtra(SystemAlarmDispatcher.KEY_START_ID, 0);
                Logger logger = Logger.get();
                String str = SystemAlarmDispatcher.TAG;
                logger.debug(str, String.format("Processing command %s, %s", new Object[]{SystemAlarmDispatcher.this.mCurrentIntent, Integer.valueOf(intExtra)}), new Throwable[0]);
                PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.mContext, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.acquire();
                    SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher3.mCommandHandler.onHandleIntent(systemAlarmDispatcher3.mCurrentIntent, intExtra, systemAlarmDispatcher3);
                    Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.release();
                    systemAlarmDispatcher = SystemAlarmDispatcher.this;
                    dVar = new d(systemAlarmDispatcher);
                } catch (Throwable th) {
                    Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                    newWakeLock.release();
                    SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher4.postOnMainThread(new d(systemAlarmDispatcher4));
                    throw th;
                }
                systemAlarmDispatcher.postOnMainThread(dVar);
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final SystemAlarmDispatcher f16983a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f16984b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16985c;

        b(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i10) {
            this.f16983a = systemAlarmDispatcher;
            this.f16984b = intent;
            this.f16985c = i10;
        }

        public void run() {
            this.f16983a.add(this.f16984b, this.f16985c);
        }
    }

    interface c {
        void onAllCommandsCompleted();
    }

    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final SystemAlarmDispatcher f16986a;

        d(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f16986a = systemAlarmDispatcher;
        }

        public void run() {
            this.f16986a.dequeueAndCheckForCompletion();
        }
    }

    SystemAlarmDispatcher(@NonNull Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null);
    }

    private void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @MainThread
    private boolean hasIntentWithAction(@NonNull String str) {
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                for (Intent action : this.mIntents) {
                    if (str.equals(action.getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        try {
            newWakeLock.acquire();
            this.mWorkManager.getWorkTaskExecutor().executeOnBackgroundThread(new a());
        } finally {
            newWakeLock.release();
        }
    }

    @MainThread
    public boolean add(@NonNull Intent intent, int i10) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra(KEY_START_ID, i10);
            synchronized (this.mIntents) {
                try {
                    boolean z10 = !this.mIntents.isEmpty();
                    this.mIntents.add(intent);
                    if (!z10) {
                        processCommand();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void dequeueAndCheckForCompletion() {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                if (this.mCurrentIntent != null) {
                    Logger.get().debug(str, String.format("Removing command %s", new Object[]{this.mCurrentIntent}), new Throwable[0]);
                    if (this.mIntents.remove(0).equals(this.mCurrentIntent)) {
                        this.mCurrentIntent = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                SerialExecutor backgroundExecutor = this.mTaskExecutor.getBackgroundExecutor();
                if (!this.mCommandHandler.hasPendingCommands() && this.mIntents.isEmpty() && !backgroundExecutor.hasPendingTasks()) {
                    Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                    c cVar = this.mCompletedListener;
                    if (cVar != null) {
                        cVar.onAllCommandsCompleted();
                    }
                } else if (!this.mIntents.isEmpty()) {
                    processCommand();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Processor getProcessor() {
        return this.mProcessor;
    }

    /* access modifiers changed from: package-private */
    public TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    /* access modifiers changed from: package-private */
    public WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    /* access modifiers changed from: package-private */
    public WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        this.mWorkTimer.onDestroy();
        this.mCompletedListener = null;
    }

    public void onExecuted(@NonNull String str, boolean z10) {
        postOnMainThread(new b(this, CommandHandler.createExecutionCompletedIntent(this.mContext, str, z10), 0));
    }

    /* access modifiers changed from: package-private */
    public void postOnMainThread(@NonNull Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    /* access modifiers changed from: package-private */
    public void setCompletedListener(@NonNull c cVar) {
        if (this.mCompletedListener != null) {
            Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.mCompletedListener = cVar;
        }
    }

    @VisibleForTesting
    SystemAlarmDispatcher(@NonNull Context context, @Nullable Processor processor, @Nullable WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mCommandHandler = new CommandHandler(applicationContext);
        this.mWorkTimer = new WorkTimer();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.getInstance(context) : workManagerImpl;
        this.mWorkManager = workManagerImpl;
        processor = processor == null ? workManagerImpl.getProcessor() : processor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
