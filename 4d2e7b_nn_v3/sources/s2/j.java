package s2;

import d3.a;
import f3.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import r2.a;
import r2.c;
import r2.d;
import r2.e;
import s2.i;
import y2.l;

public class j implements n, v2.a {

    /* renamed from: r  reason: collision with root package name */
    private static final Class f23801r = j.class;

    /* renamed from: s  reason: collision with root package name */
    private static final long f23802s = TimeUnit.HOURS.toMillis(2);

    /* renamed from: t  reason: collision with root package name */
    private static final long f23803t = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final long f23804a;

    /* renamed from: b  reason: collision with root package name */
    private final long f23805b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CountDownLatch f23806c;

    /* renamed from: d  reason: collision with root package name */
    private long f23807d;

    /* renamed from: e  reason: collision with root package name */
    private final r2.c f23808e;

    /* renamed from: f  reason: collision with root package name */
    final Set f23809f;

    /* renamed from: g  reason: collision with root package name */
    private long f23810g;

    /* renamed from: h  reason: collision with root package name */
    private final long f23811h;

    /* renamed from: i  reason: collision with root package name */
    private final d3.a f23812i;

    /* renamed from: j  reason: collision with root package name */
    private final i f23813j;

    /* renamed from: k  reason: collision with root package name */
    private final m f23814k;

    /* renamed from: l  reason: collision with root package name */
    private final r2.a f23815l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f23816m;

    /* renamed from: n  reason: collision with root package name */
    private final b f23817n;

    /* renamed from: o  reason: collision with root package name */
    private final f3.a f23818o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Object f23819p = new Object();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f23820q;

    class a implements Runnable {
        a() {
        }

