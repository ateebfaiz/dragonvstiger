package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

final class c0 implements zzo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7410a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfi f7411b;

    c0(zzfi zzfi, String str) {
        this.f7411b = zzfi;
        this.f7410a = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.f7411b.zzg.get(this.f7410a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
