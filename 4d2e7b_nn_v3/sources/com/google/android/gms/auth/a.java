package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;

final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6614a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f6615b;

    a(String str, Bundle bundle) {
        this.f6614a = str;
        this.f6615b = bundle;
    }

    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) {
        Bundle zzd = zze.zzb(iBinder).zzd(this.f6614a, this.f6615b);
        Object unused = zzl.zzj(zzd);
        String string = zzd.getString("Error");
        if (zzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
