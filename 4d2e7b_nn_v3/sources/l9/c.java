package l9;

import io.jsonwebtoken.JwsHeader;
import java.util.ArrayList;
import k9.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends d {
    /* access modifiers changed from: protected */
    /* renamed from: c */
    public g b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("keys");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            arrayList.add(new g.c.a().l(jSONObject2.getString("kty")).h(jSONObject2.getString(JwsHeader.ALGORITHM)).m(jSONObject2.getString("use")).k(jSONObject2.getString(JwsHeader.KEY_ID)).j(jSONObject2.getString("crv")).n(jSONObject2.getString("x")).o(jSONObject2.getString("y")).i());
        }
        return new g.b().c(arrayList).b();
    }
}
