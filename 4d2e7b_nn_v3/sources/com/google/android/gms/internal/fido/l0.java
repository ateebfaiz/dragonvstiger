package com.google.android.gms.internal.fido;

final class l0 extends n0 {

    /* renamed from: b  reason: collision with root package name */
    private final int f7075b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7076c;

    l0(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzcz.zzj(i10, i10 + i11, bArr.length);
        this.f7075b = i10;
        this.f7076c = i11;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        return this.f7075b;
    }

    public final byte zza(int i10) {
        int i11 = this.f7076c;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.f7078a[this.f7075b + i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i10) {
        return this.f7078a[this.f7075b + i10];
    }

    public final int zzd() {
        return this.f7076c;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f7078a, this.f7075b, bArr, 0, i12);
    }
}
