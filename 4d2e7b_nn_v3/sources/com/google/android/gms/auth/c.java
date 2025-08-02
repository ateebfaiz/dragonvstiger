package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zze;

final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6634a;

    c(String str) {
        this.f6634a = str;
    }

    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) {
        Bundle zzg = zze.zzb(iBinder).zzg(this.f6634a);
        Object unused = zzl.zzj(zzg);
        String string = zzg.getString("Error");
        Intent intent = (Intent) zzg.getParcelable("userRecoveryIntent");
        zzby zza = zzby.zza(string);
        if (zzby.SUCCESS.equals(zza)) {
            return Boolean.TRUE;
        }
        if (zzby.zzb(zza)) {
            zzl.zzd.w("isUserRecoverableError status: ".concat(String.valueOf(zza)), new Object[0]);
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
