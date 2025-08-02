package kotlin.ranges;

import kotlin.collections.h0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qb.c;

public abstract class i implements Iterable<Long>, wb.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f752d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f753a;

    /* renamed from: b  reason: collision with root package name */
    private final long f754b;

    /* renamed from: c  reason: collision with root package name */
    private final long f755c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j12 != Long.MIN_VALUE) {
            this.f753a = j10;
            this.f754b = c.d(j10, j11, j12);
            this.f755c = j12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final long a() {
        return this.f753a;
    }

    public final long c() {
        return this.f754b;
    }

    /* renamed from: d */
    public h0 iterator() {
        return new j(this.f753a, this.f754b, this.f755c);
    }
}
