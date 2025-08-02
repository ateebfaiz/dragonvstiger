package g8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.io.a;
import com.fasterxml.jackson.core.io.c;
import com.fasterxml.jackson.core.io.f;
import com.fasterxml.jackson.core.j;
import com.fasterxml.jackson.core.l;
import com.fasterxml.jackson.core.m;
import com.fasterxml.jackson.core.n;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class d extends b {
    protected static final char[] Y0 = a.c();
    protected final Writer P0;
    protected char Q0;
    protected char[] R0;
    protected int S0;
    protected int T0;
    protected int U0;
    protected char[] V0;
    protected n W0;
    protected char[] X0;

    public d(c cVar, int i10, l lVar, Writer writer, char c10) {
        super(cVar, i10, lVar);
        this.P0 = writer;
        char[] e10 = cVar.e();
        this.R0 = e10;
        this.U0 = e10.length;
        this.Q0 = c10;
        if (c10 != '\"') {
            this.C = a.e(c10);
        }
    }

    private char[] E0() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.V0 = cArr;
        return cArr;
    }

    private void F0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            if (this.T0 + 2 > this.U0) {
                G0();
            }
            char[] cArr = this.R0;
            int i12 = this.T0;
            cArr[i12] = '\\';
            this.T0 = i12 + 2;
            cArr[i12 + 1] = (char) i10;
        } else if (i10 != -2) {
            if (this.T0 + 5 >= this.U0) {
                G0();
            }
            int i13 = this.T0;
            char[] cArr2 = this.R0;
            cArr2[i13] = '\\';
            int i14 = i13 + 2;
            cArr2[i13 + 1] = 'u';
            if (c10 > 255) {
                int i15 = c10 >> 8;
                int i16 = i13 + 3;
                char[] cArr3 = Y0;
                cArr2[i14] = cArr3[(i15 & 255) >> 4];
                i11 = i13 + 4;
                cArr2[i16] = cArr3[i15 & 15];
                c10 = (char) (c10 & 255);
            } else {
                int i17 = i13 + 3;
                cArr2[i14] = '0';
                i11 = i13 + 4;
                cArr2[i17] = '0';
            }
            char[] cArr4 = Y0;
            cArr2[i11] = cArr4[c10 >> 4];
            cArr2[i11 + 1] = cArr4[c10 & 15];
            this.T0 = i11 + 2;
        } else {
            this.W0.getClass();
            String value = this.W0.getValue();
            this.W0 = null;
            int length = value.length();
            if (this.T0 + length > this.U0) {
                G0();
                if (length > this.U0) {
                    this.P0.write(value);
                    return;
                }
            }
            value.getChars(0, length, this.R0, this.T0);
            this.T0 += length;
        }
    }

    private int H0(char[] cArr, int i10, int i11, char c10, int i12) {
        int i13;
        if (i12 >= 0) {
            if (i10 <= 1 || i10 >= i11) {
                char[] cArr2 = this.V0;
                if (cArr2 == null) {
                    cArr2 = E0();
                }
                cArr2[1] = (char) i12;
                this.P0.write(cArr2, 0, 2);
                return i10;
            }
            int i14 = i10 - 2;
            cArr[i14] = '\\';
            cArr[i10 - 1] = (char) i12;
            return i14;
        } else if (i12 == -2) {
            this.W0.getClass();
            String value = this.W0.getValue();
            this.W0 = null;
            int length = value.length();
            if (i10 < length || i10 >= i11) {
                this.P0.write(value);
                return i10;
            }
            int i15 = i10 - length;
            value.getChars(0, length, cArr, i15);
            return i15;
        } else if (i10 <= 5 || i10 >= i11) {
            char[] cArr3 = this.V0;
            if (cArr3 == null) {
                cArr3 = E0();
            }
            this.S0 = this.T0;
            if (c10 > 255) {
                int i16 = c10 >> 8;
                char[] cArr4 = Y0;
                cArr3[10] = cArr4[(i16 & 255) >> 4];
                cArr3[11] = cArr4[i16 & 15];
                cArr3[12] = cArr4[(c10 & 255) >> 4];
                cArr3[13] = cArr4[c10 & 15];
                this.P0.write(cArr3, 8, 6);
                return i10;
            }
            char[] cArr5 = Y0;
            cArr3[6] = cArr5[c10 >> 4];
            cArr3[7] = cArr5[c10 & 15];
            this.P0.write(cArr3, 2, 6);
            return i10;
        } else {
            cArr[i10 - 6] = '\\';
            int i17 = i10 - 4;
            cArr[i10 - 5] = 'u';
            if (c10 > 255) {
                int i18 = c10 >> 8;
                int i19 = i10 - 3;
                char[] cArr6 = Y0;
                cArr[i17] = cArr6[(i18 & 255) >> 4];
                i13 = i10 - 2;
                cArr[i19] = cArr6[i18 & 15];
                c10 = (char) (c10 & 255);
            } else {
                int i20 = i10 - 3;
                cArr[i17] = '0';
                i13 = i10 - 2;
                cArr[i20] = '0';
            }
            char[] cArr7 = Y0;
            cArr[i13] = cArr7[c10 >> 4];
            cArr[i13 + 1] = cArr7[c10 & 15];
            return i13 - 4;
        }
    }

    private void I0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            int i12 = this.T0;
            if (i12 >= 2) {
                int i13 = i12 - 2;
                this.S0 = i13;
                char[] cArr = this.R0;
                cArr[i13] = '\\';
                cArr[i12 - 1] = (char) i10;
                return;
            }
            char[] cArr2 = this.V0;
            if (cArr2 == null) {
                cArr2 = E0();
            }
            this.S0 = this.T0;
            cArr2[1] = (char) i10;
            this.P0.write(cArr2, 0, 2);
        } else if (i10 != -2) {
            int i14 = this.T0;
            if (i14 >= 6) {
                char[] cArr3 = this.R0;
                int i15 = i14 - 6;
                this.S0 = i15;
                cArr3[i15] = '\\';
                cArr3[i14 - 5] = 'u';
                if (c10 > 255) {
                    int i16 = c10 >> 8;
                    char[] cArr4 = Y0;
                    cArr3[i14 - 4] = cArr4[(i16 & 255) >> 4];
                    i11 = i14 - 3;
                    cArr3[i11] = cArr4[i16 & 15];
                    c10 = (char) (c10 & 255);
                } else {
                    cArr3[i14 - 4] = '0';
                    i11 = i14 - 3;
                    cArr3[i11] = '0';
                }
                char[] cArr5 = Y0;
                cArr3[i11 + 1] = cArr5[c10 >> 4];
                cArr3[i11 + 2] = cArr5[c10 & 15];
                return;
            }
            char[] cArr6 = this.V0;
            if (cArr6 == null) {
                cArr6 = E0();
            }
            this.S0 = this.T0;
            if (c10 > 255) {
                int i17 = c10 >> 8;
                char[] cArr7 = Y0;
                cArr6[10] = cArr7[(i17 & 255) >> 4];
                cArr6[11] = cArr7[i17 & 15];
                cArr6[12] = cArr7[(c10 & 255) >> 4];
                cArr6[13] = cArr7[c10 & 15];
                this.P0.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = Y0;
            cArr6[6] = cArr8[c10 >> 4];
            cArr6[7] = cArr8[c10 & 15];
            this.P0.write(cArr6, 2, 6);
        } else {
            this.W0.getClass();
            String value = this.W0.getValue();
            this.W0 = null;
            int length = value.length();
            int i18 = this.T0;
            if (i18 >= length) {
                int i19 = i18 - length;
                this.S0 = i19;
                value.getChars(0, length, this.R0, i19);
                return;
            }
            this.S0 = i18;
            this.P0.write(value);
        }
    }

    private int J0(InputStream inputStream, byte[] bArr, int i10, int i11, int i12) {
        int i13 = 0;
        while (i10 < i11) {
            bArr[i13] = bArr[i10];
            i13++;
            i10++;
        }
        int min = Math.min(i12, bArr.length);
        do {
            int i14 = min - i13;
            if (i14 == 0) {
                break;
            }
            int read = inputStream.read(bArr, i13, i14);
            if (read < 0) {
                return i13;
            }
            i13 += read;
        } while (i13 < 3);
        return i13;
    }

    private final void Q0(n nVar) {
        char[] a10 = nVar.a();
        j0(a10, 0, a10.length);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
    }

    private void R0(String str) {
        G0();
        int length = str.length();
        int i10 = 0;
        while (true) {
            int i11 = this.U0;
            if (i10 + i11 > length) {
                i11 = length - i10;
            }
            int i12 = i10 + i11;
            str.getChars(i10, i12, this.R0, 0);
            int i13 = this.X;
            if (i13 != 0) {
                a1(i11, i13);
            } else {
                Z0(i11);
            }
            if (i12 < length) {
                i10 = i12;
            } else {
                return;
            }
        }
    }

    private final void S0() {
        if (this.T0 + 4 >= this.U0) {
            G0();
        }
        int i10 = this.T0;
        char[] cArr = this.R0;
        cArr[i10] = 'n';
        cArr[i10 + 1] = 'u';
        cArr[i10 + 2] = 'l';
        cArr[i10 + 3] = 'l';
        this.T0 = i10 + 4;
    }

    private void V0(int i10) {
        if (this.T0 + 13 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i11 = this.T0;
        int i12 = i11 + 1;
        this.T0 = i12;
        cArr[i11] = this.Q0;
        int j10 = f.j(i10, cArr, i12);
        char[] cArr2 = this.R0;
        this.T0 = j10 + 1;
        cArr2[j10] = this.Q0;
    }

    private void W0(long j10) {
        if (this.T0 + 23 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        int i11 = i10 + 1;
        this.T0 = i11;
        cArr[i10] = this.Q0;
        int k10 = f.k(j10, cArr, i11);
        char[] cArr2 = this.R0;
        this.T0 = k10 + 1;
        cArr2[k10] = this.Q0;
    }

    private void X0(String str) {
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
        i0(str);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr2[i11] = this.Q0;
    }

    private void Y0(short s10) {
        if (this.T0 + 8 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        int i11 = i10 + 1;
        this.T0 = i11;
        cArr[i10] = this.Q0;
        int j10 = f.j(s10, cArr, i11);
        char[] cArr2 = this.R0;
        this.T0 = j10 + 1;
        cArr2[j10] = this.Q0;
    }

    private void Z0(int i10) {
        char[] cArr;
        char c10;
        int[] iArr = this.C;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            do {
                cArr = this.R0;
                c10 = cArr[i11];
                if ((c10 < length && iArr[c10] != 0) || (i11 = i11 + 1) >= i10) {
                    int i13 = i11 - i12;
                }
                cArr = this.R0;
                c10 = cArr[i11];
                break;
            } while ((i11 = i11 + 1) >= i10);
            int i132 = i11 - i12;
            if (i132 > 0) {
                this.P0.write(cArr, i12, i132);
                if (i11 >= i10) {
                    return;
                }
            }
            i11++;
            i12 = H0(this.R0, i11, i10, c10, iArr[c10]);
        }
    }

    private void a1(int i10, int i11) {
        char[] cArr;
        char c10;
        int[] iArr = this.C;
        int min = Math.min(iArr.length, i11 + 1);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i10) {
            while (true) {
                cArr = this.R0;
                c10 = cArr[i12];
                if (c10 >= min) {
                    if (c10 > i11) {
                        i14 = -1;
                        break;
                    }
                } else {
                    i14 = iArr[c10];
                    if (i14 != 0) {
                        break;
                    }
                }
                i12++;
                if (i12 >= i10) {
                    break;
                }
            }
            int i15 = i12 - i13;
            if (i15 > 0) {
                this.P0.write(cArr, i13, i15);
                if (i12 >= i10) {
                    return;
                }
            }
            i12++;
            i13 = H0(this.R0, i12, i10, c10, i14);
        }
    }

    private void b1(String str) {
        int length = str.length();
        int i10 = this.U0;
        if (length > i10) {
            R0(str);
            return;
        }
        if (this.T0 + length > i10) {
            G0();
        }
        str.getChars(0, length, this.R0, this.T0);
        int i11 = this.X;
        if (i11 != 0) {
            f1(length, i11);
        } else {
            d1(length);
        }
    }

    private void c1(char[] cArr, int i10, int i11) {
        int i12 = this.X;
        if (i12 != 0) {
            g1(cArr, i10, i11, i12);
            return;
        }
        int i13 = i11 + i10;
        int[] iArr = this.C;
        int length = iArr.length;
        while (i10 < i13) {
            int i14 = i10;
            do {
                char c10 = cArr[i14];
                if ((c10 < length && iArr[c10] != 0) || (i14 = i14 + 1) >= i13) {
                    int i15 = i14 - i10;
                }
                char c102 = cArr[i14];
                break;
            } while ((i14 = i14 + 1) >= i13);
            int i152 = i14 - i10;
            if (i152 < 32) {
                if (this.T0 + i152 > this.U0) {
                    G0();
                }
                if (i152 > 0) {
                    System.arraycopy(cArr, i10, this.R0, this.T0, i152);
                    this.T0 += i152;
                }
            } else {
                G0();
                this.P0.write(cArr, i10, i152);
            }
            if (i14 < i13) {
                i10 = i14 + 1;
                char c11 = cArr[i14];
                F0(c11, iArr[c11]);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r6.R0;
        r3 = r6.T0;
        r6.T0 = r3 + 1;
        r2 = r2[r3];
        I0(r2, r7[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r4 = r6.S0;
        r3 = r3 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3 <= 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r6.P0.write(r2, r4, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d1(int r7) {
        /*
            r6 = this;
            int r0 = r6.T0
            int r0 = r0 + r7
            int[] r7 = r6.C
            int r1 = r7.length
        L_0x0006:
            int r2 = r6.T0
            if (r2 >= r0) goto L_0x0036
        L_0x000a:
            char[] r2 = r6.R0
            int r3 = r6.T0
            char r4 = r2[r3]
            if (r4 >= r1) goto L_0x0030
            r4 = r7[r4]
            if (r4 == 0) goto L_0x0030
            int r4 = r6.S0
            int r3 = r3 - r4
            if (r3 <= 0) goto L_0x0020
            java.io.Writer r5 = r6.P0
            r5.write(r2, r4, r3)
        L_0x0020:
            char[] r2 = r6.R0
            int r3 = r6.T0
            int r4 = r3 + 1
            r6.T0 = r4
            char r2 = r2[r3]
            r3 = r7[r2]
            r6.I0(r2, r3)
            goto L_0x0006
        L_0x0030:
            int r3 = r3 + 1
            r6.T0 = r3
            if (r3 < r0) goto L_0x000a
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g8.d.d1(int):void");
    }

    private void e1(n nVar) {
        char[] a10 = nVar.a();
        int length = a10.length;
        if (length < 32) {
            if (length > this.U0 - this.T0) {
                G0();
            }
            System.arraycopy(a10, 0, this.R0, this.T0, length);
            this.T0 += length;
        } else {
            G0();
            this.P0.write(a10, 0, length);
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f1(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.T0
            int r0 = r0 + r9
            int[] r9 = r8.C
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        L_0x000c:
            int r2 = r8.T0
            if (r2 >= r0) goto L_0x003a
        L_0x0010:
            char[] r2 = r8.R0
            int r3 = r8.T0
            char r4 = r2[r3]
            if (r4 >= r1) goto L_0x001d
            r5 = r9[r4]
            if (r5 == 0) goto L_0x0034
            goto L_0x0020
        L_0x001d:
            if (r4 <= r10) goto L_0x0034
            r5 = -1
        L_0x0020:
            int r6 = r8.S0
            int r3 = r3 - r6
            if (r3 <= 0) goto L_0x002a
            java.io.Writer r7 = r8.P0
            r7.write(r2, r6, r3)
        L_0x002a:
            int r2 = r8.T0
            int r2 = r2 + 1
            r8.T0 = r2
            r8.I0(r4, r5)
            goto L_0x000c
        L_0x0034:
            int r3 = r3 + 1
            r8.T0 = r3
            if (r3 < r0) goto L_0x0010
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g8.d.f1(int, int):void");
    }

    private void g1(char[] cArr, int i10, int i11, int i12) {
        char c10;
        int i13 = i11 + i10;
        int[] iArr = this.C;
        int min = Math.min(iArr.length, i12 + 1);
        int i14 = 0;
        while (i10 < i13) {
            int i15 = i10;
            while (true) {
                c10 = cArr[i15];
                if (c10 >= min) {
                    if (c10 > i12) {
                        i14 = -1;
                        break;
                    }
                } else {
                    i14 = iArr[c10];
                    if (i14 != 0) {
                        break;
                    }
                }
                i15++;
                if (i15 >= i13) {
                    break;
                }
            }
            int i16 = i15 - i10;
            if (i16 < 32) {
                if (this.T0 + i16 > this.U0) {
                    G0();
                }
                if (i16 > 0) {
                    System.arraycopy(cArr, i10, this.R0, this.T0, i16);
                    this.T0 += i16;
                }
            } else {
                G0();
                this.P0.write(cArr, i10, i16);
            }
            if (i15 < i13) {
                i10 = i15 + 1;
                F0(c10, i14);
            } else {
                return;
            }
        }
    }

    private void h1(String str) {
        int i10 = this.U0;
        int i11 = this.T0;
        int i12 = i10 - i11;
        str.getChars(0, i12, this.R0, i11);
        this.T0 += i12;
        G0();
        int length = str.length() - i12;
        while (true) {
            int i13 = this.U0;
            if (length > i13) {
                int i14 = i12 + i13;
                str.getChars(i12, i14, this.R0, 0);
                this.S0 = 0;
                this.T0 = i13;
                G0();
                length -= i13;
                i12 = i14;
            } else {
                str.getChars(i12, i12 + length, this.R0, 0);
                this.S0 = 0;
                this.T0 = length;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void A0(String str) {
        char c10;
        int t10 = this.f11964h.t();
        if (this.f5094a != null) {
            C0(str, t10);
            return;
        }
        if (t10 == 1) {
            c10 = ',';
        } else if (t10 == 2) {
            c10 = ':';
        } else if (t10 == 3) {
            n nVar = this.Y;
            if (nVar != null) {
                i0(nVar.getValue());
                return;
            }
            return;
        } else if (t10 == 5) {
            B0(str);
            return;
        } else {
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = c10;
    }

    /* access modifiers changed from: protected */
    public void G0() {
        int i10 = this.T0;
        int i11 = this.S0;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.S0 = 0;
            this.T0 = 0;
            this.P0.write(this.R0, i11, i12);
        }
    }

    /* JADX INFO: finally extract failed */
    public int J(com.fasterxml.jackson.core.a aVar, InputStream inputStream, int i10) {
        A0("write a binary value");
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr[i11] = this.Q0;
        byte[] d10 = this.f12221w.d();
        if (i10 < 0) {
            try {
                i10 = L0(aVar, inputStream, d10);
            } catch (Throwable th) {
                this.f12221w.g(d10);
                throw th;
            }
        } else {
            int M0 = M0(aVar, inputStream, d10, i10);
            if (M0 > 0) {
                a("Too few bytes available: missing " + M0 + " bytes (out of " + i10 + ")");
            }
        }
        this.f12221w.g(d10);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i12 = this.T0;
        this.T0 = i12 + 1;
        cArr2[i12] = this.Q0;
        return i10;
    }

    /* access modifiers changed from: protected */
    public void K0() {
        char[] cArr = this.R0;
        if (cArr != null) {
            this.R0 = null;
            this.f12221w.h(cArr);
        }
        char[] cArr2 = this.X0;
        if (cArr2 != null) {
            this.X0 = null;
            this.f12221w.i(cArr2);
        }
    }

    public void L(com.fasterxml.jackson.core.a aVar, byte[] bArr, int i10, int i11) {
        A0("write a binary value");
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i12 = this.T0;
        this.T0 = i12 + 1;
        cArr[i12] = this.Q0;
        N0(aVar, bArr, i10, i11 + i10);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i13 = this.T0;
        this.T0 = i13 + 1;
        cArr2[i13] = this.Q0;
    }

    /* access modifiers changed from: protected */
    public final int L0(com.fasterxml.jackson.core.a aVar, InputStream inputStream, byte[] bArr) {
        com.fasterxml.jackson.core.a aVar2 = aVar;
        byte[] bArr2 = bArr;
        int i10 = this.U0 - 6;
        int i11 = 2;
        int i12 = -3;
        int h10 = aVar.h() >> 2;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 > i12) {
                i14 = J0(inputStream, bArr, i13, i14, bArr2.length);
                if (i14 < 3) {
                    break;
                }
                i12 = i14 - 3;
                i13 = 0;
            }
            if (this.T0 > i10) {
                G0();
            }
            int i16 = i13 + 2;
            byte b10 = bArr2[i13 + 1] & 255;
            i13 += 3;
            i15 += 3;
            int c10 = aVar2.c(((b10 | (bArr2[i13] << 8)) << 8) | (bArr2[i16] & 255), this.R0, this.T0);
            this.T0 = c10;
            h10--;
            if (h10 <= 0) {
                char[] cArr = this.R0;
                cArr[c10] = '\\';
                this.T0 = c10 + 2;
                cArr[c10 + 1] = 'n';
                h10 = aVar.h() >> 2;
            }
        }
        if (i14 <= 0) {
            return i15;
        }
        if (this.T0 > i10) {
            G0();
        }
        int i17 = bArr2[0] << 16;
        if (1 < i14) {
            i17 |= (bArr2[1] & 255) << 8;
        } else {
            i11 = 1;
        }
        int i18 = i15 + i11;
        this.T0 = aVar2.e(i17, i11, this.R0, this.T0);
        return i18;
    }

    /* access modifiers changed from: protected */
    public final int M0(com.fasterxml.jackson.core.a aVar, InputStream inputStream, byte[] bArr, int i10) {
        int J0;
        com.fasterxml.jackson.core.a aVar2 = aVar;
        int i11 = this.U0 - 6;
        int i12 = 2;
        int i13 = -3;
        int i14 = i10;
        int h10 = aVar.h() >> 2;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            if (i14 <= 2) {
                break;
            }
            if (i15 > i13) {
                i16 = J0(inputStream, bArr, i15, i16, i14);
                if (i16 < 3) {
                    i15 = 0;
                    break;
                }
                i13 = i16 - 3;
                i15 = 0;
            }
            if (this.T0 > i11) {
                G0();
            }
            int i17 = i15 + 2;
            byte b10 = bArr[i15 + 1] & 255;
            i15 += 3;
            i14 -= 3;
            int c10 = aVar.c(((b10 | (bArr[i15] << 8)) << 8) | (bArr[i17] & 255), this.R0, this.T0);
            this.T0 = c10;
            h10--;
            if (h10 <= 0) {
                char[] cArr = this.R0;
                cArr[c10] = '\\';
                this.T0 = c10 + 2;
                cArr[c10 + 1] = 'n';
                h10 = aVar.h() >> 2;
            }
        }
        if (i14 <= 0 || (J0 = J0(inputStream, bArr, i15, i16, i14)) <= 0) {
            return i14;
        }
        if (this.T0 > i11) {
            G0();
        }
        int i18 = bArr[0] << 16;
        if (1 < J0) {
            i18 |= (bArr[1] & 255) << 8;
        } else {
            i12 = 1;
        }
        this.T0 = aVar.e(i18, i12, this.R0, this.T0);
        return i14 - i12;
    }

    /* access modifiers changed from: protected */
    public final void N0(com.fasterxml.jackson.core.a aVar, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 3;
        int i13 = this.U0 - 6;
        int h10 = aVar.h();
        loop0:
        while (true) {
            int i14 = h10 >> 2;
            while (i10 <= i12) {
                if (this.T0 > i13) {
                    G0();
                }
                int i15 = i10 + 2;
                byte b10 = bArr[i10 + 1] & 255;
                i10 += 3;
                int c10 = aVar.c(((b10 | (bArr[i10] << 8)) << 8) | (bArr[i15] & 255), this.R0, this.T0);
                this.T0 = c10;
                i14--;
                if (i14 <= 0) {
                    char[] cArr = this.R0;
                    cArr[c10] = '\\';
                    this.T0 = c10 + 2;
                    cArr[c10 + 1] = 'n';
                    h10 = aVar.h();
                }
            }
            break loop0;
        }
        int i16 = i11 - i10;
        if (i16 > 0) {
            if (this.T0 > i13) {
                G0();
            }
            int i17 = i10 + 1;
            int i18 = bArr[i10] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & 255) << 8;
            }
            this.T0 = aVar.e(i18, i16, this.R0, this.T0);
        }
    }

    public void O(boolean z10) {
        int i10;
        A0("write a boolean value");
        if (this.T0 + 5 >= this.U0) {
            G0();
        }
        int i11 = this.T0;
        char[] cArr = this.R0;
        if (z10) {
            cArr[i11] = 't';
            cArr[i11 + 1] = 'r';
            cArr[i11 + 2] = 'u';
            i10 = i11 + 3;
            cArr[i10] = 'e';
        } else {
            cArr[i11] = 'f';
            cArr[i11 + 1] = 'a';
            cArr[i11 + 2] = 'l';
            cArr[i11 + 3] = 's';
            i10 = i11 + 4;
            cArr[i10] = 'e';
        }
        this.T0 = i10 + 1;
    }

    /* access modifiers changed from: protected */
    public final void O0(n nVar, boolean z10) {
        if (this.f5094a != null) {
            T0(nVar, z10);
            return;
        }
        if (this.T0 + 1 >= this.U0) {
            G0();
        }
        if (z10) {
            char[] cArr = this.R0;
            int i10 = this.T0;
            this.T0 = i10 + 1;
            cArr[i10] = ',';
        }
        if (this.Z) {
            char[] a10 = nVar.a();
            j0(a10, 0, a10.length);
            return;
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        int i12 = i11 + 1;
        this.T0 = i12;
        cArr2[i11] = this.Q0;
        int c10 = nVar.c(cArr2, i12);
        if (c10 < 0) {
            Q0(nVar);
            return;
        }
        int i13 = this.T0 + c10;
        this.T0 = i13;
        if (i13 >= this.U0) {
            G0();
        }
        char[] cArr3 = this.R0;
        int i14 = this.T0;
        this.T0 = i14 + 1;
        cArr3[i14] = this.Q0;
    }

    public void P() {
        if (!this.f11964h.d()) {
            a("Current context not Array but " + this.f11964h.f());
        }
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.k(this, this.f11964h.c());
        } else {
            if (this.T0 >= this.U0) {
                G0();
            }
            char[] cArr = this.R0;
            int i10 = this.T0;
            this.T0 = i10 + 1;
            cArr[i10] = ']';
        }
        this.f11964h = this.f11964h.h();
    }

    /* access modifiers changed from: protected */
    public final void P0(String str, boolean z10) {
        if (this.f5094a != null) {
            U0(str, z10);
            return;
        }
        if (this.T0 + 1 >= this.U0) {
            G0();
        }
        if (z10) {
            char[] cArr = this.R0;
            int i10 = this.T0;
            this.T0 = i10 + 1;
            cArr[i10] = ',';
        }
        if (this.Z) {
            b1(str);
            return;
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr2[i11] = this.Q0;
        b1(str);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr3 = this.R0;
        int i12 = this.T0;
        this.T0 = i12 + 1;
        cArr3[i12] = this.Q0;
    }

    public void Q() {
        if (!this.f11964h.e()) {
            a("Current context not Object but " + this.f11964h.f());
        }
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.f(this, this.f11964h.c());
        } else {
            if (this.T0 >= this.U0) {
                G0();
            }
            char[] cArr = this.R0;
            int i10 = this.T0;
            this.T0 = i10 + 1;
            cArr[i10] = '}';
        }
        this.f11964h = this.f11964h.h();
    }

    public void S(n nVar) {
        int s10 = this.f11964h.s(nVar.getValue());
        if (s10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        boolean z10 = true;
        if (s10 != 1) {
            z10 = false;
        }
        O0(nVar, z10);
    }

    public void T(String str) {
        int s10 = this.f11964h.s(str);
        if (s10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        boolean z10 = true;
        if (s10 != 1) {
            z10 = false;
        }
        P0(str, z10);
    }

    /* access modifiers changed from: protected */
    public final void T0(n nVar, boolean z10) {
        if (z10) {
            this.f5094a.j(this);
        } else {
            this.f5094a.d(this);
        }
        char[] a10 = nVar.a();
        if (this.Z) {
            j0(a10, 0, a10.length);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
        j0(a10, 0, a10.length);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr2[i11] = this.Q0;
    }

    public void U() {
        A0("write a null");
        S0();
    }

    /* access modifiers changed from: protected */
    public final void U0(String str, boolean z10) {
        if (z10) {
            this.f5094a.j(this);
        } else {
            this.f5094a.d(this);
        }
        if (this.Z) {
            b1(str);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
        b1(str);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr2[i11] = this.Q0;
    }

    public void V(double d10) {
        if (this.f11963g || (f.h(d10) && y(f.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            s0(String.valueOf(d10));
            return;
        }
        A0("write a number");
        i0(String.valueOf(d10));
    }

    public void W(float f10) {
        if (this.f11963g || (com.fasterxml.jackson.core.io.f.i(f10) && y(f.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            s0(String.valueOf(f10));
            return;
        }
        A0("write a number");
        i0(String.valueOf(f10));
    }

    public void X(int i10) {
        A0("write a number");
        if (this.f11963g) {
            V0(i10);
            return;
        }
        if (this.T0 + 11 >= this.U0) {
            G0();
        }
        this.T0 = com.fasterxml.jackson.core.io.f.j(i10, this.R0, this.T0);
    }

    public void Y(long j10) {
        A0("write a number");
        if (this.f11963g) {
            W0(j10);
            return;
        }
        if (this.T0 + 21 >= this.U0) {
            G0();
        }
        this.T0 = com.fasterxml.jackson.core.io.f.k(j10, this.R0, this.T0);
    }

    public void Z(String str) {
        A0("write a number");
        if (str == null) {
            S0();
        } else if (this.f11963g) {
            X0(str);
        } else {
            i0(str);
        }
    }

    public void a0(BigDecimal bigDecimal) {
        A0("write a number");
        if (bigDecimal == null) {
            S0();
        } else if (this.f11963g) {
            X0(y0(bigDecimal));
        } else {
            i0(y0(bigDecimal));
        }
    }

    public void b0(BigInteger bigInteger) {
        A0("write a number");
        if (bigInteger == null) {
            S0();
        } else if (this.f11963g) {
            X0(bigInteger.toString());
        } else {
            i0(bigInteger.toString());
        }
    }

    public void c0(short s10) {
        A0("write a number");
        if (this.f11963g) {
            Y0(s10);
            return;
        }
        if (this.T0 + 6 >= this.U0) {
            G0();
        }
        this.T0 = com.fasterxml.jackson.core.io.f.j(s10, this.R0, this.T0);
    }

    public void close() {
        super.close();
        if (this.R0 != null && y(f.b.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                j v10 = v();
                if (!v10.d()) {
                    if (!v10.e()) {
                        break;
                    }
                    Q();
                } else {
                    P();
                }
            }
        }
        G0();
        this.S0 = 0;
        this.T0 = 0;
        if (this.P0 != null) {
            if (this.f12221w.f() || y(f.b.AUTO_CLOSE_TARGET)) {
                this.P0.close();
            } else if (y(f.b.FLUSH_PASSED_TO_STREAM)) {
                this.P0.flush();
            }
        }
        K0();
    }

    public void flush() {
        G0();
        if (this.P0 != null && y(f.b.FLUSH_PASSED_TO_STREAM)) {
            this.P0.flush();
        }
    }

    public void g0(char c10) {
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = c10;
    }

    public void h0(n nVar) {
        int b10 = nVar.b(this.R0, this.T0);
        if (b10 < 0) {
            i0(nVar.getValue());
        } else {
            this.T0 += b10;
        }
    }

    public void i0(String str) {
        int length = str.length();
        int i10 = this.U0 - this.T0;
        if (i10 == 0) {
            G0();
            i10 = this.U0 - this.T0;
        }
        if (i10 >= length) {
            str.getChars(0, length, this.R0, this.T0);
            this.T0 += length;
            return;
        }
        h1(str);
    }

    public void j0(char[] cArr, int i10, int i11) {
        if (i11 < 32) {
            if (i11 > this.U0 - this.T0) {
                G0();
            }
            System.arraycopy(cArr, i10, this.R0, this.T0, i11);
            this.T0 += i11;
            return;
        }
        G0();
        this.P0.write(cArr, i10, i11);
    }

    public void l0() {
        A0("start an array");
        this.f11964h = this.f11964h.i();
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.h(this);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = '[';
    }

    public void m0(Object obj) {
        A0("start an array");
        this.f11964h = this.f11964h.j(obj);
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.h(this);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = '[';
    }

    public void n0(Object obj, int i10) {
        A0("start an array");
        this.f11964h = this.f11964h.j(obj);
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.h(this);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr[i11] = '[';
    }

    public void o0() {
        A0("start an object");
        this.f11964h = this.f11964h.k();
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.a(this);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = '{';
    }

    public void p0(Object obj) {
        A0("start an object");
        this.f11964h = this.f11964h.l(obj);
        m mVar = this.f5094a;
        if (mVar != null) {
            mVar.a(this);
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = '{';
    }

    public void r0(n nVar) {
        A0("write a string");
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        int i11 = i10 + 1;
        this.T0 = i11;
        cArr[i10] = this.Q0;
        int c10 = nVar.c(cArr, i11);
        if (c10 < 0) {
            e1(nVar);
            return;
        }
        int i12 = this.T0 + c10;
        this.T0 = i12;
        if (i12 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i13 = this.T0;
        this.T0 = i13 + 1;
        cArr2[i13] = this.Q0;
    }

    public void s0(String str) {
        A0("write a string");
        if (str == null) {
            S0();
            return;
        }
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr = this.R0;
        int i10 = this.T0;
        this.T0 = i10 + 1;
        cArr[i10] = this.Q0;
        b1(str);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i11 = this.T0;
        this.T0 = i11 + 1;
        cArr2[i11] = this.Q0;
    }

    public void t0(char[] cArr, int i10, int i11) {
        A0("write a string");
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr2 = this.R0;
        int i12 = this.T0;
        this.T0 = i12 + 1;
        cArr2[i12] = this.Q0;
        c1(cArr, i10, i11);
        if (this.T0 >= this.U0) {
            G0();
        }
        char[] cArr3 = this.R0;
        int i13 = this.T0;
        this.T0 = i13 + 1;
        cArr3[i13] = this.Q0;
    }
}
