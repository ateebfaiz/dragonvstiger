package kotlinx.coroutines.channels;

import androidx.core.location.LocationRequestCompat;
import cc.a0;
import cc.b0;
import cc.c0;
import cc.l0;
import cc.v;
import cc.z;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.g;
import kotlinx.coroutines.selects.h;
import vb.n;

public class BufferedChannel implements e {
    private static final AtomicReferenceFieldUpdater C;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f853d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f854e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f855f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f856g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f857h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f858i;

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f859j;

    /* renamed from: w  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f860w;
    private volatile Object _closeCause;

    /* renamed from: a  reason: collision with root package name */
    private final int f861a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f862b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c  reason: collision with root package name */
    private final n f863c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    private final class a implements ChannelIterator, b2 {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object f864a = d.f896p;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CancellableContinuationImpl f865b;

        public a() {
        }

        private final Object e(i iVar, int i10, long j10, kotlin.coroutines.d dVar) {
            Boolean a10;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl b10 = j.b(kotlin.coroutines.intrinsics.b.b(dVar));
            try {
                this.f865b = b10;
                Object C = bufferedChannel.M0(iVar, i10, j10, this);
                if (C == d.f893m) {
                    bufferedChannel.u0(this, iVar, i10);
                } else {
                    Function1 function1 = null;
                    if (C == d.f895o) {
                        if (j10 < bufferedChannel.W()) {
                            iVar.b();
                        }
                        i iVar2 = (i) BufferedChannel.f858i.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.d0()) {
                                h();
                                break;
                            }
                            long andIncrement = BufferedChannel.f854e.getAndIncrement(bufferedChannel);
                            int i11 = d.f882b;
                            long j11 = andIncrement / ((long) i11);
                            int i12 = (int) (andIncrement % ((long) i11));
                            if (iVar2.f113c != j11) {
                                i a11 = bufferedChannel.P(j11, iVar2);
                                if (a11 != null) {
                                    iVar2 = a11;
                                }
                            }
                            Object C2 = bufferedChannel.M0(iVar2, i12, andIncrement, this);
                            if (C2 == d.f893m) {
                                bufferedChannel.u0(this, iVar2, i12);
                                break;
                            } else if (C2 == d.f895o) {
                                if (andIncrement < bufferedChannel.W()) {
                                    iVar2.b();
                                }
                            } else if (C2 != d.f894n) {
                                iVar2.b();
                                this.f864a = C2;
                                this.f865b = null;
                                a10 = kotlin.coroutines.jvm.internal.a.a(true);
                                Function1 function12 = bufferedChannel.f862b;
                                if (function12 != null) {
                                    function1 = v.a(function12, C2, b10.getContext());
                                }
                            } else {
                                throw new IllegalStateException("unexpected".toString());
                            }
                        }
                    } else {
                        iVar.b();
                        this.f864a = C;
                        this.f865b = null;
                        a10 = kotlin.coroutines.jvm.internal.a.a(true);
                        Function1 function13 = bufferedChannel.f862b;
                        if (function13 != null) {
                            function1 = v.a(function13, C, b10.getContext());
                        }
                    }
                    b10.t(a10, function1);
                }
                Object A = b10.A();
                if (A == kotlin.coroutines.intrinsics.b.c()) {
                    kotlin.coroutines.jvm.internal.e.c(dVar);
                }
                return A;
            } catch (Throwable th) {
                b10.N();
                throw th;
            }
        }

        private final boolean g() {
            this.f864a = d.z();
            Throwable S = BufferedChannel.this.S();
            if (S == null) {
                return false;
            }
            throw b0.a(S);
        }

        /* access modifiers changed from: private */
        public final void h() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f865b;
            m.c(cancellableContinuationImpl);
            this.f865b = null;
            this.f864a = d.z();
            Throwable S = BufferedChannel.this.S();
            if (S == null) {
                o.a aVar = o.f12592b;
                cancellableContinuationImpl.d(o.b(Boolean.FALSE));
                return;
            }
            o.a aVar2 = o.f12592b;
            cancellableContinuationImpl.d(o.b(p.a(S)));
        }

        public Object a(kotlin.coroutines.d dVar) {
            i iVar;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            i iVar2 = (i) BufferedChannel.f858i.get(bufferedChannel);
            while (!bufferedChannel.d0()) {
                long andIncrement = BufferedChannel.f854e.getAndIncrement(bufferedChannel);
                int i10 = d.f882b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (iVar2.f113c != j10) {
                    i a10 = bufferedChannel.P(j10, iVar2);
                    if (a10 == null) {
                        continue;
                    } else {
                        iVar = a10;
                    }
                } else {
                    iVar = iVar2;
                }
                Object C = bufferedChannel.M0(iVar, i11, andIncrement, (Object) null);
                if (C == d.f893m) {
                    throw new IllegalStateException("unreachable".toString());
                } else if (C == d.f895o) {
                    if (andIncrement < bufferedChannel.W()) {
                        iVar.b();
                    }
                    iVar2 = iVar;
                } else if (C == d.f894n) {
                    return e(iVar, i11, andIncrement, dVar);
                } else {
                    iVar.b();
                    this.f864a = C;
                    return kotlin.coroutines.jvm.internal.a.a(true);
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(g());
        }

        public void f(z zVar, int i10) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f865b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.f(zVar, i10);
            }
        }

        public final boolean i(Object obj) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f865b;
            m.c(cancellableContinuationImpl);
            Function1 function1 = null;
            this.f865b = null;
            this.f864a = obj;
            Boolean bool = Boolean.TRUE;
            Function1 function12 = BufferedChannel.this.f862b;
            if (function12 != null) {
                function1 = v.a(function12, obj, cancellableContinuationImpl.getContext());
            }
            return d.B(cancellableContinuationImpl, bool, function1);
        }

        public final void j() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f865b;
            m.c(cancellableContinuationImpl);
            this.f865b = null;
            this.f864a = d.z();
            Throwable S = BufferedChannel.this.S();
            if (S == null) {
                o.a aVar = o.f12592b;
                cancellableContinuationImpl.d(o.b(Boolean.FALSE));
                return;
            }
            o.a aVar2 = o.f12592b;
            cancellableContinuationImpl.d(o.b(p.a(S)));
        }

        public Object next() {
            Object obj = this.f864a;
            if (obj != d.f896p) {
                this.f864a = d.f896p;
                if (obj != d.z()) {
                    return obj;
                }
                throw b0.a(BufferedChannel.this.T());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* synthetic */ class b extends kotlin.jvm.internal.j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final b f867a = new b();

        b() {
            super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void c(BufferedChannel bufferedChannel, kotlinx.coroutines.selects.j jVar, Object obj) {
            bufferedChannel.A0(jVar, obj);
        }

        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
            c((BufferedChannel) obj, (kotlinx.coroutines.selects.j) obj2, obj3);
            return Unit.f12577a;
        }
    }

    /* synthetic */ class c extends kotlin.jvm.internal.j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final c f868a = new c();

        c() {
            super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        /* renamed from: c */
        public final Object e(BufferedChannel bufferedChannel, Object obj, Object obj2) {
            return bufferedChannel.w0(obj, obj2);
        }
    }

    /* synthetic */ class d extends kotlin.jvm.internal.j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final d f869a = new d();

        d() {
            super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void c(BufferedChannel bufferedChannel, kotlinx.coroutines.selects.j jVar, Object obj) {
            bufferedChannel.A0(jVar, obj);
        }

        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
            c((BufferedChannel) obj, (kotlinx.coroutines.selects.j) obj2, obj3);
            return Unit.f12577a;
        }
    }

    /* synthetic */ class e extends kotlin.jvm.internal.j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final e f870a = new e();

        e() {
            super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        /* renamed from: c */
        public final Object e(BufferedChannel bufferedChannel, Object obj, Object obj2) {
            return bufferedChannel.x0(obj, obj2);
        }
    }

    static final class f extends kotlin.jvm.internal.n implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BufferedChannel f871a;

        static final class a extends kotlin.jvm.internal.n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f872a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BufferedChannel f873b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.selects.j f874c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, BufferedChannel bufferedChannel, kotlinx.coroutines.selects.j jVar) {
                super(1);
                this.f872a = obj;
                this.f873b = bufferedChannel;
                this.f874c = jVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                if (this.f872a != d.z()) {
                    v.b(this.f873b.f862b, this.f872a, this.f874c.getContext());
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(BufferedChannel bufferedChannel) {
            super(3);
            this.f871a = bufferedChannel;
        }

        /* renamed from: a */
        public final Function1 e(kotlinx.coroutines.selects.j jVar, Object obj, Object obj2) {
            return new a(obj2, this.f871a, jVar);
        }
    }

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        f853d = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        f854e = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        f855f = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        f856g = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        Class<Object> cls2 = Object.class;
        f857h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment");
        f858i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment");
        f859j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment");
        f860w = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause");
        C = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler");
    }

    public BufferedChannel(int i10, Function1 function1) {
        f fVar;
        this.f861a = i10;
        this.f862b = function1;
        if (i10 >= 0) {
            this.bufferEnd = d.A(i10);
            this.completedExpandBuffersAndPauseFlag = R();
            i iVar = new i(0, (i) null, this, 3);
            this.sendSegment = iVar;
            this.receiveSegment = iVar;
            if (h0()) {
                iVar = d.f881a;
                m.d(iVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = iVar;
            if (function1 != null) {
                fVar = new f(this);
            } else {
                fVar = null;
            }
            this.f863c = fVar;
            this._closeCause = d.f899s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
    }

    /* access modifiers changed from: private */
    public final void A0(kotlinx.coroutines.selects.j jVar, Object obj) {
        b2 b2Var;
        i iVar = (i) f858i.get(this);
        while (!d0()) {
            long andIncrement = f854e.getAndIncrement(this);
            int i10 = d.f882b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (iVar.f113c != j10) {
                i a10 = P(j10, iVar);
                if (a10 == null) {
                    continue;
                } else {
                    iVar = a10;
                }
            }
            Object C2 = M0(iVar, i11, andIncrement, jVar);
            if (C2 == d.f893m) {
                if (jVar instanceof b2) {
                    b2Var = (b2) jVar;
                } else {
                    b2Var = null;
                }
                if (b2Var != null) {
                    u0(b2Var, iVar, i11);
                    return;
                }
                return;
            } else if (C2 == d.f895o) {
                if (andIncrement < W()) {
                    iVar.b();
                }
            } else if (C2 != d.f894n) {
                iVar.b();
                jVar.g(C2);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        p0(jVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.i) r12.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void B0(kotlinx.coroutines.channels.i r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1 r0 = r11.f862b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = cc.j.b(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.d.f882b
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.f113c
            int r8 = kotlinx.coroutines.channels.d.f882b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.w(r4)
            cc.c0 r9 = kotlinx.coroutines.channels.d.f889i
            if (r8 == r9) goto L_0x00bb
            cc.c0 r9 = kotlinx.coroutines.channels.d.f884d
            if (r8 != r9) goto L_0x0048
            long r9 = r11.U()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            cc.c0 r9 = kotlinx.coroutines.channels.d.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.v(r4)
            cc.l0 r1 = cc.v.c(r0, r5, r1)
        L_0x0040:
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x0048:
            cc.c0 r9 = kotlinx.coroutines.channels.d.f885e
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.b2
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.r
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            cc.c0 r9 = kotlinx.coroutines.channels.d.f887g
            if (r8 == r9) goto L_0x00bb
            cc.c0 r9 = kotlinx.coroutines.channels.d.f886f
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            cc.c0 r9 = kotlinx.coroutines.channels.d.f887g
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.U()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.r
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.r r9 = (kotlinx.coroutines.channels.r) r9
            kotlinx.coroutines.b2 r9 = r9.f914a
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.b2 r9 = (kotlinx.coroutines.b2) r9
        L_0x0083:
            cc.c0 r10 = kotlinx.coroutines.channels.d.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.v(r4)
            cc.l0 r1 = cc.v.c(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = cc.j.c(r3, r9)
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x00a2:
            cc.c0 r9 = kotlinx.coroutines.channels.d.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.p()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            cc.d r12 = r12.g()
            kotlinx.coroutines.channels.i r12 = (kotlinx.coroutines.channels.i) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.b2 r3 = (kotlinx.coroutines.b2) r3
            r11.D0(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.m.d(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.b2 r0 = (kotlinx.coroutines.b2) r0
            r11.D0(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.B0(kotlinx.coroutines.channels.i):void");
    }

    private final void C0(b2 b2Var) {
        E0(b2Var, true);
    }

    private final void D0(b2 b2Var) {
        E0(b2Var, false);
    }

    private final boolean E(long j10) {
        if (j10 < R() || j10 < U() + ((long) this.f861a)) {
            return true;
        }
        return false;
    }

    private final void E0(b2 b2Var, boolean z10) {
        Throwable th;
        if (b2Var instanceof CancellableContinuation) {
            kotlin.coroutines.d dVar = (kotlin.coroutines.d) b2Var;
            o.a aVar = o.f12592b;
            if (z10) {
                th = T();
            } else {
                th = V();
            }
            dVar.d(o.b(p.a(th)));
        } else if (b2Var instanceof o) {
            CancellableContinuationImpl cancellableContinuationImpl = ((o) b2Var).f910a;
            o.a aVar2 = o.f12592b;
            cancellableContinuationImpl.d(o.b(g.b(g.f904b.a(S()))));
        } else if (b2Var instanceof a) {
            ((a) b2Var).j();
        } else if (b2Var instanceof kotlinx.coroutines.selects.j) {
            ((kotlinx.coroutines.selects.j) b2Var).c(this, d.z());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + b2Var).toString());
        }
    }

    static /* synthetic */ Object F0(BufferedChannel bufferedChannel, Object obj, kotlin.coroutines.d dVar) {
        i iVar = (i) f857h.get(bufferedChannel);
        while (true) {
            long andIncrement = f853d.getAndIncrement(bufferedChannel);
            long j10 = 1152921504606846975L & andIncrement;
            boolean n10 = bufferedChannel.f0(andIncrement);
            int i10 = d.f882b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (iVar.f113c != j11) {
                i c10 = bufferedChannel.Q(j11, iVar);
                if (c10 != null) {
                    iVar = c10;
                } else if (n10) {
                    Object q02 = bufferedChannel.q0(obj, dVar);
                    if (q02 == kotlin.coroutines.intrinsics.b.c()) {
                        return q02;
                    }
                }
            }
            int D = bufferedChannel.O0(iVar, i11, obj, j10, (Object) null, n10);
            if (D == 0) {
                iVar.b();
                break;
            } else if (D == 1) {
                break;
            } else if (D != 2) {
                if (D == 3) {
                    Object G0 = bufferedChannel.G0(iVar, i11, obj, j10, dVar);
                    if (G0 == kotlin.coroutines.intrinsics.b.c()) {
                        return G0;
                    }
                } else if (D == 4) {
                    if (j10 < bufferedChannel.U()) {
                        iVar.b();
                    }
                    Object q03 = bufferedChannel.q0(obj, dVar);
                    if (q03 == kotlin.coroutines.intrinsics.b.c()) {
                        return q03;
                    }
                } else if (D == 5) {
                    iVar.b();
                }
            } else if (n10) {
                iVar.p();
                Object q04 = bufferedChannel.q0(obj, dVar);
                if (q04 == kotlin.coroutines.intrinsics.b.c()) {
                    return q04;
                }
            }
        }
        return Unit.f12577a;
    }

    private final void G(i iVar, long j10) {
        Object b10 = cc.j.b((Object) null, 1, (DefaultConstructorMarker) null);
        loop0:
        while (iVar != null) {
            for (int i10 = d.f882b - 1; -1 < i10; i10--) {
                if ((iVar.f113c * ((long) d.f882b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object w10 = iVar.w(i10);
                    if (w10 == null || w10 == d.f885e) {
                        if (iVar.r(i10, w10, d.z())) {
                            iVar.p();
                            break;
                        }
                    } else if (w10 instanceof r) {
                        if (iVar.r(i10, w10, d.z())) {
                            b10 = cc.j.c(b10, ((r) w10).f914a);
                            iVar.x(i10, true);
                            break;
                        }
                    } else if (!(w10 instanceof b2)) {
                        break;
                    } else if (iVar.r(i10, w10, d.z())) {
                        b10 = cc.j.c(b10, w10);
                        iVar.x(i10, true);
                        break;
                    }
                }
            }
            iVar = (i) iVar.g();
        }
        if (b10 == null) {
            return;
        }
        if (!(b10 instanceof ArrayList)) {
            C0((b2) b10);
            return;
        }
        m.d(b10, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) b10;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            C0((b2) arrayList.get(size));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0125 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object G0(kotlinx.coroutines.channels.i r21, int r22, java.lang.Object r23, long r24, kotlin.coroutines.d r26) {
        /*
            r20 = this;
            r9 = r20
            r0 = r23
            kotlin.coroutines.d r1 = kotlin.coroutines.intrinsics.b.b(r26)
            kotlinx.coroutines.CancellableContinuationImpl r10 = kotlinx.coroutines.j.b(r1)
            r8 = 0
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r7 = r10
            int r1 = r1.O0(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0104
            r11 = 1
            if (r1 == r11) goto L_0x00fb
            r12 = 2
            if (r1 == r12) goto L_0x00f3
            r13 = 4
            if (r1 == r13) goto L_0x00e6
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x00dc
            r21.b()     // Catch:{ all -> 0x0068 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f857h     // Catch:{ all -> 0x0068 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.channels.i r1 = (kotlinx.coroutines.channels.i) r1     // Catch:{ all -> 0x0068 }
        L_0x0039:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f853d     // Catch:{ all -> 0x0068 }
            long r2 = r2.getAndIncrement(r9)     // Catch:{ all -> 0x0068 }
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r16 = r2 & r4
            boolean r18 = r9.f0(r2)     // Catch:{ all -> 0x0068 }
            int r2 = kotlinx.coroutines.channels.d.f882b     // Catch:{ all -> 0x0068 }
            long r3 = (long) r2     // Catch:{ all -> 0x0068 }
            long r3 = r16 / r3
            long r5 = (long) r2     // Catch:{ all -> 0x0068 }
            long r5 = r16 % r5
            int r8 = (int) r5     // Catch:{ all -> 0x0068 }
            long r5 = r1.f113c     // Catch:{ all -> 0x0068 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x006d
            kotlinx.coroutines.channels.i r2 = r9.Q(r3, r1)     // Catch:{ all -> 0x0068 }
            if (r2 != 0) goto L_0x006b
            if (r18 == 0) goto L_0x0039
        L_0x0063:
            r9.r0(r0, r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x0068:
            r0 = move-exception
            goto L_0x0129
        L_0x006b:
            r7 = r2
            goto L_0x006e
        L_0x006d:
            r7 = r1
        L_0x006e:
            r1 = r20
            r2 = r7
            r3 = r8
            r4 = r23
            r5 = r16
            r21 = r7
            r7 = r10
            r19 = r8
            r8 = r18
            int r1 = r1.O0(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x00ce
            if (r1 == r11) goto L_0x00c2
            if (r1 == r12) goto L_0x00ab
            r2 = 3
            if (r1 == r2) goto L_0x00a1
            if (r1 == r13) goto L_0x0095
            if (r1 == r15) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r21.b()     // Catch:{ all -> 0x0068 }
        L_0x0092:
            r1 = r21
            goto L_0x0039
        L_0x0095:
            long r1 = r20.U()     // Catch:{ all -> 0x0068 }
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00a1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0068 }
            r0.<init>(r1)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x00ab:
            if (r18 == 0) goto L_0x00b1
            r21.p()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00b1:
            boolean r0 = r10 instanceof kotlinx.coroutines.b2     // Catch:{ all -> 0x0068 }
            if (r0 == 0) goto L_0x00b7
            r0 = r10
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            if (r0 == 0) goto L_0x0112
            r2 = r21
            r1 = r19
            r9.v0(r0, r2, r1)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00c2:
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x0068 }
        L_0x00ca:
            r10.d(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00ce:
            r2 = r21
            r2.b()     // Catch:{ all -> 0x0068 }
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x00dc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0068 }
            r0.<init>(r1)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x00e6:
            long r1 = r20.U()     // Catch:{ all -> 0x0068 }
            int r1 = (r24 > r1 ? 1 : (r24 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0068 }
            goto L_0x0063
        L_0x00f3:
            r0 = r21
            r1 = r22
            r9.v0(r10, r0, r1)     // Catch:{ all -> 0x0068 }
            goto L_0x0112
        L_0x00fb:
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x0104:
            r0 = r21
            r21.b()     // Catch:{ all -> 0x0068 }
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0068 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = kotlin.o.b(r0)     // Catch:{ all -> 0x0068 }
            goto L_0x00ca
        L_0x0112:
            java.lang.Object r0 = r10.A()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            if (r0 != r1) goto L_0x011f
            kotlin.coroutines.jvm.internal.e.c(r26)
        L_0x011f:
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            if (r0 != r1) goto L_0x0126
            return r0
        L_0x0126:
            kotlin.Unit r0 = kotlin.Unit.f12577a
            return r0
        L_0x0129:
            r10.N()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.G0(kotlinx.coroutines.channels.i, int, java.lang.Object, long, kotlin.coroutines.d):java.lang.Object");
    }

    private final i H() {
        i iVar = f859j.get(this);
        i iVar2 = (i) f857h.get(this);
        if (iVar2.f113c > ((i) iVar).f113c) {
            iVar = iVar2;
        }
        i iVar3 = (i) f858i.get(this);
        if (iVar3.f113c > ((i) iVar).f113c) {
            iVar = iVar3;
        }
        return (i) cc.c.b((cc.d) iVar);
    }

    private final boolean H0(long j10) {
        if (f0(j10)) {
            return false;
        }
        return !E(j10 & 1152921504606846975L);
    }

    private final boolean I0(Object obj, Object obj2) {
        if (obj instanceof kotlinx.coroutines.selects.j) {
            return ((kotlinx.coroutines.selects.j) obj).c(this, obj2);
        }
        Function1 function1 = null;
        if (obj instanceof o) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            o oVar = (o) obj;
            CancellableContinuationImpl cancellableContinuationImpl = oVar.f910a;
            g b10 = g.b(g.f904b.c(obj2));
            Function1 function12 = this.f862b;
            if (function12 != null) {
                function1 = v.a(function12, obj2, oVar.f910a.getContext());
            }
            return d.B(cancellableContinuationImpl, b10, function1);
        } else if (obj instanceof a) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        } else if (obj instanceof CancellableContinuation) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1 function13 = this.f862b;
            if (function13 != null) {
                function1 = v.a(function13, obj2, cancellableContinuation.getContext());
            }
            return d.B(cancellableContinuation, obj2, function1);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    private final void J(long j10) {
        B0(K(j10));
    }

    private final boolean J0(Object obj, i iVar, int i10) {
        if (obj instanceof CancellableContinuation) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return d.C((CancellableContinuation) obj, Unit.f12577a, (Function1) null, 2, (Object) null);
        } else if (obj instanceof kotlinx.coroutines.selects.j) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            kotlinx.coroutines.selects.m z10 = ((SelectImplementation) obj).z(this, Unit.f12577a);
            if (z10 == kotlinx.coroutines.selects.m.REREGISTER) {
                iVar.s(i10);
            }
            if (z10 == kotlinx.coroutines.selects.m.SUCCESSFUL) {
                return true;
            }
            return false;
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    private final i K(long j10) {
        i H = H();
        if (g0()) {
            long i02 = i0(H);
            if (i02 != -1) {
                M(i02);
            }
        }
        G(H, j10);
        return H;
    }

    private final boolean K0(i iVar, int i10, long j10) {
        Object w10 = iVar.w(i10);
        if (!(w10 instanceof b2) || j10 < f854e.get(this) || !iVar.r(i10, w10, d.f887g)) {
            return L0(iVar, i10, j10);
        }
        if (J0(w10, iVar, i10)) {
            iVar.A(i10, d.f884d);
            return true;
        }
        iVar.A(i10, d.f890j);
        iVar.x(i10, false);
        return false;
    }

    private final void L() {
        y();
    }

    private final boolean L0(i iVar, int i10, long j10) {
        while (true) {
            Object w10 = iVar.w(i10);
            if (w10 instanceof b2) {
                if (j10 < f854e.get(this)) {
                    if (iVar.r(i10, w10, new r((b2) w10))) {
                        return true;
                    }
                } else if (iVar.r(i10, w10, d.f887g)) {
                    if (J0(w10, iVar, i10)) {
                        iVar.A(i10, d.f884d);
                        return true;
                    }
                    iVar.A(i10, d.f890j);
                    iVar.x(i10, false);
                    return false;
                }
            } else if (w10 == d.f890j) {
                return false;
            } else {
                if (w10 == null) {
                    if (iVar.r(i10, w10, d.f885e)) {
                        return true;
                    }
                } else if (w10 == d.f884d || w10 == d.f888h || w10 == d.f889i || w10 == d.f891k || w10 == d.z()) {
                    return true;
                } else {
                    if (w10 != d.f886f) {
                        throw new IllegalStateException(("Unexpected cell state: " + w10).toString());
                    }
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final Object M0(i iVar, int i10, long j10, Object obj) {
        Object w10 = iVar.w(i10);
        if (w10 == null) {
            if (j10 >= (f853d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return d.f894n;
                }
                if (iVar.r(i10, w10, obj)) {
                    N();
                    return d.f893m;
                }
            }
        } else if (w10 == d.f884d && iVar.r(i10, w10, d.f889i)) {
            N();
            return iVar.y(i10);
        }
        return N0(iVar, i10, j10, obj);
    }

    private final void N() {
        if (!h0()) {
            i iVar = (i) f859j.get(this);
            while (true) {
                long andIncrement = f855f.getAndIncrement(this);
                int i10 = d.f882b;
                long j10 = andIncrement / ((long) i10);
                if (W() <= andIncrement) {
                    if (iVar.f113c < j10 && iVar.e() != null) {
                        m0(j10, iVar);
                    }
                    Z(this, 0, 1, (Object) null);
                    return;
                }
                if (iVar.f113c != j10) {
                    i O = O(j10, iVar, andIncrement);
                    if (O == null) {
                        continue;
                    } else {
                        iVar = O;
                    }
                }
                if (K0(iVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                    Z(this, 0, 1, (Object) null);
                    return;
                }
                Z(this, 0, 1, (Object) null);
            }
        }
    }

    private final Object N0(i iVar, int i10, long j10, Object obj) {
        while (true) {
            Object w10 = iVar.w(i10);
            if (w10 == null || w10 == d.f885e) {
                if (j10 < (f853d.get(this) & 1152921504606846975L)) {
                    if (iVar.r(i10, w10, d.f888h)) {
                        N();
                        return d.f895o;
                    }
                } else if (obj == null) {
                    return d.f894n;
                } else {
                    if (iVar.r(i10, w10, obj)) {
                        N();
                        return d.f893m;
                    }
                }
            } else if (w10 == d.f884d) {
                if (iVar.r(i10, w10, d.f889i)) {
                    N();
                    return iVar.y(i10);
                }
            } else if (w10 == d.f890j) {
                return d.f895o;
            } else {
                if (w10 == d.f888h) {
                    return d.f895o;
                }
                if (w10 == d.z()) {
                    N();
                    return d.f895o;
                } else if (w10 != d.f887g && iVar.r(i10, w10, d.f886f)) {
                    boolean z10 = w10 instanceof r;
                    if (z10) {
                        w10 = ((r) w10).f914a;
                    }
                    if (J0(w10, iVar, i10)) {
                        iVar.A(i10, d.f889i);
                        N();
                        return iVar.y(i10);
                    }
                    iVar.A(i10, d.f890j);
                    iVar.x(i10, false);
                    if (z10) {
                        N();
                    }
                    return d.f895o;
                }
            }
        }
    }

    private final i O(long j10, i iVar, long j11) {
        Object c10;
        long j12 = j10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f859j;
        Function2 function2 = (Function2) d.y();
        i iVar2 = iVar;
        loop0:
        while (true) {
            c10 = cc.c.c(iVar2, j12, function2);
            if (a0.c(c10)) {
                break;
            }
            z b10 = a0.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f113c >= b10.f113c) {
                    break loop0;
                } else if (b10.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            }
        }
        if (a0.c(c10)) {
            L();
            m0(j10, iVar);
            Z(this, 0, 1, (Object) null);
            return null;
        }
        i iVar3 = (i) a0.b(c10);
        long j13 = iVar3.f113c;
        if (j13 <= j12) {
            return iVar3;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f855f;
        int i10 = d.f882b;
        if (atomicLongFieldUpdater.compareAndSet(this, j11 + 1, ((long) i10) * j13)) {
            Y((iVar3.f113c * ((long) i10)) - j11);
            return null;
        }
        Z(this, 0, 1, (Object) null);
        return null;
    }

    /* access modifiers changed from: private */
    public final int O0(i iVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        iVar.B(i10, obj);
        if (z10) {
            return P0(iVar, i10, obj, j10, obj2, z10);
        }
        Object w10 = iVar.w(i10);
        if (w10 == null) {
            if (E(j10)) {
                if (iVar.r(i10, (Object) null, d.f884d)) {
                    return 1;
                }
            } else if (obj2 == null) {
                return 3;
            } else {
                if (iVar.r(i10, (Object) null, obj2)) {
                    return 2;
                }
            }
        } else if (w10 instanceof b2) {
            iVar.s(i10);
            if (I0(w10, obj)) {
                iVar.A(i10, d.f889i);
                s0();
                return 0;
            }
            if (iVar.t(i10, d.f891k) != d.f891k) {
                iVar.x(i10, true);
            }
            return 5;
        }
        return P0(iVar, i10, obj, j10, obj2, z10);
    }

    /* access modifiers changed from: private */
    public final i P(long j10, i iVar) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f858i;
        Function2 function2 = (Function2) d.y();
        loop0:
        while (true) {
            c10 = cc.c.c(iVar, j10, function2);
            if (a0.c(c10)) {
                break;
            }
            z b10 = a0.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f113c >= b10.f113c) {
                    break loop0;
                } else if (b10.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            }
        }
        if (a0.c(c10)) {
            L();
            if (iVar.f113c * ((long) d.f882b) >= W()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i iVar2 = (i) a0.b(c10);
        if (!h0() && j10 <= R() / ((long) d.f882b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f859j;
            while (true) {
                z zVar2 = (z) atomicReferenceFieldUpdater2.get(this);
                if (zVar2.f113c >= iVar2.f113c || !iVar2.q()) {
                    break;
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, zVar2, iVar2)) {
                    if (zVar2.m()) {
                        zVar2.k();
                    }
                } else if (iVar2.m()) {
                    iVar2.k();
                }
            }
        }
        long j11 = iVar2.f113c;
        if (j11 <= j10) {
            return iVar2;
        }
        int i10 = d.f882b;
        Q0(j11 * ((long) i10));
        if (iVar2.f113c * ((long) i10) >= W()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    private final int P0(i iVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        while (true) {
            Object w10 = iVar.w(i10);
            if (w10 == null) {
                if (!E(j10) || z10) {
                    if (z10) {
                        if (iVar.r(i10, (Object) null, d.f890j)) {
                            iVar.x(i10, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (iVar.r(i10, (Object) null, obj2)) {
                            return 2;
                        }
                    }
                } else if (iVar.r(i10, (Object) null, d.f884d)) {
                    return 1;
                }
            } else if (w10 == d.f885e) {
                if (iVar.r(i10, w10, d.f884d)) {
                    return 1;
                }
            } else if (w10 == d.f891k) {
                iVar.s(i10);
                return 5;
            } else if (w10 == d.f888h) {
                iVar.s(i10);
                return 5;
            } else if (w10 == d.z()) {
                iVar.s(i10);
                L();
                return 4;
            } else {
                iVar.s(i10);
                if (w10 instanceof r) {
                    w10 = ((r) w10).f914a;
                }
                if (I0(w10, obj)) {
                    iVar.A(i10, d.f889i);
                    s0();
                    return 0;
                }
                if (iVar.t(i10, d.f891k) != d.f891k) {
                    iVar.x(i10, true);
                }
                return 5;
            }
        }
    }

    /* access modifiers changed from: private */
    public final i Q(long j10, i iVar) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f857h;
        Function2 function2 = (Function2) d.y();
        loop0:
        while (true) {
            c10 = cc.c.c(iVar, j10, function2);
            if (a0.c(c10)) {
                break;
            }
            z b10 = a0.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f113c >= b10.f113c) {
                    break loop0;
                } else if (b10.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            }
        }
        if (a0.c(c10)) {
            L();
            if (iVar.f113c * ((long) d.f882b) >= U()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i iVar2 = (i) a0.b(c10);
        long j11 = iVar2.f113c;
        if (j11 <= j10) {
            return iVar2;
        }
        int i10 = d.f882b;
        R0(j11 * ((long) i10));
        if (iVar2.f113c * ((long) i10) >= U()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    private final void Q0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f854e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10 || f854e.compareAndSet(this, j11, j10)) {
            }
            j11 = atomicLongFieldUpdater.get(this);
            return;
        } while (f854e.compareAndSet(this, j11, j10));
    }

    private final long R() {
        return f855f.get(this);
    }

    private final void R0(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f853d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = 1152921504606846975L & j11;
            if (j12 < j10) {
            } else {
                return;
            }
        } while (!f853d.compareAndSet(this, j11, d.w(j12, (int) (j11 >> 60))));
    }

    /* access modifiers changed from: private */
    public final Throwable T() {
        Throwable S = S();
        if (S == null) {
            return new k("Channel was closed");
        }
        return S;
    }

    private final void Y(long j10) {
        if ((f856g.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
            } while ((f856g.get(this) & 4611686018427387904L) != 0);
        }
    }

    static /* synthetic */ void Z(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 1;
            }
            bufferedChannel.Y(j10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void a0() {
        Object obj;
        c0 c0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                c0Var = d.f897q;
            } else {
                c0Var = d.f898r;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c0Var));
        if (obj != null) {
            Function1 function1 = (Function1) kotlin.jvm.internal.c0.e(obj, 1);
            ((Function1) obj).invoke(S());
        }
    }

    private final boolean b0(i iVar, int i10, long j10) {
        Object w10;
        do {
            w10 = iVar.w(i10);
            if (w10 != null && w10 != d.f885e) {
                if (w10 == d.f884d) {
                    return true;
                }
                if (w10 == d.f890j || w10 == d.z() || w10 == d.f889i || w10 == d.f888h) {
                    return false;
                }
                if (w10 == d.f887g) {
                    return true;
                }
                if (w10 != d.f886f && j10 == U()) {
                    return true;
                }
                return false;
            }
        } while (!iVar.r(i10, w10, d.f888h));
        N();
        return false;
    }

    private final boolean c0(long j10, boolean z10) {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            K(j10 & 1152921504606846975L);
            if (z10 && X()) {
                return false;
            }
        } else if (i10 == 3) {
            J(j10 & 1152921504606846975L);
        } else {
            throw new IllegalStateException(("unexpected close status: " + i10).toString());
        }
        return true;
    }

    private final boolean e0(long j10) {
        return c0(j10, true);
    }

    /* access modifiers changed from: private */
    public final boolean f0(long j10) {
        return c0(j10, false);
    }

    private final boolean h0() {
        long R = R();
        if (R == 0 || R == LocationRequestCompat.PASSIVE_INTERVAL) {
            return true;
        }
        return false;
    }

    private final long i0(i iVar) {
        do {
            int i10 = d.f882b;
            while (true) {
                i10--;
                if (-1 < i10) {
                    long j10 = (iVar.f113c * ((long) d.f882b)) + ((long) i10);
                    if (j10 < U()) {
                        return -1;
                    }
                    while (true) {
                        Object w10 = iVar.w(i10);
                        if (w10 == null || w10 == d.f885e) {
                            if (iVar.r(i10, w10, d.z())) {
                                iVar.p();
                                break;
                            }
                        } else if (w10 == d.f884d) {
                            return j10;
                        }
                    }
                } else {
                    iVar = (i) iVar.g();
                }
            }
        } while (iVar != null);
        return -1;
    }

    private final void j0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f853d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) == 0) {
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, d.w(1152921504606846975L & j10, 1)));
    }

    private final void k0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f853d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, d.w(1152921504606846975L & j10, 3)));
    }

    private final void l0() {
        long j10;
        long b10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f853d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                b10 = d.w(j10 & 1152921504606846975L, 2);
            } else if (i10 == 1) {
                b10 = d.w(j10 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, b10));
    }

    private final void m0(long j10, i iVar) {
        i iVar2;
        i iVar3;
        while (iVar.f113c < j10 && (iVar3 = (i) iVar.e()) != null) {
            iVar = iVar3;
        }
        while (true) {
            if (!iVar.h() || (iVar2 = (i) iVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f859j;
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f113c < iVar.f113c) {
                        if (!iVar.q()) {
                            continue;
                            break;
                        } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, iVar)) {
                            if (zVar.m()) {
                                zVar.k();
                                return;
                            }
                            return;
                        } else if (iVar.m()) {
                            iVar.k();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                iVar = iVar2;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void o0(CancellableContinuation cancellableContinuation) {
        o.a aVar = o.f12592b;
        cancellableContinuation.d(o.b(g.b(g.f904b.a(S()))));
    }

    private final void p0(kotlinx.coroutines.selects.j jVar) {
        jVar.g(d.z());
    }

    private final Object q0(Object obj, kotlin.coroutines.d dVar) {
        l0 d10;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
        cancellableContinuationImpl.E();
        Function1 function1 = this.f862b;
        if (function1 == null || (d10 = v.d(function1, obj, (l0) null, 2, (Object) null)) == null) {
            Throwable V = V();
            o.a aVar = o.f12592b;
            cancellableContinuationImpl.d(o.b(p.a(V)));
        } else {
            kotlin.b.a(d10, V());
            o.a aVar2 = o.f12592b;
            cancellableContinuationImpl.d(o.b(p.a(d10)));
        }
        Object A = cancellableContinuationImpl.A();
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.e.c(dVar);
        }
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    /* access modifiers changed from: private */
    public final void r0(Object obj, CancellableContinuation cancellableContinuation) {
        Function1 function1 = this.f862b;
        if (function1 != null) {
            v.b(function1, obj, cancellableContinuation.getContext());
        }
        Throwable V = V();
        o.a aVar = o.f12592b;
        cancellableContinuation.d(o.b(p.a(V)));
    }

    /* access modifiers changed from: private */
    public final void u0(b2 b2Var, i iVar, int i10) {
        t0();
        b2Var.f(iVar, i10);
    }

    /* access modifiers changed from: private */
    public final void v0(b2 b2Var, i iVar, int i10) {
        b2Var.f(iVar, i10 + d.f882b);
    }

    /* access modifiers changed from: private */
    public final Object w0(Object obj, Object obj2) {
        if (obj2 != d.z()) {
            return obj2;
        }
        throw T();
    }

    /* access modifiers changed from: private */
    public final Object x0(Object obj, Object obj2) {
        Object obj3;
        if (obj2 == d.z()) {
            obj3 = g.f904b.a(S());
        } else {
            obj3 = g.f904b.c(obj2);
        }
        return g.b(obj3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object y0(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.d r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.p.b(r14)
            kotlinx.coroutines.channels.g r14 = (kotlinx.coroutines.channels.g) r14
            java.lang.Object r13 = r14.k()
            goto L_0x00b2
        L_0x0032:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003a:
            kotlin.p.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = f858i
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.i r14 = (kotlinx.coroutines.channels.i) r14
        L_0x0047:
            boolean r1 = r13.d0()
            if (r1 == 0) goto L_0x0058
            kotlinx.coroutines.channels.g$b r14 = kotlinx.coroutines.channels.g.f904b
            java.lang.Throwable r13 = r13.S()
            java.lang.Object r13 = r14.a(r13)
            goto L_0x00b2
        L_0x0058:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f854e
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.d.f882b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f113c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0077
            kotlinx.coroutines.channels.i r1 = r13.P(r7, r14)
            if (r1 != 0) goto L_0x0076
            goto L_0x0047
        L_0x0076:
            r14 = r1
        L_0x0077:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.M0(r8, r9, r10, r12)
            cc.c0 r7 = kotlinx.coroutines.channels.d.f893m
            if (r1 == r7) goto L_0x00b3
            cc.c0 r7 = kotlinx.coroutines.channels.d.f895o
            if (r1 != r7) goto L_0x0098
            long r7 = r13.W()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0047
            r14.b()
            goto L_0x0047
        L_0x0098:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f894n
            if (r1 != r7) goto L_0x00a9
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.z0(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00b2
            return r0
        L_0x00a9:
            r14.b()
            kotlinx.coroutines.channels.g$b r13 = kotlinx.coroutines.channels.g.f904b
            java.lang.Object r13 = r13.c(r1)
        L_0x00b2:
            return r13
        L_0x00b3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.y0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z0(kotlinx.coroutines.channels.i r11, int r12, long r13, kotlin.coroutines.d r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.channels.i r11 = (kotlinx.coroutines.channels.i) r11
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.channels.BufferedChannel r11 = (kotlinx.coroutines.channels.BufferedChannel) r11
            kotlin.p.b(r15)
            goto L_0x0134
        L_0x0032:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003a:
            kotlin.p.b(r15)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r12
            r0.J$0 = r13
            r0.label = r3
            kotlin.coroutines.d r15 = kotlin.coroutines.intrinsics.b.b(r0)
            kotlinx.coroutines.CancellableContinuationImpl r15 = kotlinx.coroutines.j.b(r15)
            kotlinx.coroutines.channels.o r8 = new kotlinx.coroutines.channels.o     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>"
            kotlin.jvm.internal.m.d(r15, r2)     // Catch:{ all -> 0x006d }
            r8.<init>(r15)     // Catch:{ all -> 0x006d }
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r8
            java.lang.Object r2 = r2.M0(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            cc.c0 r3 = kotlinx.coroutines.channels.d.f893m     // Catch:{ all -> 0x006d }
            if (r2 != r3) goto L_0x0070
            r10.u0(r8, r11, r12)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x006d:
            r11 = move-exception
            goto L_0x013b
        L_0x0070:
            cc.c0 r12 = kotlinx.coroutines.channels.d.f895o     // Catch:{ all -> 0x006d }
            r9 = 0
            if (r2 != r12) goto L_0x010a
            long r2 = r10.W()     // Catch:{ all -> 0x006d }
            int r12 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0082
            r11.b()     // Catch:{ all -> 0x006d }
        L_0x0082:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = f858i     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.i r11 = (kotlinx.coroutines.channels.i) r11     // Catch:{ all -> 0x006d }
        L_0x008c:
            boolean r12 = r10.d0()     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x0097
            r10.o0(r15)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x0097:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = f854e     // Catch:{ all -> 0x006d }
            long r12 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x006d }
            int r14 = kotlinx.coroutines.channels.d.f882b     // Catch:{ all -> 0x006d }
            long r2 = (long) r14     // Catch:{ all -> 0x006d }
            long r2 = r12 / r2
            long r4 = (long) r14     // Catch:{ all -> 0x006d }
            long r4 = r12 % r4
            int r14 = (int) r4     // Catch:{ all -> 0x006d }
            long r4 = r11.f113c     // Catch:{ all -> 0x006d }
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b6
            kotlinx.coroutines.channels.i r2 = r10.P(r2, r11)     // Catch:{ all -> 0x006d }
            if (r2 != 0) goto L_0x00b5
            goto L_0x008c
        L_0x00b5:
            r11 = r2
        L_0x00b6:
            r2 = r10
            r3 = r11
            r4 = r14
            r5 = r12
            r7 = r8
            java.lang.Object r2 = r2.M0(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            cc.c0 r3 = kotlinx.coroutines.channels.d.f893m     // Catch:{ all -> 0x006d }
            if (r2 != r3) goto L_0x00c9
            r10.u0(r8, r11, r14)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x00c9:
            cc.c0 r14 = kotlinx.coroutines.channels.d.f895o     // Catch:{ all -> 0x006d }
            if (r2 != r14) goto L_0x00db
            long r2 = r10.W()     // Catch:{ all -> 0x006d }
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x008c
            r11.b()     // Catch:{ all -> 0x006d }
            goto L_0x008c
        L_0x00db:
            cc.c0 r12 = kotlinx.coroutines.channels.d.f894n     // Catch:{ all -> 0x006d }
            if (r2 == r12) goto L_0x00fe
            r11.b()     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.g$b r11 = kotlinx.coroutines.channels.g.f904b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.g r11 = kotlinx.coroutines.channels.g.b(r11)     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r12 = r10.f862b     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x00fa
            kotlin.coroutines.CoroutineContext r13 = r15.getContext()     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r9 = cc.v.a(r12, r2, r13)     // Catch:{ all -> 0x006d }
        L_0x00fa:
            r15.t(r11, r9)     // Catch:{ all -> 0x006d }
            goto L_0x0124
        L_0x00fe:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006d }
            java.lang.String r12 = "unexpected"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x006d }
            r11.<init>(r12)     // Catch:{ all -> 0x006d }
            throw r11     // Catch:{ all -> 0x006d }
        L_0x010a:
            r11.b()     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.g$b r11 = kotlinx.coroutines.channels.g.f904b     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x006d }
            kotlinx.coroutines.channels.g r11 = kotlinx.coroutines.channels.g.b(r11)     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r12 = r10.f862b     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x00fa
            kotlin.coroutines.CoroutineContext r13 = r15.getContext()     // Catch:{ all -> 0x006d }
            kotlin.jvm.functions.Function1 r9 = cc.v.a(r12, r2, r13)     // Catch:{ all -> 0x006d }
            goto L_0x00fa
        L_0x0124:
            java.lang.Object r15 = r15.A()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.b.c()
            if (r15 != r11) goto L_0x0131
            kotlin.coroutines.jvm.internal.e.c(r0)
        L_0x0131:
            if (r15 != r1) goto L_0x0134
            return r1
        L_0x0134:
            kotlinx.coroutines.channels.g r15 = (kotlinx.coroutines.channels.g) r15
            java.lang.Object r11 = r15.k()
            return r11
        L_0x013b:
            r15.N()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.z0(kotlinx.coroutines.channels.i, int, long, kotlin.coroutines.d):java.lang.Object");
    }

    public boolean F(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return I(th, true);
    }

    /* access modifiers changed from: protected */
    public boolean I(Throwable th, boolean z10) {
        if (z10) {
            j0();
        }
        boolean a10 = androidx.concurrent.futures.a.a(f860w, this, d.f899s, th);
        if (z10) {
            k0();
        } else {
            l0();
        }
        L();
        n0();
        if (a10) {
            a0();
        }
        return a10;
    }

    /* access modifiers changed from: protected */
    public final void M(long j10) {
        l0 d10;
        i iVar = (i) f858i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f854e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 >= Math.max(((long) this.f861a) + j11, R())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                    int i10 = d.f882b;
                    long j12 = j11 / ((long) i10);
                    int i11 = (int) (j11 % ((long) i10));
                    if (iVar.f113c != j12) {
                        i P = P(j12, iVar);
                        if (P == null) {
                            continue;
                        } else {
                            iVar = P;
                        }
                    }
                    Object M0 = M0(iVar, i11, j11, (Object) null);
                    if (M0 != d.f895o) {
                        iVar.b();
                        Function1 function1 = this.f862b;
                        if (!(function1 == null || (d10 = v.d(function1, M0, (l0) null, 2, (Object) null)) == null)) {
                            throw d10;
                        }
                    } else if (j11 < W()) {
                        iVar.b();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Throwable S() {
        return (Throwable) f860w.get(this);
    }

    public final void S0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z10;
        long j12;
        if (!h0()) {
            do {
            } while (R() <= j10);
            int g10 = d.f883c;
            int i10 = 0;
            while (i10 < g10) {
                long R = R();
                if (R != (4611686018427387903L & f856g.get(this)) || R != R()) {
                    i10++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f856g;
            do {
                j11 = atomicLongFieldUpdater2.get(this);
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, d.v(j11 & 4611686018427387903L, true)));
            while (true) {
                long R2 = R();
                atomicLongFieldUpdater = f856g;
                long j13 = atomicLongFieldUpdater.get(this);
                long j14 = j13 & 4611686018427387903L;
                if ((4611686018427387904L & j13) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (R2 == j14 && R2 == R()) {
                    break;
                } else if (!z10) {
                    atomicLongFieldUpdater.compareAndSet(this, j13, d.v(j14, true));
                }
            }
            do {
                j12 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j12, d.v(j12 & 4611686018427387903L, false)));
        }
    }

    public final long U() {
        return f854e.get(this);
    }

    /* access modifiers changed from: protected */
    public final Throwable V() {
        Throwable S = S();
        if (S == null) {
            return new l("Channel was closed");
        }
        return S;
    }

    public final long W() {
        return f853d.get(this) & 1152921504606846975L;
    }

    public final boolean X() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f858i;
            i iVar = (i) atomicReferenceFieldUpdater.get(this);
            long U = U();
            if (W() <= U) {
                return false;
            }
            int i10 = d.f882b;
            long j10 = U / ((long) i10);
            if (iVar.f113c == j10 || (iVar = P(j10, iVar)) != null) {
                iVar.b();
                if (b0(iVar, (int) (U % ((long) i10)), U)) {
                    return true;
                }
                f854e.compareAndSet(this, U, U + 1);
            } else if (((i) atomicReferenceFieldUpdater.get(this)).f113c < j10) {
                return false;
            }
        }
    }

    public final void b(CancellationException cancellationException) {
        F(cancellationException);
    }

    public boolean d0() {
        return e0(f853d.get(this));
    }

    public g e() {
        b bVar = b.f867a;
        m.d(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        c cVar = c.f868a;
        m.d(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new h(this, (n) kotlin.jvm.internal.c0.e(bVar, 3), (n) kotlin.jvm.internal.c0.e(cVar, 3), this.f863c);
    }

    public g f() {
        d dVar = d.f869a;
        m.d(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        e eVar = e.f870a;
        m.d(eVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new h(this, (n) kotlin.jvm.internal.c0.e(dVar, 3), (n) kotlin.jvm.internal.c0.e(eVar, 3), this.f863c);
    }

    public Object g() {
        i iVar;
        b2 b2Var;
        long j10 = f854e.get(this);
        long j11 = f853d.get(this);
        if (e0(j11)) {
            return g.f904b.a(S());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return g.f904b.b();
        }
        c0 i10 = d.f891k;
        i iVar2 = (i) f858i.get(this);
        while (!d0()) {
            long andIncrement = f854e.getAndIncrement(this);
            int i11 = d.f882b;
            long j12 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (iVar2.f113c != j12) {
                i a10 = P(j12, iVar2);
                if (a10 == null) {
                    continue;
                } else {
                    iVar = a10;
                }
            } else {
                iVar = iVar2;
            }
            Object C2 = M0(iVar, i12, andIncrement, i10);
            if (C2 == d.f893m) {
                if (i10 instanceof b2) {
                    b2Var = (b2) i10;
                } else {
                    b2Var = null;
                }
                if (b2Var != null) {
                    u0(b2Var, iVar, i12);
                }
                S0(andIncrement);
                iVar.p();
                return g.f904b.b();
            } else if (C2 == d.f895o) {
                if (andIncrement < W()) {
                    iVar.b();
                }
                iVar2 = iVar;
            } else if (C2 != d.f894n) {
                iVar.b();
                return g.f904b.c(C2);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return g.f904b.a(S());
    }

    /* access modifiers changed from: protected */
    public boolean g0() {
        return false;
    }

    public Object h(kotlin.coroutines.d dVar) {
        return y0(this, dVar);
    }

    public ChannelIterator iterator() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public void n0() {
    }

    public boolean r(Throwable th) {
        return I(th, false);
    }

    /* access modifiers changed from: protected */
    public void s0() {
    }

    /* access modifiers changed from: protected */
    public void t0() {
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [cc.d] */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d4, code lost:
        r3 = r3.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01db, code lost:
        if (r3 != null) goto L_0x01fc;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f853d
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0023
        L_0x001e:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0023:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "capacity="
            r2.append(r5)
            int r5 = r0.f861a
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.i[] r2 = new kotlinx.coroutines.channels.i[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f858i
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f857h
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f859j
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.r.o(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.i r8 = (kotlinx.coroutines.channels.i) r8
            kotlinx.coroutines.channels.i r9 = kotlinx.coroutines.channels.d.f881a
            if (r8 == r9) goto L_0x006e
            r3.add(r4)
            goto L_0x006e
        L_0x0085:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0200
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009a
            goto L_0x00b4
        L_0x009a:
            r4 = r3
            kotlinx.coroutines.channels.i r4 = (kotlinx.coroutines.channels.i) r4
            long r8 = r4.f113c
        L_0x009f:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.i r10 = (kotlinx.coroutines.channels.i) r10
            long r10 = r10.f113c
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ae
            r3 = r4
            r8 = r10
        L_0x00ae:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009f
        L_0x00b4:
            kotlinx.coroutines.channels.i r3 = (kotlinx.coroutines.channels.i) r3
            long r10 = r16.U()
            long r12 = r16.W()
        L_0x00be:
            int r2 = kotlinx.coroutines.channels.d.f882b
            r4 = r6
        L_0x00c1:
            if (r4 >= r2) goto L_0x01d4
            long r8 = r3.f113c
            int r14 = kotlinx.coroutines.channels.d.f882b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00d3
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01dd
        L_0x00d3:
            java.lang.Object r15 = r3.w(r4)
            java.lang.Object r6 = r3.v(r4)
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x00f5
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00e9
            if (r14 < 0) goto L_0x00e9
            java.lang.String r7 = "receive"
            goto L_0x019a
        L_0x00e9:
            if (r14 >= 0) goto L_0x00f1
            if (r7 < 0) goto L_0x00f1
            java.lang.String r7 = "send"
            goto L_0x019a
        L_0x00f1:
            java.lang.String r7 = "cont"
            goto L_0x019a
        L_0x00f5:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.j
            if (r7 == 0) goto L_0x010f
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0103
            if (r14 < 0) goto L_0x0103
            java.lang.String r7 = "onReceive"
            goto L_0x019a
        L_0x0103:
            if (r14 >= 0) goto L_0x010b
            if (r7 < 0) goto L_0x010b
            java.lang.String r7 = "onSend"
            goto L_0x019a
        L_0x010b:
            java.lang.String r7 = "select"
            goto L_0x019a
        L_0x010f:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.o
            if (r7 == 0) goto L_0x0117
            java.lang.String r7 = "receiveCatching"
            goto L_0x019a
        L_0x0117:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.r
            if (r7 == 0) goto L_0x0133
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "EB("
            r7.append(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x019a
        L_0x0133:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f886f
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
            if (r7 == 0) goto L_0x013f
            r7 = 1
            goto L_0x0147
        L_0x013f:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f887g
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0147:
            if (r7 == 0) goto L_0x014c
            java.lang.String r7 = "resuming_sender"
            goto L_0x019a
        L_0x014c:
            if (r15 != 0) goto L_0x0150
            r7 = 1
            goto L_0x0158
        L_0x0150:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f885e
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0158:
            if (r7 == 0) goto L_0x015c
            r7 = 1
            goto L_0x0164
        L_0x015c:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f889i
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0164:
            if (r7 == 0) goto L_0x0168
            r7 = 1
            goto L_0x0170
        L_0x0168:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f888h
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0170:
            if (r7 == 0) goto L_0x0174
            r7 = 1
            goto L_0x017c
        L_0x0174:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f891k
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x017c:
            if (r7 == 0) goto L_0x0180
            r7 = 1
            goto L_0x0188
        L_0x0180:
            cc.c0 r7 = kotlinx.coroutines.channels.d.f890j
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0188:
            if (r7 == 0) goto L_0x018c
            r7 = 1
            goto L_0x0194
        L_0x018c:
            cc.c0 r7 = kotlinx.coroutines.channels.d.z()
            boolean r7 = kotlin.jvm.internal.m.b(r15, r7)
        L_0x0194:
            if (r7 != 0) goto L_0x01ce
            java.lang.String r7 = r15.toString()
        L_0x019a:
            if (r6 == 0) goto L_0x01bc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            r8.append(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01ce
        L_0x01bc:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01ce:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00c1
        L_0x01d4:
            cc.d r2 = r3.e()
            r3 = r2
            kotlinx.coroutines.channels.i r3 = (kotlinx.coroutines.channels.i) r3
            if (r3 != 0) goto L_0x01fc
        L_0x01dd:
            char r2 = kotlin.text.j.S0(r1)
            if (r2 != r5) goto L_0x01f2
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "this.deleteCharAt(index)"
            kotlin.jvm.internal.m.e(r2, r3)
        L_0x01f2:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x01fc:
            r6 = 0
            r7 = 1
            goto L_0x00be
        L_0x0200:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public void u(Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            do {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != d.f897q) {
                    if (obj == d.f898r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!androidx.concurrent.futures.a.a(C, this, d.f897q, d.f898r));
            function1.invoke(S());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return kotlinx.coroutines.channels.g.f904b.c(kotlin.Unit.f12577a);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object w(java.lang.Object r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f853d
            long r0 = r0.get(r14)
            boolean r0 = r14.H0(r0)
            if (r0 == 0) goto L_0x0013
            kotlinx.coroutines.channels.g$b r15 = kotlinx.coroutines.channels.g.f904b
            java.lang.Object r15 = r15.b()
            return r15
        L_0x0013:
            cc.c0 r8 = kotlinx.coroutines.channels.d.f890j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f857h
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.i r0 = (kotlinx.coroutines.channels.i) r0
        L_0x0021:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f853d
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = r14.f0(r1)
            int r1 = kotlinx.coroutines.channels.d.f882b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f113c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0059
            kotlinx.coroutines.channels.i r1 = r14.Q(r2, r0)
            if (r1 != 0) goto L_0x0057
            if (r11 == 0) goto L_0x0021
        L_0x004b:
            kotlinx.coroutines.channels.g$b r15 = kotlinx.coroutines.channels.g.f904b
            java.lang.Throwable r0 = r14.V()
            java.lang.Object r15 = r15.a(r0)
            goto L_0x00be
        L_0x0057:
            r13 = r1
            goto L_0x005a
        L_0x0059:
            r13 = r0
        L_0x005a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = r0.O0(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00ba
            r1 = 1
            if (r0 == r1) goto L_0x00b1
            r1 = 2
            if (r0 == r1) goto L_0x0094
            r1 = 3
            if (r0 == r1) goto L_0x0088
            r1 = 4
            if (r0 == r1) goto L_0x007c
            r1 = 5
            if (r0 == r1) goto L_0x0077
            goto L_0x007a
        L_0x0077:
            r13.b()
        L_0x007a:
            r0 = r13
            goto L_0x0021
        L_0x007c:
            long r0 = r14.U()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x004b
            r13.b()
            goto L_0x004b
        L_0x0088:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x0094:
            if (r11 == 0) goto L_0x009a
            r13.p()
            goto L_0x004b
        L_0x009a:
            boolean r15 = r8 instanceof kotlinx.coroutines.b2
            if (r15 == 0) goto L_0x00a1
            kotlinx.coroutines.b2 r8 = (kotlinx.coroutines.b2) r8
            goto L_0x00a2
        L_0x00a1:
            r8 = 0
        L_0x00a2:
            if (r8 == 0) goto L_0x00a7
            r14.v0(r8, r13, r12)
        L_0x00a7:
            r13.p()
            kotlinx.coroutines.channels.g$b r15 = kotlinx.coroutines.channels.g.f904b
            java.lang.Object r15 = r15.b()
            goto L_0x00be
        L_0x00b1:
            kotlinx.coroutines.channels.g$b r15 = kotlinx.coroutines.channels.g.f904b
            kotlin.Unit r0 = kotlin.Unit.f12577a
            java.lang.Object r15 = r15.c(r0)
            goto L_0x00be
        L_0x00ba:
            r13.b()
            goto L_0x00b1
        L_0x00be:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.w(java.lang.Object):java.lang.Object");
    }

    public Object x(Object obj, kotlin.coroutines.d dVar) {
        return F0(this, obj, dVar);
    }

    public boolean y() {
        return f0(f853d.get(this));
    }
}
