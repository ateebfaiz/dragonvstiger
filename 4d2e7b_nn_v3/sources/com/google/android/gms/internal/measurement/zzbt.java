package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzbt {
    @Nullable
    private static final Method zza;
    @Nullable
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            if (r0 < r4) goto L_0x0033
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobInfo> r5 = android.app.job.JobInfo.class
            r6 = 0
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 1
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7 = 2
            r0[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0028 }
            r6 = 3
            r0[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobScheduler> r5 = android.app.job.JobScheduler.class
            java.lang.String r6 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r6, r0)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x0034
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r2, r0)
        L_0x0033:
            r0 = r3
        L_0x0034:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x004e
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0043 }
            goto L_0x004e
        L_0x0043:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r2, r0)
        L_0x004e:
            zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048 A[SYNTHETIC, Splitter:B:18:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            r7 = 0
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            r8.getClass()
            java.lang.reflect.Method r0 = zza
            if (r0 == 0) goto L_0x0076
            java.lang.String r0 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r0)
            if (r5 == 0) goto L_0x0019
            goto L_0x0076
        L_0x0019:
            java.lang.reflect.Method r5 = zzb
            if (r5 == 0) goto L_0x0031
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            if (r5 == 0) goto L_0x0031
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            goto L_0x0042
        L_0x002d:
            r5 = move-exception
            goto L_0x0033
        L_0x002f:
            r5 = move-exception
            goto L_0x0033
        L_0x0031:
            r5 = r7
            goto L_0x0042
        L_0x0033:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
            goto L_0x0031
        L_0x0042:
            java.lang.reflect.Method r0 = zza
            java.lang.String r1 = "UploadAlarm"
            if (r0 == 0) goto L_0x0071
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r2[r7] = r6     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.String r3 = "com.google.android.gms"
            r4 = 1
            r2[r4] = r3     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r3 = 2
            r2[r3] = r5     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r5 = 3
            r2[r5] = r1     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.Object r5 = r0.invoke(r8, r2)     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            if (r5 == 0) goto L_0x0075
            int r7 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            goto L_0x0075
        L_0x0069:
            r5 = move-exception
            goto L_0x006c
        L_0x006b:
            r5 = move-exception
        L_0x006c:
            java.lang.String r7 = "error calling scheduleAsPackage"
            android.util.Log.e(r1, r7, r5)
        L_0x0071:
            int r7 = r8.schedule(r6)
        L_0x0075:
            return r7
        L_0x0076:
            int r5 = r8.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
