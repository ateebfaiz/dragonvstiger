package l9;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.linecorp.linesdk.LineIdToken;
import com.zing.zalo.zalosdk.common.Constant;
import i9.k;
import java.util.Collections;
import k9.f;
import k9.h;
import k9.i;
import k9.j;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: f  reason: collision with root package name */
    private static final m9.c f12752f = new c();

    /* renamed from: g  reason: collision with root package name */
    private static final m9.c f12753g = new C0151e();

    /* renamed from: h  reason: collision with root package name */
    private static final m9.c f12754h = new d();

    /* renamed from: i  reason: collision with root package name */
    private static final m9.c f12755i = new f();

    /* renamed from: j  reason: collision with root package name */
    private static final m9.c f12756j = new g();

    /* renamed from: k  reason: collision with root package name */
    private static final m9.c f12757k = new c();

    /* renamed from: a  reason: collision with root package name */
    private final m9.c f12758a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final h f12759b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f12760c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f12761d;

    /* renamed from: e  reason: collision with root package name */
    private final m9.a f12762e;

    private class b extends d {
        private b() {
        }

        private LineIdToken c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a.c(str, e.this.f12759b);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public f b(JSONObject jSONObject) {
            String string = jSONObject.getString("token_type");
            if ("Bearer".equals(string)) {
                try {
                    return new f(new k9.e(jSONObject.getString("access_token"), 1000 * jSONObject.getLong("expires_in"), System.currentTimeMillis(), jSONObject.getString("refresh_token")), k.e(jSONObject.getString("scope")), c(jSONObject.optString("id_token")));
                } catch (Exception e10) {
                    throw new JSONException(e10.getMessage());
                }
            } else {
                throw new JSONException("Illegal token type. token_type=" + string);
            }
        }
    }

    private static class c extends d {
        private c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public h b(JSONObject jSONObject) {
            return new h(jSONObject.getString("otpId"), jSONObject.getString("otp"));
        }
    }

    private static class d extends d {
        private d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public j b(JSONObject jSONObject) {
            String string = jSONObject.getString("token_type");
            if ("Bearer".equals(string)) {
                return new j(jSONObject.getString("access_token"), 1000 * jSONObject.getLong("expires_in"), jSONObject.getString("refresh_token"), k.e(jSONObject.getString("scope")));
            }
            throw new JSONException("Illegal token type. token_type=" + string);
        }
    }

    /* renamed from: l9.e$e  reason: collision with other inner class name */
    private static class C0151e extends d {
        private C0151e() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public k9.b b(JSONObject jSONObject) {
            return new k9.b(jSONObject.getString("client_id"), jSONObject.getLong("expires_in") * 1000, k.e(jSONObject.getString("scope")));
        }
    }

    public e(Context context, Uri uri, Uri uri2) {
        this(uri, uri2, new m9.a(context, "5.3.1"));
    }

    public i9.c b() {
        i9.c d10 = d();
        if (!d10.g()) {
            return i9.c.a(d10.d(), d10.c());
        }
        i9.c b10 = this.f12762e.b(Uri.parse(((i) d10.e()).b()), Collections.emptyMap(), Collections.emptyMap(), f12757k);
        if (!b10.g()) {
            Log.e("LineAuthApiClient", "getJWKSet failed: " + b10);
        }
        return b10;
    }

    public i9.c c(String str) {
        return this.f12762e.j(n9.d.e(this.f12761d, "oauth2/v2.1", "otp"), Collections.emptyMap(), n9.d.d("client_id", str), f12752f);
    }

    public i9.c d() {
        i9.c b10 = this.f12762e.b(n9.d.e(this.f12760c, new String[0]), Collections.emptyMap(), Collections.emptyMap(), f12756j);
        if (!b10.g()) {
            Log.e("LineAuthApiClient", "getOpenIdDiscoveryDocument failed: " + b10);
        }
        return b10;
    }

    public i9.c e(String str, String str2, h hVar, String str3) {
        return this.f12762e.j(n9.d.e(this.f12761d, "oauth2/v2.1", "token"), Collections.emptyMap(), n9.d.d("grant_type", "authorization_code", Constant.PARAM_OAUTH_CODE, str2, "redirect_uri", str3, "client_id", str, "otp", hVar.b(), "id_token_key_type", k9.d.JWK.name(), "client_version", "LINE SDK Android v5.3.1"), this.f12758a);
    }

    public i9.c f(String str, k9.e eVar) {
        return this.f12762e.j(n9.d.e(this.f12761d, "oauth2/v2.1", "token"), Collections.emptyMap(), n9.d.d("grant_type", "refresh_token", "refresh_token", eVar.d(), "client_id", str), f12754h);
    }

    e(Uri uri, Uri uri2, m9.a aVar) {
        this.f12758a = new b();
        this.f12759b = new h(this);
        this.f12760c = uri;
        this.f12761d = uri2;
        this.f12762e = aVar;
    }
}
