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
import java.io.IOException;

class t0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f9298f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f9299g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f9300h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9301a;

    /* renamed from: b  reason: collision with root package name */
    private final d0 f9302b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f9303c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final s0 f9304d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9305e;

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private t0 f9306a;

        public a(t0 t0Var) {
            this.f9306a = t0Var;
        }

        public void a() {
            if (t0.j()) {
                Log.d(Constants.TAG, "Connectivity change received registered");
            }
            t0.this.f9301a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            try {
                t0 t0Var = this.f9306a;
                if (t0Var != null) {
                    if (t0Var.i()) {
                        if (t0.j()) {
                            Log.d(Constants.TAG, "Connectivity changed. Starting background sync.");
                        }
                        this.f9306a.f9304d.m(this.f9306a, 0);
                        context.unregisterReceiver(this);
                        this.f9306a = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    t0(s0 s0Var, Context context, d0 d0Var, long j10) {
        this.f9304d = s0Var;
        this.f9301a = context;
        this.f9305e = j10;
        this.f9302b = d0Var;
        this.f9303c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, Constants.FCM_WAKE_LOCK);
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean z10;
        boolean booleanValue;
        synchronized (f9298f) {
            try {
                Boolean bool = f9300h;
                if (bool == null) {
                    z10 = g(context, "android.permission.ACCESS_NETWORK_STATE", bool);
                } else {
                    z10 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z10);
                f9300h = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        boolean z10;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, e(str));
        }
        return z10;
    }

    private static boolean h(Context context) {
        boolean z10;
        boolean booleanValue;
        synchronized (f9298f) {
            try {
                Boolean bool = f9299g;
                if (bool == null) {
                    z10 = g(context, "android.permission.WAKE_LOCK", bool);
                } else {
                    z10 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z10);
                f9299g = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo networkInfo;
        boolean z10;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f9301a.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                z10 = false;
            } else {
                z10 = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z10;
    }

    /* access modifiers changed from: private */
    public static boolean j() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f9301a)) {
            this.f9303c.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            this.f9304d.o(true);
            if (!this.f9302b.g()) {
                this.f9304d.o(false);
                if (h(this.f9301a)) {
                    try {
                        this.f9303c.release();
                    } catch (RuntimeException unused) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!f(this.f9301a) || i()) {
                if (this.f9304d.s()) {
                    this.f9304d.o(false);
                } else {
                    this.f9304d.t(this.f9305e);
                }
                if (h(this.f9301a)) {
                    try {
                        wakeLock = this.f9303c;
                        wakeLock.release();
                    } catch (RuntimeException unused2) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                new a(this).a();
                if (h(this.f9301a)) {
                    try {
                        this.f9303c.release();
                    } catch (RuntimeException unused3) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e10) {
            Log.e(Constants.TAG, "Failed to sync topics. Won't retry sync. " + e10.getMessage());
            this.f9304d.o(false);
            if (h(this.f9301a)) {
                wakeLock = this.f9303c;
            }
        } catch (Throwable th) {
            if (h(this.f9301a)) {
                try {
                    this.f9303c.release();
                } catch (RuntimeException unused4) {
                    Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
