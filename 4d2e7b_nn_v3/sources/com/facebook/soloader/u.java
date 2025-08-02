package com.facebook.soloader;

import com.alibaba.pdns.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class u implements t {

    /* renamed from: a  reason: collision with root package name */
    private final Runtime f4841a = Runtime.getRuntime();

    /* renamed from: b  reason: collision with root package name */
    private final Method f4842b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4843c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4844d;

    public u() {
        String str;
        Method nativeLoadRuntimeMethod = SysUtil.getNativeLoadRuntimeMethod();
        this.f4842b = nativeLoadRuntimeMethod;
        if (nativeLoadRuntimeMethod != null) {
            str = SysUtil.getClassLoaderLdLoadLibrary();
        } else {
            str = null;
        }
        this.f4843c = str;
        this.f4844d = SysUtil.m(str);
    }

    private String b(String str) {
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    String format = String.format("%32x", new Object[]{new BigInteger(1, instance.digest())});
                    fileInputStream.close();
                    return format;
                }
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e10) {
            return e10.toString();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        com.facebook.soloader.m.b("SoFileLoaderImpl", "Error when loading library: " + r2 + ", library hash is " + b(r9) + ", LD_LIBRARY_PATH is " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        r2 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        throw new java.lang.RuntimeException("nativeLoad() error during invocation for " + r9 + ": " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        com.facebook.soloader.m.b("SoFileLoaderImpl", "Error when loading library: " + r2 + ", library hash is " + b(r9) + ", LD_LIBRARY_PATH is " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0090 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, int r10) {
        /*
            r8 = this;
            java.lang.reflect.Method r0 = r8.f4842b
            if (r0 != 0) goto L_0x0008
            java.lang.System.load(r9)
            return
        L_0x0008:
            r0 = 4
            r10 = r10 & r0
            if (r10 != r0) goto L_0x000f
            java.lang.String r10 = r8.f4843c
            goto L_0x0011
        L_0x000f:
            java.lang.String r10 = r8.f4844d
        L_0x0011:
            r0 = 0
            java.lang.Runtime r1 = r8.f4841a     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0090 }
            monitor-enter(r1)     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0090 }
            java.lang.reflect.Method r2 = r8.f4842b     // Catch:{ all -> 0x0082 }
            java.lang.Runtime r3 = r8.f4841a     // Catch:{ all -> 0x0082 }
            java.lang.Class<com.facebook.soloader.SoLoader> r4 = com.facebook.soloader.SoLoader.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x0082 }
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0082 }
            r6 = 0
            r5[r6] = r9     // Catch:{ all -> 0x0082 }
            r6 = 1
            r5[r6] = r4     // Catch:{ all -> 0x0082 }
            r4 = 2
            r5[r4] = r10     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.invoke(r3, r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x0063
            monitor-exit(r1)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0060
            java.lang.String r0 = "SoFileLoaderImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Error when loading library: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = ", library hash is "
            r1.append(r2)
            java.lang.String r9 = r8.b(r9)
            r1.append(r9)
            java.lang.String r9 = ", LD_LIBRARY_PATH is "
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = r1.toString()
            com.facebook.soloader.m.b(r0, r9)
        L_0x0060:
            return
        L_0x0061:
            r0 = move-exception
            goto L_0x0086
        L_0x0063:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = "nativeLoad() returned error for "
            r0.append(r3)     // Catch:{ all -> 0x0061 }
            r0.append(r9)     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = ": "
            r0.append(r3)     // Catch:{ all -> 0x0061 }
            r0.append(r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0061 }
            com.facebook.soloader.y r2 = new com.facebook.soloader.y     // Catch:{ all -> 0x0082 }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x0082 }
            throw r2     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r2 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
        L_0x0086:
            monitor-exit(r1)     // Catch:{ all -> 0x0061 }
            throw r0     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008a, all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            goto L_0x00af
        L_0x008a:
            r0 = r2
            goto L_0x0090
        L_0x008c:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x00af
        L_0x0090:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r1.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "nativeLoad() error during invocation for "
            r1.append(r2)     // Catch:{ all -> 0x008c }
            r1.append(r9)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = ": "
            r1.append(r2)     // Catch:{ all -> 0x008c }
            r1.append(r0)     // Catch:{ all -> 0x008c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x008c }
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x008c }
            r1.<init>(r0)     // Catch:{ all -> 0x008c }
            throw r1     // Catch:{ all -> 0x008c }
        L_0x00af:
            if (r2 == 0) goto L_0x00db
            java.lang.String r1 = "SoFileLoaderImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error when loading library: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ", library hash is "
            r3.append(r2)
            java.lang.String r9 = r8.b(r9)
            r3.append(r9)
            java.lang.String r9 = ", LD_LIBRARY_PATH is "
            r3.append(r9)
            r3.append(r10)
            java.lang.String r9 = r3.toString()
            com.facebook.soloader.m.b(r1, r9)
        L_0x00db:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.u.a(java.lang.String, int):void");
    }
}
