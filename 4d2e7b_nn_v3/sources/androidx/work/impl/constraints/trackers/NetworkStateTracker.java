package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    static final String TAG = Logger.tagWithPrefix("NetworkStateTracker");
    private a mBroadcastReceiver;
    private final ConnectivityManager mConnectivityManager = ((ConnectivityManager) this.mAppContext.getSystemService("connectivity"));
    @RequiresApi(24)
    private b mNetworkCallback;

    private class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
            }
        }
    }

    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }

        public void onLost(Network network) {
            Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (isNetworkCallbackSupported()) {
            this.mNetworkCallback = new b();
        } else {
            this.mBroadcastReceiver = new a();
        }
    }

    private static boolean isNetworkCallbackSupported() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public NetworkState getActiveNetworkState() {
        boolean z10;
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        boolean z11 = false;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean isActiveNetworkValidated = isActiveNetworkValidated();
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z11 = true;
        }
        return new NetworkState(z10, isActiveNetworkValidated, isActiveNetworkMetered, z11);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isActiveNetworkValidated() {
        try {
            NetworkCapabilities networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(this.mConnectivityManager.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException e10) {
            Logger.get().error(TAG, "Unable to validate active network", e10);
            return false;
        }
    }

    public void startTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Registering network callback", new Throwable[0]);
                this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e10) {
                Logger.get().error(TAG, "Received exception while registering network callback", e10);
            }
        } else {
            Logger.get().debug(TAG, "Registering broadcast receiver", new Throwable[0]);
            this.mAppContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void stopTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Unregistering network callback", new Throwable[0]);
                this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException | SecurityException e10) {
                Logger.get().error(TAG, "Received exception while unregistering network callback", e10);
            }
        } else {
            Logger.get().debug(TAG, "Unregistering broadcast receiver", new Throwable[0]);
            this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
        }
    }

    public NetworkState getInitialState() {
        return getActiveNetworkState();
    }
}
