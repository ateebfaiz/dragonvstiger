package k1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.engagelab.privates.common.component.MTCommonService;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static volatile a f22268e;

    /* renamed from: a  reason: collision with root package name */
    private b f22269a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22270b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f22271c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22272d = false;

    public static a a() {
        if (f22268e == null) {
            synchronized (a.class) {
                f22268e = new a();
            }
        }
        return f22268e;
    }

    private void f(Context context) {
        if (Build.VERSION.SDK_INT >= 26 && !this.f22272d && p1.a.f23054c) {
            this.f22272d = true;
            MTCommonService h10 = p1.a.h(context);
            if (h10 != null) {
                Intent intent = new Intent();
                intent.setClass(context, h10.getClass());
                context.startService(intent);
            }
        }
    }

    public void b(Context context) {
        if (!this.f22270b) {
            this.f22270b = true;
            b bVar = new b();
            this.f22269a = bVar;
            ((Application) context).registerActivityLifecycleCallbacks(bVar);
        }
    }

    public void c(Context context, Bundle bundle) {
        p1.a.C(bundle.getString("activity"));
    }

    public void d(Context context, Bundle bundle) {
        boolean z10 = bundle.getBoolean("state");
        p1.a.E(z10);
        if (z10) {
            if (this.f22271c == 0) {
                f(context);
                s1.a.a("MTLifecycleBusiness", "toForeground currentActivity:" + p1.a.k());
                h1.a.i(context, 1005, bundle);
                if (p1.a.f23054c) {
                    h1.a.j(context, 1995, bundle);
                }
            }
            this.f22271c++;
            return;
        }
        int i10 = this.f22271c;
        if (i10 > 0) {
            this.f22271c = i10 - 1;
        }
        if (this.f22271c == 0) {
            s1.a.a("MTLifecycleBusiness", "toBackground currentActivity:" + p1.a.k());
            h1.a.i(context, 1006, bundle);
            if (p1.a.f23054c) {
                h1.a.j(context, 1994, bundle);
            }
        }
    }

    public void e(Context context, Bundle bundle) {
        String str;
        if (bundle != null) {
            String string = bundle.getString("activity");
            boolean z10 = bundle.getBoolean("state");
            p1.a.C(string);
            p1.a.E(z10);
            StringBuilder sb2 = new StringBuilder();
            if (p1.a.p()) {
                str = "toForeground";
            } else {
                str = "toBackground";
            }
            sb2.append(str);
            sb2.append(" currentActivity:");
            sb2.append(p1.a.k());
            s1.a.a("MTLifecycleBusiness", sb2.toString());
        }
    }
}
