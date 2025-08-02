package u1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

public abstract class i {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            return context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, 2);
        }
        return context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
    }
}
