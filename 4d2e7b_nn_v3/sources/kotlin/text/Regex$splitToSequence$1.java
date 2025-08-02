package kotlin.text;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {275, 283, 287}, m = "invokeSuspend")
final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ h this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$splitToSequence$1(h hVar, CharSequence charSequence, int i10, d dVar) {
        super(2, dVar);
        this.this$0 = hVar;
        this.$input = charSequence;
        this.$limit = i10;
    }

    public final d k(Object obj, d dVar) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, dVar);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002d
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.p.b(r10)
            goto L_0x009d
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            int r1 = r9.I$0
            java.lang.Object r5 = r9.L$1
            java.util.regex.Matcher r5 = (java.util.regex.Matcher) r5
            java.lang.Object r6 = r9.L$0
            kotlin.sequences.g r6 = (kotlin.sequences.g) r6
            kotlin.p.b(r10)
            r10 = r5
            goto L_0x0071
        L_0x002d:
            kotlin.p.b(r10)
            goto L_0x00af
        L_0x0032:
            kotlin.p.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlin.sequences.g r10 = (kotlin.sequences.g) r10
            kotlin.text.h r1 = r9.this$0
            java.util.regex.Pattern r1 = r1.f821a
            java.lang.CharSequence r5 = r9.$input
            java.util.regex.Matcher r1 = r1.matcher(r5)
            int r5 = r9.$limit
            if (r5 == r4) goto L_0x00a0
            boolean r5 = r1.find()
            if (r5 != 0) goto L_0x0050
            goto L_0x00a0
        L_0x0050:
            r5 = 0
            r6 = r10
            r10 = r1
            r1 = r5
        L_0x0054:
            java.lang.CharSequence r7 = r9.$input
            int r8 = r10.start()
            java.lang.CharSequence r5 = r7.subSequence(r5, r8)
            java.lang.String r5 = r5.toString()
            r9.L$0 = r6
            r9.L$1 = r10
            r9.I$0 = r1
            r9.label = r3
            java.lang.Object r5 = r6.c(r5, r9)
            if (r5 != r0) goto L_0x0071
            return r0
        L_0x0071:
            int r5 = r10.end()
            int r1 = r1 + r4
            int r7 = r9.$limit
            int r7 = r7 - r4
            if (r1 == r7) goto L_0x0081
            boolean r7 = r10.find()
            if (r7 != 0) goto L_0x0054
        L_0x0081:
            java.lang.CharSequence r10 = r9.$input
            int r1 = r10.length()
            java.lang.CharSequence r10 = r10.subSequence(r5, r1)
            java.lang.String r10 = r10.toString()
            r1 = 0
            r9.L$0 = r1
            r9.L$1 = r1
            r9.label = r2
            java.lang.Object r10 = r6.c(r10, r9)
            if (r10 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r10 = kotlin.Unit.f12577a
            return r10
        L_0x00a0:
            java.lang.CharSequence r1 = r9.$input
            java.lang.String r1 = r1.toString()
            r9.label = r4
            java.lang.Object r10 = r10.c(r1, r9)
            if (r10 != r0) goto L_0x00af
            return r0
        L_0x00af:
            kotlin.Unit r10 = kotlin.Unit.f12577a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((Regex$splitToSequence$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
