package kotlinx.coroutines.channels;

import cc.c0;
import cc.l0;
import cc.v;
import kotlin.Unit;
import kotlin.b;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.channels.g;

public class m extends BufferedChannel {
    private final int X;
    private final c Y;

    public m(int i10, c cVar, Function1 function1) {
        super(i10, function1);
        this.X = i10;
        this.Y = cVar;
        if (cVar == c.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + z.b(BufferedChannel.class).b() + " instead").toString());
        } else if (i10 < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
        }
    }

    static /* synthetic */ Object T0(m mVar, Object obj, d dVar) {
        l0 d10;
        Object W0 = mVar.W0(obj, true);
        if (!(W0 instanceof g.a)) {
            return Unit.f12577a;
        }
        g.e(W0);
        Function1 function1 = mVar.f862b;
        if (function1 == null || (d10 = v.d(function1, obj, (l0) null, 2, (Object) null)) == null) {
            throw mVar.V();
        }
        b.a(d10, mVar.V());
        throw d10;
    }

    private final Object U0(Object obj, boolean z10) {
        Function1 function1;
        l0 d10;
        Object w10 = super.w(obj);
        if (g.i(w10) || g.h(w10)) {
            return w10;
        }
        if (!z10 || (function1 = this.f862b) == null || (d10 = v.d(function1, obj, (l0) null, 2, (Object) null)) == null) {
            return g.f904b.c(Unit.f12577a);
        }
        throw d10;
    }

    private final Object V0(Object obj) {
        i iVar;
        b2 b2Var;
        c0 c0Var = d.f884d;
        i iVar2 = (i) BufferedChannel.f857h.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f853d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean n10 = f0(andIncrement);
            int i10 = d.f882b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (iVar2.f113c != j11) {
                i c10 = Q(j11, iVar2);
                if (c10 != null) {
                    iVar = c10;
                } else if (n10) {
                    return g.f904b.a(V());
                }
            } else {
                iVar = iVar2;
            }
            int D = O0(iVar, i11, obj, j10, c0Var, n10);
            if (D == 0) {
                iVar.b();
                return g.f904b.c(Unit.f12577a);
            } else if (D == 1) {
                return g.f904b.c(Unit.f12577a);
            } else {
                if (D != 2) {
                    if (D == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (D != 4) {
                        if (D == 5) {
                            iVar.b();
                        }
                        iVar2 = iVar;
                    } else {
                        if (j10 < U()) {
                            iVar.b();
                        }
                        return g.f904b.a(V());
                    }
                } else if (n10) {
                    iVar.p();
                    return g.f904b.a(V());
                } else {
                    if (c0Var instanceof b2) {
                        b2Var = (b2) c0Var;
                    } else {
                        b2Var = null;
                    }
                    if (b2Var != null) {
                        v0(b2Var, iVar, i11);
                    }
                    M((iVar.f113c * ((long) i10)) + ((long) i11));
                    return g.f904b.c(Unit.f12577a);
                }
            }
        }
    }

    private final Object W0(Object obj, boolean z10) {
        if (this.Y == c.DROP_LATEST) {
            return U0(obj, z10);
        }
        return V0(obj);
    }

    /* access modifiers changed from: protected */
    public boolean g0() {
        if (this.Y == c.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    public Object w(Object obj) {
        return W0(obj, false);
    }

    public Object x(Object obj, d dVar) {
        return T0(this, obj, dVar);
    }
}
