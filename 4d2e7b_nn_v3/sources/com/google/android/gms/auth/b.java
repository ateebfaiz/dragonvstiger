package com.google.android.gms.auth;

import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;

final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountChangeEventsRequest f6633a;

    b(AccountChangeEventsRequest accountChangeEventsRequest) {
        this.f6633a = accountChangeEventsRequest;
    }

    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) {
        AccountChangeEventsResponse zzh = zze.zzb(iBinder).zzh(this.f6633a);
        Object unused = zzl.zzj(zzh);
        return zzh.getEvents();
    }
}
