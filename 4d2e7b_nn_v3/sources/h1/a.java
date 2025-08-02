package h1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import q1.c;
import t1.b;

public abstract class a {
    public static void a(Context context, String str, int i10) {
        c.c().b(context, str, i10);
    }

    public static void b(Context context, boolean z10) {
        boolean z11;
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't init with empty context");
        } else if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            p1.a.f23053b = context.getApplicationContext();
            if (z10 || p1.a.f23054c) {
                z11 = true;
            } else {
                z11 = false;
            }
            p1.a.f23054c = z11;
            if (p1.a.z(context.getApplicationContext())) {
                g(context, g1.a.f21571a, 1000, (Bundle) null);
            }
        }
    }

    public static void c(Context context, b bVar) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't observer with empty context");
        } else if (!p1.a.z(context.getApplicationContext())) {
            s1.a.b("MTCommonPrivatesApi", "can't observer in another process");
        } else {
            t1.a.b().d(context.getApplicationContext(), bVar);
        }
    }

    public static void d(Context context, String str, Runnable runnable, long j10) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't postMessageDelayed with empty context");
        } else if (TextUtils.isEmpty(str)) {
            s1.a.b("MTCommonPrivatesApi", "can't postMessageDelayed with empty name");
        } else if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            c.c().d(context, str, runnable, j10);
        } else {
            s1.a.b("MTCommonPrivatesApi", "can't postMessageDelayed in another process");
        }
    }

    public static void e(Context context, String str) {
        c.c().e(context, str);
    }

    public static void f(Context context, String str, int i10) {
        c.c().f(context, str, i10);
    }

    public static void g(Context context, String str, int i10, Bundle bundle) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessage with empty context");
        } else if (TextUtils.isEmpty(str)) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessage with empty name");
        } else if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            c.c().g(context, str, i10, bundle);
        } else {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessage in another process");
        }
    }

    public static void h(Context context, String str, int i10, Bundle bundle, long j10) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessageDelayed with empty context");
        } else if (TextUtils.isEmpty(str)) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessageDelayed with empty name");
        } else if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            c.c().h(context, str, i10, bundle, j10);
        } else {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessageDelayed in another process");
        }
    }

    public static void i(Context context, int i10, Bundle bundle) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessageToMainProcess with empty context");
        } else {
            i1.a.b().i(context.getApplicationContext(), i10, bundle);
        }
    }

    public static void j(Context context, int i10, Bundle bundle) {
        if (context == null) {
            s1.a.b("MTCommonPrivatesApi", "can't sendMessageToRemoteProcess with empty context");
        } else {
            i1.a.b().j(context.getApplicationContext(), i10, bundle);
        }
    }
}
