package f3;

import java.util.concurrent.TimeUnit;

public abstract /* synthetic */ class b {
    public static long a(c cVar) {
        return TimeUnit.NANOSECONDS.toMillis(cVar.nowNanos());
    }
}
