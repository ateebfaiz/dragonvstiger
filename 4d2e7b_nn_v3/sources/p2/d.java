package p2;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.facebook.o;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import m2.d;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.r;
import q5.s;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f23087a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static final Set f23088b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private static final Set f23089c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    public static final d f23090d = new d();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23091a = new a();

        a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    d dVar = d.f23090d;
                    if (!d.a(dVar).get()) {
                        d.a(dVar).set(true);
                        d.b(dVar);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private d() {
    }

    public static final /* synthetic */ AtomicBoolean a(d dVar) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23087a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                dVar.d();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final synchronized void c() {
        synchronized (d.class) {
            if (!v5.a.d(d.class)) {
                try {
                    o.p().execute(a.f23091a);
                } catch (Throwable th) {
                    v5.a.b(th, d.class);
                }
            }
        }
    }

    private final void d() {
        String n10;
        if (!v5.a.d(this)) {
            try {
                r o10 = s.o(o.g(), false);
                if (o10 != null && (n10 = o10.n()) != null) {
                    g(n10);
                    if (!(!f23088b.isEmpty())) {
                        if (!(!f23089c.isEmpty())) {
                            return;
                        }
                    }
                    File j10 = m2.d.j(d.a.MTML_APP_EVENT_PREDICTION);
                    if (j10 != null) {
                        a.d(j10);
                        Activity p10 = l2.a.p();
                        if (p10 != null) {
                            h(p10);
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public static final boolean e(String str) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            m.f(str, NotificationCompat.CATEGORY_EVENT);
            return f23089c.contains(str);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean f(String str) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            m.f(str, NotificationCompat.CATEGORY_EVENT);
            return f23088b.contains(str);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final void h(Activity activity) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(activity, "activity");
                try {
                    if (f23087a.get() && a.f()) {
                        if (f23088b.isEmpty()) {
                            if (!f23089c.isEmpty()) {
                            }
                        }
                        e.f23093e.a(activity);
                        return;
                    }
                    e.f23093e.b(activity);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public final void g(String str) {
        if (!v5.a.d(this)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("production_events")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        Set set = f23088b;
                        String string = jSONArray.getString(i10);
                        m.e(string, "jsonArray.getString(i)");
                        set.add(string);
                    }
                }
                if (jSONObject.has("eligible_for_prediction_events")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                    int length2 = jSONArray2.length();
                    for (int i11 = 0; i11 < length2; i11++) {
                        Set set2 = f23089c;
                        String string2 = jSONArray2.getString(i11);
                        m.e(string2, "jsonArray.getString(i)");
                        set2.add(string2);
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
