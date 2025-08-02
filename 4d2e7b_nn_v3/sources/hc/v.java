package hc;

import java.io.IOException;
import java.io.InputStream;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f433a;

    /* renamed from: b  reason: collision with root package name */
    private final int f434b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[][] f435c;

    public v(InputStream inputStream) {
        this(inputStream, v1.c(inputStream));
    }

    private void e(boolean z10) {
        InputStream inputStream = this.f433a;
        if (inputStream instanceof q1) {
            ((q1) inputStream).j(z10);
        }
    }

    /* access modifiers changed from: package-private */
    public d a(int i10) {
        if (i10 == 4) {
            return new c0(this);
        }
        if (i10 == 8) {
            return new o0(this);
        }
        if (i10 == 16) {
            return new e0(this);
        }
        if (i10 == 17) {
            return new g0(this);
        }
        throw new g("unknown BER object encountered: 0x" + Integer.toHexString(i10));
    }

    public d b() {
        int read = this.f433a.read();
        if (read == -1) {
            return null;
        }
        boolean z10 = false;
        e(false);
        int y10 = i.y(this.f433a, read);
        if ((read & 32) != 0) {
            z10 = true;
        }
        int v10 = i.v(this.f433a, this.f434b);
        if (v10 >= 0) {
            o1 o1Var = new o1(this.f433a, v10);
            if ((read & 64) != 0) {
                return new k0(z10, y10, o1Var.h());
            }
            if ((read & 128) != 0) {
                return new i0(z10, y10, new v(o1Var));
            }
            if (z10) {
                if (y10 == 4) {
                    return new c0(new v(o1Var));
                }
                if (y10 == 8) {
                    return new o0(new v(o1Var));
                }
                if (y10 == 16) {
                    return new a1(new v(o1Var));
                }
                if (y10 == 17) {
                    return new c1(new v(o1Var));
                }
                throw new IOException("unknown tag " + y10 + " encountered");
            } else if (y10 == 4) {
                return new w0(o1Var);
            } else {
                try {
                    return i.j(y10, o1Var, this.f435c);
                } catch (IllegalArgumentException e10) {
                    throw new g("corrupted stream detected", e10);
                }
            }
        } else if (z10) {
            v vVar = new v(new q1(this.f433a, this.f434b), this.f434b);
            if ((read & 64) != 0) {
                return new z(y10, vVar);
            }
            if ((read & 128) != 0) {
                return new i0(true, y10, vVar);
            }
            return vVar.a(y10);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    /* access modifiers changed from: package-private */
    public r c(boolean z10, int i10) {
        if (!z10) {
            return new e1(false, i10, new v0(((o1) this.f433a).h()));
        }
        e d10 = d();
        if (this.f433a instanceof q1) {
            if (d10.c() == 1) {
                return new h0(true, i10, d10.b(0));
            }
            return new h0(false, i10, a0.a(d10));
        } else if (d10.c() == 1) {
            return new e1(true, i10, d10.b(0));
        } else {
            return new e1(false, i10, p0.a(d10));
        }
    }

    /* access modifiers changed from: package-private */
    public e d() {
        e eVar = new e();
        while (true) {
            d b10 = b();
            if (b10 == null) {
                return eVar;
            }
            if (b10 instanceof p1) {
                eVar.a(((p1) b10).d());
            } else {
                eVar.a(b10.c());
            }
        }
    }

    public v(InputStream inputStream, int i10) {
        this.f433a = inputStream;
        this.f434b = i10;
        this.f435c = new byte[11][];
    }
}
