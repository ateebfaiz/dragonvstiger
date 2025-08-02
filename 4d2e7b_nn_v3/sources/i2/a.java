package i2;

import com.facebook.o;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import e2.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.p0;
import q5.r;
import q5.s;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f22048a;

    /* renamed from: b  reason: collision with root package name */
    private static final List f22049b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static final Set f22050c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public static final a f22051d = new a();

    /* renamed from: i2.a$a  reason: collision with other inner class name */
    public static final class C0286a {

        /* renamed from: a  reason: collision with root package name */
        private String f22052a;

        /* renamed from: b  reason: collision with root package name */
        private List f22053b;

        public C0286a(String str, List list) {
            m.f(str, "eventName");
            m.f(list, "deprecateParams");
            this.f22052a = str;
            this.f22053b = list;
        }

        public final List a() {
            return this.f22053b;
        }

        public final String b() {
            return this.f22052a;
        }

        public final void c(List list) {
            m.f(list, "<set-?>");
            this.f22053b = list;
        }
    }

    private a() {
    }

    public static final void a() {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f22048a = true;
                f22051d.b();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final synchronized void b() {
        if (!v5.a.d(this)) {
            try {
                r o10 = s.o(o.g(), false);
                if (o10 != null) {
                    String j10 = o10.j();
                    if (j10 != null && j10.length() > 0) {
                        JSONObject jSONObject = new JSONObject(j10);
                        f22049b.clear();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            if (jSONObject2 != null) {
                                if (jSONObject2.optBoolean("is_deprecated_event")) {
                                    Set set = f22050c;
                                    m.e(next, "key");
                                    set.add(next);
                                } else {
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                    m.e(next, "key");
                                    C0286a aVar = new C0286a(next, new ArrayList());
                                    if (optJSONArray != null) {
                                        aVar.c(p0.l(optJSONArray));
                                    }
                                    f22049b.add(aVar);
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

    public static final void c(Map map, String str) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(map, "parameters");
                m.f(str, "eventName");
                if (f22048a) {
                    ArrayList<String> arrayList = new ArrayList<>(map.keySet());
                    for (C0286a aVar : new ArrayList(f22049b)) {
                        if (!(!m.b(aVar.b(), str))) {
                            for (String str2 : arrayList) {
                                if (aVar.a().contains(str2)) {
                                    map.remove(str2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void d(List list) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(list, DbParams.TABLE_EVENTS);
                if (f22048a) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (f22050c.contains(((c) it.next()).f())) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
