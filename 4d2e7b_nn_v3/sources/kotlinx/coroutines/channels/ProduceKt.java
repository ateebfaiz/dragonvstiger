package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.n;
import kotlin.o;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.x;

public abstract class ProduceKt {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f875a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CancellableContinuation cancellableContinuation) {
            super(1);
            this.f875a = cancellableContinuation;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.f12577a;
        }

        public final void invoke(Throwable th) {
            CancellableContinuation cancellableContinuation = this.f875a;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(Unit.f12577a));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlinx.coroutines.channels.n r4, kotlin.jvm.functions.Function0 r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.p.b(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x0075
        L_0x0032:
            r4 = move-exception
            goto L_0x007b
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.p.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.f1$b r2 = kotlinx.coroutines.f1.f964r
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            if (r6 != r4) goto L_0x007f
            r0.L$0 = r4     // Catch:{ all -> 0x0032 }
            r0.L$1 = r5     // Catch:{ all -> 0x0032 }
            r0.label = r3     // Catch:{ all -> 0x0032 }
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0032 }
            kotlin.coroutines.d r2 = kotlin.coroutines.intrinsics.b.b(r0)     // Catch:{ all -> 0x0032 }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x0032 }
            r6.E()     // Catch:{ all -> 0x0032 }
            kotlinx.coroutines.channels.ProduceKt$a r2 = new kotlinx.coroutines.channels.ProduceKt$a     // Catch:{ all -> 0x0032 }
            r2.<init>(r6)     // Catch:{ all -> 0x0032 }
            r4.u(r2)     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r6.A()     // Catch:{ all -> 0x0032 }
            java.lang.Object r6 = kotlin.coroutines.intrinsics.b.c()     // Catch:{ all -> 0x0032 }
            if (r4 != r6) goto L_0x0072
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch:{ all -> 0x0032 }
        L_0x0072:
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r5.invoke()
            kotlin.Unit r4 = kotlin.Unit.f12577a
            return r4
        L_0x007b:
            r5.invoke()
            throw r4
        L_0x007f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.n, kotlin.jvm.functions.Function0, kotlin.coroutines.d):java.lang.Object");
    }

    public static final ReceiveChannel b(b0 b0Var, CoroutineContext coroutineContext, int i10, Function2 function2) {
        return c(b0Var, coroutineContext, i10, c.SUSPEND, d0.DEFAULT, (Function1) null, function2);
    }

    public static final ReceiveChannel c(b0 b0Var, CoroutineContext coroutineContext, int i10, c cVar, d0 d0Var, Function1 function1, Function2 function2) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(x.e(b0Var, coroutineContext), f.b(i10, cVar, (Function1) null, 4, (Object) null));
        if (function1 != null) {
            producerCoroutine.v(function1);
        }
        producerCoroutine.L0(d0Var, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static /* synthetic */ ReceiveChannel d(b0 b0Var, CoroutineContext coroutineContext, int i10, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = g.f679a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return b(b0Var, coroutineContext, i10, function2);
    }

    public static /* synthetic */ ReceiveChannel e(b0 b0Var, CoroutineContext coroutineContext, int i10, c cVar, d0 d0Var, Function1 function1, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = g.f679a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            cVar = c.SUSPEND;
        }
        c cVar2 = cVar;
        if ((i11 & 8) != 0) {
            d0Var = d0.DEFAULT;
        }
        d0 d0Var2 = d0Var;
        if ((i11 & 16) != 0) {
            function1 = null;
        }
        return c(b0Var, coroutineContext2, i12, cVar2, d0Var2, function1, function2);
    }
}
