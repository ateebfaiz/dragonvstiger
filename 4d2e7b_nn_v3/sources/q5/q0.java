package q5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.o;
import com.facebook.p;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23418a;

    /* renamed from: b  reason: collision with root package name */
    public static final q0 f23419b = new q0();

    static {
        String name = q0.class.getName();
        m.e(name, "Validate::class.java.name");
        f23418a = name;
    }

    private q0() {
    }

    public static final void a(Collection collection, String str) {
        m.f(collection, "container");
        m.f(str, "name");
        m(collection, str);
        for (Object obj : collection) {
            if (obj == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static final String b() {
        String g10 = o.g();
        if (g10 != null) {
            return g10;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    public static final String c() {
        String n10 = o.n();
        if (n10 != null) {
            return n10;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.".toString());
    }

    public static final void d(Context context) {
        m.f(context, "context");
        m(context, "context");
        String b10 = b();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = "com.facebook.app.FacebookContentProvider" + b10;
            if (packageManager.resolveContentProvider(str, 0) == null) {
                b0 b0Var = b0.f709a;
                String format = String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", Arrays.copyOf(new Object[]{str}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                throw new IllegalStateException(format.toString());
            }
        }
    }

    public static final boolean e(Context context, String str) {
        List<ResolveInfo> list;
        m.f(context, "context");
        m(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        boolean z10 = false;
        for (ResolveInfo resolveInfo : list) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!m.b(activityInfo.name, "com.facebook.CustomTabActivity") || !m.b(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z10 = true;
        }
        return z10;
    }

    public static final void f(Context context) {
        m.f(context, "context");
        g(context, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void g(android.content.Context r4, boolean r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.f(r4, r0)
            m(r4, r0)
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r1 = 1
            if (r0 == 0) goto L_0x001b
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "com.facebook.FacebookActivity"
            r2.<init>(r4, r3)
            android.content.pm.ActivityInfo r4 = r0.getActivityInfo(r2, r1)     // Catch:{ NameNotFoundException -> 0x001b }
            goto L_0x001c
        L_0x001b:
            r4 = 0
        L_0x001c:
            if (r4 != 0) goto L_0x0034
            r4 = r5 ^ 1
            java.lang.String r5 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            if (r4 == 0) goto L_0x002a
            java.lang.String r4 = f23418a
            android.util.Log.w(r4, r5)
            goto L_0x0034
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q0.g(android.content.Context, boolean):void");
    }

    public static final void h(Context context) {
        m.f(context, "context");
        i(context, true);
    }

    public static final void i(Context context, boolean z10) {
        m.f(context, "context");
        m(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (!z10) {
            Log.w(f23418a, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
            return;
        }
        throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.".toString());
    }

    public static final void j(String str, String str2) {
        boolean z10;
        m.f(str, "arg");
        m.f(str2, "name");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be empty").toString());
        }
    }

    public static final void k(Collection collection, String str) {
        m.f(collection, "container");
        m.f(str, "name");
        if (!(!collection.isEmpty())) {
            throw new IllegalArgumentException(("Container '" + str + "' cannot be empty").toString());
        }
    }

    public static final void l(Collection collection, String str) {
        m.f(collection, "container");
        m.f(str, "name");
        a(collection, str);
        k(collection, str);
    }

    public static final void m(Object obj, String str) {
        m.f(str, "name");
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    public static final String n(String str, String str2) {
        boolean z10;
        m.f(str2, "name");
        if (str == null || str.length() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return str;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be null or empty").toString());
    }

    public static final void o() {
        if (!o.A()) {
            throw new p("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }
}
