package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzjl implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzjm zza;
    /* access modifiers changed from: private */
    public volatile boolean zzb;
    private volatile zzed zzc;

    protected zzjl(zzjm zzjm) {
        this.zza = zzjm;
    }

    @MainThread
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzt.zzaz().zzp(new e3(this, (zzdx) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzeh zzl = this.zza.zzt.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzt.zzaz().zzp(new g3(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i10) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzt.zzay().zzc().zza("Service connection suspended");
        this.zza.zzt.zzaz().zzp(new f3(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.zza.zzt.zzay().zzd().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0066 */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x0021
            r3.zzb = r4     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzjm r4 = r3.zza     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x001e }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001e }
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r4 = move-exception
            goto L_0x00a3
        L_0x0021:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0066 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0066 }
            if (r2 == 0) goto L_0x0054
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0066 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzdx     // Catch:{ RemoteException -> 0x0066 }
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzdx r1 = (com.google.android.gms.measurement.internal.zzdx) r1     // Catch:{ RemoteException -> 0x0066 }
        L_0x003a:
            r0 = r1
            goto L_0x0042
        L_0x003c:
            com.google.android.gms.measurement.internal.zzdv r1 = new com.google.android.gms.measurement.internal.zzdv     // Catch:{ RemoteException -> 0x0066 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0066 }
            goto L_0x003a
        L_0x0042:
            com.google.android.gms.measurement.internal.zzjm r5 = r3.zza     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()     // Catch:{ RemoteException -> 0x0066 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x0066 }
            goto L_0x0077
        L_0x0054:
            com.google.android.gms.measurement.internal.zzjm r5 = r3.zza     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ RemoteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ RemoteException -> 0x0066 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzb(r2, r1)     // Catch:{ RemoteException -> 0x0066 }
            goto L_0x0077
        L_0x0066:
            com.google.android.gms.measurement.internal.zzjm r5 = r3.zza     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001e }
        L_0x0077:
            if (r0 != 0) goto L_0x0091
            r3.zzb = r4     // Catch:{ all -> 0x001e }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzjm r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ IllegalArgumentException -> 0x00a1 }
            android.content.Context r5 = r5.zzau()     // Catch:{ IllegalArgumentException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzjm r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzjl r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x00a1 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x00a1 }
            goto L_0x00a1
        L_0x0091:
            com.google.android.gms.measurement.internal.zzjm r4 = r3.zza     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.zzfo r4 = r4.zzaz()     // Catch:{ all -> 0x001e }
            com.google.android.gms.measurement.internal.c3 r5 = new com.google.android.gms.measurement.internal.c3     // Catch:{ all -> 0x001e }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001e }
            r4.zzp(r5)     // Catch:{ all -> 0x001e }
        L_0x00a1:
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            return
        L_0x00a3:
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjl.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzt.zzay().zzc().zza("Service disconnected");
        this.zza.zzt.zzaz().zzp(new d3(this, componentName));
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        this.zza.zzg();
        Context zzau = this.zza.zzt.zzau();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzt.zzay().zzj().zza("Connection attempt already in progress");
                    return;
                }
                this.zza.zzt.zzay().zzj().zza("Using local app measurement service");
                this.zzb = true;
                instance.bindService(zzau, intent, this.zza.zza, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzc() {
        this.zza.zzg();
        Context zzau = this.zza.zzt.zzau();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzt.zzay().zzj().zza("Connection attempt already in progress");
                } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                    this.zzc = new zzed(zzau, Looper.getMainLooper(), this, this);
                    this.zza.zzt.zzay().zzj().zza("Connecting to remote service");
                    this.zzb = true;
                    Preconditions.checkNotNull(this.zzc);
                    this.zzc.checkAvailabilityAndConnect();
                } else {
                    this.zza.zzt.zzay().zzj().zza("Already awaiting connection attempt");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzd() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }
}
