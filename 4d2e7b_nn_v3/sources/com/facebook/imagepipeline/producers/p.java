package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.net.Uri;
import c5.e;
import c5.f;
import e5.j;
import e5.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import y2.o;
import y4.g;

public final class p implements d1 {

    /* renamed from: m  reason: collision with root package name */
    public static final a f20193m = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final b3.a f20194a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f20195b;

    /* renamed from: c  reason: collision with root package name */
    private final c5.c f20196c;

    /* renamed from: d  reason: collision with root package name */
    private final e f20197d;

    /* renamed from: e  reason: collision with root package name */
    private final z4.e f20198e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f20199f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f20200g;

    /* renamed from: h  reason: collision with root package name */
    private final d1 f20201h;

    /* renamed from: i  reason: collision with root package name */
    private final int f20202i;

    /* renamed from: j  reason: collision with root package name */
    private final z4.a f20203j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f20204k;

    /* renamed from: l  reason: collision with root package name */
    private final o f20205l;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final boolean b(j jVar, y4.c cVar) {
            if (((long) jVar.getWidth()) * ((long) jVar.getHeight()) * ((long) o5.a.e(cVar.f24903h)) > 104857600) {
                return true;
            }
            return false;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b extends d {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ p f20206k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p pVar, n nVar, e1 e1Var, boolean z10, int i10) {
            super(pVar, nVar, e1Var, z10, i10);
            m.f(nVar, "consumer");
            m.f(e1Var, "producerContext");
            this.f20206k = pVar;
        }

        /* access modifiers changed from: protected */
        public synchronized boolean I(j jVar, int i10) {
            boolean z10;
            if (c.e(i10)) {
                z10 = false;
            } else {
                z10 = super.I(jVar, i10);
            }
            return z10;
        }

        /* access modifiers changed from: protected */
        public int w(j jVar) {
            m.f(jVar, "encodedImage");
            return jVar.A();
        }

        /* access modifiers changed from: protected */
        public e5.o y() {
            e5.o d10 = n.d(0, false, false);
            m.e(d10, "of(0, false, false)");
            return d10;
        }
    }

    private final class c extends d {

        /* renamed from: k  reason: collision with root package name */
        private final f f20207k;

