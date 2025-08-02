package p3;

import android.content.Context;
import android.net.Uri;
import i3.c;
import java.util.Set;
import k5.b;
import m4.g;
import r2.d;
import t3.b;
import y2.f;
import y2.p;
import z4.k;

public class e extends b {

    /* renamed from: t  reason: collision with root package name */
    private final k f23116t;

    /* renamed from: u  reason: collision with root package name */
    private final g f23117u;

    /* renamed from: v  reason: collision with root package name */
    private f f23118v;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23119a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                t3.b$c[] r0 = t3.b.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23119a = r0
                t3.b$c r1 = t3.b.c.FULL_FETCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23119a     // Catch:{ NoSuchFieldError -> 0x001d }
                t3.b$c r1 = t3.b.c.DISK_CACHE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23119a     // Catch:{ NoSuchFieldError -> 0x0028 }
                t3.b$c r1 = t3.b.c.BITMAP_MEMORY_CACHE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p3.e.a.<clinit>():void");
        }
    }

    public e(Context context, g gVar, k kVar, Set set, Set set2) {
        super(context, set, set2);
        this.f23116t = kVar;
        this.f23117u = gVar;
    }

    public static b.c H(b.c cVar) {
        int i10 = a.f23119a[cVar.ordinal()];
        if (i10 == 1) {
            return b.c.FULL_FETCH;
        }
        if (i10 == 2) {
            return b.c.DISK_CACHE;
        }
        if (i10 == 3) {
            return b.c.BITMAP_MEMORY_CACHE;
        }
        throw new RuntimeException("Cache level" + cVar + "is not supported. ");
    }

    private d I() {
        k5.b bVar = (k5.b) n();
        x4.k n10 = this.f23116t.n();
        if (n10 == null || bVar == null) {
            return null;
        }
        if (bVar.k() != null) {
            return n10.b(bVar, f());
        }
        return n10.d(bVar, f());
    }

    /* access modifiers changed from: protected */
    /* renamed from: J */
    public c i(z3.a aVar, String str, k5.b bVar, Object obj, b.c cVar) {
        return this.f23116t.i(bVar, obj, H(cVar), K(aVar), str);
    }

    /* access modifiers changed from: protected */
    public g5.e K(z3.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).n0();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: L */
    public d x() {
        d dVar;
        if (l5.b.d()) {
            l5.b.a("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            z3.a p10 = p();
            String e10 = t3.b.e();
            if (p10 instanceof d) {
                dVar = (d) p10;
            } else {
                dVar = this.f23117u.c();
            }
            dVar.p0(y(dVar, e10), e10, I(), f(), this.f23118v);
            dVar.q0((g) null, this, p.f24881b);
            if (l5.b.d()) {
                l5.b.b();
            }
            return dVar;
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    public e M(g gVar) {
        return (e) r();
    }

    /* renamed from: N */
    public e b(Uri uri) {
        if (uri == null) {
            return (e) super.D((Object) null);
        }
        return (e) super.D(k5.c.w(uri).M(y4.g.e()).a());
    }
}
