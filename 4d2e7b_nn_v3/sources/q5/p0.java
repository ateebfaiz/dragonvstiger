package q5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.l;
import com.facebook.o;
import com.facebook.t;
import com.facebook.u;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import e2.p;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import q5.n;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    private static int f23393a;

    /* renamed from: b  reason: collision with root package name */
    private static long f23394b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static long f23395c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static long f23396d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static String f23397e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f23398f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f23399g = "NoCarrier";

    /* renamed from: h  reason: collision with root package name */
    public static final p0 f23400h = new p0();

    public interface a {
        void a(JSONObject jSONObject);

        void b(l lVar);
    }

    public interface b {
        Object apply(Object obj);
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private List f23401a;

        /* renamed from: b  reason: collision with root package name */
        private List f23402b;

        /* renamed from: c  reason: collision with root package name */
        private List f23403c;

        public c(List list, List list2, List list3) {
            m.f(list, "grantedPermissions");
            m.f(list2, "declinedPermissions");
            m.f(list3, "expiredPermissions");
            this.f23401a = list;
            this.f23402b = list2;
            this.f23403c = list3;
        }

        public final List a() {
            return this.f23402b;
        }

        public final List b() {
            return this.f23403c;
        }

        public final List c() {
            return this.f23401a;
        }
    }

    static final class d implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23405b;

        d(a aVar, String str) {
            this.f23404a = aVar;
            this.f23405b = str;
        }

        public final void a(t tVar) {
            m.f(tVar, "response");
            if (tVar.b() != null) {
                this.f23404a.b(tVar.b().e());
                return;
            }
            String str = this.f23405b;
            JSONObject d10 = tVar.d();
            if (d10 != null) {
                h0.b(str, d10);
                this.f23404a.a(tVar.d());
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    static final class e implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final e f23406a = new e();

        e() {
        }

        public final boolean accept(File file, String str) {
            return Pattern.matches("cpu[0-9]+", str);
        }
    }

    private p0() {
    }

    public static final JSONObject A() {
        Class<p0> cls = p0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            String string = o.f().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", (String) null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void A0(JSONObject jSONObject, Context context) {
        String str;
        Locale locale;
        int i10;
        m.f(jSONObject, "params");
        m.f(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        f23400h.u0(context);
        String packageName = context.getPackageName();
        int i11 = 0;
        int i12 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                i12 = packageInfo.versionCode;
                str = packageInfo.versionName;
                jSONArray.put(packageName);
                jSONArray.put(i12);
                jSONArray.put(str);
                jSONArray.put(Build.VERSION.RELEASE);
                jSONArray.put(Build.MODEL);
                try {
                    Resources resources = context.getResources();
                    m.e(resources, "appContext.resources");
                    locale = resources.getConfiguration().locale;
                } catch (Exception unused) {
                    locale = Locale.getDefault();
                }
                StringBuilder sb2 = new StringBuilder();
                m.e(locale, "locale");
                sb2.append(locale.getLanguage());
                sb2.append("_");
                sb2.append(locale.getCountry());
                jSONArray.put(sb2.toString());
                jSONArray.put(f23397e);
                jSONArray.put(f23399g);
                double d10 = 0.0d;
                try {
                    Object systemService = context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                    Display display = null;
                    if (!(systemService instanceof DisplayManager)) {
                        systemService = null;
                    }
                    DisplayManager displayManager = (DisplayManager) systemService;
                    if (displayManager != null) {
                        display = displayManager.getDisplay(0);
                    }
                    if (display != null) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        display.getMetrics(displayMetrics);
                        int i13 = displayMetrics.widthPixels;
                        try {
                            i11 = displayMetrics.heightPixels;
                            d10 = (double) displayMetrics.density;
                        } catch (Exception unused2) {
                        }
                        i10 = i11;
                        i11 = i13;
                        jSONArray.put(i11);
                        jSONArray.put(i10);
                        jSONArray.put(new DecimalFormat("#.##").format(d10));
                        jSONArray.put(f23400h.s0());
                        jSONArray.put(f23395c);
                        jSONArray.put(f23396d);
                        jSONArray.put(f23398f);
                        jSONObject.put("extinfo", jSONArray.toString());
                    }
                } catch (Exception unused3) {
                }
                i10 = 0;
                jSONArray.put(i11);
                jSONArray.put(i10);
                jSONArray.put(new DecimalFormat("#.##").format(d10));
                jSONArray.put(f23400h.s0());
                jSONArray.put(f23395c);
                jSONArray.put(f23396d);
                jSONArray.put(f23398f);
                jSONObject.put("extinfo", jSONArray.toString());
            }
        } catch (PackageManager.NameNotFoundException unused4) {
            str = "";
        }
    }

    public static final String B(String str) {
        String q10 = o.q();
        if (str == null) {
            return q10;
        }
        int hashCode = str.hashCode();
        if (hashCode != -1253231569) {
            if (hashCode == 28903346 && str.equals("instagram")) {
                return j.z(q10, "facebook.com", "instagram.com", false, 4, (Object) null);
            }
            return q10;
        } else if (str.equals("gaming")) {
            return j.z(q10, "facebook.com", "fb.gg", false, 4, (Object) null);
        } else {
            return q10;
        }
    }

    public static final String B0(byte[] bArr) {
        m.f(bArr, "bytes");
        return f23400h.O(com.alibaba.pdns.j.f17956c, bArr);
    }

    private final GraphRequest C(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", H(z()));
        bundle.putString("access_token", str);
        GraphRequest w10 = GraphRequest.f19541t.w((AccessToken) null, (GraphRequest.d) null);
        w10.F(bundle);
        w10.E(u.GET);
        return w10;
    }

    public static final String C0(String str) {
        if (str == null) {
            return null;
        }
        return f23400h.N("SHA-256", str);
    }

    public static final void D(String str, a aVar) {
        m.f(str, "accessToken");
        m.f(aVar, "callback");
        JSONObject a10 = h0.a(str);
        if (a10 != null) {
            aVar.a(a10);
            return;
        }
        d dVar = new d(aVar, str);
        GraphRequest C = f23400h.C(str);
        C.B(dVar);
        C.j();
    }

    public static final JSONArray D0(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static final String E(Context context) {
        q0.m(context, "context");
        return o.g();
    }

    public static final JSONObject E0(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static final Method F(Class cls, String str, Class... clsArr) {
        m.f(cls, "clazz");
        m.f(str, "methodName");
        m.f(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final void F0(Parcel parcel, Map map) {
        m.f(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    public static final Method G(String str, String str2, Class... clsArr) {
        m.f(str, "className");
        m.f(str2, "methodName");
        m.f(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            m.e(cls, "Class.forName(className)");
            return F(cls, str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String H(String str) {
        if (m.b(str, "instagram")) {
            return "id,name,profile_picture";
        }
        return "id,name,first_name,middle_name,last_name";
    }

    public static final Locale I() {
        try {
            Resources resources = o.f().getResources();
            m.e(resources, "FacebookSdk.getApplicationContext().resources");
            return resources.getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object J(JSONObject jSONObject, String str, String str2) {
        m.f(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new l("Got an unexpected non-JSON object.");
    }

    public static final String K(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public static final c L(JSONObject jSONObject) {
        String optString;
        m.f(jSONObject, DbParams.KEY_CHANNEL_RESULT);
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            String optString2 = optJSONObject.optString("permission");
            if (!(optString2 == null || m.b(optString2, "installed") || (optString = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS)) == null)) {
                if (m.b(optString, "granted")) {
                    arrayList.add(optString2);
                } else if (m.b(optString, "declined")) {
                    arrayList2.add(optString2);
                } else if (m.b(optString, "expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new c(arrayList, arrayList2, arrayList3);
    }

    private final String M(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : digest) {
            sb2.append(Integer.toHexString((b10 >> 4) & 15));
            sb2.append(Integer.toHexString(b10 & 15));
        }
        String sb3 = sb2.toString();
        m.e(sb3, "builder.toString()");
        return sb3;
    }

    private final String N(String str, String str2) {
        Charset charset = kotlin.text.d.f797b;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return O(str, bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String O(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            m.e(instance, "hash");
            return M(instance, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final Object P(Object obj, Method method, Object... objArr) {
        m.f(method, FirebaseAnalytics.Param.METHOD);
        m.f(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean Q() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            b0 b0Var = b0.f709a;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{o.g()}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context f10 = o.f();
            PackageManager packageManager = f10.getPackageManager();
            String packageName = f10.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (m.b(packageName, resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean R(Context context) {
        AutofillManager a10;
        m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 26 && (a10 = m0.a(context.getSystemService(l0.a()))) != null && a10.isAutofillSupported() && a10.isEnabled()) {
            return true;
        }
        return false;
    }

    public static final boolean S(Context context) {
        m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            m.e(str, "Build.DEVICE");
            if (new h(".+_cheets|cheets_.+").c(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean T(Uri uri) {
        if (uri == null || !j.q(FirebaseAnalytics.Param.CONTENT, uri.getScheme(), true)) {
            return false;
        }
        return true;
    }

    public static final boolean U(AccessToken accessToken) {
        if (accessToken == null || !m.b(accessToken, AccessToken.N0.e())) {
            return false;
        }
        return true;
    }

    public static final boolean V() {
        Class<p0> cls = p0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            JSONObject A = A();
            if (A != null) {
                try {
                    JSONArray jSONArray = A.getJSONArray("data_processing_options");
                    int length = jSONArray.length();
                    int i10 = 0;
                    while (i10 < length) {
                        String string = jSONArray.getString(i10);
                        m.e(string, "options.getString(i)");
                        if (string != null) {
                            String lowerCase = string.toLowerCase();
                            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (m.b(lowerCase, "ldu")) {
                                return true;
                            }
                            i10++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean W(Uri uri) {
        if (uri == null || !j.q("file", uri.getScheme(), true)) {
            return false;
        }
        return true;
    }

    private final boolean X(Context context) {
        Method G = G("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (G == null) {
            return false;
        }
        Object P = P((Object) null, G, context);
        if (!(P instanceof Integer) || (!m.b(P, 0))) {
            return false;
        }
        return true;
    }

    public static final boolean Y(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean Z(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    private final void a(JSONObject jSONObject, b bVar, String str, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !X(context)) {
            jSONObject.put("anon_id", str);
        } else if (!bVar.k()) {
            jSONObject.put("anon_id", str);
        }
    }

    public static final boolean a0(Uri uri) {
        if (uri == null || (!j.q("http", uri.getScheme(), true) && !j.q("https", uri.getScheme(), true) && !j.q("fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    private final void b(JSONObject jSONObject, b bVar, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !X(context)) {
            jSONObject.put("attribution", bVar.j());
        } else if (!bVar.k()) {
            jSONObject.put("attribution", bVar.j());
        }
    }

    public static final Set b0(JSONArray jSONArray) {
        m.f(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            String string = jSONArray.getString(i10);
            m.e(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    public static final boolean c(Object obj, Object obj2) {
        if (obj != null) {
            return m.b(obj, obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public static final List c0(JSONArray jSONArray) {
        m.f(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public static final List d(Object... objArr) {
        m.f(objArr, "array");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Map d0(String str) {
        m.f(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                m.e(next, "key");
                String string = jSONObject.getString(next);
                m.e(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final JSONObject e(String str) {
        m.f(str, "accessToken");
        JSONObject a10 = h0.a(str);
        if (a10 != null) {
            return a10;
        }
        t i10 = f23400h.C(str).i();
        if (i10.b() != null) {
            return null;
        }
        return i10.d();
    }

    public static final void e0(String str, Exception exc) {
        if (o.x() && str != null && exc != null) {
            Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
        }
    }

    public static final Uri f(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    builder.appendQueryParameter(next, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        m.e(build, "builder.build()");
        return build;
    }

    public static final void f0(String str, String str2) {
        if (o.x() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    private final void g(Context context, String str) {
        int i10;
        boolean z10;
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array = j.v0(cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i11 = 0;
                while (i11 < length) {
                    Object[] array2 = j.v0(strArr[i11], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            String str2 = strArr2[0];
                            int length2 = str2.length() - 1;
                            int i12 = 0;
                            boolean z11 = false;
                            while (i12 <= length2) {
                                if (!z11) {
                                    i10 = i12;
                                } else {
                                    i10 = length2;
                                }
                                if (m.g(str2.charAt(i10), 32) <= 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (!z11) {
                                    if (!z10) {
                                        z11 = true;
                                    } else {
                                        i12++;
                                    }
                                } else if (!z10) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            sb2.append(str2.subSequence(i12, length2 + 1).toString());
                            sb2.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                            instance.setCookie(str, sb2.toString());
                        }
                        i11++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static final void g0(String str, String str2, Throwable th) {
        if (o.x() && !Y(str)) {
            Log.d(str, str2, th);
        }
    }

    public static final void h(Context context) {
        m.f(context, "context");
        p0 p0Var = f23400h;
        p0Var.g(context, "facebook.com");
        p0Var.g(context, ".facebook.com");
        p0Var.g(context, "https://facebook.com");
        p0Var.g(context, "https://.facebook.com");
    }

    public static final List h0(List list, b bVar) {
        m.f(bVar, "mapper");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object apply : list) {
            Object apply2 = bVar.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static final void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String i0(Map map) {
        m.f(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            m.e(str, "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        }
        return str;
    }

    public static final String j(String str, String str2) {
        if (Y(str)) {
            return str2;
        }
        return str;
    }

    public static final String j0(String str) {
        m.f(str, "key");
        return f23400h.N(com.alibaba.pdns.j.f17955b, str);
    }

    private final long k(double d10) {
        return Math.round(d10 / 1.073741824E9d);
    }

    public static final boolean k0(Context context) {
        m.f(context, "context");
        return R(context);
    }

    public static final List l(JSONArray jSONArray) {
        m.f(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                m.e(string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final Bundle l0(String str) {
        Bundle bundle = new Bundle();
        if (!Y(str)) {
            if (str != null) {
                Object[] array = j.v0(str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        Object[] array2 = j.v0(strArr[i10], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e10) {
                                e0("FacebookSDK", e10);
                            }
                            i10++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    public static final Map m(JSONObject jSONObject) {
        m.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        if (names != null) {
            int length = names.length();
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    String string = names.getString(i10);
                    m.e(string, "keys.getString(i)");
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = m((JSONObject) obj);
                    }
                    m.e(obj, "value");
                    hashMap.put(string, obj);
                } catch (JSONException unused) {
                }
            }
        }
        return hashMap;
    }

    public static final boolean m0(Bundle bundle, String str, Object obj) {
        m.f(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, obj.toString());
            return true;
        }
    }

    public static final Map n(JSONObject jSONObject) {
        m.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                m.e(next, "key");
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static final void n0(Bundle bundle, String str, String str2) {
        m.f(bundle, "b");
        if (!Y(str2)) {
            bundle.putString(str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int o(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.m.f(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0029 }
            r1.<init>(r6)     // Catch:{ all -> 0x0029 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x001d }
            r2 = 0
            r3 = r2
        L_0x0011:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x001d }
            r5 = -1
            if (r4 == r5) goto L_0x0020
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x001d }
            int r3 = r3 + r4
            goto L_0x0011
        L_0x001d:
            r7 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0020:
            r1.close()
            if (r6 == 0) goto L_0x0028
            r6.close()
        L_0x0028:
            return r3
        L_0x0029:
            r7 = move-exception
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()
        L_0x002f:
            if (r6 == 0) goto L_0x0034
            r6.close()
        L_0x0034:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.p0.o(java.io.InputStream, java.io.OutputStream):int");
    }

    public static final void o0(Bundle bundle, String str, Uri uri) {
        m.f(bundle, "b");
        if (uri != null) {
            n0(bundle, str, uri.toString());
        }
    }

    public static final void p(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File p10 : listFiles) {
                    p(p10);
                }
            }
            file.delete();
        }
    }

    public static final String p0(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb2.append(cArr, 0, read);
                        } else {
                            String sb3 = sb2.toString();
                            m.e(sb3, "stringBuilder.toString()");
                            i(bufferedInputStream);
                            i(inputStreamReader);
                            return sb3;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i(bufferedInputStream);
                    i(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                i(bufferedInputStream);
                i(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
            i(bufferedInputStream);
            i(inputStreamReader);
            throw th;
        }
    }

    public static final void q(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static final Map q0(Parcel parcel) {
        m.f(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < readInt; i10++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    private final boolean r() {
        return m.b("mounted", Environment.getExternalStorageState());
    }

    private final void r0() {
        try {
            if (r()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                m.e(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                f23396d = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            f23396d = k((double) f23396d);
        } catch (Exception unused) {
        }
    }

    public static final String s(int i10) {
        String bigInteger = new BigInteger(i10 * 5, new Random()).toString(32);
        m.e(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    private final int s0() {
        int i10 = f23393a;
        if (i10 > 0) {
            return i10;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(e.f23406a);
            if (listFiles != null) {
                f23393a = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (f23393a <= 0) {
            f23393a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f23393a;
    }

    public static final String t(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        m.e(simpleName, "context.javaClass.simpleName");
        return simpleName;
    }

    private final void t0(Context context) {
        if (m.b(f23399g, "NoCarrier")) {
            try {
                Object systemService = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    m.e(networkOperatorName, "telephonyManager.networkOperatorName");
                    f23399g = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    public static final String u(Context context) {
        m.f(context, "context");
        try {
            String h10 = o.h();
            if (h10 != null) {
                return h10;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i10 = applicationInfo.labelRes;
            if (i10 == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i10);
            m.e(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    private final void u0(Context context) {
        if (f23394b == -1 || System.currentTimeMillis() - f23394b >= ((long) com.adjust.sdk.Constants.THIRTY_MINUTES)) {
            f23394b = System.currentTimeMillis();
            v0();
            t0(context);
            w0();
            r0();
        }
    }

    public static final String v() {
        Context f10 = o.f();
        if (f10 != null) {
            try {
                PackageInfo packageInfo = f10.getPackageManager().getPackageInfo(f10.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    private final void v0() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            m.e(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            f23397e = displayName;
            m.e(timeZone, "tz");
            String id2 = timeZone.getID();
            m.e(id2, "tz.id");
            f23398f = id2;
        } catch (AssertionError | Exception unused) {
        }
    }

    public static final Date w(Bundle bundle, String str, Date date) {
        long j10;
        m.f(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j10 = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j10 = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j10 == 0) {
            return new Date(LocationRequestCompat.PASSIVE_INTERVAL);
        }
        return new Date(date.getTime() + (j10 * 1000));
    }

    private final void w0() {
        try {
            if (r()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                m.e(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                f23395c = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            f23395c = k((double) f23395c);
        } catch (Exception unused) {
        }
    }

    public static final long x(Uri uri) {
        m.f(uri, "contentUri");
        Cursor cursor = null;
        try {
            Cursor query = o.f().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return 0;
            }
            int columnIndex = query.getColumnIndex("_size");
            query.moveToFirst();
            long j10 = query.getLong(columnIndex);
            query.close();
            return j10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static final void x0(Runnable runnable) {
        try {
            o.p().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final Locale y() {
        Locale I = I();
        if (I != null) {
            return I;
        }
        Locale locale = Locale.getDefault();
        m.e(locale, "Locale.getDefault()");
        return locale;
    }

    public static final String y0(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        m.e(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    private final String z() {
        AccessToken e10 = AccessToken.N0.e();
        if (e10 == null || e10.i() == null) {
            return "facebook";
        }
        return e10.i();
    }

    public static final void z0(JSONObject jSONObject, b bVar, String str, boolean z10, Context context) {
        m.f(jSONObject, "params");
        m.f(context, "context");
        n.b bVar2 = n.b.ServiceUpdateCompliance;
        if (!n.g(bVar2)) {
            jSONObject.put("anon_id", str);
        }
        jSONObject.put("application_tracking_enabled", !z10);
        jSONObject.put("advertiser_id_collection_enabled", o.e());
        if (bVar != null) {
            if (n.g(bVar2)) {
                f23400h.a(jSONObject, bVar, str, context);
            }
            if (bVar.j() != null) {
                if (n.g(bVar2)) {
                    f23400h.b(jSONObject, bVar, context);
                } else {
                    jSONObject.put("attribution", bVar.j());
                }
            }
            if (bVar.h() != null) {
                jSONObject.put("advertiser_id", bVar.h());
                jSONObject.put("advertiser_tracking_enabled", !bVar.k());
            }
            if (!bVar.k()) {
                String d10 = p.d();
                if (d10.length() != 0) {
                    jSONObject.put("ud", d10);
                }
            }
            if (bVar.i() != null) {
                jSONObject.put("installer_package", bVar.i());
            }
        }
    }
}
