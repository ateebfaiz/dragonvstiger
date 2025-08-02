package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import vb.n;

@c(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, 180, 182, 183, 185}, m = "invokeSuspend")
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements n {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ s1 this$0;

    StartedWhileSubscribed$command$1(s1 s1Var, d dVar) {
        super(3, dVar);
    }

    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
        return u((d) obj, ((Number) obj2).intValue(), (d) obj3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x003d
            if (r1 == r6) goto L_0x0039
            if (r1 == r5) goto L_0x0031
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            goto L_0x0039
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r11)
            goto L_0x0089
        L_0x0029:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r11)
            goto L_0x007a
        L_0x0031:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.p.b(r11)
            goto L_0x0063
        L_0x0039:
            kotlin.p.b(r11)
            goto L_0x0096
        L_0x003d:
            kotlin.p.b(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            int r11 = r10.I$0
            if (r11 <= 0) goto L_0x0054
            kotlinx.coroutines.flow.p1 r11 = kotlinx.coroutines.flow.p1.START
            r10.label = r6
            java.lang.Object r11 = r1.i(r11, r10)
            if (r11 != r0) goto L_0x0096
            return r0
        L_0x0054:
            long r8 = kotlinx.coroutines.flow.s1.c(r7)
            r10.L$0 = r1
            r10.label = r5
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r8, r10)
            if (r11 != r0) goto L_0x0063
            return r0
        L_0x0063:
            long r5 = kotlinx.coroutines.flow.s1.b(r7)
            r8 = 0
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0089
            kotlinx.coroutines.flow.p1 r11 = kotlinx.coroutines.flow.p1.STOP
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r1.i(r11, r10)
            if (r11 != r0) goto L_0x007a
            return r0
        L_0x007a:
            long r4 = kotlinx.coroutines.flow.s1.b(r7)
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L_0x0089
            return r0
        L_0x0089:
            kotlinx.coroutines.flow.p1 r11 = kotlinx.coroutines.flow.p1.STOP_AND_RESET_REPLAY_CACHE
            r10.L$0 = r7
            r10.label = r2
            java.lang.Object r11 = r1.i(r11, r10)
            if (r11 != r0) goto L_0x0096
            return r0
        L_0x0096:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.n(java.lang.Object):java.lang.Object");
    }

    public final Object u(d dVar, int i10, d dVar2) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1((s1) null, dVar2);
        startedWhileSubscribed$command$1.L$0 = dVar;
        startedWhileSubscribed$command$1.I$0 = i10;
        return startedWhileSubscribed$command$1.n(Unit.f12577a);
    }
}
