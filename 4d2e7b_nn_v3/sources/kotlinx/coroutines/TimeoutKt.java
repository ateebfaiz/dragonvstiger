package kotlinx.coroutines;

import dc.b;
import kotlin.jvm.functions.Function2;

public abstract class TimeoutKt {
    public static final y1 a(long j10, i0 i0Var, f1 f1Var) {
        return new y1("Timed out waiting for " + j10 + " ms", f1Var);
    }

    private static final Object b(TimeoutCoroutine timeoutCoroutine, Function2 function2) {
        j1.e(timeoutCoroutine, DelayKt.c(timeoutCoroutine.uCont.getContext()).w(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return b.c(timeoutCoroutine, timeoutCoroutine, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(long r7, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.y r7 = (kotlin.jvm.internal.y) r7
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.p.b(r10)     // Catch:{ y1 -> 0x0032 }
            goto L_0x006f
        L_0x0032:
            r8 = move-exception
            goto L_0x0070
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.p.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r3
        L_0x0046:
            kotlin.jvm.internal.y r10 = new kotlin.jvm.internal.y
            r10.<init>()
            r0.L$0 = r9     // Catch:{ y1 -> 0x0068 }
            r0.L$1 = r10     // Catch:{ y1 -> 0x0068 }
            r0.J$0 = r7     // Catch:{ y1 -> 0x0068 }
            r0.label = r4     // Catch:{ y1 -> 0x0068 }
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ y1 -> 0x0068 }
            r2.<init>(r7, r0)     // Catch:{ y1 -> 0x0068 }
            r10.f725a = r2     // Catch:{ y1 -> 0x0068 }
            java.lang.Object r7 = b(r2, r9)     // Catch:{ y1 -> 0x0068 }
            java.lang.Object r8 = kotlin.coroutines.intrinsics.b.c()     // Catch:{ y1 -> 0x0068 }
            if (r7 != r8) goto L_0x006b
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch:{ y1 -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r8 = move-exception
            r7 = r10
            goto L_0x0070
        L_0x006b:
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r10 = r7
        L_0x006f:
            return r10
        L_0x0070:
            kotlinx.coroutines.f1 r9 = r8.f1212a
            java.lang.Object r7 = r7.f725a
            if (r9 != r7) goto L_0x0077
            return r3
        L_0x0077:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.c(long, kotlin.jvm.functions.Function2, kotlin.coroutines.d):java.lang.Object");
    }
}
