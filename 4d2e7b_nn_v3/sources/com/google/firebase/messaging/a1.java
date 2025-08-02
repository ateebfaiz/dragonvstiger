package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class a1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9211a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f9212b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f9213c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue f9214d;

    /* renamed from: e  reason: collision with root package name */
    private x0 f9215e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9216f;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f9217a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskCompletionSource f9218b = new TaskCompletionSource();

        a(Intent intent) {
            this.f9217a = intent;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w(Constants.TAG, "Service took too long to process intent: " + this.f9217a.getAction() + " Releasing WakeLock.");
            d();
        }

        /* access modifiers changed from: package-private */
        public void c(ScheduledExecutorService scheduledExecutorService) {
            boolean z10;
            long j10;
            if ((this.f9217a.getFlags() & GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            y0 y0Var = new y0(this);
            if (z10) {
                j10 = v0.f9314a;
            } else {
                j10 = 9000;
            }
            e().addOnCompleteListener((Executor) scheduledExecutorService, new z0(scheduledExecutorService.schedule(y0Var, j10, TimeUnit.MILLISECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f9218b.trySetResult(null);
        }

        /* access modifiers changed from: package-private */
        public Task e() {
            return this.f9218b.getTask();
        }
    }

    a1(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private void a() {
        while (!this.f9214d.isEmpty()) {
            ((a) this.f9214d.poll()).d();
        }
    }

    private synchronized void b() {
        try {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "flush queue called");
            }
            while (!this.f9214d.isEmpty()) {
                if (Log.isLoggable(Constants.TAG, 3)) {
                    Log.d(Constants.TAG, "found intent to be delivered");
                }
                x0 x0Var = this.f9215e;
                if (x0Var == null || !x0Var.isBinderAlive()) {
                    d();
                    return;
                }
                if (Log.isLoggable(Constants.TAG, 3)) {
                    Log.d(Constants.TAG, "binder is alive, sending the intent.");
                }
                this.f9215e.c((a) this.f9214d.poll());
            }
        } finally {
        }
    }

    private void d() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.f9216f);
            Log.d(Constants.TAG, sb2.toString());
        }
        if (!this.f9216f) {
            this.f9216f = true;
            try {
                if (!ConnectionTracker.getInstance().bindService(this.f9211a, this.f9212b, this, 65)) {
                    Log.e(Constants.TAG, "binding to the service failed");
                    this.f9216f = false;
                    a();
                }
            } catch (SecurityException e10) {
                Log.e(Constants.TAG, "Exception while binding the service", e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Task c(Intent intent) {
        a aVar;
        try {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "new intent queued in the bind-strategy delivery");
            }
            aVar = new a(intent);
            aVar.c(this.f9213c);
            this.f9214d.add(aVar);
            b();
        } catch (Throwable th) {
            throw th;
        }
        return aVar.e();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "onServiceConnected: " + componentName);
            }
            this.f9216f = false;
            if (!(iBinder instanceof x0)) {
                Log.e(Constants.TAG, "Invalid service connection: " + iBinder);
                a();
                return;
            }
            this.f9215e = (x0) iBinder;
            b();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "onServiceDisconnected: " + componentName);
        }
        b();
    }

    a1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f9214d = new ArrayDeque();
        this.f9216f = false;
        Context applicationContext = context.getApplicationContext();
        this.f9211a = applicationContext;
        this.f9212b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f9213c = scheduledExecutorService;
    }
}
