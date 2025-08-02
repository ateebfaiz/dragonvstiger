package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StorageNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = Logger.tagWithPrefix("StorageNotLowTracker");

    public StorageNotLowTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public void onBroadcastReceive(Context context, @NonNull Intent intent) {
        if (intent.getAction() != null) {
            Logger.get().debug(TAG, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                setState(Boolean.FALSE);
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                setState(Boolean.TRUE);
            }
        }
    }

    public Boolean getInitialState() {
        Intent registerReceiver = this.mAppContext.registerReceiver((BroadcastReceiver) null, getIntentFilter());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return Boolean.TRUE;
    }
}
