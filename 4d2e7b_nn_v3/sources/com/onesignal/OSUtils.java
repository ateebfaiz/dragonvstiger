package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationManagerCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.s.e.c;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.location.LocationListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.location.LocationCallback;
import com.onesignal.o3;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OSUtils {

    /* renamed from: a  reason: collision with root package name */
    public static int f10310a = 3;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f10311b = {401, 402, 403, 404, 410};

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10312a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.onesignal.OSUtils$b[] r0 = com.onesignal.OSUtils.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10312a = r0
                com.onesignal.OSUtils$b r1 = com.onesignal.OSUtils.b.DATA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10312a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.OSUtils$b r1 = com.onesignal.OSUtils.b.HTTPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10312a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.OSUtils$b r1 = com.onesignal.OSUtils.b.HTTP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSUtils.a.<clinit>():void");
        }
    }

    public enum b {
        DATA("data"),
        HTTPS("https"),
        HTTP("http");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f10317a;

        private b(String str) {
            this.f10317a = str;
        }

        public static b b(String str) {
            for (b bVar : values()) {
                if (bVar.f10317a.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    OSUtils() {
    }

    static boolean B() {
        if (new OSUtils().e() == 1) {
            return true;
        }
        return false;
    }

    static boolean C() {
        if (new OSUtils().e() == 2) {
            return true;
        }
        return false;
    }

    static boolean D() {
        return P("com.google.android.gms");
    }

    private static boolean E() {
        try {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(o3.f10882b) == 0) {
                return true;
            }
            return false;
        } catch (RuntimeException e10) {
            if (i.a(e10.getCause())) {
                return false;
            }
            throw e10;
        }
    }

    private static boolean F() {
        return P("com.huawei.hwid");
    }

    static boolean G() {
        if (new OSUtils().e() == 13) {
            return true;
        }
        return false;
    }

    static boolean H() {
        return Thread.currentThread().equals(Looper.getMainLooper().getThread());
    }

    static boolean I(String str) {
        return !TextUtils.isEmpty(str);
    }

    static boolean J(String str) {
        if (str == null || str.matches("^[0-9]")) {
            return false;
        }
        return true;
    }

    static Set K() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    static Set L(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            hashSet.add(jSONArray.getString(i10));
        }
        return hashSet;
    }

    private static void M(Uri uri) {
        o3.f10882b.startActivity(O(uri));
    }

    static void N(String str) {
        M(Uri.parse(str.trim()));
    }

    static Intent O(Uri uri) {
        b bVar;
        Intent intent;
        if (uri.getScheme() != null) {
            bVar = b.b(uri.getScheme());
        } else {
            bVar = null;
        }
        if (bVar == null) {
            bVar = b.HTTP;
            if (!uri.toString().contains("://")) {
                uri = Uri.parse(c.f18246k + uri.toString());
            }
        }
        if (a.f10312a[bVar.ordinal()] != 1) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            intent.setData(uri);
        }
        intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        return intent;
    }

    private static boolean P(String str) {
        PackageInfo a10;
        y a11 = f4.f10638a.a(o3.f10882b, str, 128);
        if (a11.b() && (a10 = a11.a()) != null) {
            return a10.applicationInfo.enabled;
        }
        return false;
    }

    static long[] Q(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            Object opt = jSONObject.opt("vib_pt");
            if (opt instanceof String) {
                jSONArray = new JSONArray((String) opt);
            } else {
                jSONArray = (JSONArray) opt;
            }
            long[] jArr = new long[jSONArray.length()];
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                jArr[i10] = jSONArray.optLong(i10);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    static void R(Runnable runnable, int i10) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, (long) i10);
    }

    static void S(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static boolean T(String str) {
        if (str != null) {
            return false;
        }
        o3.a(o3.v.INFO, "OneSignal was not initialized, ensure to always initialize OneSignal from the onCreate of your Application class.");
        return true;
    }

    public static boolean U(int i10) {
        for (int i11 : f10311b) {
            if (i10 == i11) {
                return false;
            }
        }
        return true;
    }

    static void V(int i10) {
        try {
            Thread.sleep((long) i10);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    static void W(Thread thread) {
        boolean z10 = false;
        while (!z10) {
            try {
                thread.start();
                z10 = true;
            } catch (OutOfMemoryError unused) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException unused2) {
                }
            }
        }
    }

    private boolean X() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean Y() {
        if (!r()) {
            return false;
        }
        return D();
    }

    private boolean Z() {
        if (!u() || !p()) {
            return false;
        }
        return E();
    }

    static boolean a(Context context) {
        try {
            return NotificationManagerCompat.from(o3.f10882b).areNotificationsEnabled();
        } catch (Throwable unused) {
            return true;
        }
    }

    private Integer b(Context context) {
        boolean z10 = z();
        boolean y10 = y();
        if (!z10 && !y10) {
            o3.a(o3.v.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
            return -3;
        } else if (!z10 || !y10) {
            o3.a(o3.v.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        } else if (Build.VERSION.SDK_INT < 26 || o(context) < 26 || x()) {
            return null;
        } else {
            o3.a(o3.v.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        }
    }

    static String f(Context context, String str) {
        Bundle h10 = h(context);
        if (h10 != null) {
            return h10.getString(str);
        }
        return null;
    }

    static boolean g(Context context, String str) {
        Bundle h10 = h(context);
        if (h10 != null) {
            return h10.getBoolean(str);
        }
        return false;
    }

    static Bundle h(Context context) {
        ApplicationInfo a10 = j.f10703a.a(context);
        if (a10 == null) {
            return null;
        }
        return a10.metaData;
    }

    static int j(int i10, int i11) {
        return new Random().nextInt((i11 + 1) - i10) + i10;
    }

    static String k(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        if (identifier != 0) {
            return resources.getString(identifier);
        }
        return str2;
    }

    static String l(Throwable th) {
        return m(th).getMessage();
    }

    static Throwable m(Throwable th) {
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    static Uri n(Context context, String str) {
        int identifier;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (!J(str) || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
            if (identifier2 == 0) {
                return null;
            }
            return Uri.parse("android.resource://" + packageName + DomExceptionUtils.SEPARATOR + identifier2);
        }
        return Uri.parse("android.resource://" + packageName + DomExceptionUtils.SEPARATOR + identifier);
    }

    static int o(Context context) {
        ApplicationInfo a10 = j.f10703a.a(context);
        if (a10 == null) {
            return 15;
        }
        return a10.targetSdkVersion;
    }

    @Keep
    private static boolean opaqueHasClass(Class<?> cls) {
        return true;
    }

    static boolean p() {
        if (!t() || !w()) {
            return false;
        }
        return true;
    }

    static boolean q(Activity activity, int i10) {
        try {
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i10) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    static boolean r() {
        try {
            return opaqueHasClass(FirebaseMessaging.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    static boolean s() {
        try {
            return opaqueHasClass(LocationListener.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean t() {
        try {
            return opaqueHasClass(AGConnectServicesConfig.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean u() {
        try {
            return opaqueHasClass(HuaweiApiAvailability.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    static boolean v() {
        try {
            return opaqueHasClass(LocationCallback.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean w() {
        try {
            return opaqueHasClass(HmsInstanceId.class);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    private static boolean x() {
        return true;
    }

    private static boolean y() {
        return true;
    }

    private static boolean z() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public int A(Context context, String str) {
        Integer c10;
        int e10 = e();
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str)) {
                o3.a(o3.v.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            int i10 = 1;
            if (e10 == 1 && (c10 = c()) != null) {
                i10 = c10.intValue();
            }
            Integer b10 = b(context);
            if (b10 != null) {
                return b10.intValue();
            }
            return i10;
        } catch (Throwable th) {
            o3.b(o3.v.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return -999;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer c() {
        if (r()) {
            return null;
        }
        o3.a(o3.v.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return -4;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        try {
            String networkOperatorName = ((TelephonyManager) o3.f10882b.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
            if ("".equals(networkOperatorName)) {
                return null;
            }
            return networkOperatorName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int e() {
        if (X()) {
            return 2;
        }
        boolean Z = Z();
        boolean Y = Y();
        if (Y && Z) {
            Context context = o3.f10882b;
            if (context == null || !g(context, "com.onesignal.preferHMS")) {
                return 1;
            }
            return 13;
        } else if (Y) {
            return 1;
        } else {
            if (Z) {
                return 13;
            }
            if (!D() && F()) {
                return 13;
            }
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer i() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) o3.f10882b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 9) {
            return 0;
        }
        return 1;
    }
}
