package c;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f17190a;

    /* renamed from: b  reason: collision with root package name */
    public int f17191b;

    /* renamed from: c  reason: collision with root package name */
    public int f17192c;

    /* renamed from: d  reason: collision with root package name */
    public int f17193d;

    /* renamed from: e  reason: collision with root package name */
    public final InputStream f17194e;

    /* renamed from: f  reason: collision with root package name */
    public int f17195f;

    /* renamed from: g  reason: collision with root package name */
    public int f17196g;

    /* renamed from: h  reason: collision with root package name */
    public int f17197h;

    /* renamed from: i  reason: collision with root package name */
    public int f17198i;

    /* renamed from: j  reason: collision with root package name */
    public int f17199j;

    public b(byte[] bArr, int i10, int i11) {
        this.f17197h = Integer.MAX_VALUE;
        this.f17198i = 64;
        this.f17199j = 67108864;
        this.f17190a = bArr;
        this.f17191b = i11 + i10;
        this.f17193d = i10;
        this.f17196g = -i10;
        this.f17194e = null;
    }

    public static b c(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    public void a(int i10) {
        int i11;
        if (i10 >= 0) {
            int i12 = this.f17196g;
            int i13 = this.f17193d;
            int i14 = i12 + i13 + i10;
            int i15 = this.f17197h;
            if (i14 <= i15) {
                int i16 = this.f17191b - i13;
                if (i10 <= i16) {
                    this.f17193d = i13 + i10;
                    return;
                }
                this.f17196g = i12 + i16;
                this.f17193d = 0;
                this.f17191b = 0;
                while (i16 < i10) {
                    InputStream inputStream = this.f17194e;
                    if (inputStream == null) {
                        i11 = -1;
                    } else {
                        i11 = (int) inputStream.skip((long) (i10 - i16));
                    }
                    if (i11 > 0) {
                        i16 += i11;
                        this.f17196g += i11;
                    } else {
                        throw new IOException("Truncated message.");
                    }
                }
                return;
            }
            a((i15 - i12) - i13);
            throw new IOException("Truncated message.");
        }
        throw new IOException("Negative size.");
    }

    public int b() {
        int i10 = this.f17197h;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - (this.f17196g + this.f17193d);
    }

    public void d(int i10) {
        if (this.f17195f != i10) {
            throw new IOException("Invalid end tag.");
        }
    }

    public final boolean e(boolean z10) {
        int i10;
        int i11 = this.f17193d;
        int i12 = this.f17191b;
        if (i11 >= i12) {
            int i13 = this.f17196g + i12;
            if (i13 != this.f17197h) {
                this.f17196g = i13;
                this.f17193d = 0;
                InputStream inputStream = this.f17194e;
                if (inputStream == null) {
                    i10 = -1;
                } else {
                    i10 = inputStream.read(this.f17190a);
                }
                this.f17191b = i10;
                if (i10 == 0 || i10 < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f17191b + "\nThe InputStream implementation is buggy.");
                } else if (i10 == -1) {
                    this.f17191b = 0;
                    if (!z10) {
                        return false;
                    }
                    throw new IOException("Truncated message.");
                } else {
                    q();
                    int i14 = this.f17196g + this.f17191b + this.f17192c;
                    if (i14 <= this.f17199j && i14 >= 0) {
                        return true;
                    }
                    throw new IOException("Size limit exceeded.");
                }
            } else if (!z10) {
                return false;
            } else {
                throw new IOException("Truncated message.");
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    public boolean f() {
        if (this.f17193d != this.f17191b || e(false)) {
            return false;
        }
        return true;
    }

    public int g(int i10) {
        if (i10 >= 0) {
            int i11 = this.f17196g + this.f17193d + i10;
            int i12 = this.f17197h;
            if (i11 <= i12) {
                this.f17197h = i11;
                q();
                return i12;
            }
            throw new IOException("Truncated message.");
        }
        throw new IOException("Negative size.");
    }

    public boolean h() {
        if (n() != 0) {
            return true;
        }
        return false;
    }

    public byte[] i(int i10) {
        int i11;
        if (i10 >= 0) {
            int i12 = this.f17196g;
            int i13 = this.f17193d;
            int i14 = i12 + i13 + i10;
            int i15 = this.f17197h;
            if (i14 <= i15) {
                int i16 = this.f17191b;
                int i17 = i16 - i13;
                if (i10 <= i17) {
                    byte[] bArr = new byte[i10];
                    System.arraycopy(this.f17190a, i13, bArr, 0, i10);
                    this.f17193d += i10;
                    return bArr;
                } else if (i10 < 4096) {
                    byte[] bArr2 = new byte[i10];
                    System.arraycopy(this.f17190a, i13, bArr2, 0, i17);
                    this.f17193d = this.f17191b;
                    e(true);
                    while (true) {
                        int i18 = i10 - i17;
                        int i19 = this.f17191b;
                        if (i18 > i19) {
                            System.arraycopy(this.f17190a, 0, bArr2, i17, i19);
                            int i20 = this.f17191b;
                            i17 += i20;
                            this.f17193d = i20;
                            e(true);
                        } else {
                            System.arraycopy(this.f17190a, 0, bArr2, i17, i18);
                            this.f17193d = i18;
                            return bArr2;
                        }
                    }
                } else {
                    this.f17196g = i12 + i16;
                    this.f17193d = 0;
                    this.f17191b = 0;
                    int i21 = i10 - i17;
                    Vector vector = new Vector();
                    while (i21 > 0) {
                        int min = Math.min(i21, 4096);
                        byte[] bArr3 = new byte[min];
                        int i22 = 0;
                        while (i22 < min) {
                            InputStream inputStream = this.f17194e;
                            if (inputStream == null) {
                                i11 = -1;
                            } else {
                                i11 = inputStream.read(bArr3, i22, min - i22);
                            }
                            if (i11 != -1) {
                                this.f17196g += i11;
                                i22 += i11;
                            } else {
                                throw new IOException("Truncated message.");
                            }
                        }
                        i21 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i10];
                    System.arraycopy(this.f17190a, i13, bArr4, 0, i17);
                    for (int i23 = 0; i23 < vector.size(); i23++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i23);
                        System.arraycopy(bArr5, 0, bArr4, i17, bArr5.length);
                        i17 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                a((i15 - i12) - i13);
                throw new IOException("Truncated message.");
            }
        } else {
            throw new IOException("Negative size.");
        }
    }

    public boolean j(int i10) {
        int i11 = i10 & 7;
        if (i11 == 0) {
            n();
            return true;
        } else if (i11 == 1) {
            m();
            return true;
        } else if (i11 == 2) {
            a(n());
            return true;
        } else if (i11 == 3) {
            r();
            d(((i10 >>> 3) << 3) | 4);
            return true;
        } else if (i11 == 4) {
            return false;
        } else {
            if (i11 == 5) {
                k();
                return true;
            }
            throw new IOException("Invalid wire type: " + i11);
        }
    }

    public int k() {
        return (l() & 255) | ((l() & 255) << 8) | ((l() & 255) << 16) | ((l() & 255) << 24);
    }

    public byte l() {
        if (this.f17193d == this.f17191b) {
            e(true);
        }
        byte[] bArr = this.f17190a;
        int i10 = this.f17193d;
        this.f17193d = i10 + 1;
        return bArr[i10];
    }

    public long m() {
        byte l10 = l();
        byte l11 = l();
        return ((((long) l11) & 255) << 8) | (((long) l10) & 255) | ((((long) l()) & 255) << 16) | ((((long) l()) & 255) << 24) | ((((long) l()) & 255) << 32) | ((((long) l()) & 255) << 40) | ((((long) l()) & 255) << 48) | ((((long) l()) & 255) << 56);
    }

    public int n() {
        int i10;
        byte l10 = l();
        if (l10 >= 0) {
            return l10;
        }
        byte b10 = l10 & Byte.MAX_VALUE;
        byte l11 = l();
        if (l11 >= 0) {
            i10 = l11 << 7;
        } else {
            b10 |= (l11 & Byte.MAX_VALUE) << 7;
            byte l12 = l();
            if (l12 >= 0) {
                i10 = l12 << 14;
            } else {
                b10 |= (l12 & Byte.MAX_VALUE) << 14;
                byte l13 = l();
                if (l13 >= 0) {
                    i10 = l13 << 21;
                } else {
                    byte b11 = b10 | ((l13 & Byte.MAX_VALUE) << 21);
                    byte l14 = l();
                    byte b12 = b11 | (l14 << 28);
                    if (l14 >= 0) {
                        return b12;
                    }
                    for (int i11 = 0; i11 < 5; i11++) {
                        if (l() >= 0) {
                            return b12;
                        }
                    }
                    throw new IOException("malformed varint.");
                }
            }
        }
        return b10 | i10;
    }

    public String o() {
        int n10 = n();
        int i10 = this.f17191b;
        int i11 = this.f17193d;
        if (n10 > i10 - i11 || n10 <= 0) {
            return new String(i(n10), "UTF-8");
        }
        String str = new String(this.f17190a, i11, n10, "UTF-8");
        this.f17193d += n10;
        return str;
    }

    public int p() {
        if (f()) {
            this.f17195f = 0;
            return 0;
        }
        int n10 = n();
        this.f17195f = n10;
        if ((n10 >>> 3) != 0) {
            return n10;
        }
        throw new IOException("Invalid tag.");
    }

    public final void q() {
        int i10 = this.f17191b + this.f17192c;
        this.f17191b = i10;
        int i11 = this.f17196g + i10;
        int i12 = this.f17197h;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.f17192c = i13;
            this.f17191b = i10 - i13;
            return;
        }
        this.f17192c = 0;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void r() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.p()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.j(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.r():void");
    }

    public b(InputStream inputStream) {
        this.f17197h = Integer.MAX_VALUE;
        this.f17198i = 64;
        this.f17199j = 67108864;
        this.f17190a = new byte[4096];
        this.f17191b = 0;
        this.f17193d = 0;
        this.f17196g = 0;
        this.f17194e = inputStream;
    }
}
