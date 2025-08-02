package tb;

import com.alibaba.pdns.f;
import java.io.File;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import kotlin.text.j;

class l extends k {
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        tb.c.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
        tb.c.a(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File k(java.io.File r6, java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.f(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.m.f(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0071
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x0027
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            tb.e r8 = new tb.e
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0027:
            tb.e r8 = new tb.e
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x002f:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x0044
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x003c
            goto L_0x0061
        L_0x003c:
            tb.f r8 = new tb.f
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0044:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x004d
            r8.mkdirs()
        L_0x004d:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0062 }
            r6.<init>(r7)     // Catch:{ all -> 0x0062 }
            tb.b.a(r8, r6, r9)     // Catch:{ all -> 0x0064 }
            r9 = 0
            tb.c.a(r6, r9)     // Catch:{ all -> 0x0062 }
            tb.c.a(r8, r9)
        L_0x0061:
            return r7
        L_0x0062:
            r6 = move-exception
            goto L_0x006b
        L_0x0064:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r9 = move-exception
            tb.c.a(r6, r7)     // Catch:{ all -> 0x0062 }
            throw r9     // Catch:{ all -> 0x0062 }
        L_0x006b:
            throw r6     // Catch:{ all -> 0x006c }
        L_0x006c:
            r7 = move-exception
            tb.c.a(r8, r6)
            throw r7
        L_0x0071:
            tb.n r7 = new tb.n
            r4 = 2
            r5 = 0
            r2 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.l.k(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    public static /* synthetic */ File l(File file, File file2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 8192;
        }
        return k(file, file2, z10, i10);
    }

    public static boolean m(File file) {
        m.f(file, "<this>");
        Iterator it = k.j(file).iterator();
        while (true) {
            boolean z10 = true;
            while (true) {
                if (!it.hasNext()) {
                    return z10;
                }
                File file2 = (File) it.next();
                if (file2.delete() || !file2.exists()) {
                    if (z10) {
                    }
                }
                z10 = false;
            }
        }
    }

    public static String n(File file) {
        m.f(file, "<this>");
        String name = file.getName();
        m.e(name, "getName(...)");
        return j.O0(name, f.G, (String) null, 2, (Object) null);
    }
}
