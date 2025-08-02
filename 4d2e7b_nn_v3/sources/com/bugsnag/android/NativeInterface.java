package com.bugsnag.android;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c1.j;
import c1.p;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class NativeInterface {
    private static Charset UTF8Charset = Charset.defaultCharset();
    @SuppressLint({"StaticFieldLeak"})
    private static z client;

    class a implements h3 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Severity f18587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18588b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18589c;

        a(Severity severity, String str, String str2) {
            this.f18587a = severity;
            this.f18588b = str;
            this.f18589c = str2;
        }

        public boolean a(o1 o1Var) {
            o1Var.z(this.f18587a);
            List<k1> h10 = o1Var.h();
            k1 k1Var = (k1) o1Var.h().get(0);
            if (h10.isEmpty()) {
                return true;
            }
            k1Var.g(this.f18588b);
            k1Var.h(this.f18589c);
            for (k1 i10 : h10) {
                i10.i(ErrorType.C);
            }
            return true;
        }
    }

    public static void addMetadata(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
        getClient().b(str, str2, obj);
    }

    public static void clearMetadata(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            getClient().i(str);
        } else {
            getClient().j(str, str2);
        }
    }

    @NonNull
    public static o1 createEmptyEvent() {
        z client2 = getClient();
        return new o1(new r1((Throwable) null, client2.m(), q3.h("handledException"), client2.v().h().e()), client2.t());
    }

    @NonNull
    public static o1 createEvent(@Nullable Throwable th, @NonNull z zVar, @NonNull q3 q3Var) {
        return new o1(th, zVar.m(), q3Var, zVar.v().h(), zVar.r().g(), zVar.f19174q);
    }

    private static void deepMerge(Map<String, Object> map, Map<String, Object> map2) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            Object obj = map2.get(str);
            if ((value instanceof Map) && (obj instanceof Map)) {
                deepMerge((Map) value, (Map) obj);
            } else if (!(value instanceof Collection) || !(obj instanceof Collection)) {
                map2.put(str, value);
            } else {
                ((Collection) obj).addAll((Collection) value);
            }
        }
    }

    public static void deliverReport(@Nullable byte[] bArr, @NonNull byte[] bArr2, @Nullable byte[] bArr3, @NonNull String str, boolean z10) {
        String str2;
        if (bArr3 != null) {
            p pVar = p.f17266a;
            Map d10 = pVar.d(new ByteArrayInputStream(bArr2));
            deepMerge(pVar.d(new ByteArrayInputStream(bArr3)), d10);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            pVar.f(d10, byteArrayOutputStream);
            bArr2 = byteArrayOutputStream.toByteArray();
        }
        String str3 = new String(bArr2, UTF8Charset);
        if (bArr == null) {
            str2 = null;
        } else {
            str2 = new String(bArr, UTF8Charset);
        }
        z client2 = getClient();
        j m10 = client2.m();
        if (str2 == null || str2.length() == 0 || !m10.M()) {
            y1 q10 = client2.q();
            String D = q10.D(str3, str);
            if (z10) {
                D = D.replace(".json", "startupcrash.json");
            }
            q10.d(str3, D);
        }
    }

    @NonNull
    public static Map<String, Object> getApp() {
        HashMap hashMap = new HashMap();
        j k10 = getClient().k();
        m e10 = k10.e();
        hashMap.put("version", e10.g());
        hashMap.put("releaseStage", e10.e());
        hashMap.put("id", e10.d());
        hashMap.put("type", e10.f());
        hashMap.put("buildUUID", e10.b());
        hashMap.put("duration", e10.j());
        hashMap.put("durationInForeground", e10.k());
        hashMap.put("versionCode", e10.h());
        hashMap.put("inForeground", e10.l());
        hashMap.put("isLaunching", e10.m());
        hashMap.put("binaryArch", e10.a());
        hashMap.putAll(k10.f());
        return hashMap;
    }

    @Nullable
    public static String getAppVersion() {
        return getClient().m().d();
    }

    @NonNull
    public static List<Breadcrumb> getBreadcrumbs() {
        return getClient().l();
    }

    @NonNull
    private static z getClient() {
        z zVar = client;
        if (zVar != null) {
            return zVar;
        }
        return r.a();
    }

    @Nullable
    public static String getContext() {
        return getClient().n();
    }

    @NonNull
    public static String[] getCpuAbi() {
        return getClient().p().k();
    }

    @Nullable
    public static l3 getCurrentSession() {
        return getClient().f19172o.i();
    }

    @NonNull
    public static Map<String, Object> getDevice() {
        b1 p10 = getClient().p();
        HashMap hashMap = new HashMap(p10.l());
        i1 j10 = p10.j(new Date().getTime());
        hashMap.put("freeDisk", j10.m());
        hashMap.put("freeMemory", j10.n());
        hashMap.put("orientation", j10.o());
        hashMap.put("time", j10.p());
        hashMap.put("cpuAbi", j10.a());
        hashMap.put("jailbroken", j10.c());
        hashMap.put("id", j10.b());
        hashMap.put("locale", j10.d());
        hashMap.put("manufacturer", j10.e());
        hashMap.put("model", j10.f());
        hashMap.put("osName", j10.g());
        hashMap.put("osVersion", j10.h());
        hashMap.put("runtimeVersions", j10.i());
        hashMap.put("totalMemory", j10.j());
        return hashMap;
    }

    @Nullable
    public static Collection<String> getEnabledReleaseStages() {
        return getClient().m().m();
    }

    @NonNull
    public static String getEndpoint() {
        return getClient().m().n().a();
    }

    @Nullable
    public static n2 getLastRunInfo() {
        return getClient().s();
    }

    @NonNull
    public static s2 getLogger() {
        return getClient().m().r();
    }

    @NonNull
    public static Map<String, Object> getMetadata() {
        return getClient().u();
    }

    @NonNull
    public static File getNativeReportPath() {
        return getNativeReportPath(getPersistenceDirectory());
    }

    @NonNull
    private static File getPersistenceDirectory() {
        return (File) getClient().m().z().getValue();
    }

    @Nullable
    public static String getReleaseStage() {
        return getClient().m().C();
    }

    @NonNull
    public static String getSessionEndpoint() {
        return getClient().m().n().b();
    }

    @NonNull
    public static Map<String, String> getUser() {
        HashMap hashMap = new HashMap();
        k4 z10 = getClient().z();
        hashMap.put("id", z10.b());
        hashMap.put("name", z10.c());
        hashMap.put("email", z10.a());
        return hashMap;
    }

    public static boolean isDiscardErrorClass(@NonNull String str) {
        Collection<Pattern> j10 = getClient().m().j();
        if (j10.isEmpty()) {
            return false;
        }
        for (Pattern matcher : j10) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public static void leaveBreadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType) {
        if (str != null) {
            getClient().B(str, new HashMap(), breadcrumbType);
        }
    }

    public static void markLaunchCompleted() {
        getClient().E();
    }

    public static void notify(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull Severity severity, @NonNull StackTraceElement[] stackTraceElementArr) {
        if (bArr != null && bArr2 != null && stackTraceElementArr != null) {
            notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, stackTraceElementArr);
        }
    }

    public static void pauseSession() {
        getClient().I();
    }

    public static void registerSession(long j10, @Nullable String str, int i10, int i11) {
        Date date;
        z client2 = getClient();
        k4 z10 = client2.z();
        if (j10 > 0) {
            date = new Date(j10);
        } else {
            date = null;
        }
        client2.y().n(date, str, z10, i10, i11);
    }

    public static boolean resumeSession() {
        return getClient().P();
    }

    public static void setAutoDetectAnrs(boolean z10) {
        getClient().Q(z10);
    }

    public static void setAutoNotify(boolean z10) {
        getClient().R(z10);
    }

    public static void setBinaryArch(@NonNull String str) {
        getClient().S(str);
    }

    public static void setClient(@NonNull z zVar) {
        client = zVar;
    }

    public static void setContext(@Nullable String str) {
        getClient().U(str);
    }

    public static void setUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        getClient().V(str, str2, str3);
    }

    public static void startSession() {
        getClient().Z();
    }

    public static void addMetadata(@NonNull String str, @NonNull Map<String, ?> map) {
        getClient().c(str, map);
    }

    @NonNull
    private static File getNativeReportPath(@NonNull File file) {
        return new File(file, "bugsnag/native");
    }

    public static void leaveBreadcrumb(@NonNull byte[] bArr, @NonNull BreadcrumbType breadcrumbType) {
        if (bArr != null) {
            getClient().B(new String(bArr, UTF8Charset), new HashMap(), breadcrumbType);
        }
    }

    public static void setUser(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        String str;
        String str2 = null;
        String str3 = bArr == null ? null : new String(bArr, UTF8Charset);
        if (bArr2 == null) {
            str = null;
        } else {
            str = new String(bArr2, UTF8Charset);
        }
        if (bArr3 != null) {
            str2 = new String(bArr3, UTF8Charset);
        }
        setUser(str3, str, str2);
    }

    public static void leaveBreadcrumb(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        getClient().B(str, map, BreadcrumbType.valueOf(str2.toUpperCase(Locale.US)));
    }

    public static void notify(@NonNull String str, @NonNull String str2, @NonNull Severity severity, @NonNull StackTraceElement[] stackTraceElementArr) {
        if (!getClient().m().N(str)) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.setStackTrace(stackTraceElementArr);
            getClient().F(runtimeException, new a(severity, str, str2));
        }
    }

    public static void notify(@NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull Severity severity, @NonNull NativeStackframe[] nativeStackframeArr) {
        if (bArr != null && bArr2 != null && nativeStackframeArr != null) {
            notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, nativeStackframeArr);
        }
    }

    public static void notify(@NonNull String str, @NonNull String str2, @NonNull Severity severity, @NonNull NativeStackframe[] nativeStackframeArr) {
        z client2 = getClient();
        if (!client2.m().N(str)) {
            o1 createEmptyEvent = createEmptyEvent();
            createEmptyEvent.z(severity);
            ArrayList arrayList = new ArrayList(nativeStackframeArr.length);
            for (NativeStackframe s3Var : nativeStackframeArr) {
                arrayList.add(new s3(s3Var));
            }
            createEmptyEvent.h().add(new k1(new m1(str, str2, new u3(arrayList), ErrorType.C), client2.t()));
            getClient().K(createEmptyEvent, (h3) null);
        }
    }

    public static void deliverReport(@NonNull File file) {
        y1 y1Var = getClient().f19171n;
        if (file.renameTo(new File(y1Var.h(), file.getName()))) {
            y1Var.v();
        } else {
            file.delete();
        }
    }
}
