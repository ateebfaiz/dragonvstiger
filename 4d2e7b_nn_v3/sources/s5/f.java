package s5;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import kotlin.text.h;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f23910a = new f();

    static final class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23911a = new a();

        a() {
        }

        public final boolean accept(File file, String str) {
            m.e(str, "name");
            b0 b0Var = b0.f709a;
            String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"anr_log_"}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            return new h(format).c(str);
        }
    }

    static final class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final b f23912a = new b();

        b() {
        }

        public final boolean accept(File file, String str) {
            m.e(str, "name");
            b0 b0Var = b0.f709a;
            String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"analysis_log_"}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            return new h(format).c(str);
        }
    }

    static final class c implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final c f23913a = new c();

        c() {
        }

        public final boolean accept(File file, String str) {
            m.e(str, "name");
            b0 b0Var = b0.f709a;
            String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{"crash_log_", "shield_log_", "thread_check_log_"}, 3));
            m.e(format, "java.lang.String.format(format, *args)");
            return new h(format).c(str);
        }
    }

    private f() {
    }

    public static final boolean a(String str) {
        File c10 = c();
        if (c10 == null || str == null) {
            return false;
        }
        return new File(c10, str).delete();
    }

    public static final String b(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    public static final File c() {
        File file = new File(o.f().getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String d(Thread thread) {
        m.f(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTrace) {
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }

    public static final String e(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static final boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                m.e(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                m.e(className, "element.className");
                if (j.F(className, "com.facebook", false, 2, (Object) null)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static final boolean g(Thread thread) {
        StackTraceElement[] stackTrace;
        if (!(thread == null || (stackTrace = thread.getStackTrace()) == null)) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                m.e(stackTraceElement, "element");
                String className = stackTraceElement.getClassName();
                m.e(className, "element.className");
                if (j.F(className, "com.facebook", false, 2, (Object) null)) {
                    String className2 = stackTraceElement.getClassName();
                    m.e(className2, "element.className");
                    if (!j.F(className2, "com.facebook.appevents.codeless", false, 2, (Object) null)) {
                        String className3 = stackTraceElement.getClassName();
                        m.e(className3, "element.className");
                        if (!j.F(className3, "com.facebook.appevents.suggestedevents", false, 2, (Object) null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    m.e(methodName, "element.methodName");
                    if (!j.F(methodName, "onClick", false, 2, (Object) null)) {
                        String methodName2 = stackTraceElement.getMethodName();
                        m.e(methodName2, "element.methodName");
                        if (!j.F(methodName2, "onItemClick", false, 2, (Object) null)) {
                            String methodName3 = stackTraceElement.getMethodName();
                            m.e(methodName3, "element.methodName");
                            if (!j.F(methodName3, "onTouch", false, 2, (Object) null)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static final File[] h() {
        File c10 = c();
        if (c10 == null) {
            return new File[0];
        }
        File[] listFiles = c10.listFiles(a.f23911a);
        if (listFiles != null) {
            return listFiles;
        }
        return new File[0];
    }

    public static final File[] i() {
        File c10 = c();
        if (c10 == null) {
            return new File[0];
        }
        File[] listFiles = c10.listFiles(b.f23912a);
        if (listFiles != null) {
            return listFiles;
        }
        return new File[0];
    }

    public static final File[] j() {
        File c10 = c();
        if (c10 == null) {
            return new File[0];
        }
        File[] listFiles = c10.listFiles(c.f23913a);
        if (listFiles != null) {
            return listFiles;
        }
        return new File[0];
    }

    public static final JSONObject k(String str, boolean z10) {
        File c10 = c();
        if (!(c10 == null || str == null)) {
            try {
                return new JSONObject(p0.p0(new FileInputStream(new File(c10, str))));
            } catch (Exception unused) {
                if (z10) {
                    a(str);
                }
            }
        }
        return null;
    }

    public static final void l(String str, JSONArray jSONArray, GraphRequest.b bVar) {
        m.f(jSONArray, "reports");
        if (jSONArray.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, jSONArray.toString());
                JSONObject A = p0.A();
                if (A != null) {
                    Iterator<String> keys = A.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, A.get(next));
                    }
                }
                GraphRequest.c cVar = GraphRequest.f19541t;
                b0 b0Var = b0.f709a;
                String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{o.g()}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                cVar.x((AccessToken) null, format, jSONObject, bVar).j();
            } catch (JSONException unused) {
            }
        }
    }

    public static final void m(String str, String str2) {
        File c10 = c();
        if (c10 != null && str != null && str2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(c10, str));
                byte[] bytes = str2.getBytes(d.f797b);
                m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
