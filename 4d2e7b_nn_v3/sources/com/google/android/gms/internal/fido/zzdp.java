package com.google.android.gms.internal.fido;

import java.util.Arrays;

public final class zzdp extends zzdr {
    private final String zza;

    zzdp(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int length;
        int length2;
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd((byte) 96) != zzdr.zza()) {
            length2 = zzdr.zza();
            length = zzdr.zzd((byte) 96);
        } else {
            String str = this.zza;
            int length3 = str.length();
            String str2 = ((zzdp) zzdr).zza;
            if (length3 == str2.length()) {
                return str.compareTo(str2);
            }
            length = str.length();
            length2 = str2.length();
        }
        return length - length2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdp.class == obj.getClass()) {
            return this.zza.equals(((zzdp) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd((byte) 96)), this.zza});
    }

    public final String toString() {
        String str = this.zza;
        return "\"" + str + "\"";
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzdr.zzd((byte) 96);
    }
}
