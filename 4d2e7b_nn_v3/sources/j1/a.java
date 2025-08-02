package j1;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.pdns.DNSResolver;
import java.util.Iterator;
import t1.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f22138a;

    public static a a() {
        if (f22138a == null) {
            synchronized (a.class) {
                f22138a = new a();
            }
        }
        return f22138a;
    }

    public void b(Context context) {
        Iterator it = t1.a.b().f24069b.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("observer_name", (String) it.next());
            i1.a.b().j(context, DNSResolver.GOBACK_LOCAL, bundle);
        }
        try {
            Object newInstance = Class.forName("com.engagelab.privates.collect.MTCollect").newInstance();
            if (newInstance instanceof b) {
                h1.a.c(context.getApplicationContext(), (b) newInstance);
            }
        } catch (Throwable unused) {
        }
        try {
            Object newInstance2 = Class.forName("com.engagelab.privates.geofence.MTGeofence").newInstance();
            if (newInstance2 instanceof b) {
                h1.a.c(context.getApplicationContext(), (b) newInstance2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Object newInstance3 = Class.forName("cn.jiguang.privates.wake.MTWake").newInstance();
            if (newInstance3 instanceof b) {
                h1.a.c(context.getApplicationContext(), (b) newInstance3);
            }
        } catch (Throwable unused3) {
        }
    }
}
