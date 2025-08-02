package com.google.android.gms.internal.auth;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class e0 extends zzdc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhu f6914a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e0(zzcz zzcz, String str, Object obj, boolean z10, zzhu zzhu, byte[] bArr) {
        super(zzcz, "getTokenRefactor__blocked_packages", obj, true, (zzdb) null);
        this.f6914a = zzhu;
    }

    /* access modifiers changed from: package-private */
    public final Object zza(Object obj) {
        try {
            return zzhr.zzk(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid byte[] value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
