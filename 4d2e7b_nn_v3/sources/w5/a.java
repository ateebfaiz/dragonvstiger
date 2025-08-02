package w5;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import s5.f;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0350a f24614d = new C0350a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24615a;

    /* renamed from: b  reason: collision with root package name */
    private String f24616b;

    /* renamed from: c  reason: collision with root package name */
    private Long f24617c;

    /* renamed from: w5.a$a  reason: collision with other inner class name */
    public static final class C0350a {
        private C0350a() {
        }

        public /* synthetic */ C0350a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String str) {
        this.f24617c = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.f24616b = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("error_log_");
        Long l10 = this.f24617c;
        if (l10 != null) {
            stringBuffer.append(l10.longValue());
            stringBuffer.append(".json");
            String stringBuffer2 = stringBuffer.toString();
            m.e(stringBuffer2, "StringBuffer()\n         …)\n            .toString()");
            this.f24615a = stringBuffer2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void a() {
        f.a(this.f24615a);
    }

    public final int b(a aVar) {
        m.f(aVar, "data");
        Long l10 = this.f24617c;
        if (l10 == null) {
            return -1;
        }
        long longValue = l10.longValue();
        Long l11 = aVar.f24617c;
        if (l11 != null) {
            return (l11.longValue() > longValue ? 1 : (l11.longValue() == longValue ? 0 : -1));
        }
        return 1;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l10 = this.f24617c;
            if (l10 != null) {
                jSONObject.put("timestamp", l10.longValue());
            }
            jSONObject.put("error_message", this.f24616b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean d() {
        if (this.f24616b == null || this.f24617c == null) {
            return false;
        }
        return true;
    }

    public final void e() {
        if (d()) {
            f.m(this.f24615a, toString());
        }
    }

    public String toString() {
        JSONObject c10 = c();
        if (c10 == null) {
            return super.toString();
        }
        String jSONObject = c10.toString();
        m.e(jSONObject, "params.toString()");
        return jSONObject;
    }

    public a(File file) {
        m.f(file, "file");
        String name = file.getName();
        m.e(name, "file.name");
        this.f24615a = name;
        JSONObject k10 = f.k(name, true);
        if (k10 != null) {
            this.f24617c = Long.valueOf(k10.optLong("timestamp", 0));
            this.f24616b = k10.optString("error_message", (String) null);
        }
    }
}
