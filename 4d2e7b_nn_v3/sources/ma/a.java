package ma;

import com.onesignal.c2;
import com.onesignal.g3;
import kotlin.jvm.internal.m;
import na.b;
import na.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private c f12814a;

    /* renamed from: b  reason: collision with root package name */
    private c2 f12815b;

    /* renamed from: c  reason: collision with root package name */
    private g3 f12816c;

    /* renamed from: d  reason: collision with root package name */
    private c f12817d;

    /* renamed from: e  reason: collision with root package name */
    private JSONArray f12818e;

    /* renamed from: f  reason: collision with root package name */
    private String f12819f;

    public a(c cVar, c2 c2Var, g3 g3Var) {
        m.f(cVar, "dataRepository");
        m.f(c2Var, "logger");
        m.f(g3Var, "timeProvider");
        this.f12814a = cVar;
        this.f12815b = c2Var;
        this.f12816c = g3Var;
    }

    private final boolean q() {
        return this.f12814a.m();
    }

    private final boolean r() {
        return this.f12814a.n();
    }

    private final boolean s() {
        return this.f12814a.o();
    }

    public abstract void a(JSONObject jSONObject, na.a aVar);

    public abstract void b();

    public abstract int c();

    public abstract b d();

    public final na.a e() {
        b d10 = d();
        c cVar = c.DISABLED;
        na.a aVar = new na.a(d10, cVar, (JSONArray) null);
        if (this.f12817d == null) {
            p();
        }
        c cVar2 = this.f12817d;
        if (cVar2 != null) {
            cVar = cVar2;
        }
        if (cVar.c()) {
            if (q()) {
                aVar.e(new JSONArray().put(g()));
                aVar.f(c.DIRECT);
            }
        } else if (cVar.e()) {
            if (r()) {
                aVar.e(j());
                aVar.f(c.INDIRECT);
            }
        } else if (s()) {
            aVar.f(c.UNATTRIBUTED);
        }
        return aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !m.b(getClass(), obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f12817d != aVar.f12817d || !m.b(aVar.h(), h())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final c f() {
        return this.f12814a;
    }

    public final String g() {
        return this.f12819f;
    }

    public abstract String h();

    public int hashCode() {
        int i10;
        c cVar = this.f12817d;
        if (cVar != null) {
            i10 = cVar.hashCode();
        } else {
            i10 = 0;
        }
        return (i10 * 31) + h().hashCode();
    }

    public abstract int i();

    public final JSONArray j() {
        return this.f12818e;
    }

    public final c k() {
        return this.f12817d;
    }

    public abstract JSONArray l();

    public abstract JSONArray m(String str);

    public final JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray l10 = l();
            this.f12815b.b(m.n("OneSignal ChannelTracker getLastReceivedIds lastChannelObjectReceived: ", l10));
            long i10 = ((long) (i() * 60)) * 1000;
            long b10 = this.f12816c.b();
            int length = l10.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject jSONObject = l10.getJSONObject(i11);
                    if (b10 - jSONObject.getLong("time") <= i10) {
                        jSONArray.put(jSONObject.getString(h()));
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
        } catch (JSONException e10) {
            this.f12815b.a("Generating tracker getLastReceivedIds JSONObject ", e10);
        }
        return jSONArray;
    }

    public final c2 o() {
        return this.f12815b;
    }

    public abstract void p();

    public final void t() {
        int i10;
        c cVar;
        this.f12819f = null;
        JSONArray n10 = n();
        this.f12818e = n10;
        if (n10 == null) {
            i10 = 0;
        } else {
            i10 = n10.length();
        }
        if (i10 > 0) {
            cVar = c.INDIRECT;
        } else {
            cVar = c.UNATTRIBUTED;
        }
        this.f12817d = cVar;
        b();
        c2 c2Var = this.f12815b;
        c2Var.b("OneSignal OSChannelTracker resetAndInitInfluence: " + h() + " finish with influenceType: " + this.f12817d);
    }

    public String toString() {
        return "OSChannelTracker{tag=" + h() + ", influenceType=" + this.f12817d + ", indirectIds=" + this.f12818e + ", directId=" + this.f12819f + '}';
    }

    public abstract void u(JSONArray jSONArray);

    public final void v(String str) {
        c2 c2Var = this.f12815b;
        c2Var.b("OneSignal OSChannelTracker for: " + h() + " saveLastId: " + str);
        if (str != null && str.length() != 0) {
            JSONArray m10 = m(str);
            c2 c2Var2 = this.f12815b;
            c2Var2.b("OneSignal OSChannelTracker for: " + h() + " saveLastId with lastChannelObjectsReceived: " + m10);
            try {
                m10.put(new JSONObject().put(h(), str).put("time", this.f12816c.b()));
                if (m10.length() > c()) {
                    int length = m10.length() - c();
                    JSONArray jSONArray = new JSONArray();
                    int length2 = m10.length();
                    if (length < length2) {
                        while (true) {
                            int i10 = length + 1;
                            try {
                                jSONArray.put(m10.get(length));
                            } catch (JSONException e10) {
                                this.f12815b.a("Generating tracker lastChannelObjectsReceived get JSONObject ", e10);
                            }
                            if (i10 >= length2) {
                                break;
                            }
                            length = i10;
                        }
                    }
                    m10 = jSONArray;
                }
                c2 c2Var3 = this.f12815b;
                c2Var3.b("OneSignal OSChannelTracker for: " + h() + " with channelObjectToSave: " + m10);
                u(m10);
            } catch (JSONException e11) {
                this.f12815b.a("Generating tracker newInfluenceId JSONObject ", e11);
            }
        }
    }

    public final void w(String str) {
        this.f12819f = str;
    }

    public final void x(JSONArray jSONArray) {
        this.f12818e = jSONArray;
    }

    public final void y(c cVar) {
        this.f12817d = cVar;
    }
}
