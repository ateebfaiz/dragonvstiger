package t8;

import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.core.n;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.w;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final j f13084a;

    /* renamed from: b  reason: collision with root package name */
    public final n f13085b;

    /* renamed from: c  reason: collision with root package name */
    public final i0 f13086c;

    /* renamed from: d  reason: collision with root package name */
    public final o f13087d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f13088e;

    protected i(j jVar, n nVar, i0 i0Var, o oVar, boolean z10) {
        this.f13084a = jVar;
        this.f13085b = nVar;
        this.f13086c = i0Var;
        this.f13087d = oVar;
        this.f13088e = z10;
    }

    public static i a(j jVar, w wVar, i0 i0Var, boolean z10) {
        String str;
        h hVar = null;
        if (wVar == null) {
            str = null;
        } else {
            str = wVar.c();
        }
        if (str != null) {
            hVar = new h(str);
        }
        return new i(jVar, hVar, i0Var, (o) null, z10);
    }

    public i b(boolean z10) {
        if (z10 == this.f13088e) {
            return this;
        }
        return new i(this.f13084a, this.f13085b, this.f13086c, this.f13087d, z10);
    }

    public i c(o oVar) {
        return new i(this.f13084a, this.f13085b, this.f13086c, oVar, this.f13088e);
    }
}
