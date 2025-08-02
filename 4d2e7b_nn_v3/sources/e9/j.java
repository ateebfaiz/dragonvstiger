package e9;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private h f12032a;

    /* renamed from: b  reason: collision with root package name */
    private d f12033b;

    /* renamed from: c  reason: collision with root package name */
    private int f12034c;

    j(Object obj) {
        if (obj instanceof Activity) {
            if (this.f12032a == null) {
                this.f12032a = new h((Activity) obj);
            }
        } else if (obj instanceof Fragment) {
            if (this.f12032a != null) {
                return;
            }
            if (obj instanceof DialogFragment) {
                this.f12032a = new h((DialogFragment) obj);
            } else {
                this.f12032a = new h((Fragment) obj);
            }
        } else if ((obj instanceof android.app.Fragment) && this.f12032a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f12032a = new h((android.app.DialogFragment) obj);
            } else {
                this.f12032a = new h((android.app.Fragment) obj);
            }
        }
    }

    private void a(Configuration configuration) {
        h hVar = this.f12032a;
        if (hVar != null && hVar.G()) {
            this.f12032a.q().getClass();
        }
    }

    public h b() {
        return this.f12032a;
    }

    /* access modifiers changed from: package-private */
    public void c(Configuration configuration) {
        a(configuration);
    }

    /* access modifiers changed from: package-private */
    public void d(Configuration configuration) {
        h hVar = this.f12032a;
        if (hVar != null) {
            hVar.L(configuration);
            a(configuration);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        h hVar = this.f12032a;
        if (hVar != null) {
            hVar.M();
            this.f12032a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        h hVar = this.f12032a;
        if (hVar != null) {
            hVar.N();
        }
    }

    public void run() {
        h hVar = this.f12032a;
        if (hVar != null && hVar.o() != null) {
            Activity o10 = this.f12032a.o();
            a aVar = new a(o10);
            this.f12033b.g(aVar.i());
            this.f12033b.b(aVar.k());
            this.f12033b.c(aVar.d());
            this.f12033b.d(aVar.f());
            this.f12033b.a(aVar.a());
            boolean k10 = n.k(o10);
            this.f12033b.f(k10);
            if (k10 && this.f12034c == 0) {
                int d10 = n.d(o10);
                this.f12034c = d10;
                this.f12033b.e(d10);
            }
            throw null;
        }
    }
}
