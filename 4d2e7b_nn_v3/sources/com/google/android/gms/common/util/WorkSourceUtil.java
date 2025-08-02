package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    @GuardedBy("WorkSourceUtil.class")
    private static Boolean zzj = null;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    static {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "add"
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            int r5 = android.os.Process.myUid()
            zza = r5
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0019 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0019 }
            r6[r1] = r7     // Catch:{ Exception -> 0x0019 }
            java.lang.reflect.Method r6 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0019 }
            goto L_0x001a
        L_0x0019:
            r6 = r5
        L_0x001a:
            zzb = r6
            boolean r6 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 == 0) goto L_0x0031
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0031 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0031 }
            r6[r1] = r8     // Catch:{ Exception -> 0x0031 }
            r6[r2] = r7     // Catch:{ Exception -> 0x0031 }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r3 = r5
        L_0x0032:
            zzc = r3
            java.lang.String r3 = "size"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch:{ Exception -> 0x003b }
            goto L_0x003c
        L_0x003b:
            r3 = r5
        L_0x003c:
            zzd = r3
            java.lang.String r3 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x004b }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004b }
            r6[r1] = r8     // Catch:{ Exception -> 0x004b }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x004b }
            goto L_0x004c
        L_0x004b:
            r3 = r5
        L_0x004c:
            zze = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = "getName"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0061 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0061 }
            r6[r1] = r8     // Catch:{ Exception -> 0x0061 }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r3 = r5
        L_0x0062:
            zzf = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r6 = "WorkSourceUtil"
            if (r3 == 0) goto L_0x0079
            java.lang.String r3 = "createWorkChain"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch:{ Exception -> 0x0073 }
            goto L_0x007a
        L_0x0073:
            r3 = move-exception
            java.lang.String r8 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r6, r8, r3)
        L_0x0079:
            r3 = r5
        L_0x007a:
            zzg = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r3 == 0) goto L_0x009d
            java.lang.String r3 = "android.os.WorkSource$WorkChain"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r8 = "addNode"
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0097 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0097 }
            r0[r1] = r9     // Catch:{ Exception -> 0x0097 }
            r0[r2] = r7     // Catch:{ Exception -> 0x0097 }
            java.lang.reflect.Method r0 = r3.getMethod(r8, r0)     // Catch:{ Exception -> 0x0097 }
            goto L_0x009e
        L_0x0097:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r6, r1, r0)
        L_0x009d:
            r0 = r5
        L_0x009e:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r4.getMethod(r0, r5)     // Catch:{ Exception -> 0x00b0 }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b1
        L_0x00b0:
            r0 = r5
        L_0x00b1:
            zzi = r0
            zzj = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void add(@NonNull WorkSource workSource, int i10, @NonNull String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i10), str});
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i10)});
                } catch (Exception e11) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
                }
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackage(@NonNull Context context, @NonNull String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i10 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i10, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i10 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i10 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i10 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i10, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, (Object[]) null);
                int i11 = zza;
                if (i10 != i11) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i10), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i11), str2});
            } catch (Exception e10) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e10);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int get(@NonNull WorkSource workSource, int i10) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i10)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String getName(@NonNull WorkSource workSource, int i10) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i10)});
        } catch (Exception e10) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> getNames(@NonNull WorkSource workSource) {
        int i10;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i10 = 0;
        } else {
            i10 = size(workSource);
        }
        if (i10 != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                String name = getName(workSource, i11);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(@NonNull Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z10 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z10 = true;
            }
            zzj = Boolean.valueOf(z10);
            return z10;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(@NonNull WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, (Object[]) null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e10) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e10);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int size(@NonNull WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, (Object[]) null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e10) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            return 0;
        }
    }
}
