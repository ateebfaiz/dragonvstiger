package p2;

import android.content.SharedPreferences;
import com.facebook.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import q5.p0;
import v5.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f23081a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f23082b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f23083c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public static final b f23084d = new b();

    private b() {
    }

    public static final void a(String str, String str2) {
        Class<b> cls = b.class;
        if (!a.d(cls)) {
            try {
                m.f(str, "pathID");
                m.f(str2, "predictedEvent");
                if (!f23083c.get()) {
                    f23084d.c();
                }
                Map map = f23081a;
                map.put(str, str2);
                SharedPreferences sharedPreferences = f23082b;
                if (sharedPreferences == null) {
                    m.u("shardPreferences");
                }
                sharedPreferences.edit().putString("SUGGESTED_EVENTS_HISTORY", p0.i0(i0.p(map))).apply();
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: org.json.JSONObject} */
    /* JADX WARNING: type inference failed for: r2v2, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|7|(1:9)|18|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(android.view.View r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "text"
            java.lang.Class<p2.b> r1 = p2.b.class
            boolean r2 = v5.a.d(r1)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "view"
            kotlin.jvm.internal.m.f(r4, r2)     // Catch:{ all -> 0x0033 }
            kotlin.jvm.internal.m.f(r5, r0)     // Catch:{ all -> 0x0033 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0033 }
            r2.<init>()     // Catch:{ all -> 0x0033 }
            r2.put(r0, r5)     // Catch:{ JSONException -> 0x003a }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x003a }
            r5.<init>()     // Catch:{ JSONException -> 0x003a }
        L_0x0021:
            if (r4 == 0) goto L_0x0035
            java.lang.Class r0 = r4.getClass()     // Catch:{ JSONException -> 0x003a }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ JSONException -> 0x003a }
            r5.put(r0)     // Catch:{ JSONException -> 0x003a }
            android.view.ViewGroup r4 = h2.f.j(r4)     // Catch:{ JSONException -> 0x003a }
            goto L_0x0021
        L_0x0033:
            r4 = move-exception
            goto L_0x0043
        L_0x0035:
            java.lang.String r4 = "classname"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x003a }
        L_0x003a:
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = q5.p0.C0(r4)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x0043:
            v5.a.b(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.b(android.view.View, java.lang.String):java.lang.String");
    }

    private final void c() {
        String str = "";
        if (!a.d(this)) {
            try {
                AtomicBoolean atomicBoolean = f23083c;
                if (!atomicBoolean.get()) {
                    SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
                    m.e(sharedPreferences, "FacebookSdk.getApplicati…RE, Context.MODE_PRIVATE)");
                    f23082b = sharedPreferences;
                    Map map = f23081a;
                    if (sharedPreferences == null) {
                        m.u("shardPreferences");
                    }
                    String string = sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", str);
                    if (string != null) {
                        str = string;
                    }
                    m.e(str, "shardPreferences.getStri…EVENTS_HISTORY, \"\") ?: \"\"");
                    map.putAll(p0.d0(str));
                    atomicBoolean.set(true);
                }
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    public static final String d(String str) {
        Class<b> cls = b.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "pathID");
            Map map = f23081a;
            if (map.containsKey(str)) {
                return (String) map.get(str);
            }
            return null;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }
}
