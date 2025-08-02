package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

final class b extends SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f6502a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f6503b;

    b(Clock clock, Map map) {
        if (clock != null) {
            this.f6502a = clock;
            if (map != null) {
                this.f6503b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.f6502a.equals(schedulerConfig.getClock()) || !this.f6503b.equals(schedulerConfig.getValues())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Clock getClock() {
        return this.f6502a;
    }

    /* access modifiers changed from: package-private */
    public Map getValues() {
        return this.f6503b;
    }

    public int hashCode() {
        return ((this.f6502a.hashCode() ^ 1000003) * 1000003) ^ this.f6503b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f6502a + ", values=" + this.f6503b + "}";
    }
}
