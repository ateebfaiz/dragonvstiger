package s5;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.s;
import com.facebook.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.n;
import q5.p0;
import s5.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f23883a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f23884b = new a();

    /* renamed from: s5.a$a  reason: collision with other inner class name */
    static final class C0332a implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23885a;

        C0332a(b bVar) {
            this.f23885a = bVar;
        }

        public final void a(t tVar) {
            JSONObject d10;
            m.f(tVar, "response");
            try {
                if (tVar.b() == null && (d10 = tVar.d()) != null && d10.getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    this.f23885a.a();
                }
            } catch (JSONException unused) {
            }
        }
    }

    private a() {
    }

    public static final void a() {
        f23883a = true;
        if (o.k()) {
            f23884b.d();
        }
    }

    public static final void b(Throwable th) {
        if (f23883a && !c() && th != null) {
            HashSet hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            m.e(stackTrace, "e.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                m.e(stackTraceElement, "it");
                String className = stackTraceElement.getClassName();
                m.e(className, "it.className");
                n.b d10 = n.d(className);
                if (d10 != n.b.Unknown) {
                    n.c(d10);
                    hashSet.add(d10.toString());
                }
            }
            if (o.k() && (!hashSet.isEmpty())) {
                b.a.c(new JSONArray(hashSet)).g();
            }
        }
    }

    public static final boolean c() {
        return false;
    }

    public final void d() {
        if (!p0.V()) {
            File[] i10 = f.i();
            ArrayList arrayList = new ArrayList();
            for (File d10 : i10) {
                b d11 = b.a.d(d10);
                if (d11.f()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", d11.toString());
                        GraphRequest.c cVar = GraphRequest.f19541t;
                        b0 b0Var = b0.f709a;
                        String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{o.g()}, 1));
                        m.e(format, "java.lang.String.format(format, *args)");
                        arrayList.add(cVar.x((AccessToken) null, format, jSONObject, new C0332a(d11)));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new s((Collection) arrayList).i();
            }
        }
    }
}
