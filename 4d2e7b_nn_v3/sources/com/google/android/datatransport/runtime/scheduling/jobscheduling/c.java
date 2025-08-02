package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

final class c extends SchedulerConfig.ConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final long f6504a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6505b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f6506c;

    static final class b extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f6507a;

        /* renamed from: b  reason: collision with root package name */
        private Long f6508b;

        /* renamed from: c  reason: collision with root package name */
        private Set f6509c;

        b() {
        }

        public SchedulerConfig.ConfigValue build() {
            String str = "";
            if (this.f6507a == null) {
                str = str + " delta";
            }
            if (this.f6508b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f6509c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f6507a.longValue(), this.f6508b.longValue(), this.f6509c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SchedulerConfig.ConfigValue.Builder setDelta(long j10) {
            this.f6507a = Long.valueOf(j10);
            return this;
        }

        public SchedulerConfig.ConfigValue.Builder setFlags(Set set) {
            if (set != null) {
                this.f6509c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j10) {
            this.f6508b = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.f6504a == configValue.getDelta() && this.f6505b == configValue.getMaxAllowedDelay() && this.f6506c.equals(configValue.getFlags())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long getDelta() {
        return this.f6504a;
    }

    /* access modifiers changed from: package-private */
    public Set getFlags() {
        return this.f6506c;
    }

    /* access modifiers changed from: package-private */
    public long getMaxAllowedDelay() {
        return this.f6505b;
    }

    public int hashCode() {
        long j10 = this.f6504a;
        long j11 = this.f6505b;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f6506c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f6504a + ", maxAllowedDelay=" + this.f6505b + ", flags=" + this.f6506c + "}";
    }

    private c(long j10, long j11, Set set) {
        this.f6504a = j10;
        this.f6505b = j11;
        this.f6506c = set;
    }
}
