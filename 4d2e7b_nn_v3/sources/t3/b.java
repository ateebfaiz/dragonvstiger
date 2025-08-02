package t3;

import android.content.Context;
import android.graphics.drawable.Animatable;
import i3.g;
import i3.h;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import y2.j;
import y2.l;
import y2.o;
import z3.d;

public abstract class b implements d {

    /* renamed from: q  reason: collision with root package name */
    private static final d f24098q = new a();

    /* renamed from: r  reason: collision with root package name */
    private static final NullPointerException f24099r = new NullPointerException("No image request was specified!");

    /* renamed from: s  reason: collision with root package name */
    private static final AtomicLong f24100s = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    private final Context f24101a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f24102b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f24103c;

    /* renamed from: d  reason: collision with root package name */
    private Object f24104d;

    /* renamed from: e  reason: collision with root package name */
    private Object f24105e;

    /* renamed from: f  reason: collision with root package name */
    private Object f24106f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f24107g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24108h;

    /* renamed from: i  reason: collision with root package name */
    private o f24109i;

    /* renamed from: j  reason: collision with root package name */
    private d f24110j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24111k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24112l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24113m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24114n = false;

    /* renamed from: o  reason: collision with root package name */
    private String f24115o;

    /* renamed from: p  reason: collision with root package name */
    private z3.a f24116p;

    class a extends c {
        a() {
        }

        public void f(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* renamed from: t3.b$b  reason: collision with other inner class name */
    class C0337b implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z3.a f24117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24118b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f24119c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f24120d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f24121e;

        C0337b(z3.a aVar, String str, Object obj, Object obj2, c cVar) {
            this.f24117a = aVar;
            this.f24118b = str;
            this.f24119c = obj;
            this.f24120d = obj2;
            this.f24121e = cVar;
        }

        /* renamed from: a */
        public i3.c get() {
            return b.this.i(this.f24117a, this.f24118b, this.f24119c, this.f24120d, this.f24121e);
        }

        public String toString() {
            return j.c(this).b("request", this.f24119c.toString()).toString();
        }
    }

    public enum c {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected b(Context context, Set set, Set set2) {
        this.f24101a = context;
        this.f24102b = set;
        this.f24103c = set2;
        s();
    }

    protected static String e() {
        return String.valueOf(f24100s.getAndIncrement());
    }

    private void s() {
        this.f24104d = null;
        this.f24105e = null;
        this.f24106f = null;
        this.f24107g = null;
        this.f24108h = true;
        this.f24110j = null;
        this.f24111k = false;
        this.f24112l = false;
        this.f24114n = false;
        this.f24116p = null;
        this.f24115o = null;
    }

    public b A(boolean z10) {
        this.f24112l = z10;
        return r();
    }

    public b B(Object obj) {
        this.f24104d = obj;
        return r();
    }

    public b C(d dVar) {
        this.f24110j = dVar;
        return r();
    }

    public b D(Object obj) {
        this.f24105e = obj;
        return r();
    }

    public b E(Object obj) {
        this.f24106f = obj;
        return r();
    }

    /* renamed from: F */
    public b a(z3.a aVar) {
        this.f24116p = aVar;
        return r();
    }

    /* access modifiers changed from: protected */
    public void G() {
        boolean z10;
        boolean z11 = true;
        if (this.f24107g == null || this.f24105e == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.j(z10, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (!(this.f24109i == null || (this.f24107g == null && this.f24105e == null && this.f24106f == null))) {
            z11 = false;
        }
        l.j(z11, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    /* renamed from: c */
    public a build() {
        Object obj;
        G();
        if (this.f24105e == null && this.f24107g == null && (obj = this.f24106f) != null) {
            this.f24105e = obj;
            this.f24106f = null;
        }
        return d();
    }

    /* access modifiers changed from: protected */
    public a d() {
        if (l5.b.d()) {
            l5.b.a("AbstractDraweeControllerBuilder#buildController");
        }
        a x10 = x();
        x10.c0(t());
        x10.d0(q());
        x10.Y(g());
        h();
        x10.a0((e) null);
        w(x10);
        u(x10);
        if (l5.b.d()) {
            l5.b.b();
        }
        return x10;
    }

    public Object f() {
        return this.f24104d;
    }

    public String g() {
        return this.f24115o;
    }

    public e h() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract i3.c i(z3.a aVar, String str, Object obj, Object obj2, c cVar);

    /* access modifiers changed from: protected */
    public o j(z3.a aVar, String str, Object obj) {
        return k(aVar, str, obj, c.FULL_FETCH);
    }

    /* access modifiers changed from: protected */
    public o k(z3.a aVar, String str, Object obj, c cVar) {
        return new C0337b(aVar, str, obj, f(), cVar);
    }

    /* access modifiers changed from: protected */
    public o l(z3.a aVar, String str, Object[] objArr, boolean z10) {
        ArrayList arrayList = new ArrayList(objArr.length * 2);
        if (z10) {
            for (Object k10 : objArr) {
                arrayList.add(k(aVar, str, k10, c.BITMAP_MEMORY_CACHE));
            }
        }
        for (Object j10 : objArr) {
            arrayList.add(j(aVar, str, j10));
        }
        return g.b(arrayList);
    }

    public Object[] m() {
        return this.f24107g;
    }

    public Object n() {
        return this.f24105e;
    }

    public Object o() {
        return this.f24106f;
    }

    public z3.a p() {
        return this.f24116p;
    }

    public boolean q() {
        return this.f24113m;
    }

    /* access modifiers changed from: protected */
    public final b r() {
        return this;
    }

    public boolean t() {
        return this.f24114n;
    }

    /* access modifiers changed from: protected */
    public void u(a aVar) {
        Set<d> set = this.f24102b;
        if (set != null) {
            for (d i10 : set) {
                aVar.i(i10);
            }
        }
        Set<m4.b> set2 = this.f24103c;
        if (set2 != null) {
            for (m4.b j10 : set2) {
                aVar.j(j10);
            }
        }
        d dVar = this.f24110j;
        if (dVar != null) {
            aVar.i(dVar);
        }
        if (this.f24112l) {
            aVar.i(f24098q);
        }
    }

    /* access modifiers changed from: protected */
    public void v(a aVar) {
        if (aVar.t() == null) {
            aVar.b0(y3.a.c(this.f24101a));
        }
    }

    /* access modifiers changed from: protected */
    public void w(a aVar) {
        if (this.f24111k) {
            aVar.z().d(this.f24111k);
            v(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public abstract a x();

    /* access modifiers changed from: protected */
    public o y(z3.a aVar, String str) {
        o oVar;
        o oVar2 = this.f24109i;
        if (oVar2 != null) {
            return oVar2;
        }
        Object obj = this.f24105e;
        if (obj != null) {
            oVar = j(aVar, str, obj);
        } else {
            Object[] objArr = this.f24107g;
            if (objArr != null) {
                oVar = l(aVar, str, objArr, this.f24108h);
            } else {
                oVar = null;
            }
        }
        if (!(oVar == null || this.f24106f == null)) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(oVar);
            arrayList.add(j(aVar, str, this.f24106f));
            oVar = h.c(arrayList, false);
        }
        if (oVar == null) {
            return i3.d.a(f24099r);
        }
        return oVar;
    }

    public b z() {
        s();
        return r();
    }
}
