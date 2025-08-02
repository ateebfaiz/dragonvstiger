package l9;

import k9.i;
import n9.a;
import org.json.JSONObject;

public class g extends d {
    /* access modifiers changed from: protected */
    /* renamed from: c */
    public i b(JSONObject jSONObject) {
        return new i.b().k(jSONObject.getString("issuer")).h(jSONObject.getString("authorization_endpoint")).o(jSONObject.getString("token_endpoint")).l(jSONObject.getString("jwks_uri")).m(a.a(jSONObject.getJSONArray("response_types_supported"))).n(a.a(jSONObject.getJSONArray("subject_types_supported"))).j(a.a(jSONObject.getJSONArray("id_token_signing_alg_values_supported"))).i();
    }
}
