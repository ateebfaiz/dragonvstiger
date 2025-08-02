package g1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.zing.zalo.zalosdk.common.Constant;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import u1.l;
import u1.m;
import x1.a;

public abstract class g {
    public static String a(Context context) {
        try {
            List d10 = a.d(context);
            if (d10.isEmpty()) {
                s1.a.h("CrtClient", "there are no report url");
                return null;
            }
            String j10 = u1.a.j((long) u1.a.h());
            String i10 = u1.a.i(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b');
            String b10 = p1.a.b(context);
            String str = b10 + ":" + j10;
            s1.a.a("CrtClient", "atn:" + str);
            byte[] k10 = l.k(m.g(str), m.b(b10), i10);
            String str2 = "Basic " + Base64.encodeToString(k10, 10);
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < 3; i11++) {
                arrayList.addAll(d10);
            }
            String str3 = "/get_cert?ver=" + n.E(context) + "&k=" + b10;
            for (String str4 : arrayList) {
                byte[] b11 = p.b(context, str4 + str3, str2);
                if (b11 != null) {
                    JSONObject jSONObject = new JSONObject(new String(b11, o1.a.f22951b));
                    if (jSONObject.has("cert")) {
                        jSONObject.put("cert", new String(l.i(Base64.decode(jSONObject.optString("cert"), 10), j10, i10), o1.a.f22951b));
                    }
                    return jSONObject.toString();
                }
            }
            s1.a.h("CrtClient", "get crt failed");
            return null;
        } catch (Exception e10) {
            s1.a.h("CrtClient", "get crt failed un :" + e10);
            return null;
        }
    }

    public static boolean b(Context context) {
        String a10 = a(context);
        if (TextUtils.isEmpty(a10)) {
            s1.a.h("CrtClient", "get crt failed");
            return false;
        }
        try {
            s1.a.a("CrtClient", "get crt body : " + a10);
            JSONObject jSONObject = new JSONObject(a10);
            if (jSONObject.optInt(Constant.PARAM_OAUTH_CODE, -1) == 0) {
                int i10 = jSONObject.getInt("ver");
                String string = jSONObject.getString("cert");
                n.c(context, i10);
                n.e(context, string);
                s1.a.a("CrtClient", "get crt Success ver = " + i10);
                return true;
            }
            s1.a.b("CrtClient", "get crt failed jsonObject : " + jSONObject);
            return false;
        } catch (Exception e10) {
            s1.a.b("CrtClient", "get crt failed : " + e10);
        }
    }
}
