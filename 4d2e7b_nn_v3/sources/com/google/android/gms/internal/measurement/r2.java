package com.google.android.gms.internal.measurement;

final class r2 extends zzji {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7288a;

    /* renamed from: b  reason: collision with root package name */
    private int f7289b;

    /* renamed from: c  reason: collision with root package name */
    private int f7290c;

    /* renamed from: d  reason: collision with root package name */
    private int f7291d = Integer.MAX_VALUE;

    /* synthetic */ r2(byte[] bArr, int i10, int i11, boolean z10, zzjf zzjf) {
        super((zzjh) null);
        this.f7288a = bArr;
        this.f7289b = 0;
    }

    public final int a(int i10) {
        int i11 = this.f7291d;
        this.f7291d = 0;
        int i12 = this.f7289b + this.f7290c;
        this.f7289b = i12;
        if (i12 > 0) {
            this.f7290c = i12;
            this.f7289b = 0;
        } else {
            this.f7290c = 0;
        }
        return i11;
    }
}
