package ae;

import java.io.IOException;
import java.io.OutputStream;

public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f18a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19b = new byte[128];

    public e() {
        d();
    }

    private static boolean c(char c10) {
        if (c10 == 10 || c10 == 13 || c10 == 9 || c10 == ' ') {
            return true;
        }
        return false;
    }

    public int a(String str, OutputStream outputStream) {
        int length = str.length();
        while (length > 0 && c(str.charAt(length - 1))) {
            length--;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            while (i10 < length && c(str.charAt(i10))) {
                i10++;
            }
            int i12 = i10 + 1;
            byte b10 = this.f19b[str.charAt(i10)];
            while (i12 < length && c(str.charAt(i12))) {
                i12++;
            }
            int i13 = i12 + 1;
            byte b11 = this.f19b[str.charAt(i12)];
            if ((b10 | b11) >= 0) {
                outputStream.write((b10 << 4) | b11);
                i11++;
                i10 = i13;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        return i11;
    }

    public int b(byte[] bArr, int i10, int i11, OutputStream outputStream) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            byte b10 = bArr[i12];
            outputStream.write(this.f18a[(b10 & 255) >>> 4]);
            outputStream.write(this.f18a[b10 & 15]);
        }
        return i11 * 2;
    }

    /* access modifiers changed from: protected */
    public void d() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f19b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.f18a;
            if (i10 < bArr2.length) {
                this.f19b[bArr2[i10]] = (byte) i10;
                i10++;
            } else {
                byte[] bArr3 = this.f19b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }
}
