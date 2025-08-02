package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzd {
    static int zza(int i10) {
        int[] iArr = {1, 2, 3};
        int i11 = 0;
        while (i11 < 3) {
            int i12 = iArr[i11];
            int i13 = i12 - 1;
            if (i12 == 0) {
                throw null;
            } else if (i13 == i10) {
                return i12;
            } else {
                i11++;
            }
        }
        return 1;
    }
}
