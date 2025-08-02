package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.credentials.a;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@KeepForSdk
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    @GuardedBy("lock")
    private static a1 fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = new a();
    }

    private static Task<Integer> bindToMessagingService(Context context2, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Binding to service");
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context2)) {
            v0.f(context2, getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT").c(intent);
        }
        return Tasks.forResult(-1);
    }

    private static a1 getServiceConnection(Context context2, String str) {
        a1 a1Var;
        synchronized (lock) {
            try {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new a1(context2, str);
                }
                a1Var = fcmServiceConn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a1Var;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) throws Exception {
        return 403;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$startMessagingService$2(Context context2, Intent intent, Task task) throws Exception {
        if (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) {
            return task;
        }
        return bindToMessagingService(context2, intent).continueWith(new a(), new f());
    }

    @VisibleForTesting
    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(Context context2, Intent intent) {
        boolean z10;
        boolean z11 = false;
        if (!PlatformVersion.isAtLeastO() || context2.getApplicationInfo().targetSdkVersion < 26) {
            z10 = false;
        } else {
            z10 = true;
        }
        if ((intent.getFlags() & GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR) != 0) {
            z11 = true;
        }
        if (!z10 || z11) {
            return Tasks.call(this.executor, new g(context2, intent)).continueWithTask(this.executor, new h(context2, intent));
        }
        return bindToMessagingService(context2, intent);
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }
}
