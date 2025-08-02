package b1;

import a1.b;
import a1.g;
import a1.v;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class d implements a1.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map f17137a;

    /* renamed from: b  reason: collision with root package name */
    private long f17138b;

    /* renamed from: c  reason: collision with root package name */
    private final File f17139c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17140d;

    public d(File file, int i10) {
        this.f17137a = new LinkedHashMap(16, 0.75f, true);
        this.f17138b = 0;
        this.f17139c = file;
        this.f17140d = i10;
    }

    private String e(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void f(int i10) {
        int i11;
        long j10 = (long) i10;
        if (this.f17138b + j10 >= ((long) this.f17140d)) {
            if (v.f13657b) {
                v.e("Pruning old cache entries.", new Object[0]);
            }
            long j11 = this.f17138b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f17137a.entrySet().iterator();
            int i12 = 0;
            while (it.hasNext()) {
                a aVar = (a) ((Map.Entry) it.next()).getValue();
                if (d(aVar.f17142b).delete()) {
                    this.f17138b -= aVar.f17141a;
                    i11 = 1;
                } else {
                    String str = aVar.f17142b;
                    String e10 = e(str);
                    i11 = 1;
                    v.b("Could not delete cache entry for key=%s, filename=%s", str, e10);
                }
                it.remove();
                i12 += i11;
                if (((float) (this.f17138b + j10)) < ((float) this.f17140d) * 0.9f) {
                    break;
                }
            }
            if (v.f13657b) {
                v.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i12), Long.valueOf(this.f17138b - j11), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void g(String str, a aVar) {
        if (!this.f17137a.containsKey(str)) {
            this.f17138b += aVar.f17141a;
        } else {
            this.f17138b += aVar.f17141a - ((a) this.f17137a.get(str)).f17141a;
        }
        this.f17137a.put(str, aVar);
    }

    private static int h(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static List i(b bVar) {
        List list;
        int j10 = j(bVar);
        if (j10 == 0) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(j10);
        }
        for (int i10 = 0; i10 < j10; i10++) {
            list.add(new g(l(bVar).intern(), l(bVar).intern()));
        }
        return list;
    }

    static int j(InputStream inputStream) {
        return (h(inputStream) << 24) | h(inputStream) | (h(inputStream) << 8) | (h(inputStream) << 16);
    }

    static long k(InputStream inputStream) {
        return (((long) h(inputStream)) & 255) | ((((long) h(inputStream)) & 255) << 8) | ((((long) h(inputStream)) & 255) << 16) | ((((long) h(inputStream)) & 255) << 24) | ((((long) h(inputStream)) & 255) << 32) | ((((long) h(inputStream)) & 255) << 40) | ((((long) h(inputStream)) & 255) << 48) | ((255 & ((long) h(inputStream))) << 56);
    }

    static String l(b bVar) {
        return new String(o(bVar, k(bVar)), "UTF-8");
    }

    private void n(String str) {
        a aVar = (a) this.f17137a.remove(str);
        if (aVar != null) {
            this.f17138b -= aVar.f17141a;
        }
    }

    static byte[] o(b bVar, long j10) {
        long a10 = bVar.a();
        if (j10 >= 0 && j10 <= a10) {
            int i10 = (int) j10;
            if (((long) i10) == j10) {
                byte[] bArr = new byte[i10];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j10 + ", maxLength=" + a10);
    }

    static void p(List list, OutputStream outputStream) {
        if (list != null) {
            q(outputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                s(outputStream, gVar.a());
                s(outputStream, gVar.b());
            }
            return;
        }
        q(outputStream, 0);
    }

    static void q(OutputStream outputStream, int i10) {
        outputStream.write(i10 & 255);
        outputStream.write((i10 >> 8) & 255);
        outputStream.write((i10 >> 16) & 255);
        outputStream.write((i10 >> 24) & 255);
    }

    static void r(OutputStream outputStream, long j10) {
        outputStream.write((byte) ((int) j10));
        outputStream.write((byte) ((int) (j10 >>> 8)));
        outputStream.write((byte) ((int) (j10 >>> 16)));
        outputStream.write((byte) ((int) (j10 >>> 24)));
        outputStream.write((byte) ((int) (j10 >>> 32)));
        outputStream.write((byte) ((int) (j10 >>> 40)));
        outputStream.write((byte) ((int) (j10 >>> 48)));
        outputStream.write((byte) ((int) (j10 >>> 56)));
    }

    static void s(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        r(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|(1:17)|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r2.delete() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        a1.v.b("Could not clean up file %s", r2.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r7, a1.b.a r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            monitor-enter(r6)
            byte[] r2 = r8.f13578a     // Catch:{ all -> 0x002e }
            int r2 = r2.length     // Catch:{ all -> 0x002e }
            r6.f(r2)     // Catch:{ all -> 0x002e }
            java.io.File r2 = r6.d(r7)     // Catch:{ all -> 0x002e }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0046 }
            java.io.OutputStream r4 = r6.c(r2)     // Catch:{ IOException -> 0x0046 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0046 }
            b1.d$a r4 = new b1.d$a     // Catch:{ IOException -> 0x0046 }
            r4.<init>(r7, r8)     // Catch:{ IOException -> 0x0046 }
            boolean r5 = r4.d(r3)     // Catch:{ IOException -> 0x0046 }
            if (r5 == 0) goto L_0x0030
            byte[] r8 = r8.f13578a     // Catch:{ IOException -> 0x0046 }
            r3.write(r8)     // Catch:{ IOException -> 0x0046 }
            r3.close()     // Catch:{ IOException -> 0x0046 }
            r6.g(r7, r4)     // Catch:{ IOException -> 0x0046 }
            monitor-exit(r6)
            return
        L_0x002e:
            r7 = move-exception
            goto L_0x005b
        L_0x0030:
            r3.close()     // Catch:{ IOException -> 0x0046 }
            java.lang.String r7 = "Failed to write header for %s"
            java.lang.String r8 = r2.getAbsolutePath()     // Catch:{ IOException -> 0x0046 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x0046 }
            r3[r0] = r8     // Catch:{ IOException -> 0x0046 }
            a1.v.b(r7, r3)     // Catch:{ IOException -> 0x0046 }
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x0046 }
            r7.<init>()     // Catch:{ IOException -> 0x0046 }
            throw r7     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            boolean r7 = r2.delete()     // Catch:{ all -> 0x002e }
            if (r7 != 0) goto L_0x0059
            java.lang.String r7 = "Could not clean up file %s"
            java.lang.String r8 = r2.getAbsolutePath()     // Catch:{ all -> 0x002e }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002e }
            r1[r0] = r8     // Catch:{ all -> 0x002e }
            a1.v.b(r7, r1)     // Catch:{ all -> 0x002e }
        L_0x0059:
            monitor-exit(r6)
            return
        L_0x005b:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.d.a(java.lang.String, a1.b$a):void");
    }

    /* access modifiers changed from: package-private */
    public InputStream b(File file) {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: package-private */
    public OutputStream c(File file) {
        return new FileOutputStream(file);
    }

    public File d(String str) {
        return new File(this.f17139c, e(str));
    }

    public synchronized b.a get(String str) {
        b bVar;
        a aVar = (a) this.f17137a.get(str);
        if (aVar == null) {
            return null;
        }
        File d10 = d(str);
        try {
            bVar = new b(new BufferedInputStream(b(d10)), d10.length());
            a b10 = a.b(bVar);
            if (!TextUtils.equals(str, b10.f17142b)) {
                v.b("%s: key=%s, found=%s", d10.getAbsolutePath(), str, b10.f17142b);
                n(str);
                bVar.close();
                return null;
            }
            b.a c10 = aVar.c(o(bVar, bVar.a()));
            bVar.close();
            return c10;
        } catch (IOException e10) {
            v.b("%s: %s", d10.getAbsolutePath(), e10.toString());
            m(str);
            return null;
        } catch (Throwable th) {
            bVar.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            monitor-enter(r10)
            java.io.File r2 = r10.f17139c     // Catch:{ all -> 0x0023 }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0027
            java.io.File r2 = r10.f17139c     // Catch:{ all -> 0x0023 }
            boolean r2 = r2.mkdirs()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0025
            java.lang.String r2 = "Unable to create cache dir %s"
            java.io.File r3 = r10.f17139c     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0023 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0023 }
            r1[r0] = r3     // Catch:{ all -> 0x0023 }
            a1.v.c(r2, r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r0 = move-exception
            goto L_0x0063
        L_0x0025:
            monitor-exit(r10)
            return
        L_0x0027:
            java.io.File r2 = r10.f17139c     // Catch:{ all -> 0x0023 }
            java.io.File[] r2 = r2.listFiles()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0031
            monitor-exit(r10)
            return
        L_0x0031:
            int r3 = r2.length     // Catch:{ all -> 0x0023 }
        L_0x0032:
            if (r0 >= r3) goto L_0x0061
            r4 = r2[r0]     // Catch:{ all -> 0x0023 }
            long r5 = r4.length()     // Catch:{ IOException -> 0x005c }
            b1.d$b r7 = new b1.d$b     // Catch:{ IOException -> 0x005c }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005c }
            java.io.InputStream r9 = r10.b(r4)     // Catch:{ IOException -> 0x005c }
            r8.<init>(r9)     // Catch:{ IOException -> 0x005c }
            r7.<init>(r8, r5)     // Catch:{ IOException -> 0x005c }
            b1.d$a r8 = b1.d.a.b(r7)     // Catch:{ all -> 0x0057 }
            r8.f17141a = r5     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = r8.f17142b     // Catch:{ all -> 0x0057 }
            r10.g(r5, r8)     // Catch:{ all -> 0x0057 }
            r7.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x005f
        L_0x0057:
            r5 = move-exception
            r7.close()     // Catch:{ IOException -> 0x005c }
            throw r5     // Catch:{ IOException -> 0x005c }
        L_0x005c:
            r4.delete()     // Catch:{ all -> 0x0023 }
        L_0x005f:
            int r0 = r0 + r1
            goto L_0x0032
        L_0x0061:
            monitor-exit(r10)
            return
        L_0x0063:
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.d.initialize():void");
    }

    public synchronized void m(String str) {
        boolean delete = d(str).delete();
        n(str);
        if (!delete) {
            v.b("Could not delete cache entry for key=%s, filename=%s", str, e(str));
        }
    }

    static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final long f17149a;

        /* renamed from: b  reason: collision with root package name */
        private long f17150b;

        b(InputStream inputStream, long j10) {
            super(inputStream);
            this.f17149a = j10;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f17149a - this.f17150b;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f17150b++;
            }
            return read;
        }

        public int read(byte[] bArr, int i10, int i11) {
            int read = super.read(bArr, i10, i11);
            if (read != -1) {
                this.f17150b += (long) read;
            }
            return read;
        }
    }

    public d(File file) {
        this(file, 5242880);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f17141a;

        /* renamed from: b  reason: collision with root package name */
        final String f17142b;

        /* renamed from: c  reason: collision with root package name */
        final String f17143c;

        /* renamed from: d  reason: collision with root package name */
        final long f17144d;

        /* renamed from: e  reason: collision with root package name */
        final long f17145e;

        /* renamed from: f  reason: collision with root package name */
        final long f17146f;

        /* renamed from: g  reason: collision with root package name */
        final long f17147g;

        /* renamed from: h  reason: collision with root package name */
        final List f17148h;

        private a(String str, String str2, long j10, long j11, long j12, long j13, List list) {
            this.f17142b = str;
            this.f17143c = "".equals(str2) ? null : str2;
            this.f17144d = j10;
            this.f17145e = j11;
            this.f17146f = j12;
            this.f17147g = j13;
            this.f17148h = list;
        }

        private static List a(b.a aVar) {
            List list = aVar.f13585h;
            if (list != null) {
                return list;
            }
            return e.f(aVar.f13584g);
        }

        static a b(b bVar) {
            if (d.j(bVar) == 538247942) {
                return new a(d.l(bVar), d.l(bVar), d.k(bVar), d.k(bVar), d.k(bVar), d.k(bVar), d.i(bVar));
            }
            throw new IOException();
        }

        /* access modifiers changed from: package-private */
        public b.a c(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f13578a = bArr;
            aVar.f13579b = this.f17143c;
            aVar.f13580c = this.f17144d;
            aVar.f13581d = this.f17145e;
            aVar.f13582e = this.f17146f;
            aVar.f13583f = this.f17147g;
            aVar.f13584g = e.g(this.f17148h);
            aVar.f13585h = Collections.unmodifiableList(this.f17148h);
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public boolean d(OutputStream outputStream) {
            try {
                d.q(outputStream, 538247942);
                d.s(outputStream, this.f17142b);
                String str = this.f17143c;
                if (str == null) {
                    str = "";
                }
                d.s(outputStream, str);
                d.r(outputStream, this.f17144d);
                d.r(outputStream, this.f17145e);
                d.r(outputStream, this.f17146f);
                d.r(outputStream, this.f17147g);
                d.p(this.f17148h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e10) {
                v.b("%s", e10.toString());
                return false;
            }
        }

        a(String str, b.a aVar) {
            this(str, aVar.f13579b, aVar.f13580c, aVar.f13581d, aVar.f13582e, aVar.f13583f, a(aVar));
            this.f17141a = (long) aVar.f13578a.length;
        }
    }
}
