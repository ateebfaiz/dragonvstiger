package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class r3 {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f7696a;

    /* renamed from: b  reason: collision with root package name */
    private long f7697b;

    public r3(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f7696a = clock;
    }

    public final void a() {
        this.f7697b = 0;
    }

    public final void b() {
        this.f7697b = this.f7696a.elapsedRealtime();
    }

    public final boolean c(long j10) {
        if (this.f7697b != 0 && this.f7696a.elapsedRealtime() - this.f7697b < 3600000) {
            return false;
        }
        return true;
    }
}
