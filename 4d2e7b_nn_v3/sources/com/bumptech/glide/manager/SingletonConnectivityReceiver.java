package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

final class SingletonConnectivityReceiver {
    private static final String TAG = "ConnectivityMonitor";
    private static volatile SingletonConnectivityReceiver instance;
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    @GuardedBy("this")
    private boolean isRegistered;
    @GuardedBy("this")
    final Set<ConnectivityMonitor.ConnectivityListener> listeners = new HashSet();

    private interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    @RequiresApi(24)
    private static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            private void postOnConnectivityChange(final boolean z10) {
                Util.postOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass1.this.onConnectivityChange(z10);
                    }
                });
            }

            public void onAvailable(@NonNull Network network) {
                postOnConnectivityChange(true);
            }

            /* access modifiers changed from: package-private */
            public void onConnectivityChange(boolean z10) {
                Util.assertMainThread();
                FrameworkConnectivityMonitorPostApi24 frameworkConnectivityMonitorPostApi24 = FrameworkConnectivityMonitorPostApi24.this;
                boolean z11 = frameworkConnectivityMonitorPostApi24.isConnected;
                frameworkConnectivityMonitorPostApi24.isConnected = z10;
                if (z11 != z10) {
                    frameworkConnectivityMonitorPostApi24.listener.onConnectivityChanged(z10);
                }
            }

            public void onLost(@NonNull Network network) {
                postOnConnectivityChange(false);
            }
        };

        FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        @SuppressLint({"MissingPermission"})
        public boolean register() {
            boolean z10;
            if (this.connectivityManager.get().getActiveNetwork() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.isConnected = z10;
            try {
                this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to register callback", e10);
                }
                return false;
            }
        }

        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    private static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        static final Executor EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
            public void onReceive(@NonNull Context context, Intent intent) {
                FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
            }
        };
        final Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final ConnectivityMonitor.ConnectivityListener listener;

        FrameworkConnectivityMonitorPreApi24(Context context2, GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.context = context2.getApplicationContext();
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"MissingPermission"})
        public boolean isConnected() {
            try {
                NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e10);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void notifyChangeOnUiThread(final boolean z10) {
            Util.postOnUiThread(new Runnable() {
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(z10);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void onConnectivityChange() {
            EXECUTOR.execute(new Runnable() {
                public void run() {
                    boolean z10 = FrameworkConnectivityMonitorPreApi24.this.isConnected;
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    if (z10 != FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                        if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 3)) {
                            Log.d(SingletonConnectivityReceiver.TAG, "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.isConnected);
                        }
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.notifyChangeOnUiThread(frameworkConnectivityMonitorPreApi242.isConnected);
                    }
                }
            });
        }

        public boolean register() {
            EXECUTOR.execute(new Runnable() {
                public void run() {
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    try {
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.context.registerReceiver(frameworkConnectivityMonitorPreApi242.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                    } catch (SecurityException e10) {
                        if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                            Log.w(SingletonConnectivityReceiver.TAG, "Failed to register", e10);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    }
                }
            });
            return true;
        }

        public void unregister() {
            EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi24.context.unregisterReceiver(frameworkConnectivityMonitorPreApi24.connectivityReceiver);
                    }
                }
            });
        }
    }

    private SingletonConnectivityReceiver(@NonNull final Context context) {
        FrameworkConnectivityMonitor frameworkConnectivityMonitor2;
        GlideSuppliers.GlideSupplier memorize = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier<ConnectivityManager>() {
            public ConnectivityManager get() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        });
        AnonymousClass2 r12 = new ConnectivityMonitor.ConnectivityListener() {
            public void onConnectivityChanged(boolean z10) {
                ArrayList<ConnectivityMonitor.ConnectivityListener> arrayList;
                Util.assertMainThread();
                synchronized (SingletonConnectivityReceiver.this) {
                    arrayList = new ArrayList<>(SingletonConnectivityReceiver.this.listeners);
                }
                for (ConnectivityMonitor.ConnectivityListener onConnectivityChanged : arrayList) {
                    onConnectivityChanged.onConnectivityChanged(z10);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 24) {
            frameworkConnectivityMonitor2 = new FrameworkConnectivityMonitorPostApi24(memorize, r12);
        } else {
            frameworkConnectivityMonitor2 = new FrameworkConnectivityMonitorPreApi24(context, memorize, r12);
        }
        this.frameworkConnectivityMonitor = frameworkConnectivityMonitor2;
    }

    static SingletonConnectivityReceiver get(@NonNull Context context) {
        if (instance == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                try {
                    if (instance == null) {
                        instance = new SingletonConnectivityReceiver(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    @GuardedBy("this")
    private void maybeRegisterReceiver() {
        if (!this.isRegistered && !this.listeners.isEmpty()) {
            this.isRegistered = this.frameworkConnectivityMonitor.register();
        }
    }

    @GuardedBy("this")
    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    @VisibleForTesting
    static void reset() {
        instance = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void register(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
        maybeRegisterReceiver();
    }

    /* access modifiers changed from: package-private */
    public synchronized void unregister(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
        maybeUnregisterReceiver();
    }
}
