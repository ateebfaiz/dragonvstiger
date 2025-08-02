package q5;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f23262a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f23263b = new c();

    public static final class a implements h {
        a() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            jSONObject.put(str, obj);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public static final class b implements h {
        b() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            jSONObject.put(str, obj);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    }

    /* renamed from: q5.c$c  reason: collision with other inner class name */
    public static final class C0324c implements h {
        C0324c() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            jSONObject.put(str, obj);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            bundle.putLong(str, ((Long) obj).longValue());
        }
    }

    public static final class d implements h {
        d() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            jSONObject.put(str, obj);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }
    }

    public static final class e implements h {
        e() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            jSONObject.put(str, obj);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            bundle.putString(str, (String) obj);
        }
    }

    public static final class f implements h {
        f() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            JSONArray jSONArray = new JSONArray();
            for (String put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            throw new IllegalArgumentException("Unexpected type from JSON");
        }
    }

    public static final class g implements h {
        g() {
        }

        public void a(JSONObject jSONObject, String str, Object obj) {
            m.f(jSONObject, "json");
            m.f(str, "key");
            m.f(obj, "value");
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }

        public void b(Bundle bundle, String str, Object obj) {
            m.f(bundle, "bundle");
            m.f(str, "key");
            m.f(obj, "value");
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int length = jSONArray.length();
            int i10 = 0;
            while (i10 < length) {
                Object obj2 = jSONArray.get(i10);
                if (obj2 instanceof String) {
                    arrayList.add(obj2);
                    i10++;
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }
    }

    public interface h {
        void a(JSONObject jSONObject, String str, Object obj);

        void b(Bundle bundle, String str, Object obj);
    }

    static {
        HashMap hashMap = new HashMap();
        f23262a = hashMap;
        hashMap.put(Boolean.class, new a());
        hashMap.put(Integer.class, new b());
        hashMap.put(Long.class, new C0324c());
        hashMap.put(Double.class, new d());
        hashMap.put(String.class, new e());
        hashMap.put(String[].class, new f());
        hashMap.put(JSONArray.class, new g());
    }

    private c() {
    }

    public static final Bundle a(JSONObject jSONObject) {
        m.f(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, a((JSONObject) obj));
                } else {
                    h hVar = (h) f23262a.get(obj.getClass());
                    if (hVar != null) {
                        m.e(next, "key");
                        m.e(obj, "value");
                        hVar.b(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return bundle;
    }

    public static final JSONObject b(Bundle bundle) {
        m.f(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                m.e(obj, "bundle[key] ?: // Null i…orted.\n          continue");
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(next, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(next, b((Bundle) obj));
                } else {
                    h hVar = (h) f23262a.get(obj.getClass());
                    if (hVar != null) {
                        m.e(next, "key");
                        hVar.a(jSONObject, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return jSONObject;
    }
}
