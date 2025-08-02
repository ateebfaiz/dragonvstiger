package c1;

import android.content.pm.ApplicationInfo;
import java.io.File;
import kotlin.collections.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f17218a = new g();

    private g() {
    }

    private final void d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        tb.c.a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] e(java.util.zip.ZipFile r4, java.util.zip.ZipEntry r5) {
        /*
            r3 = this;
            java.io.InputStream r4 = r4.getInputStream(r5)
            r5 = 32
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x0017 }
            r1 = 0
            int r1 = r4.read(r0, r1, r5)     // Catch:{ all -> 0x0017 }
            r2 = 0
            if (r1 != r5) goto L_0x0019
            c1.g r5 = f17218a     // Catch:{ all -> 0x0017 }
            byte[] r5 = r5.a(r0)     // Catch:{ all -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r5 = move-exception
            goto L_0x001e
        L_0x0019:
            r5 = r2
        L_0x001a:
            tb.c.a(r4, r2)
            return r5
        L_0x001e:
            throw r5     // Catch:{ all -> 0x001f }
        L_0x001f:
            r0 = move-exception
            tb.c.a(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.g.e(java.util.zip.ZipFile, java.util.zip.ZipEntry):byte[]");
    }

    private final byte[] f(ApplicationInfo applicationInfo) {
        File file = new File(applicationInfo.sourceDir);
        if (!file.canRead()) {
            return null;
        }
        return b(file);
    }

    private final boolean g(byte[] bArr) {
        if ((bArr[0] & 255) == 100 && (bArr[1] & 255) == 101 && (bArr[2] & 255) == 120 && (bArr[3] & 255) == 10 && (bArr[7] & 255) == 0) {
            return true;
        }
        return false;
    }

    public final byte[] a(byte[] bArr) {
        if (!g(bArr)) {
            return null;
        }
        return j.h(bArr, 12, 32);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        tb.c.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] b(java.io.File r6) {
        /*
            r5 = this;
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile
            r1 = 1
            r0.<init>(r6, r1)
            java.lang.String r6 = "classes.dex"
            java.util.zip.ZipEntry r6 = r0.getEntry(r6)     // Catch:{ all -> 0x004f }
            r1 = 0
            if (r6 != 0) goto L_0x0013
            tb.c.a(r0, r1)
            return r1
        L_0x0013:
            c1.g r2 = f17218a     // Catch:{ all -> 0x004f }
            byte[] r6 = r2.e(r0, r6)     // Catch:{ all -> 0x004f }
            if (r6 != 0) goto L_0x001f
            tb.c.a(r0, r1)
            return r1
        L_0x001f:
            r2 = 2
        L_0x0020:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r3.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "classes"
            r3.append(r4)     // Catch:{ all -> 0x004f }
            r3.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r4 = ".dex"
            r3.append(r4)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004f }
            java.util.zip.ZipEntry r3 = r0.getEntry(r3)     // Catch:{ all -> 0x004f }
            if (r3 != 0) goto L_0x003d
            goto L_0x0045
        L_0x003d:
            c1.g r4 = f17218a     // Catch:{ all -> 0x004f }
            byte[] r3 = r4.e(r0, r3)     // Catch:{ all -> 0x004f }
            if (r3 != 0) goto L_0x0049
        L_0x0045:
            tb.c.a(r0, r1)
            return r6
        L_0x0049:
            r4.d(r6, r3)     // Catch:{ all -> 0x004f }
            int r2 = r2 + 1
            goto L_0x0020
        L_0x004f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r1 = move-exception
            tb.c.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.g.b(java.io.File):byte[]");
    }

    public final String c(ApplicationInfo applicationInfo) {
        try {
            byte[] f10 = f(applicationInfo);
            if (f10 == null) {
                return null;
            }
            return e.a(f10);
        } catch (Throwable unused) {
            return null;
        }
    }
}
