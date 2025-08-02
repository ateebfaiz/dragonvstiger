package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = Logger.tagWithPrefix("BatteryChrgTracker");

    public BatteryChargingTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    private boolean isBatteryChangedIntentCharging(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r7.equals("android.os.action.DISCHARGING") == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBroadcastReceive(android.content.Context r6, @androidx.annotation.NonNull android.content.Intent r7) {
        /*
            r5 = this;
            r6 = 1
            r0 = 0
            java.lang.String r7 = r7.getAction()
            if (r7 != 0) goto L_0x0009
            return
        L_0x0009:
            androidx.work.Logger r1 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.String r3 = "Received %s"
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r0] = r7
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r0]
            r1.debug(r2, r3, r4)
            r1 = -1
            int r2 = r7.hashCode()
            switch(r2) {
                case -1886648615: goto L_0x0047;
                case -54942926: goto L_0x003e;
                case 948344062: goto L_0x0033;
                case 1019184907: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            r6 = r1
            goto L_0x0051
        L_0x0028:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0031
            goto L_0x0026
        L_0x0031:
            r6 = 3
            goto L_0x0051
        L_0x0033:
            java.lang.String r6 = "android.os.action.CHARGING"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x003c
            goto L_0x0026
        L_0x003c:
            r6 = 2
            goto L_0x0051
        L_0x003e:
            java.lang.String r0 = "android.os.action.DISCHARGING"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0051
            goto L_0x0026
        L_0x0047:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0050
            goto L_0x0026
        L_0x0050:
            r6 = r0
        L_0x0051:
            switch(r6) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0061;
                case 2: goto L_0x005b;
                case 3: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x006c
        L_0x0055:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
            goto L_0x006c
        L_0x005b:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
            goto L_0x006c
        L_0x0061:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
            goto L_0x006c
        L_0x0067:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryChargingTracker.onBroadcastReceive(android.content.Context, android.content.Intent):void");
    }

    public Boolean getInitialState() {
        Intent registerReceiver = this.mAppContext.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(isBatteryChangedIntentCharging(registerReceiver));
        }
        Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
