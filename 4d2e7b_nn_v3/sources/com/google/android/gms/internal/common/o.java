package com.google.android.gms.internal.common;

abstract class o extends f {

    /* renamed from: c  reason: collision with root package name */
    final CharSequence f7043c;

    /* renamed from: d  reason: collision with root package name */
    final zzo f7044d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f7045e;

    /* renamed from: f  reason: collision with root package name */
    int f7046f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f7047g;

    protected o(zzx zzx, CharSequence charSequence) {
        this.f7044d = zzx.zza;
        this.f7045e = zzx.zzb;
        this.f7047g = Integer.MAX_VALUE;
        this.f7043c = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object a() {
        int d10;
        int i10;
        int i11 = this.f7046f;
        while (true) {
            int i12 = this.f7046f;
            if (i12 != -1) {
                d10 = d(i12);
                if (d10 == -1) {
                    d10 = this.f7043c.length();
                    this.f7046f = -1;
                    i10 = -1;
                } else {
                    i10 = c(d10);
                    this.f7046f = i10;
                }
                if (i10 == i11) {
                    int i13 = i10 + 1;
                    this.f7046f = i13;
                    if (i13 > this.f7043c.length()) {
                        this.f7046f = -1;
                    }
                } else {
                    if (i11 < d10) {
                        this.f7043c.charAt(i11);
                    }
                    if (i11 < d10) {
                        this.f7043c.charAt(d10 - 1);
                    }
                    if (!this.f7045e || i11 != d10) {
                        int i14 = this.f7047g;
                    } else {
                        i11 = this.f7046f;
                    }
                }
            } else {
                b();
                return null;
            }
        }
        int i142 = this.f7047g;
        if (i142 == 1) {
            d10 = this.f7043c.length();
            this.f7046f = -1;
            if (d10 > i11) {
                this.f7043c.charAt(d10 - 1);
            }
        } else {
            this.f7047g = i142 - 1;
        }
        return this.f7043c.subSequence(i11, d10).toString();
    }

    /* access modifiers changed from: package-private */
    public abstract int c(int i10);

    /* access modifiers changed from: package-private */
    public abstract int d(int i10);
}
