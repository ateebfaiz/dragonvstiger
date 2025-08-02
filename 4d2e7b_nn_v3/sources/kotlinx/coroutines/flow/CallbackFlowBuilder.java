package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.ChannelFlow;

final class CallbackFlowBuilder extends b {

    /* renamed from: e  reason: collision with root package name */
    private final Function2 f966e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i10, c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i11 & 2) != 0 ? g.f679a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? c.SUSPEND : cVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(kotlinx.coroutines.channels.n r5, kotlin.coroutines.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.p.b(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.p.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = super.g(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            boolean r5 = r5.y()
            if (r5 == 0) goto L_0x004c
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.g(kotlinx.coroutines.channels.n, kotlin.coroutines.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public ChannelFlow i(CoroutineContext coroutineContext, int i10, c cVar) {
        return new CallbackFlowBuilder(this.f966e, coroutineContext, i10, cVar);
    }

    public CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i10, c cVar) {
        super(function2, coroutineContext, i10, cVar);
        this.f966e = function2;
    }
}
