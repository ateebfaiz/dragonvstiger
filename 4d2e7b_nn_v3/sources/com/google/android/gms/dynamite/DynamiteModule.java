package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pdns.x.c;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
public final class DynamiteModule {
    @KeepForSdk
    public static final int LOCAL = -1;
    @KeepForSdk
    public static final int NONE = 0;
    @KeepForSdk
    public static final int NO_SELECTION = 0;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new j();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new k();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new l();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new h();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new g();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new i();
    @KeepForSdk
    public static final int REMOTE = 1;
    @NonNull
    public static final VersionPolicy zza = new m();
    @Nullable
    private static Boolean zzb = null;
    @Nullable
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    @Nullable
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new e();
    private static final VersionPolicy.IVersions zzi = new f();
    @Nullable
    private static zzq zzk;
    @Nullable
    private static zzr zzl;
    private final Context zzj;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @Nullable
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    public interface VersionPolicy {

        @KeepForSdk
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z10) throws LoadingException;
        }

        @KeepForSdk
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x017f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0181, code lost:
        r19 = r4;
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r13);
        r2 = zzg(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a5, code lost:
        if (r2 == null) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a7, code lost:
        r4 = r2.zze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ac, code lost:
        if (r4 < 3) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ae, code lost:
        r4 = (com.google.android.gms.dynamite.n) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01b4, code lost:
        if (r4 == null) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01b6, code lost:
        r2 = r2.zzi(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r4.f6853a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01cd, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No cached result cursor holder", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ce, code lost:
        if (r4 != 2) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d0, code lost:
        android.util.Log.w("DynamiteModule", "IDynamite loader version = 2");
        r2 = r2.zzj(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01e0, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
        r2 = r2.zzh(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01ef, code lost:
        r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f3, code lost:
        if (r2 == null) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f5, code lost:
        r4 = new com.google.android.gms.dynamite.DynamiteModule((android.content.Context) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0200, code lost:
        if (r10 != 0) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0202, code lost:
        r8.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0206, code lost:
        r8.set(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0209, code lost:
        r1 = r7.f6853a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x020b, code lost:
        if (r1 == null) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x020d, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0210, code lost:
        r0.set(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0213, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x021c, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0225, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0226, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0230, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        if (r17 == null) goto L_0x0226;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (r17.booleanValue() == false) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r13);
        r2 = com.google.android.gms.dynamite.DynamiteModule.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r5 = zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00df, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        if (r5 == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2 = (com.google.android.gms.dynamite.n) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e8, code lost:
        if (r2 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ec, code lost:
        if (r2.f6853a == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r15 = r20.getApplicationContext();
        r2 = r2.f6853a;
        com.google.android.gms.dynamic.ObjectWrapper.wrap(null);
        r18 = com.google.android.gms.dynamite.DynamiteModule.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fb, code lost:
        monitor-enter(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fc, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0100, code lost:
        if (zze < 2) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0104, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0105, code lost:
        monitor-exit(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0106, code lost:
        if (r12 == false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        android.util.Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
        r2 = r5.zzf(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0122, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0125, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
        r2 = r5.zze(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0138, code lost:
        r2 = (android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013e, code lost:
        if (r2 == null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0140, code lost:
        r4 = new com.google.android.gms.dynamite.DynamiteModule(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0151, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to get module context", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0164, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x016e, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No result cursor", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x016f, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0179, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x017a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x017b, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x027c A[Catch:{ all -> 0x0079 }] */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(@androidx.annotation.NonNull android.content.Context r20, @androidx.annotation.NonNull com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r21, @androidx.annotation.NonNull java.lang.String r22) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r20
            r2 = r21
            r3 = r22
            android.content.Context r4 = r20.getApplicationContext()
            r5 = 0
            if (r4 == 0) goto L_0x031f
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r6 = r0.get()
            com.google.android.gms.dynamite.n r6 = (com.google.android.gms.dynamite.n) r6
            com.google.android.gms.dynamite.n r7 = new com.google.android.gms.dynamite.n
            r7.<init>(r5)
            r0.set(r7)
            java.lang.ThreadLocal r8 = zzh
            java.lang.Object r9 = r8.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r10 = r9.longValue()
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0079 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0079 }
            r8.set(r14)     // Catch:{ all -> 0x0079 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r14 = zzi     // Catch:{ all -> 0x0079 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r14 = r2.selectModule(r1, r3, r14)     // Catch:{ all -> 0x0079 }
            java.lang.String r15 = "DynamiteModule"
            int r5 = r14.localVersion     // Catch:{ all -> 0x0079 }
            int r12 = r14.remoteVersion     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r13.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "Considering local module "
            r13.append(r2)     // Catch:{ all -> 0x0079 }
            r13.append(r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = ":"
            r13.append(r2)     // Catch:{ all -> 0x0079 }
            r13.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = " and remote module "
            r13.append(r2)     // Catch:{ all -> 0x0079 }
            r13.append(r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = ":"
            r13.append(r2)     // Catch:{ all -> 0x0079 }
            r13.append(r12)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x0079 }
            android.util.Log.i(r15, r2)     // Catch:{ all -> 0x0079 }
            int r2 = r14.selection     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x02d2
            r5 = -1
            if (r2 != r5) goto L_0x007e
            int r2 = r14.localVersion     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x02d2
            r2 = r5
            goto L_0x007e
        L_0x0079:
            r0 = move-exception
            r1 = 0
            goto L_0x0303
        L_0x007e:
            r12 = 1
            if (r2 != r12) goto L_0x0085
            int r13 = r14.remoteVersion     // Catch:{ all -> 0x0079 }
            if (r13 == 0) goto L_0x02d2
        L_0x0085:
            if (r2 != r5) goto L_0x00a3
            com.google.android.gms.dynamite.DynamiteModule r1 = zzc(r4, r3)     // Catch:{ all -> 0x0079 }
            r2 = 0
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0095
            r8.remove()
            goto L_0x0098
        L_0x0095:
            r8.set(r9)
        L_0x0098:
            android.database.Cursor r2 = r7.f6853a
            if (r2 == 0) goto L_0x009f
            r2.close()
        L_0x009f:
            r0.set(r6)
            return r1
        L_0x00a3:
            if (r2 != r12) goto L_0x02ba
            int r13 = r14.remoteVersion     // Catch:{ LoadingException -> 0x025b }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r15 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r15)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            boolean r17 = zzf(r20)     // Catch:{ all -> 0x0231 }
            if (r17 == 0) goto L_0x0235
            java.lang.Boolean r17 = zzb     // Catch:{ all -> 0x0231 }
            monitor-exit(r15)     // Catch:{ all -> 0x0231 }
            if (r17 == 0) goto L_0x0226
            boolean r15 = r17.booleanValue()     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r12 = 2
            if (r15 == 0) goto L_0x0181
            java.lang.String r15 = "DynamiteModule"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r5.<init>()     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            java.lang.String r2 = "Selected remote version of "
            r5.append(r2)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r5.append(r3)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            java.lang.String r2 = ", version >= "
            r5.append(r2)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r5.append(r13)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            java.lang.String r2 = r5.toString()     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            android.util.Log.i(r15, r2)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r2 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r2)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            com.google.android.gms.dynamite.zzr r5 = zzl     // Catch:{ all -> 0x017a }
            monitor-exit(r2)     // Catch:{ all -> 0x017a }
            if (r5 == 0) goto L_0x016f
            java.lang.Object r2 = r0.get()     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            com.google.android.gms.dynamite.n r2 = (com.google.android.gms.dynamite.n) r2     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            if (r2 == 0) goto L_0x0164
            android.database.Cursor r15 = r2.f6853a     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            if (r15 == 0) goto L_0x0164
            android.content.Context r15 = r20.getApplicationContext()     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            android.database.Cursor r2 = r2.f6853a     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r16 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r18 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r18)     // Catch:{ RemoteException -> 0x015f, LoadingException -> 0x015a, all -> 0x0155 }
            r19 = r4
            int r4 = zze     // Catch:{ all -> 0x0152 }
            if (r4 < r12) goto L_0x0104
            r12 = 1
            goto L_0x0105
        L_0x0104:
            r12 = 0
        L_0x0105:
            monitor-exit(r18)     // Catch:{ all -> 0x0152 }
            if (r12 == 0) goto L_0x0125
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r12 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r4, r12)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r5.zzf(r4, r3, r13, r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            goto L_0x0138
        L_0x011c:
            r0 = move-exception
            goto L_0x0243
        L_0x011f:
            r0 = move-exception
            goto L_0x0251
        L_0x0122:
            r0 = move-exception
            goto L_0x0252
        L_0x0125:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r12 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r4, r12)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r5.zze(r4, r3, r13, r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0138:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            if (r2 == 0) goto L_0x0149
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0145:
            r1 = 0
            goto L_0x01fe
        L_0x0149:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "Failed to get module context"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0152:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x0152 }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0155:
            r0 = move-exception
            r19 = r4
            goto L_0x0243
        L_0x015a:
            r0 = move-exception
            r19 = r4
            goto L_0x0251
        L_0x015f:
            r0 = move-exception
            r19 = r4
            goto L_0x0252
        L_0x0164:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "No result cursor"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x016f:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "DynamiteLoaderV2 was not cached."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x017a:
            r0 = move-exception
            r19 = r4
        L_0x017d:
            monitor-exit(r2)     // Catch:{ all -> 0x017f }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x017f:
            r0 = move-exception
            goto L_0x017d
        L_0x0181:
            r19 = r4
            java.lang.String r2 = "DynamiteModule"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r4.<init>()     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r5 = "Selected remote version of "
            r4.append(r5)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r4.append(r3)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r5 = ", version >= "
            r4.append(r5)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r4.append(r13)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r4 = r4.toString()     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            android.util.Log.i(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamite.zzq r2 = zzg(r20)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            if (r2 == 0) goto L_0x021d
            int r4 = r2.zze()     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r5 = 3
            if (r4 < r5) goto L_0x01ce
            java.lang.Object r4 = r0.get()     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamite.n r4 = (com.google.android.gms.dynamite.n) r4     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            if (r4 == 0) goto L_0x01c5
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            android.database.Cursor r4 = r4.f6853a     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzi(r5, r3, r13, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            goto L_0x01ef
        L_0x01c5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "No cached result cursor holder"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x01ce:
            if (r4 != r12) goto L_0x01e0
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "IDynamite loader version = 2"
            android.util.Log.w(r4, r5)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzj(r4, r3, r13)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            goto L_0x01ef
        L_0x01e0:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r4, r5)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzh(r4, r3, r13)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x01ef:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            if (r2 == 0) goto L_0x0214
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            goto L_0x0145
        L_0x01fe:
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0206
            r8.remove()
            goto L_0x0209
        L_0x0206:
            r8.set(r9)
        L_0x0209:
            android.database.Cursor r1 = r7.f6853a
            if (r1 == 0) goto L_0x0210
            r1.close()
        L_0x0210:
            r0.set(r6)
            return r4
        L_0x0214:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "Failed to load remote module."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x021d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "Failed to create IDynamiteLoader."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0226:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            java.lang.String r2 = "Failed to determine which loading route to use."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0231:
            r0 = move-exception
            r19 = r4
            goto L_0x0241
        L_0x0235:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0240 }
            java.lang.String r2 = "Remote loading disabled"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ all -> 0x0240 }
            throw r0     // Catch:{ all -> 0x0240 }
        L_0x0240:
            r0 = move-exception
        L_0x0241:
            monitor-exit(r15)     // Catch:{ all -> 0x0240 }
            throw r0     // Catch:{ RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c }
        L_0x0243:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ LoadingException -> 0x024f }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x024f }
            java.lang.String r4 = "Failed to load remote module."
            r5 = 0
            r2.<init>(r4, r0, r5)     // Catch:{ LoadingException -> 0x024f }
            throw r2     // Catch:{ LoadingException -> 0x024f }
        L_0x024f:
            r0 = move-exception
            goto L_0x025e
        L_0x0251:
            throw r0     // Catch:{ LoadingException -> 0x024f }
        L_0x0252:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x024f }
            java.lang.String r4 = "Failed to load remote module."
            r5 = 0
            r2.<init>(r4, r0, r5)     // Catch:{ LoadingException -> 0x024f }
            throw r2     // Catch:{ LoadingException -> 0x024f }
        L_0x025b:
            r0 = move-exception
            r19 = r4
        L_0x025e:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r5.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = "Failed to load remote module: "
            r5.append(r8)     // Catch:{ all -> 0x0079 }
            r5.append(r4)     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0079 }
            android.util.Log.w(r2, r4)     // Catch:{ all -> 0x0079 }
            int r2 = r14.localVersion     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x02b1
            com.google.android.gms.dynamite.o r4 = new com.google.android.gms.dynamite.o     // Catch:{ all -> 0x0079 }
            r5 = 0
            r4.<init>(r2, r5)     // Catch:{ all -> 0x0079 }
            r2 = r21
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = r2.selectModule(r1, r3, r4)     // Catch:{ all -> 0x0079 }
            int r1 = r1.selection     // Catch:{ all -> 0x0079 }
            r2 = -1
            if (r1 != r2) goto L_0x02b1
            r1 = r19
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{ all -> 0x0079 }
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x029f
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02a4
        L_0x029f:
            java.lang.ThreadLocal r1 = zzh
            r1.set(r9)
        L_0x02a4:
            android.database.Cursor r1 = r7.f6853a
            if (r1 == 0) goto L_0x02ab
            r1.close()
        L_0x02ab:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r6)
            return r0
        L_0x02b1:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x0079 }
            throw r1     // Catch:{ all -> 0x0079 }
        L_0x02ba:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r1.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "VersionPolicy returned invalid code:"
            r1.append(r3)     // Catch:{ all -> 0x0079 }
            r1.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0079 }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0079 }
            throw r0     // Catch:{ all -> 0x0079 }
        L_0x02d2:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0079 }
            int r1 = r14.localVersion     // Catch:{ all -> 0x0079 }
            int r2 = r14.remoteVersion     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r4.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "No acceptable module "
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            r4.append(r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x0079 }
            r4.append(r1)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x0079 }
            r4.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0079 }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0079 }
            throw r0     // Catch:{ all -> 0x0079 }
        L_0x0303:
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x030d
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0312
        L_0x030d:
            java.lang.ThreadLocal r1 = zzh
            r1.set(r9)
        L_0x0312:
            android.database.Cursor r1 = r7.f6853a
            if (r1 == 0) goto L_0x0319
            r1.close()
        L_0x0319:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r6)
            throw r0
        L_0x031f:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r1 = "null application Context"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x00a2=Splitter:B:52:0x00a2, B:33:0x005c=Splitter:B:33:0x005c, B:18:0x003e=Splitter:B:18:0x003e} */
    public static int zza(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00eb }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x004b }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00df
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x0036 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x0036 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            if (r5 != r6) goto L_0x0039
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
            goto L_0x00b8
        L_0x0036:
            r1 = move-exception
            goto L_0x00ba
        L_0x0039:
            if (r5 == 0) goto L_0x0042
            zzd(r5)     // Catch:{ LoadingException -> 0x003e }
        L_0x003e:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0036 }
            goto L_0x00b8
        L_0x0042:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x004e
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r3
        L_0x004b:
            r11 = move-exception
            goto L_0x01cd
        L_0x004e:
            boolean r5 = zzd     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x00af
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0036 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x0036 }
            if (r6 == 0) goto L_0x005b
            goto L_0x00af
        L_0x005b:
            r6 = 1
            int r6 = zzb(r10, r11, r12, r6)     // Catch:{ LoadingException -> 0x00a5 }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x00a5 }
            if (r7 == 0) goto L_0x00a2
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x00a5 }
            if (r7 == 0) goto L_0x006b
            goto L_0x00a2
        L_0x006b:
            java.lang.ClassLoader r7 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x00a5 }
            if (r7 == 0) goto L_0x0072
            goto L_0x0097
        L_0x0072:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x00a5 }
            r8 = 29
            if (r7 < r8) goto L_0x0089
            com.google.android.gms.dynamite.b.a()     // Catch:{ LoadingException -> 0x00a5 }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x00a5 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x00a5 }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a5 }
            dalvik.system.DelegateLastClassLoader r7 = com.google.android.gms.dynamite.a.a(r7, r8)     // Catch:{ LoadingException -> 0x00a5 }
            goto L_0x0097
        L_0x0089:
            com.google.android.gms.dynamite.d r7 = new com.google.android.gms.dynamite.d     // Catch:{ LoadingException -> 0x00a5 }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x00a5 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x00a5 }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a5 }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x00a5 }
        L_0x0097:
            zzd(r7)     // Catch:{ LoadingException -> 0x00a5 }
            r1.set(r2, r7)     // Catch:{ LoadingException -> 0x00a5 }
            zzb = r5     // Catch:{ LoadingException -> 0x00a5 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r6
        L_0x00a2:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r6
        L_0x00a5:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            r1.set(r2, r5)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
            goto L_0x00b8
        L_0x00af:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            r1.set(r2, r5)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
        L_0x00b8:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            goto L_0x00dd
        L_0x00ba:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00c0, IllegalAccessException -> 0x00be, NoSuchFieldException -> 0x00bc }
        L_0x00bc:
            r1 = move-exception
            goto L_0x00c1
        L_0x00be:
            r1 = move-exception
            goto L_0x00c1
        L_0x00c0:
            r1 = move-exception
        L_0x00c1:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r5.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x004b }
            r5.append(r1)     // Catch:{ all -> 0x004b }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x004b }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x004b }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x004b }
        L_0x00dd:
            zzb = r1     // Catch:{ all -> 0x004b }
        L_0x00df:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00eb }
            if (r0 == 0) goto L_0x010a
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00ee }
            return r10
        L_0x00eb:
            r11 = move-exception
            goto L_0x01cf
        L_0x00ee:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00eb }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r0.<init>()     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x00eb }
            r0.append(r11)     // Catch:{ all -> 0x00eb }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00eb }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x00eb }
            return r3
        L_0x010a:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x0112
            goto L_0x01c4
        L_0x0112:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x012d }
            r1 = 3
            if (r0 < r1) goto L_0x017f
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x012d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x012d }
            com.google.android.gms.dynamite.n r0 = (com.google.android.gms.dynamite.n) r0     // Catch:{ RemoteException -> 0x012d }
            if (r0 == 0) goto L_0x0130
            android.database.Cursor r0 = r0.f6853a     // Catch:{ RemoteException -> 0x012d }
            if (r0 == 0) goto L_0x0130
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x012d }
            goto L_0x01c4
        L_0x012d:
            r11 = move-exception
            goto L_0x01a4
        L_0x0130:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x012d }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x012d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x012d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x012d }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x012d }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x012d }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x012d }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x012d }
            if (r11 == 0) goto L_0x016e
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0164, all -> 0x0162 }
            if (r12 != 0) goto L_0x0155
            goto L_0x016e
        L_0x0155:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0164, all -> 0x0162 }
            if (r12 <= 0) goto L_0x0166
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x0164, all -> 0x0162 }
            if (r0 == 0) goto L_0x0166
            goto L_0x0167
        L_0x0162:
            r12 = move-exception
            goto L_0x017b
        L_0x0164:
            r12 = move-exception
            goto L_0x017d
        L_0x0166:
            r2 = r11
        L_0x0167:
            if (r2 == 0) goto L_0x016c
            r2.close()     // Catch:{ all -> 0x00eb }
        L_0x016c:
            r3 = r12
            goto L_0x01c4
        L_0x016e:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x0164, all -> 0x0162 }
            if (r11 == 0) goto L_0x01c4
            r11.close()     // Catch:{ all -> 0x00eb }
            goto L_0x01c4
        L_0x017b:
            r2 = r11
            goto L_0x01c7
        L_0x017d:
            r2 = r11
            goto L_0x01a5
        L_0x017f:
            r1 = 2
            if (r0 != r1) goto L_0x0192
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x012d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x012d }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x012d }
            goto L_0x01c4
        L_0x0192:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x012d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x012d }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x012d }
            goto L_0x01c4
        L_0x01a2:
            r12 = r11
            goto L_0x01c7
        L_0x01a4:
            r12 = r11
        L_0x01a5:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c5 }
            r0.<init>()     // Catch:{ all -> 0x01c5 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c5 }
            r0.append(r12)     // Catch:{ all -> 0x01c5 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01c5 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01c5 }
            if (r2 == 0) goto L_0x01c4
            r2.close()     // Catch:{ all -> 0x00eb }
        L_0x01c4:
            return r3
        L_0x01c5:
            r11 = move-exception
            goto L_0x01a2
        L_0x01c7:
            if (r2 == 0) goto L_0x01cc
            r2.close()     // Catch:{ all -> 0x00eb }
        L_0x01cc:
            throw r12     // Catch:{ all -> 0x00eb }
        L_0x01cd:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r11     // Catch:{ all -> 0x00eb }
        L_0x01cf:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c2 A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c3 A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r12.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r10 == 0) goto L_0x00a9
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009f }
            if (r11 == 0) goto L_0x00a9
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009f }
            if (r12 <= 0) goto L_0x0090
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009f }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x0070 }
            zzc = r2     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0070 }
            if (r2 < 0) goto L_0x0072
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x0070 }
            zze = r2     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r11 = move-exception
            goto L_0x008e
        L_0x0072:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0070 }
            if (r2 < 0) goto L_0x0085
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r9 = r11
        L_0x0082:
            zzd = r9     // Catch:{ all -> 0x0070 }
            r11 = r9
        L_0x0085:
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009f }
            if (r1 == 0) goto L_0x0090
            r10 = r0
            goto L_0x0090
        L_0x008e:
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            throw r11     // Catch:{ Exception -> 0x009f }
        L_0x0090:
            if (r13 == 0) goto L_0x00a3
            if (r11 != 0) goto L_0x0095
            goto L_0x00a3
        L_0x0095:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009f }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009f }
            throw r11     // Catch:{ Exception -> 0x009f }
        L_0x009d:
            r11 = move-exception
            goto L_0x00a1
        L_0x009f:
            r11 = move-exception
            goto L_0x00be
        L_0x00a1:
            r0 = r10
            goto L_0x00de
        L_0x00a3:
            if (r10 == 0) goto L_0x00a8
            r10.close()
        L_0x00a8:
            return r12
        L_0x00a9:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009f }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009f }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009f }
            throw r11     // Catch:{ Exception -> 0x009f }
        L_0x00b8:
            r10 = move-exception
            r11 = r10
            goto L_0x00de
        L_0x00bb:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00be:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x009d }
            if (r12 == 0) goto L_0x00c3
            throw r11     // Catch:{ all -> 0x009d }
        L_0x00c3:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x009d }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x009d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
            r1.<init>()     // Catch:{ all -> 0x009d }
            java.lang.String r2 = "V2 version check failed: "
            r1.append(r2)     // Catch:{ all -> 0x009d }
            r1.append(r13)     // Catch:{ all -> 0x009d }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x009d }
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x009d }
            throw r12     // Catch:{ all -> 0x009d }
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.close()
        L_0x00e3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class[]) null).newInstance((Object[]) null);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        } catch (InstantiationException e12) {
            e = e12;
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        } catch (InvocationTargetException e13) {
            e = e13;
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        } catch (NoSuchMethodException e14) {
            e = e14;
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        n nVar = (n) zzg.get();
        if (nVar == null || nVar.f6853a != null) {
            return false;
        }
        nVar.f6853a = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(zzf)) {
            return true;
        }
        boolean z10 = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, c.f18291e) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            zzf = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    @Nullable
    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzq) {
                        zzq = (zzq) queryLocalInterface;
                    } else {
                        zzq = new zzq(iBinder);
                    }
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, (zzp) null);
        }
    }
}
