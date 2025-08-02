package o2;

import android.util.Log;
import com.facebook.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.r;
import q5.s;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f22952a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f22953b = a.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private static final List f22954c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final Set f22955d = new CopyOnWriteArraySet();

    /* renamed from: e  reason: collision with root package name */
    public static final a f22956e = new a();

    /* renamed from: o2.a$a  reason: collision with other inner class name */
    public static final class C0316a {

        /* renamed from: a  reason: collision with root package name */
        private String f22957a;

        /* renamed from: b  reason: collision with root package name */
        private Map f22958b;

        public C0316a(String str, Map map) {
            m.f(str, "eventName");
            m.f(map, "restrictiveParams");
            this.f22957a = str;
            this.f22958b = map;
        }

        public final String a() {
            return this.f22957a;
        }

        public final Map b() {
            return this.f22958b;
        }

        public final void c(Map map) {
            m.f(map, "<set-?>");
            this.f22958b = map;
        }
    }

    private a() {
    }

    public static final void a() {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f22952a = true;
                f22956e.c();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final String b(String str, String str2) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            for (C0316a aVar : new ArrayList(f22954c)) {
                if (aVar != null) {
                    if (m.b(str, aVar.a())) {
                        for (String str3 : aVar.b().keySet()) {
                            if (m.b(str2, str3)) {
                                return (String) aVar.b().get(str3);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e10) {
            Log.w(f22953b, "getMatchedRuleType failed", e10);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
        return null;
    }

    private final void c() {
        String j10;
        if (!v5.a.d(this)) {
            try {
                r o10 = s.o(o.g(), false);
                if (o10 != null && (j10 = o10.j()) != null) {
                    if (j10.length() != 0) {
                        JSONObject jSONObject = new JSONObject(j10);
                        f22954c.clear();
                        f22955d.clear();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            if (jSONObject2 != null) {
                                JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                                m.e(next, "key");
                                C0316a aVar = new C0316a(next, new HashMap());
                                if (optJSONObject != null) {
                                    aVar.c(p0.n(optJSONObject));
                                    f22954c.add(aVar);
                                }
                                if (jSONObject2.has("process_event_name")) {
                                    f22955d.add(aVar.a());
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final boolean d(String str) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            return f22955d.contains(str);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    public static final String e(String str) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "eventName");
            if (!f22952a || !f22956e.d(str)) {
                return str;
            }
            return "_removed_";
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void f(Map map, String str) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(map, "parameters");
                m.f(str, "eventName");
                if (f22952a) {
                    HashMap hashMap = new HashMap();
                    for (String str2 : new ArrayList(map.keySet())) {
                        String b10 = f22956e.b(str, str2);
                        if (b10 != null) {
                            hashMap.put(str2, b10);
                            map.remove(str2);
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            for (Map.Entry entry : hashMap.entrySet()) {
                                jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                            }
                            map.put("_restrictedParams", jSONObject.toString());
                        } catch (JSONException unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
