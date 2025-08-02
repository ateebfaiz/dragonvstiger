package rc;

import dd.d;
import java.math.BigInteger;

public class i {
    public int a(d dVar) {
        return (dVar.e() + 7) / 8;
    }

    public byte[] b(BigInteger bigInteger, int i10) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i10 < byteArray.length) {
            byte[] bArr = new byte[i10];
            System.arraycopy(byteArray, byteArray.length - i10, bArr, 0, i10);
            return bArr;
        } else if (i10 <= byteArray.length) {
            return byteArray;
        } else {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(byteArray, 0, bArr2, i10 - byteArray.length, byteArray.length);
            return bArr2;
        }
    }
}
