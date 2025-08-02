package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

abstract class m {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f16104a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f16105b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        e.h(inputStream);
        int j10 = e.j(inputStream);
        if (j10 != 6 && j10 != 7) {
            while (j10 > 0) {
                e.j(inputStream);
                for (int j11 = e.j(inputStream); j11 > 0; j11--) {
                    e.h(inputStream);
                }
                j10--;
            }
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, d[] dVarArr) {
        if (Arrays.equals(bArr, ProfileVersion.V015_S)) {
            N(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            M(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V005_O)) {
            K(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            L(outputStream, dVarArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.V001_N)) {
            return false;
        } else {
            J(outputStream, dVarArr);
            return true;
        }
    }

    private static void C(OutputStream outputStream, d dVar) {
        int[] iArr = dVar.f16084h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            e.p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    private static n D(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i10 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f16079c);
                e.q(byteArrayOutputStream, dVar.f16080d);
                e.q(byteArrayOutputStream, (long) dVar.f16083g);
                String j10 = j(dVar.f16077a, dVar.f16078b, ProfileVersion.V015_S);
                int k10 = e.k(j10);
                e.p(byteArrayOutputStream, k10);
                i10 = i10 + 14 + k10;
                e.n(byteArrayOutputStream, j10);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                n nVar = new n(f.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return nVar;
            }
            throw e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f16104a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, d dVar) {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    private static void G(OutputStream outputStream, d dVar, String str) {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f16081e);
        e.q(outputStream, (long) dVar.f16082f);
        e.q(outputStream, dVar.f16079c);
        e.q(outputStream, (long) dVar.f16083g);
        e.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, d dVar) {
        byte[] bArr = new byte[k(dVar.f16083g)];
        for (Map.Entry entry : dVar.f16085i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, d dVar) {
        int i10 = 0;
        for (Map.Entry entry : dVar.f16085i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                e.p(outputStream, intValue - i10);
                e.p(outputStream, 0);
                i10 = intValue;
            }
        }
    }

    private static void J(OutputStream outputStream, d[] dVarArr) {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j10 = j(dVar.f16077a, dVar.f16078b, ProfileVersion.V001_N);
            e.p(outputStream, e.k(j10));
            e.p(outputStream, dVar.f16085i.size());
            e.p(outputStream, dVar.f16084h.length);
            e.q(outputStream, dVar.f16079c);
            e.n(outputStream, j10);
            for (Integer intValue : dVar.f16085i.keySet()) {
                e.p(outputStream, intValue.intValue());
            }
            for (int p10 : dVar.f16084h) {
                e.p(outputStream, p10);
            }
        }
    }

    private static void K(OutputStream outputStream, d[] dVarArr) {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j10 = j(dVar.f16077a, dVar.f16078b, ProfileVersion.V005_O);
            e.p(outputStream, e.k(j10));
            e.p(outputStream, dVar.f16084h.length);
            e.q(outputStream, (long) (dVar.f16085i.size() * 4));
            e.q(outputStream, dVar.f16079c);
            e.n(outputStream, j10);
            for (Integer intValue : dVar.f16085i.keySet()) {
                e.p(outputStream, intValue.intValue());
                e.p(outputStream, 0);
            }
            for (int p10 : dVar.f16084h) {
                e.p(outputStream, p10);
            }
        }
    }

