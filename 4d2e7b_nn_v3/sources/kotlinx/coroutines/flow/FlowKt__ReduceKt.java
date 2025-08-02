package kotlinx.coroutines.flow;

import cc.c0;
import kotlin.Unit;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.flow.internal.n;

abstract /* synthetic */ class FlowKt__ReduceKt {

    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f991a;

        public a(y yVar) {
            this.f991a = yVar;
        }

        public Object i(Object obj, kotlin.coroutines.d dVar) {
            this.f991a.f725a = obj;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f992a;

        public b(y yVar) {
            this.f992a = yVar;
        }

        public Object i(Object obj, kotlin.coroutines.d dVar) {
            this.f992a.f725a = obj;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f993a;

        c(y yVar) {
            this.f993a = yVar;
        }

        public final Object i(Object obj, kotlin.coroutines.d dVar) {
            this.f993a.f725a = obj;
            return Unit.f12577a;
        }
    }

    static final class d implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f994a;

        d(y yVar) {
            this.f994a = yVar;
        }

        public final Object i(Object obj, kotlin.coroutines.d dVar) {
            this.f994a.f725a = obj;
            return Unit.f12577a;
        }
    }

    static final class e implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f995a;

        e(y yVar) {
            this.f995a = yVar;
        }

        public final Object i(Object obj, kotlin.coroutines.d dVar) {
            y yVar = this.f995a;
            if (yVar.f725a == n.f1056a) {
                yVar.f725a = obj;
                return Unit.f12577a;
            }
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
    }

    public static final class f implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f996a;

        public f(y yVar) {
            this.f996a = yVar;
        }

        public Object i(Object obj, kotlin.coroutines.d dVar) {
            y yVar = this.f996a;
            Object obj2 = yVar.f725a;
            c0 c0Var = n.f1056a;
            if (obj2 == c0Var) {
                yVar.f725a = obj;
                return Unit.f12577a;
            }
            yVar.f725a = c0Var;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.a) r4
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.y r0 = (kotlin.jvm.internal.y) r0
            kotlin.p.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x0062
        L_0x0031:
            r5 = move-exception
            goto L_0x005f
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r5.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.L$0 = r5     // Catch:{ a -> 0x005b }
            r0.L$1 = r2     // Catch:{ a -> 0x005b }
            r0.label = r3     // Catch:{ a -> 0x005b }
            java.lang.Object r4 = r4.a(r2, r0)     // Catch:{ a -> 0x005b }
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r5
            goto L_0x0062
        L_0x005b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005f:
            kotlinx.coroutines.flow.internal.k.a(r5, r4)
        L_0x0062:
            java.lang.Object r4 = r0.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 == r5) goto L_0x0069
            return r4
        L_0x0069:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(kotlinx.coroutines.flow.c r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.y r5 = (kotlin.jvm.internal.y) r5
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.p.b(r6)     // Catch:{ a -> 0x0035 }
            goto L_0x006a
        L_0x0035:
            r6 = move-exception
            goto L_0x0067
        L_0x0037:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003f:
            kotlin.p.b(r6)
            kotlin.jvm.internal.y r6 = new kotlin.jvm.internal.y
            r6.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r6.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.L$0 = r5     // Catch:{ a -> 0x0062 }
            r0.L$1 = r6     // Catch:{ a -> 0x0062 }
            r0.L$2 = r2     // Catch:{ a -> 0x0062 }
            r0.label = r3     // Catch:{ a -> 0x0062 }
            java.lang.Object r4 = r4.a(r2, r0)     // Catch:{ a -> 0x0062 }
            if (r4 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r0 = r5
            r5 = r6
            goto L_0x006a
        L_0x0062:
            r4 = move-exception
            r0 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L_0x0067:
            kotlinx.coroutines.flow.internal.k.a(r6, r4)
        L_0x006a:
            java.lang.Object r4 = r5.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 == r5) goto L_0x0071
            return r4
        L_0x0071:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.c, kotlin.jvm.functions.Function2, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.b) r4
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.y r0 = (kotlin.jvm.internal.y) r0
            kotlin.p.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x005e
        L_0x0031:
            r5 = move-exception
            goto L_0x005b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$b
            r2.<init>(r5)
            r0.L$0 = r5     // Catch:{ a -> 0x0057 }
            r0.L$1 = r2     // Catch:{ a -> 0x0057 }
            r0.label = r3     // Catch:{ a -> 0x0057 }
            java.lang.Object r4 = r4.a(r2, r0)     // Catch:{ a -> 0x0057 }
            if (r4 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r0 = r5
            goto L_0x005e
        L_0x0057:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005b:
            kotlinx.coroutines.flow.internal.k.a(r5, r4)
        L_0x005e:
            java.lang.Object r4 = r0.f725a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(kotlinx.coroutines.flow.c r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.internal.y r5 = (kotlin.jvm.internal.y) r5
            kotlin.p.b(r6)     // Catch:{ a -> 0x0031 }
            goto L_0x005e
        L_0x0031:
            r6 = move-exception
            goto L_0x005b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.p.b(r6)
            kotlin.jvm.internal.y r6 = new kotlin.jvm.internal.y
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.L$0 = r6     // Catch:{ a -> 0x0057 }
            r0.L$1 = r2     // Catch:{ a -> 0x0057 }
            r0.label = r3     // Catch:{ a -> 0x0057 }
            java.lang.Object r4 = r4.a(r2, r0)     // Catch:{ a -> 0x0057 }
            if (r4 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r5 = r6
            goto L_0x005e
        L_0x0057:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L_0x005b:
            kotlinx.coroutines.flow.internal.k.a(r6, r4)
        L_0x005e:
            java.lang.Object r4 = r5.f725a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.d(kotlinx.coroutines.flow.c, kotlin.jvm.functions.Function2, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e(kotlinx.coroutines.flow.c r4, java.lang.Object r5, vb.n r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            kotlin.p.b(r7)
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.p.b(r7)
            kotlin.jvm.internal.y r7 = new kotlin.jvm.internal.y
            r7.<init>()
            r7.f725a = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2 r5 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2
            r5.<init>(r7, r6)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r4 = r4.a(r5, r0)
            if (r4 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = r7
        L_0x0050:
            java.lang.Object r4 = r4.f725a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.e(kotlinx.coroutines.flow.c, java.lang.Object, vb.n, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object f(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            kotlin.p.b(r5)
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r5.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$c
            r2.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r4 = r5
        L_0x0052:
            java.lang.Object r4 = r4.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 == r5) goto L_0x0059
            return r4
        L_0x0059:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.f(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            kotlin.p.b(r5)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$d
            r2.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r4 = r5
        L_0x004e:
            java.lang.Object r4 = r4.f725a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.g(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object h(kotlinx.coroutines.flow.c r4, vb.n r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            kotlin.p.b(r6)
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.p.b(r6)
            kotlin.jvm.internal.y r6 = new kotlin.jvm.internal.y
            r6.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r6.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2
            r2.<init>(r6, r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r4 = r6
        L_0x0052:
            java.lang.Object r4 = r4.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 == r5) goto L_0x0059
            return r4
        L_0x0059:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Empty flow can't be reduced"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.h(kotlinx.coroutines.flow.c, vb.n, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object i(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            kotlin.p.b(r5)
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r5.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$e
            r2.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.a(r2, r0)
            if (r4 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r4 = r5
        L_0x0052:
            java.lang.Object r4 = r4.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 == r5) goto L_0x0059
            return r4
        L_0x0059:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.i(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object j(kotlinx.coroutines.flow.c r4, kotlin.coroutines.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.f) r4
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.y r0 = (kotlin.jvm.internal.y) r0
            kotlin.p.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x0062
        L_0x0031:
            r5 = move-exception
            goto L_0x005f
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.p.b(r5)
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            cc.c0 r2 = kotlinx.coroutines.flow.internal.n.f1056a
            r5.f725a = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$f
            r2.<init>(r5)
            r0.L$0 = r5     // Catch:{ a -> 0x005b }
            r0.L$1 = r2     // Catch:{ a -> 0x005b }
            r0.label = r3     // Catch:{ a -> 0x005b }
            java.lang.Object r4 = r4.a(r2, r0)     // Catch:{ a -> 0x005b }
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r5
            goto L_0x0062
        L_0x005b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005f:
            kotlinx.coroutines.flow.internal.k.a(r5, r4)
        L_0x0062:
            java.lang.Object r4 = r0.f725a
            cc.c0 r5 = kotlinx.coroutines.flow.internal.n.f1056a
            if (r4 != r5) goto L_0x0069
            r4 = 0
        L_0x0069:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.j(kotlinx.coroutines.flow.c, kotlin.coroutines.d):java.lang.Object");
    }
}
