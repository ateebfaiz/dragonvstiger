package t5;

import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import s5.b;
import s5.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f24165a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static final b f24166b = new b();

    static final class a implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f24167a;

        a(List list) {
            this.f24167a = list;
        }

        public final void a(t tVar) {
            JSONObject d10;
            m.f(tVar, "response");
            try {
                if (tVar.b() == null && (d10 = tVar.d()) != null && d10.getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    for (s5.b a10 : this.f24167a) {
                        a10.a();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: t5.b$b  reason: collision with other inner class name */
    static final class C0339b implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final C0339b f24168a = new C0339b();

        C0339b() {
        }

        /* renamed from: a */
        public final int compare(s5.b bVar, s5.b bVar2) {
            m.e(bVar2, "o2");
            return bVar.b(bVar2);
        }
    }

    private b() {
    }

    public static final synchronized void a() {
        synchronized (b.class) {
            if (!v5.a.d(b.class)) {
                try {
                    if (!f24165a.getAndSet(true)) {
                        if (o.k()) {
                            b();
                        }
                        a.b();
                    }
                } catch (Throwable th) {
                    v5.a.b(th, b.class);
                }
            }
        }
    }

    public static final void b() {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                if (!p0.V()) {
                    File[] h10 = f.h();
                    ArrayList arrayList = new ArrayList(h10.length);
                    for (File d10 : h10) {
                        arrayList.add(b.a.d(d10));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object next : arrayList) {
                        if (((s5.b) next).f()) {
                            arrayList2.add(next);
                        }
                    }
                    List s02 = r.s0(arrayList2, C0339b.f24168a);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = l.l(0, Math.min(s02.size(), 5)).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(s02.get(((g0) it).nextInt()));
                    }
                    f.l("anr_reports", jSONArray, new a(s02));
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
