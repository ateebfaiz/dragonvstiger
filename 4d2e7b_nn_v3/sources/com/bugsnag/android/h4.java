package com.bugsnag.android;

import com.bugsnag.android.k2;
import g0.c;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.m;

public final class h4 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private final UUID f18756a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18757b;

    public h4(UUID uuid, long j10) {
        this.f18756a = uuid;
        this.f18757b = j10;
    }

    private final String a(long j10) {
        String format = String.format("%016x", Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
        m.e(format, "format(this, *args)");
        return format;
    }

    private final String b(UUID uuid) {
        String format = String.format("%016x%016x", Arrays.copyOf(new Object[]{Long.valueOf(uuid.getMostSignificantBits()), Long.valueOf(uuid.getLeastSignificantBits())}, 2));
        m.e(format, "format(this, *args)");
        return format;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h4)) {
            return false;
        }
        h4 h4Var = (h4) obj;
        return m.b(this.f18756a, h4Var.f18756a) && this.f18757b == h4Var.f18757b;
    }

    public int hashCode() {
        return (this.f18756a.hashCode() * 31) + c.a(this.f18757b);
    }

    public void toStream(k2 k2Var) {
        k2Var.j().v("traceId").K(b(this.f18756a)).v("spanId").K(a(this.f18757b));
        k2Var.n();
    }

    public String toString() {
        return "TraceCorrelation(traceId=" + this.f18756a + ", spanId=" + this.f18757b + ')';
    }
}
