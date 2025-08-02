package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.p;

@c(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", l = {340}, m = "invokeSuspend")
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ p $result;
    final /* synthetic */ c $upstream;
    private /* synthetic */ Object L$0;
    int label;

    static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f1002a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b0 f1003b;

        a(y yVar, b0 b0Var, p pVar) {
            this.f1002a = yVar;
            this.f1003b = b0Var;
        }

        public final Object i(Object obj, d dVar) {
            Unit unit;
            j1 j1Var = (j1) this.f1002a.f725a;
            if (j1Var != null) {
                j1Var.setValue(obj);
                unit = Unit.f12577a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return Unit.f12577a;
            }
            new k1(u1.a(obj), j1.h(this.f1003b.getCoroutineContext()));
            throw null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(c cVar, p pVar, d dVar) {
        super(2, dVar);
        this.$upstream = cVar;
    }

    public final d k(Object obj, d dVar) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, (p) null, dVar);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.p.b(obj);
            b0 b0Var = (b0) this.L$0;
            y yVar = new y();
            c cVar = this.$upstream;
            a aVar = new a(yVar, b0Var, (p) null);
            this.label = 1;
            if (cVar.a(aVar, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            kotlin.p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
