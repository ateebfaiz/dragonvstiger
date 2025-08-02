package a1;

import android.os.Handler;
import android.os.Looper;
import c.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f13640a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f13641b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityBlockingQueue f13642c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityBlockingQueue f13643d;

    /* renamed from: e  reason: collision with root package name */
    private final b f13644e;

    /* renamed from: f  reason: collision with root package name */
    private final h f13645f;

    /* renamed from: g  reason: collision with root package name */
    private final q f13646g;

    /* renamed from: h  reason: collision with root package name */
    private final i[] f13647h;

    /* renamed from: i  reason: collision with root package name */
    private c f13648i;

    /* renamed from: j  reason: collision with root package name */
    private final List f13649j;

    public o(b bVar, h hVar, int i10, q qVar) {
        this.f13640a = new AtomicInteger();
        this.f13641b = new HashSet();
        this.f13642c = new PriorityBlockingQueue();
        this.f13643d = new PriorityBlockingQueue();
        this.f13649j = new ArrayList();
        this.f13644e = bVar;
        this.f13645f = hVar;
        this.f13647h = new i[i10];
        this.f13646g = qVar;
    }

    public n a(n nVar) {
        nVar.C(this);
        synchronized (this.f13641b) {
            this.f13641b.add(nVar);
        }
        nVar.E(c());
        nVar.b("add-to-queue");
        if (!nVar.F()) {
            this.f13643d.add(nVar);
            return nVar;
        }
        this.f13642c.add(nVar);
        return nVar;
    }

    /* access modifiers changed from: package-private */
    public void b(n nVar) {
        synchronized (this.f13641b) {
            this.f13641b.remove(nVar);
        }
        synchronized (this.f13649j) {
            try {
                Iterator it = this.f13649j.iterator();
                if (it.hasNext()) {
                    d.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int c() {
        return this.f13640a.incrementAndGet();
    }

    public void d() {
        e();
        c cVar = new c(this.f13642c, this.f13643d, this.f13644e, this.f13646g);
        this.f13648i = cVar;
        cVar.start();
        for (int i10 = 0; i10 < this.f13647h.length; i10++) {
            i iVar = new i(this.f13643d, this.f13645f, this.f13644e, this.f13646g);
            this.f13647h[i10] = iVar;
            iVar.start();
        }
    }

    public void e() {
        c cVar = this.f13648i;
        if (cVar != null) {
            cVar.d();
        }
        for (i iVar : this.f13647h) {
            if (iVar != null) {
                iVar.d();
            }
        }
    }

    public o(b bVar, h hVar, int i10) {
        this(bVar, hVar, i10, new f(new Handler(Looper.getMainLooper())));
    }

    public o(b bVar, h hVar) {
        this(bVar, hVar, 4);
    }
}
