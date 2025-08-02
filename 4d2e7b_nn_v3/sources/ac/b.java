package ac;

import java.util.concurrent.TimeUnit;
import pb.a;

public enum b {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: a  reason: collision with root package name */
    private final TimeUnit f14a;

    static {
        b[] a10;
        f13j = a.a(a10);
    }

    private b(TimeUnit timeUnit) {
        this.f14a = timeUnit;
    }

    public final TimeUnit b() {
        return this.f14a;
    }
}
