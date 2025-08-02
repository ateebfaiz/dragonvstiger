package com.onesignal;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.g;
import androidx.core.app.i;
import java.util.ArrayList;
import java.util.HashMap;

abstract class JobIntentService extends Service {

    /* renamed from: h  reason: collision with root package name */
    static final Object f10281h = new Object();

    /* renamed from: i  reason: collision with root package name */
    static final HashMap f10282i = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    CompatJobEngine f10283a;

    /* renamed from: b  reason: collision with root package name */
    WorkEnqueuer f10284b;

    /* renamed from: c  reason: collision with root package name */
    CommandProcessor f10285c;

    /* renamed from: d  reason: collision with root package name */
    boolean f10286d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f10287e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f10288f = false;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList f10289g = new ArrayList();

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a10 = JobIntentService.this.a();
                if (a10 == null) {
                    return null;
                }
                JobIntentService.this.g(a10.getIntent());
                a10.complete();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Void voidR) {
            JobIntentService.this.i();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.i();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.mLaunchingService) {
                            this.mLaunchingService = true;
                            if (!this.mServiceProcessing) {
                                this.mLaunchWakeLock.acquire(60000);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void serviceProcessingFinished() {
            synchronized (this) {
                try {
                    if (this.mServiceProcessing) {
                        if (this.mLaunchingService) {
                            this.mLaunchWakeLock.acquire(60000);
                        }
                        this.mServiceProcessing = false;
                        this.mRunWakeLock.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void serviceProcessingStarted() {
            synchronized (this) {
                try {
                    if (!this.mServiceProcessing) {
                        this.mServiceProcessing = true;
                        this.mRunWakeLock.acquire(600000);
                        this.mLaunchWakeLock.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int i10) {
            this.mIntent = intent;
            this.mStartId = i10;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }

    private static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName2, boolean z10) {
            this.componentName = componentName2;
            this.useWakefulService = z10;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock = new Object();
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    JobParameters jobParameters = JobServiceEngineImpl.this.mParams;
                    if (jobParameters != null) {
                        try {
                            g.a(jobParameters, this.mJobWork);
                        } catch (SecurityException e10) {
                            Log.e(JobServiceEngineImpl.TAG, "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e10);
                        } catch (IllegalArgumentException e11) {
                            Log.e(JobServiceEngineImpl.TAG, "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e11);
                        }
                    }
                }
            }

            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mService = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
            androidx.core.app.f.a(r1).setExtrasClassLoader(r5.mService.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            return new com.onesignal.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(r5, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.onesignal.JobIntentService.GenericWorkItem dequeueWork() {
            /*
                r5 = this;
                java.lang.Object r0 = r5.mLock
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r5.mParams     // Catch:{ all -> 0x000a }
                r2 = 0
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x000a:
                r1 = move-exception
                goto L_0x0031
            L_0x000c:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ SecurityException -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                com.onesignal.JobIntentService r2 = r5.mService
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem r0 = new com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                r1 = move-exception
                java.lang.String r3 = "JobServiceEngineImpl"
                java.lang.String r4 = "Failed to run mParams.dequeueWork()!"
                android.util.Log.e(r3, r4, r1)     // Catch:{ all -> 0x000a }
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x0031:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.JobIntentService.JobServiceEngineImpl.dequeueWork():com.onesignal.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.e(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b10 = this.mService.b();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return b10;
        }
    }

    @RequiresApi(26)
    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i10) {
            super(componentName);
            ensureJobId(i10);
            this.mJobInfo = new JobInfo.Builder(i10, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void enqueueWork(Intent intent) {
            int unused = this.mJobScheduler.enqueue(this.mJobInfo, i.a(intent));
        }
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void enqueueWork(Intent intent);

        /* access modifiers changed from: package-private */
        public void ensureJobId(int i10) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i10;
            } else if (this.mJobId != i10) {
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.mJobId);
            }
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public static void c(Context context, ComponentName componentName, int i10, Intent intent, boolean z10) {
        if (intent != null) {
            synchronized (f10281h) {
                WorkEnqueuer f10 = f(context, componentName, true, i10, z10);
                f10.ensureJobId(i10);
                try {
                    f10.enqueueWork(intent);
                } catch (IllegalStateException e10) {
                    if (z10) {
                        f(context, componentName, true, i10, false).enqueueWork(intent);
                    } else {
                        throw e10;
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void d(Context context, Class cls, int i10, Intent intent, boolean z10) {
        c(context, new ComponentName(context, cls), i10, intent, z10);
    }

    static WorkEnqueuer f(Context context, ComponentName componentName, boolean z10, int i10, boolean z11) {
        WorkEnqueuer compatWorkEnqueuer;
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, z11);
        HashMap hashMap = f10282i;
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) hashMap.get(componentNameWithWakeful);
        if (workEnqueuer == null) {
            if (Build.VERSION.SDK_INT < 26 || z11) {
                compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
            } else if (z10) {
                compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i10);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            workEnqueuer = compatWorkEnqueuer;
            hashMap.put(componentNameWithWakeful, workEnqueuer);
        }
        return workEnqueuer;
    }

    /* access modifiers changed from: package-private */
    public GenericWorkItem a() {
        GenericWorkItem dequeueWork;
        CompatJobEngine compatJobEngine = this.f10283a;
        if (compatJobEngine != null && (dequeueWork = compatJobEngine.dequeueWork()) != null) {
            return dequeueWork;
        }
        synchronized (this.f10289g) {
            try {
                if (this.f10289g.size() <= 0) {
                    return null;
                }
                GenericWorkItem genericWorkItem = (GenericWorkItem) this.f10289g.remove(0);
                return genericWorkItem;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        CommandProcessor commandProcessor = this.f10285c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f10286d);
        }
        this.f10287e = true;
        return h();
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z10) {
        if (this.f10285c == null) {
            this.f10285c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f10284b;
            if (workEnqueuer != null && z10) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.f10285c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ArrayList arrayList = this.f10289g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f10285c = null;
                    ArrayList arrayList2 = this.f10289g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.f10288f) {
                        this.f10284b.serviceProcessingFinished();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f10283a;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10283a = new JobServiceEngineImpl(this);
            this.f10284b = null;
        }
        this.f10284b = f(this, new ComponentName(this, getClass()), false, 0, true);
    }

    public void onDestroy() {
        super.onDestroy();
        b();
        synchronized (this.f10289g) {
            this.f10288f = true;
            this.f10284b.serviceProcessingFinished();
        }
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        this.f10284b.serviceStartReceived();
        synchronized (this.f10289g) {
            ArrayList arrayList = this.f10289g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i11));
            e(true);
        }
        return 3;
    }
}
