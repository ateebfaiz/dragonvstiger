package q;

import com.mah.sdk.MahProxy;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import w.d;

public class c extends d {

    /* renamed from: g  reason: collision with root package name */
    public static final String f23136g = d.f("");

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f23137a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23138b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23139c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23140d;

        public a(boolean z10, boolean z11, String str, boolean z12) {
            this.f23137a = z10;
            this.f23138b = z11;
            this.f23139c = str;
            this.f23140d = z12;
        }

        public String a() {
            return String.format(Locale.US, "isRoot: %b, isEmulator: %b, cpuArch: %s, isDebug: %b", new Object[]{Boolean.valueOf(this.f23137a), Boolean.valueOf(this.f23138b), this.f23139c, Boolean.valueOf(this.f23140d)});
        }
    }

    public c(int i10, int i11, String str, String str2, String str3) {
        super(i10, i11, str, str2, str3, System.currentTimeMillis());
    }

    public static String b(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isRoot", aVar.f23137a);
            jSONObject.put("isSimulator", aVar.f23138b);
            jSONObject.put("cpuArch", aVar.f23139c);
            jSONObject.put("isDebug", aVar.f23140d);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static d c(String str, a aVar) {
        return new c(10, 2, str, MahProxy.getVersion(), b(aVar));
    }
}
