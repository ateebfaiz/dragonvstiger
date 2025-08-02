package com.google.android.gms.internal.fido;

import java.io.IOException;

public abstract class zzch {
    private static final zzch zza = new b0("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzch zzb = new b0("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzch zzc = new c0("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzch zzd = new c0("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzch zze = new a0("base16()", "0123456789ABCDEF");

    zzch() {
    }

    public static zzch zzf() {
        return zze;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i10);

    public abstract zzch zzd();

    public final String zzg(byte[] bArr, int i10, int i11) {
        zzap.zze(0, i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzc(i11));
        try {
            zzb(sb2, bArr, 0, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
