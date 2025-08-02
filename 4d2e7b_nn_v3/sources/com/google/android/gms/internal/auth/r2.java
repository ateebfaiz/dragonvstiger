package com.google.android.gms.internal.auth;

abstract class r2 {
    r2() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(int i10, byte[] bArr, int i11, int i12);

    /* access modifiers changed from: package-private */
    public final boolean b(byte[] bArr, int i10, int i11) {
        if (a(0, bArr, i10, i11) == 0) {
            return true;
        }
        return false;
    }
}
