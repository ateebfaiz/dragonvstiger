package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import java.util.List;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private String f6831a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f6832b = -1;

    /* renamed from: c  reason: collision with root package name */
    private zzag f6833c = zzag.zzl();

    /* renamed from: d  reason: collision with root package name */
    private zzag f6834d = zzag.zzl();

    t() {
    }

    /* access modifiers changed from: package-private */
    public final t a(long j10) {
        this.f6832b = j10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final t b(List list) {
        Preconditions.checkNotNull(list);
        this.f6834d = zzag.zzk(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final t c(List list) {
        Preconditions.checkNotNull(list);
        this.f6833c = zzag.zzk(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final t d(String str) {
        this.f6831a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final d e() {
        if (this.f6831a == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.f6832b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.f6833c.isEmpty() || !this.f6834d.isEmpty()) {
            return new d(this.f6831a, this.f6832b, this.f6833c, this.f6834d, (zzaa) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
