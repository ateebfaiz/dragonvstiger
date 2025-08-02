package f1;

import androidx.core.view.MotionEventCompat;
import f1.h;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class k {

    /* renamed from: g  reason: collision with root package name */
    private static final Charset f21444g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private int f21445a;

    /* renamed from: b  reason: collision with root package name */
    private long f21446b;

    /* renamed from: c  reason: collision with root package name */
    private OutputStream f21447c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f21448d;

    /* renamed from: e  reason: collision with root package name */
    private final u f21449e;

    /* renamed from: f  reason: collision with root package name */
    private final h.e f21450f;

    public interface a {
        void a(k kVar, Object obj);
    }

    k(int i10, u uVar) {
        this(new byte[i10], uVar);
    }

    private void b(int i10, int i11) {
        OutputStream outputStream = this.f21447c;
        if (outputStream != null) {
            try {
                outputStream.write(this.f21448d, 0, i10);
                this.f21445a = 0;
                this.f21446b += (long) i10;
                byte[] bArr = this.f21448d;
                if (i11 > bArr.length) {
                    this.f21448d = Arrays.copyOf(bArr, bArr.length + (bArr.length / 2) + i11);
                }
            } catch (IOException e10) {
                throw new p("Unable to write to target stream.", e10);
            }
        } else {
            byte[] bArr2 = this.f21448d;
            this.f21448d = Arrays.copyOf(bArr2, bArr2.length + (bArr2.length / 2) + i11);
        }
    }

    private void o(CharSequence charSequence, int i10, int i11, int i12) {
        CharSequence charSequence2 = charSequence;
        byte[] bArr = this.f21448d;
        int i13 = i10;
        int i14 = i11;
        while (i13 < i12) {
            char charAt = charSequence2.charAt(i13);
            if (charAt == '\"') {
                int i15 = i14 + 1;
                bArr[i14] = 92;
                i14 += 2;
                bArr[i15] = 34;
            } else if (charAt == '\\') {
                int i16 = i14 + 1;
                bArr[i14] = 92;
                i14 += 2;
                bArr[i16] = 92;
            } else if (charAt < ' ') {
                if (charAt == 8) {
                    int i17 = i14 + 1;
                    bArr[i14] = 92;
                    i14 += 2;
                    bArr[i17] = 98;
                } else if (charAt == 9) {
                    int i18 = i14 + 1;
                    bArr[i14] = 92;
                    i14 += 2;
                    bArr[i18] = 116;
                } else if (charAt == 10) {
                    int i19 = i14 + 1;
                    bArr[i14] = 92;
                    i14 += 2;
                    bArr[i19] = 110;
                } else if (charAt == 12) {
                    int i20 = i14 + 1;
                    bArr[i14] = 92;
                    i14 += 2;
                    bArr[i20] = 102;
                } else if (charAt == 13) {
                    int i21 = i14 + 1;
                    bArr[i14] = 92;
                    i14 += 2;
                    bArr[i21] = 114;
                } else {
                    bArr[i14] = 92;
                    bArr[i14 + 1] = 117;
                    bArr[i14 + 2] = 48;
                    bArr[i14 + 3] = 48;
                    switch (charAt) {
                        case 0:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 48;
                            break;
                        case 1:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 49;
                            break;
                        case 2:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 50;
                            break;
                        case 3:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 51;
                            break;
                        case 4:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 52;
                            break;
                        case 5:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 53;
                            break;
                        case 6:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 54;
                            break;
                        case 7:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 55;
                            break;
                        case 11:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 66;
                            break;
                        case 14:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 69;
                            break;
                        case 15:
                            bArr[i14 + 4] = 48;
                            bArr[i14 + 5] = 70;
                            break;
                        case 16:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 48;
                            break;
                        case 17:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 49;
                            break;
                        case 18:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 50;
                            break;
                        case 19:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 51;
                            break;
                        case 20:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 52;
                            break;
                        case 21:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 53;
                            break;
                        case 22:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 54;
                            break;
                        case 23:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 55;
                            break;
                        case 24:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 56;
                            break;
                        case 25:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 57;
                            break;
                        case 26:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 65;
                            break;
                        case 27:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 66;
                            break;
                        case MotionEventCompat.AXIS_RELATIVE_Y:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 67;
                            break;
                        case 29:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 68;
                            break;
                        case 30:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 69;
                            break;
                        default:
                            bArr[i14 + 4] = 49;
                            bArr[i14 + 5] = 70;
                            break;
                    }
                    i14 += 6;
                }
            } else if (charAt < 127) {
                bArr[i14] = (byte) charAt;
                i14++;
            } else {
                int codePointAt = Character.codePointAt(charSequence2, i13);
                if (Character.isSupplementaryCodePoint(codePointAt)) {
                    i13++;
                }
                if (codePointAt == 127) {
                    bArr[i14] = (byte) codePointAt;
                    i14++;
                } else if (codePointAt <= 2047) {
                    int i22 = i14 + 1;
                    bArr[i14] = (byte) (((codePointAt >> 6) & 31) | 192);
                    i14 += 2;
                    bArr[i22] = (byte) ((codePointAt & 63) | 128);
                } else if (codePointAt < 55296 || (codePointAt > 57343 && codePointAt <= 65535)) {
                    bArr[i14] = (byte) (((codePointAt >> 12) & 15) | 224);
                    int i23 = i14 + 2;
                    bArr[i14 + 1] = (byte) (((codePointAt >> 6) & 63) | 128);
                    i14 += 3;
                    bArr[i23] = (byte) ((codePointAt & 63) | 128);
                } else if (codePointAt < 65536 || codePointAt > 1114111) {
                    throw new p("Unknown unicode codepoint in string! " + Integer.toHexString(codePointAt));
                } else {
                    bArr[i14] = (byte) (((codePointAt >> 18) & 7) | 240);
                    bArr[i14 + 1] = (byte) (((codePointAt >> 12) & 63) | 128);
                    int i24 = i14 + 3;
                    bArr[i14 + 2] = (byte) (((codePointAt >> 6) & 63) | 128);
                    i14 += 4;
                    bArr[i24] = (byte) ((codePointAt & 63) | 128);
                }
            }
            i13++;
        }
        bArr[i14] = 34;
        this.f21445a = i14 + 1;
    }

    /* access modifiers changed from: package-private */
    public void a(int i10) {
        this.f21445a += i10;
    }

    /* access modifiers changed from: package-private */
    public final byte[] c(int i10) {
        int i11 = this.f21445a;
        if (i11 + i10 >= this.f21448d.length) {
            b(i11, i10);
        }
        return this.f21448d;
    }

    public final void d() {
        int i10;
        OutputStream outputStream = this.f21447c;
        if (outputStream != null && (i10 = this.f21445a) != 0) {
            try {
                outputStream.write(this.f21448d, 0, i10);
                this.f21446b += (long) this.f21445a;
                this.f21445a = 0;
            } catch (IOException e10) {
                throw new p("Unable to write to target stream.", e10);
            }
        }
    }

    public final void e(OutputStream outputStream) {
        this.f21445a = 0;
        this.f21447c = outputStream;
        this.f21446b = 0;
    }

    public void f(Collection collection, a aVar) {
        if (collection == null) {
            n();
            return;
        }
        l((byte) 91);
        if (!collection.isEmpty()) {
            Iterator it = collection.iterator();
            Object next = it.next();
            if (next != null) {
                aVar.a(this, next);
            } else {
                n();
            }
            while (it.hasNext()) {
                l((byte) 44);
                Object next2 = it.next();
                if (next2 != null) {
                    aVar.a(this, next2);
                } else {
                    n();
                }
            }
        }
        l((byte) 93);
    }

    public void g(Object[] objArr, a aVar) {
        if (objArr == null) {
            n();
            return;
        }
        l((byte) 91);
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj != null) {
                aVar.a(this, obj);
            } else {
                n();
            }
            for (int i10 = 1; i10 < objArr.length; i10++) {
                l((byte) 44);
                Object obj2 = objArr[i10];
                if (obj2 != null) {
                    aVar.a(this, obj2);
                } else {
                    n();
                }
            }
        }
        l((byte) 93);
    }

    public final int h() {
        return this.f21445a;
    }

    public final void i(String str) {
        int length = str.length();
        int i10 = this.f21445a;
        if (i10 + length >= this.f21448d.length) {
            b(i10, length);
        }
        str.getBytes(0, length, this.f21448d, this.f21445a);
        this.f21445a += length;
    }

    public final void j(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f21445a;
        if (i10 + length >= this.f21448d.length) {
            b(i10, length);
        }
        int i11 = this.f21445a;
        byte[] bArr2 = this.f21448d;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            bArr2[i11 + i12] = bArr[i12];
        }
        this.f21445a += length;
    }

    public final void k(byte[] bArr) {
        int i10 = this.f21445a;
        if ((bArr.length << 1) + i10 + 2 >= this.f21448d.length) {
            b(i10, (bArr.length << 1) + 2);
        }
        byte[] bArr2 = this.f21448d;
        int i11 = this.f21445a;
        int i12 = i11 + 1;
        this.f21445a = i12;
        bArr2[i11] = 34;
        int b10 = i12 + a.b(bArr, bArr2, i12);
        byte[] bArr3 = this.f21448d;
        this.f21445a = b10 + 1;
        bArr3[b10] = 34;
    }

    public final void l(byte b10) {
        int i10 = this.f21445a;
        if (i10 == this.f21448d.length) {
            b(i10, 0);
        }
        byte[] bArr = this.f21448d;
        int i11 = this.f21445a;
        this.f21445a = i11 + 1;
        bArr[i11] = b10;
    }

    /* access modifiers changed from: package-private */
    public final void m(double d10) {
        if (d10 == Double.POSITIVE_INFINITY) {
            i("\"Infinity\"");
        } else if (d10 == Double.NEGATIVE_INFINITY) {
            i("\"-Infinity\"");
        } else if (d10 != d10) {
            i("\"NaN\"");
        } else if (d10 == 0.0d) {
            i("0.0");
        } else if (h.a(d10, this.f21450f)) {
            int i10 = this.f21445a;
            if (i10 + 24 >= this.f21448d.length) {
                b(i10, 24);
            }
            this.f21445a += this.f21450f.l(this.f21448d, this.f21445a);
        } else {
            i(Double.toString(d10));
        }
    }

    public final void n() {
        int i10 = this.f21445a;
        if (i10 + 4 >= this.f21448d.length) {
            b(i10, 0);
        }
        int i11 = this.f21445a;
        byte[] bArr = this.f21448d;
        bArr[i11] = 110;
        bArr[i11 + 1] = 117;
        bArr[i11 + 2] = 108;
        bArr[i11 + 3] = 108;
        this.f21445a = i11 + 4;
    }

    public final void p(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = this.f21445a;
        int i11 = length << 2;
        int i12 = length << 1;
        if (i10 + i11 + i12 + 2 >= this.f21448d.length) {
            b(i10, i11 + i12 + 2);
        }
        byte[] bArr = this.f21448d;
        int i13 = this.f21445a;
        bArr[i13] = 34;
        int i14 = i13 + 1;
        int i15 = 0;
        while (i15 < length) {
            char charAt = charSequence.charAt(i15);
            if (charAt <= 31 || charAt == '\"' || charAt == '\\' || charAt >= '~') {
                o(charSequence, i15, i14, length);
                return;
            }
            bArr[i14] = (byte) charAt;
            i15++;
            i14++;
        }
        bArr[i14] = 34;
        this.f21445a = i14 + 1;
    }

    public final void q(String str) {
        int length = str.length();
        int i10 = this.f21445a;
        int i11 = length << 2;
        int i12 = length << 1;
        if (i10 + i11 + i12 + 2 >= this.f21448d.length) {
            b(i10, i11 + i12 + 2);
        }
        byte[] bArr = this.f21448d;
        int i13 = this.f21445a;
        bArr[i13] = 34;
        int i14 = i13 + 1;
        int i15 = 0;
        while (i15 < length) {
            char charAt = str.charAt(i15);
            if (charAt <= 31 || charAt == '\"' || charAt == '\\' || charAt >= '~') {
                o(str, i15, i14, length);
                return;
            }
            bArr[i14] = (byte) charAt;
            i15++;
            i14++;
        }
        bArr[i14] = 34;
        this.f21445a = i14 + 1;
    }

    public String toString() {
        return new String(this.f21448d, 0, this.f21445a, f21444g);
    }

    k(byte[] bArr, u uVar) {
        this.f21450f = new h.e();
        this.f21448d = bArr;
        this.f21449e = uVar;
    }
}
