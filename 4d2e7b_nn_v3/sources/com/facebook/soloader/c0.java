package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;

public abstract class c0 extends e implements b {

    /* renamed from: d  reason: collision with root package name */
    protected final Context f4793d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f4794e;

    class a implements FilenameFilter {
        a() {
        }

        public boolean accept(File file, String str) {
            if (str.equals("dso_state") || str.equals("dso_lock") || str.equals("dso_deps")) {
                return false;
            }
            return true;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f4797b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f4798c;

        b(boolean z10, File file, l lVar) {
            this.f4796a = z10;
            this.f4797b = file;
            this.f4798c = lVar;
        }

        public void run() {
            m.f("fb-UnpackingSoSource", "starting syncer worker");
            try {
                if (this.f4796a) {
                    SysUtil.f(c0.this.f4807a);
                }
                c0.t(this.f4797b, (byte) 1, this.f4796a);
                m.f("fb-UnpackingSoSource", "releasing dso store lock for " + c0.this.f4807a + " (from syncer thread)");
                this.f4798c.close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            } catch (Throwable th) {
                m.f("fb-UnpackingSoSource", "releasing dso store lock for " + c0.this.f4807a + " (from syncer thread)");
                this.f4798c.close();
                throw th;
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f4800a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4801b;

        public c(String str, String str2) {
            this.f4800a = str;
            this.f4801b = str2;
        }
    }

    protected static final class d implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final c f4802a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final InputStream f4803b;

        public d(c cVar, InputStream inputStream) {
            this.f4802a = cVar;
            this.f4803b = inputStream;
        }

        public int available() {
            return this.f4803b.available();
        }

        public c b() {
            return this.f4802a;
        }

        public void close() {
            this.f4803b.close();
        }
    }

    protected static abstract class e implements Closeable {
        protected e() {
        }

        public void a(d dVar, byte[] bArr, File file) {
            RandomAccessFile randomAccessFile;
            Throwable th;
            File file2 = file;
            m.d("fb-UnpackingSoSource", "extracting DSO " + dVar.b().f4800a);
            File file3 = new File(file2, dVar.b().f4800a);
            try {
                randomAccessFile = new RandomAccessFile(file3, "rw");
                int available = dVar.available();
                if (available > 1) {
                    SysUtil.d(randomAccessFile.getFD(), (long) available);
                }
                SysUtil.a(randomAccessFile, dVar.f4803b, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file3.setExecutable(true, false)) {
                    randomAccessFile.close();
                    if (file3.exists() && !file3.setWritable(false)) {
                        m.b("SoLoader", "Error removing " + file3 + " write permission from directory " + file2 + " (writable: " + file.canWrite() + ")");
                        return;
                    }
                    return;
                }
                throw new IOException("cannot make file executable: " + file3);
            } catch (IOException e10) {
                try {
                    m.b("fb-UnpackingSoSource", "error extracting dso  " + file3 + " due to: " + e10);
                    SysUtil.c(file3);
                    throw e10;
                } catch (Throwable th2) {
                    if (file3.exists() && !file3.setWritable(false)) {
                        m.b("SoLoader", "Error removing " + file3 + " write permission from directory " + file2 + " (writable: " + file.canWrite() + ")");
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
            throw th;
        }

        public abstract c[] b();

        public void close() {
        }

        public abstract void h(File file);
    }

    protected c0(Context context, String str) {
        super(n(context, str), 1);
        this.f4793d = context;
    }

    private void i() {
        File[] listFiles = this.f4807a.listFiles(new a());
        if (listFiles != null) {
            for (File file : listFiles) {
                m.f("fb-UnpackingSoSource", "Deleting " + file);
                SysUtil.c(file);
            }
            return;
        }
        throw new IOException("unable to list directory " + this.f4807a);
    }

    private static boolean l(int i10) {
        return (i10 & 2) != 0;
    }

    public static File n(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + DomExceptionUtils.SEPARATOR + str);
    }

    private boolean q(l lVar, int i10) {
        byte b10;
        boolean z10;
        File file = new File(this.f4807a, "dso_state");
        byte[] m10 = m();
        boolean l10 = l(i10);
        if (l10 || j(m10)) {
            b10 = 0;
        } else {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                if (randomAccessFile.length() == 1) {
                    try {
                        b10 = randomAccessFile.readByte();
                        if (b10 == 1) {
                            m.f("fb-UnpackingSoSource", "dso store " + this.f4807a + " regeneration not needed: state file clean");
                            randomAccessFile.close();
                        }
                    } catch (IOException e10) {
                        m.f("fb-UnpackingSoSource", "dso store " + this.f4807a + " regeneration interrupted: " + e10.getMessage());
                    }
                }
                b10 = 0;
                randomAccessFile.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        if (b10 == 1) {
            return false;
        }
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        m.f("fb-UnpackingSoSource", "so store dirty: regenerating");
        t(file, (byte) 0, z10);
        i();
        e o10 = o(l10);
        try {
            o10.h(this.f4807a);
            o10.close();
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(this.f4807a, "dso_deps"), "rw");
            try {
                randomAccessFile2.write(m10);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                randomAccessFile2.close();
                b bVar = new b(z10, file, lVar);
                if (r(i10)) {
                    new Thread(bVar, "SoSync:" + this.f4807a.getName()).start();
                } else {
                    bVar.run();
                }
                return true;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        throw th;
        throw th;
        throw th;
    }

    private static boolean r(int i10) {
        return (i10 & 1) != 0;
    }

    /* access modifiers changed from: private */
    public static void t(File file, byte b10, boolean z10) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(b10);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            if (z10) {
                randomAccessFile.getFD().sync();
            }
            randomAccessFile.close();
            return;
        } catch (SyncFailedException e10) {
            m.h("fb-UnpackingSoSource", "state file sync failed", e10);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void a() {
        try {
            l i10 = SysUtil.i(this.f4807a, new File(this.f4807a, "dso_lock"));
            if (i10 != null) {
                i10.close();
            }
        } catch (Exception e10) {
            m.c("fb-UnpackingSoSource", "Encountered exception during wait for unpacking trying to acquire file lock for " + getClass().getName() + " (" + this.f4807a + "): ", e10);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0122 A[SYNTHETIC, Splitter:B:38:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013a A[Catch:{ all -> 0x00d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "error removing "
            java.lang.String r1 = " (syncer thread started)"
            java.lang.String r2 = "not releasing dso store lock for "
            java.lang.String r3 = "releasing dso store lock for "
            java.lang.String r4 = "fb-UnpackingSoSource"
            java.io.File r5 = r13.f4807a
            com.facebook.soloader.SysUtil.n(r5)
            java.io.File r5 = r13.f4807a
            boolean r5 = r5.canWrite()
            java.lang.String r6 = "error adding "
            r7 = 1
            java.lang.String r8 = " write permission"
            if (r5 != 0) goto L_0x0043
            java.io.File r5 = r13.f4807a
            boolean r5 = r5.setWritable(r7)
            if (r5 == 0) goto L_0x0025
            goto L_0x0043
        L_0x0025:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.io.File r1 = r13.f4807a
            java.lang.String r1 = r1.getCanonicalPath()
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x0043:
            r5 = 0
            r9 = 0
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x011f }
            java.io.File r11 = r13.f4807a     // Catch:{ all -> 0x011f }
            java.lang.String r12 = "dso_lock"
            r10.<init>(r11, r12)     // Catch:{ all -> 0x011f }
            java.io.File r11 = r13.f4807a     // Catch:{ all -> 0x011f }
            com.facebook.soloader.l r10 = com.facebook.soloader.SysUtil.i(r11, r10)     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r11.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = "locked dso store "
            r11.append(r12)     // Catch:{ all -> 0x0099 }
            java.io.File r12 = r13.f4807a     // Catch:{ all -> 0x0099 }
            r11.append(r12)     // Catch:{ all -> 0x0099 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0099 }
            com.facebook.soloader.m.f(r4, r11)     // Catch:{ all -> 0x0099 }
            java.io.File r11 = r13.f4807a     // Catch:{ all -> 0x0099 }
            boolean r11 = r11.canWrite()     // Catch:{ all -> 0x0099 }
            if (r11 != 0) goto L_0x009d
            java.io.File r11 = r13.f4807a     // Catch:{ all -> 0x0099 }
            boolean r7 = r11.setWritable(r7)     // Catch:{ all -> 0x0099 }
            if (r7 == 0) goto L_0x007b
            goto L_0x009d
        L_0x007b:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r7.<init>()     // Catch:{ all -> 0x0099 }
            r7.append(r6)     // Catch:{ all -> 0x0099 }
            java.io.File r6 = r13.f4807a     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = r6.getCanonicalPath()     // Catch:{ all -> 0x0099 }
            r7.append(r6)     // Catch:{ all -> 0x0099 }
            r7.append(r8)     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0099 }
            r14.<init>(r6)     // Catch:{ all -> 0x0099 }
            throw r14     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r14 = move-exception
            r9 = r10
            goto L_0x0120
        L_0x009d:
            boolean r14 = r13.q(r10, r14)     // Catch:{ all -> 0x0099 }
            if (r14 == 0) goto L_0x00a4
            goto L_0x00bb
        L_0x00a4:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r14.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = "dso store is up-to-date: "
            r14.append(r6)     // Catch:{ all -> 0x0099 }
            java.io.File r6 = r13.f4807a     // Catch:{ all -> 0x0099 }
            r14.append(r6)     // Catch:{ all -> 0x0099 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0099 }
            com.facebook.soloader.m.d(r4, r14)     // Catch:{ all -> 0x0099 }
            r9 = r10
        L_0x00bb:
            if (r9 == 0) goto L_0x00d8
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r14.<init>()     // Catch:{ all -> 0x00d5 }
            r14.append(r3)     // Catch:{ all -> 0x00d5 }
            java.io.File r1 = r13.f4807a     // Catch:{ all -> 0x00d5 }
            r14.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00d5 }
            com.facebook.soloader.m.f(r4, r14)     // Catch:{ all -> 0x00d5 }
            r9.close()     // Catch:{ all -> 0x00d5 }
            goto L_0x00ef
        L_0x00d5:
            r14 = move-exception
            goto L_0x0152
        L_0x00d8:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r14.<init>()     // Catch:{ all -> 0x00d5 }
            r14.append(r2)     // Catch:{ all -> 0x00d5 }
            java.io.File r2 = r13.f4807a     // Catch:{ all -> 0x00d5 }
            r14.append(r2)     // Catch:{ all -> 0x00d5 }
            r14.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00d5 }
            com.facebook.soloader.m.f(r4, r14)     // Catch:{ all -> 0x00d5 }
        L_0x00ef:
            java.io.File r14 = r13.f4807a
            boolean r14 = r14.canWrite()
            if (r14 == 0) goto L_0x011e
            java.io.File r14 = r13.f4807a
            boolean r14 = r14.setWritable(r5)
            if (r14 == 0) goto L_0x0100
            goto L_0x011e
        L_0x0100:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.io.File r0 = r13.f4807a
            java.lang.String r0 = r0.getCanonicalPath()
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = r1.toString()
            r14.<init>(r0)
            throw r14
        L_0x011e:
            return
        L_0x011f:
            r14 = move-exception
        L_0x0120:
            if (r9 == 0) goto L_0x013a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r1.<init>()     // Catch:{ all -> 0x00d5 }
            r1.append(r3)     // Catch:{ all -> 0x00d5 }
            java.io.File r2 = r13.f4807a     // Catch:{ all -> 0x00d5 }
            r1.append(r2)     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d5 }
            com.facebook.soloader.m.f(r4, r1)     // Catch:{ all -> 0x00d5 }
            r9.close()     // Catch:{ all -> 0x00d5 }
            goto L_0x0151
        L_0x013a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r3.<init>()     // Catch:{ all -> 0x00d5 }
            r3.append(r2)     // Catch:{ all -> 0x00d5 }
            java.io.File r2 = r13.f4807a     // Catch:{ all -> 0x00d5 }
            r3.append(r2)     // Catch:{ all -> 0x00d5 }
            r3.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00d5 }
            com.facebook.soloader.m.f(r4, r1)     // Catch:{ all -> 0x00d5 }
        L_0x0151:
            throw r14     // Catch:{ all -> 0x00d5 }
        L_0x0152:
            java.io.File r1 = r13.f4807a
            boolean r1 = r1.canWrite()
            if (r1 == 0) goto L_0x0180
            java.io.File r1 = r13.f4807a
            boolean r1 = r1.setWritable(r5)
            if (r1 != 0) goto L_0x0180
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.io.File r0 = r13.f4807a
            java.lang.String r0 = r0.getCanonicalPath()
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = r1.toString()
            r14.<init>(r0)
            throw r14
        L_0x0180:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.c0.e(int):void");
    }

    /* access modifiers changed from: protected */
    public boolean j(byte[] bArr) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(this.f4807a, "dso_deps"), "rw");
            if (randomAccessFile.length() == 0) {
                randomAccessFile.close();
                return true;
            }
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                m.f("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                randomAccessFile.close();
                return true;
            }
            boolean k10 = k(bArr2, bArr);
            randomAccessFile.close();
            return k10;
        } catch (IOException e10) {
            m.h("fb-UnpackingSoSource", "failed to compare whether deps changed", e10);
            return true;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public boolean k(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    /* access modifiers changed from: protected */
    public byte[] m() {
        Parcel obtain = Parcel.obtain();
        e o10 = o(false);
        try {
            c[] b10 = o10.b();
            obtain.writeInt(b10.length);
            for (c cVar : b10) {
                obtain.writeString(cVar.f4800a);
                obtain.writeString(cVar.f4801b);
            }
            o10.close();
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public abstract e o(boolean z10);

    public void p() {
        e(2);
    }

    public void s(String[] strArr) {
        this.f4794e = strArr;
    }
}
