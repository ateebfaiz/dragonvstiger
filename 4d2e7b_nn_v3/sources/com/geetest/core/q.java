package com.geetest.core;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.util.Arrays;

public abstract class q extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f6140a;

    public q(char[] cArr) {
        if (cArr != null) {
            this.f6140a = cArr;
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof q)) {
            return false;
        }
        return Arrays.equals(this.f6140a, ((q) p0Var).f6140a);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        char[] cArr = this.f6140a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ cArr[length];
        }
    }

    public String toString() {
        return new String(this.f6140a);
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f6140a.length * 2);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        int length = this.f6140a.length;
        n0Var.b(z10, 30);
        n0Var.c(length * 2);
        byte[] bArr = new byte[8];
        int i10 = length & -4;
        int i11 = 0;
        while (i11 < i10) {
            char[] cArr = this.f6140a;
            char c10 = cArr[i11];
            char c11 = cArr[i11 + 1];
            char c12 = cArr[i11 + 2];
            char c13 = cArr[i11 + 3];
            i11 += 4;
            bArr[0] = (byte) (c10 >> 8);
            bArr[1] = (byte) c10;
            bArr[2] = (byte) (c11 >> 8);
            bArr[3] = (byte) c11;
            bArr[4] = (byte) (c12 >> 8);
            bArr[5] = (byte) c12;
            bArr[6] = (byte) (c13 >> 8);
            bArr[7] = (byte) c13;
            n0Var.f6110a.write(bArr, 0, 8);
        }
        if (i11 < length) {
            int i12 = 0;
            do {
                char c14 = this.f6140a[i11];
                i11++;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (c14 >> 8);
                i12 += 2;
                bArr[i13] = (byte) c14;
            } while (i11 < length);
            n0Var.f6110a.write(bArr, 0, i12);
        }
    }
}
