package a4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import s3.c;
import w3.s;
import w3.t;
import y2.j;
import y2.l;
import z3.b;

public class a implements t {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13671a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13672b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13673c = true;

    /* renamed from: d  reason: collision with root package name */
    private b f13674d;

    /* renamed from: e  reason: collision with root package name */
    private z3.a f13675e = null;

    /* renamed from: f  reason: collision with root package name */
    private final c f13676f = c.a();

    public a(b bVar) {
        if (bVar != null) {
            p(bVar);
        }
    }

    private void a() {
        if (!this.f13671a) {
            this.f13676f.b(c.a.ON_ATTACH_CONTROLLER);
            this.f13671a = true;
            z3.a aVar = this.f13675e;
            if (aVar != null && aVar.b() != null) {
                this.f13675e.d();
            }
        }
    }

    private void c() {
        if (!this.f13672b || !this.f13673c) {
            e();
        } else {
            a();
        }
    }

    public static a d(b bVar, Context context) {
        a aVar = new a(bVar);
        aVar.m(context);
        return aVar;
    }

    private void e() {
        if (this.f13671a) {
            this.f13676f.b(c.a.ON_DETACH_CONTROLLER);
            this.f13671a = false;
            if (i()) {
                this.f13675e.a();
            }
        }
    }

    private void q(t tVar) {
        Drawable h10 = h();
        if (h10 instanceof s) {
            ((s) h10).n(tVar);
        }
    }

    public void b(boolean z10) {
        c.a aVar;
        if (this.f13673c != z10) {
            c cVar = this.f13676f;
            if (z10) {
                aVar = c.a.ON_DRAWABLE_SHOW;
            } else {
                aVar = c.a.ON_DRAWABLE_HIDE;
            }
            cVar.b(aVar);
            this.f13673c = z10;
            c();
        }
    }

    public z3.a f() {
        return this.f13675e;
    }

    public b g() {
        return (b) l.g(this.f13674d);
    }

    public Drawable h() {
        b bVar = this.f13674d;
        if (bVar == null) {
            return null;
        }
        return bVar.f();
    }

    public boolean i() {
        z3.a aVar = this.f13675e;
        if (aVar == null || aVar.b() != this.f13674d) {
            return false;
        }
        return true;
    }

    public void j() {
        this.f13676f.b(c.a.ON_HOLDER_ATTACH);
        this.f13672b = true;
        c();
    }

    public void k() {
        this.f13676f.b(c.a.ON_HOLDER_DETACH);
        this.f13672b = false;
        c();
    }

    public boolean l(MotionEvent motionEvent) {
        if (!i()) {
            return false;
        }
        return this.f13675e.c(motionEvent);
    }

    public void m(Context context) {
    }

    public void n() {
        o((z3.a) null);
    }

    public void o(z3.a aVar) {
        boolean z10 = this.f13671a;
        if (z10) {
            e();
        }
        if (i()) {
            this.f13676f.b(c.a.ON_CLEAR_OLD_CONTROLLER);
            this.f13675e.e((b) null);
        }
        this.f13675e = aVar;
        if (aVar != null) {
            this.f13676f.b(c.a.ON_SET_CONTROLLER);
            this.f13675e.e(this.f13674d);
        } else {
            this.f13676f.b(c.a.ON_CLEAR_CONTROLLER);
        }
        if (z10) {
            a();
        }
    }

    public void onDraw() {
        if (!this.f13671a) {
            z2.a.E(c.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f13675e)), toString());
            this.f13672b = true;
            this.f13673c = true;
            c();
        }
    }

    public void p(b bVar) {
        boolean z10;
        this.f13676f.b(c.a.ON_SET_HIERARCHY);
        boolean i10 = i();
        q((t) null);
        b bVar2 = (b) l.g(bVar);
        this.f13674d = bVar2;
        Drawable f10 = bVar2.f();
        if (f10 == null || f10.isVisible()) {
            z10 = true;
        } else {
            z10 = false;
        }
        b(z10);
        q(this);
        if (i10) {
            this.f13675e.e(bVar);
        }
    }

    public String toString() {
        return j.c(this).c("controllerAttached", this.f13671a).c("holderAttached", this.f13672b).c("drawableVisible", this.f13673c).b(DbParams.TABLE_EVENTS, this.f13676f.toString()).toString();
    }
}
