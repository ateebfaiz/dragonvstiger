package c5;

import b3.a;
import b3.g;
import e5.j;
import g3.d;
import java.io.IOException;
import java.io.InputStream;
import y2.b;
import y2.l;
import y2.q;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private int f17322a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f17323b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f17324c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f17325d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f17326e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f17327f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17328g;

    /* renamed from: h  reason: collision with root package name */
    private final a f17329h;

    public f(a aVar) {
        this.f17329h = (a) l.g(aVar);
    }

    private boolean a(InputStream inputStream) {
        int read;
        int i10 = this.f17326e;
        while (this.f17322a != 6 && (read = inputStream.read()) != -1) {
            try {
                int i11 = this.f17324c;
                this.f17324c = i11 + 1;
                if (this.f17328g) {
                    this.f17322a = 6;
                    this.f17328g = false;
                    return false;
                }
                int i12 = this.f17322a;
                if (i12 != 0) {
                    if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 == 4) {
                                    this.f17322a = 5;
                                } else if (i12 != 5) {
                                    l.i(false);
                                } else {
                                    int i13 = ((this.f17323b << 8) + read) - 2;
                                    d.a(inputStream, (long) i13);
                                    this.f17324c += i13;
                                    this.f17322a = 2;
                                }
                            } else if (read == 255) {
                                this.f17322a = 3;
                            } else if (read == 0) {
                                this.f17322a = 2;
                            } else if (read == 217) {
                                this.f17328g = true;
                                f(i11 - 1);
                                this.f17322a = 2;
                            } else {
                                if (read == 218) {
                                    f(i11 - 1);
                                }
                                if (b(read)) {
                                    this.f17322a = 4;
                                } else {
                                    this.f17322a = 2;
                                }
                            }
                        } else if (read == 255) {
                            this.f17322a = 3;
                        }
                    } else if (read == 216) {
                        this.f17322a = 2;
                    } else {
                        this.f17322a = 6;
                    }
                } else if (read == 255) {
                    this.f17322a = 1;
                } else {
                    this.f17322a = 6;
                }
                this.f17323b = read;
            } catch (IOException e10) {
                q.a(e10);
            }
        }
        if (this.f17322a == 6 || this.f17326e == i10) {
            return false;
        }
        return true;
    }

    private static boolean b(int i10) {
        if (i10 == 1) {
            return false;
        }
        if ((i10 >= 208 && i10 <= 215) || i10 == 217 || i10 == 216) {
            return false;
        }
        return true;
    }

    private void f(int i10) {
        int i11 = this.f17325d;
        if (i11 > 0) {
            this.f17327f = i10;
        }
        this.f17325d = i11 + 1;
        this.f17326e = i11;
    }

    public int c() {
        return this.f17327f;
    }

    public int d() {
        return this.f17326e;
    }

    public boolean e() {
        return this.f17328g;
    }

    public boolean g(j jVar) {
        if (this.f17322a == 6 || jVar.A() <= this.f17324c) {
            return false;
        }
        g gVar = new g(jVar.y(), (byte[]) this.f17329h.get(16384), this.f17329h);
        try {
            d.a(gVar, (long) this.f17324c);
            return a(gVar);
        } catch (IOException e10) {
            q.a(e10);
            return false;
        } finally {
            b.b(gVar);
        }
    }
}
