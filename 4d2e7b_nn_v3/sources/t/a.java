package t;

import d.k;
import j.b;
import j.c;
import java.util.concurrent.atomic.AtomicReference;
import w.d;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f23914d = d.f("");

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReference f23915e = new AtomicReference((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final k f23916a;

    /* renamed from: b  reason: collision with root package name */
    public final b f23917b;

    /* renamed from: c  reason: collision with root package name */
    public b f23918c;

    /* renamed from: t.a$a  reason: collision with other inner class name */
    public static class C0334a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final long f23919a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f23920b;

        /* renamed from: c  reason: collision with root package name */
        public final k f23921c;

        public C0334a(k kVar, long j10, String[] strArr) {
            this.f23921c = kVar;
            this.f23919a = j10;
            this.f23920b = strArr;
        }

        public long a() {
            return 0;
        }

        public long b() {
            return this.f23919a;
        }

        public void c() {
            this.f23921c.d(this.f23920b);
        }
    }

    public a(k kVar, d.c cVar) {
        this.f23916a = kVar;
        this.f23917b = new b(kVar, cVar);
    }

    public static a a(k kVar, d.c cVar) {
        AtomicReference atomicReference = f23915e;
        d.a.a(atomicReference, (Object) null, new a(kVar, cVar));
        return (a) atomicReference.get();
    }

    public static void c(String str) {
        if (d()) {
            ((a) f23915e.get()).f23917b.b(str);
        }
    }

    public static boolean d() {
        if (f23915e.get() != null) {
            return true;
        }
        return false;
    }

    public void b(h.d dVar) {
        String[] a10;
        if (dVar != null && (a10 = dVar.a()) != null) {
            this.f23918c = j.a.a().b(new C0334a(this.f23916a, ((long) dVar.b()) * 60000, a10));
        }
    }

    public void e() {
        b bVar = this.f23918c;
        if (bVar != null) {
            bVar.a();
            this.f23918c = null;
        }
    }
}
