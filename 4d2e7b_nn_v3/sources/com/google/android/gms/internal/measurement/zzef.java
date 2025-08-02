package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzef {
    private static volatile zzef zzc;
    protected final Clock zza;
    protected final ExecutorService zzb;
    /* access modifiers changed from: private */
    public final String zzd;
    private final AppMeasurementSdk zze;
    @GuardedBy("listenerList")
    private final List zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzh;
    private final String zzi;
    /* access modifiers changed from: private */
    public volatile zzcc zzj;

    protected zzef(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z10;
        if (str == null || !zzW(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.getInstance();
        zzbx.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new h0(this));
        boolean z11 = true;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzid.zzc(context, "google_app_id", zzfj.zza(context)) != null && !zzS()) {
                this.zzi = null;
                this.zzh = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzW(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if (str2 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 ^ (str3 != null ? false : z11)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzi = str2;
        }
        zzV(new w(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new d1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void zzT(Exception exc, boolean z10, boolean z11) {
        this.zzh |= z10;
        if (z10) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z11) {
            zzB(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzU(String str, String str2, Bundle bundle, boolean z10, boolean z11, Long l10) {
        zzV(new r0(this, l10, str, str2, bundle, z10, z11));
    }

    /* access modifiers changed from: private */
    public final void zzV(t0 t0Var) {
        this.zzb.execute(t0Var);
    }

    /* access modifiers changed from: private */
    public final boolean zzW(String str, String str2) {
        if (str2 == null || str == null || zzS()) {
            return false;
        }
        return true;
    }

    public static zzef zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzef.class) {
                try {
                    if (zzc == null) {
                        zzc = new zzef(context, str, str2, str3, bundle);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzc;
    }

    public final void zzA(String str, String str2, Bundle bundle, long j10) {
        zzU(str, str2, bundle, true, false, Long.valueOf(j10));
    }

    public final void zzB(int i10, String str, Object obj, Object obj2, Object obj3) {
        zzV(new f0(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r4.zzj == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        android.util.Log.w(r4.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        zzV(new com.google.android.gms.internal.measurement.p0(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC(com.google.android.gms.measurement.internal.zzgs r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0028 }
            int r2 = r2.size()     // Catch:{ all -> 0x0028 }
            if (r1 >= r2) goto L_0x002d
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0028 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0028 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            java.lang.String r5 = r4.zzd     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r5 = move-exception
            goto L_0x0057
        L_0x002a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002d:
            com.google.android.gms.internal.measurement.v0 r1 = new com.google.android.gms.internal.measurement.v0     // Catch:{ all -> 0x0028 }
            r1.<init>(r5)     // Catch:{ all -> 0x0028 }
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0028 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0028 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0028 }
            r2.add(r3)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj
            if (r5 == 0) goto L_0x004e
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0047 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0047 }
            return
        L_0x0047:
            java.lang.String r5 = r4.zzd
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004e:
            com.google.android.gms.internal.measurement.p0 r5 = new com.google.android.gms.internal.measurement.p0
            r5.<init>(r4, r1)
            r4.zzV(r5)
            return
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzef.zzC(com.google.android.gms.measurement.internal.zzgs):void");
    }

    public final void zzD() {
        zzV(new u(this));
    }

    public final void zzE(Bundle bundle) {
        zzV(new m(this, bundle));
    }

    public final void zzF(Bundle bundle) {
        zzV(new s(this, bundle));
    }

    public final void zzG(Bundle bundle) {
        zzV(new t(this, bundle));
    }

    public final void zzH(Activity activity, String str, String str2) {
        zzV(new q(this, activity, str, str2));
    }

    public final void zzI(boolean z10) {
        zzV(new m0(this, z10));
    }

    public final void zzJ(Bundle bundle) {
        zzV(new n0(this, bundle));
    }

    public final void zzK(zzgr zzgr) {
        u0 u0Var = new u0(zzgr);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(u0Var);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzV(new o0(this, u0Var));
    }

    public final void zzL(Boolean bool) {
        zzV(new r(this, bool));
    }

    public final void zzM(long j10) {
        zzV(new v(this, j10));
    }

    public final void zzN(String str) {
        zzV(new p(this, str));
    }

    public final void zzO(String str, String str2, Object obj, boolean z10) {
        zzV(new s0(this, str, str2, obj, z10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r3.zzj == null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.zzj.unregisterOnMeasurementEventListener(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        android.util.Log.w(r3.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        zzV(new com.google.android.gms.internal.measurement.q0(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzP(com.google.android.gms.measurement.internal.zzgs r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x0028 }
            int r2 = r2.size()     // Catch:{ all -> 0x0028 }
            if (r1 >= r2) goto L_0x002d
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0028 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0028 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            java.util.List r4 = r3.zzf     // Catch:{ all -> 0x0028 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0028 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0028 }
            goto L_0x002e
        L_0x0028:
            r4 = move-exception
            goto L_0x005d
        L_0x002a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002d:
            r4 = 0
        L_0x002e:
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = r3.zzd     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0039:
            java.util.List r1 = r3.zzf     // Catch:{ all -> 0x0028 }
            r1.remove(r4)     // Catch:{ all -> 0x0028 }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.measurement.v0 r4 = (com.google.android.gms.internal.measurement.v0) r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj
            if (r0 == 0) goto L_0x0054
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004d }
            r0.unregisterOnMeasurementEventListener(r4)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004d }
            return
        L_0x004d:
            java.lang.String r0 = r3.zzd
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x0054:
            com.google.android.gms.internal.measurement.q0 r0 = new com.google.android.gms.internal.measurement.q0
            r0.<init>(r3, r4)
            r3.zzV(r0)
            return
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzef.zzP(com.google.android.gms.measurement.internal.zzgs):void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzS() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzef.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int zza(String str) {
        zzbz zzbz = new zzbz();
        zzV(new i0(this, str, zzbz));
        Integer num = (Integer) zzbz.zzf(zzbz.zzb(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzbz zzbz = new zzbz();
        zzV(new b0(this, zzbz));
        Long zzc2 = zzbz.zzc(500);
        if (zzc2 != null) {
            return zzc2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i10 = this.zzg + 1;
        this.zzg = i10;
        return nextLong + ((long) i10);
    }

    public final Bundle zzc(Bundle bundle, boolean z10) {
        zzbz zzbz = new zzbz();
        zzV(new g0(this, bundle, zzbz));
        if (z10) {
            return zzbz.zzb(5000);
        }
        return null;
    }

    public final AppMeasurementSdk zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzcc zzf(Context context, boolean z10) {
        try {
            return zzcb.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e10) {
            zzT(e10, true, false);
            return null;
        }
    }

    @WorkerThread
    public final Long zzh() {
        zzbz zzbz = new zzbz();
        zzV(new k0(this, zzbz));
        return zzbz.zzc(120000);
    }

    public final Object zzi(int i10) {
        zzbz zzbz = new zzbz();
        zzV(new l0(this, zzbz, i10));
        return zzbz.zzf(zzbz.zzb(15000), Object.class);
    }

    public final String zzk() {
        return this.zzi;
    }

    @WorkerThread
    public final String zzl() {
        zzbz zzbz = new zzbz();
        zzV(new j0(this, zzbz));
        return zzbz.zzd(120000);
    }

    public final String zzm() {
        zzbz zzbz = new zzbz();
        zzV(new a0(this, zzbz));
        return zzbz.zzd(50);
    }

    public final String zzn() {
        zzbz zzbz = new zzbz();
        zzV(new d0(this, zzbz));
        return zzbz.zzd(500);
    }

    public final String zzo() {
        zzbz zzbz = new zzbz();
        zzV(new c0(this, zzbz));
        return zzbz.zzd(500);
    }

    public final String zzp() {
        zzbz zzbz = new zzbz();
        zzV(new z(this, zzbz));
        return zzbz.zzd(500);
    }

    public final List zzq(String str, String str2) {
        zzbz zzbz = new zzbz();
        zzV(new o(this, str, str2, zzbz));
        List list = (List) zzbz.zzf(zzbz.zzb(5000), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final Map zzr(String str, String str2, boolean z10) {
        zzbz zzbz = new zzbz();
        zzV(new e0(this, str, str2, z10, zzbz));
        Bundle zzb2 = zzbz.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String next : zzb2.keySet()) {
            Object obj = zzb2.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void zzv(String str) {
        zzV(new x(this, str));
    }

    public final void zzw(String str, String str2, Bundle bundle) {
        zzV(new n(this, str, str2, bundle));
    }

    public final void zzx(String str) {
        zzV(new y(this, str));
    }

    public final void zzy(@NonNull String str, Bundle bundle) {
        zzU((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzz(String str, String str2, Bundle bundle) {
        zzU(str, str2, bundle, true, true, (Long) null);
    }
}
