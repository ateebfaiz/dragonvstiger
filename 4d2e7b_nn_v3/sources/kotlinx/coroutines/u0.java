package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import cc.c0;

public abstract class u0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f1195a = new c0("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f1196b = new c0("CLOSED_EMPTY");

    public static final long c(long j10) {
        return j10 / 1000000;
    }

    public static final long d(long j10) {
        if (j10 <= 0) {
            return 0;
        }
        return j10 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j10;
    }
}
