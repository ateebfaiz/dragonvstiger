package com.google.android.gms.internal.auth;

final class u1 implements k1 {

    /* renamed from: a  reason: collision with root package name */
    private final zzfw f7003a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7004b = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a";

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f7005c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7006d;

    u1(zzfw zzfw, String str, Object[] objArr) {
        this.f7003a = zzfw;
        this.f7005c = objArr;
        char charAt = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(0);
        if (charAt < 55296) {
            this.f7006d = charAt;
            return;
        }
        char c10 = charAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char charAt2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(i11);
            if (charAt2 >= 55296) {
                c10 |= (charAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            } else {
                this.f7006d = (charAt2 << i10) | c10;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f7004b;
    }

    /* access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f7005c;
    }

    public final zzfw zza() {
        return this.f7003a;
    }

    public final boolean zzb() {
        return (this.f7006d & 2) == 2;
    }

    public final int zzc() {
        return (this.f7006d & 1) == 1 ? 1 : 2;
    }
}
