package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

abstract class a extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    a(int i10) {
    }

    @CanIgnoreReturnValue
    public final a zza(Object obj) {
        obj.getClass();
        int i10 = this.zzb;
        int i11 = i10 + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i11) {
            int i12 = length + (length >> 1) + 1;
            if (i12 < i11) {
                int highestOneBit = Integer.highestOneBit(i10);
                i12 = highestOneBit + highestOneBit;
            }
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i12);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i13 = this.zzb;
        this.zzb = i13 + 1;
        objArr2[i13] = obj;
        return this;
    }
}
