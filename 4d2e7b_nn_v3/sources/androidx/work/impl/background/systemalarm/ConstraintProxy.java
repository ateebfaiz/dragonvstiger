package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    static void updateAll(Context context, List<WorkSpec> list) {
        boolean z10;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        for (WorkSpec workSpec : list) {
            Constraints constraints = workSpec.constraints;
            z11 |= constraints.requiresBatteryNotLow();
            z12 |= constraints.requiresCharging();
            z13 |= constraints.requiresStorageNotLow();
            if (constraints.getRequiredNetworkType() != NetworkType.NOT_REQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            z14 |= z10;
            if (z11 && z12 && z13 && z14) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, z11, z12, z13, z14));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(CommandHandler.createConstraintsChangedIntent(context));
    }
}
