package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.o3;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

abstract class OSNotificationRestoreWorkManager {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f10295a = {"notification_id", "android_notification_id", "full_data", "created_time"};

    /* renamed from: b  reason: collision with root package name */
    private static final String f10296b = NotificationRestoreWorker.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10297c;

    public static class NotificationRestoreWorker extends Worker {
        public NotificationRestoreWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        public ListenableWorker.Result doWork() {
            Context applicationContext = getApplicationContext();
            if (o3.f10882b == null) {
                o3.L0(applicationContext);
            }
            if (!OSUtils.a(applicationContext)) {
                return ListenableWorker.Result.failure();
            }
            if (OSNotificationRestoreWorkManager.f10297c) {
                return ListenableWorker.Result.failure();
            }
            OSNotificationRestoreWorkManager.f10297c = true;
            o3.a(o3.v.INFO, "Restoring notifications");
            v3 n10 = v3.n(applicationContext);
            StringBuilder z10 = v3.z();
            OSNotificationRestoreWorkManager.f(applicationContext, z10);
            OSNotificationRestoreWorkManager.d(applicationContext, n10, z10);
            return ListenableWorker.Result.success();
        }
    }

    public static void c(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = 15;
        } else {
            i10 = 0;
        }
        n3.a(context).enqueueUniqueWork(f10296b, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationRestoreWorker.class).setInitialDelay((long) i10, TimeUnit.SECONDS)).build());
    }

    /* access modifiers changed from: private */
    public static void d(Context context, v3 v3Var, StringBuilder sb2) {
        o3.v vVar = o3.v.INFO;
        o3.a(vVar, "Querying DB for notifications to restore: " + sb2.toString());
        Cursor cursor = null;
        try {
            cursor = v3Var.b("notification", f10295a, sb2.toString(), (String[]) null, (String) null, (String) null, "_id DESC", y0.f11110a);
            e(context, cursor, 200);
            l.c(v3Var, context);
            if (cursor == null || cursor.isClosed()) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    static void e(Context context, Cursor cursor, int i10) {
        if (cursor.moveToFirst()) {
            do {
                OSNotificationWorkManager.b(context, cursor.getString(cursor.getColumnIndex("notification_id")), cursor.getInt(cursor.getColumnIndex("android_notification_id")), cursor.getString(cursor.getColumnIndex("full_data")), cursor.getLong(cursor.getColumnIndex("created_time")), true, false);
                if (i10 > 0) {
                    OSUtils.V(i10);
                }
            } while (cursor.moveToNext());
        }
    }

    /* access modifiers changed from: private */
    public static void f(Context context, StringBuilder sb2) {
        StatusBarNotification[] d10 = y3.d(context);
        if (d10.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (StatusBarNotification id2 : d10) {
                arrayList.add(Integer.valueOf(id2.getId()));
            }
            sb2.append(" AND android_notification_id NOT IN (");
            sb2.append(TextUtils.join(",", arrayList));
            sb2.append(")");
        }
    }
}
