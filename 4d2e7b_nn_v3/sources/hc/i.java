package hc;

import androidx.core.view.MotionEventCompat;
import be.a;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class i extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final int f377a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f378b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[][] f379c;

    public i(InputStream inputStream) {
        this(inputStream, v1.c(inputStream));
    }

    static r j(int i10, o1 o1Var, byte[][] bArr) {
        if (i10 == 10) {
            return f.o(m(o1Var, bArr));
        }
        if (i10 == 12) {
            return new f1(o1Var.h());
        }
        if (i10 == 30) {
            return new l0(k(o1Var));
        }
        switch (i10) {
            case 1:
                return c.o(m(o1Var, bArr));
            case 2:
                return new j(o1Var.h(), false);
            case 3:
                return b.p(o1Var.a(), o1Var);
            case 4:
                return new v0(o1Var.h());
            case 5:
                return t0.f424a;
            case 6:
                return m.q(m(o1Var, bArr));
            default:
                switch (i10) {
                    case 18:
                        return new u0(o1Var.h());
                    case 19:
                        return new y0(o1Var.h());
                    case 20:
                        return new d1(o1Var.h());
                    case 21:
                        return new h1(o1Var.h());
                    case 22:
                        return new s0(o1Var.h());
                    case 23:
                        return new x(o1Var.h());
                    case 24:
                        return new h(o1Var.h());
                    case 25:
                        return new r0(o1Var.h());
                    case 26:
                        return new i1(o1Var.h());
                    case 27:
                        return new q0(o1Var.h());
                    case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                        return new g1(o1Var.h());
                    default:
                        throw new IOException("unknown tag " + i10 + " encountered");
                }
        }
    }

    private static char[] k(o1 o1Var) {
        int read;
        int a10 = o1Var.a() / 2;
        char[] cArr = new char[a10];
        for (int i10 = 0; i10 < a10; i10++) {
            int read2 = o1Var.read();
            if (read2 < 0 || (read = o1Var.read()) < 0) {
                break;
            }
            cArr[i10] = (char) ((read2 << 8) | (read & 255));
        }
        return cArr;
    }

    private static byte[] m(o1 o1Var, byte[][] bArr) {
        int a10 = o1Var.a();
        if (o1Var.a() >= bArr.length) {
            return o1Var.h();
        }
        byte[] bArr2 = bArr[a10];
        if (bArr2 == null) {
            bArr2 = new byte[a10];
            bArr[a10] = bArr2;
        }
        a.c(o1Var, bArr2);
        return bArr2;
    }

    static int v(InputStream inputStream, int i10) {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i11 = read & 127;
            if (i11 <= 4) {
                int i12 = 0;
                int i13 = 0;
                while (i13 < i11) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i12 = (i12 << 8) + read2;
                        i13++;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i12 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i12 < i10) {
                    return i12;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException("DER length more than 4 bytes: " + i11);
            }
        }
    }

    static int y(InputStream inputStream, int i10) {
        int i11 = i10 & 31;
        if (i11 != 31) {
            return i11;
        }
        int read = inputStream.read();
        if ((read & 127) != 0) {
            int i12 = 0;
            while (read >= 0 && (read & 128) != 0) {
                i12 = ((read & 127) | i12) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i12 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    /* access modifiers changed from: package-private */
    public e a(o1 o1Var) {
        return new i((InputStream) o1Var).b();
    }

    /* access modifiers changed from: package-private */
    public e b() {
        e eVar = new e();
        while (true) {
            r w10 = w();
            if (w10 == null) {
                return eVar;
            }
            eVar.a(w10);
        }
    }

    /* access modifiers changed from: protected */
    public r h(int i10, int i11, int i12) {
        boolean z10;
        if ((i10 & 32) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        o1 o1Var = new o1(this, i12);
        if ((i10 & 64) != 0) {
            return new k0(z10, i11, o1Var.h());
        }
        if ((i10 & 128) != 0) {
            return new v(o1Var).c(z10, i11);
        }
        if (!z10) {
            return j(i11, o1Var, this.f379c);
        }
        if (i11 == 4) {
            e a10 = a(o1Var);
            int c10 = a10.c();
            n[] nVarArr = new n[c10];
            for (int i13 = 0; i13 != c10; i13++) {
                nVarArr[i13] = (n) a10.b(i13);
            }
            return new b0(nVarArr);
        } else if (i11 == 8) {
            return new n0(a(o1Var));
        } else {
            if (i11 != 16) {
                if (i11 == 17) {
                    return p0.b(a(o1Var));
                }
                throw new IOException("unknown tag " + i11 + " encountered");
            } else if (this.f378b) {
                return new s1(o1Var.h());
            } else {
                return p0.a(a(o1Var));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f377a;
    }

    /* access modifiers changed from: protected */
    public int p() {
        return v(this, this.f377a);
    }

    public r w() {
        boolean z10;
        int read = read();
        if (read > 0) {
            int y10 = y(this, read);
            if ((read & 32) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int p10 = p();
            if (p10 >= 0) {
                try {
                    return h(read, y10, p10);
                } catch (IllegalArgumentException e10) {
                    throw new g("corrupted stream detected", e10);
                }
            } else if (z10) {
                v vVar = new v(new q1(this, this.f377a), this.f377a);
                if ((read & 64) != 0) {
                    return new z(y10, vVar).d();
                }
                if ((read & 128) != 0) {
                    return new i0(true, y10, vVar).d();
                }
                if (y10 == 4) {
                    return new c0(vVar).d();
                }
                if (y10 == 8) {
                    return new o0(vVar).d();
                }
                if (y10 == 16) {
                    return new e0(vVar).d();
                }
                if (y10 == 17) {
                    return new g0(vVar).d();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    public i(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr), bArr.length);
    }

    public i(byte[] bArr, boolean z10) {
        this(new ByteArrayInputStream(bArr), bArr.length, z10);
    }

    public i(InputStream inputStream, int i10) {
        this(inputStream, i10, false);
    }

    public i(InputStream inputStream, int i10, boolean z10) {
        super(inputStream);
        this.f377a = i10;
        this.f378b = z10;
        this.f379c = new byte[11][];
    }
}
