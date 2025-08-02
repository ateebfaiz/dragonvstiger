package j2;

import android.content.SharedPreferences;
import com.facebook.o;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import l2.d;
import org.json.JSONObject;
import v5.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f22189a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set f22190b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private static final Map f22191c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final e f22192d = new e();

    private e() {
    }

    public static final boolean d() {
        Class<e> cls = e.class;
        if (a.d(cls)) {
            return false;
        }
        try {
            f22192d.g();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences = f22189a;
            if (sharedPreferences == null) {
                m.u("sharedPreferences");
            }
            long j10 = sharedPreferences.getLong("LAST_QUERY_PURCHASE_HISTORY_TIME", 0);
            if (j10 != 0 && currentTimeMillis - j10 < ((long) 86400)) {
                return false;
            }
            SharedPreferences sharedPreferences2 = f22189a;
            if (sharedPreferences2 == null) {
                m.u("sharedPreferences");
            }
            sharedPreferences2.edit().putLong("LAST_QUERY_PURCHASE_HISTORY_TIME", currentTimeMillis).apply();
            return true;
        } catch (Throwable th) {
            a.b(th, cls);
            return false;
        }
    }

    public static final void e(Map map, Map map2) {
        Class<e> cls = e.class;
        if (!a.d(cls)) {
            try {
                m.f(map, "purchaseDetailsMap");
                m.f(map2, "skuDetailsMap");
                e eVar = f22192d;
                eVar.g();
                eVar.f(eVar.c(eVar.a(map), map2));
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    private final void f(Map map) {
        if (!a.d(this)) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!(str == null || str2 == null)) {
                        d.f(str, str2, false);
                    }
                }
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    private final void g() {
        Collection collection;
        if (!a.d(this)) {
            try {
                SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
                SharedPreferences sharedPreferences2 = o.f().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
                if (sharedPreferences.contains("LAST_CLEARED_TIME")) {
                    sharedPreferences.edit().clear().apply();
                    sharedPreferences2.edit().clear().apply();
                }
                SharedPreferences sharedPreferences3 = o.f().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0);
                m.e(sharedPreferences3, "getApplicationContext().…RE, Context.MODE_PRIVATE)");
                f22189a = sharedPreferences3;
                Set<String> set = f22190b;
                if (sharedPreferences3 == null) {
                    m.u("sharedPreferences");
                }
                Set<String> stringSet = sharedPreferences3.getStringSet("PURCHASE_DETAILS_SET", new HashSet());
                if (stringSet != null) {
                    collection = stringSet;
                } else {
                    collection = new HashSet();
                }
                set.addAll(collection);
                for (String v02 : set) {
                    List v03 = j.v0(v02, new String[]{";"}, false, 2, 2, (Object) null);
                    f22191c.put(v03.get(0), Long.valueOf(Long.parseLong((String) v03.get(1))));
                }
                b();
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map a(java.util.Map r9) {
        /*
            r8 = this;
            java.lang.String r0 = "purchaseToken"
            boolean r1 = v5.a.d(r8)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "purchaseDetailsMap"
            kotlin.jvm.internal.m.f(r9, r1)     // Catch:{ all -> 0x0050 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0050 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            java.util.Map r1 = kotlin.collections.i0.p(r9)     // Catch:{ all -> 0x0050 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0050 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0050 }
        L_0x0022:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0050 }
            if (r5 == 0) goto L_0x006c
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0050 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0050 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0050 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0050 }
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ all -> 0x0050 }
            boolean r7 = r5.has(r0)     // Catch:{ Exception -> 0x0022 }
            if (r7 == 0) goto L_0x0022
            java.lang.String r5 = r5.getString(r0)     // Catch:{ Exception -> 0x0022 }
            java.util.Map r7 = f22191c     // Catch:{ Exception -> 0x0022 }
            boolean r7 = r7.containsKey(r5)     // Catch:{ Exception -> 0x0022 }
            if (r7 == 0) goto L_0x0052
            r9.remove(r6)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0050:
            r9 = move-exception
            goto L_0x008a
        L_0x0052:
            java.util.Set r6 = f22190b     // Catch:{ Exception -> 0x0022 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
            r7.<init>()     // Catch:{ Exception -> 0x0022 }
            r7.append(r5)     // Catch:{ Exception -> 0x0022 }
            r5 = 59
            r7.append(r5)     // Catch:{ Exception -> 0x0022 }
            r7.append(r3)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0022 }
            r6.add(r5)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x006c:
            android.content.SharedPreferences r0 = f22189a     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0075
            java.lang.String r1 = "sharedPreferences"
            kotlin.jvm.internal.m.u(r1)     // Catch:{ all -> 0x0050 }
        L_0x0075:
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = "PURCHASE_DETAILS_SET"
            java.util.Set r3 = f22190b     // Catch:{ all -> 0x0050 }
            android.content.SharedPreferences$Editor r0 = r0.putStringSet(r1, r3)     // Catch:{ all -> 0x0050 }
            r0.apply()     // Catch:{ all -> 0x0050 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0050 }
            r0.<init>(r9)     // Catch:{ all -> 0x0050 }
            return r0
        L_0x008a:
            v5.a.b(r9, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.e.a(java.util.Map):java.util.Map");
    }

    public final void b() {
        if (!a.d(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences = f22189a;
                if (sharedPreferences == null) {
                    m.u("sharedPreferences");
                }
                long j10 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0);
                if (j10 == 0) {
                    SharedPreferences sharedPreferences2 = f22189a;
                    if (sharedPreferences2 == null) {
                        m.u("sharedPreferences");
                    }
                    sharedPreferences2.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                } else if (currentTimeMillis - j10 > ((long) 604800)) {
                    for (Map.Entry entry : i0.p(f22191c).entrySet()) {
                        String str = (String) entry.getKey();
                        long longValue = ((Number) entry.getValue()).longValue();
                        if (currentTimeMillis - longValue > ((long) 86400)) {
                            Set set = f22190b;
                            set.remove(str + ';' + longValue);
                            f22191c.remove(str);
                        }
                    }
                    SharedPreferences sharedPreferences3 = f22189a;
                    if (sharedPreferences3 == null) {
                        m.u("sharedPreferences");
                    }
                    sharedPreferences3.edit().putStringSet("PURCHASE_DETAILS_SET", f22190b).putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                }
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }

    public final Map c(Map map, Map map2) {
        if (a.d(this)) {
            return null;
        }
        try {
            m.f(map, "purchaseDetailsMap");
            m.f(map2, "skuDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                JSONObject jSONObject = (JSONObject) entry.getValue();
                JSONObject jSONObject2 = (JSONObject) map2.get((String) entry.getKey());
                if (jSONObject != null && jSONObject.has("purchaseTime")) {
                    try {
                        if (currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) <= ((long) 86400)) {
                            if (jSONObject2 != null) {
                                String jSONObject3 = jSONObject.toString();
                                m.e(jSONObject3, "purchaseDetail.toString()");
                                String jSONObject4 = jSONObject2.toString();
                                m.e(jSONObject4, "skuDetail.toString()");
                                linkedHashMap.put(jSONObject3, jSONObject4);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }
}
