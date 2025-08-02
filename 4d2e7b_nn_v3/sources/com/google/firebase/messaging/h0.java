package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.credentials.a;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

abstract class h0 {
    private static boolean b(Context context) {
        if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
            return true;
        }
        return false;
    }

    static void c(Context context) {
        if (!i0.b(context)) {
            f(new a(), context, g(context));
        }
    }

    static boolean d(Context context) {
        if (!PlatformVersion.isAtLeastQ()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "Platform doesn't support proxying.");
            }
            return false;
        } else if (!b(context)) {
            Log.e(Constants.TAG, "error retrieving notification delegate for package " + context.getPackageName());
            return false;
        } else if (!"com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
            return false;
        } else {
            if (!Log.isLoggable(Constants.TAG, 3)) {
                return true;
            }
            Log.d(Constants.TAG, "GMS core is set for proxying");
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Context context, boolean z10, TaskCompletionSource taskCompletionSource) {
        try {
            if (!b(context)) {
                Log.e(Constants.TAG, "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            i0.c(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (z10) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate((String) null);
            }
            taskCompletionSource.trySetResult(null);
        } finally {
            taskCompletionSource.trySetResult(null);
        }
    }

    static Task f(Executor executor, Context context, boolean z10) {
        if (!PlatformVersion.isAtLeastQ()) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new g0(context, z10, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_notification_delegation_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_messaging_notification_delegation_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
