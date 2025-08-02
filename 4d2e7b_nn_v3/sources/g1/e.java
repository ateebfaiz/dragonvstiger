package g1;

import android.content.Context;
import android.os.Bundle;
import x1.a;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f21580c;

    /* renamed from: a  reason: collision with root package name */
    public long f21581a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f21582b = 0;

    public static e a() {
        if (f21580c == null) {
            synchronized (e.class) {
                f21580c = new e();
            }
        }
        return f21580c;
    }

    public void b(Context context) {
        if (n.p(context)) {
            this.f21582b = System.currentTimeMillis();
        }
    }

    public void c(Context context) {
        if (n.p(context) && this.f21582b != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f21581a = currentTimeMillis;
            if (currentTimeMillis - this.f21582b >= a.c() / 2) {
                if (!f.a().f()) {
                    s1.a.a("MTActiveBusiness", "re connect");
                    h1.a.j(context, 2993, (Bundle) null);
                    h1.a.j(context, 2994, (Bundle) null);
                    return;
                }
                s1.a.a("MTActiveBusiness", "re heartbeat");
                f.a().k(context);
                f.a().i(context);
            }
        }
    }
}
