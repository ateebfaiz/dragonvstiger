package s5;

import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;

public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final C0333b f23886h = new C0333b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f23887a;

    /* renamed from: b  reason: collision with root package name */
    private c f23888b;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f23889c;

    /* renamed from: d  reason: collision with root package name */
    private String f23890d;

    /* renamed from: e  reason: collision with root package name */
    private String f23891e;

    /* renamed from: f  reason: collision with root package name */
    private String f23892f;

    /* renamed from: g  reason: collision with root package name */
    private Long f23893g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23894a = new a();

        private a() {
        }

        public static final b a(String str, String str2) {
            return new b(str, str2, (DefaultConstructorMarker) null);
        }

        public static final b b(Throwable th, c cVar) {
            m.f(cVar, "t");
            return new b(th, cVar, (DefaultConstructorMarker) null);
        }

        public static final b c(JSONArray jSONArray) {
            m.f(jSONArray, "features");
            return new b(jSONArray, (DefaultConstructorMarker) null);
        }

        public static final b d(File file) {
            m.f(file, "file");
            return new b(file, (DefaultConstructorMarker) null);
        }
    }

    /* renamed from: s5.b$b  reason: collision with other inner class name */
    public static final class C0333b {
        private C0333b() {
        }

        /* access modifiers changed from: private */
        public final c b(String str) {
            if (j.F(str, "crash_log_", false, 2, (Object) null)) {
                return c.CrashReport;
            }
            if (j.F(str, "shield_log_", false, 2, (Object) null)) {
                return c.CrashShield;
            }
            if (j.F(str, "thread_check_log_", false, 2, (Object) null)) {
                return c.ThreadCheck;
            }
            if (j.F(str, "analysis_log_", false, 2, (Object) null)) {
                return c.Analysis;
            }
            if (j.F(str, "anr_log_", false, 2, (Object) null)) {
                return c.AnrReport;
            }
            return c.Unknown;
        }

        public /* synthetic */ C0333b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum c {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        public final String a() {
            int i10 = c.f23903b[ordinal()];
            if (i10 == 1) {
                return "analysis_log_";
            }
            if (i10 == 2) {
                return "anr_log_";
            }
            if (i10 == 3) {
                return "crash_log_";
            }
            if (i10 == 4) {
                return "shield_log_";
            }
            if (i10 != 5) {
                return "Unknown";
            }
            return "thread_check_log_";
        }

        public String toString() {
            int i10 = c.f23902a[ordinal()];
            if (i10 == 1) {
                return "Analysis";
            }
            if (i10 == 2) {
                return "AnrReport";
            }
            if (i10 == 3) {
                return "CrashReport";
            }
            if (i10 == 4) {
                return "CrashShield";
            }
            if (i10 != 5) {
                return "Unknown";
            }
            return "ThreadCheck";
        }
    }

    public /* synthetic */ b(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.f23889c;
            if (jSONArray != null) {
                jSONObject.put("feature_names", jSONArray);
            }
            Long l10 = this.f23893g;
            if (l10 != null) {
                jSONObject.put("timestamp", l10);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.f23890d;
            if (str != null) {
                jSONObject.put("app_version", str);
            }
            Long l10 = this.f23893g;
            if (l10 != null) {
                jSONObject.put("timestamp", l10);
            }
            String str2 = this.f23891e;
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            String str3 = this.f23892f;
            if (str3 != null) {
                jSONObject.put("callstack", str3);
            }
            c cVar = this.f23888b;
            if (cVar != null) {
                jSONObject.put("type", cVar);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject e() {
        c cVar = this.f23888b;
        if (cVar != null) {
            int i10 = d.f23905b[cVar.ordinal()];
            if (i10 == 1) {
                return c();
            }
            if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                return d();
            }
        }
        return null;
    }

    public final void a() {
        f.a(this.f23887a);
    }

    public final int b(b bVar) {
        m.f(bVar, "data");
        Long l10 = this.f23893g;
        if (l10 == null) {
            return -1;
        }
        long longValue = l10.longValue();
        Long l11 = bVar.f23893g;
        if (l11 != null) {
            return (l11.longValue() > longValue ? 1 : (l11.longValue() == longValue ? 0 : -1));
        }
        return 1;
    }

    public final boolean f() {
        c cVar = this.f23888b;
        if (cVar == null) {
            return false;
        }
        int i10 = d.f23904a[cVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (!(i10 == 3 || i10 == 4 || i10 == 5) || this.f23892f == null || this.f23893g == null) {
                    return false;
                }
            } else if (this.f23892f == null || this.f23891e == null || this.f23893g == null) {
                return false;
            }
        } else if (this.f23889c == null || this.f23893g == null) {
            return false;
        }
        return true;
    }

    public final void g() {
        if (f()) {
            f.m(this.f23887a, toString());
        }
    }

    public String toString() {
        JSONObject e10 = e();
        if (e10 != null) {
            String jSONObject = e10.toString();
            m.e(jSONObject, "params.toString()");
            return jSONObject;
        }
        String jSONObject2 = new JSONObject().toString();
        m.e(jSONObject2, "JSONObject().toString()");
        return jSONObject2;
    }

    public /* synthetic */ b(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ b(Throwable th, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, cVar);
    }

    public /* synthetic */ b(JSONArray jSONArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONArray);
    }

    private b(JSONArray jSONArray) {
        this.f23888b = c.Analysis;
        this.f23893g = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.f23889c = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("analysis_log_");
        stringBuffer.append(String.valueOf(this.f23893g));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        m.e(stringBuffer2, "StringBuffer()\n         …)\n            .toString()");
        this.f23887a = stringBuffer2;
    }

    private b(Throwable th, c cVar) {
        this.f23888b = cVar;
        this.f23890d = p0.v();
        this.f23891e = f.b(th);
        this.f23892f = f.e(th);
        this.f23893g = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cVar.a());
        stringBuffer.append(String.valueOf(this.f23893g));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        m.e(stringBuffer2, "StringBuffer().append(t.…ppend(\".json\").toString()");
        this.f23887a = stringBuffer2;
    }

    private b(String str, String str2) {
        this.f23888b = c.AnrReport;
        this.f23890d = p0.v();
        this.f23891e = str;
        this.f23892f = str2;
        this.f23893g = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("anr_log_");
        stringBuffer.append(String.valueOf(this.f23893g));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        m.e(stringBuffer2, "StringBuffer()\n         …)\n            .toString()");
        this.f23887a = stringBuffer2;
    }

    private b(File file) {
        String name = file.getName();
        m.e(name, "file.name");
        this.f23887a = name;
        this.f23888b = f23886h.b(name);
        JSONObject k10 = f.k(this.f23887a, true);
        if (k10 != null) {
            this.f23893g = Long.valueOf(k10.optLong("timestamp", 0));
            this.f23890d = k10.optString("app_version", (String) null);
            this.f23891e = k10.optString("reason", (String) null);
            this.f23892f = k10.optString("callstack", (String) null);
            this.f23889c = k10.optJSONArray("feature_names");
        }
    }
}
