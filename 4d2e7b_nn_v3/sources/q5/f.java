package q5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.facebook.o;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import v5.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f23300a = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    /* renamed from: b  reason: collision with root package name */
    public static final f f23301b = new f();

    private f() {
    }

    public static final String a() {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            Context f10 = o.f();
            List<ResolveInfo> queryIntentServices = f10.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices != null) {
                HashSet V = j.V(f23300a);
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null && V.contains(serviceInfo.packageName)) {
                        return serviceInfo.packageName;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final String b() {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            return "fbconnect://cct." + o.f().getPackageName();
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final String c(String str) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "developerDefinedRedirectURI");
            if (q0.e(o.f(), str)) {
                return str;
            }
            if (q0.e(o.f(), b())) {
                return b();
            }
            return "";
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }
}
