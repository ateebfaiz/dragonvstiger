package com.google.android.gms.internal.fido;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzde {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzdd zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i10 = zzdd.zza;
        p0 p0Var = new p0(bArr, 0, 0, false, (zzda) null);
        try {
            p0Var.a(0);
            zzf = p0Var;
        } catch (zzdf e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
