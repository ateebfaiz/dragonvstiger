package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class o implements DynamiteModule.VersionPolicy.IVersions {

    /* renamed from: a  reason: collision with root package name */
    private final int f6854a;

    public o(int i10, int i11) {
        this.f6854a = i10;
    }

    public final int zza(Context context, String str) {
        return this.f6854a;
    }

    public final int zzb(Context context, String str, boolean z10) {
        return 0;
    }
}
