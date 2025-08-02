package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzje implements Iterable, Serializable {
    private static final Comparator zza = new l2();
    public static final zzje zzb = new p2(zzkn.zzd);
    private static final q2 zzd = new q2((zzjc) null);
    private int zzc = 0;

    static {
        int i10 = h2.f7184a;
    }

    zzje() {
    }

    static int zzj(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        } else if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
        }
    }

    public static zzje zzl(byte[] bArr, int i10, int i11) {
        zzj(i10, i10 + i11, bArr.length);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new p2(bArr2);
    }

    public static zzje zzm(String str) {
        return new p2(str.getBytes(zzkn.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.zzc;
        if (i10 == 0) {
            int zzd2 = zzd();
            i10 = zze(zzd2, 0, zzd2);
            if (i10 == 0) {
                i10 = 1;
            }
            this.zzc = i10;
        }
        return i10;
    }

    public final /* synthetic */ Iterator iterator() {
        return new k2(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            str = i4.a(this);
        } else {
            str = i4.a(zzf(0, 47)).concat("...");
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }

    public abstract byte zza(int i10);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i10);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract int zze(int i10, int i11, int i12);

    public abstract zzje zzf(int i10, int i11);

    /* access modifiers changed from: protected */
    public abstract String zzg(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzh(zziu zziu) throws IOException;

    public abstract boolean zzi();

    /* access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzg(charset);
    }
}
