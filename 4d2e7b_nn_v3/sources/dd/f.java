package dd;

import androidx.core.view.InputDeviceCompat;
import dd.d;
import java.math.BigInteger;
import java.util.Hashtable;

public abstract class f {

    /* renamed from: g  reason: collision with root package name */
    protected static d[] f153g = new d[0];

    /* renamed from: a  reason: collision with root package name */
    protected c f154a;

    /* renamed from: b  reason: collision with root package name */
    protected d f155b;

    /* renamed from: c  reason: collision with root package name */
    protected d f156c;

    /* renamed from: d  reason: collision with root package name */
    protected d[] f157d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f158e;

    /* renamed from: f  reason: collision with root package name */
    protected Hashtable f159f;

    public static abstract class a extends f {
        protected a(c cVar, d dVar, d dVar2) {
            super(cVar, dVar, dVar2);
        }

        /* access modifiers changed from: protected */
        public boolean v() {
            d dVar;
            d dVar2;
            c g10 = g();
            d dVar3 = this.f155b;
            d k10 = g10.k();
            d l10 = g10.l();
            int n10 = g10.n();
            if (n10 == 6) {
                d dVar4 = this.f157d[0];
                boolean g11 = dVar4.g();
                if (dVar3.h()) {
                    d n11 = this.f156c.n();
                    if (!g11) {
                        l10 = l10.i(dVar4.n());
                    }
                    return n11.equals(l10);
                }
                d dVar5 = this.f156c;
                d n12 = dVar3.n();
                if (g11) {
                    dVar2 = dVar5.n().a(dVar5).a(k10);
                    dVar = n12.n().a(l10);
                } else {
                    d n13 = dVar4.n();
                    d n14 = n13.n();
                    dVar2 = dVar5.a(dVar4).k(dVar5, k10, n13);
                    dVar = n12.o(l10, n14);
                }
                return dVar2.i(n12).equals(dVar);
            }
            d dVar6 = this.f156c;
            d i10 = dVar6.a(dVar3).i(dVar6);
            if (n10 != 0) {
                if (n10 == 1) {
                    d dVar7 = this.f157d[0];
                    if (!dVar7.g()) {
                        d i11 = dVar7.i(dVar7.n());
                        i10 = i10.i(dVar7);
                        k10 = k10.i(dVar7);
                        l10 = l10.i(i11);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return i10.equals(dVar3.a(k10).i(dVar3.n()).a(l10));
        }

        protected a(c cVar, d dVar, d dVar2, d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }
    }

    public static abstract class b extends f {
        protected b(c cVar, d dVar, d dVar2) {
            super(cVar, dVar, dVar2);
        }

        /* access modifiers changed from: protected */
        public boolean v() {
            d dVar = this.f155b;
            d dVar2 = this.f156c;
            d k10 = this.f154a.k();
            d l10 = this.f154a.l();
            d n10 = dVar2.n();
            int h10 = h();
            if (h10 != 0) {
                if (h10 == 1) {
                    d dVar3 = this.f157d[0];
                    if (!dVar3.g()) {
                        d n11 = dVar3.n();
                        d i10 = dVar3.i(n11);
                        n10 = n10.i(dVar3);
                        k10 = k10.i(n11);
                        l10 = l10.i(i10);
                    }
                } else if (h10 == 2 || h10 == 3 || h10 == 4) {
                    d dVar4 = this.f157d[0];
                    if (!dVar4.g()) {
                        d n12 = dVar4.n();
                        d n13 = n12.n();
                        d i11 = n12.i(n13);
                        k10 = k10.i(n13);
                        l10 = l10.i(i11);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return n10.equals(dVar.n().a(k10).i(dVar).a(l10));
        }

        protected b(c cVar, d dVar, d dVar2, d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }
    }

    public static class c extends a {
        public c(c cVar, d dVar, d dVar2) {
            this(cVar, dVar, dVar2, false);
        }

        public f a(f fVar) {
            d dVar;
            d dVar2;
            d dVar3;
            d dVar4;
            d dVar5;
            d dVar6;
            d dVar7;
            d dVar8;
            d dVar9;
            if (o()) {
                return fVar;
            }
            if (fVar.o()) {
                return this;
            }
            c g10 = g();
            int n10 = g10.n();
            d dVar10 = this.f155b;
            d dVar11 = fVar.f155b;
            if (n10 == 0) {
                d dVar12 = this.f156c;
                d dVar13 = fVar.f156c;
                d a10 = dVar10.a(dVar11);
                d a11 = dVar12.a(dVar13);
                if (!a10.h()) {
                    d d10 = a11.d(a10);
                    d a12 = d10.n().a(d10).a(a10).a(g10.k());
                    return new c(g10, a12, d10.i(dVar10.a(a12)).a(a12).a(dVar12), this.f158e);
                } else if (a11.h()) {
                    return w();
                } else {
                    return g10.q();
                }
            } else if (n10 == 1) {
                d dVar14 = this.f156c;
                d dVar15 = this.f157d[0];
                d dVar16 = fVar.f156c;
                d dVar17 = fVar.f157d[0];
                boolean g11 = dVar17.g();
                d i10 = dVar15.i(dVar16);
                if (g11) {
                    dVar = dVar14;
                } else {
                    dVar = dVar14.i(dVar17);
                }
                d a13 = i10.a(dVar);
                d i11 = dVar15.i(dVar11);
                if (g11) {
                    dVar2 = dVar10;
                } else {
                    dVar2 = dVar10.i(dVar17);
                }
                d a14 = i11.a(dVar2);
                if (!a14.h()) {
                    d n11 = a14.n();
                    d i12 = n11.i(a14);
                    if (!g11) {
                        dVar15 = dVar15.i(dVar17);
                    }
                    d a15 = a13.a(a14);
                    d a16 = a15.k(a13, n11, g10.k()).i(dVar15).a(i12);
                    d i13 = a14.i(a16);
                    if (!g11) {
                        n11 = n11.i(dVar17);
                    }
                    d k10 = a13.k(dVar10, a14, dVar14).k(n11, a15, a16);
                    d[] dVarArr = {i12.i(dVar15)};
                    return new c(g10, i13, k10, dVarArr, this.f158e);
                } else if (a13.h()) {
                    return w();
                } else {
                    return g10.q();
                }
            } else if (n10 != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (!dVar10.h()) {
                d dVar18 = this.f156c;
                d dVar19 = this.f157d[0];
                d dVar20 = fVar.f156c;
                d dVar21 = fVar.f157d[0];
                boolean g12 = dVar19.g();
                if (!g12) {
                    dVar4 = dVar11.i(dVar19);
                    dVar3 = dVar20.i(dVar19);
                } else {
                    dVar4 = dVar11;
                    dVar3 = dVar20;
                }
                boolean g13 = dVar21.g();
                if (!g13) {
                    dVar10 = dVar10.i(dVar21);
                    dVar5 = dVar18.i(dVar21);
                } else {
                    dVar5 = dVar18;
                }
                d a17 = dVar5.a(dVar3);
                d a18 = dVar10.a(dVar4);
                if (!a18.h()) {
                    if (dVar11.h()) {
                        f s10 = s();
                        d l10 = s10.l();
                        d m10 = s10.m();
                        d d11 = m10.a(dVar20).d(l10);
                        dVar7 = d11.n().a(d11).a(l10).a(g10.k());
                        if (dVar7.h()) {
                            return new c(g10, dVar7, g10.l().m(), this.f158e);
                        }
                        d a19 = d11.i(l10.a(dVar7)).a(dVar7).a(m10).d(dVar7).a(dVar7);
                        dVar8 = g10.j(b.f122b);
                        dVar6 = a19;
                    } else {
                        d n12 = a18.n();
                        d i14 = a17.i(dVar10);
                        d i15 = a17.i(dVar4);
                        d i16 = i14.i(i15);
                        if (i16.h()) {
                            return new c(g10, i16, g10.l().m(), this.f158e);
                        }
                        d i17 = a17.i(n12);
                        if (!g13) {
                            dVar9 = i17.i(dVar21);
                        } else {
                            dVar9 = i17;
                        }
                        d o10 = i15.a(n12).o(dVar9, dVar18.a(dVar19));
                        if (!g12) {
                            dVar9 = dVar9.i(dVar19);
                        }
                        dVar6 = o10;
                        dVar7 = i16;
                        dVar8 = dVar9;
                    }
                    return new c(g10, dVar7, dVar6, new d[]{dVar8}, this.f158e);
                } else if (a17.h()) {
                    return w();
                } else {
                    return g10.q();
                }
            } else if (dVar11.h()) {
                return g10.q();
            } else {
                return fVar.a(this);
            }
        }

        public d m() {
            int h10 = h();
            if (h10 != 5 && h10 != 6) {
                return this.f156c;
            }
            d dVar = this.f155b;
            d dVar2 = this.f156c;
            if (o() || dVar.h()) {
                return dVar2;
            }
            d i10 = dVar2.a(dVar).i(dVar);
            if (6 != h10) {
                return i10;
            }
            d dVar3 = this.f157d[0];
            if (!dVar3.g()) {
                return i10.d(dVar3);
            }
            return i10;
        }

        public f r() {
            if (o()) {
                return this;
            }
            d dVar = this.f155b;
            if (dVar.h()) {
                return this;
            }
            int h10 = h();
            if (h10 == 0) {
                return new c(this.f154a, dVar, this.f156c.a(dVar), this.f158e);
            } else if (h10 == 1) {
                d dVar2 = this.f156c;
                d dVar3 = this.f157d[0];
                return new c(this.f154a, dVar, dVar2.a(dVar), new d[]{dVar3}, this.f158e);
            } else if (h10 == 5) {
                return new c(this.f154a, dVar, this.f156c.b(), this.f158e);
            } else if (h10 == 6) {
                d dVar4 = this.f156c;
                d dVar5 = this.f157d[0];
                return new c(this.f154a, dVar, dVar4.a(dVar5), new d[]{dVar5}, this.f158e);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public f w() {
            d dVar;
            d dVar2;
            d dVar3;
            d dVar4;
            d dVar5;
            d a10;
            d dVar6;
            if (o()) {
                return this;
            }
            c g10 = g();
            d dVar7 = this.f155b;
            if (dVar7.h()) {
                return g10.q();
            }
            int n10 = g10.n();
            if (n10 == 0) {
                d a11 = this.f156c.d(dVar7).a(dVar7);
                d a12 = a11.n().a(a11).a(g10.k());
                return new c(g10, a12, dVar7.o(a12, a11.b()), this.f158e);
            } else if (n10 == 1) {
                c cVar = g10;
                d dVar8 = this.f156c;
                d dVar9 = this.f157d[0];
                boolean g11 = dVar9.g();
                if (g11) {
                    dVar = dVar7;
                } else {
                    dVar = dVar7.i(dVar9);
                }
                if (!g11) {
                    dVar8 = dVar8.i(dVar9);
                }
                d n11 = dVar7.n();
                d a13 = n11.a(dVar8);
                d n12 = dVar.n();
                d a14 = a13.a(dVar);
                d k10 = a14.k(a13, n12, cVar.k());
                d i10 = dVar.i(k10);
                d k11 = n11.n().k(dVar, k10, a14);
                d[] dVarArr = {dVar.i(n12)};
                return new c(cVar, i10, k11, dVarArr, this.f158e);
            } else if (n10 == 6) {
                d dVar10 = this.f156c;
                d dVar11 = this.f157d[0];
                boolean g12 = dVar11.g();
                if (g12) {
                    dVar2 = dVar10;
                } else {
                    dVar2 = dVar10.i(dVar11);
                }
                if (g12) {
                    dVar3 = dVar11;
                } else {
                    dVar3 = dVar11.n();
                }
                d k12 = g10.k();
                if (g12) {
                    dVar4 = k12;
                } else {
                    dVar4 = k12.i(dVar3);
                }
                d a15 = dVar10.n().a(dVar2).a(dVar4);
                if (a15.h()) {
                    return new c(g10, a15, g10.l().m(), this.f158e);
                }
                d n13 = a15.n();
                if (g12) {
                    dVar5 = a15;
                } else {
                    dVar5 = a15.i(dVar3);
                }
                d l10 = g10.l();
                c cVar2 = g10;
                if (l10.c() < (g10.p() >> 1)) {
                    d n14 = dVar10.a(dVar7).n();
                    if (l10.g()) {
                        dVar6 = dVar4.a(dVar3).n();
                    } else {
                        dVar6 = dVar4.o(l10, dVar3.n());
                    }
                    a10 = n14.a(a15).a(dVar3).i(n14).a(dVar6).a(n13);
                    if (k12.h()) {
                        a10 = a10.a(dVar5);
                    } else if (!k12.g()) {
                        a10 = a10.a(k12.b().i(dVar5));
                    }
                } else {
                    if (!g12) {
                        dVar7 = dVar7.i(dVar11);
                    }
                    a10 = dVar7.o(a15, dVar2).a(n13).a(dVar5);
                }
                return new c(cVar2, n13, a10, new d[]{dVar5}, this.f158e);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public c(c cVar, d dVar, d dVar2, boolean z10) {
            super(cVar, dVar, dVar2);
            if ((dVar == null) == (dVar2 == null)) {
                if (dVar != null) {
                    d.a.s(this.f155b, this.f156c);
                    if (cVar != null) {
                        d.a.s(this.f155b, this.f154a.k());
                    }
                }
                this.f158e = z10;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        c(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
            super(cVar, dVar, dVar2, dVarArr);
            this.f158e = z10;
        }
    }

    public static class d extends b {
        public d(c cVar, d dVar, d dVar2) {
            this(cVar, dVar, dVar2, false);
        }

        /* access modifiers changed from: protected */
        public d A() {
            d[] dVarArr = this.f157d;
            d dVar = dVarArr[1];
            if (dVar != null) {
                return dVar;
            }
            d x10 = x(dVarArr[0], (d) null);
            dVarArr[1] = x10;
            return x10;
        }

        /* access modifiers changed from: protected */
        public d B(d dVar) {
            return D(dVar).a(dVar);
        }

        /* access modifiers changed from: protected */
        public d C(boolean z10) {
            d dVar;
            d dVar2 = this.f155b;
            d dVar3 = this.f156c;
            d dVar4 = this.f157d[0];
            d A = A();
            d a10 = B(dVar2.n()).a(A);
            d D = D(dVar3);
            d i10 = D.i(dVar3);
            d D2 = D(dVar2.i(i10));
            d p10 = a10.n().p(D(D2));
            d D3 = D(i10.n());
            d p11 = a10.i(D2.p(p10)).p(D3);
            if (z10) {
                dVar = D(D3.i(A));
            } else {
                dVar = null;
            }
            if (!dVar4.g()) {
                D = D.i(dVar4);
            }
            return new d(g(), p10, p11, new d[]{D, dVar}, this.f158e);
        }

        /* access modifiers changed from: protected */
        public d D(d dVar) {
            return dVar.a(dVar);
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [dd.f] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0139  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public dd.f a(dd.f r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                r2 = 0
                r3 = 1
                boolean r4 = r16.o()
                if (r4 == 0) goto L_0x000d
                return r1
            L_0x000d:
                boolean r4 = r17.o()
                if (r4 == 0) goto L_0x0014
                return r0
            L_0x0014:
                if (r0 != r1) goto L_0x001b
                dd.f r1 = r16.w()
                return r1
            L_0x001b:
                dd.c r4 = r16.g()
                int r5 = r4.n()
                dd.d r6 = r0.f155b
                dd.d r7 = r0.f156c
                dd.d r8 = r1.f155b
                dd.d r9 = r1.f156c
                if (r5 == 0) goto L_0x01e6
                if (r5 == r3) goto L_0x014d
                r10 = 4
                r11 = 2
                if (r5 == r11) goto L_0x003e
                if (r5 != r10) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                dd.d[] r12 = r0.f157d
                r12 = r12[r2]
                dd.d[] r1 = r1.f157d
                r1 = r1[r2]
                boolean r13 = r12.g()
                if (r13 != 0) goto L_0x00a3
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a3
                dd.d r1 = r6.p(r8)
                dd.d r9 = r7.p(r9)
                boolean r13 = r1.h()
                if (r13 == 0) goto L_0x0070
                boolean r1 = r9.h()
                if (r1 == 0) goto L_0x006b
                dd.f r1 = r16.w()
                return r1
            L_0x006b:
                dd.f r1 = r4.q()
                return r1
            L_0x0070:
                dd.d r13 = r1.n()
                dd.d r6 = r6.i(r13)
                dd.d r8 = r8.i(r13)
                dd.d r13 = r6.p(r8)
                dd.d r7 = r13.i(r7)
                dd.d r13 = r9.n()
                dd.d r13 = r13.p(r6)
                dd.d r8 = r13.p(r8)
                dd.d r6 = r6.p(r8)
                dd.d r6 = r6.i(r9)
                dd.d r6 = r6.p(r7)
                dd.d r1 = r1.i(r12)
            L_0x00a0:
                r14 = 0
                goto L_0x0128
            L_0x00a3:
                if (r13 == 0) goto L_0x00a6
                goto L_0x00b6
            L_0x00a6:
                dd.d r15 = r12.n()
                dd.d r8 = r15.i(r8)
                dd.d r15 = r15.i(r12)
                dd.d r9 = r15.i(r9)
            L_0x00b6:
                boolean r15 = r1.g()
                if (r15 == 0) goto L_0x00bd
                goto L_0x00cd
            L_0x00bd:
                dd.d r14 = r1.n()
                dd.d r6 = r14.i(r6)
                dd.d r14 = r14.i(r1)
                dd.d r7 = r14.i(r7)
            L_0x00cd:
                dd.d r8 = r6.p(r8)
                dd.d r9 = r7.p(r9)
                boolean r14 = r8.h()
                if (r14 == 0) goto L_0x00eb
                boolean r1 = r9.h()
                if (r1 == 0) goto L_0x00e6
                dd.f r1 = r16.w()
                return r1
            L_0x00e6:
                dd.f r1 = r4.q()
                return r1
            L_0x00eb:
                dd.d r14 = r8.n()
                dd.d r3 = r14.i(r8)
                dd.d r6 = r14.i(r6)
                dd.d r2 = r9.n()
                dd.d r2 = r2.a(r3)
                dd.d r11 = r0.D(r6)
                dd.d r2 = r2.p(r11)
                dd.d r6 = r6.p(r2)
                dd.d r3 = r6.j(r9, r3, r7)
                if (r13 != 0) goto L_0x0116
                dd.d r6 = r8.i(r12)
                goto L_0x0117
            L_0x0116:
                r6 = r8
            L_0x0117:
                if (r15 != 0) goto L_0x011e
                dd.d r1 = r6.i(r1)
                goto L_0x011f
            L_0x011e:
                r1 = r6
            L_0x011f:
                if (r1 != r8) goto L_0x0124
                r8 = r2
                r6 = r3
                goto L_0x0128
            L_0x0124:
                r8 = r2
                r6 = r3
                goto L_0x00a0
            L_0x0128:
                if (r5 != r10) goto L_0x0139
                dd.d r2 = r0.x(r1, r14)
                r3 = 2
                dd.d[] r3 = new dd.d[r3]
                r5 = 0
                r3[r5] = r1
                r7 = 1
                r3[r7] = r2
                r1 = r3
                goto L_0x0140
            L_0x0139:
                r5 = 0
                r7 = 1
                dd.d[] r2 = new dd.d[r7]
                r2[r5] = r1
                r1 = r2
            L_0x0140:
                dd.f$d r9 = new dd.f$d
                boolean r7 = r0.f158e
                r2 = r9
                r3 = r4
                r4 = r8
                r5 = r6
                r6 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r9
            L_0x014d:
                dd.d[] r2 = r0.f157d
                r3 = 0
                r2 = r2[r3]
                dd.d[] r1 = r1.f157d
                r1 = r1[r3]
                boolean r3 = r2.g()
                boolean r5 = r1.g()
                if (r3 == 0) goto L_0x0161
                goto L_0x0165
            L_0x0161:
                dd.d r9 = r9.i(r2)
            L_0x0165:
                if (r5 == 0) goto L_0x0168
                goto L_0x016c
            L_0x0168:
                dd.d r7 = r7.i(r1)
            L_0x016c:
                dd.d r9 = r9.p(r7)
                if (r3 == 0) goto L_0x0173
                goto L_0x0177
            L_0x0173:
                dd.d r8 = r8.i(r2)
            L_0x0177:
                if (r5 == 0) goto L_0x017a
                goto L_0x017e
            L_0x017a:
                dd.d r6 = r6.i(r1)
            L_0x017e:
                dd.d r8 = r8.p(r6)
                boolean r10 = r8.h()
                if (r10 == 0) goto L_0x0198
                boolean r1 = r9.h()
                if (r1 == 0) goto L_0x0193
                dd.f r1 = r16.w()
                return r1
            L_0x0193:
                dd.f r1 = r4.q()
                return r1
            L_0x0198:
                if (r3 == 0) goto L_0x019c
                r2 = r1
                goto L_0x01a3
            L_0x019c:
                if (r5 == 0) goto L_0x019f
                goto L_0x01a3
            L_0x019f:
                dd.d r2 = r2.i(r1)
            L_0x01a3:
                dd.d r1 = r8.n()
                dd.d r3 = r1.i(r8)
                dd.d r1 = r1.i(r6)
                dd.d r5 = r9.n()
                dd.d r5 = r5.i(r2)
                dd.d r5 = r5.p(r3)
                dd.d r6 = r0.D(r1)
                dd.d r5 = r5.p(r6)
                dd.d r6 = r8.i(r5)
                dd.d r1 = r1.p(r5)
                dd.d r5 = r1.j(r9, r7, r3)
                dd.d r1 = r3.i(r2)
                dd.f$d r8 = new dd.f$d
                r2 = 1
                dd.d[] r7 = new dd.d[r2]
                r2 = 0
                r7[r2] = r1
                boolean r1 = r0.f158e
                r2 = r8
                r3 = r4
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x01e6:
                dd.d r1 = r8.p(r6)
                dd.d r2 = r9.p(r7)
                boolean r3 = r1.h()
                if (r3 == 0) goto L_0x0204
                boolean r1 = r2.h()
                if (r1 == 0) goto L_0x01ff
                dd.f r1 = r16.w()
                return r1
            L_0x01ff:
                dd.f r1 = r4.q()
                return r1
            L_0x0204:
                dd.d r1 = r2.d(r1)
                dd.d r2 = r1.n()
                dd.d r2 = r2.p(r6)
                dd.d r2 = r2.p(r8)
                dd.d r3 = r6.p(r2)
                dd.d r1 = r1.i(r3)
                dd.d r1 = r1.p(r7)
                dd.f$d r3 = new dd.f$d
                boolean r5 = r0.f158e
                r3.<init>(r4, r2, r1, r5)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: dd.f.d.a(dd.f):dd.f");
        }

        public d n(int i10) {
            if (i10 == 1 && 4 == h()) {
                return A();
            }
            return f.super.n(i10);
        }

        public f r() {
            if (o()) {
                return this;
            }
            c g10 = g();
            if (g10.n() != 0) {
                return new d(g10, this.f155b, this.f156c.l(), this.f157d, this.f158e);
            }
            return new d(g10, this.f155b, this.f156c.l(), this.f158e);
        }

        public f w() {
            d dVar;
            d dVar2;
            d dVar3;
            d dVar4;
            d dVar5;
            d dVar6;
            if (o()) {
                return this;
            }
            c g10 = g();
            d dVar7 = this.f156c;
            if (dVar7.h()) {
                return g10.q();
            }
            int n10 = g10.n();
            d dVar8 = this.f155b;
            if (n10 == 0) {
                d d10 = B(dVar8.n()).a(g().k()).d(D(dVar7));
                d p10 = d10.n().p(D(dVar8));
                return new d(g10, p10, d10.i(dVar8.p(p10)).p(dVar7), this.f158e);
            } else if (n10 == 1) {
                d dVar9 = this.f157d[0];
                boolean g11 = dVar9.g();
                d k10 = g10.k();
                if (!k10.h() && !g11) {
                    k10 = k10.i(dVar9.n());
                }
                d a10 = k10.a(B(dVar8.n()));
                if (g11) {
                    dVar = dVar7;
                } else {
                    dVar = dVar7.i(dVar9);
                }
                if (g11) {
                    dVar2 = dVar7.n();
                } else {
                    dVar2 = dVar.i(dVar7);
                }
                d z10 = z(dVar8.i(dVar2));
                d p11 = a10.n().p(D(z10));
                d D = D(dVar);
                d i10 = p11.i(D);
                d D2 = D(dVar2);
                d p12 = z10.p(p11).i(a10).p(D(D2.n()));
                if (g11) {
                    dVar3 = D(D2);
                } else {
                    dVar3 = D.n();
                }
                return new d(g10, i10, p12, new d[]{D(dVar3).i(dVar)}, this.f158e);
            } else if (n10 == 2) {
                d dVar10 = this.f157d[0];
                boolean g12 = dVar10.g();
                d n11 = dVar7.n();
                d n12 = n11.n();
                d k11 = g10.k();
                d l10 = k11.l();
                if (l10.r().equals(BigInteger.valueOf(3))) {
                    if (g12) {
                        dVar6 = dVar10;
                    } else {
                        dVar6 = dVar10.n();
                    }
                    dVar4 = B(dVar8.a(dVar6).i(dVar8.p(dVar6)));
                    dVar5 = z(n11.i(dVar8));
                } else {
                    d B = B(dVar8.n());
                    if (g12) {
                        dVar4 = B.a(k11);
                    } else if (!k11.h()) {
                        d n13 = dVar10.n().n();
                        if (l10.c() < k11.c()) {
                            dVar4 = B.p(n13.i(l10));
                        } else {
                            dVar4 = B.a(n13.i(k11));
                        }
                    } else {
                        dVar4 = B;
                    }
                    dVar5 = z(dVar8.i(n11));
                }
                d p13 = dVar4.n().p(D(dVar5));
                d p14 = dVar5.p(p13).i(dVar4).p(y(n12));
                d D3 = D(dVar7);
                if (!g12) {
                    D3 = D3.i(dVar10);
                }
                return new d(g10, p13, p14, new d[]{D3}, this.f158e);
            } else if (n10 == 4) {
                return C(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        /* access modifiers changed from: protected */
        public d x(d dVar, d dVar2) {
            d k10 = g().k();
            if (k10.h() || dVar.g()) {
                return k10;
            }
            if (dVar2 == null) {
                dVar2 = dVar.n();
            }
            d n10 = dVar2.n();
            d l10 = k10.l();
            if (l10.c() < k10.c()) {
                return n10.i(l10).l();
            }
            return n10.i(k10);
        }

        /* access modifiers changed from: protected */
        public d y(d dVar) {
            return z(D(dVar));
        }

        /* access modifiers changed from: protected */
        public d z(d dVar) {
            return D(D(dVar));
        }

        public d(c cVar, d dVar, d dVar2, boolean z10) {
            super(cVar, dVar, dVar2);
            if ((dVar == null) == (dVar2 == null)) {
                this.f158e = z10;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        d(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
            super(cVar, dVar, dVar2, dVarArr);
            this.f158e = z10;
        }
    }

    protected f(c cVar, d dVar, d dVar2) {
        this(cVar, dVar, dVar2, i(cVar));
    }

    protected static d[] i(c cVar) {
        int i10;
        if (cVar == null) {
            i10 = 0;
        } else {
            i10 = cVar.n();
        }
        if (i10 == 0 || i10 == 5) {
            return f153g;
        }
        d j10 = cVar.j(b.f122b);
        if (!(i10 == 1 || i10 == 2)) {
            if (i10 == 3) {
                return new d[]{j10, j10, j10};
            } else if (i10 == 4) {
                return new d[]{j10, cVar.k()};
            } else if (i10 != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new d[]{j10};
    }

    public abstract f a(f fVar);

    /* access modifiers changed from: protected */
    public void b() {
        if (!p()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* access modifiers changed from: protected */
    public f c(d dVar, d dVar2) {
        return g().f(j().i(dVar), k().i(dVar2), this.f158e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(dd.f r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 != 0) goto L_0x0005
            return r1
        L_0x0005:
            dd.c r2 = r8.g()
            dd.c r3 = r9.g()
            if (r2 != 0) goto L_0x0011
            r4 = r0
            goto L_0x0012
        L_0x0011:
            r4 = r1
        L_0x0012:
            if (r3 != 0) goto L_0x0016
            r5 = r0
            goto L_0x0017
        L_0x0016:
            r5 = r1
        L_0x0017:
            boolean r6 = r8.o()
            boolean r7 = r9.o()
            if (r6 != 0) goto L_0x0070
            if (r7 == 0) goto L_0x0024
            goto L_0x0070
        L_0x0024:
            if (r4 == 0) goto L_0x002a
            if (r5 == 0) goto L_0x002a
        L_0x0028:
            r2 = r8
            goto L_0x0051
        L_0x002a:
            if (r4 == 0) goto L_0x0031
            dd.f r9 = r9.s()
            goto L_0x0028
        L_0x0031:
            if (r5 == 0) goto L_0x0038
            dd.f r2 = r8.s()
            goto L_0x0051
        L_0x0038:
            boolean r3 = r2.i(r3)
            if (r3 != 0) goto L_0x003f
            return r1
        L_0x003f:
            dd.f r9 = r2.s(r9)
            r3 = 2
            dd.f[] r3 = new dd.f[r3]
            r3[r1] = r8
            r3[r0] = r9
            r2.t(r3)
            r2 = r3[r1]
            r9 = r3[r0]
        L_0x0051:
            dd.d r3 = r2.l()
            dd.d r4 = r9.l()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x006e
            dd.d r2 = r2.m()
            dd.d r9 = r9.m()
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r0 = r1
        L_0x006f:
            return r0
        L_0x0070:
            if (r6 == 0) goto L_0x007f
            if (r7 == 0) goto L_0x007f
            if (r4 != 0) goto L_0x0080
            if (r5 != 0) goto L_0x0080
            boolean r9 = r2.i(r3)
            if (r9 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r0 = r1
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dd.f.d(dd.f):boolean");
    }

    public d e() {
        b();
        return l();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return d((f) obj);
    }

    public d f() {
        b();
        return m();
    }

    public c g() {
        return this.f154a;
    }

    /* access modifiers changed from: protected */
    public int h() {
        c cVar = this.f154a;
        if (cVar == null) {
            return 0;
        }
        return cVar.n();
    }

    public int hashCode() {
        int i10;
        c g10 = g();
        if (g10 == null) {
            i10 = 0;
        } else {
            i10 = ~g10.hashCode();
        }
        if (o()) {
            return i10;
        }
        f s10 = s();
        return (i10 ^ (s10.l().hashCode() * 17)) ^ (s10.m().hashCode() * InputDeviceCompat.SOURCE_KEYBOARD);
    }

    public final d j() {
        return this.f155b;
    }

    public final d k() {
        return this.f156c;
    }

    public d l() {
        return this.f155b;
    }

    public d m() {
        return this.f156c;
    }

    public d n(int i10) {
        if (i10 >= 0) {
            d[] dVarArr = this.f157d;
            if (i10 < dVarArr.length) {
                return dVarArr[i10];
            }
        }
        return null;
    }

    public boolean o() {
        if (!(this.f155b == null || this.f156c == null)) {
            d[] dVarArr = this.f157d;
            if (dVarArr.length <= 0 || !dVarArr[0].h()) {
                return false;
            }
        }
        return true;
    }

    public boolean p() {
        int h10 = h();
        if (h10 == 0 || h10 == 5 || o() || this.f157d[0].g()) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (!o() && g() != null && (!v() || !u())) {
            return false;
        }
        return true;
    }

    public abstract f r();

    public f s() {
        int h10;
        if (o() || (h10 = h()) == 0 || h10 == 5) {
            return this;
        }
        d n10 = n(0);
        if (n10.g()) {
            return this;
        }
        return t(n10.f());
    }

    /* access modifiers changed from: package-private */
    public f t(d dVar) {
        int h10 = h();
        if (h10 != 1) {
            if (h10 == 2 || h10 == 3 || h10 == 4) {
                d n10 = dVar.n();
                return c(n10, n10.i(dVar));
            } else if (h10 != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return c(dVar, dVar);
    }

    public String toString() {
        if (o()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(j());
        stringBuffer.append(',');
        stringBuffer.append(k());
        for (d append : this.f157d) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        BigInteger m10 = this.f154a.m();
        if (m10 == null || m10.equals(b.f122b) || !a.f(this, m10).o()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean v();

    public abstract f w();

    protected f(c cVar, d dVar, d dVar2, d[] dVarArr) {
        this.f159f = null;
        this.f154a = cVar;
        this.f155b = dVar;
        this.f156c = dVar2;
        this.f157d = dVarArr;
    }
}
