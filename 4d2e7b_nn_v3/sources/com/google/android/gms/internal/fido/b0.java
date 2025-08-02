package com.google.android.gms.internal.fido;

import okio.Utf8;

final class b0 extends c0 {
    private b0(z zVar, Character ch) {
        super(zVar, ch);
        zzap.zzc(zVar.f7103b.length == 64);
    }

    /* access modifiers changed from: package-private */
    public final zzch a(z zVar, Character ch) {
        return new b0(zVar, ch);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Appendable appendable, byte[] bArr, int i10, int i11) {
        int i12 = 0;
        zzap.zze(0, i11, bArr.length);
        for (int i13 = i11; i13 >= 3; i13 -= 3) {
            byte b10 = ((bArr[i12 + 1] & 255) << 8) | ((bArr[i12] & 255) << 16) | (bArr[i12 + 2] & 255);
            appendable.append(this.f7054a.a(b10 >>> 18));
            appendable.append(this.f7054a.a((b10 >>> 12) & 63));
            appendable.append(this.f7054a.a((b10 >>> 6) & 63));
            appendable.append(this.f7054a.a(b10 & Utf8.REPLACEMENT_BYTE));
            i12 += 3;
        }
        if (i12 < i11) {
            b(appendable, bArr, i12, i11 - i12);
        }
    }

    b0(String str, String str2, Character ch) {
        this(new z(str, str2.toCharArray()), ch);
    }
}
