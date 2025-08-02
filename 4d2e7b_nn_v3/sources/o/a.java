package o;

import android.text.TextUtils;
import com.mah.ndk.MahxServer;
import com.mah.sdk.MahProxy;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import w.d;

public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f22834i = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final String f22835a;

    /* renamed from: b  reason: collision with root package name */
    public final long f22836b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f22837c;

    /* renamed from: d  reason: collision with root package name */
    public final h f22838d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22839e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22840f;

    /* renamed from: g  reason: collision with root package name */
    public final String f22841g;

    /* renamed from: h  reason: collision with root package name */
    public final String f22842h;

    public a(String str, long j10, boolean z10, String str2, boolean z11, h hVar, boolean z12, String str3) {
        this.f22835a = str;
        this.f22836b = j10;
        this.f22839e = z10;
        this.f22841g = str2;
        this.f22837c = z11;
        this.f22838d = hVar;
        this.f22840f = z12;
        this.f22842h = str3;
    }

    public static Throwable a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null) {
            return th;
        }
        return a(cause);
    }

    public static a b(String str) {
        h hVar;
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("uuid");
        long optLong = jSONObject.optLong("timestamp");
        boolean optBoolean = jSONObject.optBoolean("isNDK", false);
        String optString2 = jSONObject.optString("sdkVersion", "");
        String optString3 = jSONObject.optString("appVersion", "");
        boolean optBoolean2 = jSONObject.optBoolean("isSdkCrash", false);
        JSONObject optJSONObject = jSONObject.optJSONObject("exception");
        if (optJSONObject != null) {
            hVar = h.b(optJSONObject);
        } else {
            hVar = null;
        }
        return new a(optString, optLong, optBoolean, optString2, optBoolean2, hVar, false, optString3);
    }

    public static a c(String str, String str2) {
        h e10 = h.e(str);
        return new a(UUID.randomUUID().toString(), System.currentTimeMillis(), true, MahProxy.getVersion(), i(e10.f22876b), e10, false, str2);
    }

    public static a d(Throwable th, boolean z10, String str, String str2) {
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis();
        Throwable cause = th.getCause();
        if (cause != null) {
            th = a(cause);
        }
        h hVar = new h(h.d(th), h.a(th), str);
        return new a(uuid, currentTimeMillis, false, MahProxy.getVersion(), i(hVar.f22876b), hVar, z10, str2);
    }

    public static boolean g(String str) {
        if (!str.contains("module=") || (!str.contains("/mahx") && !str.contains(MahxServer.OooOoo0))) {
            return false;
        }
        return true;
    }

    public static boolean h(String str) {
        for (String g10 : str.split("\n")) {
            if (g(g10)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("com.mah.sdk")) {
            return true;
        }
        return h(str);
    }

    public boolean e() {
        if (this.f22838d == null || TextUtils.isEmpty(this.f22841g) || TextUtils.isEmpty(this.f22842h)) {
            return false;
        }
        return true;
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.f22835a);
            jSONObject.put("timestamp", this.f22836b);
            jSONObject.put("isSdkCrash", this.f22837c);
            jSONObject.put("isNDK", this.f22839e);
            jSONObject.put("sdkVersion", this.f22841g);
            jSONObject.put("appVersion", this.f22842h);
            h hVar = this.f22838d;
            if (hVar != null) {
                jSONObject.put("exception", hVar.c());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
