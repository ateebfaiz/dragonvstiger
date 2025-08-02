package e2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.o;
import f2.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import q5.p0;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21218a;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f21219b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f21220c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f21221d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f21222e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final p f21223f = new p();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21225b;

        a(String str, String str2) {
            this.f21224a = str;
            this.f21225b = str2;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    p pVar = p.f21223f;
                    if (!p.a(pVar).get()) {
                        p.c(pVar);
                    }
                    p.b(pVar).edit().putString(this.f21224a, this.f21225b).apply();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String simpleName = p.class.getSimpleName();
        m.e(simpleName, "UserDataStore::class.java.simpleName");
        f21218a = simpleName;
    }

    private p() {
    }

    public static final /* synthetic */ AtomicBoolean a(p pVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21220c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ SharedPreferences b(p pVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = f21219b;
            if (sharedPreferences == null) {
                m.u("sharedPreferences");
            }
            return sharedPreferences;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void c(p pVar) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                pVar.f();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final String d() {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (!f21220c.get()) {
                f21223f.f();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(f21221d);
            hashMap.putAll(f21223f.e());
            return p0.i0(hashMap);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final Map e() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set b10 = c.f21504e.b();
            for (String str : f21222e.keySet()) {
                if (b10.contains(str)) {
                    hashMap.put(str, f21222e.get(str));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final synchronized void f() {
        if (!v5.a.d(this)) {
            try {
                AtomicBoolean atomicBoolean = f21220c;
                if (!atomicBoolean.get()) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
                    m.e(defaultSharedPreferences, "PreferenceManager.getDef….getApplicationContext())");
                    f21219b = defaultSharedPreferences;
                    if (defaultSharedPreferences == null) {
                        m.u("sharedPreferences");
                    }
                    String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
                    if (string == null) {
                        string = "";
                    }
                    m.e(string, "sharedPreferences.getStr…(USER_DATA_KEY, \"\") ?: \"\"");
                    SharedPreferences sharedPreferences = f21219b;
                    if (sharedPreferences == null) {
                        m.u("sharedPreferences");
                    }
                    String string2 = sharedPreferences.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
                    if (string2 == null) {
                        string2 = "";
                    }
                    m.e(string2, "sharedPreferences.getStr…_USER_DATA_KEY, \"\") ?: \"\"");
                    f21221d.putAll(p0.d0(string));
                    f21222e.putAll(p0.d0(string2));
                    atomicBoolean.set(true);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public static final void g() {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                if (!f21220c.get()) {
                    f21223f.f();
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final String h(String str, String str2) {
        String str3;
        int i10;
        boolean z10;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i11 > length) {
                    break;
                }
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
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
                        i11++;
                    }
                } else if (!z10) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = str2.subSequence(i11, length + 1).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (m.b("em", str)) {
                    if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        return lowerCase;
                    }
                    Log.e(f21218a, "Setting email failure: this is not a valid email address");
                    return "";
                } else if (m.b("ph", str)) {
                    return new h("[^0-9]").d(lowerCase, "");
                } else {
                    if (!m.b("ge", str)) {
                        return lowerCase;
                    }
                    if (lowerCase.length() <= 0) {
                        str3 = "";
                    } else if (lowerCase != null) {
                        str3 = lowerCase.substring(0, 1);
                        m.e(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (!m.b("f", str3)) {
                        if (!m.b("m", str3)) {
                            Log.e(f21218a, "Setting gender failure: the supported value for gender is f or m");
                            return "";
                        }
                    }
                    return str3;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c7 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void i(java.util.Map r12) {
        /*
            java.lang.Class<e2.p> r0 = e2.p.class
            boolean r1 = v5.a.d(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "ud"
            kotlin.jvm.internal.m.f(r12, r1)     // Catch:{ all -> 0x001c }
            java.util.concurrent.atomic.AtomicBoolean r1 = f21220c     // Catch:{ all -> 0x001c }
            boolean r1 = r1.get()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x001f
            e2.p r1 = f21223f     // Catch:{ all -> 0x001c }
            r1.f()     // Catch:{ all -> 0x001c }
            goto L_0x001f
        L_0x001c:
            r12 = move-exception
            goto L_0x011e
        L_0x001f:
            java.util.Set r12 = r12.entrySet()     // Catch:{ all -> 0x001c }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x001c }
        L_0x0027:
            boolean r1 = r12.hasNext()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0110
            java.lang.Object r1 = r12.next()     // Catch:{ all -> 0x001c }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x001c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x001c }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x001c }
            e2.p r3 = f21223f     // Catch:{ all -> 0x001c }
            int r4 = r1.length()     // Catch:{ all -> 0x001c }
            r5 = 1
            int r4 = r4 - r5
            r6 = 0
            r7 = r6
            r8 = r7
        L_0x004a:
            if (r7 > r4) goto L_0x006f
            if (r8 != 0) goto L_0x0050
            r9 = r7
            goto L_0x0051
        L_0x0050:
            r9 = r4
        L_0x0051:
            char r9 = r1.charAt(r9)     // Catch:{ all -> 0x001c }
            r10 = 32
            int r9 = kotlin.jvm.internal.m.g(r9, r10)     // Catch:{ all -> 0x001c }
            if (r9 > 0) goto L_0x005f
            r9 = r5
            goto L_0x0060
        L_0x005f:
            r9 = r6
        L_0x0060:
            if (r8 != 0) goto L_0x0069
            if (r9 != 0) goto L_0x0066
            r8 = r5
            goto L_0x004a
        L_0x0066:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0069:
            if (r9 != 0) goto L_0x006c
            goto L_0x006f
        L_0x006c:
            int r4 = r4 + -1
            goto L_0x004a
        L_0x006f:
            int r4 = r4 + 1
            java.lang.CharSequence r1 = r1.subSequence(r7, r4)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r3.h(r2, r1)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = q5.p0.C0(r1)     // Catch:{ all -> 0x001c }
            java.util.concurrent.ConcurrentHashMap r3 = f21222e     // Catch:{ all -> 0x001c }
            boolean r4 = r3.containsKey(r2)     // Catch:{ all -> 0x001c }
            if (r4 == 0) goto L_0x010b
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x001c }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x001c }
            java.lang.String r4 = ","
            if (r3 == 0) goto L_0x00b3
            kotlin.text.h r7 = new kotlin.text.h     // Catch:{ all -> 0x001c }
            r7.<init>((java.lang.String) r4)     // Catch:{ all -> 0x001c }
            java.util.List r7 = r7.e(r3, r6)     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x00b3
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ all -> 0x001c }
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ all -> 0x001c }
            java.lang.Object[] r7 = r7.toArray(r8)     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x00ab
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x001c }
            goto L_0x00b5
        L_0x00ab:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r12.<init>(r1)     // Catch:{ all -> 0x001c }
            throw r12     // Catch:{ all -> 0x001c }
        L_0x00b3:
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x001c }
        L_0x00b5:
            int r8 = r7.length     // Catch:{ all -> 0x001c }
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r7, r8)     // Catch:{ all -> 0x001c }
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ all -> 0x001c }
            java.util.Set r8 = kotlin.collections.r0.f(r8)     // Catch:{ all -> 0x001c }
            boolean r9 = r8.contains(r1)     // Catch:{ all -> 0x001c }
            if (r9 == 0) goto L_0x00c7
            return
        L_0x00c7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r9.<init>()     // Catch:{ all -> 0x001c }
            int r10 = r7.length     // Catch:{ all -> 0x001c }
            if (r10 != 0) goto L_0x00d8
            r9.append(r1)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "sb.append(value)"
            kotlin.jvm.internal.m.e(r9, r1)     // Catch:{ all -> 0x001c }
            goto L_0x0100
        L_0x00d8:
            int r10 = r7.length     // Catch:{ all -> 0x001c }
            r11 = 5
            if (r10 >= r11) goto L_0x00eb
            r9.append(r3)     // Catch:{ all -> 0x001c }
            r9.append(r4)     // Catch:{ all -> 0x001c }
            r9.append(r1)     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "sb.append(originalVal).a…_SEPARATOR).append(value)"
            kotlin.jvm.internal.m.e(r9, r1)     // Catch:{ all -> 0x001c }
            goto L_0x0100
        L_0x00eb:
            if (r5 >= r11) goto L_0x00f8
            r3 = r7[r5]     // Catch:{ all -> 0x001c }
            r9.append(r3)     // Catch:{ all -> 0x001c }
            r9.append(r4)     // Catch:{ all -> 0x001c }
            int r5 = r5 + 1
            goto L_0x00eb
        L_0x00f8:
            r9.append(r1)     // Catch:{ all -> 0x001c }
            r1 = r7[r6]     // Catch:{ all -> 0x001c }
            r8.remove(r1)     // Catch:{ all -> 0x001c }
        L_0x0100:
            java.util.concurrent.ConcurrentHashMap r1 = f21222e     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r9.toString()     // Catch:{ all -> 0x001c }
            r1.put(r2, r3)     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x010b:
            r3.put(r2, r1)     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x0110:
            e2.p r12 = f21223f     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "com.facebook.appevents.UserDataStore.internalUserData"
            java.util.concurrent.ConcurrentHashMap r2 = f21222e     // Catch:{ all -> 0x001c }
            java.lang.String r2 = q5.p0.i0(r2)     // Catch:{ all -> 0x001c }
            r12.j(r1, r2)     // Catch:{ all -> 0x001c }
            return
        L_0x011e:
            v5.a.b(r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.p.i(java.util.Map):void");
    }

    private final void j(String str, String str2) {
        if (!v5.a.d(this)) {
            try {
                o.p().execute(new a(str, str2));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
