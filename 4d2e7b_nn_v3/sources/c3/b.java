package c3;

import c3.a;
import y2.l;

public class b extends a {
    private b(i iVar, a.c cVar, Throwable th) {
        super(iVar, cVar, th);
    }

    /* renamed from: b */
    public a clone() {
        Throwable th;
        l.i(w());
        i iVar = this.f17285b;
        a.c cVar = this.f17286c;
        if (this.f17287d != null) {
            th = new Throwable();
        } else {
            th = null;
        }
        return new b(iVar, cVar, th);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r7.f17285b.f();
        r3 = java.lang.Integer.valueOf(java.lang.System.identityHashCode(r7));
        r4 = java.lang.Integer.valueOf(java.lang.System.identityHashCode(r7.f17285b));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r0 = r0.getClass().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        z2.a.I("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", r3, r4, r0);
        r0 = r7.f17286c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r0 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        r0.b(r7.f17285b, r7.f17287d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        super.finalize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finalize() {
        /*
            r7 = this;
            monitor-enter(r7)     // Catch:{ all -> 0x0050 }
            boolean r0 = r7.f17284a     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r7)     // Catch:{ all -> 0x000a }
            super.finalize()
            return
        L_0x000a:
            r0 = move-exception
            goto L_0x0059
        L_0x000c:
            monitor-exit(r7)     // Catch:{ all -> 0x000a }
            c3.i r0 = r7.f17285b     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.f()     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = "DefaultCloseableReference"
            java.lang.String r2 = "Finalized without closing: %x %x (type = %s)"
            int r3 = java.lang.System.identityHashCode(r7)     // Catch:{ all -> 0x0050 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0050 }
            c3.i r4 = r7.f17285b     // Catch:{ all -> 0x0050 }
            int r4 = java.lang.System.identityHashCode(r4)     // Catch:{ all -> 0x0050 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x002d
            r0 = 0
            goto L_0x0035
        L_0x002d:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0050 }
        L_0x0035:
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0050 }
            r6 = 0
            r5[r6] = r3     // Catch:{ all -> 0x0050 }
            r3 = 1
            r5[r3] = r4     // Catch:{ all -> 0x0050 }
            r3 = 2
            r5[r3] = r0     // Catch:{ all -> 0x0050 }
            z2.a.I(r1, r2, r5)     // Catch:{ all -> 0x0050 }
            c3.a$c r0 = r7.f17286c     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x0052
            c3.i r1 = r7.f17285b     // Catch:{ all -> 0x0050 }
            java.lang.Throwable r2 = r7.f17287d     // Catch:{ all -> 0x0050 }
            r0.b(r1, r2)     // Catch:{ all -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            r0 = move-exception
            goto L_0x005b
        L_0x0052:
            r7.close()     // Catch:{ all -> 0x0050 }
            super.finalize()
            return
        L_0x0059:
            monitor-exit(r7)     // Catch:{ all -> 0x000a }
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x005b:
            super.finalize()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.b.finalize():void");
    }

    b(Object obj, h hVar, a.c cVar, Throwable th) {
        super(obj, hVar, cVar, th, true);
    }
}
