package g;

import androidx.work.PeriodicWorkRequest;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public long f21569a = 0;

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f21569a = currentTimeMillis;
        if (currentTimeMillis - this.f21569a >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            return true;
        }
        return false;
    }
}
