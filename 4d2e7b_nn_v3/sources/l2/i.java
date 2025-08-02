package l2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.work.PeriodicWorkRequest;
import com.facebook.AccessToken;
import com.facebook.w;
import e2.g;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import q5.d0;
import v5.a;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22442a = i.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static final long[] f22443b = {PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    /* renamed from: c  reason: collision with root package name */
    public static final i f22444c = new i();

    private i() {
    }

    public static final int b(long j10) {
        Class<i> cls = i.class;
        if (a.d(cls)) {
            return 0;
        }
        int i10 = 0;
        while (true) {
            try {
                long[] jArr = f22443b;
                if (i10 >= jArr.length || jArr[i10] >= j10) {
                    return i10;
                }
                i10++;
            } catch (Throwable th) {
                a.b(th, cls);
                return 0;
            }
        }
        return i10;
    }

    public static final void c(String str, j jVar, String str2, Context context) {
        String str3;
        Class<i> cls = i.class;
        if (!a.d(cls)) {
            try {
                m.f(str, "activityName");
                m.f(context, "context");
                if (jVar == null || (str3 = jVar.toString()) == null) {
                    str3 = "Unclassified";
                }
                Bundle bundle = new Bundle();
                bundle.putString("fb_mobile_launch_source", str3);
                bundle.putString("fb_mobile_pckg_fp", f22444c.a(context));
                bundle.putString("fb_mobile_app_cert_hash", z5.a.a(context));
                e2.m mVar = new e2.m(str, str2, (AccessToken) null);
                mVar.d("fb_mobile_activate_app", bundle);
                if (e2.m.f21204b.b() != g.b.EXPLICIT_ONLY) {
                    mVar.a();
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    private final void d() {
        if (!a.d(this)) {
            try {
                d0.a aVar = d0.f23283f;
                w wVar = w.APP_EVENTS;
                String str = f22442a;
                m.c(str);
                aVar.b(wVar, str, "Clock skew detected");
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    public static final void e(String str, h hVar, String str2) {
        long j10;
        String str3;
        long j11;
        Class<i> cls = i.class;
        if (!a.d(cls)) {
            try {
                m.f(str, "activityName");
                if (hVar != null) {
                    Long b10 = hVar.b();
                    long j12 = 0;
                    if (b10 != null) {
                        j10 = b10.longValue();
                    } else {
                        Long e10 = hVar.e();
                        if (e10 != null) {
                            j11 = e10.longValue();
                        } else {
                            j11 = 0;
                        }
                        j10 = 0 - j11;
                    }
                    if (j10 < 0) {
                        f22444c.d();
                        j10 = 0;
                    }
                    long f10 = hVar.f();
                    if (f10 < 0) {
                        f22444c.d();
                        f10 = 0;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("fb_mobile_app_interruptions", hVar.c());
                    b0 b0Var = b0.f709a;
                    String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(b(j10))}, 1));
                    m.e(format, "java.lang.String.format(locale, format, *args)");
                    bundle.putString("fb_mobile_time_between_sessions", format);
                    j g10 = hVar.g();
                    if (g10 == null || (str3 = g10.toString()) == null) {
                        str3 = "Unclassified";
                    }
                    bundle.putString("fb_mobile_launch_source", str3);
                    Long e11 = hVar.e();
                    if (e11 != null) {
                        j12 = e11.longValue();
                    }
                    bundle.putLong("_logTime", j12 / ((long) 1000));
                    new e2.m(str, str2, (AccessToken) null).c("fb_mobile_deactivate_app", ((double) f10) / ((double) 1000), bundle);
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public final String a(Context context) {
        if (a.d(this)) {
            return null;
        }
        try {
            m.f(context, "context");
            try {
                PackageManager packageManager = context.getPackageManager();
                String str = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                String string = sharedPreferences.getString(str, (String) null);
                if (string != null && string.length() == 32) {
                    return string;
                }
                String c10 = g.c(context, (Long) null);
                if (c10 == null) {
                    c10 = g.b(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
                }
                sharedPreferences.edit().putString(str, c10).apply();
                return c10;
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }
}