        public void run() {
            synchronized (j.this.f23819p) {
                boolean unused = j.this.p();
            }
            j.this.f23820q = true;
            j.this.f23806c.countDown();
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23822a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f23823b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f23824c = -1;

        b() {
        }

        public synchronized long a() {
            return this.f23824c;
        }

        public synchronized long b() {
            return this.f23823b;
        }

        public synchronized void c(long j10, long j11) {
            if (this.f23822a) {
                this.f23823b += j10;
                this.f23824c += j11;
            }
        }

        public synchronized boolean d() {
            return this.f23822a;
        }

        public synchronized void e() {
            this.f23822a = false;
            this.f23824c = -1;
            this.f23823b = -1;
        }

        public synchronized void f(long j10, long j11) {
            this.f23824c = j11;
            this.f23823b = j10;
            this.f23822a = true;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f23825a;

        /* renamed from: b  reason: collision with root package name */
        public final long f23826b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23827c;

        public c(long j10, long j11, long j12) {
            this.f23825a = j10;
            this.f23826b = j11;
            this.f23827c = j12;
        }
    }

    public j(i iVar, m mVar, c cVar, r2.c cVar2, r2.a aVar, v2.b bVar, Executor executor, boolean z10) {
        this.f23804a = cVar.f23826b;
        long j10 = cVar.f23827c;
        this.f23805b = j10;
        this.f23807d = j10;
        this.f23812i = d3.a.d();
        this.f23813j = iVar;
        this.f23814k = mVar;
        this.f23810g = -1;
        this.f23808e = cVar2;
        this.f23811h = cVar.f23825a;
        this.f23815l = aVar;
        this.f23817n = new b();
        this.f23818o = f.a();
        this.f23816m = z10;
        this.f23809f = new HashSet();
        if (bVar != null) {
            bVar.a(this);
        }
        if (z10) {
            this.f23806c = new CountDownLatch(1);
            executor.execute(new a());
            return;
        }
        this.f23806c = new CountDownLatch(0);
    }

    private q2.a l(i.b bVar, d dVar, String str) {
        q2.a b10;
        synchronized (this.f23819p) {
            b10 = bVar.b(dVar);
            this.f23809f.add(str);
            this.f23817n.c(b10.size(), 1);
        }
        return b10;
    }

    private void m(long j10, c.a aVar) {
        long j11 = j10;
        try {
            Collection<i.a> n10 = n(this.f23813j.h());
            long b10 = this.f23817n.b();
            long j12 = b10 - j11;
            int i10 = 0;
            long j13 = 0;
            for (i.a aVar2 : n10) {
                if (j13 > j12) {
                    break;
                }
                long b11 = this.f23813j.b(aVar2);
                this.f23809f.remove(aVar2.getId());
                if (b11 > 0) {
                    i10++;
                    j13 += b11;
                    o e10 = o.a().j(aVar2.getId()).g(aVar).i(b11).f(b10 - j13).e(j11);
                    this.f23808e.c(e10);
                    e10.b();
                } else {
                    c.a aVar3 = aVar;
                }
            }
            this.f23817n.c(-j13, (long) (-i10));
            this.f23813j.c();
        } catch (IOException e11) {
            r2.a aVar4 = this.f23815l;
            a.C0326a aVar5 = a.C0326a.EVICTION;
            Class cls = f23801r;
            aVar4.a(aVar5, cls, "evictAboveSize: " + e11.getMessage(), e11);
            throw e11;
        }
    }

    private Collection n(Collection collection) {
        long now = this.f23818o.now() + f23802s;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i.a aVar = (i.a) it.next();
            if (aVar.a() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.f23814k.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void o() {
        synchronized (this.f23819p) {
            try {
                boolean p10 = p();
                s();
                long b10 = this.f23817n.b();
                if (b10 > this.f23807d && !p10) {
                    this.f23817n.e();
                    p();
                }
                long j10 = this.f23807d;
                if (b10 > j10) {
                    m((j10 * 9) / 10, c.a.CACHE_FULL);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean p() {
        long now = this.f23818o.now();
        if (this.f23817n.d()) {
            long j10 = this.f23810g;
            if (j10 != -1 && now - j10 <= f23803t) {
                return false;
            }
        }
        return q();
    }

    private boolean q() {
        Set set;
        long j10;
        long now = this.f23818o.now();
        long j11 = f23802s + now;
        if (this.f23816m && this.f23809f.isEmpty()) {
            set = this.f23809f;
        } else if (this.f23816m) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j12 = 0;
            long j13 = -1;
            int i10 = 0;
            boolean z10 = false;
            int i11 = 0;
            int i12 = 0;
            for (i.a aVar : this.f23813j.h()) {
                i11++;
                j12 += aVar.getSize();
                if (aVar.a() > j11) {
                    i12++;
                    i10 = (int) (((long) i10) + aVar.getSize());
                    j10 = j11;
                    j13 = Math.max(aVar.a() - now, j13);
                    z10 = true;
                } else {
                    j10 = j11;
                    if (this.f23816m) {
                        l.g(set);
                        set.add(aVar.getId());
                    }
                }
                j11 = j10;
            }
            if (z10) {
                this.f23815l.a(a.C0326a.READ_INVALID_ENTRY, f23801r, "Future timestamp found in " + i12 + " files , with a total size of " + i10 + " bytes, and a maximum time delta of " + j13 + "ms", (Throwable) null);
            }
            long j14 = (long) i11;
            if (!(this.f23817n.a() == j14 && this.f23817n.b() == j12)) {
                if (this.f23816m && this.f23809f != set) {
                    l.g(set);
                    this.f23809f.clear();
                    this.f23809f.addAll(set);
                }
                this.f23817n.f(j12, j14);
            }
            this.f23810g = now;
            return true;
        } catch (IOException e10) {
            this.f23815l.a(a.C0326a.GENERIC_IO, f23801r, "calcFileCacheSize: " + e10.getMessage(), e10);
            return false;
        }
    }

    private i.b r(String str, d dVar) {
        o();
        return this.f23813j.d(str, dVar);
    }

    private void s() {
        a.C0260a aVar;
        if (this.f23813j.isExternal()) {
            aVar = a.C0260a.EXTERNAL;
        } else {
            aVar = a.C0260a.INTERNAL;
        }
        if (this.f23812i.f(aVar, this.f23805b - this.f23817n.b())) {
            this.f23807d = this.f23804a;
        } else {
            this.f23807d = this.f23805b;
        }
    }

    public void a() {
        synchronized (this.f23819p) {
            try {
                this.f23813j.a();
                this.f23809f.clear();
                this.f23808e.d();
            } catch (IOException | NullPointerException e10) {
                r2.a aVar = this.f23815l;
                a.C0326a aVar2 = a.C0326a.EVICTION;
                Class cls = f23801r;
                aVar.a(aVar2, cls, "clearAll: " + e10.getMessage(), e10);
            }
            this.f23817n.e();
        }
    }

    public boolean b(d dVar) {
        synchronized (this.f23819p) {
            try {
                List b10 = e.b(dVar);
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    if (this.f23809f.contains((String) b10.get(i10))) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(d dVar) {
        synchronized (this.f23819p) {
            try {
                List b10 = e.b(dVar);
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    String str = (String) b10.get(i10);
                    this.f23813j.remove(str);
                    this.f23809f.remove(str);
                }
            } catch (IOException e10) {
                r2.a aVar = this.f23815l;
                a.C0326a aVar2 = a.C0326a.DELETE_FILE;
                Class cls = f23801r;
                aVar.a(aVar2, cls, "delete: " + e10.getMessage(), e10);
            }
        }
    }

    public q2.a d(d dVar, r2.j jVar) {
        String a10;
        i.b r10;
        o d10 = o.a().d(dVar);
        this.f23808e.a(d10);
        synchronized (this.f23819p) {
            a10 = e.a(dVar);
        }
        d10.j(a10);
        try {
            r10 = r(a10, dVar);
            r10.a(jVar, dVar);
            q2.a l10 = l(r10, dVar, a10);
            d10.i(l10.size()).f(this.f23817n.b());
            this.f23808e.f(d10);
            if (!r10.cleanUp()) {
                z2.a.f(f23801r, "Failed to delete temp file");
            }
            d10.b();
            return l10;
        } catch (IOException e10) {
            d10.h(e10);
            this.f23808e.e(d10);
            z2.a.g(f23801r, "Failed inserting a file into the cache", e10);
            throw e10;
        } catch (Throwable th) {
            d10.b();
            throw th;
        }
    }

    public boolean e(d dVar) {
        synchronized (this.f23819p) {
            if (b(dVar)) {
                return true;
            }
            try {
                List b10 = e.b(dVar);
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    String str = (String) b10.get(i10);
                    if (this.f23813j.f(str, dVar)) {
                        this.f23809f.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public q2.a f(d dVar) {
        q2.a aVar;
        o d10 = o.a().d(dVar);
        try {
            synchronized (this.f23819p) {
                List b10 = e.b(dVar);
                int i10 = 0;
                String str = null;
                aVar = null;
                while (true) {
                    if (i10 >= b10.size()) {
                        break;
                    }
                    str = (String) b10.get(i10);
                    d10.j(str);
                    aVar = this.f23813j.g(str, dVar);
                    if (aVar != null) {
                        break;
                    }
                    i10++;
                }
                if (aVar == null) {
                    this.f23808e.b(d10);
                    this.f23809f.remove(str);
                } else {
                    l.g(str);
                    this.f23808e.h(d10);
                    this.f23809f.add(str);
                }
            }
            d10.b();
            return aVar;
        } catch (IOException e10) {
            try {
                this.f23815l.a(a.C0326a.GENERIC_IO, f23801r, "getResource", e10);
                d10.h(e10);
                this.f23808e.g(d10);
                return null;
            } finally {
                d10.b();
            }
        } catch (Throwable th) {
            while (true) {
            }
            throw th;
        }
    }

    public boolean g(d dVar) {
        String str;
        IOException e10;
        Throwable th;
        String str2 = null;
        try {
            synchronized (this.f23819p) {
                try {
                    List b10 = e.b(dVar);
                    int i10 = 0;
                    while (i10 < b10.size()) {
                        String str3 = (String) b10.get(i10);
                        try {
                            if (this.f23813j.e(str3, dVar)) {
                                this.f23809f.add(str3);
                                return true;
                            }
                            i10++;
                            str2 = str3;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (IOException e11) {
                                e10 = e11;
                            }
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    str = str2;
                    th = th3;
                    throw th;
                }
            }
        } catch (IOException e12) {
            str = null;
            e10 = e12;
            o h10 = o.a().d(dVar).j(str).h(e10);
            this.f23808e.g(h10);
            h10.b();
            return false;
        }
    }
}
