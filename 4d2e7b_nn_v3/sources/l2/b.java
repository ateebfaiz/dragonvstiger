package l2;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.Window;
import com.facebook.o;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import q5.p0;
import v5.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22412a = new b();

    private b() {
    }

    public static final void a() {
    }

    public static final void b() {
    }

    public static final String c(byte[] bArr) {
        m.f(bArr, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte valueOf : bArr) {
            b0 b0Var = b0.f709a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
        }
        String stringBuffer2 = stringBuffer.toString();
        m.e(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public static final String d() {
        Context f10 = o.f();
        try {
            String str = f10.getPackageManager().getPackageInfo(f10.getPackageName(), 0).versionName;
            m.e(str, "packageInfo.versionName");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static final View e(Activity activity) {
        Class<b> cls = b.class;
        if (a.d(cls) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            View decorView = window.getDecorView();
            m.e(decorView, "window.decorView");
            return decorView.getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (kotlin.text.j.F(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean f() {
        /*
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r1 = "Build.FINGERPRINT"
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r2 = "generic"
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r6 = kotlin.text.j.F(r0, r2, r3, r4, r5)
            if (r6 != 0) goto L_0x0073
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r1 = "unknown"
            boolean r0 = kotlin.text.j.F(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L_0x0073
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "Build.MODEL"
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r6 = "google_sdk"
            boolean r7 = kotlin.text.j.K(r0, r6, r3, r4, r5)
            if (r7 != 0) goto L_0x0073
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r7 = "Emulator"
            boolean r7 = kotlin.text.j.K(r0, r7, r3, r4, r5)
            if (r7 != 0) goto L_0x0073
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = kotlin.text.j.K(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L_0x0073
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "Build.MANUFACTURER"
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = kotlin.text.j.K(r0, r1, r3, r4, r5)
            if (r0 != 0) goto L_0x0073
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "Build.BRAND"
            kotlin.jvm.internal.m.e(r0, r1)
            boolean r0 = kotlin.text.j.F(r0, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r1 = "Build.DEVICE"
            kotlin.jvm.internal.m.e(r0, r1)
            boolean r0 = kotlin.text.j.F(r0, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0073
        L_0x006b:
            java.lang.String r0 = android.os.Build.PRODUCT
            boolean r0 = kotlin.jvm.internal.m.b(r6, r0)
            if (r0 == 0) goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.b.f():boolean");
    }

    public static final double g(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            return NumberFormat.getNumberInstance(p0.y()).parse(matcher.group(0)).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }
}
