package com.google.android.gms.internal.fido;

final class p0 extends zzdd {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7081a;

    /* renamed from: b  reason: collision with root package name */
    private int f7082b;

    /* renamed from: c  reason: collision with root package name */
    private int f7083c;

    /* renamed from: d  reason: collision with root package name */
    private int f7084d = Integer.MAX_VALUE;

    /* synthetic */ p0(byte[] bArr, int i10, int i11, boolean z10, zzda zzda) {
        super((zzdc) null);
        this.f7081a = bArr;
        this.f7082b = 0;
    }

    public final int a(int i10) {
        int i11 = this.f7084d;
        this.f7084d = 0;
        int i12 = this.f7082b + this.f7083c;
        this.f7082b = i12;
        if (i12 > 0) {
            this.f7083c = i12;
            this.f7082b = 0;
        } else {
            this.f7083c = 0;
        }
        return i11;
    }
}
