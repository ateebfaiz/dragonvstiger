package q;

import com.mah.sdk.MahProxy;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q.a;
import w.d;

public class i extends d {

    /* renamed from: g  reason: collision with root package name */
    public static final String f23171g = d.f("");

    public i(int i10, int i11, String str, String str2, String str3) {
        super(i10, i11, str, str2, str3, System.currentTimeMillis());
    }

    public static String b(int i10, int i11, List list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a.C0320a aVar = (a.C0320a) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", aVar.f23133a);
                jSONObject2.put("startTime", aVar.f23134b);
                jSONObject2.put("endTime", aVar.f23135c);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("startType", i10);
            jSONObject.put("serviceId", i11);
            jSONObject.put("costTimeList", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static d c(String str, boolean z10, int i10, List list) {
        return new i(11, 0, str, MahProxy.getVersion(), b(z10 ? 1 : 0, i10, list));
    }
}
