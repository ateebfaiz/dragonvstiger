package s2;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import r2.a;
import s2.i;
import x2.c;
import y2.l;
import y2.o;

public class k implements i {

    /* renamed from: f  reason: collision with root package name */
    private static final Class f23828f = k.class;

    /* renamed from: a  reason: collision with root package name */
    private final int f23829a;

    /* renamed from: b  reason: collision with root package name */
    private final o f23830b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23831c;

    /* renamed from: d  reason: collision with root package name */
    private final r2.a f23832d;

    /* renamed from: e  reason: collision with root package name */
    volatile a f23833e = new a((File) null, (i) null);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final i f23834a;

        /* renamed from: b  reason: collision with root package name */
        public final File f23835b;

        a(File file, i iVar) {
            this.f23834a = iVar;
            this.f23835b = file;
        }
    }

    public k(int i10, o oVar, String str, r2.a aVar) {
        this.f23829a = i10;
        this.f23832d = aVar;
        this.f23830b = oVar;
        this.f23831c = str;
    }

    private void j() {
        File file = new File((File) this.f23830b.get(), this.f23831c);
        i(file);
        this.f23833e = new a(file, new b(file, this.f23829a, this.f23832d));
    }

    private boolean m() {
        File file;
        a aVar = this.f23833e;
        if (aVar.f23834a == null || (file = aVar.f23835b) == null || !file.exists()) {
            return true;
        }
        return false;
    }

    public void a() {
        l().a();
    }

    public long b(i.a aVar) {
        return l().b(aVar);
    }

    public void c() {
        try {
            l().c();
        } catch (IOException e10) {
            z2.a.g(f23828f, "purgeUnexpectedResources", e10);
        }
    }

    public i.b d(String str, Object obj) {
        return l().d(str, obj);
    }

    public boolean e(String str, Object obj) {
        return l().e(str, obj);
    }

    public boolean f(String str, Object obj) {
        return l().f(str, obj);
    }

    public q2.a g(String str, Object obj) {
        return l().g(str, obj);
    }

    public Collection h() {
        return l().h();
    }

    /* access modifiers changed from: package-private */
    public void i(File file) {
        try {
            c.a(file);
            z2.a.a(f23828f, "Created cache directory %s", file.getAbsolutePath());
        } catch (c.a e10) {
            this.f23832d.a(a.C0326a.WRITE_CREATE_DIR, f23828f, "createRootDirectoryIfNecessary", e10);
            throw e10;
        }
    }

    public boolean isExternal() {
        try {
            return l().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f23833e.f23834a != null && this.f23833e.f23835b != null) {
            x2.a.b(this.f23833e.f23835b);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i l() {
        try {
            if (m()) {
                k();
                j();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (i) l.g(this.f23833e.f23834a);
    }

    public long remove(String str) {
        return l().remove(str);
    }
}
