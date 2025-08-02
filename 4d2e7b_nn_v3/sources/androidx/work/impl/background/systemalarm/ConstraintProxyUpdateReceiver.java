package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f16978a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f16979b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f16980c;

        a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f16978a = intent;
            this.f16979b = context;
            this.f16980c = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f16978a.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_NOT_LOW_PROXY_ENABLED, false);
                boolean booleanExtra2 = this.f16978a.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_CHARGING_PROXY_ENABLED, false);
                boolean booleanExtra3 = this.f16978a.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_STORAGE_NOT_LOW_PROXY_ENABLED, false);
                boolean booleanExtra4 = this.f16978a.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_NETWORK_STATE_PROXY_ENABLED, false);
                Logger.get().debug(ConstraintProxyUpdateReceiver.TAG, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                PackageManagerHelper.setComponentEnabled(this.f16979b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                PackageManagerHelper.setComponentEnabled(this.f16979b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                PackageManagerHelper.setComponentEnabled(this.f16979b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                PackageManagerHelper.setComponentEnabled(this.f16979b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f16980c.finish();
            }
        }
    }

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra(KEY_BATTERY_NOT_LOW_PROXY_ENABLED, z10).putExtra(KEY_BATTERY_CHARGING_PROXY_ENABLED, z11).putExtra(KEY_STORAGE_NOT_LOW_PROXY_ENABLED, z12).putExtra(KEY_NETWORK_STATE_PROXY_ENABLED, z13);
        return intent;
    }

    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!ACTION.equals(str)) {
            Logger.get().debug(TAG, String.format("Ignoring unknown action %s", new Object[]{str}), new Throwable[0]);
            return;
        }
        WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnBackgroundThread(new a(intent, context, goAsync()));
    }
}
