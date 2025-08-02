package com.google.android.gms.cloudmessaging;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

public final /* synthetic */ class zzy implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzy(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        if (this.zza.trySetException(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
