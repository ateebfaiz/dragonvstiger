package i;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final File f22009a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f22010b;

    public k(Context context) {
        this.f22010b = context;
        this.f22009a = new File(context.getFilesDir(), "mah_installation");
    }

    public final String a(File file) {
        BufferedReader bufferedReader;
        if (file.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e10) {
                e = e10;
                try {
                    e.getMessage();
                    v.f(bufferedReader2);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    v.f(bufferedReader);
                    throw th;
                }
            }
            try {
                String string = new JSONObject(bufferedReader.readLine()).getString("uuid");
                v.f(bufferedReader);
                return string;
            } catch (Exception e11) {
                e = e11;
                bufferedReader2 = bufferedReader;
                e.getMessage();
                v.f(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                v.f(bufferedReader);
                throw th;
            }
        }
        return "";
    }

    public final void b(String str) {
        BufferedWriter bufferedWriter;
        IOException e10;
        JSONException e11;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uuid", str);
            bufferedWriter = new BufferedWriter(new FileWriter(this.f22009a));
            try {
                bufferedWriter.write(jSONObject.toString());
                bufferedWriter.flush();
                v.f(bufferedWriter);
            } catch (IOException e12) {
                e10 = e12;
                e10.getMessage();
                v.f(bufferedWriter);
            } catch (JSONException e13) {
                e11 = e13;
                e11.getMessage();
                v.f(bufferedWriter);
            }
        } catch (IOException e14) {
            e10 = e14;
            bufferedWriter = null;
            e10.getMessage();
            v.f(bufferedWriter);
        } catch (JSONException e15) {
            e11 = e15;
            bufferedWriter = null;
            e11.getMessage();
            v.f(bufferedWriter);
        } catch (Throwable th) {
            th = th;
            v.f(bufferedWriter);
            throw th;
        }
    }

    public String c() {
        String d10 = d();
        if (TextUtils.isEmpty(d10)) {
            d10 = a(new File(this.f22010b.getFilesDir(), "uuid.cfg"));
            if (TextUtils.isEmpty(d10)) {
                d10 = UUID.randomUUID().toString();
            }
            b(d10);
        }
        return d10;
    }

    public String d() {
        return a(this.f22009a);
    }
}
