package com.facebook.soloader;

import android.os.StrictMode;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.soloader.o;
import io.jsonwebtoken.JwtParser;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4832a = 3;

    /* renamed from: b  reason: collision with root package name */
    private static final int f4833b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4834c = (3 + 3);

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f4835d;

    /* renamed from: e  reason: collision with root package name */
    private static byte[] f4836e;

    /* renamed from: f  reason: collision with root package name */
    private static List f4837f;

    /* renamed from: g  reason: collision with root package name */
    private static Map f4838g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f4839h;

    /* renamed from: i  reason: collision with root package name */
    private static final ReentrantReadWriteLock f4840i = new ReentrantReadWriteLock();

    private static String[] a(String str) {
        if (f4835d) {
            return i(str);
        }
        if (!f4839h) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f4840i;
        reentrantReadWriteLock.readLock().lock();
        try {
            String[] i10 = i(str);
            reentrantReadWriteLock.readLock().unlock();
            return i10;
        } catch (Throwable th) {
            f4840i.readLock().unlock();
            throw th;
        }
    }

    public static String[] b(String str, g gVar) {
        boolean z10 = SoLoader.f4773a;
        if (z10) {
            Api18TraceUtils.a("soloader.NativeDeps.getDependencies[", str, "]");
        }
        try {
            String[] a10 = a(str);
            if (a10 != null) {
                if (z10) {
                    Api18TraceUtils.b();
                }
                return a10;
            }
            String[] a11 = o.a(gVar);
            if (z10) {
                Api18TraceUtils.b();
            }
            return a11;
        } catch (o.a e10) {
            throw z.b(str, e10);
        } catch (Throwable th) {
            if (SoLoader.f4773a) {
                Api18TraceUtils.b();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] c(int r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r6 = r6 + r7
            int r7 = f4834c
            int r6 = r6 - r7
            r7 = 0
            r1 = r7
            r2 = r1
        L_0x000c:
            byte[] r3 = f4836e
            int r4 = r3.length
            r5 = 0
            if (r6 >= r4) goto L_0x003e
            byte r3 = r3[r6]
            r4 = 10
            if (r3 == r4) goto L_0x003e
            r4 = 32
            if (r3 != r4) goto L_0x002b
            if (r2 == 0) goto L_0x003a
            java.lang.String r1 = d(r1)
            if (r1 != 0) goto L_0x0025
            return r5
        L_0x0025:
            r0.add(r1)
            r1 = r7
            r2 = r1
            goto L_0x003a
        L_0x002b:
            r2 = 48
            if (r3 < r2) goto L_0x003d
            r2 = 57
            if (r3 <= r2) goto L_0x0034
            goto L_0x003d
        L_0x0034:
            int r1 = r1 * 10
            int r3 = r3 + -48
            int r1 = r1 + r3
            r2 = 1
        L_0x003a:
            int r6 = r6 + 1
            goto L_0x000c
        L_0x003d:
            return r5
        L_0x003e:
            if (r2 == 0) goto L_0x004a
            java.lang.String r6 = d(r1)
            if (r6 != 0) goto L_0x0047
            return r5
        L_0x0047:
            r0.add(r6)
        L_0x004a:
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x0051
            return r5
        L_0x0051:
            int r6 = r0.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r0.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.p.c(int, int):java.lang.String[]");
    }

    private static String d(int i10) {
        if (i10 >= f4837f.size()) {
            return null;
        }
        int intValue = ((Integer) f4837f.get(i10)).intValue();
        int i11 = intValue;
        while (true) {
            byte[] bArr = f4836e;
            if (i11 >= bArr.length || bArr[i11] <= 32) {
                int i12 = (i11 - intValue) + f4834c;
                char[] cArr = new char[i12];
                cArr[0] = 'l';
                cArr[1] = 'i';
                cArr[2] = 'b';
            } else {
                i11++;
            }
        }
        int i122 = (i11 - intValue) + f4834c;
        char[] cArr2 = new char[i122];
        cArr2[0] = 'l';
        cArr2[1] = 'i';
        cArr2[2] = 'b';
        for (int i13 = 0; i13 < i122 - f4834c; i13++) {
            cArr2[f4832a + i13] = (char) f4836e[intValue + i13];
        }
        cArr2[i122 - 3] = JwtParser.SEPARATOR_CHAR;
        cArr2[i122 - 2] = 's';
        cArr2[i122 - 1] = 'o';
        return new String(cArr2);
    }

    private static int e(String str) {
        List<Integer> list = (List) f4838g.get(Integer.valueOf(f(str)));
        if (list == null) {
            return -1;
        }
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (g(str, intValue2)) {
                return intValue2;
            }
        }
        return -1;
    }

    private static int f(String str) {
        int i10 = 5381;
        for (int i11 = f4832a; i11 < str.length() - f4833b; i11++) {
            i10 = str.codePointAt(i11) + (i10 << 5) + i10;
        }
        return i10;
    }

    private static boolean g(String str, int i10) {
        int i11;
        int i12 = f4832a;
        while (true) {
            int length = str.length();
            i11 = f4833b;
            if (i12 < length - i11 && i10 < f4836e.length && (str.codePointAt(i12) & 255) == f4836e[i10]) {
                i12++;
                i10++;
            }
        }
        if (i12 == str.length() - i11) {
            return true;
        }
        return false;
    }

    public static void h(String str, g gVar, int i10, StrictMode.ThreadPolicy threadPolicy) {
        String[] b10 = b(str, gVar);
        m.a("SoLoader", "Loading " + str + "'s dependencies: " + Arrays.toString(b10));
        for (String str2 : b10) {
            if (!str2.startsWith(DomExceptionUtils.SEPARATOR)) {
                SoLoader.s(str2, i10, threadPolicy);
            }
        }
    }

    static String[] i(String str) {
        int e10;
        if (f4835d && str.length() > f4834c && (e10 = e(str)) != -1) {
            return c(e10, str.length());
        }
        return null;
    }
}
