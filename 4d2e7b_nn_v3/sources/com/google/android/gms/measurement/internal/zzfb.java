package com.google.android.gms.measurement.internal;

import com.alibaba.pdns.f;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfb implements Callable {
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfb(zzfi zzfi, String str) {
        this.zza = zzfi;
        this.zzb = str;
    }

    public final Object call() {
        zzfi zzfi = this.zza;
        String str = this.zzb;
        c1 D = zzfi.zzf.zzi().D(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", f.f17924q);
        hashMap.put("package_name", str);
        zzfi.zzt.zzf().zzh();
        hashMap.put("gmp_version", 74029L);
        if (D != null) {
            String g02 = D.g0();
            if (g02 != null) {
                hashMap.put("app_version", g02);
            }
            hashMap.put("app_version_int", Long.valueOf(D.L()));
            hashMap.put("dynamite_version", Long.valueOf(D.U()));
        }
        return hashMap;
    }
}
