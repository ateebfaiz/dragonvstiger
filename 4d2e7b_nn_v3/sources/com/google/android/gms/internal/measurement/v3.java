package com.google.android.gms.internal.measurement;

final class v3 implements l3 {

    /* renamed from: a  reason: collision with root package name */
    private final zzlm f7336a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7337b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f7338c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7339d;

    v3(zzlm zzlm, String str, Object[] objArr) {
        this.f7336a = zzlm;
        this.f7337b = str;
        this.f7338c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f7339d = charAt;
            return;
        }
        char c10 = charAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 >= 55296) {
                c10 |= (charAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            } else {
                this.f7339d = c10 | (charAt2 << i10);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f7337b;
    }

    /* access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f7338c;
    }

    public final zzlm zza() {
        return this.f7336a;
    }

    public final boolean zzb() {
        return (this.f7339d & 2) == 2;
    }

    public final int zzc() {
        return (this.f7339d & 1) == 1 ? 1 : 2;
    }
}
