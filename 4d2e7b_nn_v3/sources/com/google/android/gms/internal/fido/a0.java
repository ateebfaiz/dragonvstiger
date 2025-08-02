package com.google.android.gms.internal.fido;

final class a0 extends c0 {

    /* renamed from: d  reason: collision with root package name */
    final char[] f7050d;

    private a0(z zVar) {
        super(zVar, (Character) null);
        this.f7050d = new char[512];
        zzap.zzc(zVar.f7103b.length == 16);
        for (int i10 = 0; i10 < 256; i10++) {
            this.f7050d[i10] = zVar.a(i10 >>> 4);
            this.f7050d[i10 | 256] = zVar.a(i10 & 15);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzch a(z zVar, Character ch) {
        return new a0(zVar);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Appendable appendable, byte[] bArr, int i10, int i11) {
        zzap.zze(0, i11, bArr.length);
        for (int i12 = 0; i12 < i11; i12++) {
            byte b10 = bArr[i12] & 255;
            appendable.append(this.f7050d[b10]);
            appendable.append(this.f7050d[b10 | 256]);
        }
    }

    a0(String str, String str2) {
        this(new z("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
