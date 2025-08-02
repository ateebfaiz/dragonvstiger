package x2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import y2.l;

public abstract class c {

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    /* renamed from: x2.c$c  reason: collision with other inner class name */
    public static class C0352c extends FileNotFoundException {
        public C0352c(String str) {
            super(str);
        }
    }

    public static class d extends IOException {
        public d(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static void a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.delete()) {
                    throw new a(file.getAbsolutePath(), new b(file.getAbsolutePath()));
                }
            } else {
                return;
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new a(file.getAbsolutePath());
        }
    }

    public static void b(File file, File file2) {
        Throwable th;
        l.g(file);
        l.g(file2);
        file2.delete();
        if (!file.renameTo(file2)) {
            if (file2.exists()) {
                th = new b(file2.getAbsolutePath());
            } else if (!file.getParentFile().exists()) {
                th = new C0352c(file.getAbsolutePath());
            } else if (!file.exists()) {
                th = new FileNotFoundException(file.getAbsolutePath());
            } else {
                th = null;
            }
            throw new d("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath(), th);
        }
    }
}
