package com.bugsnag.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.o;
import kotlin.p;

public final class j {

    /* renamed from: p  reason: collision with root package name */
    public static final a f18780p = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final long f18781q = SystemClock.elapsedRealtime();

    /* renamed from: a  reason: collision with root package name */
    private final PackageManager f18782a;

    /* renamed from: b  reason: collision with root package name */
    private final c1.j f18783b;

    /* renamed from: c  reason: collision with root package name */
    private final p3 f18784c;

    /* renamed from: d  reason: collision with root package name */
    private final ActivityManager f18785d;

    /* renamed from: e  reason: collision with root package name */
    private final q2 f18786e;

    /* renamed from: f  reason: collision with root package name */
    private final w2 f18787f;

    /* renamed from: g  reason: collision with root package name */
    private String f18788g;

    /* renamed from: h  reason: collision with root package name */
    private final String f18789h;

    /* renamed from: i  reason: collision with root package name */
    private final Boolean f18790i = j();

    /* renamed from: j  reason: collision with root package name */
    private String f18791j;

    /* renamed from: k  reason: collision with root package name */
    private final String f18792k = g();

    /* renamed from: l  reason: collision with root package name */
    private final String f18793l = c();

    /* renamed from: m  reason: collision with root package name */
    private final String f18794m;

    /* renamed from: n  reason: collision with root package name */
    private final String f18795n;

    /* renamed from: o  reason: collision with root package name */
    private final String f18796o;

    public static final class a {
        private a() {
        }

        public final long a() {
            return SystemClock.elapsedRealtime() - b();
        }

        public final long b() {
            return j.f18781q;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(Context context, PackageManager packageManager, c1.j jVar, p3 p3Var, ActivityManager activityManager, q2 q2Var, w2 w2Var) {
        this.f18782a = packageManager;
        this.f18783b = jVar;
        this.f18784c = p3Var;
        this.f18785d = activityManager;
        this.f18786e = q2Var;
        this.f18787f = w2Var;
        this.f18789h = context.getPackageName();
        this.f18794m = jVar.C();
        String d10 = jVar.d();
        if (d10 == null) {
            PackageInfo x10 = jVar.x();
            if (x10 == null) {
                d10 = null;
            } else {
                d10 = x10.versionName;
            }
        }
        this.f18795n = d10;
        this.f18796o = h();
    }

    private final String c() {
        Object obj;
        String str;
        String str2 = null;
        try {
            o.a aVar = o.f12592b;
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            } else {
                Object invoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", (Class[]) null).invoke((Object) null, (Object[]) null);
                if (invoke != null) {
                    str = (String) invoke;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            obj = o.b(str);
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            str2 = obj;
        }
        return str2;
    }

    private final String g() {
        ApplicationInfo b10 = this.f18783b.b();
        PackageManager packageManager = this.f18782a;
        if (packageManager == null || b10 == null) {
            return null;
        }
        return packageManager.getApplicationLabel(b10).toString();
    }

    private final String i() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.pid == 0) {
                return null;
            }
            int i10 = runningAppProcessInfo.importance;
            if (i10 == 1) {
                return "provider in use";
            }
            if (i10 == 2) {
                return "service in use";
            }
            switch (i10) {
                case 100:
                    return "foreground";
                case 125:
                    return "foreground service";
                case 130:
                case 230:
                    return "perceptible";
                case 150:
                case 325:
                    return "top sleeping";
                case 170:
                case 350:
                    return "can't save state";
                case 200:
                    return "visible";
                case 300:
                    return NotificationCompat.CATEGORY_SERVICE;
                case Constants.MINIMAL_ERROR_STATUS_CODE:
                    return "cached/background";
                case 500:
                    return "empty";
                case 1000:
                    return "gone";
                default:
                    return "unknown importance (" + runningAppProcessInfo.importance + ')';
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final Boolean j() {
        ActivityManager activityManager = this.f18785d;
        if (activityManager == null || Build.VERSION.SDK_INT < 28 || !activityManager.isBackgroundRestricted()) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final void k(Map map) {
        Runtime runtime = Runtime.getRuntime();
        long j10 = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        map.put("memoryUsage", Long.valueOf(j10 - freeMemory));
        map.put("totalMemory", Long.valueOf(j10));
        map.put("freeMemory", Long.valueOf(freeMemory));
        map.put("memoryLimit", Long.valueOf(runtime.maxMemory()));
        map.put("installerPackage", this.f18796o);
    }

    public final Long b(Boolean bool) {
        long j10;
        if (bool == null) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.f18784c.j();
        if (!bool.booleanValue() || j11 == 0) {
            j10 = 0;
        } else {
            j10 = elapsedRealtime - j11;
        }
        if (j10 > 0) {
            return Long.valueOf(j10);
        }
        return 0L;
    }

    public final f d() {
        return new f(this.f18783b, this.f18791j, this.f18789h, this.f18794m, this.f18795n, this.f18788g);
    }

    public final m e() {
        boolean k10 = this.f18784c.k();
        return new m(this.f18783b, this.f18791j, this.f18789h, this.f18794m, this.f18795n, this.f18788g, Long.valueOf(f18780p.a()), b(Boolean.valueOf(k10)), Boolean.valueOf(k10), Boolean.valueOf(this.f18786e.d()));
    }

    public final Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.f18792k);
        hashMap.put("activeScreen", this.f18784c.h());
        hashMap.put("lowMemory", Boolean.valueOf(this.f18787f.f()));
        hashMap.put("memoryTrimLevel", this.f18787f.e());
        hashMap.put("processImportance", i());
        k(hashMap);
        Boolean bool = this.f18790i;
        if (bool != null) {
            hashMap.put("backgroundWorkRestricted", bool);
        }
        String str = this.f18793l;
        if (str != null) {
            hashMap.put("processName", str);
        }
        return hashMap;
    }

    public final String h() {
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                PackageManager packageManager = this.f18782a;
                if (packageManager == null) {
                    return null;
                }
                InstallSourceInfo a10 = packageManager.getInstallSourceInfo(this.f18789h);
                if (a10 == null) {
                    return null;
                }
                return a10.getInstallingPackageName();
            }
            PackageManager packageManager2 = this.f18782a;
            if (packageManager2 == null) {
                return null;
            }
            return packageManager2.getInstallerPackageName(this.f18789h);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void l(String str) {
        this.f18791j = str;
    }

    public final void m(String str) {
        this.f18788g = str;
    }
}
