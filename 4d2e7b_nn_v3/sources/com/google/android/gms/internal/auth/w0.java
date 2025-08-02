package com.google.android.gms.internal.auth;

final class w0 extends zzei {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7009a;

    /* renamed from: b  reason: collision with root package name */
    private int f7010b;

    /* renamed from: c  reason: collision with root package name */
    private int f7011c;

    /* renamed from: d  reason: collision with root package name */
    private int f7012d = Integer.MAX_VALUE;

    /* synthetic */ w0(byte[] bArr, int i10, int i11, boolean z10, zzef zzef) {
        super((zzeh) null);
        this.f7009a = bArr;
        this.f7010b = 0;
    }

    public final int a(int i10) {
        int i11 = this.f7012d;
        this.f7012d = 0;
        int i12 = this.f7010b + this.f7011c;
        this.f7010b = i12;
        if (i12 > 0) {
            this.f7011c = i12;
            this.f7010b = 0;
        } else {
            this.f7011c = 0;
        }
        return i11;
    }
}
