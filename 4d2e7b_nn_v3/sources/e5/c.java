package e5;

import r4.e;

public class c extends h {

    /* renamed from: d  reason: collision with root package name */
    private e f21269d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21270e;

    public c(e eVar, boolean z10) {
        this.f21269d = eVar;
        this.f21270e = z10;
    }

    public synchronized r4.c C() {
        r4.c cVar;
        e eVar = this.f21269d;
        if (eVar == null) {
            cVar = null;
        } else {
            cVar = eVar.d();
        }
        return cVar;
    }

    public boolean D() {
        return this.f21270e;
    }

    public synchronized e E() {
        return this.f21269d;
    }

    public void close() {
        synchronized (this) {
            try {
                e eVar = this.f21269d;
                if (eVar != null) {
                    this.f21269d = null;
                    eVar.a();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public synchronized int g() {
        int i10;
        e eVar = this.f21269d;
        if (eVar == null) {
            i10 = 0;
        } else {
            i10 = eVar.d().g();
        }
        return i10;
    }

    public synchronized int getHeight() {
        int i10;
        e eVar = this.f21269d;
        if (eVar == null) {
            i10 = 0;
        } else {
            i10 = eVar.d().getHeight();
        }
        return i10;
    }

    public synchronized int getWidth() {
        int i10;
        e eVar = this.f21269d;
        if (eVar == null) {
            i10 = 0;
        } else {
            i10 = eVar.d().getWidth();
        }
        return i10;
    }

    public synchronized boolean isClosed() {
        boolean z10;
        if (this.f21269d == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }
}
