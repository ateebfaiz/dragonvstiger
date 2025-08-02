package w5;

import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.collections.r;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import s5.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f24618a = new b();

    static final class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24619a = new a();

        a() {
        }

        public final boolean accept(File file, String str) {
            m.e(str, "name");
            b0 b0Var = b0.f709a;
            String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"error_log_"}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            return new h(format).c(str);
        }
    }

    /* renamed from: w5.b$b  reason: collision with other inner class name */
    static final class C0351b implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final C0351b f24620a = new C0351b();

        C0351b() {
        }

        /* renamed from: a */
        public final int compare(a aVar, a aVar2) {
            m.e(aVar2, "o2");
            return aVar.b(aVar2);
        }
    }

    static final class c implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f24621a;

        c(ArrayList arrayList) {
            this.f24621a = arrayList;
        }

        public final void a(t tVar) {
            JSONObject d10;
            m.f(tVar, "response");
            try {
                if (tVar.b() == null && (d10 = tVar.d()) != null && d10.getBoolean(FirebaseAnalytics.Param.SUCCESS)) {
                    for (a a10 : this.f24621a) {
                        a10.a();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    private b() {
    }

    public static final void a() {
        if (o.k()) {
            d();
        }
    }

    public static final File[] b() {
        File c10 = f.c();
        if (c10 == null) {
            return new File[0];
        }
        File[] listFiles = c10.listFiles(a.f24619a);
        m.e(listFiles, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    public static final void c(String str) {
        try {
            new a(str).e();
        } catch (Exception unused) {
        }
    }

    public static final void d() {
        if (!p0.V()) {
            File[] b10 = b();
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (File aVar : b10) {
                a aVar2 = new a(aVar);
                if (aVar2.d()) {
                    arrayList.add(aVar2);
                }
            }
            r.y(arrayList, C0351b.f24620a);
            JSONArray jSONArray = new JSONArray();
            while (i10 < arrayList.size() && i10 < 1000) {
                jSONArray.put(arrayList.get(i10));
                i10++;
            }
            f.l("error_reports", jSONArray, new c(arrayList));
        }
    }
}
