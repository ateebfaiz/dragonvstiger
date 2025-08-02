package o;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;
import w.d;

public class h {

    /* renamed from: d  reason: collision with root package name */
    public static final String f22874d = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final String f22875a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22876b;

    /* renamed from: c  reason: collision with root package name */
    public final String f22877c;

    public h(String str, String str2, String str3) {
        this.f22875a = str;
        this.f22876b = str2;
        this.f22877c = str3 == null ? "" : str3;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        String obj = stringWriter.toString();
        if (obj.length() > 20480) {
            return obj.substring(0, 20480);
        }
        return obj;
    }

    public static h b(JSONObject jSONObject) {
        return new h(jSONObject.optString("summary"), jSONObject.optString("stack", ""), jSONObject.optString("extra", ""));
    }

    public static String d(Throwable th) {
        if (th == null) {
            return "";
        }
        String name = th.getClass().getName();
        if (th.getMessage() == null) {
            return name;
        }
        return name + ": " + th.getMessage();
    }

    public static h e(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("\n");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                str2 = str;
                str = substring;
                return new h(str, str2, "");
            }
        } else {
            str = "";
        }
        str2 = str;
        return new h(str, str2, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("summary", this.f22875a);
        if (!TextUtils.isEmpty(this.f22877c)) {
            jSONObject.put("extra", this.f22877c);
        }
        jSONObject.put("stack", this.f22876b);
        return jSONObject;
    }
}
