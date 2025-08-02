package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    @Nullable
    private b mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    String mCurrentForegroundWorkSpecId;
    final Map<String, ForegroundInfo> mForegroundInfoById;
    final Object mLock = new Object();
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<String, WorkSpec> mWorkSpecById;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkDatabase f17001a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17002b;

        a(WorkDatabase workDatabase, String str) {
            this.f17001a = workDatabase;
            this.f17002b = str;
        }

        public void run() {
            WorkSpec workSpec = this.f17001a.workSpecDao().getWorkSpec(this.f17002b);
            if (workSpec != null && workSpec.hasConstraints()) {
                synchronized (SystemForegroundDispatcher.this.mLock) {
                    SystemForegroundDispatcher.this.mWorkSpecById.put(this.f17002b, workSpec);
                    SystemForegroundDispatcher.this.mTrackedWorkSpecs.add(workSpec);
                    SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                    systemForegroundDispatcher.mConstraintsTracker.replace(systemForegroundDispatcher.mTrackedWorkSpecs);
                }
            }
        }
    }

    interface b {
        void cancelNotification(int i10);

        void notify(int i10, Notification notification);

        void startForeground(int i10, int i11, Notification notification);

        void stop();
    }

    SystemForegroundDispatcher(@NonNull Context context) {
        this.mContext = context;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        this.mWorkManagerImpl = instance;
        TaskExecutor workTaskExecutor = instance.getWorkTaskExecutor();
        this.mTaskExecutor = workTaskExecutor;
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mContext, workTaskExecutor, this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    @NonNull
    public static Intent createCancelWorkIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_CANCEL_WORK);
        intent.setData(Uri.parse(String.format("workspec://%s", new Object[]{str})));
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createNotifyIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_NOTIFY);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createStartForegroundIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_START_FOREGROUND);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createStopForegroundIntent(@NonNull Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_STOP_FOREGROUND);
        return intent;
    }

    @MainThread
    private void handleCancelWork(@NonNull Intent intent) {
        Logger.get().info(TAG, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString(stringExtra));
        }
    }

    @MainThread
    private void handleNotify(@NonNull Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int intExtra2 = intent.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        Notification notification = (Notification) intent.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.mCallback != null) {
            this.mForegroundInfoById.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId)) {
                this.mCurrentForegroundWorkSpecId = stringExtra;
                this.mCallback.startForeground(intExtra, intExtra2, notification);
                return;
            }
            this.mCallback.notify(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> value : this.mForegroundInfoById.entrySet()) {
                    i10 |= ((ForegroundInfo) value.getValue()).getForegroundServiceType();
                }
                ForegroundInfo foregroundInfo = this.mForegroundInfoById.get(this.mCurrentForegroundWorkSpecId);
                if (foregroundInfo != null) {
                    this.mCallback.startForeground(foregroundInfo.getNotificationId(), i10, foregroundInfo.getNotification());
                }
            }
        }
    }

    @MainThread
    private void handleStartForeground(@NonNull Intent intent) {
        Logger.get().info(TAG, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        this.mTaskExecutor.executeOnBackgroundThread(new a(this.mWorkManagerImpl.getWorkDatabase(), stringExtra));
    }

    /* access modifiers changed from: package-private */
    public WorkManagerImpl getWorkManager() {
        return this.mWorkManagerImpl;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void handleStop(@NonNull Intent intent) {
        Logger.get().info(TAG, "Stopping foreground service", new Throwable[0]);
        b bVar = this.mCallback;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.mWorkManagerImpl.stopForegroundWork(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
    }

    @MainThread
    public void onExecuted(@NonNull String str, boolean z10) {
        boolean z11;
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                WorkSpec remove = this.mWorkSpecById.remove(str);
                if (remove != null) {
                    z11 = this.mTrackedWorkSpecs.remove(remove);
                } else {
                    z11 = false;
                }
                if (z11) {
                    this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ForegroundInfo remove2 = this.mForegroundInfoById.remove(str);
        if (str.equals(this.mCurrentForegroundWorkSpecId) && this.mForegroundInfoById.size() > 0) {
            Iterator it = this.mForegroundInfoById.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.mCurrentForegroundWorkSpecId = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                this.mCallback.cancelNotification(foregroundInfo.getNotificationId());
            }
        }
        b bVar = this.mCallback;
        if (remove2 != null && bVar != null) {
            Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.getNotificationId()), str, Integer.valueOf(remove2.getForegroundServiceType())}), new Throwable[0]);
            bVar.cancelNotification(remove2.getNotificationId());
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartCommand(@NonNull Intent intent) {
        String action = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(action)) {
            handleStartForeground(intent);
            handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(action)) {
            handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(action)) {
            handleCancelWork(intent);
        } else if (ACTION_STOP_FOREGROUND.equals(action)) {
            handleStop(intent);
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void setCallback(@NonNull b bVar) {
        if (this.mCallback != null) {
            Logger.get().error(TAG, "A callback already exists.", new Throwable[0]);
        } else {
            this.mCallback = bVar;
        }
    }

    @VisibleForTesting
    SystemForegroundDispatcher(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = workConstraintsTracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }
}
