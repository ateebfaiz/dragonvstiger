package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.HttpUrl;

public final class zzdi extends zzdr {
    private final zzaz zza;
    private final int zzb;

    zzdi(zzaz zzaz) throws zzdh {
        zzaz.getClass();
        this.zza = zzaz;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            zzaz zzaz2 = this.zza;
            if (i10 >= zzaz2.size()) {
                break;
            }
            int zzb2 = ((zzdr) zzaz2.get(i10)).zzb();
            if (i11 < zzb2) {
                i11 = zzb2;
            }
            i10++;
        }
        int i12 = i11 + 1;
        this.zzb = i12;
        if (i12 > 4) {
            throw new zzdh("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd(Byte.MIN_VALUE) != zzdr.zza()) {
            return zzdr.zzd(Byte.MIN_VALUE) - zzdr.zza();
        }
        zzdi zzdi = (zzdi) zzdr;
        zzaz zzaz = this.zza;
        int size = zzaz.size();
        zzaz zzaz2 = zzdi.zza;
        if (size != zzaz2.size()) {
            return zzaz.size() - zzaz2.size();
        }
        int i10 = 0;
        while (true) {
            zzaz zzaz3 = this.zza;
            if (i10 >= zzaz3.size()) {
                return 0;
            }
            int compareTo = ((zzdr) zzaz3.get(i10)).compareTo((zzdr) zzdi.zza.get(i10));
            if (compareTo != 0) {
                return compareTo;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdi.class == obj.getClass()) {
            return this.zza.equals(((zzdi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(Byte.MIN_VALUE)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        ArrayList arrayList = new ArrayList();
        zzaz zzaz = this.zza;
        int size = zzaz.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((zzdr) zzaz.get(i10)).toString().replace("\n", "\n  "));
        }
        zzag zza2 = zzag.zza(",\n  ");
        StringBuilder sb2 = new StringBuilder("[\n  ");
        try {
            zza2.zzb(sb2, arrayList.iterator());
            sb2.append("\n]");
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzdr.zzd(Byte.MIN_VALUE);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        return this.zzb;
    }
}
