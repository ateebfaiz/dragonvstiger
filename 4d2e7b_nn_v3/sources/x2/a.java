package x2;

import java.io.File;

public abstract class a {
    public static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z10 = true;
        if (listFiles != null) {
            for (File b10 : listFiles) {
                z10 &= b(b10);
            }
        }
        return z10;
    }

    public static boolean b(File file) {
        if (file.isDirectory()) {
            a(file);
        }
        return file.delete();
    }

    public static void c(File file, b bVar) {
        bVar.b(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    c(file2, bVar);
                } else {
                    bVar.a(file2);
                }
            }
        }
        bVar.c(file);
    }
}
