package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, d dVar) {
        super(2, dVar);
        this.$this_allViews = view;
    }

    public final d k(Object obj, d dVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, dVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.sequences.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.p.b(r5)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r4.L$0
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            kotlin.p.b(r5)
            goto L_0x0037
        L_0x0022:
            kotlin.p.b(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.c(r5, r4)
            if (r5 != r0) goto L_0x0037
            return r0
        L_0x0037:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.Sequence r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.f(r5, r4)
            if (r5 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((ViewKt$allViews$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
