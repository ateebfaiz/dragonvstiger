package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.onesignal.o3;

abstract class e1 {

    /* renamed from: c  reason: collision with root package name */
    protected static final Object f10610c = new Object();

    /* renamed from: a  reason: collision with root package name */
    protected boolean f10611a = false;

    /* renamed from: b  reason: collision with root package name */
    private Thread f10612b;

    e1() {
    }

    private boolean g(Context context) {
        if (h.a(context, "android.permission.RECEIVE_BOOT_COMPLETED") == 0) {
            return true;
        }
        return false;
    }

    private boolean h(Context context) {
        Thread thread;
        for (JobInfo id2 : ((JobScheduler) context.getSystemService("jobscheduler")).getAllPendingJobs()) {
            if (id2.getId() == e() && (thread = this.f10612b) != null && thread.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void j(Context context, long j10) {
        o3.v vVar = o3.v.VERBOSE;
        o3.a(vVar, getClass().getSimpleName() + " scheduleServiceSyncTask:atTime: " + j10);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, o3.w0().b() + j10, m(context));
    }

    private void k(Context context, long j10) {
        o3.v vVar = o3.v.VERBOSE;
        o3.a(vVar, "OSBackgroundSync scheduleSyncServiceAsJob:atTime: " + j10);
        if (h(context)) {
            o3.a(vVar, "OSBackgroundSync scheduleSyncServiceAsJob Scheduler already running!");
            this.f10611a = true;
            return;
        }
        JobInfo.Builder builder = new JobInfo.Builder(e(), new ComponentName(context, c()));
        builder.setMinimumLatency(j10).setRequiredNetworkType(1);
        if (g(context)) {
            builder.setPersisted(true);
        }
        try {
            int schedule = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
            o3.v vVar2 = o3.v.INFO;
            o3.a(vVar2, "OSBackgroundSync scheduleSyncServiceAsJob:result: " + schedule);
        } catch (NullPointerException e10) {
            o3.b(o3.v.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e10);
        }
    }

    private PendingIntent m(Context context) {
        return PendingIntent.getService(context, e(), new Intent(context, d()), 201326592);
    }

    private static boolean n() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, getClass().getSimpleName() + " cancel background sync");
        synchronized (f10610c) {
            try {
                if (n()) {
                    ((JobScheduler) context.getSystemService("jobscheduler")).cancel(e());
                } else {
                    ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(m(context));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context, Runnable runnable) {
        o3.d1(o3.v.DEBUG, "OSBackground sync, calling initWithContext");
        o3.L0(context);
        Thread thread = new Thread(runnable, f());
        this.f10612b = thread;
        OSUtils.W(thread);
    }

    /* access modifiers changed from: protected */
    public abstract Class c();

    /* access modifiers changed from: protected */
    public abstract Class d();

    /* access modifiers changed from: protected */
    public abstract int e();

    /* access modifiers changed from: protected */
    public abstract String f();

    /* access modifiers changed from: protected */
    public void i(Context context, long j10) {
        synchronized (f10610c) {
            try {
                if (n()) {
                    k(context, j10);
                } else {
                    j(context, j10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        Thread thread = this.f10612b;
        if (thread == null || !thread.isAlive()) {
            return false;
        }
        this.f10612b.interrupt();
        return true;
    }
}
