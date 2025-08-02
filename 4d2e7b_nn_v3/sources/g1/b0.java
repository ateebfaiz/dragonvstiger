package g1;

import androidx.work.WorkRequest;
import java.util.concurrent.ConcurrentLinkedQueue;
import s1.a;
import z1.a;

public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue f21574a = new ConcurrentLinkedQueue();

    public int a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f21574a.size() < 10) {
            f21574a.offer(Long.valueOf(currentTimeMillis));
            return 0;
        }
        long longValue = currentTimeMillis - ((Long) f21574a.element()).longValue();
        if (longValue < 0) {
            f21574a.clear();
            a.h("MTOperationBusiness", "set tags/alias failed, time shaft error，please try again");
            return a.C0362a.f25005h;
        } else if (longValue > WorkRequest.MIN_BACKOFF_MILLIS) {
            while (f21574a.size() >= 10) {
                f21574a.poll();
            }
            f21574a.offer(Long.valueOf(currentTimeMillis));
            return 0;
        } else {
            s1.a.h("MTOperationBusiness", "set tags/alias too soon, over 10 times in 10s");
            return a.C0362a.f25005h;
        }
    }
}
