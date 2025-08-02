package androidx.core.app;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    static final Object sLock = new Object();
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    boolean mDestroyed = false;
    boolean mInterruptIfStopped = false;
    b mJobImpl;
    boolean mStopped = false;

    final class a extends AsyncTask {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e dequeueWork = JobIntentService.this.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                JobIntentService.this.onHandleWork(dequeueWork.getIntent());
                dequeueWork.complete();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.processorFinished();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.processorFinished();
        }
    }

    interface b {
        IBinder compatGetBinder();

        e dequeueWork();
    }

    static final class c extends h {

        /* renamed from: d  reason: collision with root package name */
        private final Context f14802d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f14803e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f14804f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14805g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14806h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f14802d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f14803e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f14804f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f14817a);
            if (this.f14802d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f14805g) {
                            this.f14805g = true;
                            if (!this.f14806h) {
                                this.f14803e.acquire(60000);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void c() {
            synchronized (this) {
                try {
                    if (this.f14806h) {
                        if (this.f14805g) {
                            this.f14803e.acquire(60000);
                        }
                        this.f14806h = false;
                        this.f14804f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d() {
            synchronized (this) {
                try {
                    if (!this.f14806h) {
                        this.f14806h = true;
                        this.f14804f.acquire(600000);
                        this.f14803e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void e() {
            synchronized (this) {
                this.f14805g = false;
            }
        }
    }

    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f14807a;

        /* renamed from: b  reason: collision with root package name */
        final int f14808b;

        d(Intent intent, int i10) {
            this.f14807a = intent;
            this.f14808b = i10;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.f14808b);
        }

        public Intent getIntent() {
            return this.f14807a;
        }
    }

    interface e {
        void complete();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f14810a;

        /* renamed from: b  reason: collision with root package name */
        final Object f14811b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f14812c;

        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f14813a;

            a(JobWorkItem jobWorkItem) {
                this.f14813a = jobWorkItem;
            }

            public void complete() {
                synchronized (f.this.f14811b) {
                    try {
                        JobParameters jobParameters = f.this.f14812c;
                        if (jobParameters != null) {
                            g.a(jobParameters, this.f14813a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public Intent getIntent() {
                return this.f14813a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f14810a = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f14810a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            return new androidx.core.app.JobIntentService.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.e dequeueWork() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f14811b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f14812c     // Catch:{ all -> 0x000a }
                r2 = 0
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x000a:
                r1 = move-exception
                goto L_0x0027
            L_0x000c:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x000a }
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f14810a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.f.dequeueWork():androidx.core.app.JobIntentService$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f14812c = jobParameters;
            this.f14810a.ensureProcessorRunningLocked(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.f14810a.doStopCurrentWork();
            synchronized (this.f14811b) {
                this.f14812c = null;
            }
            return doStopCurrentWork;
        }
    }

    static final class g extends h {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f14815d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f14816e;

        g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f14815d = new JobInfo.Builder(i10, this.f14817a).setOverrideDeadline(0).build();
            this.f14816e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            int unused = this.f14816e.enqueue(this.f14815d, i.a(intent));
        }
    }

    static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f14817a;

        /* renamed from: b  reason: collision with root package name */
        boolean f14818b;

        /* renamed from: c  reason: collision with root package name */
        int f14819c;

        h(ComponentName componentName) {
            this.f14817a = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            if (!this.f14818b) {
                this.f14818b = true;
                this.f14819c = i10;
            } else if (this.f14819c != i10) {
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f14819c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i10, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i10, intent);
    }

    static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z10, int i10) {
        h cVar;
        HashMap<ComponentName, h> hashMap = sClassWorkEnqueuer;
        h hVar = hashMap.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else if (z10) {
                cVar = new g(context, componentName, i10);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            hVar = cVar;
            hashMap.put(componentName, hVar);
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public e dequeueWork() {
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.dequeueWork();
        }
        synchronized (this.mCompatQueue) {
            try {
                if (this.mCompatQueue.size() <= 0) {
                    return null;
                }
                e remove = this.mCompatQueue.remove(0);
                return remove;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean doStopCurrentWork() {
        a aVar = this.mCurProcessor;
        if (aVar != null) {
            aVar.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    /* access modifiers changed from: package-private */
    public void ensureProcessorRunningLocked(boolean z10) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new a();
            h hVar = this.mCompatWorkEnqueuer;
            if (hVar != null && z10) {
                hVar.d();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.compatGetBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new f(this);
            this.mCompatWorkEnqueuer = null;
            return;
        }
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onHandleWork(@NonNull Intent intent);

    public int onStartCommand(@Nullable Intent intent, int i10, int i11) {
        if (this.mCompatQueue == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.e();
        synchronized (this.mCompatQueue) {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i11));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void processorFinished() {
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.mCurProcessor = null;
                    ArrayList<d> arrayList2 = this.mCompatQueue;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        ensureProcessorRunningLocked(false);
                    } else if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void setInterruptIfStopped(boolean z10) {
        this.mInterruptIfStopped = z10;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i10, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (sLock) {
                h workEnqueuer = getWorkEnqueuer(context, componentName, true, i10);
                workEnqueuer.b(i10);
                workEnqueuer.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
