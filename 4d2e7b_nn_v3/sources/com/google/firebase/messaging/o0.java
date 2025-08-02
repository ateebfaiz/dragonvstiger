package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f9266a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f9267b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FirebaseMessaging f9268c;

    /* renamed from: d  reason: collision with root package name */
    ExecutorService f9269d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private o0 f9270a;

        public a(o0 o0Var) {
            this.f9270a = o0Var;
        }

        public void a() {
            if (o0.c()) {
                Log.d(Constants.TAG, "Connectivity change received registered");
            }
            this.f9270a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public void onReceive(Context context, Intent intent) {
            o0 o0Var = this.f9270a;
            if (o0Var != null && o0Var.d()) {
                if (o0.c()) {
                    Log.d(Constants.TAG, "Connectivity changed. Starting background sync.");
                }
                this.f9270a.f9268c.enqueueTaskWithDelaySeconds(this.f9270a, 0);
                this.f9270a.b().unregisterReceiver(this);
                this.f9270a = null;
            }
        }
    }

    public o0(FirebaseMessaging firebaseMessaging, long j10) {
        this.f9268c = firebaseMessaging;
        this.f9266a = j10;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f9267b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Context b() {
        return this.f9268c.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        try {
            if (this.f9268c.blockingGetToken() == null) {
                Log.e(Constants.TAG, "Token retrieval failed: null");
                return false;
            } else if (!Log.isLoggable(Constants.TAG, 3)) {
                return true;
            } else {
                Log.d(Constants.TAG, "Token successfully retrieved");
                return true;
            }
        } catch (IOException e10) {
            if (a0.h(e10.getMessage())) {
                Log.w(Constants.TAG, "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval");
                return false;
            } else if (e10.getMessage() == null) {
                Log.w(Constants.TAG, "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e10;
            }
        } catch (SecurityException unused) {
            Log.w(Constants.TAG, "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(b())) {
            this.f9267b.acquire();
        }
        try {
            this.f9268c.setSyncScheduledOrRunning(true);
            if (!this.f9268c.isGmsCorePresent()) {
                this.f9268c.setSyncScheduledOrRunning(false);
                if (ServiceStarter.getInstance().hasWakeLockPermission(b())) {
                    this.f9267b.release();
                }
            } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(b()) || d()) {
                if (e()) {
                    this.f9268c.setSyncScheduledOrRunning(false);
                } else {
                    this.f9268c.syncWithDelaySecondsInternal(this.f9266a);
                }
                if (!ServiceStarter.getInstance().hasWakeLockPermission(b())) {
                    return;
                }
                this.f9267b.release();
            } else {
                new a(this).a();
                if (ServiceStarter.getInstance().hasWakeLockPermission(b())) {
                    this.f9267b.release();
                }
            }
        } catch (IOException e10) {
            Log.e(Constants.TAG, "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
            this.f9268c.setSyncScheduledOrRunning(false);
            if (!ServiceStarter.getInstance().hasWakeLockPermission(b())) {
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(b())) {
                this.f9267b.release();
            }
            throw th;
        }
    }
}
