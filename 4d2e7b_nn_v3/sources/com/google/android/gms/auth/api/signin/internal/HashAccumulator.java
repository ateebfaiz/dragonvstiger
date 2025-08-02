package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class HashAccumulator {
    @VisibleForTesting
    static int zaa = 31;
    private int zab = 1;

    @NonNull
    @KeepForSdk
    public HashAccumulator addObject(@Nullable Object obj) {
        int i10;
        int i11 = zaa * this.zab;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        this.zab = i11 + i10;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    @NonNull
    public final HashAccumulator zaa(boolean z10) {
        this.zab = (zaa * this.zab) + (z10 ? 1 : 0);
        return this;
    }
}
