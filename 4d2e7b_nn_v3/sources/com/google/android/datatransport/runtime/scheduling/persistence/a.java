package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.c;

final class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private final long f6554b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6555c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6556d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6557e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6558f;

    static final class b extends c.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f6559a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f6560b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f6561c;

        /* renamed from: d  reason: collision with root package name */
        private Long f6562d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f6563e;

        b() {
        }

        /* access modifiers changed from: package-private */
        public c a() {
            String str = "";
            if (this.f6559a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f6560b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f6561c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f6562d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f6563e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f6559a.longValue(), this.f6560b.intValue(), this.f6561c.intValue(), this.f6562d.longValue(), this.f6563e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public c.a b(int i10) {
            this.f6561c = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public c.a c(long j10) {
            this.f6562d = Long.valueOf(j10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public c.a d(int i10) {
            this.f6560b = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public c.a e(int i10) {
            this.f6563e = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public c.a f(long j10) {
            this.f6559a = Long.valueOf(j10);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f6556d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f6557e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f6555c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f6558f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f6554b == cVar.f() && this.f6555c == cVar.d() && this.f6556d == cVar.b() && this.f6557e == cVar.c() && this.f6558f == cVar.e()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f6554b;
    }

    public int hashCode() {
        long j10 = this.f6554b;
        long j11 = this.f6557e;
        return ((((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f6555c) * 1000003) ^ this.f6556d) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f6558f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f6554b + ", loadBatchSize=" + this.f6555c + ", criticalSectionEnterTimeoutMs=" + this.f6556d + ", eventCleanUpAge=" + this.f6557e + ", maxBlobByteSizePerRow=" + this.f6558f + "}";
    }

    private a(long j10, int i10, int i11, long j11, int i12) {
        this.f6554b = j10;
        this.f6555c = i10;
        this.f6556d = i11;
        this.f6557e = j11;
        this.f6558f = i12;
    }
}
