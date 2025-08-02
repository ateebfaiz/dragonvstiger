package x4;

import e5.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import r2.d;
import y2.l;
import z2.a;

public class c0 {

    /* renamed from: b  reason: collision with root package name */
    private static final Class f24769b = c0.class;

    /* renamed from: a  reason: collision with root package name */
    private Map f24770a = new HashMap();

    private c0() {
    }

    public static c0 d() {
        return new c0();
    }

    private synchronized void e() {
        a.w(f24769b, "Count = %d", Integer.valueOf(this.f24770a.size()));
    }

    public void a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f24770a.values());
            this.f24770a.clear();
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            j jVar = (j) arrayList.get(i10);
            if (jVar != null) {
                jVar.close();
            }
        }
    }

    public synchronized boolean b(d dVar) {
        l.g(dVar);
        if (!this.f24770a.containsKey(dVar)) {
            return false;
        }
        j jVar = (j) this.f24770a.get(dVar);
        synchronized (jVar) {
            if (j.J(jVar)) {
                return true;
            }
            this.f24770a.remove(dVar);
            a.E(f24769b, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(jVar)), dVar.c(), Integer.valueOf(System.identityHashCode(dVar)));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized e5.j c(r2.d r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            y2.l.g(r8)     // Catch:{ all -> 0x0050 }
            java.util.Map r0 = r7.f24770a     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0050 }
            e5.j r0 = (e5.j) r0     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x0052
            monitor-enter(r0)     // Catch:{ all -> 0x0050 }
            boolean r1 = e5.j.J(r0)     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0047
            java.util.Map r1 = r7.f24770a     // Catch:{ all -> 0x0045 }
            r1.remove(r8)     // Catch:{ all -> 0x0045 }
            java.lang.Class r1 = f24769b     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "Found closed reference %d for key %s (%d)"
            int r3 = java.lang.System.identityHashCode(r0)     // Catch:{ all -> 0x0045 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r8.c()     // Catch:{ all -> 0x0045 }
            int r8 = java.lang.System.identityHashCode(r8)     // Catch:{ all -> 0x0045 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0045 }
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0045 }
            r6 = 0
            r5[r6] = r3     // Catch:{ all -> 0x0045 }
            r3 = 1
            r5[r3] = r4     // Catch:{ all -> 0x0045 }
            r3 = 2
            r5[r3] = r8     // Catch:{ all -> 0x0045 }
            z2.a.E(r1, r2, r5)     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            monitor-exit(r7)
            r8 = 0
            return r8
        L_0x0045:
            r8 = move-exception
            goto L_0x004e
        L_0x0047:
            e5.j r8 = e5.j.b(r0)     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r0 = r8
            goto L_0x0052
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r8     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r8 = move-exception
            goto L_0x0054
        L_0x0052:
            monitor-exit(r7)
            return r0
        L_0x0054:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.c0.c(r2.d):e5.j");
    }

    public synchronized void f(d dVar, j jVar) {
        l.g(dVar);
        l.b(Boolean.valueOf(j.J(jVar)));
        j.h((j) this.f24770a.put(dVar, j.b(jVar)));
        e();
    }

    public boolean g(d dVar) {
        j jVar;
        l.g(dVar);
        synchronized (this) {
            jVar = (j) this.f24770a.remove(dVar);
        }
        if (jVar == null) {
            return false;
        }
        try {
            return jVar.I();
        } finally {
            jVar.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean h(d dVar, j jVar) {
        l.g(dVar);
        l.g(jVar);
        l.b(Boolean.valueOf(j.J(jVar)));
        j jVar2 = (j) this.f24770a.get(dVar);
        if (jVar2 == null) {
            return false;
        }
        c3.a k10 = jVar2.k();
        c3.a k11 = jVar.k();
        if (!(k10 == null || k11 == null)) {
            try {
                if (k10.p() == k11.p()) {
                    this.f24770a.remove(dVar);
                    c3.a.m(k11);
                    c3.a.m(k10);
                    j.h(jVar2);
                    e();
                    return true;
                }
            } catch (Throwable th) {
                c3.a.m(k11);
                c3.a.m(k10);
                j.h(jVar2);
                throw th;
            }
        }
        c3.a.m(k11);
        c3.a.m(k10);
        j.h(jVar2);
        return false;
    }
}
