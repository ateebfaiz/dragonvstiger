package q5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.pdns.f;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23407a = z.b(q.class).b();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f23408b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentLinkedQueue f23409c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    private static final Map f23410d = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Long f23411e;

    /* renamed from: f  reason: collision with root package name */
    private static r5.b f23412f;

    /* renamed from: g  reason: collision with root package name */
    public static final q f23413g = new q();

    public interface a {
        void a();
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f23415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23416c;

        b(String str, Context context, String str2) {
            this.f23414a = str;
            this.f23415b = context;
            this.f23416c = str2;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    q qVar = q.f23413g;
                    JSONObject a10 = qVar.e(this.f23414a);
                    if (a10.length() != 0) {
                        q.k(this.f23414a, a10);
                        this.f23415b.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(this.f23416c, a10.toString()).apply();
                        q.f23411e = Long.valueOf(System.currentTimeMillis());
                    }
                    qVar.l();
                    q.f23408b.set(false);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23417a;

        c(a aVar) {
            this.f23417a = aVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23417a.a();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private q() {
    }

    /* access modifiers changed from: private */
    public final JSONObject e(String str) {
        GraphRequest graphRequest;
        Bundle bundle = new Bundle();
        bundle.putString("platform", f.f17924q);
        bundle.putString("sdk_version", o.w());
        bundle.putString("fields", "gatekeepers");
        if (p0.Y(o.n())) {
            GraphRequest.c cVar = GraphRequest.f19541t;
            b0 b0Var = b0.f709a;
            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{str, "mobile_sdk_gk"}, 2));
            m.e(format, "java.lang.String.format(format, *args)");
            graphRequest = cVar.v((AccessToken) null, format, (GraphRequest.b) null);
            graphRequest.G(true);
            graphRequest.F(bundle);
        } else {
            GraphRequest.c cVar2 = GraphRequest.f19541t;
            b0 b0Var2 = b0.f709a;
            String format2 = String.format("app/%s", Arrays.copyOf(new Object[]{"mobile_sdk_gk"}, 1));
            m.e(format2, "java.lang.String.format(format, *args)");
            graphRequest = cVar2.v((AccessToken) null, format2, (GraphRequest.b) null);
            graphRequest.F(bundle);
        }
        JSONObject d10 = graphRequest.i().d();
        if (d10 != null) {
            return d10;
        }
        return new JSONObject();
    }

    public static final boolean f(String str, String str2, boolean z10) {
        Boolean bool;
        m.f(str, "name");
        Map g10 = f23413g.g(str2);
        if (g10.containsKey(str) && (bool = (Boolean) g10.get(str)) != null) {
            return bool.booleanValue();
        }
        return z10;
    }

    private final boolean h(Long l10) {
        if (l10 != null && System.currentTimeMillis() - l10.longValue() < 3600000) {
            return true;
        }
        return false;
    }

    public static final synchronized void j(a aVar) {
        synchronized (q.class) {
            if (aVar != null) {
                try {
                    f23409c.add(aVar);
                } catch (JSONException e10) {
                    p0.e0("FacebookSDK", e10);
                } catch (Throwable th) {
                    throw th;
                }
            }
            String g10 = o.g();
            q qVar = f23413g;
            if (!qVar.h(f23411e) || !f23410d.containsKey(g10)) {
                Context f10 = o.f();
                b0 b0Var = b0.f709a;
                String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{g10}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                if (f10 != null) {
                    JSONObject jSONObject = null;
                    String string = f10.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(format, (String) null);
                    if (!p0.Y(string)) {
                        jSONObject = new JSONObject(string);
                        if (jSONObject != null) {
                            k(g10, jSONObject);
                        }
                    }
                    Executor p10 = o.p();
                    if (p10 == null) {
                        return;
                    }
                    if (f23408b.compareAndSet(false, true)) {
                        p10.execute(new b(g10, f10, format));
                        return;
                    }
                    return;
                }
                return;
            }
            qVar.l();
        }
    }

    public static final synchronized JSONObject k(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray optJSONArray;
        synchronized (q.class) {
            try {
                m.f(str, "applicationId");
                jSONObject2 = (JSONObject) f23410d.get(str);
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null || (jSONObject3 = optJSONArray.optJSONObject(0)) == null) {
                    jSONObject3 = new JSONObject();
                }
                JSONArray optJSONArray2 = jSONObject3.optJSONArray("gatekeepers");
                if (optJSONArray2 == null) {
                    optJSONArray2 = new JSONArray();
                }
                int length = optJSONArray2.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObject4 = optJSONArray2.getJSONObject(i10);
                    jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                }
                f23410d.put(str, jSONObject2);
            } catch (JSONException e10) {
                p0.e0("FacebookSDK", e10);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    public final void l() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue concurrentLinkedQueue = f23409c;
            if (!concurrentLinkedQueue.isEmpty()) {
                a aVar = (a) concurrentLinkedQueue.poll();
                if (aVar != null) {
                    handler.post(new c(aVar));
                }
            } else {
                return;
            }
        }
    }

    public static final JSONObject m(String str, boolean z10) {
        m.f(str, "applicationId");
        if (!z10) {
            Map map = f23410d;
            if (map.containsKey(str)) {
                JSONObject jSONObject = (JSONObject) map.get(str);
                if (jSONObject != null) {
                    return jSONObject;
                }
                return new JSONObject();
            }
        }
        JSONObject e10 = f23413g.e(str);
        Context f10 = o.f();
        b0 b0Var = b0.f709a;
        String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{str}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        f10.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(format, e10.toString()).apply();
        return k(str, e10);
    }

    public final Map g(String str) {
        List<r5.a> list;
        i();
        if (str != null) {
            Map map = f23410d;
            if (map.containsKey(str)) {
                r5.b bVar = f23412f;
                if (bVar != null) {
                    list = bVar.a(str);
                } else {
                    list = null;
                }
                if (list != null) {
                    HashMap hashMap = new HashMap();
                    for (r5.a aVar : list) {
                        hashMap.put(aVar.a(), Boolean.valueOf(aVar.b()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = (JSONObject) map.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    m.e(next, "key");
                    hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                r5.b bVar2 = f23412f;
                if (bVar2 == null) {
                    bVar2 = new r5.b();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new r5.a((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                bVar2.b(str, arrayList);
                f23412f = bVar2;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void i() {
        j((a) null);
    }
}
