package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import c1.a;
import c1.s;
import com.bugsnag.android.g1;
import com.google.firebase.analytics.FirebaseAnalytics;
import d1.d;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.i0;
import kotlin.o;
import kotlin.p;
import kotlin.text.j;

public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final g0 f18626a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18627b;

    /* renamed from: c  reason: collision with root package name */
    private final d f18628c;

    /* renamed from: d  reason: collision with root package name */
    private final x0 f18629d;

    /* renamed from: e  reason: collision with root package name */
    private final File f18630e;

    /* renamed from: f  reason: collision with root package name */
    private final d f18631f;

    /* renamed from: g  reason: collision with root package name */
    private final a f18632g;

    /* renamed from: h  reason: collision with root package name */
    private final s2 f18633h;

    /* renamed from: i  reason: collision with root package name */
    private final DisplayMetrics f18634i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f18635j = s();

    /* renamed from: k  reason: collision with root package name */
    private final Float f18636k = p();

    /* renamed from: l  reason: collision with root package name */
    private final Integer f18637l = q();

    /* renamed from: m  reason: collision with root package name */
    private final String f18638m = r();

    /* renamed from: n  reason: collision with root package name */
    private final String f18639n = Locale.getDefault().toString();

    /* renamed from: o  reason: collision with root package name */
    private final String[] f18640o = k();

    /* renamed from: p  reason: collision with root package name */
    private Map f18641p;

    /* renamed from: q  reason: collision with root package name */
    private final Future f18642q = v();

    /* renamed from: r  reason: collision with root package name */
    private AtomicInteger f18643r;

    public b1(g0 g0Var, Context context, Resources resources, d dVar, x0 x0Var, File file, d dVar2, a aVar, s2 s2Var) {
        this.f18626a = g0Var;
        this.f18627b = context;
        this.f18628c = dVar;
        this.f18629d = x0Var;
        this.f18630e = file;
        this.f18631f = dVar2;
        this.f18632g = aVar;
        this.f18633h = s2Var;
        this.f18634i = resources.getDisplayMetrics();
        this.f18643r = new AtomicInteger(resources.getConfiguration().orientation);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer a10 = x0Var.a();
        if (a10 != null) {
            linkedHashMap.put("androidApiLevel", Integer.valueOf(a10.intValue()));
        }
        String g10 = x0Var.g();
        if (g10 != null) {
            linkedHashMap.put("osBuild", g10);
        }
        this.f18641p = linkedHashMap;
    }

    /* access modifiers changed from: private */
    public static final Long e(b1 b1Var) {
        return Long.valueOf(b1Var.f18630e.getUsableSpace());
    }

    private final Long g() {
        Long l10;
        Object obj;
        ActivityManager a10 = l0.a(this.f18627b);
        Long l11 = null;
        if (a10 == null) {
            l10 = null;
        } else {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            a10.getMemoryInfo(memoryInfo);
            l10 = Long.valueOf(memoryInfo.totalMem);
        }
        if (l10 != null) {
            return l10;
        }
        try {
            o.a aVar = o.f12592b;
            obj = o.b((Long) Process.class.getDeclaredMethod("getTotalMemory", (Class[]) null).invoke((Object) null, (Object[]) null));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            l11 = obj;
        }
        return l11;
    }

    private final boolean h() {
        try {
            d dVar = this.f18631f;
            if (dVar == null || !((Boolean) dVar.get()).booleanValue()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String m() {
        try {
            if (t()) {
                return "allowed";
            }
            return "disallowed";
        } catch (Exception unused) {
            this.f18633h.g("Could not get locationStatus");
            return null;
        }
    }

    private final String n() {
        return this.f18626a.c();
    }

    private final Float p() {
        DisplayMetrics displayMetrics = this.f18634i;
        if (displayMetrics == null) {
            return null;
        }
        return Float.valueOf(displayMetrics.density);
    }

    private final Integer q() {
        DisplayMetrics displayMetrics = this.f18634i;
        if (displayMetrics == null) {
            return null;
        }
        return Integer.valueOf(displayMetrics.densityDpi);
    }

    private final String r() {
        DisplayMetrics displayMetrics = this.f18634i;
        if (displayMetrics == null) {
            return null;
        }
        int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        DisplayMetrics displayMetrics2 = this.f18634i;
        int min = Math.min(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(max);
        sb2.append('x');
        sb2.append(min);
        return sb2.toString();
    }

    private final boolean s() {
        String d10 = this.f18629d.d();
        if (d10 == null) {
            return false;
        }
        if (j.F(d10, "unknown", false, 2, (Object) null) || j.K(d10, "generic", false, 2, (Object) null) || j.K(d10, "vbox", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    private final boolean t() {
        if (Build.VERSION.SDK_INT >= 31) {
            LocationManager c10 = l0.c(this.f18627b);
            if (c10 != null && c10.isLocationEnabled()) {
                return true;
            }
        } else {
            String string = Settings.Secure.getString(this.f18627b.getContentResolver(), "location_providers_allowed");
            if (string != null && string.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final void u(Map map) {
        boolean z10;
        try {
            Intent e10 = l0.e(this.f18627b, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), this.f18633h);
            if (e10 != null) {
                int intExtra = e10.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra2 = e10.getIntExtra("scale", -1);
                if (!(intExtra == -1 && intExtra2 == -1)) {
                    map.put("batteryLevel", Float.valueOf(((float) intExtra) / ((float) intExtra2)));
                }
                int intExtra3 = e10.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                if (intExtra3 != 2) {
                    if (intExtra3 != 5) {
                        z10 = false;
                        map.put("charging", Boolean.valueOf(z10));
                    }
                }
                z10 = true;
                map.put("charging", Boolean.valueOf(z10));
            }
        } catch (Exception unused) {
            this.f18633h.g("Could not get battery status");
        }
    }

    private final Future v() {
        try {
            return this.f18632g.e(s.DEFAULT, new z0(this));
        } catch (RejectedExecutionException e10) {
            this.f18633h.c("Failed to lookup available device memory", e10);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final Long w(b1 b1Var) {
        return b1Var.g();
    }

    public final void c(String str, String str2) {
        Map r10 = i0.r(this.f18641p);
        r10.put(str, str2);
        this.f18641p = r10;
    }

    public final long d() {
        Long l10;
        try {
            o.a aVar = o.f12592b;
            l10 = o.b((Long) this.f18632g.e(s.IO, new a1(this)).get());
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            l10 = o.b(p.a(th));
        }
        if (o.f(l10)) {
            l10 = 0L;
        }
        return ((Number) l10).longValue();
    }

    public final Long f() {
        Long l10;
        try {
            ActivityManager a10 = l0.a(this.f18627b);
            if (a10 == null) {
                l10 = null;
            } else {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                a10.getMemoryInfo(memoryInfo);
                l10 = Long.valueOf(memoryInfo.availMem);
            }
            if (l10 != null) {
                return l10;
            }
            return (Long) Process.class.getDeclaredMethod("getFreeMemory", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final w0 i() {
        String str;
        Object obj;
        Long l10;
        x0 x0Var = this.f18629d;
        String[] strArr = this.f18640o;
        Boolean valueOf = Boolean.valueOf(h());
        g1.c cVar = (g1.c) this.f18628c.get();
        Long l11 = null;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.a();
        }
        String str2 = this.f18639n;
        Future future = this.f18642q;
        try {
            o.a aVar = o.f12592b;
            if (future == null) {
                l10 = null;
            } else {
                l10 = (Long) future.get();
            }
            obj = o.b(l10);
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            l11 = obj;
        }
        return new w0(x0Var, strArr, valueOf, str, str2, l11, i0.r(this.f18641p));
    }

    public final i1 j(long j10) {
        String str;
        Object obj;
        Long l10;
        x0 x0Var = this.f18629d;
        Boolean valueOf = Boolean.valueOf(h());
        g1.c cVar = (g1.c) this.f18628c.get();
        Long l11 = null;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.a();
        }
        String str2 = this.f18639n;
        Future future = this.f18642q;
        try {
            o.a aVar = o.f12592b;
            if (future == null) {
                l10 = null;
            } else {
                l10 = (Long) future.get();
            }
            obj = o.b(l10);
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            l11 = obj;
        }
        return new i1(x0Var, valueOf, str, str2, l11, i0.r(this.f18641p), Long.valueOf(d()), f(), o(), new Date(j10));
    }

    public final String[] k() {
        String[] c10 = this.f18629d.c();
        if (c10 == null) {
            return new String[0];
        }
        return c10;
    }

    public final Map l() {
        HashMap hashMap = new HashMap();
        u(hashMap);
        hashMap.put("locationStatus", m());
        hashMap.put("networkAccess", n());
        hashMap.put("brand", this.f18629d.b());
        hashMap.put("screenDensity", this.f18636k);
        hashMap.put("dpi", this.f18637l);
        hashMap.put("emulator", Boolean.valueOf(this.f18635j));
        hashMap.put("screenResolution", this.f18638m);
        return hashMap;
    }

    public final String o() {
        int i10 = this.f18643r.get();
        if (i10 == 1) {
            return "portrait";
        }
        if (i10 != 2) {
            return null;
        }
        return "landscape";
    }

    public final boolean x(int i10) {
        if (this.f18643r.getAndSet(i10) != i10) {
            return true;
        }
        return false;
    }
}
