package u5;

import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import s5.b;
import s5.f;

public final class a implements Thread.UncaughtExceptionHandler {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f24344b = a.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f24345c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0342a f24346d = new C0342a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f24347a;

    /* renamed from: u5.a$a  reason: collision with other inner class name */
    public static final class C0342a {

        /* renamed from: u5.a$a$a  reason: collision with other inner class name */
        static final class C0343a implements GraphRequest.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List f24348a;

            C0343a(List list) {
                this.f24348a = list;
            }

            public final void a(t tVar) {
                JSONObject d10;
                m.f(tVar, "response");
                try {
                    if (tVar.b() == null && (d10 = tVar.d()) != null && d10.getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                        for (s5.b a10 : this.f24348a) {
                            a10.a();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }

        /* renamed from: u5.a$a$b */
        static final class b implements Comparator {

            /* renamed from: a  reason: collision with root package name */
            public static final b f24349a = new b();

            b() {
            }

            /* renamed from: a */
            public final int compare(s5.b bVar, s5.b bVar2) {
                m.e(bVar2, "o2");
                return bVar.b(bVar2);
            }
        }

        private C0342a() {
        }

        private final void b() {
            if (!p0.V()) {
                File[] j10 = f.j();
                ArrayList arrayList = new ArrayList(j10.length);
                for (File d10 : j10) {
                    arrayList.add(b.a.d(d10));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (((s5.b) next).f()) {
                        arrayList2.add(next);
                    }
                }
                List s02 = r.s0(arrayList2, b.f24349a);
                JSONArray jSONArray = new JSONArray();
                Iterator it = l.l(0, Math.min(s02.size(), 5)).iterator();
                while (it.hasNext()) {
                    jSONArray.put(s02.get(((g0) it).nextInt()));
                }
                f.l("crash_reports", jSONArray, new C0343a(s02));
            }
        }

        public final synchronized void a() {
            try {
                if (o.k()) {
                    b();
                }
                if (a.f24345c != null) {
                    Log.w(a.f24344b, "Already enabled!");
                    return;
                }
                a.f24345c = new a(Thread.getDefaultUncaughtExceptionHandler(), (DefaultConstructorMarker) null);
                Thread.setDefaultUncaughtExceptionHandler(a.f24345c);
            } catch (Throwable th) {
                throw th;
            }
        }

        public /* synthetic */ C0342a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(uncaughtExceptionHandler);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m.f(thread, "t");
        m.f(th, "e");
        if (f.f(th)) {
            s5.a.b(th);
            b.a.b(th, b.c.CrashReport).g();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24347a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f24347a = uncaughtExceptionHandler;
    }
}
