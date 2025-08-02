package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.VersionPolicy.IVersions {
    f() {
    }

    public final int zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str);
    }

    public final int zzb(Context context, String str, boolean z10) {
        return DynamiteModule.zza(context, str, z10);
    }
}
