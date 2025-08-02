package i;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import w.d;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21997a = d.f("");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.ObjectInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0028, all -> 0x001f }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0028, all -> 0x001f }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r3.<init>(r1)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            java.lang.Object r0 = r3.readObject()     // Catch:{ Exception -> 0x002a, all -> 0x0016 }
            i.v.f(r1)
            i.v.f(r3)
            goto L_0x0030
        L_0x0016:
            r0 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
            goto L_0x0021
        L_0x001b:
            r3 = move-exception
            goto L_0x0021
        L_0x001d:
            r3 = r0
            goto L_0x002a
        L_0x001f:
            r3 = move-exception
            r1 = r0
        L_0x0021:
            i.v.f(r1)
            i.v.f(r0)
            throw r3
        L_0x0028:
            r3 = r0
            r1 = r3
        L_0x002a:
            i.v.f(r1)
            i.v.f(r3)
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.a(byte[]):java.lang.Object");
    }

    public static void b(File file, String str) {
        if (file != null && file.exists()) {
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write(str);
                    fileWriter2.flush();
                    v.f(fileWriter2);
                } catch (IOException unused) {
                    fileWriter = fileWriter2;
                    v.f(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    v.f(fileWriter);
                    throw th;
                }
            } catch (IOException unused2) {
                v.f(fileWriter);
            } catch (Throwable th2) {
                th = th2;
                v.f(fileWriter);
                throw th;
            }
        }
    }

    public static void c(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        gZIPOutputStream2.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream2.flush();
                        v.f(inputStream);
                        v.f(gZIPOutputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                v.f(inputStream);
                v.f(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            v.f(inputStream);
            v.f(gZIPOutputStream);
            throw th;
        }
    }

    public static void d(ZipOutputStream zipOutputStream, File file, String str) {
        FileInputStream fileInputStream = null;
        try {
            if (!file.isDirectory()) {
                byte[] bArr = new byte[2048];
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        byte[] bArr3 = new byte[read];
                        for (int i10 = 0; i10 < read; i10++) {
                            bArr3[i10] = (byte) (bArr2[i10] ^ 255);
                        }
                        zipOutputStream.write(bArr3, 0, read);
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    v.f(fileInputStream);
                    throw th;
                }
                fileInputStream = fileInputStream2;
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File d10 : listFiles) {
                        d(zipOutputStream, d10, str + file.getName() + DomExceptionUtils.SEPARATOR);
                    }
                }
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
            v.f(fileInputStream);
            throw th;
        }
        v.f(fileInputStream);
    }

    public static void e(File[] fileArr) {
        Arrays.sort(fileArr, new b());
    }

    public static boolean f(File file) {
        return g(file, 0);
    }

    public static boolean g(File file, long j10) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            if (randomAccessFile.length() > j10) {
                randomAccessFile.setLength(j10);
            }
            randomAccessFile.close();
            return true;
        } catch (FileNotFoundException unused) {
            file.getAbsolutePath();
            return true;
        } catch (Exception unused2) {
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1 A[SYNTHETIC, Splitter:B:51:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b6 A[Catch:{ Exception -> 0x00c1, all -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(java.io.InputStream r10, java.io.File r11) {
        /*
            r0 = 0
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            r10 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r10]     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
            r4 = r1
        L_0x0011:
            java.util.zip.ZipEntry r5 = r2.getNextEntry()     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
            if (r5 == 0) goto L_0x00ba
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x0061 }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0061 }
            r7.<init>(r11, r6)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r8 = r7.getCanonicalPath()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r9 = r11.getCanonicalPath()     // Catch:{ Exception -> 0x0061 }
            boolean r8 = r8.startsWith(r9)     // Catch:{ Exception -> 0x0061 }
            if (r8 == 0) goto L_0x0093
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0061 }
            java.lang.String r8 = r7.getParent()     // Catch:{ Exception -> 0x0061 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0061 }
            boolean r8 = r6.exists()     // Catch:{ Exception -> 0x0061 }
            if (r8 != 0) goto L_0x0063
            boolean r8 = r6.mkdirs()     // Catch:{ Exception -> 0x0061 }
            if (r8 == 0) goto L_0x0044
            goto L_0x0063
        L_0x0044:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0061 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r11.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0061 }
            r11.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = " mkdirs fail"
            r11.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0061 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0061 }
            throw r10     // Catch:{ Exception -> 0x0061 }
        L_0x005f:
            r10 = move-exception
            goto L_0x00ae
        L_0x0061:
            r10 = move-exception
            goto L_0x00aa
        L_0x0063:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0061 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0061 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4.<init>(r6, r10)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
        L_0x006d:
            int r1 = r2.read(r3, r0, r10)     // Catch:{ Exception -> 0x007a, all -> 0x0078 }
            r7 = -1
            if (r1 == r7) goto L_0x007c
            r4.write(r3, r0, r1)     // Catch:{ Exception -> 0x007a, all -> 0x0078 }
            goto L_0x006d
        L_0x0078:
            r10 = move-exception
            goto L_0x008a
        L_0x007a:
            r10 = move-exception
            goto L_0x008c
        L_0x007c:
            r4.flush()     // Catch:{ Exception -> 0x007a, all -> 0x0078 }
            r6.close()     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
            r4.close()     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
            r1 = r4
            r4 = r6
            goto L_0x0011
        L_0x0088:
            r10 = move-exception
            goto L_0x00bf
        L_0x008a:
            r1 = r4
            goto L_0x00af
        L_0x008c:
            r1 = r4
        L_0x008d:
            r4 = r6
            goto L_0x00aa
        L_0x008f:
            r10 = move-exception
            goto L_0x00af
        L_0x0091:
            r10 = move-exception
            goto L_0x008d
        L_0x0093:
            java.lang.SecurityException r10 = new java.lang.SecurityException     // Catch:{ Exception -> 0x0061 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r11.<init>()     // Catch:{ Exception -> 0x0061 }
            r11.append(r6)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = " zip path traversal vulnerability"
            r11.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0061 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0061 }
            throw r10     // Catch:{ Exception -> 0x0061 }
        L_0x00aa:
            r5.getName()     // Catch:{ all -> 0x005f }
            throw r10     // Catch:{ all -> 0x005f }
        L_0x00ae:
            r6 = r4
        L_0x00af:
            if (r6 == 0) goto L_0x00b4
            r6.close()     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
        L_0x00b4:
            if (r1 == 0) goto L_0x00b9
            r1.close()     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
        L_0x00b9:
            throw r10     // Catch:{ Exception -> 0x00c1, all -> 0x0088 }
        L_0x00ba:
            i.v.f(r2)
            r10 = 1
            return r10
        L_0x00bf:
            r1 = r2
            goto L_0x00c4
        L_0x00c1:
            r1 = r2
            goto L_0x00c8
        L_0x00c3:
            r10 = move-exception
        L_0x00c4:
            i.v.f(r1)
            throw r10
        L_0x00c8:
            i.v.f(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.h(java.io.InputStream, java.io.File):boolean");
    }

    public static boolean i(String str, String str2) {
        Throwable th;
        ZipOutputStream zipOutputStream = null;
        try {
            File file = new File(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                v.f((Closeable) null);
                return false;
            }
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
            try {
                if (file2.isFile()) {
                    d(zipOutputStream2, file2, "");
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File d10 : listFiles) {
                            d(zipOutputStream2, d10, "");
                        }
                    }
                }
                v.f(zipOutputStream2);
                return true;
            } catch (Exception unused) {
                zipOutputStream = zipOutputStream2;
                v.f(zipOutputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                v.f(zipOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
            v.f(zipOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            v.f(zipOutputStream);
            throw th;
        }
    }

    public static byte[] j(File file, long j10, long j11) {
        GZIPOutputStream gZIPOutputStream;
        RandomAccessFile randomAccessFile;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (!file.exists()) {
            file.getAbsolutePath();
            return null;
        } else if (j10 <= 0 || j11 < 0) {
            return null;
        } else {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    long length = randomAccessFile.length() - j11;
                    if (length <= 0) {
                        file.getAbsolutePath();
                        v.f(randomAccessFile);
                        v.f((Closeable) null);
                        return null;
                    }
                    if (length > j10) {
                        j11 = length - j10;
                        file.getName();
                    } else {
                        file.getName();
                    }
                    randomAccessFile.seek(j11);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                            gZIPOutputStream.flush();
                        }
                        gZIPOutputStream.close();
                        if (byteArrayOutputStream.size() == 0) {
                            v.f(randomAccessFile);
                            v.f(gZIPOutputStream);
                            return null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        int length2 = byteArray.length;
                        v.f(randomAccessFile);
                        v.f(gZIPOutputStream);
                        return byteArray;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream;
                        v.f(randomAccessFile);
                        v.f(gZIPOutputStream2);
                        throw th;
                    }
                } catch (Exception unused2) {
                    gZIPOutputStream = null;
                    v.f(randomAccessFile);
                    v.f(gZIPOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    v.f(randomAccessFile);
                    v.f(gZIPOutputStream2);
                    throw th;
                }
            } catch (Exception unused3) {
                gZIPOutputStream = null;
                randomAccessFile = null;
                v.f(randomAccessFile);
                v.f(gZIPOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                v.f(randomAccessFile);
                v.f(gZIPOutputStream2);
                throw th;
            }
        }
    }

    public static byte[] k(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c(inputStream, byteArrayOutputStream);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] l(java.lang.Object r3) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002d, all -> 0x0024 }
            r1.<init>()     // Catch:{ IOException -> 0x002d, all -> 0x0024 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.writeObject(r3)     // Catch:{ IOException -> 0x002f, all -> 0x001c }
            r2.flush()     // Catch:{ IOException -> 0x002f, all -> 0x001c }
            byte[] r0 = r1.toByteArray()     // Catch:{ IOException -> 0x002f, all -> 0x001c }
            i.v.f(r2)
            i.v.f(r1)
            goto L_0x0035
        L_0x001c:
            r3 = move-exception
        L_0x001d:
            r0 = r1
            goto L_0x0026
        L_0x001f:
            r3 = move-exception
            r2 = r0
            goto L_0x001d
        L_0x0022:
            r2 = r0
            goto L_0x002f
        L_0x0024:
            r3 = move-exception
            r2 = r0
        L_0x0026:
            i.v.f(r2)
            i.v.f(r0)
            throw r3
        L_0x002d:
            r1 = r0
            r2 = r1
        L_0x002f:
            i.v.f(r2)
            i.v.f(r1)
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.l(java.lang.Object):byte[]");
    }

    public static /* synthetic */ int m(File file, File file2) {
        int i10 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
        if (i10 > 0) {
            return -1;
        }
        if (i10 == 0) {
            return 0;
        }
        return 1;
    }

    public static File n(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                return n(file2, str);
            }
            if (file2.getAbsolutePath().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    public static void o(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File o10 : listFiles) {
                    o(o10);
                }
            }
            file.delete();
        } else if (file.exists()) {
            file.delete();
        }
    }

    public static byte[] p(byte[] bArr) {
        return k(new ByteArrayInputStream(bArr));
    }

    public static byte[] q(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception unused) {
                byteArrayOutputStream = null;
                v.f(fileInputStream);
                v.f(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                v.f(fileInputStream);
                v.f(byteArrayOutputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        v.f(fileInputStream);
                        v.f(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (Exception unused2) {
                v.f(fileInputStream);
                v.f(byteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                th = th3;
                v.f(fileInputStream);
                v.f(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
            fileInputStream = null;
            v.f(fileInputStream);
            v.f(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            v.f(fileInputStream);
            v.f(byteArrayOutputStream2);
            throw th;
        }
    }

    public static byte[] r(File file) {
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream.available() != 0) {
                return k(fileInputStream);
            }
            fileInputStream.close();
            return null;
        }
        throw new IllegalArgumentException("file is null");
    }

    public static String s(File file) {
        if (t(file)) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return v.d(fileInputStream);
        } finally {
            v.f(fileInputStream);
        }
    }

    public static boolean t(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return false;
    }
}
