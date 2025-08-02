package u0;

import com.airbnb.lottie.j;
import java.util.List;
import java.util.Locale;
import s0.k;
import s0.n;
import t0.h;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List f24204a;

    /* renamed from: b  reason: collision with root package name */
    private final j f24205b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24206c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24207d;

    /* renamed from: e  reason: collision with root package name */
    private final a f24208e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24209f;

    /* renamed from: g  reason: collision with root package name */
    private final String f24210g;

    /* renamed from: h  reason: collision with root package name */
    private final List f24211h;

    /* renamed from: i  reason: collision with root package name */
    private final n f24212i;

    /* renamed from: j  reason: collision with root package name */
    private final int f24213j;

    /* renamed from: k  reason: collision with root package name */
    private final int f24214k;

    /* renamed from: l  reason: collision with root package name */
    private final int f24215l;

    /* renamed from: m  reason: collision with root package name */
    private final float f24216m;

    /* renamed from: n  reason: collision with root package name */
    private final float f24217n;

    /* renamed from: o  reason: collision with root package name */
    private final float f24218o;

    /* renamed from: p  reason: collision with root package name */
    private final float f24219p;

    /* renamed from: q  reason: collision with root package name */
    private final s0.j f24220q;

    /* renamed from: r  reason: collision with root package name */
    private final k f24221r;

    /* renamed from: s  reason: collision with root package name */
    private final s0.b f24222s;

    /* renamed from: t  reason: collision with root package name */
    private final List f24223t;

    /* renamed from: u  reason: collision with root package name */
    private final b f24224u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f24225v;

    /* renamed from: w  reason: collision with root package name */
    private final t0.a f24226w;

    /* renamed from: x  reason: collision with root package name */
    private final w0.j f24227x;

    /* renamed from: y  reason: collision with root package name */
    private final h f24228y;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public e(List list, j jVar, String str, long j10, a aVar, long j11, String str2, List list2, n nVar, int i10, int i11, int i12, float f10, float f11, float f12, float f13, s0.j jVar2, k kVar, List list3, b bVar, s0.b bVar2, boolean z10, t0.a aVar2, w0.j jVar3, h hVar) {
        this.f24204a = list;
        this.f24205b = jVar;
        this.f24206c = str;
        this.f24207d = j10;
        this.f24208e = aVar;
        this.f24209f = j11;
        this.f24210g = str2;
        this.f24211h = list2;
        this.f24212i = nVar;
        this.f24213j = i10;
        this.f24214k = i11;
        this.f24215l = i12;
        this.f24216m = f10;
        this.f24217n = f11;
        this.f24218o = f12;
        this.f24219p = f13;
        this.f24220q = jVar2;
        this.f24221r = kVar;
        this.f24223t = list3;
        this.f24224u = bVar;
        this.f24222s = bVar2;
        this.f24225v = z10;
        this.f24226w = aVar2;
        this.f24227x = jVar3;
        this.f24228y = hVar;
    }

    public h a() {
        return this.f24228y;
    }

    public t0.a b() {
        return this.f24226w;
    }

    /* access modifiers changed from: package-private */
    public j c() {
        return this.f24205b;
    }

    public w0.j d() {
        return this.f24227x;
    }

    public long e() {
        return this.f24207d;
    }

    /* access modifiers changed from: package-private */
    public List f() {
        return this.f24223t;
    }

    public a g() {
        return this.f24208e;
    }

    /* access modifiers changed from: package-private */
    public List h() {
        return this.f24211h;
    }

    /* access modifiers changed from: package-private */
    public b i() {
        return this.f24224u;
    }

    public String j() {
        return this.f24206c;
    }

    /* access modifiers changed from: package-private */
    public long k() {
        return this.f24209f;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f24219p;
    }

    /* access modifiers changed from: package-private */
    public float m() {
        return this.f24218o;
    }

    public String n() {
        return this.f24210g;
    }

    /* access modifiers changed from: package-private */
    public List o() {
        return this.f24204a;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f24215l;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f24214k;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.f24213j;
    }

    /* access modifiers changed from: package-private */
    public float s() {
        return this.f24217n / this.f24205b.e();
    }

    /* access modifiers changed from: package-private */
    public s0.j t() {
        return this.f24220q;
    }

    public String toString() {
        return z("");
    }

    /* access modifiers changed from: package-private */
    public k u() {
        return this.f24221r;
    }

    /* access modifiers changed from: package-private */
    public s0.b v() {
        return this.f24222s;
    }

    /* access modifiers changed from: package-private */
    public float w() {
        return this.f24216m;
    }

    /* access modifiers changed from: package-private */
    public n x() {
        return this.f24212i;
    }

    public boolean y() {
        return this.f24225v;
    }

    public String z(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(j());
        sb2.append("\n");
        e t10 = this.f24205b.t(k());
        if (t10 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(t10.j());
            e t11 = this.f24205b.t(t10.k());
            while (t11 != null) {
                sb2.append("->");
                sb2.append(t11.j());
                t11 = this.f24205b.t(t11.k());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!h().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(h().size());
            sb2.append("\n");
        }
        if (!(r() == 0 || q() == 0)) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())}));
        }
        if (!this.f24204a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (Object next : this.f24204a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(next);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
