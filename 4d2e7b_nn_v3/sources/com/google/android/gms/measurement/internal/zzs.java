package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;

public final class zzs {
    private final zzfr zza;

    public zzs(zzfr zzfr) {
        this.zza = zzfr;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzaz().zzg();
        if (!this.zza.zzJ()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String next : bundle.keySet()) {
                    builder.appendQueryParameter(next, bundle.getString(next));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzm().f7787t.zzb(str2);
                this.zza.zzm().f7788u.zzb(this.zza.zzav().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb() {
        String str;
        this.zza.zzaz().zzg();
        if (zzd()) {
            if (zze()) {
                this.zza.zzm().f7787t.zzb((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.zza.zzq().zzG("auto", "_cmpx", bundle);
            } else {
                String zza2 = this.zza.zzm().f7787t.zza();
                if (TextUtils.isEmpty(zza2)) {
                    this.zza.zzay().zzh().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((this.zza.zzm().f7788u.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = "app";
                    } else {
                        str = (String) obj;
                    }
                    this.zza.zzq().zzG(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.zza.zzm().f7787t.zzb((String) null);
            }
            this.zza.zzm().f7788u.zzb(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (zzd() && zze()) {
            this.zza.zzm().f7787t.zzb((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        if (this.zza.zzm().f7788u.zza() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        if (zzd() && this.zza.zzav().currentTimeMillis() - this.zza.zzm().f7788u.zza() > this.zza.zzf().zzi((String) null, zzdu.zzQ)) {
            return true;
        }
        return false;
    }
}
