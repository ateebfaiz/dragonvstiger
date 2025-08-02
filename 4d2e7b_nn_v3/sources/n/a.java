package n;

import d.d;
import d.g;
import i.c;
import java.io.File;
import java.io.IOException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public File f22626a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22627b = false;

    public a(g gVar) {
        b(gVar);
    }

    public void a() {
        if (this.f22627b) {
            c.f(this.f22626a);
        }
    }

    public final void b(g gVar) {
        File a10 = new d(gVar, "abnormalAccess").a();
        if (a10 == null) {
            String str = b.f22628m;
            return;
        }
        File file = new File(a10, "ABNAccessLogCache.log");
        this.f22626a = file;
        try {
            file.createNewFile();
            String str2 = b.f22628m;
            this.f22626a.getAbsolutePath();
            this.f22627b = true;
        } catch (IOException unused) {
            String str3 = b.f22628m;
        }
    }

    public void c(String str) {
        if (this.f22627b) {
            c.b(this.f22626a, str);
        }
    }

    public String d() {
        if (!this.f22627b) {
            return null;
        }
        try {
            return c.s(this.f22626a);
        } catch (IOException unused) {
            String str = b.f22628m;
            return null;
        }
    }
}
