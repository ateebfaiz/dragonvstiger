package u1;

public abstract class h {
    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, 22, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr3[i10] = (byte) (bArr[i10] ^ bArr2[(bArr.length + i10) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }
}
