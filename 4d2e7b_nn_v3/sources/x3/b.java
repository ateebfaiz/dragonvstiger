package x3;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.Arrays;
import java.util.List;
import w3.p;
import y2.l;

public class b {

    /* renamed from: t  reason: collision with root package name */
    public static final p.b f24721t = p.b.f24589h;

    /* renamed from: u  reason: collision with root package name */
    public static final p.b f24722u = p.b.f24590i;

    /* renamed from: a  reason: collision with root package name */
    private Resources f24723a;

    /* renamed from: b  reason: collision with root package name */
    private int f24724b;

    /* renamed from: c  reason: collision with root package name */
    private float f24725c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f24726d;

    /* renamed from: e  reason: collision with root package name */
    private p.b f24727e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f24728f;

    /* renamed from: g  reason: collision with root package name */
    private p.b f24729g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f24730h;

    /* renamed from: i  reason: collision with root package name */
    private p.b f24731i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f24732j;

    /* renamed from: k  reason: collision with root package name */
    private p.b f24733k;

    /* renamed from: l  reason: collision with root package name */
    private p.b f24734l;

    /* renamed from: m  reason: collision with root package name */
    private Matrix f24735m;

    /* renamed from: n  reason: collision with root package name */
    private PointF f24736n;

    /* renamed from: o  reason: collision with root package name */
    private ColorFilter f24737o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f24738p;

    /* renamed from: q  reason: collision with root package name */
    private List f24739q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f24740r;

    /* renamed from: s  reason: collision with root package name */
    private e f24741s;

    public b(Resources resources) {
        this.f24723a = resources;
        t();
    }

    private void K() {
        List<Drawable> list = this.f24739q;
        if (list != null) {
            for (Drawable g10 : list) {
                l.g(g10);
            }
        }
    }

    private void t() {
        this.f24724b = 300;
        this.f24725c = 0.0f;
        this.f24726d = null;
        p.b bVar = f24721t;
        this.f24727e = bVar;
        this.f24728f = null;
        this.f24729g = bVar;
        this.f24730h = null;
        this.f24731i = bVar;
        this.f24732j = null;
        this.f24733k = bVar;
        this.f24734l = f24722u;
        this.f24735m = null;
        this.f24736n = null;
        this.f24737o = null;
        this.f24738p = null;
        this.f24739q = null;
        this.f24740r = null;
        this.f24741s = null;
    }

    public static b u(Resources resources) {
        return new b(resources);
    }

    public b A(p.b bVar) {
        this.f24731i = bVar;
        return this;
    }

    public b B(Drawable drawable) {
        if (drawable == null) {
            this.f24739q = null;
        } else {
            this.f24739q = Arrays.asList(new Drawable[]{drawable});
        }
        return this;
    }

    public b C(Drawable drawable) {
        this.f24726d = drawable;
        return this;
    }

    public b D(p.b bVar) {
        this.f24727e = bVar;
        return this;
    }

    public b E(Drawable drawable) {
        if (drawable == null) {
            this.f24740r = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.f24740r = stateListDrawable;
        }
        return this;
    }

    public b F(Drawable drawable) {
        this.f24732j = drawable;
        return this;
    }

    public b G(p.b bVar) {
        this.f24733k = bVar;
        return this;
    }

    public b H(Drawable drawable) {
        this.f24728f = drawable;
        return this;
    }

    public b I(p.b bVar) {
        this.f24729g = bVar;
        return this;
    }

    public b J(e eVar) {
        this.f24741s = eVar;
        return this;
    }

    public a a() {
        K();
        return new a(this);
    }

    public ColorFilter b() {
        return this.f24737o;
    }

    public PointF c() {
        return this.f24736n;
    }

    public p.b d() {
        return this.f24734l;
    }

    public Drawable e() {
        return this.f24738p;
    }

    public float f() {
        return this.f24725c;
    }

    public int g() {
        return this.f24724b;
    }

    public Drawable h() {
        return this.f24730h;
    }

    public p.b i() {
        return this.f24731i;
    }

    public List j() {
        return this.f24739q;
    }

    public Drawable k() {
        return this.f24726d;
    }

    public p.b l() {
        return this.f24727e;
    }

    public Drawable m() {
        return this.f24740r;
    }

    public Drawable n() {
        return this.f24732j;
    }

    public p.b o() {
        return this.f24733k;
    }

    public Resources p() {
        return this.f24723a;
    }

    public Drawable q() {
        return this.f24728f;
    }

    public p.b r() {
        return this.f24729g;
    }

    public e s() {
        return this.f24741s;
    }

    public b v(p.b bVar) {
        this.f24734l = bVar;
        this.f24735m = null;
        return this;
    }

    public b w(Drawable drawable) {
        this.f24738p = drawable;
        return this;
    }

    public b x(float f10) {
        this.f24725c = f10;
        return this;
    }

    public b y(int i10) {
        this.f24724b = i10;
        return this;
    }

    public b z(Drawable drawable) {
        this.f24730h = drawable;
        return this;
    }
}
