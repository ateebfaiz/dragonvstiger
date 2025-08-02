package kotlin.io.path;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;

@c(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", l = {184, 190, 199, 205}, m = "invokeSuspend")
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<g, d, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ n this$0;

    PathTreeWalk$dfsIterator$1(n nVar, d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1((n) null, dVar);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: kotlin.sequences.g} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0204 A[SYNTHETIC] */
    public final java.lang.Object n(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
            int r1 = r14.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0070
            if (r1 == r6) goto L_0x0050
            if (r1 == r5) goto L_0x003f
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            goto L_0x003f
        L_0x0017:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x001f:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = kotlin.io.path.a.a(r1)
            java.lang.Object r5 = r14.L$4
            c.d.a(r5)
            java.lang.Object r5 = r14.L$3
            kotlin.io.path.i r5 = (kotlin.io.path.i) r5
            java.lang.Object r8 = r14.L$2
            kotlin.io.path.e r8 = (kotlin.io.path.e) r8
            java.lang.Object r9 = r14.L$1
            kotlin.collections.i r9 = (kotlin.collections.i) r9
            java.lang.Object r10 = r14.L$0
            kotlin.sequences.g r10 = (kotlin.sequences.g) r10
            kotlin.p.b(r15)
            goto L_0x019d
        L_0x003f:
            java.lang.Object r1 = r14.L$2
            kotlin.io.path.e r1 = (kotlin.io.path.e) r1
            java.lang.Object r5 = r14.L$1
            kotlin.collections.i r5 = (kotlin.collections.i) r5
            java.lang.Object r8 = r14.L$0
            kotlin.sequences.g r8 = (kotlin.sequences.g) r8
            kotlin.p.b(r15)
            goto L_0x013b
        L_0x0050:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = kotlin.io.path.a.a(r1)
            java.lang.Object r5 = r14.L$4
            c.d.a(r5)
            java.lang.Object r5 = r14.L$3
            kotlin.io.path.i r5 = (kotlin.io.path.i) r5
            java.lang.Object r8 = r14.L$2
            kotlin.io.path.e r8 = (kotlin.io.path.e) r8
            java.lang.Object r9 = r14.L$1
            kotlin.collections.i r9 = (kotlin.collections.i) r9
            java.lang.Object r10 = r14.L$0
            kotlin.sequences.g r10 = (kotlin.sequences.g) r10
            kotlin.p.b(r15)
            goto L_0x00de
        L_0x0070:
            kotlin.p.b(r15)
            java.lang.Object r15 = r14.L$0
            r8 = r15
            kotlin.sequences.g r8 = (kotlin.sequences.g) r8
            kotlin.collections.i r15 = new kotlin.collections.i
            r15.<init>()
            kotlin.io.path.e r1 = new kotlin.io.path.e
            boolean r9 = kotlin.io.path.n.b(r7)
            r1.<init>(r9)
            kotlin.io.path.i r9 = new kotlin.io.path.i
            java.nio.file.Path r10 = kotlin.io.path.n.e(r7)
            java.nio.file.Path r11 = kotlin.io.path.n.e(r7)
            java.nio.file.LinkOption[] r12 = kotlin.io.path.n.d(r7)
            java.lang.Object r11 = kotlin.io.path.p.d(r11, r12)
            r9.<init>(r10, r11, r7)
            java.nio.file.Path r10 = r9.d()
            java.nio.file.LinkOption[] r11 = kotlin.io.path.n.d(r7)
            int r12 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r12)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            int r12 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r12)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.isDirectory(r10, r11)
            if (r11 == 0) goto L_0x0118
            boolean r5 = kotlin.io.path.p.c(r9)
            if (r5 != 0) goto L_0x010c
            boolean r5 = kotlin.io.path.n.c(r7)
            if (r5 == 0) goto L_0x00e4
            r14.L$0 = r8
            r14.L$1 = r15
            r14.L$2 = r1
            r14.L$3 = r9
            r14.L$4 = r7
            r14.L$5 = r10
            r14.label = r6
            java.lang.Object r5 = r8.c(r10, r14)
            if (r5 != r0) goto L_0x00d8
            return r0
        L_0x00d8:
            r5 = r9
            r9 = r15
            r13 = r8
            r8 = r1
            r1 = r10
            r10 = r13
        L_0x00de:
            r15 = r9
            r9 = r5
            r13 = r10
            r10 = r1
            r1 = r8
            r8 = r13
        L_0x00e4:
            java.nio.file.LinkOption[] r5 = kotlin.io.path.n.d(r7)
            int r11 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r11)
            java.nio.file.LinkOption[] r5 = (java.nio.file.LinkOption[]) r5
            int r11 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r11)
            java.nio.file.LinkOption[] r5 = (java.nio.file.LinkOption[]) r5
            boolean r5 = java.nio.file.Files.isDirectory(r10, r5)
            if (r5 == 0) goto L_0x010a
            java.util.List r5 = r1.b(r9)
            java.util.Iterator r5 = r5.iterator()
            r9.e(r5)
            r15.addLast(r9)
        L_0x010a:
            r5 = r15
            goto L_0x013b
        L_0x010c:
            kotlin.io.path.m.a()
            java.lang.String r15 = r10.toString()
            java.nio.file.FileSystemLoopException r15 = kotlin.io.path.l.a(r15)
            throw r15
        L_0x0118:
            java.nio.file.LinkOption[] r9 = new java.nio.file.LinkOption[r6]
            java.nio.file.LinkOption r11 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r9[r2] = r11
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r6)
            java.nio.file.LinkOption[] r9 = (java.nio.file.LinkOption[]) r9
            boolean r9 = java.nio.file.Files.exists(r10, r9)
            if (r9 == 0) goto L_0x010a
            r14.L$0 = r8
            r14.L$1 = r15
            r14.L$2 = r1
            r14.label = r5
            java.lang.Object r5 = r8.c(r10, r14)
            if (r5 != r0) goto L_0x010a
            return r0
        L_0x013b:
            boolean r15 = r5.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x0204
            java.lang.Object r15 = r5.last()
            kotlin.io.path.i r15 = (kotlin.io.path.i) r15
            java.util.Iterator r15 = r15.a()
            kotlin.jvm.internal.m.c(r15)
            boolean r9 = r15.hasNext()
            if (r9 == 0) goto L_0x01ff
            java.lang.Object r15 = r15.next()
            kotlin.io.path.i r15 = (kotlin.io.path.i) r15
            java.nio.file.Path r9 = r15.d()
            java.nio.file.LinkOption[] r10 = kotlin.io.path.n.d(r7)
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r9, r10)
            if (r10 == 0) goto L_0x01d6
            boolean r10 = kotlin.io.path.p.c(r15)
            if (r10 != 0) goto L_0x01ca
            boolean r10 = kotlin.io.path.n.c(r7)
            if (r10 == 0) goto L_0x01a2
            r14.L$0 = r8
            r14.L$1 = r5
            r14.L$2 = r1
            r14.L$3 = r15
            r14.L$4 = r7
            r14.L$5 = r9
            r14.label = r4
            java.lang.Object r10 = r8.c(r9, r14)
            if (r10 != r0) goto L_0x0198
            return r0
        L_0x0198:
            r10 = r8
            r8 = r1
            r1 = r9
            r9 = r5
            r5 = r15
        L_0x019d:
            r15 = r5
            r5 = r9
            r9 = r1
            r1 = r8
            r8 = r10
        L_0x01a2:
            java.nio.file.LinkOption[] r10 = kotlin.io.path.n.d(r7)
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r9 = java.nio.file.Files.isDirectory(r9, r10)
            if (r9 == 0) goto L_0x013b
            java.util.List r9 = r1.b(r15)
            java.util.Iterator r9 = r9.iterator()
            r15.e(r9)
            r5.addLast(r15)
            goto L_0x013b
        L_0x01ca:
            kotlin.io.path.m.a()
            java.lang.String r15 = r9.toString()
            java.nio.file.FileSystemLoopException r15 = kotlin.io.path.l.a(r15)
            throw r15
        L_0x01d6:
            java.nio.file.LinkOption[] r15 = new java.nio.file.LinkOption[r6]
            java.nio.file.LinkOption r10 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r15[r2] = r10
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r6)
            java.nio.file.LinkOption[] r15 = (java.nio.file.LinkOption[]) r15
            boolean r15 = java.nio.file.Files.exists(r9, r15)
            if (r15 == 0) goto L_0x013b
            r14.L$0 = r8
            r14.L$1 = r5
            r14.L$2 = r1
            r14.L$3 = r7
            r14.L$4 = r7
            r14.L$5 = r7
            r14.label = r3
            java.lang.Object r15 = r8.c(r9, r14)
            if (r15 != r0) goto L_0x013b
            return r0
        L_0x01ff:
            r5.removeLast()
            goto L_0x013b
        L_0x0204:
            kotlin.Unit r15 = kotlin.Unit.f12577a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: s */
    public final Object invoke(g gVar, d dVar) {
        return ((PathTreeWalk$dfsIterator$1) k(gVar, dVar)).n(Unit.f12577a);
    }
}
