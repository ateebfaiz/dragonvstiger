package e;

import i.v;
import i.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

public class n implements m {

    /* renamed from: a  reason: collision with root package name */
    public final String f21112a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21113b;

    /* renamed from: c  reason: collision with root package name */
    public final b f21114c;

    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f21115a;

        public a(String str) {
            this.f21115a = str;
        }

        public String a(String str) {
            return w.a(str, this.f21115a);
        }

        public String b(String str) {
            return w.f(str, this.f21115a);
        }
    }

    public interface b {
        String a(String str);

        String b(String str);
    }

    public n(String str, String str2, String str3) {
        this.f21112a = str;
        this.f21113b = str2;
        this.f21114c = new a(str3);
    }

    public JSONObject OooO00o() {
        JSONObject jSONObject;
        FileInputStream fileInputStream = null;
        try {
            File file = new File(this.f21112a, this.f21113b);
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(this.f21114c.a(v.d(fileInputStream2)));
                } catch (Exception unused) {
                    jSONObject = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    v.f(fileInputStream);
                    throw th;
                }
                fileInputStream = fileInputStream2;
                v.f(fileInputStream);
                return jSONObject;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
            v.f(fileInputStream);
            throw th;
        }
        jSONObject = null;
        v.f(fileInputStream);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(new File(this.f21112a, this.f21113b));
                try {
                    fileWriter2.write(this.f21114c.b(jSONObject.toString()));
                    fileWriter2.flush();
                    v.f(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    v.f(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    v.f(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
                v.f(fileWriter);
            } catch (Throwable th2) {
                th = th2;
                v.f(fileWriter);
                throw th;
            }
        }
    }
}
