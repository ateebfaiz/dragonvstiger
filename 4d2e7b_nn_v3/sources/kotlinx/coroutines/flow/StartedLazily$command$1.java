package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.f;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.v;
import kotlin.p;

@c(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
final class StartedLazily$command$1 extends SuspendLambda implements Function2<d, d, Object> {
    final /* synthetic */ t1 $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartedLazily$command$1(t1 t1Var, d dVar) {
        super(2, dVar);
        this.$subscriptionCount = t1Var;
    }

    public final d k(Object obj, d dVar) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, dVar);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            final d dVar = (d) this.L$0;
            final v vVar = new v();
            t1 t1Var = this.$subscriptionCount;
            AnonymousClass1 r42 = new d() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object a(int r5, kotlin.coroutines.d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.p.b(r6)
                        goto L_0x004b
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.p.b(r6)
                        if (r5 <= 0) goto L_0x004e
                        kotlin.jvm.internal.v r5 = r1
                        boolean r6 = r5.f722a
                        if (r6 != 0) goto L_0x004e
                        r5.f722a = r3
                        kotlinx.coroutines.flow.d r5 = r6
                        kotlinx.coroutines.flow.p1 r6 = kotlinx.coroutines.flow.p1.START
                        r0.label = r3
                        java.lang.Object r5 = r5.i(r6, r0)
                        if (r5 != r1) goto L_0x004b
                        return r1
                    L_0x004b:
                        kotlin.Unit r5 = kotlin.Unit.f12577a
                        return r5
                    L_0x004e:
                        kotlin.Unit r5 = kotlin.Unit.f12577a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1.AnonymousClass1.a(int, kotlin.coroutines.d):java.lang.Object");
                }

                public /* bridge */ /* synthetic */ Object i(Object obj, d dVar) {
                    return a(((Number) obj).intValue(), dVar);
                }
            };
            this.label = 1;
            if (t1Var.a(r42, this) == c10) {
                return c10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            p.b(obj);
        }
        throw new f();
    }

    /* renamed from: u */
    public final Object invoke(d dVar, d dVar2) {
        return ((StartedLazily$command$1) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