        /* renamed from: l  reason: collision with root package name */
        private final e f20208l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ p f20209m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p pVar, n nVar, e1 e1Var, f fVar, e eVar, boolean z10, int i10) {
            super(pVar, nVar, e1Var, z10, i10);
            m.f(nVar, "consumer");
            m.f(e1Var, "producerContext");
            m.f(fVar, "progressiveJpegParser");
            m.f(eVar, "progressiveJpegConfig");
            this.f20209m = pVar;
            this.f20207k = fVar;
            this.f20208l = eVar;
            H(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0062, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean I(e5.j r4, int r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                r0 = 0
                if (r4 != 0) goto L_0x0006
                monitor-exit(r3)
                return r0
            L_0x0006:
                boolean r1 = super.I(r4, r5)     // Catch:{ all -> 0x0019 }
                boolean r2 = com.facebook.imagepipeline.producers.c.e(r5)     // Catch:{ all -> 0x0019 }
                if (r2 != 0) goto L_0x001b
                r2 = 8
                boolean r2 = com.facebook.imagepipeline.producers.c.m(r5, r2)     // Catch:{ all -> 0x0019 }
                if (r2 == 0) goto L_0x0061
                goto L_0x001b
            L_0x0019:
                r4 = move-exception
                goto L_0x0063
            L_0x001b:
                r2 = 4
                boolean r5 = com.facebook.imagepipeline.producers.c.m(r5, r2)     // Catch:{ all -> 0x0019 }
                if (r5 != 0) goto L_0x0061
                boolean r5 = e5.j.J(r4)     // Catch:{ all -> 0x0019 }
                if (r5 == 0) goto L_0x0061
                q4.c r5 = r4.v()     // Catch:{ all -> 0x0019 }
                q4.c r2 = q4.b.f23216b     // Catch:{ all -> 0x0019 }
                if (r5 != r2) goto L_0x0061
                c5.f r5 = r3.f20207k     // Catch:{ all -> 0x0019 }
                boolean r4 = r5.g(r4)     // Catch:{ all -> 0x0019 }
                if (r4 != 0) goto L_0x003a
                monitor-exit(r3)
                return r0
            L_0x003a:
                c5.f r4 = r3.f20207k     // Catch:{ all -> 0x0019 }
                int r4 = r4.d()     // Catch:{ all -> 0x0019 }
                int r5 = r3.x()     // Catch:{ all -> 0x0019 }
                if (r4 > r5) goto L_0x0048
                monitor-exit(r3)
                return r0
            L_0x0048:
                c5.e r5 = r3.f20208l     // Catch:{ all -> 0x0019 }
                int r2 = r3.x()     // Catch:{ all -> 0x0019 }
                int r5 = r5.b(r2)     // Catch:{ all -> 0x0019 }
                if (r4 >= r5) goto L_0x005e
                c5.f r5 = r3.f20207k     // Catch:{ all -> 0x0019 }
                boolean r5 = r5.e()     // Catch:{ all -> 0x0019 }
                if (r5 != 0) goto L_0x005e
                monitor-exit(r3)
                return r0
            L_0x005e:
                r3.H(r4)     // Catch:{ all -> 0x0019 }
            L_0x0061:
                monitor-exit(r3)
                return r1
            L_0x0063:
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.p.c.I(e5.j, int):boolean");
        }

        /* access modifiers changed from: protected */
        public int w(j jVar) {
            m.f(jVar, "encodedImage");
            return this.f20207k.c();
        }

        /* access modifiers changed from: protected */
        public e5.o y() {
            e5.o a10 = this.f20208l.a(this.f20207k.d());
            m.e(a10, "progressiveJpegConfig.ge…pegParser.bestScanNumber)");
            return a10;
        }
    }

    private abstract class d extends t {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final e1 f20210c;

        /* renamed from: d  reason: collision with root package name */
        private final String f20211d = "ProgressiveDecoder";

        /* renamed from: e  reason: collision with root package name */
        private final g1 f20212e;

        /* renamed from: f  reason: collision with root package name */
        private final y4.c f20213f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f20214g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final g0 f20215h;

        /* renamed from: i  reason: collision with root package name */
        private int f20216i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ p f20217j;

        public static final class a extends f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f20218a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f20219b;

            a(d dVar, boolean z10) {
                this.f20218a = dVar;
                this.f20219b = z10;
            }

            public void a() {
                if (this.f20219b) {
                    this.f20218a.z();
                }
            }

            public void b() {
                if (this.f20218a.f20210c.A()) {
                    this.f20218a.f20215h.h();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(p pVar, n nVar, e1 e1Var, boolean z10, int i10) {
            super(nVar);
            m.f(nVar, "consumer");
            m.f(e1Var, "producerContext");
            this.f20217j = pVar;
            this.f20210c = e1Var;
            this.f20212e = e1Var.z();
            y4.c g10 = e1Var.b().g();
            m.e(g10, "producerContext.imageRequest.imageDecodeOptions");
            this.f20213f = g10;
            this.f20215h = new g0(pVar.f(), new q(this, pVar, i10), g10.f24896a);
            e1Var.h(new a(this, z10));
        }

        private final void A(Throwable th) {
            D(true);
            o().onFailure(th);
        }

        private final void B(e5.e eVar, int i10) {
            c3.a b10 = this.f20217j.c().b(eVar);
            try {
                D(c.d(i10));
                o().c(b10, i10);
            } finally {
                c3.a.m(b10);
            }
        }

        private final e5.e C(j jVar, int i10, e5.o oVar) {
            boolean z10;
            if (this.f20217j.h() != null) {
                Object obj = this.f20217j.i().get();
                m.e(obj, "recoverFromDecoderOOM.get()");
                if (((Boolean) obj).booleanValue()) {
                    z10 = true;
                    return this.f20217j.g().a(jVar, i10, oVar, this.f20213f);
                }
            }
            z10 = false;
            try {
                return this.f20217j.g().a(jVar, i10, oVar, this.f20213f);
            } catch (OutOfMemoryError e10) {
                if (z10) {
                    Runnable h10 = this.f20217j.h();
                    if (h10 != null) {
                        h10.run();
                    }
                    System.gc();
                    return this.f20217j.g().a(jVar, i10, oVar, this.f20213f);
                }
                throw e10;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void D(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 == 0) goto L_0x0020
                boolean r2 = r1.f20214g     // Catch:{ all -> 0x001d }
                if (r2 == 0) goto L_0x0008
                goto L_0x0020
            L_0x0008:
                com.facebook.imagepipeline.producers.n r2 = r1.o()     // Catch:{ all -> 0x001d }
                r0 = 1065353216(0x3f800000, float:1.0)
                r2.b(r0)     // Catch:{ all -> 0x001d }
                r2 = 1
                r1.f20214g = r2     // Catch:{ all -> 0x001d }
                kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x001d }
                monitor-exit(r1)
                com.facebook.imagepipeline.producers.g0 r2 = r1.f20215h
                r2.c()
                return
            L_0x001d:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            L_0x0020:
                monitor-exit(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.p.d.D(boolean):void");
        }

        private final void E(j jVar) {
            if (jVar.v() == q4.b.f23216b) {
                jVar.T(m5.a.c(jVar, o5.a.e(this.f20213f.f24903h), 104857600));
            }
        }

        private final void G(j jVar, e5.e eVar, int i10) {
            this.f20210c.w("encoded_width", Integer.valueOf(jVar.getWidth()));
            this.f20210c.w("encoded_height", Integer.valueOf(jVar.getHeight()));
            this.f20210c.w("encoded_size", Integer.valueOf(jVar.A()));
            this.f20210c.w("image_color_space", jVar.n());
            if (eVar instanceof e5.d) {
                this.f20210c.w("bitmap_config", String.valueOf(((e5.d) eVar).x().getConfig()));
            }
            if (eVar != null) {
                eVar.m(this.f20210c.getExtras());
            }
            this.f20210c.w("last_scan_num", Integer.valueOf(i10));
        }

        /* access modifiers changed from: private */
        public static final void q(d dVar, p pVar, int i10, j jVar, int i11) {
            String str;
            m.f(dVar, "this$0");
            m.f(pVar, "this$1");
            if (jVar != null) {
                k5.b b10 = dVar.f20210c.b();
                dVar.f20210c.w("image_format", jVar.v().a());
                Uri u10 = b10.u();
                if (u10 != null) {
                    str = u10.toString();
                } else {
                    str = null;
                }
                jVar.U(str);
                boolean m10 = c.m(i11, 16);
                if ((pVar.e() == z4.e.ALWAYS || (pVar.e() == z4.e.AUTO && !m10)) && (pVar.d() || !g3.f.o(b10.u()))) {
                    g s10 = b10.s();
                    m.e(s10, "request.rotationOptions");
                    jVar.T(m5.a.b(s10, b10.q(), jVar, i10));
                }
                if (dVar.f20210c.j().F().h()) {
                    dVar.E(jVar);
                }
                dVar.u(jVar, i11, dVar.f20216i);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x011d A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x013c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void u(e5.j r21, int r22, int r23) {
            /*
                r20 = this;
                r11 = r20
                r12 = r21
                r0 = r22
                r1 = 4
                java.lang.String r4 = "quality"
                q4.c r5 = r21.v()
                q4.c r6 = q4.b.f23216b
                if (r5 == r6) goto L_0x0018
                boolean r5 = com.facebook.imagepipeline.producers.c.e(r22)
                if (r5 == 0) goto L_0x0018
                return
            L_0x0018:
                boolean r5 = r11.f20214g
                if (r5 != 0) goto L_0x01c3
                boolean r5 = e5.j.J(r21)
                if (r5 != 0) goto L_0x0024
                goto L_0x01c3
            L_0x0024:
                q4.c r5 = r21.v()
                q4.c r6 = q4.b.f23218d
                boolean r5 = kotlin.jvm.internal.m.b(r5, r6)
                r6 = 0
                java.lang.String r13 = "DecodeProducer"
                if (r5 == 0) goto L_0x007f
                com.facebook.imagepipeline.producers.p$a r5 = com.facebook.imagepipeline.producers.p.f20193m
                y4.c r7 = r11.f20213f
                boolean r5 = r5.b(r12, r7)
                if (r5 == 0) goto L_0x007f
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                int r1 = r21.getWidth()
                int r2 = r21.getHeight()
                y4.c r3 = r11.f20213f
                android.graphics.Bitmap$Config r3 = r3.f24903h
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Image is too big to attempt decoding: w = "
                r4.append(r5)
                r4.append(r1)
                java.lang.String r1 = ", h = "
                r4.append(r1)
                r4.append(r2)
                java.lang.String r1 = ", pixel config = "
                r4.append(r1)
                r4.append(r3)
                java.lang.String r1 = ", max bitmap size = 104857600"
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                r0.<init>(r1)
                com.facebook.imagepipeline.producers.g1 r1 = r11.f20212e
                com.facebook.imagepipeline.producers.e1 r2 = r11.f20210c
                r1.k(r2, r13, r0, r6)
                r11.A(r0)
                return
            L_0x007f:
                q4.c r5 = r21.v()
                java.lang.String r7 = "unknown"
                if (r5 == 0) goto L_0x0090
                java.lang.String r5 = r5.a()
                if (r5 != 0) goto L_0x008e
                goto L_0x0090
            L_0x008e:
                r8 = r5
                goto L_0x0091
            L_0x0090:
                r8 = r7
            L_0x0091:
                int r5 = r21.getWidth()
                int r9 = r21.getHeight()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r5)
                java.lang.String r5 = "x"
                r10.append(r5)
                r10.append(r9)
                java.lang.String r9 = r10.toString()
                int r10 = r21.z()
                java.lang.String r10 = java.lang.String.valueOf(r10)
                boolean r14 = com.facebook.imagepipeline.producers.c.d(r22)
                if (r14 == 0) goto L_0x00c5
                r15 = 8
                boolean r15 = com.facebook.imagepipeline.producers.c.m(r0, r15)
                if (r15 != 0) goto L_0x00c5
                r15 = 1
                goto L_0x00c6
            L_0x00c5:
                r15 = 0
            L_0x00c6:
                boolean r16 = com.facebook.imagepipeline.producers.c.m(r0, r1)
                com.facebook.imagepipeline.producers.e1 r6 = r11.f20210c
                k5.b r6 = r6.b()
                y4.f r6 = r6.q()
                if (r6 == 0) goto L_0x00ef
                int r7 = r6.f24926a
                int r6 = r6.f24927b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r7)
                r2.append(r5)
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                r17 = r2
                goto L_0x00f1
            L_0x00ef:
                r17 = r7
            L_0x00f1:
                com.facebook.imagepipeline.producers.g0 r2 = r11.f20215h     // Catch:{ all -> 0x0114 }
                long r5 = r2.f()     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.e1 r2 = r11.f20210c     // Catch:{ all -> 0x0114 }
                k5.b r2 = r2.b()     // Catch:{ all -> 0x0114 }
                android.net.Uri r2 = r2.u()     // Catch:{ all -> 0x0114 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0114 }
                java.lang.String r7 = "producerContext.imageRequest.sourceUri.toString()"
                kotlin.jvm.internal.m.e(r2, r7)     // Catch:{ all -> 0x0114 }
                if (r15 != 0) goto L_0x0117
                if (r16 == 0) goto L_0x010f
                goto L_0x0117
            L_0x010f:
                int r7 = r20.w(r21)     // Catch:{ all -> 0x0114 }
                goto L_0x011b
            L_0x0114:
                r0 = move-exception
                goto L_0x01bf
            L_0x0117:
                int r7 = r21.A()     // Catch:{ all -> 0x0114 }
            L_0x011b:
                if (r15 != 0) goto L_0x0125
                if (r16 == 0) goto L_0x0120
                goto L_0x0125
            L_0x0120:
                e5.o r15 = r20.y()     // Catch:{ all -> 0x0114 }
                goto L_0x0127
            L_0x0125:
                e5.o r15 = e5.n.f21287d     // Catch:{ all -> 0x0114 }
            L_0x0127:
                com.facebook.imagepipeline.producers.g1 r1 = r11.f20212e     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.e1 r3 = r11.f20210c     // Catch:{ all -> 0x0114 }
                r1.e(r3, r13)     // Catch:{ all -> 0x0114 }
                kotlin.jvm.internal.m.e(r15, r4)     // Catch:{ a -> 0x016b }
                e5.e r7 = r11.C(r12, r7, r15)     // Catch:{ a -> 0x016b }
                int r1 = r21.z()     // Catch:{ Exception -> 0x0160 }
                r2 = 1
                if (r1 == r2) goto L_0x013e
                r0 = r0 | 16
            L_0x013e:
                r1 = r20
                r2 = r7
                r3 = r5
                r5 = r15
                r6 = r14
                r14 = r7
                r7 = r8
                r8 = r9
                r9 = r17
                java.util.Map r1 = r1.v(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.g1 r2 = r11.f20212e     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.e1 r3 = r11.f20210c     // Catch:{ all -> 0x0114 }
                r2.j(r3, r13, r1)     // Catch:{ all -> 0x0114 }
                r1 = r23
                r11.G(r12, r14, r1)     // Catch:{ all -> 0x0114 }
                r11.B(r14, r0)     // Catch:{ all -> 0x0114 }
                e5.j.h(r21)
                return
            L_0x0160:
                r0 = move-exception
                r1 = r7
                r2 = r1
                r19 = r13
                goto L_0x019f
            L_0x0166:
                r0 = move-exception
                r19 = r13
            L_0x0169:
                r2 = 0
                goto L_0x019f
            L_0x016b:
                r0 = move-exception
                e5.j r1 = r0.a()     // Catch:{ Exception -> 0x0166 }
                java.lang.String r3 = r11.f20211d     // Catch:{ Exception -> 0x0166 }
                java.lang.String r7 = "%s, {uri: %s, firstEncodedBytes: %s, length: %d}"
                java.lang.String r18 = r0.getMessage()     // Catch:{ Exception -> 0x0166 }
                r12 = 10
                java.lang.String r12 = r1.p(r12)     // Catch:{ Exception -> 0x0166 }
                int r1 = r1.A()     // Catch:{ Exception -> 0x0166 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0166 }
                r19 = r13
                r13 = 4
                java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x019d }
                r16 = 0
                r13[r16] = r18     // Catch:{ Exception -> 0x019d }
                r16 = 1
                r13[r16] = r2     // Catch:{ Exception -> 0x019d }
                r2 = 2
                r13[r2] = r12     // Catch:{ Exception -> 0x019d }
                r2 = 3
                r13[r2] = r1     // Catch:{ Exception -> 0x019d }
                z2.a.I(r3, r7, r13)     // Catch:{ Exception -> 0x019d }
                throw r0     // Catch:{ Exception -> 0x019d }
            L_0x019d:
                r0 = move-exception
                goto L_0x0169
            L_0x019f:
                kotlin.jvm.internal.m.e(r15, r4)     // Catch:{ all -> 0x0114 }
                r1 = r20
                r3 = r5
                r5 = r15
                r6 = r14
                r7 = r8
                r8 = r9
                r9 = r17
                java.util.Map r1 = r1.v(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.g1 r2 = r11.f20212e     // Catch:{ all -> 0x0114 }
                com.facebook.imagepipeline.producers.e1 r3 = r11.f20210c     // Catch:{ all -> 0x0114 }
                r4 = r19
                r2.k(r3, r4, r0, r1)     // Catch:{ all -> 0x0114 }
                r11.A(r0)     // Catch:{ all -> 0x0114 }
                e5.j.h(r21)
                return
            L_0x01bf:
                e5.j.h(r21)
                throw r0
            L_0x01c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.p.d.u(e5.j, int, int):void");
        }

        private final Map v(e5.e eVar, long j10, e5.o oVar, boolean z10, String str, String str2, String str3, String str4) {
            Map extras;
            Object obj;
            e5.e eVar2 = eVar;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            String str9 = null;
            if (!this.f20212e.g(this.f20210c, "DecodeProducer")) {
                return null;
            }
            String valueOf = String.valueOf(j10);
            String valueOf2 = String.valueOf(oVar.b());
            String valueOf3 = String.valueOf(z10);
            if (!(eVar2 == null || (extras = eVar.getExtras()) == null || (obj = extras.get("non_fatal_decode_error")) == null)) {
                str9 = obj.toString();
            }
            Object obj2 = "non_fatal_decode_error";
            String str10 = str9;
            if (eVar2 instanceof e5.g) {
                Bitmap x10 = ((e5.g) eVar2).x();
                m.e(x10, "image.underlyingBitmap");
                Bitmap bitmap = x10;
                String str11 = x10.getWidth() + "x" + x10.getHeight();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", str11);
                hashMap.put("queueTime", valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str6);
                hashMap.put("imageFormat", str5);
                hashMap.put("requestedImageSize", str7);
                hashMap.put("sampleSize", str4);
                int byteCount = bitmap.getByteCount();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(byteCount);
                hashMap.put("byteCount", sb2.toString());
                if (str10 != null) {
                    hashMap.put(obj2, str10);
                }
                return y2.g.a(hashMap);
            }
            String str12 = str8;
            String str13 = str10;
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str6);
            hashMap2.put("imageFormat", str5);
            hashMap2.put("requestedImageSize", str7);
            hashMap2.put("sampleSize", str12);
            if (str10 != null) {
                hashMap2.put(obj2, str10);
            }
            return y2.g.a(hashMap2);
        }

        /* access modifiers changed from: private */
        public final void z() {
            D(true);
            o().a();
        }

        /* renamed from: F */
        public void h(j jVar, int i10) {
            if (!l5.b.d()) {
                boolean d10 = c.d(i10);
                if (d10) {
                    if (jVar == null) {
                        boolean b10 = m.b(this.f20210c.p("cached_value_found"), Boolean.TRUE);
                        if (!this.f20210c.j().F().g() || this.f20210c.B() == b.c.FULL_FETCH || b10) {
                            A(new g3.a("Encoded image is null."));
                            return;
                        }
                    } else if (!jVar.I()) {
                        A(new g3.a("Encoded image is not valid."));
                        return;
                    }
                }
                if (I(jVar, i10)) {
                    boolean m10 = c.m(i10, 4);
                    if (d10 || m10 || this.f20210c.A()) {
                        this.f20215h.h();
                        return;
                    }
                    return;
                }
                return;
            }
            l5.b.a("DecodeProducer#onNewResultImpl");
            try {
                boolean d11 = c.d(i10);
                if (d11) {
                    if (jVar == null) {
                        boolean b11 = m.b(this.f20210c.p("cached_value_found"), Boolean.TRUE);
                        if (this.f20210c.j().F().g() && this.f20210c.B() != b.c.FULL_FETCH) {
                            if (b11) {
                            }
                        }
                        A(new g3.a("Encoded image is null."));
                        l5.b.b();
                        return;
                    } else if (!jVar.I()) {
                        A(new g3.a("Encoded image is not valid."));
                        l5.b.b();
                        return;
                    }
                }
                if (!I(jVar, i10)) {
                    l5.b.b();
                    return;
                }
                boolean m11 = c.m(i10, 4);
                if (d11 || m11 || this.f20210c.A()) {
                    this.f20215h.h();
                }
                Unit unit = Unit.f12577a;
                l5.b.b();
            } catch (Throwable th) {
                l5.b.b();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public final void H(int i10) {
            this.f20216i = i10;
        }

        /* access modifiers changed from: protected */
        public boolean I(j jVar, int i10) {
            return this.f20215h.k(jVar, i10);
        }

        public void f() {
            z();
        }

        public void g(Throwable th) {
            m.f(th, "t");
            A(th);
        }

        /* access modifiers changed from: protected */
        public void i(float f10) {
            super.i(f10 * 0.99f);
        }

        /* access modifiers changed from: protected */
        public abstract int w(j jVar);

        /* access modifiers changed from: protected */
        public final int x() {
            return this.f20216i;
        }

        /* access modifiers changed from: protected */
        public abstract e5.o y();
    }

    public p(b3.a aVar, Executor executor, c5.c cVar, e eVar, z4.e eVar2, boolean z10, boolean z11, d1 d1Var, int i10, z4.a aVar2, Runnable runnable, o oVar) {
        m.f(aVar, "byteArrayPool");
        m.f(executor, "executor");
        m.f(cVar, "imageDecoder");
        m.f(eVar, "progressiveJpegConfig");
        m.f(eVar2, "downsampleMode");
        m.f(d1Var, "inputProducer");
        m.f(aVar2, "closeableReferenceFactory");
        m.f(oVar, "recoverFromDecoderOOM");
        this.f20194a = aVar;
        this.f20195b = executor;
        this.f20196c = cVar;
        this.f20197d = eVar;
        this.f20198e = eVar2;
        this.f20199f = z10;
        this.f20200g = z11;
        this.f20201h = d1Var;
        this.f20202i = i10;
        this.f20203j = aVar2;
        this.f20204k = runnable;
        this.f20205l = oVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.facebook.imagepipeline.producers.p$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.facebook.imagepipeline.producers.p$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.facebook.imagepipeline.producers.p$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.facebook.imagepipeline.producers.p$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.facebook.imagepipeline.producers.p$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.facebook.imagepipeline.producers.p$b} */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.facebook.imagepipeline.producers.n] */
    /* JADX WARNING: type inference failed for: r7v4, types: [com.facebook.imagepipeline.producers.n] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.facebook.imagepipeline.producers.n r11, com.facebook.imagepipeline.producers.e1 r12) {
        /*
            r10 = this;
            java.lang.String r1 = "consumer"
            kotlin.jvm.internal.m.f(r11, r1)
            java.lang.String r1 = "context"
            kotlin.jvm.internal.m.f(r12, r1)
            boolean r1 = l5.b.d()
            if (r1 != 0) goto L_0x0053
            k5.b r1 = r12.b()
            android.net.Uri r2 = r1.u()
            boolean r2 = g3.f.o(r2)
            if (r2 != 0) goto L_0x0036
            android.net.Uri r1 = r1.u()
            boolean r1 = k5.c.r(r1)
            if (r1 != 0) goto L_0x0036
            com.facebook.imagepipeline.producers.p$b r7 = new com.facebook.imagepipeline.producers.p$b
            boolean r5 = r10.f20200g
            int r6 = r10.f20202i
            r1 = r7
            r2 = r10
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x004d
        L_0x0036:
            c5.f r5 = new c5.f
            b3.a r1 = r10.f20194a
            r5.<init>(r1)
            com.facebook.imagepipeline.producers.p$c r9 = new com.facebook.imagepipeline.producers.p$c
            c5.e r6 = r10.f20197d
            boolean r7 = r10.f20200g
            int r8 = r10.f20202i
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r7 = r9
        L_0x004d:
            com.facebook.imagepipeline.producers.d1 r1 = r10.f20201h
            r1.b(r7, r12)
            goto L_0x00a1
        L_0x0053:
            java.lang.String r1 = "DecodeProducer#produceResults"
            l5.b.a(r1)
            k5.b r1 = r12.b()     // Catch:{ all -> 0x007e }
            android.net.Uri r2 = r1.u()     // Catch:{ all -> 0x007e }
            boolean r2 = g3.f.o(r2)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0080
            android.net.Uri r1 = r1.u()     // Catch:{ all -> 0x007e }
            boolean r1 = k5.c.r(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0080
            com.facebook.imagepipeline.producers.p$b r7 = new com.facebook.imagepipeline.producers.p$b     // Catch:{ all -> 0x007e }
            boolean r5 = r10.f20200g     // Catch:{ all -> 0x007e }
            int r6 = r10.f20202i     // Catch:{ all -> 0x007e }
            r1 = r7
            r2 = r10
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x007e }
            goto L_0x0097
        L_0x007e:
            r0 = move-exception
            goto L_0x00a2
        L_0x0080:
            c5.f r5 = new c5.f     // Catch:{ all -> 0x007e }
            b3.a r1 = r10.f20194a     // Catch:{ all -> 0x007e }
            r5.<init>(r1)     // Catch:{ all -> 0x007e }
            com.facebook.imagepipeline.producers.p$c r9 = new com.facebook.imagepipeline.producers.p$c     // Catch:{ all -> 0x007e }
            c5.e r6 = r10.f20197d     // Catch:{ all -> 0x007e }
            boolean r7 = r10.f20200g     // Catch:{ all -> 0x007e }
            int r8 = r10.f20202i     // Catch:{ all -> 0x007e }
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007e }
            r7 = r9
        L_0x0097:
            com.facebook.imagepipeline.producers.d1 r1 = r10.f20201h     // Catch:{ all -> 0x007e }
            r1.b(r7, r12)     // Catch:{ all -> 0x007e }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x007e }
            l5.b.b()
        L_0x00a1:
            return
        L_0x00a2:
            l5.b.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.p.b(com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.e1):void");
    }

    public final z4.a c() {
        return this.f20203j;
    }

    public final boolean d() {
        return this.f20199f;
    }

    public final z4.e e() {
        return this.f20198e;
    }

    public final Executor f() {
        return this.f20195b;
    }

    public final c5.c g() {
        return this.f20196c;
    }

    public final Runnable h() {
        return this.f20204k;
    }

    public final o i() {
        return this.f20205l;
    }
}
