package com.google.android.gms.internal.stats;

import androidx.annotation.Nullable;
import java.io.Closeable;

public final class zzb implements Closeable {
    private static final zzb zza = new zzb(false, (zzd) null);

    private zzb(boolean z10, @Nullable zzd zzd) {
    }

    public static zzb zza(boolean z10, @Nullable zzc zzc) {
        return zza;
    }

    public final void close() {
    }
}
