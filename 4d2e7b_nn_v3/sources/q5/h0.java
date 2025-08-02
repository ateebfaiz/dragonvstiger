package q5;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap f23330a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f23331b = new h0();

    private h0() {
    }

    public static final JSONObject a(String str) {
        m.f(str, "accessToken");
        return (JSONObject) f23330a.get(str);
    }

    public static final void b(String str, JSONObject jSONObject) {
        m.f(str, "key");
        m.f(jSONObject, "value");
        f23330a.put(str, jSONObject);
    }
}
