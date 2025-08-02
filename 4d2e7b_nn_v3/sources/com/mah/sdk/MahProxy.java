package com.mah.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.mah.sdk.MahProxyOptions;
import d.b;
import d.c;
import g.a;
import i.e;
import i.n;
import i.q;
import i.r;
import i.u;
import i.v;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import r.f;
import w.d;

public class MahProxy {
    public static boolean OooO00o;

    public enum ProxyChangedReason {
        START_SUCCEED,
        START_FAILED_LOAD_SO_FAILED,
        START_FAILED_ANDROID_API,
        START_FAILED_SO_VERSION_MISMATCH,
        START_FAILED_UNZIP_CERT,
        START_FAILED_UNKNOWN,
        CHANGE_FROM_DISABLE_TO_ENABLE,
        SDK_DISABLE,
        NDK_EXIT,
        NDK_CRASHED,
        SDK_STOP,
        AUTH_FAILURE,
        UNKNOWN
    }

    public interface ProxyListener {
        void onProxyChanged(String str, int i10, ProxyChangedReason proxyChangedReason);
    }

    public static MahProxyAddress getAddress() {
        if (!OooO00o) {
            return null;
        }
        return a.a().h(b.ADDRESS_TYPE_SOURCE);
    }

    public static HostnameVerifier getHostnameVerifier() {
        return n.b((HostnameVerifier) null);
    }

    public static MahProxyAddress getHttpProxyAddress() {
        if (!OooO00o) {
            return null;
        }
        return a.a().h(b.ADDRESS_TYPE_PROXY_NORMAL);
    }

    public static MahProxyAddress getHttpsProxyAddress() {
        if (!OooO00o) {
            return null;
        }
        return a.a().h(b.ADDRESS_TYPE_PROXY_HANDSHAKE);
    }

    public static SSLSocketFactory getSslSocketFactory() {
        return n.h();
    }

    public static X509TrustManager getTrustManager() {
        return n.j();
    }

    public static String getVersion() {
        return Version.sdkVersion();
    }

    public static boolean isStarted() {
        return OooO00o;
    }

    public static void shareLog(Activity activity) {
        u.b(new q(new r(activity)));
    }

    public static int start(Context context) {
        return start(context, new MahProxyOptions(new MahProxyOptions.Builder()));
    }

