package com.google.android.gms.internal.fido;

import java.util.Arrays;

public final class zzam {
    private final String zza;
    private final c zzb;
    private c zzc;

    /* synthetic */ zzam(String str, zzal zzal) {
        c cVar = new c((zzaj) null);
        this.zzb = cVar;
        this.zzc = cVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        c cVar = this.zzb.f7053c;
        String str = "";
        while (cVar != null) {
            Object obj = cVar.f7052b;
            sb2.append(str);
            String str2 = cVar.f7051a;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            cVar = cVar.f7053c;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzam zza(String str, int i10) {
        String valueOf = String.valueOf(i10);
        b bVar = new b((zzah) null);
        this.zzc.f7053c = bVar;
        this.zzc = bVar;
        bVar.f7052b = valueOf;
        bVar.f7051a = "errorCode";
        return this;
    }

    public final zzam zzb(String str, Object obj) {
        c cVar = new c((zzaj) null);
        this.zzc.f7053c = cVar;
        this.zzc = cVar;
        cVar.f7052b = obj;
        cVar.f7051a = str;
        return this;
    }
}
