package com.swmansion.gesturehandler.react;

import ab.d;
import ab.h;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray f11409a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f11410b = new SparseArray();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f11411c = new SparseArray();

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void d(ab.d r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray r0 = r3.f11410b     // Catch:{ all -> 0x003b }
            int r1 = r4.R()     // Catch:{ all -> 0x003b }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x003b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0040
            android.util.SparseArray r1 = r3.f11410b     // Catch:{ all -> 0x003b }
            int r2 = r4.R()     // Catch:{ all -> 0x003b }
            r1.remove(r2)     // Catch:{ all -> 0x003b }
            android.util.SparseArray r1 = r3.f11411c     // Catch:{ all -> 0x003b }
            int r2 = r0.intValue()     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x003b }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0040
            monitor-enter(r1)     // Catch:{ all -> 0x003b }
            r1.remove(r4)     // Catch:{ all -> 0x003d }
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            int r1 = r1.size()     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0040
            android.util.SparseArray r1 = r3.f11411c     // Catch:{ all -> 0x003b }
            int r0 = r0.intValue()     // Catch:{ all -> 0x003b }
            r1.remove(r0)     // Catch:{ all -> 0x003b }
            goto L_0x0040
        L_0x003b:
            r4 = move-exception
            goto L_0x0050
        L_0x003d:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            throw r4     // Catch:{ all -> 0x003b }
        L_0x0040:
            android.view.View r0 = r4.U()     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x004e
            com.swmansion.gesturehandler.react.f r0 = new com.swmansion.gesturehandler.react.f     // Catch:{ all -> 0x003b }
            r0.<init>(r4)     // Catch:{ all -> 0x003b }
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)     // Catch:{ all -> 0x003b }
        L_0x004e:
            monitor-exit(r3)
            return
        L_0x0050:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.g.d(ab.d):void");
    }

    /* access modifiers changed from: private */
    public static final void e(d dVar) {
        m.f(dVar, "$handler");
        dVar.o();
    }

    private final synchronized void k(int i10, d dVar) {
        try {
            if (this.f11410b.get(dVar.R()) == null) {
                this.f11410b.put(dVar.R(), Integer.valueOf(i10));
                Object obj = this.f11411c.get(i10);
                if (obj == null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(dVar);
                    this.f11411c.put(i10, arrayList);
                } else {
                    synchronized (obj) {
                        ((ArrayList) obj).add(dVar);
                    }
                }
            } else {
                throw new IllegalStateException(("Handler " + dVar + " already attached").toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ArrayList a(View view) {
        m.f(view, "view");
        return i(view.getId());
    }

    public final synchronized boolean c(int i10, int i11, int i12) {
        boolean z10;
        d dVar = (d) this.f11409a.get(i10);
        if (dVar != null) {
            d(dVar);
            dVar.r0(i12);
            k(i11, dVar);
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public final synchronized void f() {
        this.f11409a.clear();
        this.f11410b.clear();
        this.f11411c.clear();
    }

    public final synchronized void g(int i10) {
        d dVar = (d) this.f11409a.get(i10);
        if (dVar != null) {
            d(dVar);
            this.f11409a.remove(i10);
        }
    }

    public final synchronized d h(int i10) {
        return (d) this.f11409a.get(i10);
    }

    public final synchronized ArrayList i(int i10) {
        return (ArrayList) this.f11411c.get(i10);
    }

    public final synchronized void j(d dVar) {
        m.f(dVar, "handler");
        this.f11409a.put(dVar.R(), dVar);
    }
}