    public static void OooO00o(MahProxyOptions mahProxyOptions, int i10) {
        if (mahProxyOptions != null && mahProxyOptions.OooO0oo != null) {
            mahProxyOptions.OooO0oo.onProxyChanged((String) null, -1, OooO00o.OooO0OO(i10));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int start(android.content.Context r8, com.mah.sdk.MahProxyOptions r9) {
        /*
            java.lang.Class<com.mah.sdk.MahProxy> r0 = com.mah.sdk.MahProxy.class
            monitor-enter(r0)
            java.lang.String r1 = "Mah proxy initialize failed: "
            r2 = -6
            boolean r3 = OooO00o     // Catch:{ all -> 0x0014 }
            r4 = 0
            if (r3 == 0) goto L_0x0017
            java.lang.String r8 = "MAH"
            java.lang.String r1 = "MahProxy is already running."
            w.d.k(r8, r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)
            return r4
        L_0x0014:
            r8 = move-exception
            goto L_0x009e
        L_0x0017:
            OooO00o((android.content.Context) r8)     // Catch:{ all -> 0x0014 }
            if (r9 != 0) goto L_0x0027
            com.mah.sdk.MahProxyOptions r3 = new com.mah.sdk.MahProxyOptions     // Catch:{ all -> 0x0014 }
            com.mah.sdk.MahProxyOptions$Builder r5 = new com.mah.sdk.MahProxyOptions$Builder     // Catch:{ all -> 0x0014 }
            r5.<init>()     // Catch:{ all -> 0x0014 }
            r3.<init>(r5)     // Catch:{ all -> 0x0014 }
            r9 = r3
        L_0x0027:
            r9.OooO00o()     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = i.v.a(r8)     // Catch:{ all -> 0x0014 }
            java.lang.String r5 = i.v.s(r8)     // Catch:{ all -> 0x0014 }
            boolean r6 = OooO00o(r9, r3, r5)     // Catch:{ all -> 0x0014 }
            if (r6 == 0) goto L_0x003a
            monitor-exit(r0)
            return r4
        L_0x003a:
            i.e r6 = OooO00o((android.content.Context) r8, (java.lang.String) r5)     // Catch:{ all -> 0x0014 }
            d.c r7 = new d.c     // Catch:{ all -> 0x0014 }
            r7.<init>(r8, r3, r5, r6)     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r9.f10168OooO0o0     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = com.mah.sdk.OooO00o.OooO0O0((android.content.Context) r8, (java.lang.String) r3)     // Catch:{ all -> 0x0014 }
            r7.f20996g = r3     // Catch:{ all -> 0x0014 }
            r9.a r3 = new r9.a     // Catch:{ all -> 0x0014 }
            r3.<init>()     // Catch:{ all -> 0x0014 }
            r7.f20997h = r3     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r6.b()     // Catch:{ all -> 0x0014 }
            OooO00o(r8, r5, r3, r9)     // Catch:{ all -> 0x0014 }
            q.f r3 = q.f.f()     // Catch:{ all -> 0x0014 }
            r3.c(r8, r7)     // Catch:{ all -> 0x0014 }
            g.i.p(r8, r7, r9)     // Catch:{ h -> 0x0069, all -> 0x0067 }
            r8 = 1
            OooO00o = r8     // Catch:{ h -> 0x0069, all -> 0x0067 }
            goto L_0x0095
        L_0x0067:
            r8 = move-exception
            goto L_0x006b
        L_0x0069:
            r8 = move-exception
            goto L_0x0079
        L_0x006b:
            java.lang.String r1 = "MAH"
            java.lang.String r4 = "Mah proxy start failed"
            w.d.g(r1, r4, r8)     // Catch:{ all -> 0x0077 }
            r3.h(r8)     // Catch:{ all -> 0x0077 }
            r4 = r2
            goto L_0x0095
        L_0x0077:
            r8 = move-exception
            goto L_0x009a
        L_0x0079:
            java.lang.String r4 = "MAH"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r5.<init>(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r8.getMessage()     // Catch:{ all -> 0x0077 }
            r5.append(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0077 }
            w.d.h(r4, r1)     // Catch:{ all -> 0x0077 }
            r3.h(r8)     // Catch:{ all -> 0x0077 }
            int r4 = r8.a()     // Catch:{ all -> 0x0077 }
        L_0x0095:
            r3.m()     // Catch:{ all -> 0x0014 }
            r2 = r4
            goto L_0x00a5
        L_0x009a:
            r3.m()     // Catch:{ all -> 0x0014 }
            throw r8     // Catch:{ all -> 0x0014 }
        L_0x009e:
            java.lang.String r1 = "MAH"
            java.lang.String r3 = "Mah proxy start unknown error"
            w.d.g(r1, r3, r8)     // Catch:{ all -> 0x00ab }
        L_0x00a5:
            if (r2 == 0) goto L_0x00ad
            OooO00o((com.mah.sdk.MahProxyOptions) r9, (int) r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r8 = move-exception
            goto L_0x00af
        L_0x00ad:
            monitor-exit(r0)
            return r2
        L_0x00af:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mah.sdk.MahProxy.start(android.content.Context, com.mah.sdk.MahProxyOptions):int");
    }

    public static e OooO00o(Context context, String str) {
        SharedPreferences OooO00o2 = OooO00o.OooO00o(context, str);
        String string = OooO00o2.getString("lastLaunchId", "");
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = currentTimeMillis + "-" + UUID.randomUUID().toString();
        OooO00o2.edit().putString("lastLaunchId", str2).apply();
        return new e(currentTimeMillis, str2, string);
    }

    public static void OooO00o(Context context, String str, String str2, MahProxyOptions mahProxyOptions) {
        if (v.p()) {
            d.k("MAH", "MahProxy start on main thread");
        } else {
            d.k("MAH", "MahProxy start on sub thread");
        }
        Locale locale = Locale.US;
        d.k("MAH", String.format(locale, "MahProxy version: %s", new Object[]{Version.sdkVersion()}));
        d.b().a("MAH", String.format(locale, "targetSdkVersion: %d", new Object[]{Integer.valueOf(context.getApplicationInfo().targetSdkVersion)}));
        d.b().a("MAH", String.format(locale, "SDK_INT: %d", new Object[]{Integer.valueOf(Build.VERSION.SDK_INT)}));
        d.b().a("MAH", String.format(locale, "processName: %s", new Object[]{str}));
        d.b().a("MAH", String.format(locale, "%s: %s", new Object[]{"sessionId", str2}));
        d.b().a("MAH", String.format(locale, "waitForAuthEnabled=%b, timeout=%d", new Object[]{Boolean.valueOf(mahProxyOptions.OooO), Integer.valueOf(mahProxyOptions.OooOO0)}));
    }

    public static void OooO00o(Context context) {
        if (d.d(context)) {
            d.c(new w.b(context));
        }
    }

    public static void OooO00o(Context context, c cVar) {
        f.c().e(context, cVar);
    }

    public static boolean OooO00o(MahProxyOptions mahProxyOptions, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.e("MAH", "packageName is empty, not start mah");
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            Log.e("MAH", "processName is empty, not start mah");
            return true;
        } else if (mahProxyOptions == null || !mahProxyOptions.OooO0Oo.contains(str2)) {
            return (str + ":mah_remote").equals(str2);
        } else {
            d.m("MAH", "process: " + str2 + " not start Mah");
            return true;
        }
    }
}
