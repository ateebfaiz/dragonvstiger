package s2;

import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import r2.a;
import r2.j;
import s2.i;
import x2.c;
import y2.l;

public class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Class f23755f = b.class;

    /* renamed from: g  reason: collision with root package name */
    static final long f23756g = TimeUnit.MINUTES.toMillis(30);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f23757a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23758b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final File f23759c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final r2.a f23760d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final f3.a f23761e = f3.f.a();

    private class a implements x2.b {

        /* renamed from: a  reason: collision with root package name */
        private final List f23762a;

        public void a(File file) {
            c m10 = b.this.u(file);
            if (m10 != null && m10.f23768a == ".cnt") {
                this.f23762a.add(new C0330b(m10.f23769b, file));
            }
        }

        public void b(File file) {
        }

        public void c(File file) {
        }

        public List d() {
            return Collections.unmodifiableList(this.f23762a);
        }

        private a() {
            this.f23762a = new ArrayList();
        }
    }

    /* renamed from: s2.b$b  reason: collision with other inner class name */
    static class C0330b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f23764a;

        /* renamed from: b  reason: collision with root package name */
        private final q2.b f23765b;

        /* renamed from: c  reason: collision with root package name */
        private long f23766c;

        /* renamed from: d  reason: collision with root package name */
        private long f23767d;

        public long a() {
            if (this.f23767d < 0) {
                this.f23767d = this.f23765b.d().lastModified();
            }
            return this.f23767d;
        }

        public q2.b b() {
            return this.f23765b;
        }

        public String getId() {
            return this.f23764a;
        }

        public long getSize() {
            if (this.f23766c < 0) {
                this.f23766c = this.f23765b.size();
            }
            return this.f23766c;
        }

        private C0330b(String str, File file) {
            l.g(file);
            this.f23764a = (String) l.g(str);
            this.f23765b = q2.b.b(file);
            this.f23766c = -1;
            this.f23767d = -1;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f23768a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23769b;

        public static c b(File file) {
            String o10;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf <= 0 || (o10 = b.s(name.substring(lastIndexOf))) == null) {
                return null;
            }
            String substring = name.substring(0, lastIndexOf);
            if (o10.equals(".tmp")) {
                int lastIndexOf2 = substring.lastIndexOf(46);
                if (lastIndexOf2 <= 0) {
                    return null;
                }
                substring = substring.substring(0, lastIndexOf2);
            }
            return new c(o10, substring);
        }

        public File a(File file) {
            return File.createTempFile(this.f23769b + com.alibaba.pdns.f.G, ".tmp", file);
        }

        public String c(String str) {
            return str + File.separator + this.f23769b + this.f23768a;
        }

        public String toString() {
            return this.f23768a + "(" + this.f23769b + ")";
        }

        private c(String str, String str2) {
            this.f23768a = str;
            this.f23769b = str2;
        }
    }

    private static class d extends IOException {
        public d(long j10, long j11) {
            super("File was not written completely. Expected: " + j10 + ", found: " + j11);
        }
    }

    class e implements i.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f23770a;

        /* renamed from: b  reason: collision with root package name */
        final File f23771b;

        public e(String str, File file) {
            this.f23770a = str;
            this.f23771b = file;
        }

        /* JADX INFO: finally extract failed */
        public void a(j jVar, Object obj) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f23771b);
                try {
                    y2.c cVar = new y2.c(fileOutputStream);
                    jVar.a(cVar);
                    cVar.flush();
                    long a10 = cVar.a();
                    fileOutputStream.close();
                    if (this.f23771b.length() != a10) {
                        throw new d(a10, this.f23771b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                b.this.f23760d.a(a.C0326a.WRITE_UPDATE_FILE_NOT_FOUND, b.f23755f, "updateResource", e10);
                throw e10;
            }
        }

        public q2.a b(Object obj) {
            return c(obj, b.this.f23761e.now());
        }

        public q2.a c(Object obj, long j10) {
            a.C0326a aVar;
            File q10 = b.this.q(this.f23770a);
            try {
                x2.c.b(this.f23771b, q10);
                if (q10.exists()) {
                    q10.setLastModified(j10);
                }
                return q2.b.b(q10);
            } catch (c.d e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    aVar = a.C0326a.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof c.C0352c) {
                    aVar = a.C0326a.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    aVar = a.C0326a.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    aVar = a.C0326a.WRITE_RENAME_FILE_OTHER;
                }
                b.this.f23760d.a(aVar, b.f23755f, "commit", e10);
                throw e10;
            }
        }

        public boolean cleanUp() {
            if (!this.f23771b.exists() || this.f23771b.delete()) {
                return true;
            }
            return false;
        }
    }

    private class f implements x2.b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23773a;

        private boolean d(File file) {
            c m10 = b.this.u(file);
            boolean z10 = false;
            if (m10 == null) {
                return false;
            }
            String str = m10.f23768a;
            if (str == ".tmp") {
                return e(file);
            }
            if (str == ".cnt") {
                z10 = true;
            }
            l.i(z10);
            return true;
        }

        private boolean e(File file) {
            if (file.lastModified() > b.this.f23761e.now() - b.f23756g) {
                return true;
            }
            return false;
        }

        public void a(File file) {
            if (!this.f23773a || !d(file)) {
                file.delete();
            }
        }

        public void b(File file) {
            if (!this.f23773a && file.equals(b.this.f23759c)) {
                this.f23773a = true;
            }
        }

        public void c(File file) {
            if (!b.this.f23757a.equals(file) && !this.f23773a) {
                file.delete();
            }
            if (this.f23773a && file.equals(b.this.f23759c)) {
                this.f23773a = false;
            }
        }

        private f() {
        }
    }

    public b(File file, int i10, r2.a aVar) {
        l.g(file);
        this.f23757a = file;
        this.f23758b = y(file, aVar);
        this.f23759c = new File(file, x(i10));
        this.f23760d = aVar;
        B();
    }

    private boolean A(String str, boolean z10) {
        File q10 = q(str);
        boolean exists = q10.exists();
        if (z10 && exists) {
            q10.setLastModified(this.f23761e.now());
        }
        return exists;
    }

    private void B() {
        if (this.f23757a.exists()) {
            if (!this.f23759c.exists()) {
                x2.a.b(this.f23757a);
            } else {
                return;
            }
        }
        try {
            x2.c.a(this.f23759c);
        } catch (c.a unused) {
            r2.a aVar = this.f23760d;
            a.C0326a aVar2 = a.C0326a.WRITE_CREATE_DIR;
            Class cls = f23755f;
            aVar.a(aVar2, cls, "version directory could not be created: " + this.f23759c, (Throwable) null);
        }
    }

    private long p(File file) {
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static String s(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    private String t(String str) {
        c cVar = new c(".cnt", str);
        return cVar.c(w(cVar.f23769b));
    }

    /* access modifiers changed from: private */
    public c u(File file) {
        c b10 = c.b(file);
        if (b10 == null) {
            return null;
        }
        if (v(b10.f23769b).equals(file.getParentFile())) {
            return b10;
        }
        return null;
    }

    private File v(String str) {
        return new File(w(str));
    }

    private String w(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        return this.f23759c + File.separator + valueOf;
    }

    static String x(int i10) {
        return String.format((Locale) null, "%s.ols%d.%d", new Object[]{"v2", 100, Integer.valueOf(i10)});
    }

    private static boolean y(File file, r2.a aVar) {
        String str;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            String file2 = externalStorageDirectory.toString();
            try {
                str = file.getCanonicalPath();
                try {
                    return str.contains(file2);
                } catch (IOException e10) {
                    e = e10;
                    a.C0326a aVar2 = a.C0326a.OTHER;
                    Class cls = f23755f;
                    aVar.a(aVar2, cls, "failed to read folder to check if external: " + str, e);
                    return false;
                }
            } catch (IOException e11) {
                e = e11;
                str = null;
                a.C0326a aVar22 = a.C0326a.OTHER;
                Class cls2 = f23755f;
                aVar.a(aVar22, cls2, "failed to read folder to check if external: " + str, e);
                return false;
            }
        } catch (Exception e12) {
            aVar.a(a.C0326a.OTHER, f23755f, "failed to get the external storage directory!", e12);
            return false;
        }
    }

    private void z(File file, String str) {
        try {
            x2.c.a(file);
        } catch (c.a e10) {
            this.f23760d.a(a.C0326a.WRITE_CREATE_DIR, f23755f, str, e10);
            throw e10;
        }
    }

    public void a() {
        x2.a.a(this.f23757a);
    }

    public long b(i.a aVar) {
        return p(((C0330b) aVar).b().d());
    }

    public void c() {
        x2.a.c(this.f23757a, new f());
    }

    public i.b d(String str, Object obj) {
        c cVar = new c(".tmp", str);
        File v10 = v(cVar.f23769b);
        if (!v10.exists()) {
            z(v10, "insert");
        }
        try {
            return new e(str, cVar.a(v10));
        } catch (IOException e10) {
            this.f23760d.a(a.C0326a.WRITE_CREATE_TEMPFILE, f23755f, "insert", e10);
            throw e10;
        }
    }

    public boolean e(String str, Object obj) {
        return A(str, true);
    }

    public boolean f(String str, Object obj) {
        return A(str, false);
    }

    public q2.a g(String str, Object obj) {
        File q10 = q(str);
        if (!q10.exists()) {
            return null;
        }
        q10.setLastModified(this.f23761e.now());
        return q2.b.c(q10);
    }

    public boolean isExternal() {
        return this.f23758b;
    }

    /* access modifiers changed from: package-private */
    public File q(String str) {
        return new File(t(str));
    }

    /* renamed from: r */
    public List h() {
        a aVar = new a();
        x2.a.c(this.f23759c, aVar);
        return aVar.d();
    }

    public long remove(String str) {
        return p(q(str));
    }
}
