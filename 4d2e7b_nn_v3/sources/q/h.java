package q;

import i.v;
import java.io.File;
import java.io.FileOutputStream;
import w.d;

public class h {

    /* renamed from: b  reason: collision with root package name */
    public static final String f23169b = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final File f23170a;

    public h(File file) {
        this.f23170a = file;
    }

    public final void a(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f23170a, true);
            try {
                fileOutputStream2.write("\n".getBytes());
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                v.f(fileOutputStream2);
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                v.f(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                v.f(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
            v.f(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            v.f(fileOutputStream);
            throw th;
        }
    }

    public void b(d dVar) {
        a(dVar.a());
    }
}
