package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class i {

    /* renamed from: a  reason: collision with root package name */
    final String f7537a;

    /* renamed from: b  reason: collision with root package name */
    final String f7538b;

    /* renamed from: c  reason: collision with root package name */
    final long f7539c;

    /* renamed from: d  reason: collision with root package name */
    final long f7540d;

    /* renamed from: e  reason: collision with root package name */
    final long f7541e;

    /* renamed from: f  reason: collision with root package name */
    final long f7542f;

    /* renamed from: g  reason: collision with root package name */
    final long f7543g;

    /* renamed from: h  reason: collision with root package name */
    final Long f7544h;

    /* renamed from: i  reason: collision with root package name */
    final Long f7545i;

    /* renamed from: j  reason: collision with root package name */
    final Long f7546j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f7547k;

    i(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        long j15 = j10;
        long j16 = j11;
        long j17 = j12;
        long j18 = j14;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z10 = false;
        Preconditions.checkArgument(j15 >= 0);
        Preconditions.checkArgument(j16 >= 0);
        Preconditions.checkArgument(j17 >= 0);
        Preconditions.checkArgument(j18 >= 0 ? true : z10);
        this.f7537a = str;
        this.f7538b = str2;
        this.f7539c = j15;
        this.f7540d = j16;
        this.f7541e = j17;
        this.f7542f = j13;
        this.f7543g = j18;
        this.f7544h = l10;
        this.f7545i = l11;
        this.f7546j = l12;
        this.f7547k = bool;
    }

    /* access modifiers changed from: package-private */
    public final i a(Long l10, Long l11, Boolean bool) {
        Boolean bool2;
        if (bool == null || bool.booleanValue()) {
            bool2 = bool;
        } else {
            bool2 = null;
        }
        return new i(this.f7537a, this.f7538b, this.f7539c, this.f7540d, this.f7541e, this.f7542f, this.f7543g, this.f7544h, l10, l11, bool2);
    }

    /* access modifiers changed from: package-private */
    public final i b(long j10, long j11) {
        return new i(this.f7537a, this.f7538b, this.f7539c, this.f7540d, this.f7541e, this.f7542f, j10, Long.valueOf(j11), this.f7545i, this.f7546j, this.f7547k);
    }

    /* access modifiers changed from: package-private */
    public final i c(long j10) {
        return new i(this.f7537a, this.f7538b, this.f7539c, this.f7540d, this.f7541e, j10, this.f7543g, this.f7544h, this.f7545i, this.f7546j, this.f7547k);
    }
}
