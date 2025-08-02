package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.flow.d;

public abstract class ChannelFlow implements l {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f1024a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1025b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1026c;

    public ChannelFlow(CoroutineContext coroutineContext, int i10, c cVar) {
        this.f1024a = coroutineContext;
        this.f1025b = i10;
        this.f1026c = cVar;
    }

    static /* synthetic */ Object e(ChannelFlow channelFlow, d dVar, kotlin.coroutines.d dVar2) {
        Object b10 = c0.b(new ChannelFlow$collect$2(dVar, channelFlow, (kotlin.coroutines.d) null), dVar2);
        if (b10 == b.c()) {
            return b10;
        }
        return Unit.f12577a;
    }

    public Object a(d dVar, kotlin.coroutines.d dVar2) {
        return e(this, dVar, dVar2);
    }

    public kotlinx.coroutines.flow.c c(CoroutineContext coroutineContext, int i10, c cVar) {
        CoroutineContext plus = coroutineContext.plus(this.f1024a);
        if (cVar == c.SUSPEND) {
            int i11 = this.f1025b;
            if (i11 != -3) {
                if (i10 != -3) {
                    if (i11 != -2) {
                        if (i10 != -2) {
                            i10 += i11;
                            if (i10 < 0) {
                                i10 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i10 = i11;
            }
            cVar = this.f1026c;
        }
        if (m.b(plus, this.f1024a) && i10 == this.f1025b && cVar == this.f1026c) {
            return this;
        }
        return i(plus, i10, cVar);
    }

    /* access modifiers changed from: protected */
    public String d() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Object g(n nVar, kotlin.coroutines.d dVar);

    /* access modifiers changed from: protected */
    public abstract ChannelFlow i(CoroutineContext coroutineContext, int i10, c cVar);

    public final Function2 j() {
        return new ChannelFlow$collectToFun$1(this, (kotlin.coroutines.d) null);
    }

    public final int k() {
        int i10 = this.f1025b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public ReceiveChannel l(b0 b0Var) {
        return ProduceKt.e(b0Var, this.f1024a, k(), this.f1026c, d0.ATOMIC, (Function1) null, j(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String d10 = d();
        if (d10 != null) {
            arrayList.add(d10);
        }
        if (this.f1024a != g.f679a) {
            arrayList.add("context=" + this.f1024a);
        }
        if (this.f1025b != -3) {
            arrayList.add("capacity=" + this.f1025b);
        }
        if (this.f1026c != c.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f1026c);
        }
        return f0.a(this) + '[' + r.f0(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ']';
    }
}
