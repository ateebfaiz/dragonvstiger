package c1;

import kotlin.jvm.internal.m;
import kotlin.text.a;

public abstract class e {
    public static final String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            i10++;
            byte b11 = b10 & 255;
            if (b11 < 16) {
                sb2.append('0');
            }
            String num = Integer.toString(b11, a.a(16));
            m.e(num, "toString(this, checkRadix(radix))");
            sb2.append(num);
        }
        String sb3 = sb2.toString();
        m.e(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
