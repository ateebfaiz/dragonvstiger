package com.google.android.gms.internal.measurement;

final class n2 extends p2 {

    /* renamed from: b  reason: collision with root package name */
    private final int f7235b;

    n2(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzje.zzj(0, i11, bArr.length);
        this.f7235b = i11;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        return 0;
    }

    public final byte zza(int i10) {
        int i11 = this.f7235b;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.f7265a[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i10) {
        return this.f7265a[i10];
    }

    public final int zzd() {
        return this.f7235b;
    }
}
