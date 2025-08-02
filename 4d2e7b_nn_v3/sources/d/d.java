package d;

import android.os.Environment;
import java.io.File;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final g f20999a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21000b;

    public d(g gVar, String str) {
        this.f20999a = gVar;
        this.f21000b = str;
    }

    public File a() {
        File file = null;
        if (d()) {
            file = this.f20999a.a((String) null);
        }
        if (file != null) {
            file = new File(file, this.f21000b);
        }
        return b(file);
    }

    public final File b(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public File c() {
        File c10 = this.f20999a.c();
        if (c10 != null) {
            c10 = new File(c10, this.f21000b);
        }
        return b(c10);
    }

    public final boolean d() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        return true;
    }
}
