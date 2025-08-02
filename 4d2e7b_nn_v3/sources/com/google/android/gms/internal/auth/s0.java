package com.google.android.gms.internal.auth;

final class s0 extends u0 {

    /* renamed from: b  reason: collision with root package name */
    private final int f6992b;

    s0(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzee.zzi(0, i11, bArr.length);
        this.f6992b = i11;
    }

    /* access modifiers changed from: protected */
    public final int a() {
        return 0;
    }

    public final byte zza(int i10) {
        int i11 = this.f6992b;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.f7002a[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i10) {
        return this.f7002a[i10];
    }

    public final int zzd() {
        return this.f6992b;
    }
}
