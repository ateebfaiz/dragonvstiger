package x4;

import android.app.ActivityManager;
import java.util.concurrent.TimeUnit;

public class o implements y2.o {

    /* renamed from: b  reason: collision with root package name */
    private static final long f24808b = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    private final ActivityManager f24809a;

    public o(ActivityManager activityManager) {
        this.f24809a = activityManager;
    }

    private int b() {
        int min = Math.min(this.f24809a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return 6291456;
        }
        return min / 4;
    }

    /* renamed from: a */
    public y get() {
        return new y(b(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, f24808b);
    }
}
