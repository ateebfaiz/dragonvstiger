package com.geetest.core;

import androidx.core.view.MotionEventCompat;
import com.geetest.core.k0;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentMap;

public class e0 extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final int f5959a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5960b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[][] f5961c;

    public e0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public static char[] a(a3 a3Var) throws IOException {
        int i10 = a3Var.f5903e;
        if ((i10 & 1) == 0) {
            int i11 = i10 / 2;
            char[] cArr = new char[i11];
            byte[] bArr = new byte[8];
            int i12 = 0;
            int i13 = 0;
            while (i10 >= 8) {
                if (o3.a(a3Var, bArr, 0, 8) == 8) {
                    cArr[i13] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
                    cArr[i13 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
                    cArr[i13 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
                    cArr[i13 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
                    i13 += 4;
                    i10 -= 8;
                } else {
                    throw new EOFException("EOF encountered in middle of BMPString");
                }
            }
            if (i10 > 0) {
                if (o3.a(a3Var, bArr, 0, i10) == i10) {
                    do {
                        int i14 = i12 + 1;
                        i12 += 2;
                        cArr[i13] = (char) ((bArr[i14] & 255) | (bArr[i12] << 8));
                        i13++;
                    } while (i12 < i10);
                } else {
                    throw new EOFException("EOF encountered in middle of BMPString");
                }
            }
            if (a3Var.f5903e == 0 && i11 == i13) {
                return cArr;
            }
            throw new IllegalStateException();
        }
        throw new IOException("malformed BMPString encoding encountered");
    }

    public w b(a3 a3Var) throws IOException {
        int i10 = a3Var.f5903e;
        if (i10 < 1) {
            return new w(0);
        }
        return new e0(a3Var, i10, this.f5960b, this.f5961c).b();
    }

    public e0(InputStream inputStream, int i10) {
        this(inputStream, i10, false);
    }

    public e0(InputStream inputStream, int i10, boolean z10) {
        this(inputStream, i10, z10, new byte[11][]);
    }

    public e0(InputStream inputStream, int i10, boolean z10, byte[][] bArr) {
        super(inputStream);
        this.f5959a = i10;
        this.f5960b = z10;
        this.f5961c = bArr;
    }

    public w b() throws IOException {
        p0 a10 = a();
        if (a10 == null) {
            return new w(0);
        }
        w wVar = new w(10);
        do {
            wVar.a((v) a10);
            a10 = a();
        } while (a10 != null);
        return wVar;
    }

    public static byte[] a(a3 a3Var, byte[][] bArr) throws IOException {
        int i10 = a3Var.f5903e;
        if (i10 >= bArr.length) {
            return a3Var.a();
        }
        byte[] bArr2 = bArr[i10];
        if (bArr2 == null) {
            bArr2 = new byte[i10];
            bArr[i10] = bArr2;
        }
        if (i10 == bArr2.length) {
            if (i10 != 0) {
                int i11 = a3Var.f5965b;
                if (i10 < i11) {
                    int a10 = i10 - o3.a(a3Var.f5964a, bArr2, 0, bArr2.length);
                    a3Var.f5903e = a10;
                    if (a10 == 0) {
                        a3Var.a(true);
                    } else {
                        throw new EOFException("DEF length " + a3Var.f5902d + " object truncated by " + a3Var.f5903e);
                    }
                } else {
                    throw new IOException("corrupted stream - out of bounds length found: " + a3Var.f5903e + " >= " + i11);
                }
            }
            return bArr2;
        }
        throw new IllegalArgumentException("buffer length not right for data");
    }

    public p0 a(int i10, int i11, int i12) throws IOException {
        a3 a3Var = new a3(this, i12, this.f5959a);
        if ((i10 & 224) == 0) {
            return a(i11, a3Var, this.f5961c);
        }
        int i13 = i10 & 192;
        if (i13 == 0) {
            int i14 = 0;
            if (i11 == 3) {
                w b10 = b(a3Var);
                int i15 = b10.f6199c;
                s[] sVarArr = new s[i15];
                while (i14 != i15) {
                    v a10 = b10.a(i14);
                    if (a10 instanceof s) {
                        sVarArr[i14] = (s) a10;
                        i14++;
                    } else {
                        throw new y("unknown object encountered in constructed BIT STRING: " + a10.getClass());
                    }
                }
                return new g1(sVarArr, 1000);
            } else if (i11 == 4) {
                w b11 = b(a3Var);
                int i16 = b11.f6199c;
                l0[] l0VarArr = new l0[i16];
                while (i14 != i16) {
                    v a11 = b11.a(i14);
                    if (a11 instanceof l0) {
                        l0VarArr[i14] = (l0) a11;
                        i14++;
                    } else {
                        throw new y("unknown object encountered in constructed OCTET STRING: " + a11.getClass());
                    }
                }
                return new j1(l0VarArr, 1000);
            } else if (i11 == 8) {
                u2 a12 = s2.a(b(a3Var));
                a12.getClass();
                return new r2(a12);
            } else if (i11 != 16) {
                if (i11 == 17) {
                    w b12 = b(a3Var);
                    u2 u2Var = s2.f6177a;
                    if (b12.f6199c < 1) {
                        return s2.f6178b;
                    }
                    return new w2(b12);
                }
                throw new IOException("unknown tag " + i11 + " encountered");
            } else if (a3Var.f5903e < 1) {
                return s2.f6177a;
            } else {
                if (this.f5960b) {
                    return new d3(a3Var.a());
                }
                return s2.a(b(a3Var));
            }
        } else if ((i10 & 32) != 0) {
            return z0.a(i13, i11, b(a3Var));
        } else {
            return new y2(4, i13, i11, new d2(a3Var.a()));
        }
    }

    public p0 a() throws IOException {
        int read = read();
        if (read > 0) {
            int a10 = a((InputStream) this, read);
            int a11 = a((InputStream) this, this.f5959a, false);
            if (a11 >= 0) {
                try {
                    return a(read, a10, a11);
                } catch (IllegalArgumentException e10) {
                    throw new y("corrupted stream detected", e10);
                }
            } else if ((read & 32) != 0) {
                x0 x0Var = new x0(new c3(this, this.f5959a), this.f5959a, this.f5961c);
                int i10 = read & 192;
                if (i10 != 0) {
                    return x0Var.a(i10, a10);
                }
                if (a10 == 3) {
                    r1 r1Var = new r1(x0Var, false);
                    return new g1(o3.a(r1Var), r1Var.f6155d, 1000);
                } else if (a10 == 4) {
                    return new j1(o3.a(new s1(x0Var)), (l0[]) null, 1000);
                } else {
                    if (a10 == 8) {
                        try {
                            return new r2(new u2(x0Var.b()));
                        } catch (IllegalArgumentException e11) {
                            throw new y(e11.getMessage(), e11);
                        }
                    } else if (a10 == 16) {
                        return new l1(x0Var.b());
                    } else {
                        if (a10 == 17) {
                            return new n1(x0Var.b());
                        }
                        throw new IOException("unknown BER object encountered");
                    }
                }
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    public static int a(InputStream inputStream, int i10) throws IOException {
        int i11 = i10 & 31;
        if (i11 != 31) {
            return i11;
        }
        int read = inputStream.read();
        if (read >= 31) {
            int i12 = read & 127;
            if (i12 != 0) {
                while ((read & 128) != 0) {
                    if ((i12 >>> 24) == 0) {
                        int i13 = i12 << 7;
                        int read2 = inputStream.read();
                        if (read2 >= 0) {
                            int i14 = read2;
                            i12 = i13 | (read2 & 127);
                            read = i14;
                        } else {
                            throw new EOFException("EOF found inside tag value.");
                        }
                    } else {
                        throw new IOException("Tag number more than 31 bits");
                    }
                }
                return i12;
            }
            throw new IOException("corrupted stream - invalid high tag number found");
        } else if (read < 0) {
            throw new EOFException("EOF found inside tag value.");
        } else {
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
    }

    public static int a(InputStream inputStream, int i10, boolean z10) throws IOException {
        int read = inputStream.read();
        if ((read >>> 7) == 0) {
            return read;
        }
        if (128 == read) {
            return -1;
        }
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (255 != read) {
            int i11 = read & 127;
            int i12 = 0;
            int i13 = 0;
            do {
                int read2 = inputStream.read();
                if (read2 < 0) {
                    throw new EOFException("EOF found reading length");
                } else if ((i12 >>> 23) == 0) {
                    i12 = (i12 << 8) + read2;
                    i13++;
                } else {
                    throw new IOException("long form definite-length more than 31 bits");
                }
            } while (i13 < i11);
            if (i12 < i10 || z10) {
                return i12;
            }
            throw new IOException("corrupted stream - out of bounds length found: " + i12 + " >= " + i10);
        } else {
            throw new IOException("invalid long form definite-length 0xFF");
        }
    }

    public static p0 a(int i10, a3 a3Var, byte[][] bArr) throws IOException {
        switch (i10) {
            case 1:
                return u.a(a(a3Var, bArr));
            case 2:
                return new f0(a3Var.a(), false);
            case 3:
                return s.a(a3Var.a());
            case 4:
                return new d2(a3Var.a());
            case 5:
                if (a3Var.a().length == 0) {
                    return b2.f5935a;
                }
                throw new IllegalStateException("malformed NULL encoding encountered");
            case 6:
                int i11 = a3Var.f5903e;
                ConcurrentMap<k0.a, k0> concurrentMap = k0.f6054a;
                if (i11 <= 4096) {
                    return k0.a(a(a3Var, bArr), true);
                }
                throw new IllegalArgumentException("exceeded OID contents length limit");
            case 7:
                return new j0(new z1(a3Var.a(), false));
            case 10:
                return x.a(a(a3Var, bArr), true);
            case 12:
                return new l2(a3Var.a(), false);
            case 13:
                int i12 = a3Var.f5903e;
                ConcurrentMap<k0.a, r0> concurrentMap2 = r0.f6149a;
                if (i12 <= 4096) {
                    return r0.a(a(a3Var, bArr), true);
                }
                throw new IllegalArgumentException("exceeded relative OID contents length limit");
            case 14:
            case 31:
            case 32:
            case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
            case 34:
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
            case 36:
                throw new IOException("unsupported tag " + i10 + " encountered");
            case 18:
                return new c2(a3Var.a(), false);
            case 19:
                return new g2(a3Var.a(), false);
            case 20:
                return new j2(a3Var.a(), false);
            case 21:
                return new n2(a3Var.a(), false);
            case 22:
                return new a2(a3Var.a(), false);
            case 23:
                return new a1(a3Var.a());
            case 24:
                return new b0(a3Var.a());
            case 25:
                return new z1(a3Var.a(), false);
            case 26:
                return new o2(a3Var.a(), false);
            case 27:
                return new x1(a3Var.a(), false);
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                return new m2(a3Var.a(), false);
            case 30:
                return new t1(a(a3Var));
            default:
                try {
                    throw new IOException("unknown tag " + i10 + " encountered");
                } catch (IllegalArgumentException e10) {
                    throw new y(e10.getMessage(), e10);
                } catch (IllegalStateException e11) {
                    throw new y(e11.getMessage(), e11);
                }
        }
    }
}
