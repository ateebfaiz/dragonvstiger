package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class x0 {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f6209a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6210b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[][] f6211c;

    public x0(InputStream inputStream, int i10, byte[][] bArr) {
        this.f6209a = inputStream;
        this.f6210b = i10;
        this.f6211c = bArr;
    }

    public v a() throws IOException {
        int read = this.f6209a.read();
        if (read < 0) {
            return null;
        }
        return a(read);
    }

    public w b() throws IOException {
        int read = this.f6209a.read();
        if (read < 0) {
            return new w(0);
        }
        w wVar = new w(10);
        do {
            v a10 = a(read);
            if (a10 instanceof b3) {
                wVar.a((v) ((b3) a10).b());
            } else {
                wVar.a((v) a10.d());
            }
            read = this.f6209a.read();
        } while (read >= 0);
        return wVar;
    }

    public p0 a(int i10, int i11) throws IOException {
        l1 l1Var;
        w b10 = b();
        int i12 = b10.f6199c;
        if (i12 == 1) {
            return new p1(3, i10, i11, b10.a(0));
        }
        l1 l1Var2 = i1.f6016a;
        if (i12 < 1) {
            l1Var = i1.f6016a;
        } else {
            l1Var = new l1(b10);
        }
        return new p1(4, i10, i11, l1Var);
    }

    public v a(int i10) throws IOException {
        InputStream inputStream = this.f6209a;
        boolean z10 = false;
        if (inputStream instanceof c3) {
            c3 c3Var = (c3) inputStream;
            c3Var.f5946f = false;
            c3Var.a();
        }
        int a10 = e0.a(this.f6209a, i10);
        int a11 = e0.a(this.f6209a, this.f6210b, a10 == 3 || a10 == 4 || a10 == 16 || a10 == 17 || a10 == 8);
        if (a11 >= 0) {
            a3 a3Var = new a3(this.f6209a, a11, this.f6210b);
            if ((i10 & 224) != 0) {
                x0 x0Var = new x0(a3Var, a3Var.f5965b, this.f6211c);
                int i11 = i10 & 192;
                if (i11 != 0) {
                    if ((i10 & 32) != 0) {
                        z10 = true;
                    }
                    return new z2(i11, a10, z10, x0Var);
                } else if (a10 == 3) {
                    return new h1(x0Var);
                } else {
                    if (a10 == 4) {
                        return new k1(x0Var);
                    }
                    if (a10 == 8) {
                        return new w1(x0Var);
                    }
                    if (a10 == 16) {
                        return new v2(x0Var);
                    }
                    if (a10 == 17) {
                        return new x2(x0Var);
                    }
                    throw new y("unknown DL object encountered: 0x" + Integer.toHexString(a10));
                }
            } else if (a10 == 3) {
                return new q2(a3Var);
            } else {
                if (a10 == 4) {
                    return new e2(a3Var);
                }
                if (a10 == 8) {
                    throw new y("externals must use constructed encoding (see X.690 8.18)");
                } else if (a10 == 16) {
                    throw new y("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
                } else if (a10 != 17) {
                    try {
                        return e0.a(a10, a3Var, this.f6211c);
                    } catch (IllegalArgumentException e10) {
                        throw new y("corrupted stream detected", e10);
                    }
                } else {
                    throw new y("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
                }
            }
        } else if ((i10 & 32) != 0) {
            x0 x0Var2 = new x0(new c3(this.f6209a, this.f6210b), this.f6210b, this.f6211c);
            int i12 = i10 & 192;
            if (i12 != 0) {
                return new q1(i12, a10, x0Var2);
            }
            if (a10 == 3) {
                return new h1(x0Var2);
            }
            if (a10 == 4) {
                return new k1(x0Var2);
            }
            if (a10 == 8) {
                return new w1(x0Var2);
            }
            if (a10 == 16) {
                return new m1(x0Var2);
            }
            if (a10 == 17) {
                return new o1(x0Var2);
            }
            throw new y("unknown BER object encountered: 0x" + Integer.toHexString(a10));
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }
}
