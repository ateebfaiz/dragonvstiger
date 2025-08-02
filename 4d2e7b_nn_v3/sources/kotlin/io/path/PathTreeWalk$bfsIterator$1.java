package kotlin.io.path;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190}, m = "invokeSuspend")
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ n this$0;

    PathTreeWalk$bfsIterator$1(n nVar, d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1((n) null, dVar);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0124 A[SYNTHETIC] */
    public final java.lang.Object n(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0047
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r11.L$2
            kotlin.io.path.e r1 = (kotlin.io.path.e) r1
            java.lang.Object r5 = r11.L$1
            kotlin.collections.i r5 = (kotlin.collections.i) r5
            java.lang.Object r6 = r11.L$0
            kotlin.sequences.g r6 = (kotlin.sequences.g) r6
            kotlin.p.b(r12)
            goto L_0x0078
        L_0x001f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0027:
            java.lang.Object r1 = r11.L$5
            java.nio.file.Path r1 = kotlin.io.path.a.a(r1)
            java.lang.Object r5 = r11.L$4
            c.d.a(r5)
            java.lang.Object r5 = r11.L$3
            kotlin.io.path.i r5 = (kotlin.io.path.i) r5
            java.lang.Object r6 = r11.L$2
            kotlin.io.path.e r6 = (kotlin.io.path.e) r6
            java.lang.Object r7 = r11.L$1
            kotlin.collections.i r7 = (kotlin.collections.i) r7
            java.lang.Object r8 = r11.L$0
            kotlin.sequences.g r8 = (kotlin.sequences.g) r8
            kotlin.p.b(r12)
            goto L_0x00c7
        L_0x0047:
            kotlin.p.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlin.sequences.g r12 = (kotlin.sequences.g) r12
            kotlin.collections.i r1 = new kotlin.collections.i
            r1.<init>()
            kotlin.io.path.e r5 = new kotlin.io.path.e
            boolean r6 = kotlin.io.path.n.b(r4)
            r5.<init>(r6)
            kotlin.io.path.i r6 = new kotlin.io.path.i
            java.nio.file.Path r7 = kotlin.io.path.n.e(r4)
            java.nio.file.Path r8 = kotlin.io.path.n.e(r4)
            java.nio.file.LinkOption[] r9 = kotlin.io.path.n.d(r4)
            java.lang.Object r8 = kotlin.io.path.p.d(r8, r9)
            r6.<init>(r7, r8, r4)
            r1.addLast(r6)
            r6 = r12
            r10 = r5
            r5 = r1
            r1 = r10
        L_0x0078:
            boolean r12 = r5.isEmpty()
            r12 = r12 ^ r3
            if (r12 == 0) goto L_0x0124
            java.lang.Object r12 = r5.removeFirst()
            kotlin.io.path.i r12 = (kotlin.io.path.i) r12
            java.nio.file.Path r7 = r12.d()
            java.nio.file.LinkOption[] r8 = kotlin.io.path.n.d(r4)
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.isDirectory(r7, r8)
            if (r8 == 0) goto L_0x00fa
            boolean r8 = kotlin.io.path.p.c(r12)
            if (r8 != 0) goto L_0x00ee
            boolean r8 = kotlin.io.path.n.c(r4)
            if (r8 == 0) goto L_0x00cc
            r11.L$0 = r6
            r11.L$1 = r5
            r11.L$2 = r1
            r11.L$3 = r12
            r11.L$4 = r4
            r11.L$5 = r7
            r11.label = r3
            java.lang.Object r8 = r6.c(r7, r11)
            if (r8 != r0) goto L_0x00c2
            return r0
        L_0x00c2:
            r8 = r6
            r6 = r1
            r1 = r7
            r7 = r5
            r5 = r12
        L_0x00c7:
            r12 = r5
            r5 = r7
            r7 = r1
            r1 = r6
            r6 = r8
        L_0x00cc:
            java.nio.file.LinkOption[] r8 = kotlin.io.path.n.d(r4)
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r7 = java.nio.file.Files.isDirectory(r7, r8)
            if (r7 == 0) goto L_0x0078
            java.util.List r12 = r1.b(r12)
            java.util.Collection r12 = (java.util.Collection) r12
            r5.addAll(r12)
            goto L_0x0078
        L_0x00ee:
            kotlin.io.path.m.a()
            java.lang.String r12 = r7.toString()
            java.nio.file.FileSystemLoopException r12 = kotlin.io.path.l.a(r12)
            throw r12
        L_0x00fa:
            java.nio.file.LinkOption[] r12 = new java.nio.file.LinkOption[r3]
            r8 = 0
            java.nio.file.LinkOption r9 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r12[r8] = r9
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r3)
            java.nio.file.LinkOption[] r12 = (java.nio.file.LinkOption[]) r12
            boolean r12 = java.nio.file.Files.exists(r7, r12)
            if (r12 == 0) goto L_0x0078
            r11.L$0 = r6
            r11.L$1 = r5
            r11.L$2 = r1
            r11.L$3 = r4
            r11.L$4 = r4
            r11.L$5 = r4
            r11.label = r2
            java.lang.Object r12 = r6.c(r7, r11)
            if (r12 != r0) goto L_0x0078
            return r0
        L_0x0124:
            kotlin.Unit r12 = kotlin.Unit.f12577a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((PathTreeWalk$bfsIterator$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
