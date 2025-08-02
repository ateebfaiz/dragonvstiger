package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class a implements c {
    a() {
    }

    private d p(b bVar) {
        return (d) bVar.d();
    }

    public void a(b bVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        bVar.a(new d(colorStateList, f10));
        View e10 = bVar.e();
        e10.setClipToOutline(true);
        e10.setElevation(f11);
        o(bVar, f12);
    }

    public void b(b bVar, float f10) {
        p(bVar).h(f10);
    }

    public float c(b bVar) {
        return bVar.e().getElevation();
    }

    public float d(b bVar) {
        return p(bVar).d();
    }

    public void e(b bVar) {
        o(bVar, g(bVar));
    }

    public void f(b bVar, float f10) {
        bVar.e().setElevation(f10);
    }

    public float g(b bVar) {
        return p(bVar).c();
    }

    public ColorStateList h(b bVar) {
        return p(bVar).b();
    }

    public void i(b bVar) {
        if (!bVar.c()) {
            bVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float g10 = g(bVar);
        float d10 = d(bVar);
        int ceil = (int) Math.ceil((double) e.a(g10, d10, bVar.b()));
        int ceil2 = (int) Math.ceil((double) e.b(g10, d10, bVar.b()));
        bVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public void j() {
    }

    public float k(b bVar) {
        return d(bVar) * 2.0f;
    }

    public float l(b bVar) {
        return d(bVar) * 2.0f;
    }

    public void m(b bVar) {
        o(bVar, g(bVar));
    }

    public void n(b bVar, ColorStateList colorStateList) {
        p(bVar).f(colorStateList);
    }

    public void o(b bVar, float f10) {
        p(bVar).g(f10, bVar.c(), bVar.b());
        i(bVar);
    }
}
