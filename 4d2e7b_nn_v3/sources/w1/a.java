package w1;

import android.content.Context;
import g1.n;

public abstract class a {
    public static void a(Context context, boolean z10) {
        if (context == null) {
            p1.a.D(z10);
        } else if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            p1.a.D(z10);
        }
    }

    public static String b(Context context) {
        if (context == null) {
            s1.a.b("MTCorePrivatesApi", "getRegistrationId context can't be null, please check it");
            return "";
        } else if (p1.a.z(context.getApplicationContext())) {
            return x1.a.g(context);
        } else {
            if (p1.a.A(context.getApplicationContext())) {
                return n.y(context.getApplicationContext());
            }
            return "";
        }
    }
}
