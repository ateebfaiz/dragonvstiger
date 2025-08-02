package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

final class w extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final zzkt f7753a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7754b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7755c;

    w(zzkt zzkt) {
        Preconditions.checkNotNull(zzkt);
        this.f7753a = zzkt;
    }

    public final void b() {
        this.f7753a.zzB();
        this.f7753a.zzaz().zzg();
        if (!this.f7754b) {
            this.f7753a.zzau().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f7755c = this.f7753a.zzl().zza();
            this.f7753a.zzay().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f7755c));
            this.f7754b = true;
        }
    }

    public final void c() {
        this.f7753a.zzB();
        this.f7753a.zzaz().zzg();
        this.f7753a.zzaz().zzg();
        if (this.f7754b) {
            this.f7753a.zzay().zzj().zza("Unregistering connectivity change receiver");
            this.f7754b = false;
            this.f7755c = false;
            try {
                this.f7753a.zzau().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f7753a.zzay().zzd().zzb("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        this.f7753a.zzB();
        String action = intent.getAction();
        this.f7753a.zzay().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zza = this.f7753a.zzl().zza();
            if (this.f7755c != zza) {
                this.f7755c = zza;
                this.f7753a.zzaz().zzp(new v(this, zza));
                return;
            }
            return;
        }
        this.f7753a.zzay().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }
}
