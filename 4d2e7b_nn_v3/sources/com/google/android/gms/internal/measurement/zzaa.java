package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public final class zzaa {
    private String zza;
    private final long zzb;
    private final Map zzc;

    public zzaa(String str, long j10, Map map) {
        this.zza = str;
        this.zzb = j10;
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaa = (zzaa) obj;
        if (this.zzb == zzaa.zzb && this.zza.equals(zzaa.zza)) {
            return this.zzc.equals(zzaa.zzc);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode();
        long j10 = this.zzb;
        return (((hashCode * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.zzc.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        long j10 = this.zzb;
        String obj = this.zzc.toString();
        return "Event{name='" + str + "', timestamp=" + j10 + ", params=" + obj + "}";
    }

    public final long zza() {
        return this.zzb;
    }

    /* renamed from: zzb */
    public final zzaa clone() {
        return new zzaa(this.zza, this.zzb, new HashMap(this.zzc));
    }

    public final Object zzc(String str) {
        if (this.zzc.containsKey(str)) {
            return this.zzc.get(str);
        }
        return null;
    }

    public final String zzd() {
        return this.zza;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final void zzf(String str) {
        this.zza = str;
    }

    public final void zzg(String str, Object obj) {
        if (obj == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, obj);
        }
    }
}
