package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.firebase.messaging.Constants;

final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbr f7801a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ServiceConnection f7802b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzey f7803c;

    y(zzey zzey, zzbr zzbr, ServiceConnection serviceConnection) {
        this.f7803c = zzey;
        this.f7801a = zzbr;
        this.f7802b = serviceConnection;
    }

    public final void run() {
        zzey zzey = this.f7803c;
        zzez zzez = zzey.zza;
        String zza = zzey.zzb;
        zzbr zzbr = this.f7801a;
        ServiceConnection serviceConnection = this.f7802b;
        zzez.zza.zzaz().zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", zza);
        Bundle bundle2 = null;
        try {
            Bundle zzd = zzbr.zzd(bundle);
            if (zzd == null) {
                zzez.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            } else {
                bundle2 = zzd;
            }
        } catch (Exception e10) {
            zzez.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        zzez.zza.zzaz().zzg();
        zzfr.zzO();
        if (bundle2 != null) {
            long j10 = bundle2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j10 == 0) {
                zzez.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle2.getString(Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzez.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzez.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    Bundle zzs = zzez.zza.zzv().zzs(Uri.parse("?".concat(string)));
                    if (zzs == null) {
                        zzez.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j11 = bundle2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j11 == 0) {
                                zzez.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == zzez.zza.zzm().f7771d.zza()) {
                            zzez.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzez.zza.zzJ()) {
                            zzez.zza.zzm().f7771d.zzb(j10);
                            zzez.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs.putString("_cis", "referrer API v2");
                            zzez.zza.zzq().zzF("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzs, zza);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzez.zza.zzau(), serviceConnection);
    }
}
