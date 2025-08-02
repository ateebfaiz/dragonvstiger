package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.x0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    private static final String TAG = "EnhancedIntentService";
    private Binder binder;
    @VisibleForTesting
    final ExecutorService executor = i.d();
    private int lastStartId;
    private final Object lock = new Object();
    private int runningTasks = 0;

    class a implements x0.a {
        a() {
        }

        public Task a(Intent intent) {
            return EnhancedIntentService.this.processIntent(intent);
        }
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            v0.c(intent);
        }
        synchronized (this.lock) {
            try {
                int i10 = this.runningTasks - 1;
                this.runningTasks = i10;
                if (i10 == 0) {
                    stopSelfResultHook(this.lastStartId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartCommand$1(Intent intent, Task task) {
        finishTask(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$processIntent$0(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public Task<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new e(this, intent, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: protected */
    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Service received bind request");
            }
            if (this.binder == null) {
                this.binder = new x0(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.binder;
    }

    @CallSuper
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i10, int i11) {
        synchronized (this.lock) {
            this.lastStartId = i11;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.isComplete()) {
            finishTask(intent);
            return 2;
        }
        processIntent.addOnCompleteListener((Executor) new androidx.credentials.a(), (OnCompleteListener<Void>) new d(this, intent));
        return 3;
    }

    /* access modifiers changed from: package-private */
    public boolean stopSelfResultHook(int i10) {
        return stopSelfResult(i10);
    }
}