    private static void L(OutputStream outputStream, d[] dVarArr) {
        byte[] b10 = b(dVarArr, ProfileVersion.V009_O_MR1);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b10);
    }

    private static void M(OutputStream outputStream, d[] dVarArr) {
        byte[] b10 = b(dVarArr, ProfileVersion.V010_P);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b10);
    }

    private static void N(OutputStream outputStream, d[] dVarArr) {
        O(outputStream, dVarArr);
    }

    private static void O(OutputStream outputStream, d[] dVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = ((long) ProfileVersion.V015_S.length) + ((long) f16104a.length) + 4 + ((long) (arrayList.size() * 16));
        e.q(outputStream, (long) arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            n nVar = (n) arrayList.get(i10);
            e.q(outputStream, nVar.f16106a.b());
            e.q(outputStream, length2);
            if (nVar.f16109d) {
                byte[] bArr = nVar.f16108c;
                byte[] b10 = e.b(bArr);
                arrayList2.add(b10);
                e.q(outputStream, (long) b10.length);
                e.q(outputStream, (long) bArr.length);
                length = b10.length;
            } else {
                arrayList2.add(nVar.f16108c);
                e.q(outputStream, (long) nVar.f16108c.length);
                e.q(outputStream, 0);
                length = nVar.f16108c.length;
            }
            length2 += (long) length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    private static int a(d dVar) {
        int i10 = 0;
        for (Map.Entry value : dVar.f16085i.entrySet()) {
            i10 |= ((Integer) value.getValue()).intValue();
        }
        return i10;
    }

    private static byte[] b(d[] dVarArr, byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        for (d dVar : dVarArr) {
            i11 += e.k(j(dVar.f16077a, dVar.f16078b, bArr)) + 16 + (dVar.f16081e * 2) + dVar.f16082f + k(dVar.f16083g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            int length = dVarArr.length;
            while (i10 < length) {
                d dVar2 = dVarArr[i10];
                G(byteArrayOutputStream, dVar2, j(dVar2.f16077a, dVar2.f16078b, bArr));
                F(byteArrayOutputStream, dVar2);
                i10++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f16077a, dVar3.f16078b, bArr));
            }
            int length2 = dVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, dVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == i11) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i11);
    }

    private static n c(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        int i11 = 0;
        while (i10 < dVarArr.length) {
            try {
                d dVar = dVarArr[i10];
                e.p(byteArrayOutputStream, i10);
                e.p(byteArrayOutputStream, dVar.f16081e);
                i11 = i11 + 4 + (dVar.f16081e * 2);
                C(byteArrayOutputStream, dVar);
                i10++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            n nVar = new n(f.CLASSES, i11, byteArray, true);
            byteArrayOutputStream.close();
            return nVar;
        }
        throw e.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static n d(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        int i11 = 0;
        while (i10 < dVarArr.length) {
            try {
                d dVar = dVarArr[i10];
                int a10 = a(dVar);
                byte[] e10 = e(dVar);
                byte[] f10 = f(dVar);
                e.p(byteArrayOutputStream, i10);
                int length = e10.length + 2 + f10.length;
                e.q(byteArrayOutputStream, (long) length);
                e.p(byteArrayOutputStream, a10);
                byteArrayOutputStream.write(e10);
                byteArrayOutputStream.write(f10);
                i11 = i11 + 6 + length;
                i10++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            n nVar = new n(f.METHODS, i11, byteArray, true);
            byteArrayOutputStream.close();
            return nVar;
        }
        throw e.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] e(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static byte[] f(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String g(String str, String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        if (":".equals(str2)) {
            return str.replace("!", ":");
        }
        return str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    private static d i(d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String h10 = h(str);
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            if (dVarArr[i10].f16078b.equals(h10)) {
                return dVarArr[i10];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String dexKeySeparator = ProfileVersion.dexKeySeparator(bArr);
        if (str.length() <= 0) {
            return g(str2, dexKeySeparator);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, dexKeySeparator);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.dexKeySeparator(bArr) + str2;
    }

    private static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    private static int l(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        } else if (i10 == 2) {
            return i11;
        } else {
            if (i10 == 4) {
                return i11 + i12;
            }
            throw e.c("Unexpected flag: " + i10);
        }
    }

    private static int[] m(InputStream inputStream, int i10) {
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += e.h(inputStream);
            iArr[i12] = i11;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i10, int i11) {
        int i12 = 2;
        if (!bitSet.get(l(2, i10, i11))) {
            i12 = 0;
        }
        if (bitSet.get(l(4, i10, i11))) {
            return i12 | 4;
        }
        return i12;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, ProfileVersion.V010_P.length);
        }
        throw e.c("Invalid magic");
    }

    private static void p(InputStream inputStream, d dVar) {
        int available = inputStream.available() - dVar.f16082f;
        int i10 = 0;
        while (inputStream.available() > available) {
            i10 += e.h(inputStream);
            dVar.f16085i.put(Integer.valueOf(i10), 1);
            for (int h10 = e.h(inputStream); h10 > 0; h10--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    static d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            if (!Arrays.equals(ProfileVersion.V015_S, bArr2)) {
                return r(inputStream, bArr, dVarArr);
            }
            throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, ProfileVersion.METADATA_V002)) {
            return t(inputStream, bArr2, dVarArr);
        } else {
            throw e.c("Unsupported meta version");
        }
    }

    static d[] r(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            int j10 = e.j(inputStream);
            byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    d[] s10 = s(byteArrayInputStream, j10, dVarArr);
                    byteArrayInputStream.close();
                    return s10;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported meta version");
        }
        throw th;
    }

    private static d[] s(InputStream inputStream, int i10, d[] dVarArr) {
        int i11 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 == dVarArr.length) {
            String[] strArr = new String[i10];
            int[] iArr = new int[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                int h10 = e.h(inputStream);
                iArr[i12] = e.h(inputStream);
                strArr[i12] = e.f(inputStream, h10);
            }
            while (i11 < i10) {
                d dVar = dVarArr[i11];
                if (dVar.f16078b.equals(strArr[i11])) {
                    int i13 = iArr[i11];
                    dVar.f16081e = i13;
                    dVar.f16084h = m(inputStream, i13);
                    i11++;
                } else {
                    throw e.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    static d[] t(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        int h10 = e.h(inputStream);
        byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
            try {
                d[] u10 = u(byteArrayInputStream, bArr, h10, dVarArr);
                byteArrayInputStream.close();
                return u10;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw e.c("Content found after the end of file");
        }
        throw th;
    }

    private static d[] u(InputStream inputStream, byte[] bArr, int i10, d[] dVarArr) {
        int i11 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 == dVarArr.length) {
            while (i11 < i10) {
                e.h(inputStream);
                String f10 = e.f(inputStream, e.h(inputStream));
                long i12 = e.i(inputStream);
                int h10 = e.h(inputStream);
                d i13 = i(dVarArr, f10);
                if (i13 != null) {
                    i13.f16080d = i12;
                    int[] m10 = m(inputStream, h10);
                    if (Arrays.equals(bArr, ProfileVersion.V001_N)) {
                        i13.f16081e = h10;
                        i13.f16084h = m10;
                    }
                    i11++;
                } else {
                    throw e.c("Missing profile key: " + f10);
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    private static void v(InputStream inputStream, d dVar) {
        BitSet valueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f16083g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dVar.f16083g;
            if (i10 < i11) {
                int n10 = n(valueOf, i10, i11);
                if (n10 != 0) {
                    Integer num = (Integer) dVar.f16085i.get(Integer.valueOf(i10));
                    if (num == null) {
                        num = 0;
                    }
                    dVar.f16085i.put(Integer.valueOf(i10), Integer.valueOf(n10 | num.intValue()));
                }
                i10++;
            } else {
                return;
            }
        }
    }

    static d[] w(InputStream inputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            int j10 = e.j(inputStream);
            byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    d[] x10 = x(byteArrayInputStream, str, j10);
                    byteArrayInputStream.close();
                    return x10;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported version");
        }
        throw th;
    }

    private static d[] x(InputStream inputStream, String str, int i10) {
        InputStream inputStream2 = inputStream;
        int i11 = i10;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int h10 = e.h(inputStream);
            int h11 = e.h(inputStream);
            String str2 = str;
            int[] iArr = new int[h11];
            dVarArr[i12] = new d(str2, e.f(inputStream2, h10), e.i(inputStream), 0, h11, (int) e.i(inputStream), (int) e.i(inputStream), iArr, new TreeMap());
        }
        for (int i13 = 0; i13 < i11; i13++) {
            d dVar = dVarArr[i13];
            p(inputStream2, dVar);
            dVar.f16084h = m(inputStream2, dVar.f16081e);
            v(inputStream2, dVar);
        }
        return dVarArr;
    }

    private static int y(int i10) {
        return (i10 + 7) & -8;
    }

    private static void z(byte[] bArr, int i10, int i11, d dVar) {
        int l10 = l(i10, i11, dVar.f16083g);
        int i12 = l10 / 8;
        bArr[i12] = (byte) ((1 << (l10 % 8)) | bArr[i12]);
    }
}
