package a7;

import android.content.Context;
import android.os.Build;
import com.facebook.react.n;
import java.util.Locale;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2248a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static String f2249b;

    public static String a(Context context) {
        return b(c(context));
    }

    public static String b(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    private static Integer c(Context context) {
        return Integer.valueOf(context.getResources().getInteger(n.f20870a));
    }

    public static String d() {
        if (h()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
        if (r2 == null) goto L_0x006e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0074 A[SYNTHETIC, Splitter:B:45:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0079 A[SYNTHETIC, Splitter:B:49:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String e() {
        /*
            java.lang.Class<a7.a> r0 = a7.a.class
            monitor-enter(r0)
            java.lang.String r1 = f2249b     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0057, all -> 0x0052 }
            java.lang.String r3 = "/system/bin/getprop"
            java.lang.String r4 = "metro.host"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0057, all -> 0x0052 }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0057, all -> 0x0052 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004d, all -> 0x0048 }
            java.lang.String r1 = ""
        L_0x0030:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x0038
            r1 = r4
            goto L_0x0030
        L_0x0038:
            f2249b = r1     // Catch:{ Exception -> 0x0046 }
            r3.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0040
        L_0x003e:
            r1 = move-exception
            goto L_0x007d
        L_0x0040:
            r2.destroy()     // Catch:{ all -> 0x003e }
            goto L_0x006e
        L_0x0044:
            r1 = move-exception
            goto L_0x0072
        L_0x0046:
            r1 = move-exception
            goto L_0x005b
        L_0x0048:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0072
        L_0x004d:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x005b
        L_0x0052:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x0072
        L_0x0057:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L_0x005b:
            java.lang.String r4 = f2248a     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "Failed to query for metro.host prop:"
            z2.a.H(r4, r5, r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = ""
            f2249b = r1     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            if (r2 == 0) goto L_0x006e
            goto L_0x0040
        L_0x006e:
            java.lang.String r1 = f2249b     // Catch:{ all -> 0x003e }
            monitor-exit(r0)
            return r1
        L_0x0072:
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            if (r2 == 0) goto L_0x007c
            r2.destroy()     // Catch:{ all -> 0x003e }
        L_0x007c:
            throw r1     // Catch:{ all -> 0x003e }
        L_0x007d:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.a.e():java.lang.String");
    }

    public static String f(Context context) {
        return g(c(context).intValue());
    }

    private static String g(int i10) {
        String e10 = e();
        if (e10.equals("")) {
            if (h()) {
                e10 = "10.0.3.2";
            } else if (i()) {
                e10 = "10.0.2.2";
            } else {
                e10 = "localhost";
            }
        }
        return String.format(Locale.US, "%s:%d", new Object[]{e10, Integer.valueOf(i10)});
    }

    private static boolean h() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean i() {
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.startsWith("google/sdk_gphone")) {
            return true;
        }
        return false;
    }
}
