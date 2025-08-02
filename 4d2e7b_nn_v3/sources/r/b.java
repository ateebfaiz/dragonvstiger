package r;

import i.c;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final File f23560a;

    /* renamed from: b  reason: collision with root package name */
    public final File f23561b;

    /* renamed from: c  reason: collision with root package name */
    public final File f23562c;

    public b(File file, File file2, File file3) {
        this.f23560a = file;
        this.f23561b = file2;
        this.f23562c = file3;
        d();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.io.File r2, byte[] r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0017 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0017 }
            r1.write(r3)     // Catch:{ IOException -> 0x0013, all -> 0x0011 }
            r1.flush()     // Catch:{ IOException -> 0x0013, all -> 0x0011 }
            i.v.f(r1)
            r2 = 1
            return r2
        L_0x0011:
            r2 = move-exception
            goto L_0x001f
        L_0x0013:
            r0 = r1
            goto L_0x0017
        L_0x0015:
            r2 = move-exception
            goto L_0x001e
        L_0x0017:
            java.lang.String r2 = r.f.f23569h     // Catch:{ all -> 0x0015 }
            i.v.f(r0)
            r2 = 0
            return r2
        L_0x001e:
            r1 = r0
        L_0x001f:
            i.v.f(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r.b.b(java.io.File, byte[]):boolean");
    }

    public File a() {
        File[] listFiles = this.f23562c.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            return listFiles[0];
        }
        File[] listFiles2 = this.f23561b.listFiles();
        if (listFiles2 != null && listFiles2.length > 0) {
            return listFiles2[0];
        }
        File[] listFiles3 = this.f23560a.listFiles();
        if (listFiles3 != null && listFiles3.length > 0) {
            return listFiles3[0];
        }
        String str = f.f23569h;
        return null;
    }

    public boolean c(h hVar) {
        File file;
        byte[] l10 = c.l(hVar);
        if (l10 == null) {
            String str = f.f23569h;
            return false;
        }
        int i10 = hVar.f23587h;
        if (i10 == 1) {
            file = this.f23561b;
        } else if (i10 != 2) {
            file = this.f23560a;
        } else {
            file = this.f23562c;
        }
        File file2 = new File(file, "cache_log_report_" + System.currentTimeMillis() + ".log");
        if (b(file2, l10)) {
            String str2 = f.f23569h;
            file2.getAbsolutePath();
            return true;
        }
        String str3 = f.f23569h;
        file2.getAbsolutePath();
        return false;
    }

    public final void d() {
        String str = f.f23569h;
        this.f23560a.getAbsolutePath();
        this.f23561b.getAbsolutePath();
        this.f23562c.getAbsolutePath();
    }
}
