package qd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sc.a;

public abstract class x {
    public static long a(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            long j10 = 0;
            for (int i12 = i10; i12 < i10 + i11; i12++) {
                j10 = (j10 << 8) | ((long) (bArr[i12] & 255));
            }
            return j10;
        }
        throw new NullPointerException("in == null");
    }

    public static int b(int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (((i10 >> i12) & 1) == 0) {
                return i12;
            }
        }
        return 0;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr2[i10] = bArr[i10];
            }
            return bArr2;
        }
        throw new NullPointerException("in == null");
    }

    public static byte[][] d(byte[][] bArr) {
        if (!k(bArr)) {
            byte[][] bArr2 = new byte[bArr.length][];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr2[i10] = new byte[bArr[i10].length];
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = bArr[i10];
                    if (i11 >= bArr3.length) {
                        break;
                    }
                    bArr2[i10][i11] = bArr3[i11];
                    i11++;
                }
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void e(byte[] bArr, byte[] bArr2, int i10) {
        if (bArr == null) {
            throw new NullPointerException("dst == null");
        } else if (bArr2 == null) {
            throw new NullPointerException("src == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i10 <= bArr.length) {
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                bArr[i10 + i11] = bArr2[i11];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static Object f(byte[] bArr) {
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i11 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i10 + i11 <= bArr.length) {
            byte[] bArr2 = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                bArr2[i12] = bArr[i10 + i12];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static int h(a aVar) {
        if (aVar != null) {
            String algorithmName = aVar.getAlgorithmName();
            if (algorithmName.equals("SHAKE128")) {
                return 32;
            }
            if (algorithmName.equals("SHAKE256")) {
                return 64;
            }
            return aVar.c();
        }
        throw new NullPointerException("digest == null");
    }

    public static int i(long j10, int i10) {
        return (int) (j10 & ((1 << i10) - 1));
    }

    public static long j(long j10, int i10) {
        return j10 >> i10;
    }

    public static boolean k(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(int i10, long j10) {
        if (j10 < 0) {
            throw new IllegalStateException("index must not be negative");
        } else if (j10 < (1 << i10)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m(long j10, int i10, int i11) {
        if (j10 != 0 && (j10 + 1) % ((long) Math.pow((double) (1 << i10), (double) i11)) == 0) {
            return true;
        }
        return false;
    }

    public static int n(int i10) {
        int i11 = 0;
        while (true) {
            i10 >>= 1;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static byte[] o(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] p(long j10, int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            bArr[i11] = (byte) ((int) j10);
            j10 >>>= 8;
        }
        return bArr;
    }
}
